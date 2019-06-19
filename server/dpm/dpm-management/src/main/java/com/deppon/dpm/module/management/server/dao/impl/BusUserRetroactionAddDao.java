package com.deppon.dpm.module.management.server.dao.impl;

import com.deppon.dpm.module.management.server.dao.IBusUserRetroactionAddDao;
import com.deppon.dpm.module.management.shared.domain.BusUserRetroactionEntity;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 添加用户评价的dao层实现接口
 * @author 曹嵩
 * @date 2015.6.30
 */
public class BusUserRetroactionAddDao extends iBatis3DaoImpl implements IBusUserRetroactionAddDao{

	String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.bussiteview";
	/**
	 * 添加用户评价方法
	 * @throws BusinessException
	 */
	@Override
	public int saveBusUserRetroaction(BusUserRetroactionEntity bure) throws BusinessException {
		return getSqlSession().insert(mapperNameSpace+".insertEvaluationAdvice",bure);
	}
	/**
	 * 根据时间得到用户评价表的Id
	 * @return 实体类
	 * @throws BusinessException
	 */
	@Override
	public int getBusUserRetroaction(BusUserRetroactionEntity bure)
			throws BusinessException {
		return (Integer) getSqlSession().selectOne(mapperNameSpace+".queryBusUserRetroaction", bure);
	}


	
}
