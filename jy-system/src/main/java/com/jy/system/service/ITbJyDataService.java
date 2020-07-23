package com.jy.system.service;

import com.jy.system.domain.TbJyData;
import com.jy.system.domain.TbStudentinfo;
import com.jy.system.domain.vo.JyDataVo;
import com.jy.system.domain.vo.TbJyDataVO;

import java.util.List;

/**
 * 报 服务层
 * 
 * @author jy
 * @date 2019-08-13
 */
public interface ITbJyDataService 
{
	/**
     * 查询报信息
     * 
     * @param id 报ID
     * @return 报信息
     */
	public TbJyData selectTbJyDataById(String id);
	
	/**
     * 查询报列表
     * 
     * @param tbJyData 报信息
     * @return 报集合
     */
	public List<TbJyData> selectTbJyDataList(TbJyData tbJyData);
	
	/**
     * 新增报
     * 
     * @param tbJyData 报信息
     * @return 结果
     */
	public int insertTbJyData(TbJyData tbJyData);
	
	/**
     * 修改报
     * 
     * @param tbJyData 报信息
     * @return 结果
     */
	public int updateTbJyData(TbJyData tbJyData);
		
	/**
     * 删除报信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTbJyDataByIds(String ids);

    String importTbStudentinfo(List<TbJyData> userList);

	List<JyDataVo> selectAVG(String days);
}
