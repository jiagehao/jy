package com.jy.system.domain.vo;

import com.jy.common.annotation.Excel;
import com.jy.common.core.domain.BaseEntity;

/**
 * Created by 彭嘉颖 on 2019/4/9.
 */
public class StudentVO extends BaseEntity {
    private String description;//记录信息
    private String stuId;//用户ID
    private String clazzId;//班级ID
    private String clazzname;//班级名
    private String name;//用户名称
    private String sex;//性别
    private String age;//年龄
    private String phonenumber;//手机号码
    private String qQnumber;//QQ号码
    private String graduateschool;//毕业学校
    private String education;;//学历
    private String companyId;//公司ID
    private String companyname;//公司名称
    private String empId;//就业指导ID
    private String empName;//就业指导名称
    private String Salary;//就业薪资
    private String outOfContact;//是否失联
    private String entrytime;//入职时间
    private String Employment;
    private String userName;

    /** 专业 */
    private String major;
    /** 毕业时间 */
    private String graduationTime;
    /**  是否有工作经验（工作类型） */
    private String isWork ;
    /**  广州住址（精确到门牌号） */
    private String addr;
    /** 房东联系方式（住家里的填写家人号码）合租同学填写合租舍友的电话 */
    private String landlordNum;
    /** 学费是否贷款 */
    private String isLoan;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(String graduationTime) {
        this.graduationTime = graduationTime;
    }

    public String getIsWork() {
        return isWork;
    }

    public void setIsWork(String isWork) {
        this.isWork = isWork;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getLandlordNum() {
        return landlordNum;
    }

    public void setLandlordNum(String landlordNum) {
        this.landlordNum = landlordNum;
    }

    public String getIsLoan() {
        return isLoan;
    }

    public void setIsLoan(String isLoan) {
        this.isLoan = isLoan;
    }

    public String getClazzname() {
        return clazzname;
    }

    public void setClazzname(String clazzname) {
        this.clazzname = clazzname;
    }

    public String getqQnumber() {
        return qQnumber;
    }

    public void setqQnumber(String qQnumber) {
        this.qQnumber = qQnumber;
    }

    public String getEmployment() {
        return Employment;
    }

    public void setEmployment(String employment) {
        Employment = employment;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getClazzId() {
        return clazzId;
    }

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGraduateschool() {
        return graduateschool;
    }

    public void setGraduateschool(String graduateschool) {
        this.graduateschool = graduateschool;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getOutOfContact() {
        return outOfContact;
    }

    public void setOutOfContact(String outOfContact) {
        this.outOfContact = outOfContact;
    }

    public String getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(String entrytime) {
        this.entrytime = entrytime;
    }
}
