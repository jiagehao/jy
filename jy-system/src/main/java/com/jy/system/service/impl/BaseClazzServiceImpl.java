package com.jy.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jy.common.core.text.Convert;
import com.jy.common.exception.BusinessException;
import com.jy.common.utils.DateUtils;
import com.jy.common.utils.StringUtils;
import com.jy.common.utils.bean.UuidUtil;
import com.jy.system.domain.*;
import com.jy.system.domain.vo.BaseClazzVO;
import com.jy.system.domain.vo.BaseStuExcelVO;
import com.jy.system.domain.vo.ServiceProcessVO;
import com.jy.system.mapper.BaseAchievementMapper;
import com.jy.system.mapper.BaseClazzMapper;
import com.jy.system.mapper.BaseStuClazzMapper;
import com.jy.system.mapper.BaseStudentinfoMapper;
import com.jy.system.service.IBaseClazzService;
import com.jy.system.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 学生班级 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-29
 */
@Service
public class BaseClazzServiceImpl implements IBaseClazzService
{private static final Logger log = LoggerFactory.getLogger(TbClazzServiceImpl.class);
	@Autowired
	private BaseClazzMapper baseClazzMapper;
	@Autowired
	private BaseStuClazzMapper baseStuClazzMapper;
	@Autowired
	private BaseStudentinfoMapper baseStudentinfoMapper;
	@Autowired
	private BaseAchievementMapper baseAchievementMapper;
	@Autowired
	private ISysUserService iSysUserService;
	/**
	 * 查询基础班班级信息
	 *
	 * @param clazzId 基础班班级ID
	 * @return 基础班班级信息
	 */
	@Override
	public BaseClazz selectBaseClazzById(String clazzId)
	{
		return baseClazzMapper.selectBaseClazzById(clazzId);
	}

	/**
	 * 查询基础班班级列表
	 *
	 * @param BaseClazz 基础班班级信息
	 * @return 基础班班级集合
	 */
	@Override
	public List<BaseClazz> selectBaseClazzList(BaseClazz BaseClazz)
	{
		return baseClazzMapper.selectBaseClazzList(BaseClazz);
	}

	/**
	 * 新增基础班班级
	 *
	 * @param BaseClazz 基础班班级信息
	 * @return 结果
	 */
	@Override
	public int insertBaseClazz(BaseClazz BaseClazz)
	{
		return baseClazzMapper.insertBaseClazz(BaseClazz);
	}

	/**
	 * 修改基础班班级
	 *
	 * @param BaseClazz 基础班班级信息
	 * @return 结果
	 */
	@Override
	public int updateBaseClazz(BaseClazz BaseClazz)
	{
		return baseClazzMapper.updateBaseClazz(BaseClazz);
	}

	/**
	 * 删除基础班班级对象
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteBaseClazzByIds(String ids)
	{
		baseStudentinfoMapper.deleteBaseClazzStudentinfoByClazzId(ids);
		baseStuClazzMapper.deleteBaseStuClazzByIds(Convert.toStrArray(ids));
		return baseClazzMapper.deleteBaseClazzByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<BaseClazzVO> selectBaseClazzListAll(BaseClazzVO vo) {
		return baseClazzMapper.selectBaseClazzListAll(vo);
	}

	@Override
	public String importTbStudentinfo(List<BaseStuExcelVO> userList, String clazzName, String subjectId, String subjectName, String begintime, String endtime, String headmasterName, String assistantname, String lecturername) {
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
		s.add(assistantname);
		if (!DateUtils.isValidDate(begintime))
		{
			failureMsg.append("<br/>" + "抱歉，出现异常，开班时间格式有误，请从新输入！");
		}
		if (!DateUtils.isValidDate(endtime))
		{
			failureMsg.append("<br/>" + "抱歉，出现异常，毕业时间格式有误，请从新输入！");
		}
		String[] arr = {"班级名称","学科ID","学科名称","基础班开班时间","基础班毕业时间","班主任名称","助教姓名","讲师姓名"};
		for(int i=0;i<s.size();i++){
			if(StringUtils.isEmpty(s.get(i))){
				failureMsg.append("<br/>" + "抱歉，出现异常，["+arr[i]+"]不能为空，请从新输入！");

			}
		}
		if(StringUtils.isNotEmpty(failureMsg)){
			throw new BusinessException(failureMsg.toString());
		}
		BaseClazz tbClazz = new BaseClazz();
		tbClazz.setClazzId(UuidUtil.get32UUID());
		tbClazz.setClazzname(clazzName);
		tbClazz.setSubjectId(subjectId);
		tbClazz.setSubjectname(subjectName);
		tbClazz.setBegintime(begintime);
		tbClazz.setEndtime(endtime);
		tbClazz.setHeadmasterName(headmasterName);
		tbClazz.setAssistantname(assistantname);
		tbClazz.setLecturername(lecturername);
		this.insertBaseClazz(tbClazz);
		BaseStuClazz sc = new BaseStuClazz();
		//BaseStudentinfo
		BaseStudentinfo i = new BaseStudentinfo();

		for (BaseStuExcelVO info : userList)
		{
			try
			{
				i.setStuId(UuidUtil.get32UUID());
				i.setName(info.getUserName().trim());
				i.setSex(info.getSex());
				i.setAge(info.getAge());
				i.setPhonenumber(info.getPhonenumber());
				i.setqQnumber(info.getqQnumber());
				i.setEducation(info.getEducation().trim());
				i.setGraduateschool(info.getGraduateschool().trim());
				i.setEducation(info.getEducation());
				i.setIdnumber(info.getIdnumber());
				i.setIdnumberAddress(info.getIdnumberAddress());
				sc.setClazzId(tbClazz.getClazzId());
				sc.setStuId(i.getStuId());
				sc.setStuclazzId(UuidUtil.get32UUID());

				setNum(i,subjectName);
				baseStuClazzMapper.insertBaseStuClazz(sc);
				baseStudentinfoMapper.insertBaseStudentinfo(i);
				successNum++;
				successMsg.append("<br/>" + successNum + "、学员 " + info.getUserName() + " 导入成功");
			}
			catch (Exception e)
			{
				failureNum++;
				String msg = "<br/>" + failureNum + "、学员 " + info.getUserName() + " 导入失败：";
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

	@Override
	public List<ServiceProcessVO> selectServiceProcessById(ServiceProcessVO vo) {
		return baseClazzMapper.selectServiceProcessById(vo);
	}

	@Override
	public List<ServiceProcessVO> selectClazzByclazzName(ServiceProcessVO vo) {
		return baseClazzMapper.selectClazzByclazzName(vo);
	}

	@Override
	public int updateBaseClazzServer(ServiceProcessVO vo) {
		if(StringUtils.isEmpty(vo.getIsprocess())){
			StringBuilder failureMsg = new StringBuilder();
			if(StringUtils.isEmpty(vo.getClazzid())){
				failureMsg.append("<br/>" + "抱歉，出现异常，请联系管理员！");
			}
			if(StringUtils.isEmpty(vo.getEmpname())){
				failureMsg.append("<br/>" + "抱歉，请正确填写就业老师名称！");
			}
			if (!DateUtils.isValidDate(vo.getEstimate()))
			{
				failureMsg.append("<br/>" + "请正确填写开班时间！格式：2019-09-09");
			}
			if(StringUtils.isNotEmpty(failureMsg)){
				throw new BusinessException(failureMsg.toString());
			}
			vo.setIsprocess("1");
		}
		return baseClazzMapper.updateBaseClazzServer(vo);
	}

	@Override
	public ServiceProcessVO selectClazzByServerId(String clazzId) {
		return baseClazzMapper.selectClazzByServerId(clazzId);
	}

	private BaseAchievement setNum(BaseStudentinfo studentinfo,String subjectName){
		String num = "100";
		String nums = "100";
		BaseAchievement ba = new BaseAchievement();
		if("JavaEE学科".equals(subjectName)||"PHP学科".equals(subjectName)){
			num="110";
		}

		for(int i=0;i<2;i++){
			if(i==0){
				ba.setOne(nums);
				ba.setTwo(nums);
				ba.setThree(nums);
				ba.setFour(nums);
				ba.setFive(nums);
				ba.setSix(nums);
				ba.setSeven(nums);
				ba.setNine(nums);
				ba.setEight(nums);
				ba.setTen(nums);
				getBaseClazzDay(subjectName,ba,nums);
				ba.setId(UuidUtil.get32UUID());
				ba.setCategory("日常表现");
				ba.setStuId(studentinfo.getStuId());
				baseAchievementMapper.insertBaseAchievement(ba);
			}else if(i==1){
				ba.setOne(num);
				ba.setTwo(num);
				ba.setThree(num);
				ba.setFour(num);
				ba.setFive(num);
				ba.setSix(num);
				ba.setSeven(num);
				ba.setNine(num);
				ba.setEight(num);
				ba.setTen(num);
				getBaseClazzDay(subjectName,ba,num);
				ba.setId(UuidUtil.get32UUID());
				ba.setCategory("代码量");
				ba.setStuId(studentinfo.getStuId());
				baseAchievementMapper.insertBaseAchievement(ba);
			}
		}
		return ba;
	}
	private void getBaseClazzDay(String subjectName,BaseAchievement b,String nums){
		if("JavaEE学科".equals(subjectName)){
			b.setEleven(nums);
		}else if("大数据学科".equals(subjectName)){
			b.setEleven(nums);
			b.setTwelve(nums);
			b.setThirteen(nums);
			b.setFourteen(nums);
		}else if("Python学科".equals(subjectName)){
			b.setEleven(nums);
			b.setTwelve(nums);
			b.setThirteen(nums);
		}else if("前端学科".equals(subjectName)){
			b.setEleven(nums);
			b.setTwelve(nums);
		}else if("PHP学科".equals(subjectName)){
			b.setEleven(nums);
			b.setTwelve(nums);
			b.setThirteen(nums);
		}
	}
}
