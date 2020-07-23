package com.jy.web.controller.clazz;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.jy.common.utils.StringUtils;
import com.jy.common.utils.poi.ExcelUtils;
import com.jy.system.domain.TbJyData;
import com.jy.system.domain.vo.JyDataVo;
import com.jy.system.domain.vo.TbJyDataVO;
import com.jy.system.service.ITbJyDataService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
import org.springframework.web.multipart.MultipartFile;

/**
 * 报 信息操作处理
 * 
 * @author jy
 * @date 2019-08-13
 */
@Controller
@RequestMapping("/clazz/tbJyData")
public class TbJyDataController extends BaseController
{
    private String prefix = "clazz/tbJyData";
    private String prefixs = "clazz/selectAVG";

	@Autowired
	private ITbJyDataService tbJyDataService;
	
	@RequiresPermissions("clazz:tbJyData:view")
	@GetMapping()
	public String tbJyData()
	{
	    return prefix + "/tbJyData";
	}
	
	/**
	 * 查询报列表
	 */
	@RequiresPermissions("clazz:tbJyData:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TbJyData tbJyData)
	{
		startPage();
        List<TbJyData> list = tbJyDataService.selectTbJyDataList(tbJyData);
		return getDataTable(list);
	}

	@RequiresPermissions("clazz:tbJyData:selectAvgView")
	@GetMapping("/avg")
	public String selectAVG()
	{
		return prefixs + "/dataset-link";
	}

	@RequiresPermissions("clazz:tbJyData:selectAVG")
	@GetMapping("/selectAVG")
	@ResponseBody
	public AjaxResult selectAVG(String days)
	{
		List<JyDataVo> list = tbJyDataService.selectAVG(days);
		if(list.size()>0)
			return AjaxResult.success("操作成功",changeList(list,list.size()));
		else
			return AjaxResult.error("操作失败");
	}
	public static void main(String[] args){
		List<JyDataVo> list = new ArrayList<>();

		JyDataVo j = new JyDataVo();
		j.setA("1");
		j.setB("2");
		j.setC("3");
		j.setD("4");
		j.setE("5");
		j.setF("6");
		j.setG("7");
		j.setH("8");
		j.setI("9");
		j.setJ("10");
		j.setK("11");
		j.setL("12");
		JyDataVo jj = new JyDataVo();
		jj.setA("1");
		jj.setB("2");
		jj.setC("3");
		jj.setD("4");
		jj.setE("5");
		jj.setF("6");
		jj.setG("7");
		jj.setH("8");
		jj.setI("9");
		jj.setJ("10");
		jj.setK("11");
		jj.setL("12");
		list.add(j);
		list.add(jj);
		System.out.println(changeList(list,list.size()).toString());

	}

	/**
	 * 转为二维数组
	 * @param list
	 * @param size
	 * @return
	 */
	private static String [][] changeList( List<JyDataVo> list,int size){
		String [][] objArray = new String[size+1][13];
		for(int i=0;i< list.size()+1;i++){
			if(i==0){
				objArray[i][0] = "Particular year";
				objArray[i][1] = "1";
				objArray[i][2] = "2";
				objArray[i][3] = "3";
				objArray[i][4] = "4";
				objArray[i][5] = "5";
				objArray[i][6] = "6";
				objArray[i][7] = "7";
				objArray[i][8] = "8";
				objArray[i][9] = "9";
				objArray[i][10] = "10";
				objArray[i][11] = "11";
				objArray[i][12] = "12";
			}else{
				objArray[i][0] = list.get(i-1).getUserName();
				objArray[i][1] = list.get(i-1).getA();
				objArray[i][2] = list.get(i-1).getB();
				objArray[i][3] = list.get(i-1).getC();
				objArray[i][4] = list.get(i-1).getD();
				objArray[i][5] = list.get(i-1).getE();
				objArray[i][6] = list.get(i-1).getF();
				objArray[i][7] = list.get(i-1).getG();
				objArray[i][8] = list.get(i-1).getH();
				objArray[i][9] = list.get(i-1).getI();
				objArray[i][10] = list.get(i-1).getJ();
				objArray[i][11] = list.get(i-1).getK();
				objArray[i][12] = list.get(i-1).getL();
			}
		}
		System.out.println(objArray);
		return objArray;
	}

	@RequiresPermissions("clazz:tbJyData:operation")
	@GetMapping("/operation")
	@ResponseBody
	public TableDataInfo operation(TbJyData tbJyData)
	{
		int sum=0;
		int to = 0;
		int tos = 0;
		boolean is = false;
        List<TbJyData> list = tbJyDataService.selectTbJyDataList(tbJyData);
		List<TbJyDataVO> lists = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#.##");
		double v = 0;
		for (TbJyData t:list) {
			TbJyDataVO td = new TbJyDataVO();
			if(sum<=list.size()){
				if(StringUtils.isNotEmpty(String.valueOf(t.getUserNum()))&&StringUtils.isNotEmpty(t.getR6())){
					if(sum+1<=list.size()-1){
						if(StringUtils.isNotEmpty(list.get(sum+1).getR6())){
							if(t.getD().equals(list.get(sum+1).getD())){
								if(t.getO6().substring(0,t.getO6().lastIndexOf("-")).equals(list.get(sum+1).getO6().substring(0,t.getO6().lastIndexOf("-")))){
									to += t.getUserNum();
									tos += Integer.parseInt(t.getP6());
								}else{
									to += t.getUserNum();
									tos += Integer.parseInt(t.getP6());
									v = (double) to / (double) tos * 100;

									df.setRoundingMode(RoundingMode.DOWN);
									System.out.println(df.format(v));
									td.setClassAvg(df.format(v));
									td.setClassName(t.getD());
									lists.add(td);

								}
							}else{
								to += t.getUserNum();
								tos += Integer.parseInt(t.getP6());
								td.setClassAvg(df.format(v));
								td.setClassName(t.getD());
								lists.add(td);
								to = 0;
								tos = 0;
							}
						}else{
							to += t.getUserNum();
							tos += Integer.parseInt(t.getP6());
							td.setClassAvg(df.format(v));
							td.setClassName(t.getD());
							lists.add(td);
							to = 0;
							tos = 0;
						}
					}
				}
			}
			sum++;
		}
		return getDataTable(lists);
	}

	
	/**
	 * 导出报列表
	 */
	@RequiresPermissions("clazz:tbJyData:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbJyData tbJyData)
    {
    	List<TbJyData> list = tbJyDataService.selectTbJyDataList(tbJyData);
        ExcelUtil<TbJyData> util = new ExcelUtil<TbJyData>(TbJyData.class);
        return util.exportExcel(list, "tbJyData");
    }
	
	/**
	 * 新增报
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存报
	 */
	@RequiresPermissions("clazz:tbJyData:add")
	@Log(title = "新增保存报", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TbJyData tbJyData)
	{		
		return toAjax(tbJyDataService.insertTbJyData(tbJyData));
	}

	/**
	 * 修改报
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap map)
	{
		TbJyData tbJyData = tbJyDataService.selectTbJyDataById(id);
		map.put("tbJyData", tbJyData);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存报
	 */
	@RequiresPermissions("clazz:tbJyData:edit")
	@Log(title = "修改保存报", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TbJyData tbJyData)
	{		
		return toAjax(tbJyDataService.updateTbJyData(tbJyData));
	}
	
	/**
	 * 删除报
	 */
	@RequiresPermissions("clazz:tbJyData:remove")
	@Log(title = "删除报", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tbJyDataService.deleteTbJyDataByIds(ids));
	}

	@Transactional(rollbackFor = Exception.class)
	@RequiresPermissions("clazz:tbJyData:importExcel")
	@Log(title = "报表数据导入", businessType = BusinessType.DELETE)
	@PostMapping( "/importExcel")
	@ResponseBody
	public AjaxResult importExcel(MultipartFile file)throws Exception
	{
		ExcelUtils<TbJyData> util = new ExcelUtils<TbJyData>(TbJyData.class);
		List<TbJyData> userList = util.importExcel(file.getInputStream(),1);
		return AjaxResult.success(tbJyDataService.importTbStudentinfo(userList));
	}
}
