package com.jy.system.service;


import com.jy.system.domain.SysUser;
import com.jy.system.domain.TbClazz;
import com.jy.system.domain.TbStudentinfo;
import com.jy.system.domain.vo.BaseClazzVO;
import com.jy.system.domain.vo.ClazzVO;
import com.jy.system.domain.vo.StudentInfoVO;

import java.util.List;

/**
 * 班级 服务层
 * 
 * @author jy
 * @date 2019-04-08
 */
public interface ITbClazzService 
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
     * 删除班级信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTbClazzByIds(String ids);

	/**
	 * 	导入班级学员数据
	 * @param userList
	 * @param clazzName
	 * @param subjectId
	 * @param subjectName
	 * @param begintime
	 * @param endtime
	 * @param headmasterName
	 * @return
	 */
	public String importTbStudentinfo(List<TbStudentinfo> userList, String clazzName,String subjectId,String subjectName,String begintime,String endtime,String headmasterName);


	public String importExcelCompanyName(List<StudentInfoVO> userList, String clazzId);
}
