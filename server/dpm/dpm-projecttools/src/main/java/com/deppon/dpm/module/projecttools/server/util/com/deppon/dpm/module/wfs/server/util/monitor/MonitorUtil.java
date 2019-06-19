
package com.deppon.dpm.module.projecttools.server.util.com.deppon.dpm.module.wfs.server.util.monitor;

import com.deppon.dpm.module.projecttools.server.service.IDppmMonitorService;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectMonitroInfo;




/**
 * TODO 项目管理工具数据监控
 * @author 石学钢
 * 上午10:14:28
 */
public class MonitorUtil {
public void dateMonitor(String  usId, String type, String details, IDppmMonitorService dppmMonitorService){
	//用线程实现数据监控插入操作
	ProjectMonitroInfo milestoneInfo = new ProjectMonitroInfo();
	milestoneInfo.setUserId(usId);
	milestoneInfo.setType(type);
	milestoneInfo.setDetails(details);
	MonitorRunnableUtil run = new MonitorRunnableUtil();
	run.dppmMonitorService = dppmMonitorService;
	run.monitroInfo = milestoneInfo;
	//用线程保存监控数据
	Thread thread = new Thread(run);
	thread.start();
}
}
