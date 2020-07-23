package com.jy.web.controller.WorkDayUtil; /**
 * Created by 彭嘉颖 on 2018/6/24.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class InsertHolidayUtil {
    public static void main(String[] args){
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //要插入的数据库，表
        String url = "jdbc:mysql://127.0.0.1:3306/itcast_jy?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true";
        String user = "root";
        String password = "root";
        try {
            //加载驱动程序
            Class.forName(driver);
            //连续MySQL 数据库
            Connection conn = DriverManager.getConnection(url, user, password);
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //statement用来执行SQL语句
            Statement statement = conn.createStatement();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date start = sdf.parse("2020-01-01");//开始时间
            Date end = sdf.parse("2020-12-31");//结束时间
            List<Date> lists = dateSplit(start, end);

            //-------------------插入周末时间---------------
            if (!lists.isEmpty()) {
                for (Date date : lists) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(date);
                    if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
                    {
                        System.out.println("插入日期:" + sdf.format(date) + ",周末");
                        String insertSql = "INSERT INTO tb_workday (id,title,holiday_date) VALUES('"+UUID.randomUUID()+"',"+"'周末','"+sdf.format(date)+"')";
                        statement.executeUpdate(insertSql);
                    }
                }
            }
            //---------------插入节假日时间------------------
            List<Days> holidays = new ArrayList<Days>();
            holidays.add(new Days(UUID.randomUUID().toString(),"元旦", sdf.parse("2020-01-01")));

            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-01-18")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-01-19")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-01-20")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-01-21")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-01-22")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-01-23")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-01-24")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-01-25")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-01-26")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-01-27")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-01-28")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-01-29")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-01-30")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-01-31")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-01")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-02")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-03")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-04")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-05")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-06")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-07")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-08")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-09")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-10")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-11")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-12")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-13")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-14")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-15")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-16")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-17")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-18")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-19")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-20")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-21")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-22")));
            holidays.add(new Days(UUID.randomUUID().toString(),"春节", sdf.parse("2020-02-23")));

            holidays.add(new Days(UUID.randomUUID().toString(),"清明节", sdf.parse("2020-04-04")));
            holidays.add(new Days(UUID.randomUUID().toString(),"清明节", sdf.parse("2020-04-05")));
            holidays.add(new Days(UUID.randomUUID().toString(),"清明节", sdf.parse("2020-04-06")));

            holidays.add(new Days(UUID.randomUUID().toString(),"劳动节", sdf.parse("2020-05-01")));
            holidays.add(new Days(UUID.randomUUID().toString(),"劳动节", sdf.parse("2020-05-02")));
            holidays.add(new Days(UUID.randomUUID().toString(),"劳动节", sdf.parse("2020-05-03")));
            holidays.add(new Days(UUID.randomUUID().toString(),"劳动节", sdf.parse("2020-05-04")));
            holidays.add(new Days(UUID.randomUUID().toString(),"劳动节", sdf.parse("2020-05-05")));

            holidays.add(new Days(UUID.randomUUID().toString(),"端午节", sdf.parse("2020-06-25")));
            holidays.add(new Days(UUID.randomUUID().toString(),"端午节", sdf.parse("2020-06-26")));
            holidays.add(new Days(UUID.randomUUID().toString(),"端午节", sdf.parse("2020-06-27")));
//
//            holidays.add(new Days(UUID.randomUUID().toString(),"中秋节", sdf.parse("2020-09-13")));
//            holidays.add(new Days(UUID.randomUUID().toString(),"中秋节", sdf.parse("2020-09-14")));
//            holidays.add(new Days(UUID.randomUUID().toString(),"中秋节", sdf.parse("2020-09-15")));

            holidays.add(new Days(UUID.randomUUID().toString(),"国庆节", sdf.parse("2020-10-01")));
            holidays.add(new Days(UUID.randomUUID().toString(),"国庆节", sdf.parse("2020-10-02")));
            holidays.add(new Days(UUID.randomUUID().toString(),"国庆节", sdf.parse("2020-10-03")));
            holidays.add(new Days(UUID.randomUUID().toString(),"国庆节", sdf.parse("2020-10-04")));
            holidays.add(new Days(UUID.randomUUID().toString(),"国庆节", sdf.parse("2020-10-05")));
            holidays.add(new Days(UUID.randomUUID().toString(),"国庆节", sdf.parse("2020-10-06")));
            holidays.add(new Days(UUID.randomUUID().toString(),"国庆节", sdf.parse("2020-10-07")));
            holidays.add(new Days(UUID.randomUUID().toString(),"国庆节", sdf.parse("2020-10-08")));

            for(Days day:holidays) {
                //跟周末冲突的，不重复插入
                String sql = "select count(1) as numbers from tb_workday where holiday_date ='" + sdf.format(day.getDate()) + "'";
                //结果集
                ResultSet rs = statement.executeQuery(sql);
                boolean hasRecord = false;
                while(rs.next()) {
                    if(!"0".equals(rs.getString("numbers"))) {
                        hasRecord = true;
                    }
                }
                if(!hasRecord) {
                    System.out.println("插入日期：" + sdf.format(day.getDate()) + "," + day.getName());
                    String insertSql = "INSERT INTO tb_workday (id,title,holiday_date) VALUES('"+day.getUuid()+"',"+"'"+day.getName()+"','"+sdf.format(day.getDate())+"')";
                    statement.executeUpdate(insertSql);
                }
            }


            //-------------- 剔除补班时间(周末需要补班的)---------------------
            List<Days> workDays = new ArrayList<Days>();

            workDays.add(new Days(UUID.randomUUID().toString(),"补班", sdf.parse("2020-04-26")));
            workDays.add(new Days(UUID.randomUUID().toString(),"补班", sdf.parse("2020-05-09")));
            workDays.add(new Days(UUID.randomUUID().toString(),"补班", sdf.parse("2020-06-28")));
            workDays.add(new Days(UUID.randomUUID().toString(),"补班", sdf.parse("2020-09-27")));
            workDays.add(new Days(UUID.randomUUID().toString(),"补班", sdf.parse("2020-10-10")));

            for(Days day:workDays) {
                System.out.println("剔除日期：" + sdf.format(day.getDate()) + "," + day.getName());
                String delSql = "delete from tb_workday where holiday_date ='" + sdf.format(day.getDate()) + "'";
                statement.executeUpdate(delSql);
            }
            conn.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("Sorry,can't find the Driver!");
            e.printStackTrace();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Date> dateSplit(Date start, Date end)
            throws Exception {
        if (!start.before(end))
            throw new Exception("开始时间应该在结束时间之后");
        Long spi = end.getTime() - start.getTime();
        Long step = spi / (24 * 60 * 60 * 1000);// 相隔天数


        List<Date> dateList = new ArrayList<Date>();
        dateList.add(end);
        for (int i = 1; i <= step; i++) {
            dateList.add(new Date(dateList.get(i - 1).getTime()
                    - (24 * 60 * 60 * 1000)));// 比上一天减一
        }
        return dateList;
    }


}


