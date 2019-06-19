package com.deppon.dpm.module.common.server.util;

import com.deppon.dpm.module.common.server.service.IMonitorActionInfoService;
import com.deppon.dpm.module.common.shared.domain.MonitorActionInfo;

/**
 * 线程保存监控Action访问详情
 *
 */
public class MonitorActionRunnableUtil implements Runnable {
	/**
	 * monitorActionService
	 */
	public IMonitorActionInfoService monitorActionService;

	// 保存的监控Action详情实体类
	public MonitorActionInfo actionInfo;

	/**
	 * 线程保存监控Action访问详情
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// 调用数据监控的保存方法
		try {
			monitorActionService.saveActionInfo(actionInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
