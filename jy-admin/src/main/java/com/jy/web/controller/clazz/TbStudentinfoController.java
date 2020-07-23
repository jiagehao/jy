package com.jy.web.controller.clazz;


import com.jy.common.annotation.Log;
import com.jy.common.core.controller.BaseController;
import com.jy.common.core.domain.AjaxResult;
import com.jy.common.core.page.TableDataInfo;
import com.jy.common.enums.BusinessType;
import com.jy.common.exception.BusinessException;
import com.jy.common.utils.DateUtils;
import com.jy.common.utils.StringUtils;
import com.jy.common.utils.poi.ExcelUtil;
import com.jy.framework.util.ShiroUtils;
import com.jy.system.domain.SysRole;
import com.jy.system.domain.SysUser;
import com.jy.system.domain.TbStuAppointment;
import com.jy.system.domain.TbStudentinfo;
import com.jy.system.domain.vo.PersonalVO;
import com.jy.system.domain.vo.StuGroupVO;
import com.jy.system.domain.vo.StudentVO;
import com.jy.system.domain.vo.TbStuAppointmentVO;
import com.jy.system.service.ITbStuAppointmentService;
import com.jy.system.service.ITbStudentinfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 学员 信息操作处理
 *
 * @author jy
 * @date 2019-04-08
 */
@Controller
@RequestMapping("/clazz/tbStudentinfo")
@Transactional(rollbackFor = Exception.class)
public class TbStudentinfoController extends BaseController {
    private String prefix = "clazz/tbStudentinfo";

    @Autowired
    private ITbStudentinfoService tbStudentinfoService;

    @Autowired
    private ITbStuAppointmentService tbStuAppointmentService;

    @RequiresPermissions("clazz:tbStudentinfo:view")
    @GetMapping()
    public String tbStudentinfo(Model model, String stuId) {
        model.addAttribute("stuId", stuId);
        String clazz = ShiroUtils.getSysUser().getUserId() + stuId;
        return prefix + "/tbStudentinfo";
    }


    @RequiresPermissions("clazz:tbStudentinfoAll:view")
    @GetMapping("/infoAll")
    public String tbStudentinfoAll(Model model, String stuId) {
        model.addAttribute("stuId", stuId);
        String clazz = ShiroUtils.getSysUser().getUserId() + stuId;
        return prefix + "/tbStudentinfo_all";
    }

    /**
     * 查询学员列表
     */
    @RequiresPermissions("clazz:tbStudentinfoAll:list")
    @PostMapping("/infoAllList")
    @ResponseBody
    public TableDataInfo infoAllList(TbStudentinfo tbStudentinfo) {
        List<TbStudentinfo> tbStudentinfos = new ArrayList<>();
        startPage();
        if (StringUtils.isNotEmpty(tbStudentinfo.getName()) || StringUtils.isNotEmpty(tbStudentinfo.getCompanyname()) || StringUtils.isNotEmpty(tbStudentinfo.getEducation())) {
            tbStudentinfos = tbStudentinfoService.selectTbStudentinfoList(tbStudentinfo);
        }
        return getDataTable(tbStudentinfos);
    }


    /**
     * 查询学员列表
     */
    @RequiresPermissions("clazz:tbStudentinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentVO vo) {
//		startPage();
        SysUser user = ShiroUtils.getSysUser();
        List<SysRole> roles = user.getRoles();
       /*  已取消查询自己学生的限制
       for (SysRole role : roles) {
            if (role.getRoleId() == 7) {
                vo.setUserName(user.getUserName());
            }
        }*/
        List<StudentVO> list = tbStudentinfoService.selectTbStudentinfoLists(vo);
        return getDataTable(list);
    }

    /**
     * 获取个人就业率
     *
     * @param clazzId
     * @return
     */
    @GetMapping("/getPersonal")
    @ResponseBody
    public List<PersonalVO> getPersonalRateOfEmployment(String clazzId) {
        return tbStudentinfoService.getPersonalRateOfEmployment(clazzId);
    }


    /**
     * 导出学员列表
     */
    @RequiresPermissions("clazz:tbStudentinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbStudentinfo tbStudentinfo) {
        List<TbStudentinfo> list = tbStudentinfoService.selectTbStudentinfoList(tbStudentinfo);
        ExcelUtil<TbStudentinfo> util = new ExcelUtil<TbStudentinfo>(TbStudentinfo.class);
        return util.exportExcel(list, "tbStudentinfo");
    }

    /**
     * 新增学员
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存学员
     */
    @RequiresPermissions("clazz:tbStudentinfo:add")
    @Log(title = "学员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbStudentinfo tbStudentinfo) {
        return toAjax(tbStudentinfoService.insertTbStudentinfo(tbStudentinfo));
    }

    /**
     * 修改学员
     */
    @GetMapping("/edit/{stuId}")
    public String edit(@PathVariable("stuId") String stuId, ModelMap map) {
        TbStudentinfo tbStudentinfo = tbStudentinfoService.selectTbStudentinfoById(stuId);
        map.put("tbStudentinfo", tbStudentinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存学员
     */
    @RequiresPermissions("clazz:tbStudentinfo:edit")
    @Log(title = "学员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbStudentinfo tbStudentinfo) {
        if (StringUtils.isNotEmpty(tbStudentinfo.getCompanyname())) {
            if (Integer.parseInt(tbStudentinfo.getSalary()) < 100) {
                throw new BusinessException("请正确填写薪资！");
            }
            if (!DateUtils.isValidDate(tbStudentinfo.getEntrytime())) {
                throw new BusinessException("请正确填写日期！格式为：2019-09-09");
            }
            if (!tbStudentinfo.getCompanyname().contains("有限公司")) {
                throw new BusinessException("请正确填写公司全称！");
            }

        }
        if (StringUtils.isNotEmpty(tbStudentinfo.getEntrytyears())) {
            if (tbStudentinfo.getEntrytyears().length() > 1) {
                throw new BusinessException("入职年限只能填写0~9中的任意1个数字！");
            }
            if (!isInteger(tbStudentinfo.getEntrytyears())) {
                throw new BusinessException("入职年限只能填写0~9中的任意1个数字！");
            }
        }
        return toAjax(tbStudentinfoService.updateTbStudentinfo(tbStudentinfo));
    }

    /**
     * 删除学员
     */
    @RequiresPermissions("clazz:tbStudentinfo:remove")
    @Log(title = "学员", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tbStudentinfoService.deleteTbStudentinfoByIds(ids));
    }


    /**
     * 学员跟踪记录列表
     */
    @RequiresPermissions("clazz:tbStudentinfo:trackList")
    @Log(title = "学员跟踪记录列表", businessType = BusinessType.DELETE)
    @GetMapping("/info/{stuId}")
    public String info(@PathVariable("stuId") String stuId, ModelMap map) {

        TbStuAppointment tbStuAppointment = new TbStuAppointment();
        tbStuAppointment.setStuId(stuId);
        List<TbStuAppointmentVO> list = tbStuAppointmentService.selectTbStuAppointmentAll(tbStuAppointment);
        TbStudentinfo tbStudentinfo = tbStudentinfoService.selectTbStudentinfoById(stuId);
        //学员详情信息
        map.put("tbStudentinfo", tbStudentinfo);
        //学员跟踪记录
        map.put("infoList", list);
        return prefix + "/info";
    }


    /**
     * 添加学员跟踪记录
     */
    @RequiresPermissions("clazz:tbStudentinfo:addTrack")
    @Log(title = "添加学员跟踪记录", businessType = BusinessType.DELETE)
    @GetMapping("/addInfo/{stuId}")
    public String addInfo(@PathVariable("stuId") String stuId, ModelMap map) {
        TbStudentinfo tbStudentinfo = tbStudentinfoService.selectTbStudentinfoById(stuId);
        map.put("tbStudentinfo", tbStudentinfo);
        return prefix + "/addInfo";
    }

    /**
     * 保存学生记录
     */
    @RequiresPermissions("clazz:tbStudentinfo:infoSave")
    @Log(title = "学员", businessType = BusinessType.INSERT)
    @PostMapping("/infoSave")
    @ResponseBody
    public AjaxResult infoSave(TbStuAppointment TbStuAppointment) {
        String userId = ShiroUtils.getSysUser().getUserId().toString();
        TbStuAppointment.setCreatetime(DateUtils.getTime());
        TbStuAppointment.setAppointtime(DateUtils.getTime());
        TbStuAppointment.setEmpId(userId);
        TbStuAppointment.setId(UUID.randomUUID().toString().replace("-", ""));
        return toAjax(tbStuAppointmentService.insertTbStuAppointment(TbStuAppointment));
    }

    @Transactional(rollbackFor = Exception.class)
    @RequiresPermissions("clazz:tbStudentinfo:group")
    @Log(title = "分组", businessType = BusinessType.DELETE)
    @PostMapping("/importExcelGroup")
    @ResponseBody
    public AjaxResult importExcel(MultipartFile file, String clazzId) throws Exception {
        ExcelUtil<StuGroupVO> util = new ExcelUtil<StuGroupVO>(StuGroupVO.class);
        List<StuGroupVO> userList = util.importExcel(file.getInputStream(), 0);
        return AjaxResult.success(tbStudentinfoService.importTbStudentinfo(userList, clazzId));
    }

    /**
     * 分组模板下载
     *
     * @return
     */
    @RequiresPermissions("clazz:tbStudentinfo:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<StuGroupVO> util = new ExcelUtil<StuGroupVO>(StuGroupVO.class);
        return util.importTemplateExcel("分组数据");
    }


    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^((?!0)\\d){1}$");
        return pattern.matcher(str).matches();
    }
}
