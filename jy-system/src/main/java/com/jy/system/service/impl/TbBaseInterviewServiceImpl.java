package com.jy.system.service.impl;


import com.jy.common.core.text.Convert;
import com.jy.system.domain.TbBaseInterview;
import com.jy.system.mapper.TbBaseInterviewMapper;
import com.jy.system.service.ITbBaseInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 三天一访谈 服务层实现
 * 
 * @author jy
 * @date 2019-05-16
 */
@Service
public class TbBaseInterviewServiceImpl implements ITbBaseInterviewService
{
	@Autowired
	private TbBaseInterviewMapper tbBaseInterviewMapper;

	/**
     * 查询三天一访谈信息
     * 
     * @param interviewid 三天一访谈ID
     * @return 三天一访谈信息
     */
    @Override
	public TbBaseInterview selectTbBaseInterviewById(String interviewid)
	{
	    return tbBaseInterviewMapper.selectTbBaseInterviewById(interviewid);
	}
	
	/**
     * 查询三天一访谈列表
     * 
     * @param tbBaseInterview 三天一访谈信息
     * @return 三天一访谈集合
     */
	@Override
	public List<TbBaseInterview> selectTbBaseInterviewList(TbBaseInterview tbBaseInterview)
	{
	    return tbBaseInterviewMapper.selectTbBaseInterviewList(tbBaseInterview);
	}
	
    /**
     * 新增三天一访谈
     * 
     * @param tbBaseInterview 三天一访谈信息
     * @return 结果
     */
	@Override
	public int insertTbBaseInterview(TbBaseInterview tbBaseInterview)
	{
	    return tbBaseInterviewMapper.insertTbBaseInterview(tbBaseInterview);
	}
	
	/**
     * 修改三天一访谈
     * 
     * @param tbBaseInterview 三天一访谈信息
     * @return 结果
     */
	@Override
	public int updateTbBaseInterview(TbBaseInterview tbBaseInterview)
	{
	    return tbBaseInterviewMapper.updateTbBaseInterview(tbBaseInterview);
	}

	/**
     * 删除三天一访谈对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTbBaseInterviewByIds(String ids)
	{
		return tbBaseInterviewMapper.deleteTbBaseInterviewByIds(Convert.toStrArray(ids));
	}
	
}
