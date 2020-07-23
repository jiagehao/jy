package com.jy.system.service.impl;

import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.jy.common.exception.BusinessException;
import com.jy.common.json.JSONObject;
import com.jy.common.utils.StringUtils;
import com.jy.common.utils.bean.UuidUtil;
import com.jy.system.domain.TbJyData;
import com.jy.system.domain.vo.JyDataVo;
import com.jy.system.domain.vo.TbJyDataVO;
import com.jy.system.mapper.TbJyDataMapper;
import com.jy.system.service.ITbJyDataService;
import com.mysql.cj.xdevapi.JsonArray;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jy.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 报 服务层实现
 * 
 * @author jy
 * @date 2019-08-13
 */
@Service
public class TbJyDataServiceImpl implements ITbJyDataService
{
	private static final Logger log = LoggerFactory.getLogger(TbJyDataServiceImpl.class);
	@Autowired
	private TbJyDataMapper tbJyDataMapper;

	/**
     * 查询报信息
     * 
     * @param id 报ID
     * @return 报信息
     */
    @Override
	public TbJyData selectTbJyDataById(String id)
	{
	    return tbJyDataMapper.selectTbJyDataById(id);
	}
	
	/**
     * 查询报列表
     * 
     * @param tbJyData 报信息
     * @return 报集合
     */
	@Override
	public List<TbJyData> selectTbJyDataList(TbJyData tbJyData)
	{
	    return tbJyDataMapper.selectTbJyDataList(tbJyData);
	}
	
    /**
     * 新增报
     * 
     * @param tbJyData 报信息
     * @return 结果
     */
	@Override
	public int insertTbJyData(TbJyData tbJyData)
	{
	    return tbJyDataMapper.insertTbJyData(tbJyData);
	}
	
	/**
     * 修改报
     * 
     * @param tbJyData 报信息
     * @return 结果
     */
	@Override
	public int updateTbJyData(TbJyData tbJyData)
	{
	    return tbJyDataMapper.updateTbJyData(tbJyData);
	}

	/**
     * 删除报对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTbJyDataByIds(String ids)
	{
		return tbJyDataMapper.deleteTbJyDataByIds(Convert.toStrArray(ids));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public String importTbStudentinfo(List<TbJyData> userList) {
		if (StringUtils.isNull(userList) || userList.size() == 0)
		{
			throw new BusinessException("导入用户数据不能为空！");
		}

		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();


		for (TbJyData info : userList)
		{
			try
			{
				if(StringUtils.isNotEmpty(info.getA())){
					if(!"所属校区".equals(info.getA())){
						info.setId(UuidUtil.get32UUID());
						String d = info.getD();
						info.setD(info.getD().substring(info.getD().indexOf("马")+1,info.getD().lastIndexOf("就")));
						info.setClassName(Integer.parseInt(d.substring(d.indexOf("业")+1,d.lastIndexOf("期"))));
						if(StringUtils.isNotEmpty(info.getR2())){
							DecimalFormat df = new DecimalFormat("#.##");
							df.setRoundingMode(RoundingMode.DOWN);
							info.setR2(df.format(Double.parseDouble(info.getR2())*100));
						}
						if(StringUtils.isNotEmpty(info.getR4())){
							DecimalFormat df = new DecimalFormat("#.##");
							df.setRoundingMode(RoundingMode.DOWN);
							info.setR4(df.format(Double.parseDouble(info.getR4())*100));
						}
						if(StringUtils.isNotEmpty(info.getR6())){
							DecimalFormat df = new DecimalFormat("#.##");
							df.setRoundingMode(RoundingMode.DOWN);
							info.setR6(df.format(Double.parseDouble(info.getR6())*100));
							info.setUserNum((int) Math.round(Double.parseDouble(info.getP6()) * Double.parseDouble(info.getR6()) * 100 * 0.01) );
						}
						if(StringUtils.isNotEmpty(info.getG())){
							info.setG(dat(info.getG()));
						}
						if(StringUtils.isNotEmpty(info.getO2())){
							info.setO2(dat(info.getO2()));
						}
						if(StringUtils.isNotEmpty(info.getO4())){
							info.setO4(dat(info.getO4()));
						}
						if(StringUtils.isNotEmpty(info.getO6())){
							info.setO6(dat(info.getO6()));
						}
						tbJyDataMapper.insertTbJyData(info);
						successNum++;
						successMsg.append("<br/>" + successNum + "、班级 " + info.getD() + " 导入成功");
					}
				}

			}
			catch (Exception e)
			{
				failureNum++;
				String msg = "<br/>" + failureNum + "、班级 " + info.getD() + " 导入失败：";
				failureMsg.append(msg + e.getMessage());
				log.error(msg, e);
			}
		}
		if (failureNum > 0)
		{
			failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
			throw new BusinessException(failureMsg.toString());
		}
		else
		{
			successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
		}
		return successMsg.toString();
	}

	@Override
	public List<JyDataVo> selectAVG(String days) {
		if(StringUtils.isEmpty(days)){
			days="2018";
		}
		return tbJyDataMapper.selectAVG(days);
	}


	private String dat(String d){
		try {
			SimpleDateFormat sf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
			Date parse = sf.parse(d);
			SimpleDateFormat sfs = new SimpleDateFormat("yyyy-MM-dd");
			return sfs.format(parse);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}


}
