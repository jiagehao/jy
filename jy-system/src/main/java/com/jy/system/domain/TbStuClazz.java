package com.jy.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jy.common.core.domain.BaseEntity;

/**
 * 学员班级中间表 tb_stu_clazz
 * 
 * @author jy
 * @date 2019-04-08
 */
public class TbStuClazz extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 学员班级关联ID */
	private String stuclazzId;
	/** 学员ID */
	private String stuId;
	/** 班级ID */
	private String clazzId;

	public void setStuclazzId(String stuclazzId) 
	{
		this.stuclazzId = stuclazzId;
	}

	public String getStuclazzId() 
	{
		return stuclazzId;
	}
	public void setStuId(String stuId) 
	{
		this.stuId = stuId;
	}

	public String getStuId() 
	{
		return stuId;
	}
	public void setClazzId(String clazzId) 
	{
		this.clazzId = clazzId;
	}

	public String getClazzId() 
	{
		return clazzId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stuclazzId", getStuclazzId())
            .append("stuId", getStuId())
            .append("clazzId", getClazzId())
            .toString();
    }
}
