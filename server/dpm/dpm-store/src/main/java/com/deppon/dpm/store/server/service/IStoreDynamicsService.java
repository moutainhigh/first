package com.deppon.dpm.store.server.service;

import com.deppon.dpm.store.server.entity.StoreDynamics;
/**
 * 
 * @author XiaoTian
 *
 */
public interface IStoreDynamicsService {
	
	/**
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(StoreDynamics record);

}
