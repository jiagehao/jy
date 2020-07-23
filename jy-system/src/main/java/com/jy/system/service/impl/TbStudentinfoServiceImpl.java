package com.jy.system.service.impl;


import com.jy.common.core.text.Convert;
import com.jy.common.exception.BusinessException;
import com.jy.common.utils.StringUtils;
import com.jy.common.utils.bean.UuidUtil;
import com.jy.system.domain.SysUser;
import com.jy.system.domain.TbStuClazz;
import com.jy.system.domain.TbStudentinfo;
import com.jy.system.domain.vo.PersonalVO;
import com.jy.system.domain.vo.StuGroupVO;
import com.jy.system.domain.vo.StudentVO;
import com.jy.system.mapper.SysUserMapper;
import com.jy.system.mapper.TbStuAppointmentMapper;
import com.jy.system.mapper.TbStuClazzMapper;
import com.jy.system.mapper.TbStudentinfoMapper;
import com.jy.system.service.ITbStudentinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学员 服务层实现
 * 
 * @author jy
 * @date 2019-04-08
 */
@Service

public class TbStudentinfoServiceImpl implements ITbStudentinfoService
{
	private static final Logger log = LoggerFactory.getLogger(TbStudentinfoServiceImpl.class);
	@Autowired
	private TbStudentinfoMapper tbStudentinfoMapper;
	@Autowired
	private TbStuClazzMapper tbStuClazzMapper;
	@Autowired
	private TbStuAppointmentMapper tbStuAppointmentMapper;
	@Autowired
	private SysUserMapper sysUserMapper;

	/**
     * 查询学员信息
     * 
     * @param stuId 学员ID
     * @return 学员信息
     */
    @Override
	public TbStudentinfo selectTbStudentinfoById(String stuId)
	{
	    return tbStudentinfoMapper.selectTbStudentinfoById(stuId);
	}

	@Override
	public List<StudentVO> selectTbStudentinfoLists(StudentVO vo) {
		return tbStudentinfoMapper.selectTbStudentinfoLists(vo);
	}

	/**
     * 查询学员列表
     * 
     * @param tbStudentinfo 学员信息
     * @return 学员集合
     */
	@Override
	public List<TbStudentinfo> selectTbStudentinfoList(TbStudentinfo tbStudentinfo)
	{
	    return tbStudentinfoMapper.selectTbStudentinfoList(tbStudentinfo);
	}
	
    /**
     * 新增学员
     * 
     * @param tbStudentinfo 学员信息
     * @return 结果
     */
	@Override
	public int insertTbStudentinfo(TbStudentinfo tbStudentinfo)
	{
		tbStudentinfo.setStuId(UuidUtil.get32UUID());
		TbStuClazz tbStuClazz = new TbStuClazz();
		tbStuClazz.setStuclazzId(UuidUtil.get32UUID());
		tbStuClazz.setClazzId(tbStudentinfo.getClazzId());
		tbStuClazz.setStuId(tbStudentinfo.getStuId());
		tbStuClazzMapper.insertTbStuClazz(tbStuClazz);
	    return tbStudentinfoMapper.insertTbStudentinfo(tbStudentinfo);
	}
	
	/**
     * 修改学员
     * 
     * @param tbStudentinfo 学员信息
     * @return 结果
     */
	@Override
	public int updateTbStudentinfo(TbStudentinfo tbStudentinfo)
	{
		if(StringUtils.isNotEmpty(tbStudentinfo.getCompanyname())){
			tbStudentinfo.setEmployment(1);
		}else{
			tbStudentinfo.setEmployment(0);
		}
	    return tbStudentinfoMapper.updateTbStudentinfo(tbStudentinfo);
	}

	/**
     * 删除学员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTbStudentinfoByIds(String ids)
	{
		tbStuAppointmentMapper.deleteTbStuAppointmentByIds(Convert.toStrArray(ids));
		tbStuClazzMapper.deleteTbStuClazzByIds(Convert.toStrArray(ids));
		return tbStudentinfoMapper.deleteTbStudentinfoByIds(Convert.toStrArray(ids));
	}

	/**
	 * 获取班级个人就业率
	 * @param clazzId 班级ID
	 * @return 结果
	 */
	@Override
	public List<PersonalVO> getPersonalRateOfEmployment(String clazzId) {
		return tbStudentinfoMapper.getPersonalRateOfEmployment(clazzId);
	}

	@Override
	public String importTbStudentinfo(List<StuGroupVO> userList,String clazzId) {
		if (StringUtils.isNull(userList) || userList.size() == 0)
		{
			throw new BusinessException("导入用户数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		TbStudentinfo stu = new TbStudentinfo();
		for (StuGroupVO info : userList)
		{
			try
			{
				stu.setName(info.getStuName());
				stu.setClazzId(clazzId);
				stu.setUserName(info.getEmpName());
				TbStudentinfo s = tbStudentinfoMapper.selectTbStudentinfoByUserId(stu);
				if(StringUtils.isEmpty(s.getStuId())){
//					failureMsg.append("<br/>" + successNum + "、" + info.getStuName() + " 学员的就业指导名称有误！");
					throw new BusinessException("");
				}
				stu.setName("");
				stu.setClazzId("");
				stu.setUserName("");

				stu.setEmpId(s.getUserId().toString());
				stu.setStuId(s.getStuId());
				tbStudentinfoMapper.updateTbStudentinfo(stu);
				successNum++;
				successMsg.append("<br/>" + successNum + "、" + info.getStuName() + " 导入成功");
			}
			catch (Exception e)
			{
				failureNum++;
				String msg = "<br/>" + failureNum + "、" + info.getStuName() + " 导入失败：";
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
	public List<StudentVO> selectStuNoEmployment(StudentVO vo) {
		List<StudentVO> studentVOS = tbStudentinfoMapper.selectStuNoEmployment(vo);
		return studentVOS;
	}

}
