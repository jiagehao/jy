package com.jy.system.mapper;

import com.jy.system.domain.BaseAchievement;
import com.jy.system.domain.BaseStudentinfo;
import com.jy.system.domain.vo.BaseStudentInfoVO;
import com.jy.system.domain.vo.ServerProcessStuVO;

import java.util.List;

/**
 * 学生就业 数据层
 * 
 * @author ruoyi
 * @date 2019-04-29
 */
public interface BaseStudentinfoMapper 
{
	/**
     * 查询学生就业信息
     * 
     * @param stuId 学生就业ID
     * @return 学生就业信息
     */
	public BaseStudentinfo selectBaseStudentinfoById(String stuId);
	
	/**
     * 查询学生就业列表
     * 
     * @param baseStudentinfo 学生就业信息
     * @return 学生就业集合
     */
	public List<BaseStudentinfo> selectBaseStudentinfoList(BaseStudentinfo baseStudentinfo);
	
	/**
     * 新增学生就业
     * 
     * @param baseStudentinfo 学生就业信息
     * @return 结果
     */
	public int insertBaseStudentinfo(BaseStudentinfo baseStudentinfo);
	
	/**
     * 修改学生就业
     * 
     * @param baseStudentinfo 学生就业信息
     * @return 结果
     */
	public int updateBaseStudentinfo(BaseStudentinfo baseStudentinfo);
	
	/**
     * 删除学生就业
     * 
     * @param stuId 学生就业ID
     * @return 结果
     */
	public int deleteBaseStudentinfoById(String stuId);
	
	/**
     * 批量删除学生就业
     * 
     * @param stuIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteBaseStudentinfoByIds(String[] stuIds);

	public int getAllTeacher(BaseAchievement baseAchievement);

	/**
	 * 获取班级所有学员数据
	 * @param vo
	 * @return
	 */
    List<BaseStudentInfoVO> selectBaseStudentinfoByClazzId(BaseStudentInfoVO vo);

    int deleteBaseClazzStudentinfoByClazzId(String ids);

    List<ServerProcessStuVO> selectServerStyById(String clazzid);

}