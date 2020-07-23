package com.jy.system.service.impl;


import com.jy.common.core.text.Convert;
import com.jy.system.domain.TbWorkday;
import com.jy.system.mapper.TbWorkdayMapper;
import com.jy.system.service.ITbWorkdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 工作日 服务层实现
 * 
 * @author jy
 * @date 2019-04-08
 */
@Service
public class TbWorkdayServiceImpl implements ITbWorkdayService
{
	@Autowired
	private TbWorkdayMapper tbWorkdayMapper;

	/**
     * 查询工作日信息
     * 
     * @param id 工作日ID
     * @return 工作日信息
     */
    @Override
	public TbWorkday selectTbWorkdayById(String id)
	{
	    return tbWorkdayMapper.selectTbWorkdayById(id);
	}
	
	/**
     * 查询工作日列表
     * 
     * @param tbWorkday 工作日信息
     * @return 工作日集合
     */
	@Override
	public List<TbWorkday> selectTbWorkdayList(TbWorkday tbWorkday)
	{
	    return tbWorkdayMapper.selectTbWorkdayList(tbWorkday);
	}
	
    /**
     * 新增工作日
     * 
     * @param tbWorkday 工作日信息
     * @return 结果
     */
	@Override
	public int insertTbWorkday(TbWorkday tbWorkday)
	{
	    return tbWorkdayMapper.insertTbWorkday(tbWorkday);
	}
	
	/**
     * 修改工作日
     * 
     * @param tbWorkday 工作日信息
     * @return 结果
     */
	@Override
	public int updateTbWorkday(TbWorkday tbWorkday)
	{
	    return tbWorkdayMapper.updateTbWorkday(tbWorkday);
	}

	/**
     * 删除工作日对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTbWorkdayByIds(String ids)
	{
		return tbWorkdayMapper.deleteTbWorkdayByIds(Convert.toStrArray(ids));
	}
	
}
