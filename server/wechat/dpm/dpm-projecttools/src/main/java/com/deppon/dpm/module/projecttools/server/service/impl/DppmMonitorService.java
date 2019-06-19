/**
 * 
 */
package com.deppon.dpm.module.projecttools.server.service.impl;

import com.deppon.dpm.module.projecttools.server.dao.IDppmMonitorDao;
import com.deppon.dpm.module.projecttools.server.service.IDppmMonitorService;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectMonitroInfo;

/**
 * TODO 数据监控
 * @author 石学钢
 * 2015-9-16
 */
public class DppmMonitorService implements IDppmMonitorService{
	//数据监控
	private IDppmMonitorDao monitorDaoimp;

	/**
	 * @param monitorDaoimp the monitorDaoimp to set
	 */
	public void setMonitorDaoimp(IDppmMonitorDao monitorDaoimp) {
		this.monitorDaoimp = monitorDaoimp;
	}

	/** 
	 * TODO 项目管理工具数据监控
	 * @author 石学钢
	 * 2015-9-16
	 * @see com.deppon.dpm.module.projecttools.server.service.IDppmMonitorService#InsertMonitor(com.deppon.dpm.module.projecttools.shared.domain.ProjectMonitroInfo)
	 */
	@Override
	public void insertMonitor(ProjectMonitroInfo monitroInfo) throws Exception {
			monitorDaoimp.insertMonitor(monitroInfo);
	}

}
