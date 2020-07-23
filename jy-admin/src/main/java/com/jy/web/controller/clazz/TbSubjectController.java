package com.jy.web.controller.clazz;


import com.jy.common.annotation.Log;
import com.jy.common.core.controller.BaseController;
import com.jy.common.core.domain.AjaxResult;
import com.jy.common.core.page.TableDataInfo;
import com.jy.common.enums.BusinessType;
import com.jy.common.utils.poi.ExcelUtil;
import com.jy.system.domain.TbSubject;
import com.jy.system.service.ITbSubjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学科 信息操作处理
 * 
 * @author jy
 * @date 2019-04-08
 */
@Controller
@RequestMapping("/clazz/tbSubject")
public class TbSubjectController extends BaseController
{
    private String prefix = "clazz/tbSubject";
	
	@Autowired
	private ITbSubjectService tbSubjectService;
	
	@RequiresPermissions("clazz:tbSubject:view")
	@GetMapping()
	public String tbSubject()
	{
	    return prefix + "/tbSubject";
	}
	
	/**
	 * 查询学科列表
	 */
	@RequiresPermissions("clazz:tbSubject:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TbSubject tbSubject)
	{
		startPage();
        List<TbSubject> list = tbSubjectService.selectTbSubjectList(tbSubject);
		return getDataTable(list);
	}

	/**
	 * 查询学科
	 */
	@GetMapping("/TbSubjectList")
	@ResponseBody
	public List<TbSubject> TbSubjectList()
	{
		List<TbSubject> list = tbSubjectService.TbSubjectList();
		return list;
	}
	
	/**
	 * 导出学科列表
	 */
	@RequiresPermissions("clazz:tbSubject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbSubject tbSubject)
    {
    	List<TbSubject> list = tbSubjectService.selectTbSubjectList(tbSubject);
        ExcelUtil<TbSubject> util = new ExcelUtil<TbSubject>(TbSubject.class);
        return util.exportExcel(list, "tbSubject");
    }
	
	/**
	 * 新增学科
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存学科
	 */
	@RequiresPermissions("clazz:tbSubject:add")
	@Log(title = "学科", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TbSubject tbSubject)
	{		
		return toAjax(tbSubjectService.insertTbSubject(tbSubject));
	}

	/**
	 * 修改学科
	 */
	@GetMapping("/edit/{subjectId}")
	public String edit(@PathVariable("subjectId") String subjectId, ModelMap map)
	{
		TbSubject tbSubject = tbSubjectService.selectTbSubjectById(subjectId);
		map.put("tbSubject", tbSubject);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存学科
	 */
	@RequiresPermissions("clazz:tbSubject:edit")
	@Log(title = "学科", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TbSubject tbSubject)
	{		
		return toAjax(tbSubjectService.updateTbSubject(tbSubject));
	}
	
	/**
	 * 删除学科
	 */
	@RequiresPermissions("clazz:tbSubject:remove")
	@Log(title = "学科", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tbSubjectService.deleteTbSubjectByIds(ids));
	}
	
}
