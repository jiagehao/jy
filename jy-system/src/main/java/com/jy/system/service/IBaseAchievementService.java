package com.jy.system.service;

import com.jy.system.domain.BaseAchievement;

import java.util.List;

/**
 * 基础班学生成绩 服务层
 * 
 * @author ruoyi
 * @date 2019-04-29
 */
public interface IBaseAchievementService 
{
	/**
     * 查询基础班学生成绩信息
     * 
     * @param id 基础班学生成绩ID
     * @return 基础班学生成绩信息
     */
	public BaseAchievement selectBaseAchievementById(String id);
	
	/**
     * 查询基础班学生成绩列表
     * 
     * @param baseAchievement 基础班学生成绩信息
     * @return 基础班学生成绩集合
     */
	public List<BaseAchievement> selectBaseAchievementList(BaseAchievement baseAchievement);
	
	/**
     * 新增基础班学生成绩
     * 
     * @param baseAchievement 基础班学生成绩信息
     * @return 结果
     */
	public int insertBaseAchievement(BaseAchievement baseAchievement);
	
	/**
     * 修改基础班学生成绩
     * 
     * @param baseAchievement 基础班学生成绩信息
     * @return 结果
     */
	public int updateBaseAchievement(BaseAchievement baseAchievement);
		
	/**
     * 删除基础班学生成绩信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBaseAchievementByIds(String ids);

	public int  deleteBaseAchievementByStuId(String stuId);
}
