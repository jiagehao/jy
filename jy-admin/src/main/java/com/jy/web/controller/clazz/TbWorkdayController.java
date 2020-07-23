package com.jy.web.controller.clazz;

import java.util.List;

import com.jy.system.domain.TbWorkday;
import com.jy.system.service.ITbWorkdayService;
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
import com.jy.common.utils.poi.ExcelUtil;

/**
 * 工作日 信息操作处理
 * 
 * @author jy
 * @date 2019-04-08
 */
@Controller
@RequestMapping("/clazz/tbWorkday")
public class TbWorkdayController extends BaseController
{
    private String prefix = "clazz/tbWorkday";
	
	@Autowired
	private ITbWorkdayService tbWorkdayService;
	
	@RequiresPermissions("clazz:tbWorkday:view")
	@GetMapping()
	public String tbWorkday()
	{
	    return prefix + "/tbWorkday";
	}
	
	/**
	 * 查询工作日列表
	 */
	@RequiresPermissions("clazz:tbWorkday:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TbWorkday tbWorkday)
	{
		startPage();
        List<TbWorkday> list = tbWorkdayService.selectTbWorkdayList(tbWorkday);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出工作日列表
	 */
	@RequiresPermissions("clazz:tbWorkday:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbWorkday tbWorkday)
    {
    	List<TbWorkday> list = tbWorkdayService.selectTbWorkdayList(tbWorkday);
        ExcelUtil<TbWorkday> util = new ExcelUtil<TbWorkday>(TbWorkday.class);
        return util.exportExcel(list, "tbWorkday");
    }
	
	/**
	 * 新增工作日
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存工作日
	 */
	@RequiresPermissions("clazz:tbWorkday:add")
	@Log(title = "工作日", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TbWorkday tbWorkday)
	{		
		return toAjax(tbWorkdayService.insertTbWorkday(tbWorkday));
	}

	/**
	 * 修改工作日
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap map)
	{
		TbWorkday tbWorkday = tbWorkdayService.selectTbWorkdayById(id);
		map.put("tbWorkday", tbWorkday);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存工作日
	 */
	@RequiresPermissions("clazz:tbWorkday:edit")
	@Log(title = "工作日", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TbWorkday tbWorkday)
	{		
		return toAjax(tbWorkdayService.updateTbWorkday(tbWorkday));
	}
	
	/**
	 * 删除工作日
	 */
	@RequiresPermissions("clazz:tbWorkday:remove")
	@Log(title = "工作日", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tbWorkdayService.deleteTbWorkdayByIds(ids));
	}
	
}
