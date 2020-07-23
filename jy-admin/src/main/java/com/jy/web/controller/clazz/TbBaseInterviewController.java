package com.jy.web.controller.clazz;

import java.util.List;

import com.jy.common.utils.layUI.LayUi;
import com.jy.system.domain.TbBaseInterview;
import com.jy.system.service.ITbBaseInterviewService;
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
 * 三天一访谈 信息操作处理
 * 
 * @author jy
 * @date 2019-05-16
 */
@Controller
@RequestMapping("/clazz/tbBaseInterview")
public class TbBaseInterviewController extends BaseController
{
    private String prefix = "clazz/tbBaseInterview";
	
	@Autowired
	private ITbBaseInterviewService tbBaseInterviewService;
	
	@RequiresPermissions("clazz:tbBaseInterview:view")
	@GetMapping()
	public String tbBaseInterview()
	{
	    return prefix + "/tbBaseInterview";
	}
	
	/**
	 * 查询三天一访谈列表
	 */
	@RequiresPermissions("clazz:tbBaseInterview:list")
	@GetMapping("/list")
	@ResponseBody
	public LayUi list(TbBaseInterview tbBaseInterview)
	{
		startPage();
        List<TbBaseInterview> list = tbBaseInterviewService.selectTbBaseInterviewList(tbBaseInterview);
		return LayUi.data(20,list,"操作成功");
	}
	
	
	/**
	 * 导出三天一访谈列表
	 */
	@RequiresPermissions("clazz:tbBaseInterview:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbBaseInterview tbBaseInterview)
    {
    	List<TbBaseInterview> list = tbBaseInterviewService.selectTbBaseInterviewList(tbBaseInterview);
        ExcelUtil<TbBaseInterview> util = new ExcelUtil<TbBaseInterview>(TbBaseInterview.class);
        return util.exportExcel(list, "tbBaseInterview");
    }
	
	/**
	 * 新增三天一访谈
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存三天一访谈
	 */
	@RequiresPermissions("clazz:tbBaseInterview:add")
	@Log(title = "三天一访谈", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TbBaseInterview tbBaseInterview)
	{		
		return toAjax(tbBaseInterviewService.insertTbBaseInterview(tbBaseInterview));
	}

	/**
	 * 修改三天一访谈
	 */
	@GetMapping("/edit/{interviewid}")
	public String edit(@PathVariable("interviewid") String interviewid, ModelMap map)
	{
		TbBaseInterview tbBaseInterview = tbBaseInterviewService.selectTbBaseInterviewById(interviewid);
		map.put("tbBaseInterview", tbBaseInterview);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存三天一访谈
	 */
	@RequiresPermissions("clazz:tbBaseInterview:edit")
	@Log(title = "三天一访谈", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TbBaseInterview tbBaseInterview)
	{		
		return toAjax(tbBaseInterviewService.updateTbBaseInterview(tbBaseInterview));
	}



	/**
	 * 修改保存三天一访谈
	 */
	@Log(title = "三天一访谈", businessType = BusinessType.UPDATE)
	@PostMapping("/editBI")
	@ResponseBody
	public AjaxResult editBI(TbBaseInterview tbBaseInterview)
	{
		return toAjax(tbBaseInterviewService.updateTbBaseInterview(tbBaseInterview));
	}

	
	/**
	 * 删除三天一访谈
	 */
	@RequiresPermissions("clazz:tbBaseInterview:remove")
	@Log(title = "三天一访谈", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String interviewid)
	{		
		return toAjax(tbBaseInterviewService.deleteTbBaseInterviewByIds(interviewid));
	}
	
}
