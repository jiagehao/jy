package com.jy.system.domain.vo;

import com.jy.common.core.domain.BaseEntity;

/**
 * Created by 彭嘉颖 on 2019/5/9.
 */
public class BaseClazzVO extends BaseEntity {
    //序号 学科 班级 基础班开班时间 基础班毕业时间 班级人数 流失人数  流失率 倒计时 助教 班主任 讲师  操作

    /** 班级人数*/
    private String classSize;
    /** 学科名称*/
    private String subjectname;
    /** 学科id*/
    private String subjectId;
    /** 班级名称*/
    private String clazzname;
    /** 班级id*/
    private String clazzId;
    /** 开班时间*/
    private String begintime;
    /** 结课时间*/
    private String endtime;
    /** 工作日*/
    private String workday;
    /** 流失人数*/
    private String brand;
    /**流失率*/
    private String rateEmployment;
    /** 班主任*/
    private String headmasterName;
    /** 助教*/
    private String assistantname;
    /** 讲师*/
    private String lecturername;
    /** */
    private String Lossrateone;
    /** */
    private String Lossratetwo;

    public String getClassSize() {
        return classSize;
    }

    public void setClassSize(String classSize) {
        this.classSize = classSize;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getClazzname() {
        return clazzname;
    }

    public void setClazzname(String clazzname) {
        this.clazzname = clazzname;
    }

    public String getClazzId() {
        return clazzId;
    }

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
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

    public String getWorkday() {
        return workday;
    }

    public void setWorkday(String workday) {
        this.workday = workday;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRateEmployment() {
        return rateEmployment;
    }

    public void setRateEmployment(String rateEmployment) {
        this.rateEmployment = rateEmployment;
    }

    public String getHeadmasterName() {
        return headmasterName;
    }

    public void setHeadmasterName(String headmasterName) {
        this.headmasterName = headmasterName;
    }

    public String getAssistantname() {
        return assistantname;
    }

    public void setAssistantname(String assistantname) {
        this.assistantname = assistantname;
    }

    public String getLecturername() {
        return lecturername;
    }

    public void setLecturername(String lecturername) {
        this.lecturername = lecturername;
    }

    public String getLossrateone() {
        return Lossrateone;
    }

    public void setLossrateone(String lossrateone) {
        Lossrateone = lossrateone;
    }

    public String getLossratetwo() {
        return Lossratetwo;
    }

    public void setLossratetwo(String lossratetwo) {
        Lossratetwo = lossratetwo;
    }
}
