package com.jy.system.service;

import com.jy.system.domain.BaseInterview;

import java.util.List;

/**
 * 学生约谈记录 服务层
 * 
 * @author ruoyi
 * @date 2019-05-07
 */
public interface IBaseInterviewService 
{
	/**
     * 查询学生约谈记录信息
     * 
     * @param interviewid 学生约谈记录ID
     * @return 学生约谈记录信息
     */
	public BaseInterview selectBaseInterviewById(String interviewid);
	
	/**
     * 查询学生约谈记录列表
     * 
     * @param baseInterview 学生约谈记录信息
     * @return 学生约谈记录集合
     */
	public List<BaseInterview> selectBaseInterviewList(BaseInterview baseInterview);
	
	/**
     * 新增学生约谈记录
     * 
     * @param baseInterview 学生约谈记录信息
     * @return 结果
     */
	public int insertBaseInterview(BaseInterview baseInterview);
	
	/**
     * 修改学生约谈记录
     * 
     * @param baseInterview 学生约谈记录信息
     * @return 结果
     */
	public int updateBaseInterview(BaseInterview baseInterview);
		
	/**
     * 删除学生约谈记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBaseInterviewByIds(String ids);
	public int deleteBaseInterviewByStuId(String interviewid);
}
