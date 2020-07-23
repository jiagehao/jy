package com.jy.system.domain;

import com.jy.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jy.common.core.domain.BaseEntity;

/**
 * 学员表 tb_studentinfo
 * 
 * @author jy
 * @date 2019-04-08
 */
public class TbStudentinfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 学员ID */
	private String stuId;
	/** 序号 */
	@Excel(name = "序号")
	private String num;
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
	/** 邮箱 */
	@Excel(name = "邮箱")
	private String email;
	/** 学历 */
	@Excel(name = "学历")
	private String education;
	/** 毕业学校 */
	@Excel(name = "毕业院校")
	private String graduateschool;
	/** 专业 */
	@Excel(name = "专业")
	private String major;
	/** 毕业时间 */
	@Excel(name = "毕业时间")
	private String graduationTime;
	/**  是否有工作经验（工作类型） */
	@Excel(name = "是否有工作经验（工作类型）")
	private String isWork ;
	/**  广州住址（精确到门牌号） */
	@Excel(name = "广州住址（精确到门牌号）")
	private String addr;
	/** 房东联系方式（住家里的填写家人号码）合租同学填写合租舍友的电话 */
	@Excel(name = "房东联系方式（住家里的填写家人号码）合租同学填写合租舍友的电话")
	private String landlordNum;
	/** 学费是否贷款 */
	@Excel(name = "学费是否贷款")
	private String isLoan;
	/** 公司id */
	private String companyId;
	/** 公司名称 */
	private String companyname;
	/** 就业指导ID */
	private String empId;
	/** 薪资 */
	private String salary;
	/** 未就业人数 0未就业  1就业 */
	private Integer employment;
	/** 是否失联 0否 1是 默认0 */
	private Integer outOfContact;
	/** 入职时间 */
	private String entrytime;
	/** 班级ID */
	private String clazzId;
	/** 就业指导ID */
	private Long userId;
	/** 就业指导名称 */
	private String userName;
	/** 班级名称 */
	private String clazzname;
	/** 学科名称 */
	private String subjectname;
	/** 入职年限 */
	private String entrytyears;

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
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

	public String getEntrytime() {
		return entrytime;
	}

	public void setEntrytime(String entrytime) {
		this.entrytime = entrytime;
	}

	public String getClazzId() {
		return clazzId;
	}

	public void setClazzId(String clazzId) {
		this.clazzId = clazzId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClazzname() {
		return clazzname;
	}

	public void setClazzname(String clazzname) {
		this.clazzname = clazzname;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getEntrytyears() {
		return entrytyears;
	}

	public void setEntrytyears(String entrytyears) {
		this.entrytyears = entrytyears;
	}

	@Override
	public String toString() {
		return "TbStudentinfo{" +
				"stuId='" + stuId + '\'' +
				", num='" + num + '\'' +
				", name='" + name + '\'' +
				", sex='" + sex + '\'' +
				", age=" + age +
				", phonenumber='" + phonenumber + '\'' +
				", qQnumber='" + qQnumber + '\'' +
				", email='" + email + '\'' +
				", education='" + education + '\'' +
				", graduateschool='" + graduateschool + '\'' +
				", major='" + major + '\'' +
				", graduationTime='" + graduationTime + '\'' +
				", isWork='" + isWork + '\'' +
				", addr='" + addr + '\'' +
				", landlordNum='" + landlordNum + '\'' +
				", isLoan='" + isLoan + '\'' +
				", companyId='" + companyId + '\'' +
				", companyname='" + companyname + '\'' +
				", empId='" + empId + '\'' +
				", salary='" + salary + '\'' +
				", employment=" + employment +
				", outOfContact=" + outOfContact +
				", entrytime='" + entrytime + '\'' +
				", clazzId='" + clazzId + '\'' +
				", userId=" + userId +
				", userName='" + userName + '\'' +
				", clazzname='" + clazzname + '\'' +
				", subjectname='" + subjectname + '\'' +
				", entrytyears='" + entrytyears + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TbStudentinfo)) return false;

		TbStudentinfo that = (TbStudentinfo) o;

		if (getStuId() != null ? !getStuId().equals(that.getStuId()) : that.getStuId() != null) return false;
		if (getNum() != null ? !getNum().equals(that.getNum()) : that.getNum() != null) return false;
		if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
		if (getSex() != null ? !getSex().equals(that.getSex()) : that.getSex() != null) return false;
		if (getAge() != null ? !getAge().equals(that.getAge()) : that.getAge() != null) return false;
		if (getPhonenumber() != null ? !getPhonenumber().equals(that.getPhonenumber()) : that.getPhonenumber() != null)
			return false;
		if (getqQnumber() != null ? !getqQnumber().equals(that.getqQnumber()) : that.getqQnumber() != null)
			return false;
		if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
		if (getEducation() != null ? !getEducation().equals(that.getEducation()) : that.getEducation() != null)
			return false;
		if (getGraduateschool() != null ? !getGraduateschool().equals(that.getGraduateschool()) : that.getGraduateschool() != null)
			return false;
		if (getMajor() != null ? !getMajor().equals(that.getMajor()) : that.getMajor() != null) return false;
		if (getGraduationTime() != null ? !getGraduationTime().equals(that.getGraduationTime()) : that.getGraduationTime() != null)
			return false;
		if (getIsWork() != null ? !getIsWork().equals(that.getIsWork()) : that.getIsWork() != null) return false;
		if (getAddr() != null ? !getAddr().equals(that.getAddr()) : that.getAddr() != null) return false;
		if (getLandlordNum() != null ? !getLandlordNum().equals(that.getLandlordNum()) : that.getLandlordNum() != null)
			return false;
		if (getIsLoan() != null ? !getIsLoan().equals(that.getIsLoan()) : that.getIsLoan() != null) return false;
		if (getCompanyId() != null ? !getCompanyId().equals(that.getCompanyId()) : that.getCompanyId() != null)
			return false;
		if (getCompanyname() != null ? !getCompanyname().equals(that.getCompanyname()) : that.getCompanyname() != null)
			return false;
		if (getEmpId() != null ? !getEmpId().equals(that.getEmpId()) : that.getEmpId() != null) return false;
		if (getSalary() != null ? !getSalary().equals(that.getSalary()) : that.getSalary() != null) return false;
		if (getEmployment() != null ? !getEmployment().equals(that.getEmployment()) : that.getEmployment() != null)
			return false;
		if (getOutOfContact() != null ? !getOutOfContact().equals(that.getOutOfContact()) : that.getOutOfContact() != null)
			return false;
		if (getEntrytime() != null ? !getEntrytime().equals(that.getEntrytime()) : that.getEntrytime() != null)
			return false;
		if (getClazzId() != null ? !getClazzId().equals(that.getClazzId()) : that.getClazzId() != null) return false;
		if (getUserId() != null ? !getUserId().equals(that.getUserId()) : that.getUserId() != null) return false;
		if (getUserName() != null ? !getUserName().equals(that.getUserName()) : that.getUserName() != null)
			return false;
		if (getClazzname() != null ? !getClazzname().equals(that.getClazzname()) : that.getClazzname() != null)
			return false;
		if (getSubjectname() != null ? !getSubjectname().equals(that.getSubjectname()) : that.getSubjectname() != null)
			return false;
		return getEntrytyears() != null ? getEntrytyears().equals(that.getEntrytyears()) : that.getEntrytyears() == null;
	}

	@Override
	public int hashCode() {
		int result = getStuId() != null ? getStuId().hashCode() : 0;
		result = 31 * result + (getNum() != null ? getNum().hashCode() : 0);
		result = 31 * result + (getName() != null ? getName().hashCode() : 0);
		result = 31 * result + (getSex() != null ? getSex().hashCode() : 0);
		result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
		result = 31 * result + (getPhonenumber() != null ? getPhonenumber().hashCode() : 0);
		result = 31 * result + (getqQnumber() != null ? getqQnumber().hashCode() : 0);
		result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
		result = 31 * result + (getEducation() != null ? getEducation().hashCode() : 0);
		result = 31 * result + (getGraduateschool() != null ? getGraduateschool().hashCode() : 0);
		result = 31 * result + (getMajor() != null ? getMajor().hashCode() : 0);
		result = 31 * result + (getGraduationTime() != null ? getGraduationTime().hashCode() : 0);
		result = 31 * result + (getIsWork() != null ? getIsWork().hashCode() : 0);
		result = 31 * result + (getAddr() != null ? getAddr().hashCode() : 0);
		result = 31 * result + (getLandlordNum() != null ? getLandlordNum().hashCode() : 0);
		result = 31 * result + (getIsLoan() != null ? getIsLoan().hashCode() : 0);
		result = 31 * result + (getCompanyId() != null ? getCompanyId().hashCode() : 0);
		result = 31 * result + (getCompanyname() != null ? getCompanyname().hashCode() : 0);
		result = 31 * result + (getEmpId() != null ? getEmpId().hashCode() : 0);
		result = 31 * result + (getSalary() != null ? getSalary().hashCode() : 0);
		result = 31 * result + (getEmployment() != null ? getEmployment().hashCode() : 0);
		result = 31 * result + (getOutOfContact() != null ? getOutOfContact().hashCode() : 0);
		result = 31 * result + (getEntrytime() != null ? getEntrytime().hashCode() : 0);
		result = 31 * result + (getClazzId() != null ? getClazzId().hashCode() : 0);
		result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
		result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
		result = 31 * result + (getClazzname() != null ? getClazzname().hashCode() : 0);
		result = 31 * result + (getSubjectname() != null ? getSubjectname().hashCode() : 0);
		result = 31 * result + (getEntrytyears() != null ? getEntrytyears().hashCode() : 0);
		return result;
	}
}
