package com.jy.system.service.impl;


import com.jy.common.core.text.Convert;
import com.jy.common.utils.bean.UuidUtil;
import com.jy.system.domain.TbSubject;
import com.jy.system.mapper.TbSubjectMapper;
import com.jy.system.service.ITbSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学科 服务层实现
 * 
 * @author jy
 * @date 2019-04-08
 */
@Service
public class TbSubjectServiceImpl implements ITbSubjectService
{
	@Autowired
	private TbSubjectMapper tbSubjectMapper;

	/**
     * 查询学科信息
     * 
     * @param subjectId 学科ID
     * @return 学科信息
     */
    @Override
	public TbSubject selectTbSubjectById(String subjectId)
	{
	    return tbSubjectMapper.selectTbSubjectById(subjectId);
	}
	
	/**
     * 查询学科列表
     * 
     * @param tbSubject 学科信息
     * @return 学科集合
     */
	@Override
	public List<TbSubject> selectTbSubjectList(TbSubject tbSubject)
	{
	    return tbSubjectMapper.selectTbSubjectList(tbSubject);
	}
	
    /**
     * 新增学科
     * 
     * @param tbSubject 学科信息
     * @return 结果
     */
	@Override
	public int insertTbSubject(TbSubject tbSubject)
	{
		tbSubject.setSubjectId(UuidUtil.get32UUID());
	    return tbSubjectMapper.insertTbSubject(tbSubject);
	}
	
	/**
     * 修改学科
     * 
     * @param tbSubject 学科信息
     * @return 结果
     */
	@Override
	public int updateTbSubject(TbSubject tbSubject)
	{
	    return tbSubjectMapper.updateTbSubject(tbSubject);
	}

	/**
     * 删除学科对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTbSubjectByIds(String ids)
	{
		return tbSubjectMapper.deleteTbSubjectByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<TbSubject> TbSubjectList() {
		return tbSubjectMapper.TbSubjectList();
	}

}
