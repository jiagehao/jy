package com.jy.web.controller.clazz;


import com.jy.common.annotation.Log;
import com.jy.common.core.controller.BaseController;
import com.jy.common.core.domain.AjaxResult;
import com.jy.common.enums.BusinessType;
import com.jy.common.utils.DateUtils;
import com.jy.common.utils.IDCardUtil;
import com.jy.common.utils.StringUtils;
import com.jy.common.utils.bean.UuidUtil;
import com.jy.common.utils.layUI.LayUi;
import com.jy.framework.util.ShiroUtils;
import com.jy.system.domain.*;
import com.jy.system.domain.vo.BaseStudentInfoVO;
import com.jy.system.domain.vo.TbStuAppointmentVO;
import com.jy.system.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 学员 信息操作处理
 *
 * @author jy
 * @date 2019-04-08
 */
@Controller
@RequestMapping("/clazz/tbBaseStudentinfo")
@Transactional(rollbackFor = Exception.class)
public class TbBaseStudentinfoController extends BaseController
{
    private String prefix = "clazz/tbBaseStudentinfo";


	//基础学生
	@Autowired
	private IBaseStudentinfoService baseStudentinfoService;

	//基础访谈对象
	@Autowired
	private IBaseInterviewService baseInterviewService;

	//基础班级学生表
	@Autowired
	private IBaseStuClazzService baseStuClazzService;

	//基础学生成绩
	@Autowired
	private IBaseAchievementService baseAchievementService;


	//记录信息记录
	@Autowired
	private ITbStuAppointmentService tbStuAppointmentService;


	@Autowired
	private ITbSubjectService iTbSubjectService;



	@RequiresPermissions("clazz:tbBaseStudentinfo:view")
	@GetMapping()
	public String tbStudentinfo(Model model, String clazzId)
	{
		model.addAttribute("clazzId",clazzId);
//		String clazz = ShiroUtils.getSysUser().getUserId()+stuId;
	    return prefix + "/tbBaseStudentinfo";
	}

	/**
	 * 查询学员列表
	 */
	@RequiresPermissions("clazz:tbBaseStudentinfo:list")
	@GetMapping("/list")
	@ResponseBody
	public LayUi list(BaseStudentInfoVO vo) throws Exception {

		List<BaseStudentInfoVO> list = baseStudentinfoService.selectBaseStudentinfoByClazzId(vo);
		return LayUi.data(20,list,"操作成功");
	}

	/**
	 * 获取学科天数
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/day")
	@ResponseBody
	public List day(BaseStudentInfoVO vo) throws Exception {
		TbSubject sub = new TbSubject();
		sub.setSubjectId(vo.getSubjectId());
		List<TbSubject> list = iTbSubjectService.selectTbSubjectList(sub);
		return list;
	}
	/**
	 * 学生留级
	 */
	@RequiresPermissions("clazz:tbBaseStudentinfo:isEm")
	@PostMapping("/isEm")
	@ResponseBody
	public LayUi isEm(BaseStudentinfo baseStudentinfo)
	{
		if (baseStudentinfo.getEmployment()!=1||StringUtils.isEmpty(baseStudentinfo.getStuId())){
			return  LayUi.data(0,null,"操作失败");
		}
		if (StringUtils.isEmpty(baseStudentinfo.getRemarkshr())){
			return LayUi.data(0,null,"请填写留级记录");
		}
		baseStudentinfoService.updateBaseStudentinfo(baseStudentinfo);
		return LayUi.data(0,null,"操作成功");
	}


	/**
	 * 学生流失
	 */
	@RequiresPermissions("clazz:tbBaseStudentinfo:isOut")
	@PostMapping("/isOut")
	@ResponseBody
	public AjaxResult isOut(BaseStudentinfo baseStudentinfo)
	{
		return toAjax(baseStudentinfoService.updateBaseStudentinfo(baseStudentinfo));
	}


	/**
	 * 学生添加访谈对象
	 */
	@RequiresPermissions("clazz:tbBaseStudentinfo:isProblem")
	@PostMapping("/isProblem")
	@ResponseBody
	public AjaxResult isProblem(BaseInterview baseInterview)
	{
		String stuid = baseInterview.getStuid();
		BaseStudentinfo studentinfo = baseStudentinfoService.selectBaseStudentinfoById(stuid);
		baseInterview.setAge(studentinfo.getAge().toString());
		baseInterview.setName(studentinfo.getName());
		baseInterview.setSex(studentinfo.getSex());
		baseInterview.setEducation(studentinfo.getEducation());
		baseInterview.setInterviewid(UuidUtil.get32UUID());
		return toAjax(baseInterviewService.insertBaseInterview(baseInterview));
	}

	/**
	 * 学生重点关注
	 */
	@RequiresPermissions("clazz:tbBaseStudentinfo:isEm")
	@PostMapping("/isSf")
	@ResponseBody
	public AjaxResult isSf(BaseStudentinfo baseStudentinfo)
	{
		return toAjax(baseStudentinfoService.updateBaseStudentinfo(baseStudentinfo));
	}





//	/**
//	 * 导出学员列表
//	 */
//	@RequiresPermissions("clazz:tbBaseStudentinfo:export")
//    @PostMapping("/export")
//    @ResponseBody
//    public AjaxResult export(TbStudentinfo tbStudentinfo)
//    {
//    	List<TbStudentinfo> list = tbStudentinfoService.selectTbStudentinfoList(tbStudentinfo);
//        ExcelUtil<TbStudentinfo> util = new ExcelUtil<TbStudentinfo>(TbStudentinfo.class);
//        return util.exportExcel(list, "tbBaseStudentinfo");
//    }

	/**
	 * 新增学员
	 */
	@GetMapping("/add/{clazzId}")
	public String add(@PathVariable("clazzId")String clazzId, ModelMap map)
	{
		BaseStudentinfo baseStudentinfo = new BaseStudentinfo();
		baseStudentinfo.setClazz(clazzId);
		map.put("baseStudentinfo", baseStudentinfo);
	    return prefix + "/add";
	}

	/**
	 * 新增保存学员
	 */
	@RequiresPermissions("clazz:tbBaseStudentinfo:add")
	@Log(title = "新增保存学员", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BaseStudentinfo baseStudentinfo)
	{
		//身份证不能为空
		String idnumber = baseStudentinfo.getIdnumber();
		String cv = IDCardUtil.IDCardValidate(idnumber);
		if (!cv.equals("1")){
			return error(cv);
		}
		String clazz = baseStudentinfo.getClazz();
		if (StringUtils.isEmpty(clazz)){
			return error();
		}
		BaseStuClazz baseStuClazz = new BaseStuClazz();
		String stuId = UuidUtil.get32UUID().toString();
		baseStudentinfo.setStuId(stuId);
		baseStuClazz.setStuId(stuId);
		baseStuClazz.setClazzId(clazz);
		baseStuClazz.setStuclazzId(UuidUtil.get32UUID().toString());

		BaseAchievement baseAchievement_a = new BaseAchievement();
		BaseAchievement baseAchievement_b = new BaseAchievement();
		baseAchievement_a.setStuId(stuId);
		baseAchievement_a.setCategory("代码量");
		baseAchievement_a.setId(UuidUtil.get32UUID().toString());
		baseAchievement_a.setOne("110");
		baseAchievement_a.setTwo("110");
		baseAchievement_a.setThree("110");
		baseAchievement_a.setFour("110");
		baseAchievement_a.setFive("110");
		baseAchievement_a.setSix("110");
		baseAchievement_a.setSeven("110");
		baseAchievement_a.setEight("110");
		baseAchievement_a.setNine("110");
		baseAchievement_a.setTen("110");
		baseAchievement_a.setEleven("110");
		baseAchievement_a.setTwelve("110");
		baseAchievement_a.setThirteen("110");
		baseAchievement_a.setFourteen("110");
		baseAchievement_a.setFifteen("110");

		baseAchievement_b.setStuId(stuId);
		baseAchievement_b.setCategory("日常表现");
		baseAchievement_b.setId(UuidUtil.get32UUID().toString());
		baseAchievement_b.setOne("110");
		baseAchievement_b.setTwo("110");
		baseAchievement_b.setThree("110");
		baseAchievement_b.setFour("110");
		baseAchievement_b.setFive("110");
		baseAchievement_b.setSix("110");
		baseAchievement_b.setSeven("110");
		baseAchievement_b.setEight("110");
		baseAchievement_b.setNine("110");
		baseAchievement_b.setTen("110");
		baseAchievement_b.setEleven("110");
		baseAchievement_b.setTwelve("110");
		baseAchievement_b.setThirteen("110");
		baseAchievement_b.setFourteen("110");
		baseAchievement_b.setFifteen("110");

		baseStuClazzService.insertBaseStuClazz(baseStuClazz);
		baseAchievementService.insertBaseAchievement(baseAchievement_a);
		baseAchievementService.insertBaseAchievement(baseAchievement_b);
		return toAjax(baseStudentinfoService.insertBaseStudentinfo(baseStudentinfo));
	}

	/**
	 * 新增保存学员
	 */
	@GetMapping("/checkIDcard")
	public AjaxResult checkIDcard(String IDcard)
	{
		//身份证不能为空
		String cv = IDCardUtil.IDCardValidate(IDcard);
		Map<String, String> resultMap = new HashMap<>();
		if (!cv.equals("1")){
			resultMap.put("errorMsg",cv);
			return error(cv);
		}else{
		Map<String, String> ageSex = IDCardUtil.getBirAgeSex(IDcard);
		ageSex.get("birthday");
		ageSex.get("age");
		ageSex.get("sexCode");
			return success();
		}
	}


	/**
	 * 修改学员
	 */
	@GetMapping("/edit/{stuId}")
	public String edit(@PathVariable("stuId") String stuId, ModelMap map)
	{
		BaseStudentinfo baseStudentinfo = baseStudentinfoService.selectBaseStudentinfoById(stuId);
		map.put("baseStudentinfo", baseStudentinfo);
	    return prefix + "/edit";
	}

	/**
	 * 修改保存学员
	 */
	@RequiresPermissions("clazz:tbBaseStudentinfo:edit")
	@Log(title = "学员", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BaseStudentinfo baseStudentinfo )
	{
		return toAjax(baseStudentinfoService.updateBaseStudentinfo(baseStudentinfo));
	}

	/**
	 * 修改保存学员成绩
	 */
	@RequiresPermissions("clazz:tbBaseStudentinfo:edit")
	@Log(title = "基础班学员成绩", businessType = BusinessType.UPDATE)
	@PostMapping("/editAc")
	@ResponseBody
	public AjaxResult editAc(BaseAchievement baseAchievement)
	{

		return toAjax(baseAchievementService.updateBaseAchievement(baseAchievement));
	}


	/**
	 * 删除学员
	 */
	@RequiresPermissions("clazz:tbBaseStudentinfo:remove")
	@Log(title = "学员", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String stuId)
	{
		//删除表格数据的包括    班级中间表 + 学生资料 + 学生成绩表+ 学生访谈记录 + 访谈对象
		int  submitCount=0;
		submitCount += baseStudentinfoService.deleteBaseStudentinfoById(stuId);
		submitCount += baseInterviewService.deleteBaseInterviewByStuId(stuId);
		submitCount += baseStuClazzService.deleteBaseStuClazzByStuId(stuId);
		submitCount += baseAchievementService.deleteBaseAchievementByStuId(stuId);
		submitCount += tbStuAppointmentService.deleteTbStuAppointmentByStuId(stuId);
		return toAjax(submitCount);
	}

    /**
     * 修改保存学员成绩
     */
    @Log(title = "基础班学员升级成绩", businessType = BusinessType.UPDATE)
    @PostMapping("/saveFinalScore")
    @ResponseBody
    public AjaxResult saveFinalScore(BaseAchievement baseAchievement)
    {

        String workexperience = baseAchievement.getWorkexperience();
        baseAchievement.setWorkexperience(null);
        if (StringUtils.isEmpty(workexperience)){
            return  error("升级成绩不能为空");
        }
        List<BaseAchievement> list = baseAchievementService.selectBaseAchievementList(baseAchievement);
        int i = 0;
        if (list.size()!=2){
            return error();
        }
        for (BaseAchievement achievement : list) {
            achievement.setWorkexperience(workexperience);
            i+=baseAchievementService.updateBaseAchievement(achievement);
        }
        return toAjax(i);
    }

	/**
	 * 添加学员跟踪记录
	 */
	@RequiresPermissions("clazz:tbBaseStudentinfo:addTrack")
	@Log(title = "添加学员跟踪记录", businessType = BusinessType.DELETE)
	@GetMapping("/addInfo/{stuId}")
	public String addInfo(@PathVariable("stuId") String stuId, ModelMap map)
	{
		BaseStudentinfo baseStudentinfo = baseStudentinfoService.selectBaseStudentinfoById(stuId);
		map.put("tbStudentinfo", baseStudentinfo);
		return prefix + "/addInfo";
	}

	/**
	 * 学员跟踪记录列表
	 */
	@RequiresPermissions("clazz:tbBaseStudentinfo:trackList")
	@Log(title = "学员跟踪记录列表", businessType = BusinessType.DELETE)
	@GetMapping("/info/{stuId}")
	public String info(@PathVariable("stuId") String stuId, ModelMap map)
	{

		TbStuAppointment tbStuAppointment=new TbStuAppointment();
		tbStuAppointment.setStuId(stuId);
		List<TbStuAppointmentVO> list = tbStuAppointmentService.selectTbStuAppointmentAll(tbStuAppointment);
		BaseStudentinfo baseStudentinfo = baseStudentinfoService.selectBaseStudentinfoById(stuId);
		//学员详情信息
		map.put("tbStudentinfo", baseStudentinfo);
		//学员跟踪记录
		map.put("infoList", list);
		return prefix + "/info";
	}

	/**
	 * 保存学生记录
	 */
	@RequiresPermissions("clazz:tbBaseStudentinfo:infoSave")
	@Log(title = "学员", businessType = BusinessType.INSERT)
	@PostMapping("/infoSave")
	@ResponseBody
	public AjaxResult infoSave(TbStuAppointment TbStuAppointment)
	{
		String userId = ShiroUtils.getSysUser().getUserId().toString();
		TbStuAppointment.setCreatetime(DateUtils.getTime());
		TbStuAppointment.setAppointtime(DateUtils.getTime());
		TbStuAppointment.setEmpId(userId);
		TbStuAppointment.setId(UUID.randomUUID().toString().replace("-", ""));
		return toAjax(tbStuAppointmentService.insertTbStuAppointment(TbStuAppointment));
	}


}
