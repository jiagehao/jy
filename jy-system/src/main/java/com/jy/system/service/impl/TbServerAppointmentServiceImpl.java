package com.jy.system.service.impl;

import java.util.List;

import com.jy.common.utils.StringUtils;
import com.jy.system.domain.BaseStudentinfo;
import com.jy.system.domain.TbServerAppointment;
import com.jy.system.domain.vo.BaseStudentInfoVO;
import com.jy.system.domain.vo.TbStuAppointmentVO;
import com.jy.system.mapper.BaseStudentinfoMapper;
import com.jy.system.mapper.TbServerAppointmentMapper;
import com.jy.system.service.ITbServerAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jy.common.core.text.Convert;

/**
 * 过程服务学员记录 服务层实现
 * 
 * @author jy
 * @date 2019-06-13
 */
@Service
public class TbServerAppointmentServiceImpl implements ITbServerAppointmentService
{
	@Autowired
	private TbServerAppointmentMapper tbServerAppointmentMapper;
	@Autowired
	private BaseStudentinfoMapper baseStudentinfoMapper;

	/**
     * 查询过程服务学员记录信息
     * 
     * @param id 过程服务学员记录ID
     * @return 过程服务学员记录信息
     */
    @Override
	public TbServerAppointment selectTbServerAppointmentById(String id)
	{
	    return tbServerAppointmentMapper.selectTbServerAppointmentById(id);
	}
	
	/**
     * 查询过程服务学员记录列表
     * 
     * @param tbServerAppointment 过程服务学员记录信息
     * @return 过程服务学员记录集合
     */
	@Override
	public List<TbServerAppointment> selectTbServerAppointmentList(TbServerAppointment tbServerAppointment)
	{
	    return tbServerAppointmentMapper.selectTbServerAppointmentList(tbServerAppointment);
	}
	
    /**
     * 新增过程服务学员记录
     * 
     * @param tbServerAppointment 过程服务学员记录信息
     * @return 结果
     */
	@Override
	public int insertTbServerAppointment(TbServerAppointment tbServerAppointment)
	{
		BaseStudentinfo vo = new BaseStudentinfo();
		vo.setStuId(tbServerAppointment.getStuId());
		BaseStudentinfo info = baseStudentinfoMapper.selectBaseStudentinfoById(vo.getStuId());
		if(StringUtils.isNotEmpty(info.getViolationOfDiscipline())&& tbServerAppointment.getIsfoul().equals("1")){
			int i = Integer.parseInt(info.getViolationOfDiscipline());
			++i;
			vo.setViolationOfDiscipline(i+"");
			baseStudentinfoMapper.updateBaseStudentinfo(vo);
		}
	    return tbServerAppointmentMapper.insertTbServerAppointment(tbServerAppointment);
	}
	
	/**
     * 修改过程服务学员记录
     * 
     * @param tbServerAppointment 过程服务学员记录信息
     * @return 结果
     */
	@Override
	public int updateTbServerAppointment(TbServerAppointment tbServerAppointment)
	{
	    return tbServerAppointmentMapper.updateTbServerAppointment(tbServerAppointment);
	}

	/**
     * 删除过程服务学员记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTbServerAppointmentByIds(String ids)
	{
		return tbServerAppointmentMapper.deleteTbServerAppointmentByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<TbStuAppointmentVO> selectTbServerAppointmentAll(TbServerAppointment tbServerAppointment) {
		return tbServerAppointmentMapper.selectTbServerAppointmentAll(tbServerAppointment);
	}

}
