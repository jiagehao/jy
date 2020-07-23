package com.jy.system.domain;

import com.jy.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 基础班学生成绩表 tb_base_achievement
 * 
 * @author ruoyi
 * @date 2019-04-29
 */
public class BaseAchievement extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String id;
	/** 类型 */
	private String category;
	/**  */
	private String one;
	/**  */
	private String two;
	/**  */
	private String three;
	/**  */
	private String four;
	/**  */
	private String five;
	/**  */
	private String six;
	/**  */
	private String seven;
	/**  */
	private String eight;
	/**  */
	private String nine;
	/**  */
	private String ten;
	/**  */
	private String eleven;
	/**  */
	private String twelve;
	/**  */
	private String thirteen;
	/**  */
	private String fourteen;
	/**  */
	private String fifteen;
	/**  */
	private String workexperience;
	/** 用户ID */
	private String stuId;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setCategory(String category) 
	{
		this.category = category;
	}

	public String getCategory() 
	{
		return category;
	}
	public void setOne(String one) 
	{
		this.one = one;
	}

	public String getOne() 
	{
		return one;
	}
	public void setTwo(String two) 
	{
		this.two = two;
	}

	public String getTwo() 
	{
		return two;
	}
	public void setThree(String three) 
	{
		this.three = three;
	}

	public String getThree() 
	{
		return three;
	}
	public void setFour(String four) 
	{
		this.four = four;
	}

	public String getFour() 
	{
		return four;
	}
	public void setFive(String five) 
	{
		this.five = five;
	}

	public String getFive() 
	{
		return five;
	}
	public void setSix(String six) 
	{
		this.six = six;
	}

	public String getSix() 
	{
		return six;
	}
	public void setSeven(String seven) 
	{
		this.seven = seven;
	}

	public String getSeven() 
	{
		return seven;
	}
	public void setEight(String eight) 
	{
		this.eight = eight;
	}

	public String getEight() 
	{
		return eight;
	}
	public void setNine(String nine) 
	{
		this.nine = nine;
	}

	public String getNine() 
	{
		return nine;
	}
	public void setTen(String ten) 
	{
		this.ten = ten;
	}

	public String getTen() 
	{
		return ten;
	}
	public void setEleven(String eleven) 
	{
		this.eleven = eleven;
	}

	public String getEleven() 
	{
		return eleven;
	}
	public void setTwelve(String twelve) 
	{
		this.twelve = twelve;
	}

	public String getTwelve() 
	{
		return twelve;
	}
	public void setThirteen(String thirteen) 
	{
		this.thirteen = thirteen;
	}

	public String getThirteen() 
	{
		return thirteen;
	}
	public void setFourteen(String fourteen) 
	{
		this.fourteen = fourteen;
	}

	public String getFourteen() 
	{
		return fourteen;
	}
	public void setFifteen(String fifteen) 
	{
		this.fifteen = fifteen;
	}

	public String getFifteen() 
	{
		return fifteen;
	}
	public void setWorkexperience(String workexperience) 
	{
		this.workexperience = workexperience;
	}

	public String getWorkexperience() 
	{
		return workexperience;
	}
	public void setStuId(String stuId) 
	{
		this.stuId = stuId;
	}

	public String getStuId() 
	{
		return stuId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("category", getCategory())
            .append("one", getOne())
            .append("two", getTwo())
            .append("three", getThree())
            .append("four", getFour())
            .append("five", getFive())
            .append("six", getSix())
            .append("seven", getSeven())
            .append("eight", getEight())
            .append("nine", getNine())
            .append("ten", getTen())
            .append("eleven", getEleven())
            .append("twelve", getTwelve())
            .append("thirteen", getThirteen())
            .append("fourteen", getFourteen())
            .append("fifteen", getFifteen())
            .append("workexperience", getWorkexperience())
            .append("stuId", getStuId())
            .toString();
    }
}
