package com.jy.web.controller.clazz;


import com.jy.common.annotation.Log;
import com.jy.common.core.controller.BaseController;
import com.jy.common.core.domain.AjaxResult;
import com.jy.common.core.page.TableDataInfo;
import com.jy.common.enums.BusinessType;
import com.jy.common.utils.poi.ExcelUtil;
import com.jy.system.domain.BaseClazz;
import com.jy.system.domain.BaseStudentinfo;
import com.jy.system.domain.TbStudentinfo;
import com.jy.system.domain.vo.BaseClazzVO;
import com.jy.system.domain.vo.BaseStuExcelVO;
import com.jy.system.service.IBaseClazzService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 班级 基础班记录
 *
 * @author jy
 * @date 2019-04-08
 */
@Controller
@RequestMapping("/clazz/tbBaseClazz")
public class TbBaseClazzController extends BaseController
{
    private String prefix = "clazz/tbBaseClazz";

	@Autowired
	private IBaseClazzService iBaseClazzService;

	@RequiresPermissions("clazz:tbBaseClazz:view")
	@GetMapping()
	public String tbClazz()
	{
	    return prefix + "/tbBaseClazz";
	}

	/**
	 * 查询班级列表
	 */
	@RequiresPermissions("clazz:tbBaseClazz:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BaseClazzVO vo)
	{
        List<BaseClazzVO> list = iBaseClazzService.selectBaseClazzListAll(vo);
		return getDataTable(list);
	}


	/**
	 * 导出基础班班级列表
	 */
	@RequiresPermissions("clazz:tbBaseClazz:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(BaseClazz BaseClazz)
	{
		List<BaseClazz> list = iBaseClazzService.selectBaseClazzList(BaseClazz);
		ExcelUtil<BaseClazz> util = new ExcelUtil<BaseClazz>(BaseClazz.class);
		return util.exportExcel(list, "BaseClazz");
	}

	/**
	 * 新增基础班班级
	 */
	@GetMapping("/add")
	public String add()
	{
		return prefix + "/add";
	}

	/**
	 * 新增保存基础班班级
	 */
	@RequiresPermissions("clazz:BaseClazz:add")
	@Log(title = "基础班班级", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BaseClazz BaseClazz)
	{
		return toAjax(iBaseClazzService.insertBaseClazz(BaseClazz));
	}

	/**
	 * 修改基础班班级
	 */
	@GetMapping("/edit/{clazzId}")
	public String edit(@PathVariable("clazzId") String clazzId, ModelMap map)
	{
		BaseClazz BaseClazz = iBaseClazzService.selectBaseClazzById(clazzId);
		map.put("baseClazz", BaseClazz);
		return prefix + "/edit";
	}

	/**
	 * 修改保存基础班班级
	 */
	@RequiresPermissions("clazz:BaseClazz:edit")
	@Log(title = "基础班班级", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BaseClazz BaseClazz)
	{
		return toAjax(iBaseClazzService.updateBaseClazz(BaseClazz));
	}

	/**
	 * 删除基础班班级
	 */
	@RequiresPermissions("clazz:BaseClazz:remove")
	@Log(title = "基础班班级", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		return toAjax(iBaseClazzService.deleteBaseClazzByIds(ids));
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
	 * @param assistantname 助教
	 * @param lecturername 讲师
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	@RequiresPermissions("clazz:baseClazz:importExcel")
	@Log(title = "基础班级导入", businessType = BusinessType.DELETE)
	@PostMapping( "/importExcel")
	@ResponseBody
	public AjaxResult importExcel(MultipartFile file, String clazzName, String subjectId, String subjectName, String begintime, String endtime, String headmasterName,String assistantname,String lecturername)throws Exception
	{
		ExcelUtil<BaseStuExcelVO> util = new ExcelUtil<BaseStuExcelVO>(BaseStuExcelVO.class);
		List<BaseStuExcelVO> userList = util.importExcel(file.getInputStream(),3);
		return AjaxResult.success(iBaseClazzService.importTbStudentinfo(userList,clazzName,subjectId,subjectName,begintime,endtime,headmasterName,assistantname,lecturername));
	}
}
