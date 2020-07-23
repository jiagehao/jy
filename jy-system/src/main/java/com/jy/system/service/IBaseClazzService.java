package com.jy.system.service;

import com.jy.system.domain.BaseClazz;
import com.jy.system.domain.BaseStudentinfo;
import com.jy.system.domain.TbStudentinfo;
import com.jy.system.domain.vo.BaseClazzVO;
import com.jy.system.domain.vo.BaseStuExcelVO;
import com.jy.system.domain.vo.ServiceProcessVO;

import java.util.List;

/**
 * 学生班级 服务层
 * 
 * @author ruoyi
 * @date 2019-04-29
 */
public interface IBaseClazzService 
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
	 * 删除基础班班级信息
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteBaseClazzByIds(String ids);

	List<BaseClazzVO> selectBaseClazzListAll(BaseClazzVO vo);

	/**
	 *添加班级
	 * @param userList Excel文件数据
	 * @param clazzName 班级名称
	 * @param subjectId 学科ID
	 * @param subjectName 学科名称
	 * @param begintime 开班时间
	 * @param endtime 结课时间
	 * @param headmasterName 班主任姓名
	 * @param assistantname 助教
	 * @param lecturername 讲师
	 * @return
	 */
    String importTbStudentinfo(List<BaseStuExcelVO> userList, String clazzName, String subjectId, String subjectName, String begintime, String endtime, String headmasterName, String assistantname, String lecturername);

    List<ServiceProcessVO> selectServiceProcessById(ServiceProcessVO vo);

    List<ServiceProcessVO> selectClazzByclazzName(ServiceProcessVO vo);

	int updateBaseClazzServer(ServiceProcessVO vo);

    ServiceProcessVO selectClazzByServerId(String clazzId);
}
