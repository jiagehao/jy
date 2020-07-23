package com.jy.system.mapper;


import com.jy.system.domain.TbStudentinfo;
import com.jy.system.domain.vo.PersonalVO;
import com.jy.system.domain.vo.StudentInfoVO;
import com.jy.system.domain.vo.StudentVO;

import java.util.List;

/**
 * 学员 数据层
 * 
 * @author jy
 * @date 2019-04-08
 */
public interface TbStudentinfoMapper
{
	/**
     * 查询学员信息
     * 
     * @param stuId 学员ID
     * @return 学员信息
     */
	public TbStudentinfo selectTbStudentinfoById(String stuId);
	
	/**
     * 查询学员列表
     * 
     * @param tbStudentinfo 学员信息
     * @return 学员集合
     */
	public List<TbStudentinfo> selectTbStudentinfoList(TbStudentinfo tbStudentinfo);
	public List<StudentVO> selectTbStudentinfoLists(StudentVO vo);

	/**
     * 新增学员
     * 
     * @param tbStudentinfo 学员信息
     * @return 结果
     */
	public int insertTbStudentinfo(TbStudentinfo tbStudentinfo);
	
	/**
     * 修改学员
     * 
     * @param tbStudentinfo 学员信息
     * @return 结果
     */
	public int updateTbStudentinfo(TbStudentinfo tbStudentinfo);
	
	/**
     * 删除学员
     * 
     * @param stuId 学员ID
     * @return 结果
     */
	public int deleteTbStudentinfoById(String stuId);
	
	/**
     * 批量删除学员
     * 
     * @param stuIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTbStudentinfoByIds(String[] stuIds);

	/**
	 * 获取班级个人就业率
	 * @param clazzId 班级ID
	 * @return 结果
	 */
	public List<PersonalVO> getPersonalRateOfEmployment(String clazzId);

    public TbStudentinfo selectTbStudentinfoByUserId(TbStudentinfo stu);

    List<StudentVO> selectStuNoEmployment(StudentVO vo);

	/**
	 * 获取班级学员姓名和id
	 * @param vo
	 * @return
	 */
	StudentVO selectTbStudentinfoByClazzId(StudentInfoVO vo);


}