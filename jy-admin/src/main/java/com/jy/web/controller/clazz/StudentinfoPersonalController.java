package com.jy.web.controller.clazz;

import com.jy.common.core.controller.BaseController;
import com.jy.common.core.page.TableDataInfo;
import com.jy.common.utils.layUI.LayUi;
import com.jy.framework.util.ShiroUtils;
import com.jy.system.domain.SysUser;
import com.jy.system.domain.vo.BaseStudentInfoVO;
import com.jy.system.domain.vo.StudentVO;
import com.jy.system.service.ISysUserService;
import com.jy.system.service.ITbStudentinfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 彭嘉颖 on 2019/5/30.
 */
@Controller
@RequestMapping("/clazz/stuinfo")
@Transactional(rollbackFor = Exception.class)
public class StudentinfoPersonalController extends BaseController {
    private String prefix = "clazz/tbStudentinfo";

    @Autowired
    private ITbStudentinfoService tbStudentinfoService;
    @Autowired
    private ISysUserService sysUserService;

    @RequiresPermissions("clazz:tbStudentinfoPersonal:view")
    @GetMapping()
    public String tbStudentinfo(Model model, String clazzId)
    {
        model.addAttribute("clazzId",clazzId);
        return prefix + "/tbStudentinfoPersonal";
    }

    /**
     * 查询学员列表
     */
    @RequiresPermissions("clazz:tbStudentinfoPersonal:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentVO vo)
    {

        vo.setEmpId(ShiroUtils.getUserId().toString());
        List<StudentVO> list = tbStudentinfoService.selectStuNoEmployment(vo);
        return getDataTable(list);
    }

}
