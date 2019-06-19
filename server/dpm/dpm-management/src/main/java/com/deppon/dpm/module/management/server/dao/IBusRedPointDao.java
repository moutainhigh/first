package com.deppon.dpm.module.management.server.dao;

import com.deppon.foss.framework.exception.BusinessException;

/**
 * 显示用户评价表与开线建议表中间表的总数、评价管理建议回复表总数、评价管理评价回复表总数的dao层接口
 * @author 曹嵩
 * @date 2015.7.3
 */
public interface IBusRedPointDao {

	/**
	 * 得到用户评价表与开线建议表中间表的总数
	 * @return 总数
	 * @throws BusinessException
	 */
	public int getBusCentreAdviceByCount(String userId) throws BusinessException;
	
	/**
	 * 得到评价管理建议回复表总数
	 * @return 总数
	 * @throws BusinessException
	 */
	public int getBusEvaluationAdviceByCount(String userId) throws BusinessException;

	/**
	 * 得到评价管理评价回复表总数
	 * @return 总数
	 * @throws BusinessException
	 */
	public int getBusEvaluationManageByCount(String userId) throws BusinessException;
}
