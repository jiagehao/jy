package com.jy.system.service.impl;

import java.util.List;

import com.jy.common.core.text.Convert;
import com.jy.system.domain.BaseStuClazz;
import com.jy.system.mapper.BaseStuClazzMapper;
import com.jy.system.service.IBaseStuClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 学生班级 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-29
 */
@Service
public class BaseStuClazzServiceImpl implements IBaseStuClazzService
{
	@Autowired
	private BaseStuClazzMapper baseStuClazzMapper;

	/**
     * 查询学生班级信息
     * 
     * @param stuclazzId 学生班级ID
     * @return 学生班级信息
     */
    @Override
	public BaseStuClazz selectBaseStuClazzById(String stuclazzId)
	{
	    return baseStuClazzMapper.selectBaseStuClazzById(stuclazzId);
	}
	
	/**
     * 查询学生班级列表
     * 
     * @param baseStuClazz 学生班级信息
     * @return 学生班级集合
     */
	@Override
	public List<BaseStuClazz> selectBaseStuClazzList(BaseStuClazz baseStuClazz)
	{
	    return baseStuClazzMapper.selectBaseStuClazzList(baseStuClazz);
	}
	
    /**
     * 新增学生班级
     * 
     * @param baseStuClazz 学生班级信息
     * @return 结果
     */
	@Override
	public int insertBaseStuClazz(BaseStuClazz baseStuClazz)
	{
	    return baseStuClazzMapper.insertBaseStuClazz(baseStuClazz);
	}
	
	/**
     * 修改学生班级
     * 
     * @param baseStuClazz 学生班级信息
     * @return 结果
     */
	@Override
	public int updateBaseStuClazz(BaseStuClazz baseStuClazz)
	{
	    return baseStuClazzMapper.updateBaseStuClazz(baseStuClazz);
	}

	/**
     * 删除学生班级对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBaseStuClazzByIds(String ids)
	{
		return baseStuClazzMapper.deleteBaseStuClazzByIds(Convert.toStrArray(ids));
	}

	@Override
	public int deleteBaseStuClazzByStuId(String stuId) {
		return baseStuClazzMapper.deleteBaseStuClazzByStuId(stuId);
	}

}
