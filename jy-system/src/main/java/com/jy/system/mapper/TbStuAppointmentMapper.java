package com.jy.system.mapper;


import com.jy.system.domain.TbStuAppointment;
import com.jy.system.domain.vo.TbStuAppointmentVO;

import java.util.List;

/**
 * 学员记录 数据层
 * 
 * @author jy
 * @date 2019-04-08
 */
public interface TbStuAppointmentMapper 
{
	/**
     * 查询学员记录信息
     * 
     * @param id 学员记录ID
     * @return 学员记录信息
     */
	public TbStuAppointment selectTbStuAppointmentById(String id);
	
	/**
     * 查询学员记录列表
     * 
     * @param tbStuAppointment 学员记录信息
     * @return 学员记录集合
     */
	public List<TbStuAppointment> selectTbStuAppointmentList(TbStuAppointment tbStuAppointment);

	/**
	 * 查询单个学员记录信息
	 * @param tbStuAppointment
	 * @return
	 */
	public List<TbStuAppointmentVO> selectTbStuAppointmentAll(TbStuAppointment tbStuAppointment);


	/**
     * 新增学员记录
     * 
     * @param tbStuAppointment 学员记录信息
     * @return 结果
     */
	public int insertTbStuAppointment(TbStuAppointment tbStuAppointment);
	
	/**
     * 修改学员记录
     * 
     * @param tbStuAppointment 学员记录信息
     * @return 结果
     */
	public int updateTbStuAppointment(TbStuAppointment tbStuAppointment);
	
	/**
     * 删除学员记录
     * 
     * @param id 学员记录ID
     * @return 结果
     */
	public int deleteTbStuAppointmentById(String id);
	
	/**
     * 批量删除学员记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTbStuAppointmentByIds(String[] ids);
	public int  deleteTbStuAppointmentByStuId(String stuId);
	
}