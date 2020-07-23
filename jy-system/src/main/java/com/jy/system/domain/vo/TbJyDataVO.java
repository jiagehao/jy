package com.jy.system.domain.vo;

import com.jy.common.annotation.Excel;
import com.jy.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 报表 tb_jy_data
 * 
 * @author jy
 * @date 2019-08-13
 */
public class TbJyDataVO extends BaseEntity
{
	private static final long serialVersionUID = 1L;


	//学科名称
	private String className;
	//班级人数
	private String classNum;
	//品均值
	private String classAvg;
	//工作人数
	private String workNum;

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public String getWorkNum() {
		return workNum;
	}

	public void setWorkNum(String workNum) {
		this.workNum = workNum;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassAvg() {
		return classAvg;
	}

	public void setClassAvg(String classAvg) {
		this.classAvg = classAvg;
	}

	@Override
	public String toString() {
		return "TbJyDataVO{" +
				"className=" + className +
				", classAvg=" + classAvg +
				'}';
	}
}
