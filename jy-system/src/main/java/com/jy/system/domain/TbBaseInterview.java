package com.jy.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jy.common.core.domain.BaseEntity;

/**
 * 三天一访谈表 tb_base_interview
 * 
 * @author jy
 * @date 2019-05-16
 */
public class TbBaseInterview extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String interviewid;
	/**  */
	private String name;
	/**  */
	private String sex;
	/**  */
	private String age;
	/**  */
	private String education;
	/**  */
	private String problemOne;
	/**  */
	private String remarkshrOne;
	/**  */
	private String problemTow;
	/**  */
	private String remarkshrTow;
	/**  */
	private String problemThree;
	/**  */
	private String remarkshrThree;
	/**  */
	private String problemFour;
	/**  */
	private String remarkshrFour;
	/**  */
	private String endtime;
	/**  */
	private String clazztime;
	/**  */
	private String clazzid;
	/**  */
	private String stuid;

	public void setInterviewid(String interviewid) 
	{
		this.interviewid = interviewid;
	}

	public String getInterviewid() 
	{
		return interviewid;
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
	public void setAge(String age) 
	{
		this.age = age;
	}

	public String getAge() 
	{
		return age;
	}
	public void setEducation(String education) 
	{
		this.education = education;
	}

	public String getEducation() 
	{
		return education;
	}
	public void setProblemOne(String problemOne) 
	{
		this.problemOne = problemOne;
	}

	public String getProblemOne() 
	{
		return problemOne;
	}
	public void setRemarkshrOne(String remarkshrOne) 
	{
		this.remarkshrOne = remarkshrOne;
	}

	public String getRemarkshrOne() 
	{
		return remarkshrOne;
	}
	public void setProblemTow(String problemTow) 
	{
		this.problemTow = problemTow;
	}

	public String getProblemTow() 
	{
		return problemTow;
	}
	public void setRemarkshrTow(String remarkshrTow) 
	{
		this.remarkshrTow = remarkshrTow;
	}

	public String getRemarkshrTow() 
	{
		return remarkshrTow;
	}
	public void setProblemThree(String problemThree) 
	{
		this.problemThree = problemThree;
	}

	public String getProblemThree() 
	{
		return problemThree;
	}
	public void setRemarkshrThree(String remarkshrThree) 
	{
		this.remarkshrThree = remarkshrThree;
	}

	public String getRemarkshrThree() 
	{
		return remarkshrThree;
	}
	public void setProblemFour(String problemFour) 
	{
		this.problemFour = problemFour;
	}

	public String getProblemFour() 
	{
		return problemFour;
	}
	public void setRemarkshrFour(String remarkshrFour) 
	{
		this.remarkshrFour = remarkshrFour;
	}

	public String getRemarkshrFour() 
	{
		return remarkshrFour;
	}
	public void setEndtime(String endtime) 
	{
		this.endtime = endtime;
	}

	public String getEndtime() 
	{
		return endtime;
	}
	public void setClazztime(String clazztime) 
	{
		this.clazztime = clazztime;
	}

	public String getClazztime() 
	{
		return clazztime;
	}
	public void setClazzid(String clazzid) 
	{
		this.clazzid = clazzid;
	}

	public String getClazzid() 
	{
		return clazzid;
	}
	public void setStuid(String stuid) 
	{
		this.stuid = stuid;
	}

	public String getStuid() 
	{
		return stuid;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("interviewid", getInterviewid())
            .append("name", getName())
            .append("sex", getSex())
            .append("age", getAge())
            .append("education", getEducation())
            .append("problemOne", getProblemOne())
            .append("remarkshrOne", getRemarkshrOne())
            .append("problemTow", getProblemTow())
            .append("remarkshrTow", getRemarkshrTow())
            .append("problemThree", getProblemThree())
            .append("remarkshrThree", getRemarkshrThree())
            .append("problemFour", getProblemFour())
            .append("remarkshrFour", getRemarkshrFour())
            .append("endtime", getEndtime())
            .append("clazztime", getClazztime())
            .append("clazzid", getClazzid())
            .append("stuid", getStuid())
            .toString();
    }
}
