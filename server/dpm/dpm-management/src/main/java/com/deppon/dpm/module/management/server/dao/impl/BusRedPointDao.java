package com.deppon.dpm.module.management.server.dao.impl;

import com.deppon.dpm.module.management.server.dao.IBusRedPointDao;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 显示用户评价表与开线建议表中间表的总数、评价管理建议回复表总数、评价管理评价回复表总数的dao层实现接口
 * 
 * @author 曹嵩
 * @date 2015.7.3
 */
public class BusRedPointDao extends iBatis3DaoImpl implements IBusRedPointDao {

	String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.bussiteview";

	/**
	 * 得到用户评价表与开线建议表中间表的总数
	 * 
	 * @return 总数
	 * @throws BusinessException
	 */
	@Override
	public int getBusCentreAdviceByCount(String userId) throws BusinessException {
		return (Integer) getSqlSession().selectOne(
				mapperNameSpace + ".queryBusCentreAdvice", userId);
	}

	/**
	 * 得到评价管理建议回复表总数
	 * 
	 * @return 总数
	 * @throws BusinessException
	 */
	@Override
	public int getBusEvaluationAdviceByCount(String userId) throws BusinessException {
		return (Integer) getSqlSession().selectOne(
				mapperNameSpace + ".queryBusEvaluationAdvice", userId);
	}

	/**
	 * 得到评价管理评价回复表总数
	 * 
	 * @return 总数
	 * @throws BusinessException
	 */
	@Override
	public int getBusEvaluationManageByCount(String userId) throws BusinessException {
		return (Integer) getSqlSession().selectOne(
				mapperNameSpace + ".queryBusEvaluationManage", userId);
	}

}
