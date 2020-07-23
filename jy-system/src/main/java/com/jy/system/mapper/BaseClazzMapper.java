package com.jy.system.mapper;

import com.jy.system.domain.BaseClazz;
import com.jy.system.domain.vo.BaseClazzVO;
import com.jy.system.domain.vo.ServiceProcessVO;

import java.util.List;

/**
 * 学生班级 数据层
 * 
 * @author ruoyi
 * @date 2019-04-29
 */
public interface BaseClazzMapper 
{
	/**
	 * 查询基础班班级信息
	 *
	 * @param clazzId 基础班班级ID
	 * @return 基础班班级信息
	 */
	public BaseClazz selectBaseClazzById(String clazzId);

	/**
	 * 查询基础班班级列表
	 *
	 * @param BaseClazz 基础班班级信息
	 * @return 基础班班级集合
	 */
	public List<BaseClazz> selectBaseClazzList(BaseClazz BaseClazz);

	/**
	 * 新增基础班班级
	 *
	 * @param BaseClazz 基础班班级信息
	 * @return 结果
	 */
	public int insertBaseClazz(BaseClazz BaseClazz);

	/**
	 * 修改基础班班级
	 *
	 * @param BaseClazz 基础班班级信息
	 * @return 结果
	 */
	public int updateBaseClazz(BaseClazz BaseClazz);

	/**
	 * 删除基础班班级
	 *
	 * @param clazzId 基础班班级ID
	 * @return 结果
	 */
	public int deleteBaseClazzById(String clazzId);

	/**
	 * 批量删除基础班班级
	 *
	 * @param clazzIds 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteBaseClazzByIds(String[] clazzIds);

    List<BaseClazzVO> selectBaseClazzListAll(BaseClazzVO vo);

    List<ServiceProcessVO> selectServiceProcessById(ServiceProcessVO vo);

    List<ServiceProcessVO> selectClazzByclazzName(ServiceProcessVO vo);

	int updateBaseClazzServer(ServiceProcessVO vo);

    ServiceProcessVO selectClazzByServerId(String clazzId);
}