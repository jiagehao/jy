package com.jy.web.controller.clazz;

import com.jy.common.annotation.Log;
import com.jy.common.core.controller.BaseController;
import com.jy.common.core.domain.AjaxResult;
import com.jy.common.core.page.TableDataInfo;
import com.jy.common.enums.BusinessType;
import com.jy.common.utils.DateUtils;
import com.jy.common.utils.bean.UuidUtil;
import com.jy.framework.util.ShiroUtils;
import com.jy.framework.web.domain.Server;
import com.jy.system.domain.*;
import com.jy.system.domain.vo.ServerProcessStuVO;
import com.jy.system.domain.vo.ServiceProcessVO;
import com.jy.system.domain.vo.TbStuAppointmentVO;
import com.jy.system.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by 彭嘉颖 on 2019/6/11.
 */
@Controller
@RequestMapping("/ServiceProcess")
public class ServiceProcessController extends BaseController {
    private String prefix = "clazz/ServiceProcess";
    @Autowired
    private IBaseClazzService iBaseClazzService;
    @Autowired
    private IBaseStudentinfoService baseStudentinfoService;
    @Autowired
    private ISysUserService sysUserService;
    //记录信息记录
    @Autowired
    private ITbServerAppointmentService tbServerAppointmentService;

    //过程服务班级信息
    @RequiresPermissions("ServiceProcess:server:view")
    @GetMapping()
    public String server(ModelMap map) throws Exception
    {
        return prefix + "/ServiceProcess";
    }

    /**
     * 查看过程服务班级信息
     * @param vo
     * @return
     */
    @RequiresPermissions("ServiceProcess:server:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ServiceProcessVO vo)
    {
        List<ServiceProcessVO> list = iBaseClazzService.selectServiceProcessById(vo);
        return getDataTable(list);
    }

    /**
     * 下拉框获取班级名
     * @param vo 班级id
     * @return
     */
    @GetMapping("/selectClazzByclazzName")
    @ResponseBody
    public List<ServiceProcessVO> selectClazzByclazzName(ServiceProcessVO vo)
    {
        return iBaseClazzService.selectClazzByclazzName(vo);
    }

    /**
     * 下拉框获取就业指导名称
     * @return
     */
    @GetMapping("/selectSysUserByUserName")
    @ResponseBody
    public List<SysUser> selectSysUserByUserName()
    {
        return sysUserService.selectSysUserByUserName();
    }
    /**
     * 新增过程服务班级
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存过程服务班级
     */
    @RequiresPermissions("ServiceProcess:server:add")
    @Log(title = "新增保存过程服务班级", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ServiceProcessVO vo)
    {
        return toAjax(iBaseClazzService.updateBaseClazzServer(vo));
    }
    /**
     * 删除过程服务班级
     */
    @RequiresPermissions("ServiceProcess:server:remove")
    @Log(title = "删除存过程服务班级", businessType = BusinessType.INSERT)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult removeSave(String ids)
    {
        ServiceProcessVO vo = new ServiceProcessVO();
        vo.setIsprocess("0");
        vo.setClazzid(ids);
        return toAjax(iBaseClazzService.updateBaseClazzServer(vo));
    }
    /**
     * 修改过程服务班级
     */
    @GetMapping("/edit/{clazzId}")
    public String edit(@PathVariable("clazzId") String clazzId, ModelMap map)
    {
        ServiceProcessVO ServiceProcessVO = iBaseClazzService.selectClazzByServerId(clazzId);
        map.put("ServiceProcessVO", ServiceProcessVO);
        map.put("emp", sysUserService.selectSysUserByUserName());
        return prefix + "/edit";
    }

    /**
     * 修改保存过程服务班级
     */
    @RequiresPermissions("ServiceProcess:server:edit")
    @Log(title = "修改保存过程服务班级", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ServiceProcessVO serviceProcessVO)
    {
        ServiceProcessVO vo = new ServiceProcessVO();
        vo.setEstimate(serviceProcessVO.getEstimate());
        vo.setClazzid(serviceProcessVO.getClazzid());
        vo.setIsprocess("1");
        return toAjax(iBaseClazzService.updateBaseClazzServer(vo));
    }



    //过程服务学员信息
    @RequiresPermissions("ServiceProcess:server:serverStu")
    @GetMapping("/serverStu")
    public String serverStu(ServiceProcessVO vo)
    {
        return prefix + "/getServerStu";
    }

    /**
     * 查看过程服务学员信息
     * @param clazzid
     * @return
     */
    @RequiresPermissions("ServiceProcess:server:getServerStu")
    @PostMapping("/getServerStu")
    @ResponseBody
    public TableDataInfo getServerStu(String clazzid)
    {
        return getDataTable( baseStudentinfoService.selectServerStyById(clazzid));
    }


    /**
     * 添加学员跟踪记录
     */
    @RequiresPermissions("clazz:tbBaseStudentinfo:addTrack")
    @Log(title = "添加学员跟踪记录", businessType = BusinessType.DELETE)
    @GetMapping("/addInfo/{stuId}/{isfoul}")
    public String addInfo(@PathVariable("stuId") String stuId,@PathVariable("isfoul") String isfoul,ModelMap map)
    {
        BaseStudentinfo baseStudentinfo = baseStudentinfoService.selectBaseStudentinfoById(stuId);
        baseStudentinfo.setEducation(isfoul);
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
        TbServerAppointment tbServerAppointment=new TbServerAppointment();
        tbServerAppointment.setStuId(stuId);
        List<TbStuAppointmentVO> list  = tbServerAppointmentService.selectTbServerAppointmentAll(tbServerAppointment);
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
    public AjaxResult infoSave(TbServerAppointment tbServerAppointment)
    {
        String userId = ShiroUtils.getSysUser().getUserId().toString();
        tbServerAppointment.setCreatetime(DateUtils.getTime());
        tbServerAppointment.setAppointtime(DateUtils.getTime());
        tbServerAppointment.setEmpId(userId);
        tbServerAppointment.setId(UuidUtil.get32UUID());
        return toAjax(tbServerAppointmentService.insertTbServerAppointment(tbServerAppointment));
    }


}
