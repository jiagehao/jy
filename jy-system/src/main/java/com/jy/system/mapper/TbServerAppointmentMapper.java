package com.jy.system.mapper;


import com.jy.system.domain.TbServerAppointment;
import com.jy.system.domain.vo.TbStuAppointmentVO;

import java.util.List;

/**
 * 过程服务学员记录 数据层
 * 
 * @author jy
 * @date 2019-06-13
 */
public interface TbServerAppointmentMapper 
{
	/**
     * 查询过程服务学员记录信息
     * 
     * @param id 过程服务学员记录ID
     * @return 过程服务学员记录信息
     */
	public TbServerAppointment selectTbServerAppointmentById(String id);
	
	/**
     * 查询过程服务学员记录列表
     * 
     * @param tbServerAppointment 过程服务学员记录信息
     * @return 过程服务学员记录集合
     */
	public List<TbServerAppointment> selectTbServerAppointmentList(TbServerAppointment tbServerAppointment);
	
	/**
     * 新增过程服务学员记录
     * 
     * @param tbServerAppointment 过程服务学员记录信息
     * @return 结果
     */
	public int insertTbServerAppointment(TbServerAppointment tbServerAppointment);
	
	/**
     * 修改过程服务学员记录
     * 
     * @param tbServerAppointment 过程服务学员记录信息
     * @return 结果
     */
	public int updateTbServerAppointment(TbServerAppointment tbServerAppointment);
	
	/**
     * 删除过程服务学员记录
     * 
     * @param id 过程服务学员记录ID
     * @return 结果
     */
	public int deleteTbServerAppointmentById(String id);
	
	/**
     * 批量删除过程服务学员记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTbServerAppointmentByIds(String[] ids);

	public List<TbStuAppointmentVO>  selectTbServerAppointmentAll(TbServerAppointment tbServerAppointment);

}