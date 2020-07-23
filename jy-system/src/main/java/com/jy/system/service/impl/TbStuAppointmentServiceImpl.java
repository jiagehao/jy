package com.jy.system.service.impl;

import com.jy.common.core.text.Convert;
import com.jy.common.exception.BusinessException;
import com.jy.common.utils.StringUtils;
import com.jy.common.utils.bean.UuidUtil;
import com.jy.system.domain.TbClazz;
import com.jy.system.domain.TbStuAppointment;
import com.jy.system.domain.TbStuClazz;
import com.jy.system.domain.TbStudentinfo;
import com.jy.system.domain.vo.TbStuAppointmentVO;
import com.jy.system.mapper.TbStuAppointmentMapper;
import com.jy.system.service.ITbStuAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 学员记录 服务层实现
 * 
 * @author jy
 * @date 2019-04-08
 */
@Service
public class TbStuAppointmentServiceImpl implements ITbStuAppointmentService
{
	@Autowired
	private TbStuAppointmentMapper tbStuAppointmentMapper;

	/**
     * 查询学员记录信息
     * 
     * @param id 学员记录ID
     * @return 学员记录信息
     */
    @Override
	public TbStuAppointment selectTbStuAppointmentById(String id)
	{
	    return tbStuAppointmentMapper.selectTbStuAppointmentById(id);
	}
	
	/**
     * 查询学员记录列表
     * 
     * @param tbStuAppointment 学员记录信息
     * @return 学员记录集合
     */
	@Override
	public List<TbStuAppointment> selectTbStuAppointmentList(TbStuAppointment tbStuAppointment)
	{
	    return tbStuAppointmentMapper.selectTbStuAppointmentList(tbStuAppointment);
	}

	/**
	 * 查询单个学员记录信息
	 * @param tbStuAppointment
	 * @return
	 */
	public List<TbStuAppointmentVO> selectTbStuAppointmentAll(TbStuAppointment tbStuAppointment){
		return tbStuAppointmentMapper.selectTbStuAppointmentAll(tbStuAppointment);
	}

	/**
     * 新增学员记录
     * 
     * @param tbStuAppointment 学员记录信息
     * @return 结果
     */
	@Override
	public int insertTbStuAppointment(TbStuAppointment tbStuAppointment)
	{
	    return tbStuAppointmentMapper.insertTbStuAppointment(tbStuAppointment);
	}
	
	/**
     * 修改学员记录
     * 
     * @param tbStuAppointment 学员记录信息
     * @return 结果
     */
	@Override
	public int updateTbStuAppointment(TbStuAppointment tbStuAppointment)
	{
	    return tbStuAppointmentMapper.updateTbStuAppointment(tbStuAppointment);
	}

	/**
     * 删除学员记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTbStuAppointmentByIds(String ids)
	{
		return tbStuAppointmentMapper.deleteTbStuAppointmentByIds(Convert.toStrArray(ids));
	}

	@Override
	public int deleteTbStuAppointmentByStuId(String stuId) {
		return tbStuAppointmentMapper.deleteTbStuAppointmentByStuId(stuId);
	}


}
