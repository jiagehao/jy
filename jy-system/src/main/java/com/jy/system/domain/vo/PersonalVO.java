package com.jy.system.domain.vo;

import com.jy.common.core.domain.BaseEntity;

/**
 * Created by 彭嘉颖 on 2019/4/13.
 */
public class PersonalVO extends BaseEntity {
    private String empname;
    private String total;
    private String salary;
    private String counts;

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
