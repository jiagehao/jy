package com.jy.system.mapper;

import com.jy.system.domain.TbBaseInterview;

import java.util.List;

/**
 * 三天一访谈 数据层
 * 
 * @author jy
 * @date 2019-05-16
 */
public interface TbBaseInterviewMapper 
{
	/**
     * 查询三天一访谈信息
     * 
     * @param interviewid 三天一访谈ID
     * @return 三天一访谈信息
     */
	public TbBaseInterview selectTbBaseInterviewById(String interviewid);
	
	/**
     * 查询三天一访谈列表
     * 
     * @param tbBaseInterview 三天一访谈信息
     * @return 三天一访谈集合
     */
	public List<TbBaseInterview> selectTbBaseInterviewList(TbBaseInterview tbBaseInterview);
	
	/**
     * 新增三天一访谈
     * 
     * @param tbBaseInterview 三天一访谈信息
     * @return 结果
     */
	public int insertTbBaseInterview(TbBaseInterview tbBaseInterview);
	
	/**
     * 修改三天一访谈
     * 
     * @param tbBaseInterview 三天一访谈信息
     * @return 结果
     */
	public int updateTbBaseInterview(TbBaseInterview tbBaseInterview);
	
	/**
     * 删除三天一访谈
     * 
     * @param interviewid 三天一访谈ID
     * @return 结果
     */
	public int deleteTbBaseInterviewById(String interviewid);
	
	/**
     * 批量删除三天一访谈
     * 
     * @param interviewids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTbBaseInterviewByIds(String[] interviewids);
	
}