package com.jy.system.domain.vo;

import com.jy.common.annotation.Excel;

/**
 * Created by 彭嘉颖 on 2019/4/23.
 */

public class StuGroupVO {
    @Excel(name = "学员名称", type = Excel.Type.ALL)
    private String stuName;
    @Excel(name = "就业指导名称", type = Excel.Type.ALL)
    private String empName;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
