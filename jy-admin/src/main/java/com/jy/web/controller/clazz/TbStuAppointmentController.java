package com.jy.web.controller.clazz;


import com.jy.common.annotation.Log;
import com.jy.common.core.controller.BaseController;
import com.jy.common.core.domain.AjaxResult;
import com.jy.common.core.page.TableDataInfo;
import com.jy.common.enums.BusinessType;
import com.jy.common.utils.poi.ExcelUtil;
import com.jy.system.domain.TbStuAppointment;
import com.jy.system.service.ITbStuAppointmentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学员记录 信息操作处理
 * 
 * @author jy
 * @date 2019-04-08
 */
@Controller
@RequestMapping("/clazz/tbStuAppointment")
public class TbStuAppointmentController extends BaseController
{
    private String prefix = "clazz/tbStuAppointment";
	
	@Autowired
	private ITbStuAppointmentService tbStuAppointmentService;
	
	@RequiresPermissions("clazz:tbStuAppointment:view")
	@GetMapping()
	public String tbStuAppointment()
	{
	    return prefix + "/tbStuAppointment";
	}
	
	/**
	 * 查询学员记录列表
	 */
	@RequiresPermissions("clazz:tbStuAppointment:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TbStuAppointment tbStuAppointment)
	{
		startPage();
        List<TbStuAppointment> list = tbStuAppointmentService.selectTbStuAppointmentList(tbStuAppointment);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出学员记录列表
	 */
	@RequiresPermissions("clazz:tbStuAppointment:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbStuAppointment tbStuAppointment)
    {
    	List<TbStuAppointment> list = tbStuAppointmentService.selectTbStuAppointmentList(tbStuAppointment);
        ExcelUtil<TbStuAppointment> util = new ExcelUtil<TbStuAppointment>(TbStuAppointment.class);
        return util.exportExcel(list, "tbStuAppointment");
    }
	
	/**
	 * 新增学员记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存学员记录
	 */
	@RequiresPermissions("clazz:tbStuAppointment:add")
	@Log(title = "学员记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TbStuAppointment tbStuAppointment)
	{		
		return toAjax(tbStuAppointmentService.insertTbStuAppointment(tbStuAppointment));
	}

	/**
	 * 修改学员记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap map)
	{
		TbStuAppointment tbStuAppointment = tbStuAppointmentService.selectTbStuAppointmentById(id);
		map.put("tbStuAppointment", tbStuAppointment);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存学员记录
	 */
	@RequiresPermissions("clazz:tbStuAppointment:edit")
	@Log(title = "学员记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TbStuAppointment tbStuAppointment)
	{		
		return toAjax(tbStuAppointmentService.updateTbStuAppointment(tbStuAppointment));
	}
	
	/**
	 * 删除学员记录
	 */
	@RequiresPermissions("clazz:tbStuAppointment:remove")
	@Log(title = "学员记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tbStuAppointmentService.deleteTbStuAppointmentByIds(ids));
	}
	
}
