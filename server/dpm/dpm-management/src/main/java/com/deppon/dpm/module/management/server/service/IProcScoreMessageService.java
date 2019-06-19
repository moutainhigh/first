package com.deppon.dpm.module.management.server.service;

import java.util.List;

import com.deppon.foss.framework.exception.BusinessException;

/**
 * 根据id查找评分详细的service层接口
 * @author 曹嵩
 * @date 2015.7.17
 *
 */
public interface IProcScoreMessageService {

	/**
	 * 根据id查找评分详细信息
	 * @param id 页面传过来的id
	 * @return 评分详细信息
	 */
	public List<Object> queryprocScoreMess(String id) throws BusinessException;
}
