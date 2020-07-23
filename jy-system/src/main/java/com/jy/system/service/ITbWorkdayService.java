package com.jy.system.service;

import com.jy.system.domain.TbWorkday;

import java.util.List;

/**
 * 工作日 服务层
 * 
 * @author jy
 * @date 2019-04-08
 */
public interface ITbWorkdayService 
{
	/**
     * 查询工作日信息
     * 
     * @param id 工作日ID
     * @return 工作日信息
     */
	public TbWorkday selectTbWorkdayById(String id);
	
	/**
     * 查询工作日列表
     * 
     * @param tbWorkday 工作日信息
     * @return 工作日集合
     */
	public List<TbWorkday> selectTbWorkdayList(TbWorkday tbWorkday);
	
	/**
     * 新增工作日
     * 
     * @param tbWorkday 工作日信息
     * @return 结果
     */
	public int insertTbWorkday(TbWorkday tbWorkday);
	
	/**
     * 修改工作日
     * 
     * @param tbWorkday 工作日信息
     * @return 结果
     */
	public int updateTbWorkday(TbWorkday tbWorkday);
		
	/**
     * 删除工作日信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTbWorkdayByIds(String ids);
	
}
