package com.deppon.dpm.module.common.server.dao;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.NazaInvokeMonitorEntity;

/**
 * Naza接口调用监控的dao
 */
public interface INazaInvokeMonitorDao {
	
	/**
	 * 	保存
	 */
	int save(NazaInvokeMonitorEntity entity);
	
	/**
	 * 条件查询
	 */
	List<NazaInvokeMonitorEntity> queryByCondition(
			NazaInvokeMonitorEntity entity);

}
