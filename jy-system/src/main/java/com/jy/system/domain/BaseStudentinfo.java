package com.jy.system.domain;

import com.jy.common.annotation.Excel;
import com.jy.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 学生就业表 tb_base_studentinfo
 * 
 * @author ruoyi
 * @date 2019-04-29
 */
public class BaseStudentinfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 学员ID */
	private String stuId;
	/** 学员名字 */
	@Excel(name = "学员姓名")
	private String name;
	/** 性别 */
	@Excel(name = "性别")
	private String sex;
	/** 年龄 */
	@Excel(name = "年龄")
	private Integer age;
	/** 电话号码 */
	@Excel(name = "手机号")
	private String phonenumber;
	/** QQ */
	@Excel(name = "QQ")
	private String qQnumber;
	/** 毕业学校 */
	@Excel(name = "毕业学校")
	private String graduateschool;
	/** 学历 */
	@Excel(name = "学历")
	private String education;
	/** 是否删除 */
	private Integer isdelete;
	/** 公司id */
	private String companyId;
	/** 公司名称 */
	private String companyname;
	/** 就业指导ID */
	private String empId;
	/**  */
	private String empname;
	/** 是否有效 */
	private Integer isvalid;
	/** 工作日 */
	private String entrytime;
	/** 薪资 */
	private String salary;
	/** 未就业人数 0未就业  1就业 */
	private Integer employment;
	/** 是否失联 0否 1是 默认0 */
	private Integer outOfContact;
	/** 备注 */
	private String remarkshr;
	/** 入职时间 */
	private String workexperience;
	/**  */
	private String campusId;
	/** 身份证号码 */
	@Excel(name = "身份证号码")
	private String idnumber;
	/** 重点关注 */
	private String stressfollow;
	/** 身份证地址 */
	@Excel(name = "身份证地址")
	private String idnumberAddress;

	private String category;//'0，A类。1，B类。2，C类。3，D类'
	private String violationOfDiscipline;//'违纪次数'
	private String major;//'专业'

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

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	private String clazz;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getqQnumber() {
		return qQnumber;
	}

	public void setqQnumber(String qQnumber) {
		this.qQnumber = qQnumber;
	}


	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public void setStuId(String stuId)
	{
		this.stuId = stuId;
	}

	public String getStuId() 
	{
		return stuId;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setSex(String sex) 
	{
		this.sex = sex;
	}

	public String getSex() 
	{
		return sex;
	}
	public void setAge(Integer age) 
	{
		this.age = age;
	}

	public Integer getAge() 
	{
		return age;
	}
	public void setPhonenumber(String phonenumber) 
	{
		this.phonenumber = phonenumber;
	}

	public String getPhonenumber() 
	{
		return phonenumber;
	}

	public void setGraduateschool(String graduateschool) 
	{
		this.graduateschool = graduateschool;
	}

	public String getGraduateschool() 
	{
		return graduateschool;
	}
	public void setEducation(String education) 
	{
		this.education = education;
	}

	public String getEducation() 
	{
		return education;
	}
	public void setIsdelete(Integer isdelete) 
	{
		this.isdelete = isdelete;
	}

	public Integer getIsdelete() 
	{
		return isdelete;
	}
	public void setCompanyId(String companyId) 
	{
		this.companyId = companyId;
	}

	public String getCompanyId() 
	{
		return companyId;
	}
	public void setCompanyname(String companyname) 
	{
		this.companyname = companyname;
	}

	public String getCompanyname() 
	{
		return companyname;
	}
	public void setEmpId(String empId) 
	{
		this.empId = empId;
	}

	public String getEmpId() 
	{
		return empId;
	}
	public void setEmpname(String empname) 
	{
		this.empname = empname;
	}

	public String getEmpname() 
	{
		return empname;
	}
	public void setIsvalid(Integer isvalid) 
	{
		this.isvalid = isvalid;
	}

	public Integer getIsvalid() 
	{
		return isvalid;
	}
	public void setEntrytime(String entrytime) 
	{
		this.entrytime = entrytime;
	}

	public String getEntrytime() 
	{
		return entrytime;
	}
	public void setSalary(String salary) 
	{
		this.salary = salary;
	}

	public String getSalary() 
	{
		return salary;
	}
	public void setEmployment(Integer employment) 
	{
		this.employment = employment;
	}

	public Integer getEmployment() 
	{
		return employment;
	}
	public void setOutOfContact(Integer outOfContact) 
	{
		this.outOfContact = outOfContact;
	}

	public Integer getOutOfContact() 
	{
		return outOfContact;
	}
	public void setRemarkshr(String remarkshr) 
	{
		this.remarkshr = remarkshr;
	}

	public String getRemarkshr() 
	{
		return remarkshr;
	}
	public void setWorkexperience(String workexperience) 
	{
		this.workexperience = workexperience;
	}

	public String getWorkexperience() 
	{
		return workexperience;
	}
	public void setCampusId(String campusId) 
	{
		this.campusId = campusId;
	}

	public String getCampusId() 
	{
		return campusId;
	}
	public void setIdnumber(String idnumber) 
	{
		this.idnumber = idnumber;
	}

	public String getIdnumber() 
	{
		return idnumber;
	}
	public void setStressfollow(String stressfollow) 
	{
		this.stressfollow = stressfollow;
	}

	public String getStressfollow() 
	{
		return stressfollow;
	}
	public void setIdnumberAddress(String idnumberAddress) 
	{
		this.idnumberAddress = idnumberAddress;
	}

	public String getIdnumberAddress() 
	{
		return idnumberAddress;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stuId", getStuId())
            .append("name", getName())
            .append("sex", getSex())
            .append("age", getAge())
            .append("phonenumber", getPhonenumber())
            .append("graduateschool", getGraduateschool())
            .append("education", getEducation())
            .append("isdelete", getIsdelete())
            .append("companyId", getCompanyId())
            .append("companyname", getCompanyname())
            .append("empId", getEmpId())
            .append("empname", getEmpname())
            .append("isvalid", getIsvalid())
            .append("entrytime", getEntrytime())
            .append("salary", getSalary())
            .append("employment", getEmployment())
            .append("outOfContact", getOutOfContact())
            .append("remarkshr", getRemarkshr())
            .append("workexperience", getWorkexperience())
            .append("campusId", getCampusId())
            .append("idnumber", getIdnumber())
            .append("stressfollow", getStressfollow())
            .append("idnumberAddress", getIdnumberAddress())
            .toString();
    }
}
