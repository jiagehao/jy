package com.jy.system.domain.vo;

import com.jy.common.core.domain.BaseEntity;

/**
 * Created by 彭嘉颖 on 2019/5/9.
 */
public class BaseStudentInfoVO extends BaseEntity {
    /** 学员ID */
    private String stuid;
    /** 班级id*/
    private String clazzid;
    /** 学员名字 */
    private String name;
    /** 性别 */
    private String sex;
    /** 年龄 */
    private Integer age;
    /** 专业 */
    private String education;
    /** 类型 */
    private String category;
    /**  */
    private String one;
    /**  */
    private String two;
    /**  */
    private String three;
    /**  */
    private String four;
    /**  */
    private String five;
    /**  */
    private String six;
    /**  */
    private String seven;
    /**  */
    private String eight;
    /**  */
    private String nine;
    /**  */
    private String ten;
    /**  */
    private String eleven;
    /**  */
    private String twelve;
    /**  */
    private String thirteen;
    /**  */
    private String fourteen;
    /**  */
    private String fifteen;
    /** 创建时间 */
    private String createtime;
    /** 信息记录 */
    private String description;
    /** 最终成绩*/
    private String total;
    /** 小数点*/
    private int num;

    /** 基础成绩id*/
    private String id;
    /** 基础班级天数*/
    private int subjectday;
    //学科ID
    private String subjectId;


    //是否流失
    private String outOfContact;
    //是否重点关注
    private String stressfollow;

    //留级或者流失记录
    private String remarkshr;

    //升级成绩
    private String workexperience;

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getWorkexperience() {
        return workexperience;
    }

    public void setWorkexperience(String workexperience) {
        this.workexperience = workexperience;
    }

    public int getSubjectday() {
        return subjectday;
    }

    public void setSubjectday(int subjectday) {
        this.subjectday = subjectday;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

    public String getFour() {
        return four;
    }

    public void setFour(String four) {
        this.four = four;
    }

    public String getFive() {
        return five;
    }

    public void setFive(String five) {
        this.five = five;
    }

    public String getSix() {
        return six;
    }

    public void setSix(String six) {
        this.six = six;
    }

    public String getSeven() {
        return seven;
    }

    public void setSeven(String seven) {
        this.seven = seven;
    }

    public String getEight() {
        return eight;
    }

    public void setEight(String eight) {
        this.eight = eight;
    }

    public String getNine() {
        return nine;
    }

    public void setNine(String nine) {
        this.nine = nine;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEleven() {
        return eleven;
    }

    public void setEleven(String eleven) {
        this.eleven = eleven;
    }

    public String getTwelve() {
        return twelve;
    }

    public void setTwelve(String twelve) {
        this.twelve = twelve;
    }

    public String getThirteen() {
        return thirteen;
    }

    public void setThirteen(String thirteen) {
        this.thirteen = thirteen;
    }

    public String getFourteen() {
        return fourteen;
    }

    public void setFourteen(String fourteen) {
        this.fourteen = fourteen;
    }

    public String getFifteen() {
        return fifteen;
    }

    public void setFifteen(String fifteen) {
        this.fifteen = fifteen;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getClazzid() {
        return clazzid;
    }

    public void setClazzid(String clazzid) {
        this.clazzid = clazzid;
    }


    public String getOutOfContact() {
        return outOfContact;
    }

    public void setOutOfContact(String outOfContact) {
        this.outOfContact = outOfContact;
    }

    public String getStressfollow() {
        return stressfollow;
    }

    public void setStressfollow(String stressfollow) {
        this.stressfollow = stressfollow;
    }

    public String getRemarkshr() {
        return remarkshr;
    }

    public void setRemarkshr(String remarkshr) {
        this.remarkshr = remarkshr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
