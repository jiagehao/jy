package com.jy.web.controller.clazz;

import java.util.List;

import com.jy.common.annotation.Log;
import com.jy.common.core.controller.BaseController;
import com.jy.common.core.domain.AjaxResult;
import com.jy.common.core.page.TableDataInfo;
import com.jy.common.enums.BusinessType;
import com.jy.common.utils.poi.ExcelUtil;
import com.jy.system.domain.BaseAchievement;
import com.jy.system.service.IBaseAchievementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 基础班学生成绩 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-29
 */
@Controller
@RequestMapping("/financial/baseAchievement")
public class BaseAchievementController extends BaseController
{
    private String prefix = "financial/baseAchievement";
	
	@Autowired
	private IBaseAchievementService baseAchievementService;
	
	@RequiresPermissions("financial:baseAchievement:view")
	@GetMapping()
	public String baseAchievement()
	{
	    return prefix + "/baseAchievement";
	}
	
	/**
	 * 查询基础班学生成绩列表
	 */
	@RequiresPermissions("financial:baseAchievement:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BaseAchievement baseAchievement)
	{
		startPage();
        List<BaseAchievement> list = baseAchievementService.selectBaseAchievementList(baseAchievement);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出基础班学生成绩列表
	 */
	@RequiresPermissions("financial:baseAchievement:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BaseAchievement baseAchievement)
    {
    	List<BaseAchievement> list = baseAchievementService.selectBaseAchievementList(baseAchievement);
        ExcelUtil<BaseAchievement> util = new ExcelUtil<BaseAchievement>(BaseAchievement.class);
        return util.exportExcel(list, "baseAchievement");
    }
	
	/**
	 * 新增基础班学生成绩
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存基础班学生成绩
	 */
	@RequiresPermissions("financial:baseAchievement:add")
	@Log(title = "基础班学生成绩", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BaseAchievement baseAchievement)
	{		
		return toAjax(baseAchievementService.insertBaseAchievement(baseAchievement));
	}

	/**
	 * 修改基础班学生成绩
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap map)
	{
		BaseAchievement baseAchievement = baseAchievementService.selectBaseAchievementById(id);
		map.put("baseAchievement", baseAchievement);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存基础班学生成绩
	 */
	@RequiresPermissions("financial:baseAchievement:edit")
	@Log(title = "基础班学生成绩", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BaseAchievement baseAchievement)
	{		
		return toAjax(baseAchievementService.updateBaseAchievement(baseAchievement));
	}
	
	/**
	 * 删除基础班学生成绩
	 */
	@RequiresPermissions("financial:baseAchievement:remove")
	@Log(title = "基础班学生成绩", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(baseAchievementService.deleteBaseAchievementByIds(ids));
	}
	
}
