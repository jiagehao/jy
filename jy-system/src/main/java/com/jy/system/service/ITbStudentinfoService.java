package com.jy.system.service;

import com.jy.system.domain.TbStudentinfo;
import com.jy.system.domain.vo.PersonalVO;
import com.jy.system.domain.vo.StuGroupVO;
import com.jy.system.domain.vo.StudentVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 学员 服务层
 * 
 * @author jy
 * @date 2019-04-08
 */
@Transactional(rollbackFor = Exception.class)
public interface ITbStudentinfoService 
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
     * @param vo 学员信息
     * @return 学员集合
     */
	public List<StudentVO> selectTbStudentinfoLists(StudentVO vo);
	public List<TbStudentinfo> selectTbStudentinfoList(TbStudentinfo tbStudentinfo);

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
     * 删除学员信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTbStudentinfoByIds(String ids);

	/**
	 * 获取班级个人就业率
	 * @param clazzId 班级ID
	 * @return 结果
	 */
	public List<PersonalVO> getPersonalRateOfEmployment(String clazzId);

	/**
	 *  导入分组
	 * @param userList Excel数据
	 * @return
	 */
	String importTbStudentinfo(List<StuGroupVO> userList,String clazzId);

    List<StudentVO> selectStuNoEmployment(StudentVO vo);
}
