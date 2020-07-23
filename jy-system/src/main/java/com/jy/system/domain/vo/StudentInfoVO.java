package com.jy.system.domain.vo;

import com.jy.common.annotation.Excel;
import com.jy.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 学员表 tb_studentinfo
 * 
 * @author jy
 * @date 2019-04-08
 */
public class StudentInfoVO extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 学员ID */
	private String stuId;
	/** 学员名字 */
	@Excel(name = "姓名")
	private String name;
	/** 性别 */
	@Excel(name = "性别")
	private String sex;
	/** 年龄 */
	@Excel(name = "年龄")
	private Integer age;
	/** 电话号码 */
	@Excel(name = "联系电话")
	private String phonenumber;
	/** QQ */
	@Excel(name = "QQ")
	private String qQnumber;
	/** 学历 */
	@Excel(name = "学历")
	private String education;
	/** 毕业学校 */
	@Excel(name = "毕业院校")
	private String graduateschool;
	/** 就业指导ID */
	@Excel(name = "学员入学时间")
	private String empId;
	/** 公司id */
	@Excel(name = "最后就读班级")
	private String companyId;
	/** 公司名称 */
	@Excel(name = "就业单位")
	private String companyname;

	/** 薪资 */
	@Excel(name = "就业薪资")
	private String salary;
	/** 就业指导名称 */
	private String userName;

	/** 班级ID */
	@Excel(name = "福利待遇")
	private String clazzId;

	/**  */
	@Excel(name = "就业城市")
	private String on;

	/** 入职时间 */
	@Excel(name = "入职时间")
	private String entrytime;
	/** 就业指导ID */
	private Long userId;
	/** 未就业人数 0未就业  1就业 */
	private Integer employment;
	/** 是否失联 0否 1是 默认0 */
	private Integer outOfContact;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getqQnumber() {
		return qQnumber;
	}

	public void setqQnumber(String qQnumber) {
		this.qQnumber = qQnumber;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getGraduateschool() {
		return graduateschool;
	}

	public void setGraduateschool(String graduateschool) {
		this.graduateschool = graduateschool;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
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

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClazzId() {
		return clazzId;
	}

	public void setClazzId(String clazzId) {
		this.clazzId = clazzId;
	}

	public String getOn() {
		return on;
	}

	public void setOn(String on) {
		this.on = on;
	}

	public String getEntrytime() {
		return entrytime;
	}

	public void setEntrytime(String entrytime) {
		this.entrytime = entrytime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getEmployment() {
		return employment;
	}

	public void setEmployment(Integer employment) {
		this.employment = employment;
	}

	public Integer getOutOfContact() {
		return outOfContact;
	}

	public void setOutOfContact(Integer outOfContact) {
		this.outOfContact = outOfContact;
	}
}
