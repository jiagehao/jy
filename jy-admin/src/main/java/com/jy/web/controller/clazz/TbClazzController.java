package com.jy.web.controller.clazz;


import com.jy.common.annotation.Log;
import com.jy.common.core.controller.BaseController;
import com.jy.common.core.domain.AjaxResult;
import com.jy.common.core.page.TableDataInfo;
import com.jy.common.enums.BusinessType;
import com.jy.common.utils.poi.ExcelUtil;
import com.jy.framework.util.ShiroUtils;
import com.jy.system.domain.SysRole;
import com.jy.system.domain.SysUser;
import com.jy.system.domain.TbClazz;
import com.jy.system.domain.TbStudentinfo;
import com.jy.system.domain.vo.ClazzVO;
import com.jy.system.domain.vo.StudentInfoVO;
import com.jy.system.service.ISysUserService;
import com.jy.system.service.ITbClazzService;
import com.jy.system.service.ITbStudentinfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * 班级 信息操作处理
 * 
 * @author jy
 * @date 2019-04-08
 */
@Controller
@RequestMapping("/clazz/tbClazz")
public class TbClazzController extends BaseController
{
    private String prefix = "clazz/tbClazz";
	
	@Autowired
	private ITbClazzService tbClazzService;
	@Autowired
	private ITbStudentinfoService tbStudentinfoService;
	@Autowired
	private ISysUserService sysUserService;
	@RequiresPermissions("clazz:tbClazz:view")
	@GetMapping()
	public String tbClazz(ModelMap modelMap)
	{
		modelMap.addAttribute("sysUser",sysUserService.selectUserById(ShiroUtils.getUserId()));
		return prefix + "/tbClazz";
	}

	/**
	 * 查询班级列表
	 */
	@RequiresPermissions("clazz:tbClazz:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ClazzVO tbClazz)
	{
		SysUser user = ShiroUtils.getSysUser();
		List<SysRole> roles = user.getRoles();

		// 就业指导只能看到自己的学生
		/*for (SysRole role : roles) {
			if (role.getRoleId() == 7) {
				tbClazz.setEmpId(ShiroUtils.getUserId().toString());
			}
		}*/


        List<ClazzVO> list = tbClazzService.selectTbClazzLists(tbClazz);
		return getDataTable(list);
	}

	@PostMapping("/getHeadmasterName")
	@ResponseBody
	public TableDataInfo getHeadmasterName(ClazzVO tbClazz)
	{
		TbClazz tbClazz1 = tbClazzService.selectTbClazzById(tbClazz.getClazzId());
		List<TbClazz> list = new ArrayList<>();
		list.add(tbClazz1);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出班级列表
	 */
	@RequiresPermissions("clazz:tbClazz:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbClazz tbClazz)
    {
    	List<TbClazz> list = tbClazzService.selectTbClazzList(tbClazz);
        ExcelUtil<TbClazz> util = new ExcelUtil<TbClazz>(TbClazz.class);
        return util.exportExcel(list, "tbClazz");
    }
	
	/**
	 * 新增班级
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存班级
	 */
	@RequiresPermissions("clazz:tbClazz:add")
	@Log(title = "班级", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TbClazz tbClazz)
	{		
		return toAjax(tbClazzService.insertTbClazz(tbClazz));
	}

	/**
	 * 修改班级
	 */
	@GetMapping("/edit/{clazzId}")
	public String edit(@PathVariable("clazzId") String clazzId, ModelMap map)
	{
		TbClazz tbClazz = tbClazzService.selectTbClazzById(clazzId);
		map.put("tbClazz", tbClazz);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存班级
	 */
	@RequiresPermissions("clazz:tbClazz:edit")
	@Log(title = "班级", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TbClazz tbClazz)
	{		
		return toAjax(tbClazzService.updateTbClazz(tbClazz));
	}
	
	/**
	 * 删除班级
	 */
	@RequiresPermissions("clazz:tbClazz:remove")
	@Log(title = "班级", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tbClazzService.deleteTbClazzByIds(ids));
	}

	/**
	 *添加班级
	 * @param file Excel文件数据
	 * @param clazzName 班级名称
	 * @param subjectId 学科ID
	 * @param subjectName 学科名称
	 * @param begintime 开班时间
	 * @param endtime 结课时间
	 * @param headmasterName 班主任姓名
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	@RequiresPermissions("clazz:tbClazz:importExcel")
	@Log(title = "班级导入", businessType = BusinessType.DELETE)
	@PostMapping( "/importExcel")
	@ResponseBody
	public AjaxResult importExcel(MultipartFile file, String clazzName,String subjectId,String subjectName,String begintime,String endtime,String headmasterName)throws Exception
	{
		ExcelUtil<TbStudentinfo> util = new ExcelUtil<TbStudentinfo>(TbStudentinfo.class);
		List<TbStudentinfo> userList = util.importExcel(file.getInputStream(),2);
		return AjaxResult.success(tbClazzService.importTbStudentinfo(userList,clazzName,subjectId,subjectName,begintime,endtime,headmasterName));
	}

	@Transactional(rollbackFor = Exception.class)
	@RequiresPermissions("clazz:importExcel:CompanyName")
	@Log(title = "导入班级学员就业公司", businessType = BusinessType.DELETE)
	@PostMapping( "/importExcelCompanyName")
	@ResponseBody
	public AjaxResult importExcelCompanyName(MultipartFile file, String clazzId)throws Exception
	{
		ExcelUtil<StudentInfoVO> util = new ExcelUtil<StudentInfoVO>(StudentInfoVO.class);
		List<StudentInfoVO> userList = util.importExcel(file.getInputStream(),0);
		return AjaxResult.success(tbClazzService.importExcelCompanyName(userList,clazzId));
	}
}
