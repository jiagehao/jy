package com.jy.system.mapper;

import com.jy.system.domain.BaseStuClazz;

import java.util.List;

/**
 * 学生班级 数据层
 * 
 * @author ruoyi
 * @date 2019-04-29
 */
public interface BaseStuClazzMapper 
{
	/**
     * 查询学生班级信息
     * 
     * @param stuclazzId 学生班级ID
     * @return 学生班级信息
     */
	public BaseStuClazz selectBaseStuClazzById(String stuclazzId);
	
	/**
     * 查询学生班级列表
     * 
     * @param baseStuClazz 学生班级信息
     * @return 学生班级集合
     */
	public List<BaseStuClazz> selectBaseStuClazzList(BaseStuClazz baseStuClazz);
	
	/**
     * 新增学生班级
     * 
     * @param baseStuClazz 学生班级信息
     * @return 结果
     */
	public int insertBaseStuClazz(BaseStuClazz baseStuClazz);
	
	/**
     * 修改学生班级
     * 
     * @param baseStuClazz 学生班级信息
     * @return 结果
     */
	public int updateBaseStuClazz(BaseStuClazz baseStuClazz);
	
	/**
     * 删除学生班级
     * 
     * @param stuclazzId 学生班级ID
     * @return 结果
     */
	public int deleteBaseStuClazzById(String stuclazzId);
	
	/**
     * 批量删除学生班级
     * 
     * @param stuclazzIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteBaseStuClazzByIds(String[] stuclazzIds);

	/**
	 * 删除学生班级信息
	 *
	 * @param stuId 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteBaseStuClazzByStuId(String stuId);
	
}