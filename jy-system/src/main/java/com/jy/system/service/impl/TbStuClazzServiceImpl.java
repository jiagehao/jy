package com.jy.system.service.impl;


import com.jy.common.core.text.Convert;
import com.jy.system.domain.TbStuClazz;
import com.jy.system.mapper.TbStuClazzMapper;
import com.jy.system.service.ITbStuClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学员班级中间 服务层实现
 * 
 * @author jy
 * @date 2019-04-08
 */
@Service
public class TbStuClazzServiceImpl implements ITbStuClazzService
{
	@Autowired
	private TbStuClazzMapper tbStuClazzMapper;

	/**
     * 查询学员班级中间信息
     * 
     * @param stuclazzId 学员班级中间ID
     * @return 学员班级中间信息
     */
    @Override
	public TbStuClazz selectTbStuClazzById(String stuclazzId)
	{
	    return tbStuClazzMapper.selectTbStuClazzById(stuclazzId);
	}
	
	/**
     * 查询学员班级中间列表
     * 
     * @param tbStuClazz 学员班级中间信息
     * @return 学员班级中间集合
     */
	@Override
	public List<TbStuClazz> selectTbStuClazzList(TbStuClazz tbStuClazz)
	{
	    return tbStuClazzMapper.selectTbStuClazzList(tbStuClazz);
	}
	
    /**
     * 新增学员班级中间
     * 
     * @param tbStuClazz 学员班级中间信息
     * @return 结果
     */
	@Override
	public int insertTbStuClazz(TbStuClazz tbStuClazz)
	{
	    return tbStuClazzMapper.insertTbStuClazz(tbStuClazz);
	}
	
	/**
     * 修改学员班级中间
     * 
     * @param tbStuClazz 学员班级中间信息
     * @return 结果
     */
	@Override
	public int updateTbStuClazz(TbStuClazz tbStuClazz)
	{
	    return tbStuClazzMapper.updateTbStuClazz(tbStuClazz);
	}

	/**
     * 删除学员班级中间对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTbStuClazzByIds(String ids)
	{
		return tbStuClazzMapper.deleteTbStuClazzByIds(Convert.toStrArray(ids));
	}
	
}
