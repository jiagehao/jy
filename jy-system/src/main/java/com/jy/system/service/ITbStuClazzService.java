package com.jy.system.service;

import com.jy.system.domain.TbStuClazz;

import java.util.List;

/**
 * 学员班级中间 服务层
 * 
 * @author jy
 * @date 2019-04-08
 */
public interface ITbStuClazzService 
{
	/**
     * 查询学员班级中间信息
     * 
     * @param stuclazzId 学员班级中间ID
     * @return 学员班级中间信息
     */
	public TbStuClazz selectTbStuClazzById(String stuclazzId);
	
	/**
     * 查询学员班级中间列表
     * 
     * @param tbStuClazz 学员班级中间信息
     * @return 学员班级中间集合
     */
	public List<TbStuClazz> selectTbStuClazzList(TbStuClazz tbStuClazz);
	
	/**
     * 新增学员班级中间
     * 
     * @param tbStuClazz 学员班级中间信息
     * @return 结果
     */
	public int insertTbStuClazz(TbStuClazz tbStuClazz);
	
	/**
     * 修改学员班级中间
     * 
     * @param tbStuClazz 学员班级中间信息
     * @return 结果
     */
	public int updateTbStuClazz(TbStuClazz tbStuClazz);
		
	/**
     * 删除学员班级中间信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTbStuClazzByIds(String ids);
	
}
