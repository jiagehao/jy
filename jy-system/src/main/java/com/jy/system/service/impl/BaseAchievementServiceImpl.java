package com.jy.system.service.impl;

import java.util.List;

import com.jy.common.core.text.Convert;
import com.jy.system.domain.BaseAchievement;
import com.jy.system.mapper.BaseAchievementMapper;
import com.jy.system.service.IBaseAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 基础班学生成绩 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-29
 */
@Service
public class BaseAchievementServiceImpl implements IBaseAchievementService
{
	@Autowired
	private BaseAchievementMapper baseAchievementMapper;

	/**
     * 查询基础班学生成绩信息
     * 
     * @param id 基础班学生成绩ID
     * @return 基础班学生成绩信息
     */
    @Override
	public BaseAchievement selectBaseAchievementById(String id)
	{
	    return baseAchievementMapper.selectBaseAchievementById(id);
	}
	
	/**
     * 查询基础班学生成绩列表
     * 
     * @param baseAchievement 基础班学生成绩信息
     * @return 基础班学生成绩集合
     */
	@Override
	public List<BaseAchievement> selectBaseAchievementList(BaseAchievement baseAchievement)
	{
	    return baseAchievementMapper.selectBaseAchievementList(baseAchievement);
	}
	
    /**
     * 新增基础班学生成绩
     * 
     * @param baseAchievement 基础班学生成绩信息
     * @return 结果
     */
	@Override
	public int insertBaseAchievement(BaseAchievement baseAchievement)
	{
	    return baseAchievementMapper.insertBaseAchievement(baseAchievement);
	}
	
	/**
     * 修改基础班学生成绩
     * 
     * @param baseAchievement 基础班学生成绩信息
     * @return 结果
     */
	@Override
	public int updateBaseAchievement(BaseAchievement baseAchievement)
	{
	    return baseAchievementMapper.updateBaseAchievement(baseAchievement);
	}

	/**
     * 删除基础班学生成绩对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBaseAchievementByIds(String ids)
	{
		return baseAchievementMapper.deleteBaseAchievementByIds(Convert.toStrArray(ids));
	}

	@Override
	public int deleteBaseAchievementByStuId(String stuId) {
		return baseAchievementMapper.deleteBaseAchievementByStuId(stuId);
	}

}
