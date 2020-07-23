package com.jy.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jy.common.core.domain.BaseEntity;

/**
 * 班级表 tb_clazz
 * 
 * @author jy
 * @date 2019-04-08
 */
public class TbClazz extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 班级ID */
	private String clazzId;
	/** 班级名称 */
	private String clazzname;
	/** 学科ID */
	private String subjectId;
	/** 学科名称 */
	private String subjectname;
	/** 开班时间 */
	private String begintime;
	/** 结课时间 */
	private String endtime;
	/** 工作日 */
	private String workday;
	/** 工作日更新时间 */
	private String workdaytime;
	/** 班主任名称 */
	private String headmasterName;
	/** 是否删除(0为true,1为false) */
	private Integer isdelete;
	/** 是否有效(0为true,1为false) */
	private Integer isvalid;

	public void setClazzId(String clazzId) 
	{
		this.clazzId = clazzId;
	}

	public String getClazzId() 
	{
		return clazzId;
	}
	public void setClazzname(String clazzname) 
	{
		this.clazzname = clazzname;
	}

	public String getClazzname() 
	{
		return clazzname;
	}
	public void setSubjectId(String subjectId) 
	{
		this.subjectId = subjectId;
	}

	public String getSubjectId() 
	{
		return subjectId;
	}
	public void setSubjectname(String subjectname) 
	{
		this.subjectname = subjectname;
	}

	public String getSubjectname() 
	{
		return subjectname;
	}
	public void setBegintime(String begintime) 
	{
		this.begintime = begintime;
	}

	public String getBegintime() 
	{
		return begintime;
	}
	public void setEndtime(String endtime) 
	{
		this.endtime = endtime;
	}

	public String getEndtime() 
	{
		return endtime;
	}
	public void setWorkday(String workday) 
	{
		this.workday = workday;
	}

	public String getWorkday() 
	{
		return workday;
	}
	public void setWorkdaytime(String workdaytime) 
	{
		this.workdaytime = workdaytime;
	}

	public String getWorkdaytime() 
	{
		return workdaytime;
	}
	public void setHeadmasterName(String headmasterName) 
	{
		this.headmasterName = headmasterName;
	}

	public String getHeadmasterName() 
	{
		return headmasterName;
	}
	public void setIsdelete(Integer isdelete) 
	{
		this.isdelete = isdelete;
	}

	public Integer getIsdelete() 
	{
		return isdelete;
	}
	public void setIsvalid(Integer isvalid) 
	{
		this.isvalid = isvalid;
	}

	public Integer getIsvalid() 
	{
		return isvalid;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("clazzId", getClazzId())
            .append("clazzname", getClazzname())
            .append("subjectId", getSubjectId())
            .append("subjectname", getSubjectname())
            .append("begintime", getBegintime())
            .append("endtime", getEndtime())
            .append("workday", getWorkday())
            .append("workdaytime", getWorkdaytime())
            .append("headmasterName", getHeadmasterName())
            .append("isdelete", getIsdelete())
            .append("isvalid", getIsvalid())
            .toString();
    }
}
