package com.deppon.dpm.module.management.server.dao;

import com.deppon.dpm.module.management.shared.domain.BusUserRetroactionEntity;

/**
 * 添加用户评价的dao层接口
 * @author 曹嵩
 * @date 2015.6.30
 */
public interface IBusUserRetroactionAddDao {

	/**
	 * 添加用户评价方法
	 * @throws Exception
	 */
	public int saveBusUserRetroaction(BusUserRetroactionEntity bure) throws Exception;
	
	/**
	 * 根据时间得到用户评价表的Id
	 * @return 实体类
	 * @throws Exception
	 */
	public int getBusUserRetroaction(BusUserRetroactionEntity bure) throws Exception;
}
