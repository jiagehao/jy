package com.jy.web.controller.clazz;


import com.jy.common.annotation.Log;
import com.jy.common.core.controller.BaseController;
import com.jy.common.core.domain.AjaxResult;
import com.jy.common.core.page.TableDataInfo;
import com.jy.common.enums.BusinessType;
import com.jy.common.utils.poi.ExcelUtil;
import com.jy.system.domain.TbStuClazz;
import com.jy.system.service.ITbStuClazzService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学员班级中间 信息操作处理
 * 
 * @author jy
 * @date 2019-04-08
 */
@Controller
@RequestMapping("/clazz/tbStuClazz")
public class TbStuClazzController extends BaseController
{
    private String prefix = "clazz/tbStuClazz";
	
	@Autowired
	private ITbStuClazzService tbStuClazzService;
	
	@RequiresPermissions("clazz:tbStuClazz:view")
	@GetMapping()
	public String tbStuClazz()
	{
	    return prefix + "/tbStuClazz";
	}
	
	/**
	 * 查询学员班级中间列表
	 */
	@RequiresPermissions("clazz:tbStuClazz:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TbStuClazz tbStuClazz)
	{
		startPage();
        List<TbStuClazz> list = tbStuClazzService.selectTbStuClazzList(tbStuClazz);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出学员班级中间列表
	 */
	@RequiresPermissions("clazz:tbStuClazz:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbStuClazz tbStuClazz)
    {
    	List<TbStuClazz> list = tbStuClazzService.selectTbStuClazzList(tbStuClazz);
        ExcelUtil<TbStuClazz> util = new ExcelUtil<TbStuClazz>(TbStuClazz.class);
        return util.exportExcel(list, "tbStuClazz");
    }
	
	/**
	 * 新增学员班级中间
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存学员班级中间
	 */
	@RequiresPermissions("clazz:tbStuClazz:add")
	@Log(title = "学员班级中间", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TbStuClazz tbStuClazz)
	{		
		return toAjax(tbStuClazzService.insertTbStuClazz(tbStuClazz));
	}

	/**
	 * 修改学员班级中间
	 */
	@GetMapping("/edit/{stuclazzId}")
	public String edit(@PathVariable("stuclazzId") String stuclazzId, ModelMap map)
	{
		TbStuClazz tbStuClazz = tbStuClazzService.selectTbStuClazzById(stuclazzId);
		map.put("tbStuClazz", tbStuClazz);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存学员班级中间
	 */
	@RequiresPermissions("clazz:tbStuClazz:edit")
	@Log(title = "学员班级中间", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TbStuClazz tbStuClazz)
	{		
		return toAjax(tbStuClazzService.updateTbStuClazz(tbStuClazz));
	}
	
	/**
	 * 删除学员班级中间
	 */
	@RequiresPermissions("clazz:tbStuClazz:remove")
	@Log(title = "学员班级中间", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tbStuClazzService.deleteTbStuClazzByIds(ids));
	}
	
}
