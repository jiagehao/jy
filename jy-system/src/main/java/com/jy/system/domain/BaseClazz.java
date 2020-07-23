package com.jy.system.domain;

import com.jy.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 学生班级表 tb_base_clazz
 * 
 * @author ruoyi
 * @date 2019-04-29
 */
public class BaseClazz extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 班级ID */
	private String clazzId;
	/** 班级名称 */
	private String clazzname;
	/** 班级人数 */
	private Integer studentcount;
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
	/**  */
	private String workdaytime;
	/** 班主任名称 */
	private String headmasterName;
	/**  */
	private String campusId;
	/** 是否删除(0为true,1为false) */
	private Integer isdelete;
	/** 是否有效(0为true,1为false) */
	private Integer isvalid;
	/** 助教名字 */
	private String assistantname;
	/** 讲师名字 */
	private String lecturername;
	/** 基础班流失率 */
	private String lossrateone;
	/** 就业班流失率 */
	private String lossratetwo;

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
	public void setStudentcount(Integer studentcount) 
	{
		this.studentcount = studentcount;
	}

	public Integer getStudentcount() 
	{
		return studentcount;
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
	public void setCampusId(String campusId) 
	{
		this.campusId = campusId;
	}

	public String getCampusId() 
	{
		return campusId;
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
	public void setAssistantname(String assistantname) 
	{
		this.assistantname = assistantname;
	}

	public String getAssistantname() 
	{
		return assistantname;
	}
	public void setLecturername(String lecturername) 
	{
		this.lecturername = lecturername;
	}

	public String getLecturername() 
	{
		return lecturername;
	}
	public void setLossrateone(String lossrateone) 
	{
		this.lossrateone = lossrateone;
	}

	public String getLossrateone() 
	{
		return lossrateone;
	}
	public void setLossratetwo(String lossratetwo) 
	{
		this.lossratetwo = lossratetwo;
	}

	public String getLossratetwo() 
	{
		return lossratetwo;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("clazzId", getClazzId())
            .append("clazzname", getClazzname())
            .append("studentcount", getStudentcount())
            .append("subjectId", getSubjectId())
            .append("subjectname", getSubjectname())
            .append("begintime", getBegintime())
            .append("endtime", getEndtime())
            .append("workday", getWorkday())
            .append("workdaytime", getWorkdaytime())
            .append("headmasterName", getHeadmasterName())
            .append("campusId", getCampusId())
            .append("isdelete", getIsdelete())
            .append("isvalid", getIsvalid())
            .append("assistantname", getAssistantname())
            .append("lecturername", getLecturername())
            .append("lossrateone", getLossrateone())
            .append("lossratetwo", getLossratetwo())
            .toString();
    }
}
