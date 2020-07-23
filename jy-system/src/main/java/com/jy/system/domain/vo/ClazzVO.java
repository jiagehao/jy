package com.jy.system.domain.vo;

import com.jy.common.core.domain.BaseEntity;

/**
 * Created by 彭嘉颖 on 2019/4/9.
 */
public class ClazzVO extends BaseEntity {
    private String clazzId;//班级ID
    private String workday;//工作日
    private int classSize;//班级人数
    private String rateEmployment;//就业率
    private int salary;//就业薪资
    private int employment;//未就业人数
    private String subjectId;//学科ID
    private String subjectname;//学科名称
    private String begintime;//开班时间
    private String endtime;//结课时间
    private String clazzname;//班级期数
    private String workdaytime;//当前日
    private String headmasterName;//班主任姓名
    private String empId;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getHeadmasterName() {
        return headmasterName;
    }

    public void setHeadmasterName(String headmasterName) {
        this.headmasterName = headmasterName;
    }

    public String getClazzId() {
        return clazzId;
    }

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
    }

    public String getWorkday() {
        return workday;
    }

    public void setWorkday(String workday) {
        this.workday = workday;
    }

    public int getClassSize() {
        return classSize;
    }

    public void setClassSize(int classSize) {
        this.classSize = classSize;
    }

    public String getRateEmployment() {
        return rateEmployment;
    }

    public void setRateEmployment(String rateEmployment) {
        this.rateEmployment = rateEmployment;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getEmployment() {
        return employment;
    }

    public void setEmployment(int employment) {
        this.employment = employment;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getClazzname() {
        return clazzname;
    }

    public void setClazzname(String clazzname) {
        this.clazzname = clazzname;
    }

    public String getWorkdaytime() {
        return workdaytime;
    }

    public void setWorkdaytime(String workdaytime) {
        this.workdaytime = workdaytime;
    }
}

