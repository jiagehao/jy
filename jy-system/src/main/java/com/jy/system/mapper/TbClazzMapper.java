package com.jy.system.mapper;

import com.jy.system.domain.TbClazz;
import com.jy.system.domain.vo.ClazzVO;

import java.util.List;


/**
 * 班级 数据层
 * 
 * @author jy
 * @date 2019-04-08
 */
public interface TbClazzMapper 
{
	/**
     * 查询班级信息
     * 
     * @param clazzId 班级ID
     * @return 班级信息
     */
	public TbClazz selectTbClazzById(String clazzId);
	
	/**
     * 查询班级列表
     * 
     * @param tbClazz 班级信息
     * @return 班级集合
     */
	public List<ClazzVO> selectTbClazzLists(ClazzVO tbClazz);
	public List<TbClazz> selectTbClazzList(TbClazz tbClazz);

	/**
     * 新增班级
     * 
     * @param tbClazz 班级信息
     * @return 结果
     */
	public int insertTbClazz(TbClazz tbClazz);
	
	/**
     * 修改班级
     * 
     * @param tbClazz 班级信息
     * @return 结果
     */
	public int updateTbClazz(TbClazz tbClazz);
	
	/**
     * 删除班级
     * 
     * @param clazzId 班级ID
     * @return 结果
     */
	public int deleteTbClazzById(String clazzId);
	
	/**
     * 批量删除班级
     * 
     * @param clazzIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTbClazzByIds(String[] clazzIds);

    void deleteTbStudentinfoAll(String strings);

	void delByClazzAndStu(String strings);
}