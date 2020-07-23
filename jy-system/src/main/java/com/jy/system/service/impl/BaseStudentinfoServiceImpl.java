package com.jy.system.service.impl;

import java.util.List;

import com.jy.common.core.text.Convert;
import com.jy.system.domain.BaseStudentinfo;
import com.jy.system.domain.TbSubject;
import com.jy.system.domain.vo.BaseStudentInfoVO;
import com.jy.system.domain.vo.ServerProcessStuVO;
import com.jy.system.mapper.BaseStudentinfoMapper;
import com.jy.system.mapper.TbSubjectMapper;
import com.jy.system.service.IBaseStudentinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 学生就业 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-29
 */
@Service
public class BaseStudentinfoServiceImpl implements IBaseStudentinfoService
{
	@Autowired
	private BaseStudentinfoMapper baseStudentinfoMapper;
	@Autowired
	private TbSubjectMapper tbSubjectMapper;

	/**
     * 查询学生就业信息
     * 
     * @param stuId 学生就业ID
     * @return 学生就业信息
     */
    @Override
	public BaseStudentinfo selectBaseStudentinfoById(String stuId)
	{
	    return baseStudentinfoMapper.selectBaseStudentinfoById(stuId);
	}
	
	/**
     * 查询学生就业列表
     * 
     * @param baseStudentinfo 学生就业信息
     * @return 学生就业集合
     */
	@Override
	public List<BaseStudentinfo> selectBaseStudentinfoList(BaseStudentinfo baseStudentinfo)
	{
	    return baseStudentinfoMapper.selectBaseStudentinfoList(baseStudentinfo);
	}
	
    /**
     * 新增学生就业
     * 
     * @param baseStudentinfo 学生就业信息
     * @return 结果
     */
	@Override
	public int insertBaseStudentinfo(BaseStudentinfo baseStudentinfo)
	{
	    return baseStudentinfoMapper.insertBaseStudentinfo(baseStudentinfo);
	}
	
	/**
     * 修改学生就业
     * 
     * @param baseStudentinfo 学生就业信息
     * @return 结果
     */
	@Override
	public int updateBaseStudentinfo(BaseStudentinfo baseStudentinfo)
	{
	    return baseStudentinfoMapper.updateBaseStudentinfo(baseStudentinfo);
	}

	/**
     * 删除学生就业对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBaseStudentinfoByIds(String ids)
	{
		return baseStudentinfoMapper.deleteBaseStudentinfoByIds(Convert.toStrArray(ids));
	}

	@Override
	public int deleteBaseStudentinfoById(String stuId) {
		return baseStudentinfoMapper.deleteBaseStudentinfoById(stuId);
	}

	/**
	 * 获取班级所有学员数据
	 * @param vo
	 * @return
	 */
	@Override
	public List<BaseStudentInfoVO> selectBaseStudentinfoByClazzId(BaseStudentInfoVO vo) {
		TbSubject s = new TbSubject();
		s.setSubjectId(vo.getSubjectId());
		List<TbSubject> tbSubjects = tbSubjectMapper.selectTbSubjectList(s);
		vo.setNum(Integer.parseInt(tbSubjects.get(0).getSubjectday()));
		return baseStudentinfoMapper.selectBaseStudentinfoByClazzId(vo);
	}

	@Override
	public List<ServerProcessStuVO> selectServerStyById(String clazzid) {
		return baseStudentinfoMapper.selectServerStyById(clazzid);
	}

}
