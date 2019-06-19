package com.deppon.dpm.module.management.server.dao;

import com.deppon.dpm.module.management.shared.domain.BusUserRetroactionEntity;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 添加用户评价的dao层接口
 * @author 曹嵩
 * @date 2015.6.30
 */
public interface IBusUserRetroactionAddDao {

	/**
	 * 添加用户评价方法
	 * @throws BusinessException
	 */
	public int saveBusUserRetroaction(BusUserRetroactionEntity bure) throws BusinessException;
	
	/**
	 * 根据时间得到用户评价表的Id
	 * @return 实体类
	 * @throws BusinessException
	 */
	public int getBusUserRetroaction(BusUserRetroactionEntity bure) throws BusinessException;
}
