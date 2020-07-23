package com.jy.web.controller.clazz;

import java.util.List;

import com.jy.common.utils.poi.ExcelUtil;
import com.jy.system.domain.TbServerAppointment;
import com.jy.system.service.ITbServerAppointmentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jy.common.annotation.Log;
import com.jy.common.enums.BusinessType;
import com.jy.common.core.controller.BaseController;
import com.jy.common.core.page.TableDataInfo;
import com.jy.common.core.domain.AjaxResult;

/**
 * 过程服务学员记录 信息操作处理
 * 
 * @author jy
 * @date 2019-06-13
 */
@Controller
@RequestMapping("/clazz/tbServerAppointment")
public class TbServerAppointmentController extends BaseController
{
    private String prefix = "clazz/tbServerAppointment";
	
	@Autowired
	private ITbServerAppointmentService tbServerAppointmentService;
	
	@RequiresPermissions("clazz:tbServerAppointment:view")
	@GetMapping()
	public String tbServerAppointment()
	{
	    return prefix + "/tbServerAppointment";
	}
	
	/**
	 * 查询过程服务学员记录列表
	 */
	@RequiresPermissions("clazz:tbServerAppointment:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TbServerAppointment tbServerAppointment)
	{
		startPage();
        List<TbServerAppointment> list = tbServerAppointmentService.selectTbServerAppointmentList(tbServerAppointment);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出过程服务学员记录列表
	 */
	@RequiresPermissions("clazz:tbServerAppointment:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbServerAppointment tbServerAppointment)
    {
    	List<TbServerAppointment> list = tbServerAppointmentService.selectTbServerAppointmentList(tbServerAppointment);
        ExcelUtil<TbServerAppointment> util = new ExcelUtil<TbServerAppointment>(TbServerAppointment.class);
        return util.exportExcel(list, "tbServerAppointment");
    }
	
	/**
	 * 新增过程服务学员记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存过程服务学员记录
	 */
	@RequiresPermissions("clazz:tbServerAppointment:add")
	@Log(title = "过程服务学员记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TbServerAppointment tbServerAppointment)
	{		
		return toAjax(tbServerAppointmentService.insertTbServerAppointment(tbServerAppointment));
	}

	/**
	 * 修改过程服务学员记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap map)
	{
		TbServerAppointment tbServerAppointment = tbServerAppointmentService.selectTbServerAppointmentById(id);
		map.put("tbServerAppointment", tbServerAppointment);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存过程服务学员记录
	 */
	@RequiresPermissions("clazz:tbServerAppointment:edit")
	@Log(title = "过程服务学员记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TbServerAppointment tbServerAppointment)
	{		
		return toAjax(tbServerAppointmentService.updateTbServerAppointment(tbServerAppointment));
	}
	
	/**
	 * 删除过程服务学员记录
	 */
	@RequiresPermissions("clazz:tbServerAppointment:remove")
	@Log(title = "过程服务学员记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tbServerAppointmentService.deleteTbServerAppointmentByIds(ids));
	}
	
}
