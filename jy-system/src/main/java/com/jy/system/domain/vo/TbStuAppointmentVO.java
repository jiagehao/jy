package com.jy.system.domain.vo;

import com.jy.common.core.domain.BaseEntity;

/**
 * 学员记录表 tb_stu_appointment
 * 
 * @author jy
 * @date 2019-04-08
 */
public class TbStuAppointmentVO extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	

	/** 指定时间 */
	private String appointtime;
	/** 创建时间 */
	private String createtime;
	/** 信息记录 */
	private String description;
	/**操作员姓名*/
	private String empName;

	/**是否违纪**/
	private Integer isfoul;

	public Integer getIsfoul() {
		return isfoul;
	}

	public void setIsfoul(Integer isfoul) {
		this.isfoul = isfoul;
	}

	public String getAppointtime() {
		return appointtime;
	}

	public void setAppointtime(String appointtime) {
		this.appointtime = appointtime;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "TbStuAppointmentVO{" +
				"appointtime='" + appointtime + '\'' +
				", createtime='" + createtime + '\'' +
				", description='" + description + '\'' +
				", empName='" + empName + '\'' +
				'}';
	}
}
