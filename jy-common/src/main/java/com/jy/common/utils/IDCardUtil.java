package com.jy.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 使用方法:调用 IDCardUtil.IDCardValidate(str)验证是否为合法的身份证.返回的是一个String,
 * "1"
 * 代表合法的身份证 ,其他值代表错误信息
 * @author shen
 *
 */
public class IDCardUtil {

    /**
     * 验证身份证
     *
     * @param IDStr
     * @return "1" 代表合法的身份证 ,其他值代表错误信息
     * @throws ParseException
     */
    public static String IDCardValidate(String IDStr) {
        String tipInfo = "1";// 记录错误信息
        String Ai = "";

        if (null == IDStr || IDStr.trim().isEmpty())
            return "身份证号码长度应该为15位或18位。";

// 判断号码的长度 15位或18位 
        if (IDStr.length() != 15 && IDStr.length() != 18) {
            tipInfo = "身份证号码长度应该为15位或18位。";
            return tipInfo;
        }
// 18位身份证前17位位数字，如果是15位的身份证则所有号码都为数字 
        if (IDStr.length() == 18) {
            Ai = IDStr.substring(0, 17);
        } else if (IDStr.length() == 15) {
            Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
        }
        if (isNumeric(Ai) == false) {
            tipInfo = "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";
            return tipInfo;
        }
// 判断出生年月是否有效 
        String strYear = Ai.substring(6, 10);// 年份
        String strMonth = Ai.substring(10, 12);// 月份
        String strDay = Ai.substring(12, 14);// 日期
        if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {
            tipInfo = "身份证出生日期无效。";
            return tipInfo;
        }
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
                    || (gc.getTime().getTime() - s.parse(strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
                tipInfo = "身份证生日不在有效范围。";
                return tipInfo;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
            tipInfo = "身份证月份无效";
            return tipInfo;
        }
        if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
            tipInfo = "身份证日期无效";
            return tipInfo;
        }
// 判断地区码是否有效 
        Hashtable areacode = GetAreaCode();
// 如果身份证前两位的地区码不在Hashtable，则地区码有误 
        if (areacode.get(Ai.substring(0, 2)) == null) {
            tipInfo = "身份证地区编码错误。";
            return tipInfo;
        }
//判断第18位校验码是否正确
        if (isVarifyCode(Ai, IDStr) == false) {
            tipInfo = "身份证校验码无效，不是合法的身份证号码";
            return tipInfo;
        }
        return tipInfo;
    }

    /*
     * 判断第18位校验码是否正确 第18位校验码的计算方式： 1. 对前17位数字本体码加权求和 公式为：S = Sum(Ai * Wi), i =
     * 0, ... , 16 其中Ai表示第i个位置上的身份证号码数字值，Wi表示第i位置上的加权因子，其各位对应的值依次为： 7 9 10 5 8 4
     * 2 1 6 3 7 9 10 5 8 4 2 2. 用11对计算结果取模 Y = mod(S, 11) 3. 根据模的值得到对应的校验码
     * 对应关系为： Y值： 0 1 2 3 4 5 6 7 8 9 10 校验码： 1 0 X 9 8 7 6 5 4 3 2
     */
    private static boolean isVarifyCode(String Ai, String IDStr) {
        String[] VarifyCode = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
        String[] Wi = {"7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2"};
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            sum = sum + Integer.parseInt(String.valueOf(Ai.charAt(i))) * Integer.parseInt(Wi[i]);
        }
        int modValue = sum % 11;
        String strVerifyCode = VarifyCode[modValue];
        Ai = Ai + strVerifyCode;
        if (IDStr.length() == 18) {
            if (Ai.equals(IDStr) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将所有地址编码保存在一个Hashtable中
     *
     * @return Hashtable 对象
     */
    private static Hashtable GetAreaCode() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("11", "北京");
        hashtable.put("12", "天津");
        hashtable.put("13", "河北");
        hashtable.put("14", "山西");
        hashtable.put("15", "内蒙古");
        hashtable.put("21", "辽宁");
        hashtable.put("22", "吉林");
        hashtable.put("23", "黑龙江");
        hashtable.put("31", "上海");
        hashtable.put("32", "江苏");
        hashtable.put("33", "浙江");
        hashtable.put("34", "安徽");
        hashtable.put("35", "福建");
        hashtable.put("36", "江西");
        hashtable.put("37", "山东");
        hashtable.put("41", "河南");
        hashtable.put("42", "湖北");
        hashtable.put("43", "湖南");
        hashtable.put("44", "广东");
        hashtable.put("45", "广西");
        hashtable.put("46", "海南");
        hashtable.put("50", "重庆");
        hashtable.put("51", "四川");
        hashtable.put("52", "贵州");
        hashtable.put("53", "云南");
        hashtable.put("54", "西藏");
        hashtable.put("61", "陕西");
        hashtable.put("62", "甘肃");
        hashtable.put("63", "青海");
        hashtable.put("64", "宁夏");
        hashtable.put("65", "新疆");
        hashtable.put("71", "台湾");
        hashtable.put("81", "香港");
        hashtable.put("82", "澳门");
        hashtable.put("91", "国外");
        return hashtable;
    }


    /**
     * 判断字符串是否为数字,0-9重复0次或者多次
     *
     * @param strnum
     * @return
     */
    private static boolean isNumeric(String strnum) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(strnum);
        if (isNum.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 功能：判断字符串出生日期是否符合正则表达式：包括年月日，闰年、平年和每月31天、30天和闰月的28天或者29天
     *
     * @param strDate
     * @return
     */
    public static boolean isDate(String strDate) {
        Pattern pattern = Pattern.compile(
                "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))?$");
        Matcher m = pattern.matcher(strDate);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 通过身份证号码获取出生日期、性别、年龄
     *
     * @param certificateNo
     * @return 返回的出生日期格式：1990-01-01   性别格式：F-女，M-男
     */
    public static Map<String, String> getBirAgeSex(String certificateNo) {
        String birthday = "";
        String age = "";
        String sexCode = "";

        int year = Calendar.getInstance().get(Calendar.YEAR);
        char[] number = certificateNo.toCharArray();
        boolean flag = true;
        if (number.length == 15) {
            for (int x = 0; x < number.length; x++) {
                if (!flag) return new HashMap<String, String>();
                flag = Character.isDigit(number[x]);
            }
        } else if (number.length == 18) {
            for (int x = 0; x < number.length - 1; x++) {
                if (!flag) return new HashMap<String, String>();
                flag = Character.isDigit(number[x]);
            }
        }
        if (flag && certificateNo.length() == 15) {
            birthday = "19" + certificateNo.substring(6, 8) + "-"
                    + certificateNo.substring(8, 10) + "-"
                    + certificateNo.substring(10, 12);
            sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 3, certificateNo.length())) % 2 == 0 ? "女" : "男";
            age = (year - Integer.parseInt("19" + certificateNo.substring(6, 8))) + "";
        } else if (flag && certificateNo.length() == 18) {
            birthday = certificateNo.substring(6, 10) + "-"
                    + certificateNo.substring(10, 12) + "-"
                    + certificateNo.substring(12, 14);
            sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 4, certificateNo.length() - 1)) % 2 == 0 ? "女" : "男";
            age = (year - Integer.parseInt(certificateNo.substring(6, 10))) + "";
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("birthday", birthday);
        map.put("age", age);
        map.put("sexCode", sexCode);
        return map;
    }

    /**
     * 判断字符串是否全部为中文字符组成
     * @param str	检测的文字
     * @return	true：为中文字符串，false:含有非中文字符
     */
    public static boolean isChineseStr(String str){
        Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
        char c[] = str.toCharArray();
        if (str.length()>5||str.length()<2){
            return false;
        }
        for(int i=0;i<c.length;i++){
            Matcher matcher = pattern.matcher(String.valueOf(c[i]));
            if(!matcher.matches()){
                return false;
            }
        }
        return true;
    }




        /**
         * 将18位身份证号转化为15位返回,非18位身份证号原值返回
         * @param identityCard 18位身份证号
         * @return 15身份证
         */
        public static String get15Ic(String identityCard) {
            String retId = "";
            if(null == identityCard){
                return retId;
            }
            if(identityCard.length() == 18){
                retId = identityCard.substring(0, 6) + identityCard.substring(8, 17);
            }else{
                return identityCard;
            }
            return retId;
        }

        /**
         * 将15位身份证号转化为18位返回，非15位身份证号原值返回
         * @param identityCard
         * @return
         */
        public static String get18Ic(String identityCard) {
            String retId = "";
            String id17 = "";
            int sum = 0;
            int y = 0;
            // 定义数组存放加权因子（weight factor）
            int[] wf = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
            // 定义数组存放校验码（check code）
            String[] cc = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
            if (identityCard.length() != 15) {
                return identityCard;
            }
            // 加上两位年19
            id17 = identityCard.substring(0, 6) + "19" + identityCard.substring(6);
            // 十七位数字本体码加权求和
            for (int i = 0; i < 17; i++) {
                sum = sum + Integer.valueOf(id17.substring(i, i + 1)) * wf[i];
            }
            // 计算模
            y = sum % 11;
            // 通过模得到对应的校验码 cc[y]
            retId = id17 + cc[y];
            return retId;
        }

    public static void main(String[] args) {
        String idCardValidate = IDCardValidate("422625600710053");

        String ic = get15Ic("422625196007100531");

        boolean equals = idCardValidate.equals("1");
        String s = IDCardValidate(ic);
        System.out.println(s);


    }


}