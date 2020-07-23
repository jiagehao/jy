package com.jy.system.domain.vo;

import com.jy.common.core.domain.BaseEntity;

/**
 * Created by 彭嘉颖 on 2019/6/13.
 */
public class ServerProcessStuVO extends BaseEntity {
    private String stuid;//学员ID
    private String name;//学员名称
    private String sex;//性别
    private String education;//学历
    private String category;//评价
    private String empname;//就业老师名称
    private String description;//备注
    private String violationOfDiscipline;//违纪

    public String getViolationOfDiscipline() {
        return violationOfDiscipline;
    }

    public void setViolationOfDiscipline(String violationOfDiscipline) {
        this.violationOfDiscipline = violationOfDiscipline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }
}
