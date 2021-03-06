package com.deppon.dpm.module.common.server.service;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.NazaInvokeMonitorEntity;

/**
 * Naza接口调用监控的Service
 */
public interface INazaInvokeMonitorService {

	/**
	 * 插入信息
	 */
	int save(NazaInvokeMonitorEntity entity);

	/**
	 * 条件查询
	 */
	List<NazaInvokeMonitorEntity> queryByCondition(
			NazaInvokeMonitorEntity entity);

}
