/**
 * 
 */
package com.deppon.dpm.module.projecttools.server.util.com.deppon.dpm.module.wfs.server.util.monitor;

import com.deppon.dpm.module.projecttools.server.service.IDppmMonitorService;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectMonitroInfo;

/**
 * TODO 线程实现数据监控插入
 * @author 石学钢
 * 2015-9-16
 */
public class MonitorRunnableUtil implements Runnable{
public IDppmMonitorService dppmMonitorService;

//保存的监控实体类
public ProjectMonitroInfo monitroInfo;
	/** 
	 * TODO 线程
	 * @author 石学钢
	 * 2015-9-16
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		//调用数据监控的保存方法
		try {
			dppmMonitorService.insertMonitor(monitroInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
