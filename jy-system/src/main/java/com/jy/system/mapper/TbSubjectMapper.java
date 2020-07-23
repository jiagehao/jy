package com.jy.system.mapper;


import com.jy.system.domain.TbSubject;

import java.util.List;

/**
 * 学科 数据层
 * 
 * @author jy
 * @date 2019-04-08
 */
public interface TbSubjectMapper 
{
	/**
     * 查询学科信息
     * 
     * @param subjectId 学科ID
     * @return 学科信息
     */
	public TbSubject selectTbSubjectById(String subjectId);
	
	/**
     * 查询学科列表
     * 
     * @param tbSubject 学科信息
     * @return 学科集合
     */
	public List<TbSubject> selectTbSubjectList(TbSubject tbSubject);
	
	/**
     * 新增学科
     * 
     * @param tbSubject 学科信息
     * @return 结果
     */
	public int insertTbSubject(TbSubject tbSubject);
	
	/**
     * 修改学科
     * 
     * @param tbSubject 学科信息
     * @return 结果
     */
	public int updateTbSubject(TbSubject tbSubject);
	
	/**
     * 删除学科
     * 
     * @param subjectId 学科ID
     * @return 结果
     */
	public int deleteTbSubjectById(String subjectId);
	
	/**
     * 批量删除学科
     * 
     * @param subjectIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTbSubjectByIds(String[] subjectIds);

	/**
	 * 查询学科
	 * @return
	 */
    List<TbSubject> TbSubjectList();
}