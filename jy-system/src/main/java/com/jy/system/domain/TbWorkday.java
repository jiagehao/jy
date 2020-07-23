package com.jy.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jy.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 工作日表 tb_workday
 * 
 * @author jy
 * @date 2019-04-08
 */
public class TbWorkday extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 工作日id */
	private String id;
	/** 节假日名称 */
	private String title;
	/** 节假日日期 */
	private Date holidayDate;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	public void setHolidayDate(Date holidayDate) 
	{
		this.holidayDate = holidayDate;
	}

	public Date getHolidayDate() 
	{
		return holidayDate;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("holidayDate", getHolidayDate())
            .toString();
    }
}
