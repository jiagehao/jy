package com.jy.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jy.common.core.domain.BaseEntity;

/**
 * 过程服务学员记录表 tb_server_appointment
 * 
 * @author jy
 * @date 2019-06-13
 */
public class TbServerAppointment extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String id;
	/** 学员ID */
	private String stuId;
	/** 学员姓名 */
	private String stuname;
	/** 电话号码 */
	private String telephone;
	/** QQ号 */
	private String qqnumber;
	/** 指定时间 */
	private String appointtime;
	/** 创建时间 */
	private String createtime;
	/** 信息记录 */
	private String description;
	/** 用户ID */
	private String empId;
	/**
	 * 是否违纪记录
	 */
	private String isfoul;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setStuId(String stuId) 
	{
		this.stuId = stuId;
	}

	public String getStuId() 
	{
		return stuId;
	}
	public void setStuname(String stuname) 
	{
		this.stuname = stuname;
	}

	public String getStuname() 
	{
		return stuname;
	}
	public void setTelephone(String telephone) 
	{
		this.telephone = telephone;
	}

	public String getTelephone() 
	{
		return telephone;
	}
	public void setQqnumber(String qqnumber) 
	{
		this.qqnumber = qqnumber;
	}

	public String getQqnumber() 
	{
		return qqnumber;
	}
	public void setAppointtime(String appointtime) 
	{
		this.appointtime = appointtime;
	}

	public String getAppointtime() 
	{
		return appointtime;
	}
	public void setCreatetime(String createtime) 
	{
		this.createtime = createtime;
	}

	public String getCreatetime() 
	{
		return createtime;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	public void setEmpId(String empId) 
	{
		this.empId = empId;
	}

	public String getEmpId() 
	{
		return empId;
	}

	public String getIsfoul() {
		return isfoul;
	}

	public void setIsfoul(String isfoul) {
		this.isfoul = isfoul;
	}

	@Override
	public String toString() {
		return "TbServerAppointment{" +
				"id='" + id + '\'' +
				", stuId='" + stuId + '\'' +
				", stuname='" + stuname + '\'' +
				", telephone='" + telephone + '\'' +
				", qqnumber='" + qqnumber + '\'' +
				", appointtime='" + appointtime + '\'' +
				", createtime='" + createtime + '\'' +
				", description='" + description + '\'' +
				", empId='" + empId + '\'' +
				", isfoul=" + isfoul +
				'}';
	}
}
