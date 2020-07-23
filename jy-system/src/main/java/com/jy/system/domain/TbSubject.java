package com.jy.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jy.common.core.domain.BaseEntity;

/**
 * 学科表 tb_subject
 * 
 * @author jy
 * @date 2019-04-08
 */
public class TbSubject extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 学科ID */
	private String subjectId;
	/** 学科名称 */
	private String subjectName;
	/** 学科天数 */
	private String subjectday;

	private String one;

	private String tow;

	private String three;

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public String getTow() {
		return tow;
	}

	public void setTow(String tow) {
		this.tow = tow;
	}

	public String getThree() {
		return three;
	}

	public void setThree(String three) {
		this.three = three;
	}

	public String getSubjectday() {
		return subjectday;
	}

	public void setSubjectday(String subjectday) {
		this.subjectday = subjectday;
	}

	public void setSubjectId(String subjectId)
	{
		this.subjectId = subjectId;
	}

	public String getSubjectId() 
	{
		return subjectId;
	}
	public void setSubjectName(String subjectName) 
	{
		this.subjectName = subjectName;
	}

	public String getSubjectName() 
	{
		return subjectName;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("subjectId", getSubjectId())
            .append("subjectName", getSubjectName())
            .toString();
    }
}
