package com.deppon.dpm.module.common.server.service;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.MonitorActionInfo;

/**
 * 监控Action详细信息Service接口
 *
 */
public interface IMonitorActionInfoService {

	/**
	 * 保存action执行详细信息
	 * 
	 * @param entity
	 */
	public int saveActionInfo(MonitorActionInfo entity);
	
	/**
	 * 获取需要监控的用户List
	 * 
	 * @return
	 */
	public List<String> queryMonitorEmpCodeList();
	
}
