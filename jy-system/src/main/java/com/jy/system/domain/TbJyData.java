package com.jy.system.domain;

import com.jy.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jy.common.core.domain.BaseEntity;

/**
 * 报表 tb_jy_data
 * 
 * @author jy
 * @date 2019-08-13
 */
public class TbJyData extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 就业数据id */
	private String id;
	@Excel(name = "所属校区")
	/** 所属校区 */
	private String a;
	@Excel(name = "品牌")
	/** 品牌 */
	private String b;
	@Excel(name = "授课方式")
	/** 授课方式 */
	private String c;
	@Excel(name = "毕业班级")
	/** 毕业班级 */
	private String d;
	@Excel(name = "班级人数")
	/** 班级人数 */
	private String e;
	@Excel(name = "有效人数")
	/** 有效人数 */
	private String f;
	@Excel(name = "毕业时间")
	/** 毕业时间 */
	private String g;
	@Excel(name = "数据更新时间")
	/** 数据更新时间 */
	private String o2;
	@Excel(name = "当前有效人数")
	/** 当前有效人数 */
	private String p2;
	@Excel(name = "有效工作日")
	/** 有效工作日 */
	private String q2;
	@Excel(name = "就业率")
	/** 就业率 */
	private String r2;
	@Excel(name = "全班平均薪资")
	/** 全班平均薪资 */
	private String s2;
	@Excel(name = "一线平均薪资")
	/** 一线平均薪资 */
	private String t2;
	@Excel(name = "二线平均薪资")
	/** 二线平均薪资 */
	private String u2;
	@Excel(name = "数据更新时间")
	/**  */
	private String o4;
	@Excel(name = "当前有效人数")
	/**  */
	private String p4;
	@Excel(name = "有效工作日")
	/**  */
	private String q4;
	@Excel(name = "就业率")
	/**  */
	private String r4;
	@Excel(name = "全班平均薪资")
	/**  */
	private String s4;
	@Excel(name = "一线平均薪资")
	/**  */
	private String t4;
	@Excel(name = "二线平均薪资")
	/**  */
	private String u4;
	@Excel(name = "数据更新时间")
	/**  */
	private String o6;
	@Excel(name = "当前有效人数")
	/**  */
	private String p6;
	@Excel(name = "有效工作日")
	/**  */
	private String q6;
	@Excel(name = "就业率")
	/**  */
	private String r6;
	@Excel(name = "全班平均薪资")
	/**  */
	private String s6;
	@Excel(name = "一线平均薪资")
	/**  */
	private String t6;
	@Excel(name = "二线平均薪资")
	/**  */
	private String u6;

	private int className;
	private int userNum;

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public int getClassName() {
		return className;
	}

	public void setClassName(int className) {
		this.className = className;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setA(String a) 
	{
		this.a = a;
	}

	public String getA() 
	{
		return a;
	}
	public void setB(String b) 
	{
		this.b = b;
	}

	public String getB() 
	{
		return b;
	}
	public void setC(String c) 
	{
		this.c = c;
	}

	public String getC() 
	{
		return c;
	}
	public void setD(String d) 
	{
		this.d = d;
	}

	public String getD() 
	{
		return d;
	}
	public void setE(String e) 
	{
		this.e = e;
	}

	public String getE() 
	{
		return e;
	}
	public void setF(String f) 
	{
		this.f = f;
	}

	public String getF() 
	{
		return f;
	}
	public void setG(String g) 
	{
		this.g = g;
	}

	public String getG() 
	{
		return g;
	}
	public void setO2(String o2) 
	{
		this.o2 = o2;
	}

	public String getO2() 
	{
		return o2;
	}
	public void setP2(String p2) 
	{
		this.p2 = p2;
	}

	public String getP2() 
	{
		return p2;
	}
	public void setQ2(String q2) 
	{
		this.q2 = q2;
	}

	public String getQ2() 
	{
		return q2;
	}
	public void setR2(String r2)
	{
		this.r2 = r2;
	}

	public String getR2()
	{
		return r2;
	}
	public void setS2(String s2) 
	{
		this.s2 = s2;
	}

	public String getS2() 
	{
		return s2;
	}
	public void setT2(String t2) 
	{
		this.t2 = t2;
	}

	public String getT2() 
	{
		return t2;
	}
	public void setU2(String u2) 
	{
		this.u2 = u2;
	}

	public String getU2() 
	{
		return u2;
	}
	public void setO4(String o4) 
	{
		this.o4 = o4;
	}

	public String getO4() 
	{
		return o4;
	}
	public void setP4(String p4) 
	{
		this.p4 = p4;
	}

	public String getP4() 
	{
		return p4;
	}
	public void setQ4(String q4) 
	{
		this.q4 = q4;
	}

	public String getQ4() 
	{
		return q4;
	}
	public void setR4(String r4)
	{
		this.r4 = r4;
	}

	public String getR4()
	{
		return r4;
	}
	public void setS4(String s4) 
	{
		this.s4 = s4;
	}

	public String getS4() 
	{
		return s4;
	}
	public void setT4(String t4) 
	{
		this.t4 = t4;
	}

	public String getT4() 
	{
		return t4;
	}
	public void setU4(String u4) 
	{
		this.u4 = u4;
	}

	public String getU4() 
	{
		return u4;
	}
	public void setO6(String o6) 
	{
		this.o6 = o6;
	}

	public String getO6() 
	{
		return o6;
	}
	public void setP6(String p6) 
	{
		this.p6 = p6;
	}

	public String getP6() 
	{
		return p6;
	}
	public void setQ6(String q6) 
	{
		this.q6 = q6;
	}

	public String getQ6() 
	{
		return q6;
	}
	public void setR6(String r6)
	{
		this.r6 = r6;
	}

	public String getR6()
	{
		return r6;
	}
	public void setS6(String s6)
	{
		this.s6 = s6;
	}

	public String getS6() 
	{
		return s6;
	}
	public void setT6(String t6) 
	{
		this.t6 = t6;
	}

	public String getT6() 
	{
		return t6;
	}
	public void setU6(String u6) 
	{
		this.u6 = u6;
	}

	public String getU6() 
	{
		return u6;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("a", getA())
            .append("b", getB())
            .append("c", getC())
            .append("d", getD())
            .append("e", getE())
            .append("f", getF())
            .append("g", getG())
            .append("o2", getO2())
            .append("p2", getP2())
            .append("q2", getQ2())
            .append("r2", getR2())
            .append("s2", getS2())
            .append("t2", getT2())
            .append("u2", getU2())
            .append("o4", getO4())
            .append("p4", getP4())
            .append("q4", getQ4())
            .append("r4", getR4())
            .append("s4", getS4())
            .append("t4", getT4())
            .append("u4", getU4())
            .append("o6", getO6())
            .append("p6", getP6())
            .append("q6", getQ6())
            .append("r6", getR6())
            .append("s6", getS6())
            .append("t6", getT6())
            .append("u6", getU6())
            .toString();
    }
}
