package com.jy.system.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jy.common.exception.BusinessException;
import com.jy.common.utils.DateUtils;
import com.jy.common.utils.StringUtils;
import com.jy.common.utils.bean.UuidUtil;
import com.jy.system.domain.TbClazz;
import com.jy.system.domain.TbStuClazz;
import com.jy.system.domain.TbStudentinfo;
import com.jy.system.domain.vo.ClazzVO;
import com.jy.system.domain.vo.StudentInfoVO;
import com.jy.system.domain.vo.StudentVO;
import com.jy.system.mapper.TbClazzMapper;
import com.jy.system.mapper.TbStuClazzMapper;
import com.jy.system.mapper.TbStudentinfoMapper;
import com.jy.system.service.ITbClazzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jy.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 班级 服务层实现
 * 
 * @author jy
 * @date 2019-04-08
 */
@Service
public class TbClazzServiceImpl implements ITbClazzService
{
	private static final Logger log = LoggerFactory.getLogger(TbClazzServiceImpl.class);
	@Autowired
	private TbClazzMapper tbClazzMapper;
	@Autowired
	private TbStudentinfoMapper tbStudentinfoMapper;
	@Autowired
	private TbStuClazzMapper tbStuClazzMapper;


	/**
     * 查询班级信息
     * 
     * @param clazzId 班级ID
     * @return 班级信息
     */
    @Override
	public TbClazz selectTbClazzById(String clazzId)
	{
	    return tbClazzMapper.selectTbClazzById(clazzId);
	}
	
	/**
     * 查询班级列表
     * 
     * @param tbClazz 班级信息
     * @return 班级集合
     */
	@Override
	public List<ClazzVO> selectTbClazzLists(ClazzVO tbClazz)
	{
	    return tbClazzMapper.selectTbClazzLists(tbClazz);
	}
	@Override
	public List<TbClazz> selectTbClazzList(TbClazz tbClazz)
	{
	    return tbClazzMapper.selectTbClazzList(tbClazz);
	}
	
    /**
     * 新增班级
     * 
     * @param tbClazz 班级信息
     * @return 结果
     */
	@Override
	public int insertTbClazz(TbClazz tbClazz)
	{
	    return tbClazzMapper.insertTbClazz(tbClazz);
	}
	
	/**
     * 修改班级
     * 
     * @param tbClazz 班级信息
     * @return 结果
     */
	@Override
	public int updateTbClazz(TbClazz tbClazz)
	{
	    return tbClazzMapper.updateTbClazz(tbClazz);
	}

	/**
     * 删除班级对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTbClazzByIds(String ids)
	{
		if(Convert.toStrArray(ids).length<2){
			tbClazzMapper.deleteTbStudentinfoAll(ids);
			tbClazzMapper.delByClazzAndStu(ids);
		}
		return tbClazzMapper.deleteTbClazzByIds(Convert.toStrArray(ids));
	}

	/**
	 * 		导入班级学员数据
	 * @param userList 班级学员数据
	 * @param clazzName 班级名称
	 * @param subjectId 学科ID
	 * @param subjectName 学科名称
	 * @param begintime 开班时间
	 * @param endtime 毕业时间
	 * @param headmasterName 班主任姓名
	 * @return 返回结果
	 */
	@Transactional(rollbackFor = Exception.class)
	public String importTbStudentinfo(List<TbStudentinfo> userList, String clazzName, String subjectId, String subjectName, String begintime, String endtime, String headmasterName){
		if (StringUtils.isNull(userList) || userList.size() == 0)
		{
			throw new BusinessException("导入用户数据不能为空！");
		}

		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		List<String> s = new ArrayList<>();
		s.add(clazzName);
		s.add(subjectId);
		s.add(subjectName);
		s.add(begintime);
		s.add(endtime);
		s.add(headmasterName);
		if (!DateUtils.isValidDate(begintime))
		{
			failureMsg.append("<br/>" + "抱歉，出现异常，开班时间格式有误，请从新输入！");
		}
		if (!DateUtils.isValidDate(endtime))
		{
			failureMsg.append("<br/>" + "抱歉，出现异常，毕业时间格式有误，请从新输入！");
		}
		String[] arr = {"班级名称","学科ID","学科名称","开班时间","结课时间","班主任名称"};
		for(int i=0;i<s.size();i++){
			if(StringUtils.isEmpty(s.get(i))){
				failureMsg.append("<br/>" + "抱歉，出现异常，["+arr[i]+"]不能为空，请从新输入！");

			}
		}
		if(StringUtils.isNotEmpty(failureMsg)){
			throw new BusinessException(failureMsg.toString());
		}
		TbClazz tbClazz = new TbClazz();
		tbClazz.setClazzId(UuidUtil.get32UUID());
		tbClazz.setClazzname(clazzName);
		tbClazz.setSubjectId(subjectId);
		tbClazz.setSubjectname(subjectName);
		tbClazz.setBegintime(begintime);
		tbClazz.setEndtime(endtime);
		tbClazz.setHeadmasterName(headmasterName);
		this.insertTbClazz(tbClazz);
		TbStuClazz sc = new TbStuClazz();
		for (TbStudentinfo info : userList)
		{
			try
			{
				info.setStuId(UuidUtil.get32UUID());
				info.setName(info.getName().trim());
				info.setEducation(info.getEducation().trim());
				info.setGraduateschool(info.getGraduateschool().trim());
				info.setIsLoan(info.getIsLoan().trim());
				info.setIsWork(info.getIsWork().trim());
				info.setMajor(info.getMajor().trim());
				if(info.getGraduationTime().length()>10){
					Date date = new Date(info.getGraduationTime());
					String time = new SimpleDateFormat("yyyy-MM-dd").format(date);
					info.setGraduationTime(time);
				}
				sc.setClazzId(tbClazz.getClazzId());
				sc.setStuId(info.getStuId());
				sc.setStuclazzId(UuidUtil.get32UUID());
				tbStuClazzMapper.insertTbStuClazz(sc);
				tbStudentinfoMapper.insertTbStudentinfo(info);
				successNum++;
				successMsg.append("<br/>" + successNum + "、学员 " + info.getName() + " 导入成功");
			}
			catch (Exception e)
			{
				failureNum++;
				String msg = "<br/>" + failureNum + "、学员 " + info.getName() + " 导入失败：";
				failureMsg.append(msg + e.getMessage());
				log.error(msg, e);
			}
		}
		if (failureNum > 0)
		{
			failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
			throw new BusinessException(failureMsg.toString());
		}
		else
		{
			successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
		}
		return successMsg.toString();
	}

	@Transactional(rollbackFor = Exception.class)
	public String importExcelCompanyName(List<StudentInfoVO> userList, String clazzId){
		if (StringUtils.isNull(userList) || userList.size() == 0)
		{
			throw new BusinessException("导入用户数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		StudentInfoVO infos = new StudentInfoVO();
		infos.setClazzId(clazzId);
		TbStuClazz sc = new TbStuClazz();
		for (StudentInfoVO info : userList)
		{
			try
			{
				infos.setName(info.getName());
				StudentVO studentVOS = tbStudentinfoMapper.selectTbStudentinfoByClazzId(infos);
				TbStudentinfo tbStudentinfo = new TbStudentinfo();
				tbStudentinfo.setStuId(studentVOS.getStuId());
				tbStudentinfo.setCompanyname(info.getCompanyname());
				tbStudentinfo.setSalary(info.getSalary());
				tbStudentinfo.setEntrytime(info.getEntrytime());
				tbStudentinfoMapper.updateTbStudentinfo(tbStudentinfo);
				successNum++;
				successMsg.append("<br/>" + successNum + "、学员： " + info.getName() + " 导入成功");
			}
			catch (Exception e)
			{
				failureNum++;
				String msg = "<br/>" + failureNum + "、学员： " + info.getName() + " 导入失败：";
				failureMsg.append(msg + e.getMessage());
				log.error(msg, e);
			}
		}
		if (failureNum > 0)
		{
			failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
			throw new BusinessException(failureMsg.toString());
		}
		else
		{
			successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
		}
		return successMsg.toString();
	}
}
