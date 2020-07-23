package com.jy.system.service.impl;

import java.util.List;

import com.jy.common.core.text.Convert;
import com.jy.system.domain.BaseInterview;
import com.jy.system.mapper.BaseInterviewMapper;
import com.jy.system.service.IBaseInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 学生约谈记录 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-07
 */
@Service
public class BaseInterviewServiceImpl implements IBaseInterviewService
{
	@Autowired
	private BaseInterviewMapper baseInterviewMapper;

	/**
     * 查询学生约谈记录信息
     * 
     * @param interviewid 学生约谈记录ID
     * @return 学生约谈记录信息
     */
    @Override
	public BaseInterview selectBaseInterviewById(String interviewid)
	{
	    return baseInterviewMapper.selectBaseInterviewById(interviewid);
	}
	
	/**
     * 查询学生约谈记录列表
     * 
     * @param baseInterview 学生约谈记录信息
     * @return 学生约谈记录集合
     */
	@Override
	public List<BaseInterview> selectBaseInterviewList(BaseInterview baseInterview)
	{
	    return baseInterviewMapper.selectBaseInterviewList(baseInterview);
	}
	
    /**
     * 新增学生约谈记录
     * 
     * @param baseInterview 学生约谈记录信息
     * @return 结果
     */
	@Override
	public int insertBaseInterview(BaseInterview baseInterview)
	{
	    return baseInterviewMapper.insertBaseInterview(baseInterview);
	}
	
	/**
     * 修改学生约谈记录
     * 
     * @param baseInterview 学生约谈记录信息
     * @return 结果
     */
	@Override
	public int updateBaseInterview(BaseInterview baseInterview)
	{
	    return baseInterviewMapper.updateBaseInterview(baseInterview);
	}

	/**
     * 删除学生约谈记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBaseInterviewByIds(String ids)
	{
		return baseInterviewMapper.deleteBaseInterviewByIds(Convert.toStrArray(ids));
	}

	@Override
	public int deleteBaseInterviewByStuId(String stuId) {
		return baseInterviewMapper.deleteBaseInterviewByStuId(stuId);
	}

}
