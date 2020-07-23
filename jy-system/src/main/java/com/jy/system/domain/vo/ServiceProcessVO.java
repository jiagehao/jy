package com.jy.system.domain.vo;

import com.jy.common.core.domain.BaseEntity;

/**
 * Created by 彭嘉颖 on 2019/6/12.
 */
public class ServiceProcessVO extends BaseEntity {
    private String clazzid;//班级ID
    private String subjectid;//学科ID
    private String subjectname;//学科名称
    private String clazzname;//班级名称
    private String clazzSize;//班级人数
    private String empname;//就业老师名称
    private String headmasterName;//班主任名称
    private String category;//C类占比
    private String violationOfDiscipline;//违纪次数
    private String Estimate;//预计毕业时间
    private String isprocess;//是否为过程服务

    public String getIsprocess() {
        return isprocess;
    }

    public void setIsprocess(String isprocess) {
        this.isprocess = isprocess;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getClazzid() {
        return clazzid;
    }

    public void setClazzid(String clazzid) {
        this.clazzid = clazzid;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getClazzname() {
        return clazzname;
    }

    public void setClazzname(String clazzname) {
        this.clazzname = clazzname;
    }

    public String getClazzSize() {
        return clazzSize;
    }

    public void setClazzSize(String clazzSize) {
        this.clazzSize = clazzSize;
    }

    public String getHeadmasterName() {
        return headmasterName;
    }

    public void setHeadmasterName(String headmasterName) {
        this.headmasterName = headmasterName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getViolationOfDiscipline() {
        return violationOfDiscipline;
    }

    public void setViolationOfDiscipline(String violationOfDiscipline) {
        this.violationOfDiscipline = violationOfDiscipline;
    }

    public String getEstimate() {
        return Estimate;
    }

    public void setEstimate(String estimate) {
        Estimate = estimate;
    }
}
