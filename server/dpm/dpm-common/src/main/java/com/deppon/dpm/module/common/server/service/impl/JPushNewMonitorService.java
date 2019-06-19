package com.deppon.dpm.module.common.server.service.impl;

import com.deppon.dpm.module.common.server.dao.IJPushNewMonitorDao;
import com.deppon.dpm.module.common.server.service.IJPushNewMonitorService;
import com.deppon.dpm.module.common.shared.domain.JpushMonitorEntity;

public class JPushNewMonitorService implements IJPushNewMonitorService{
	
	private IJPushNewMonitorDao jPushNewMonitorDao;
	
	/**
	 * 保存推送监控信息
	 */
	public void savePushInfo(JpushMonitorEntity monitorResult) {
		jPushNewMonitorDao.savePushInfo(monitorResult);
	}

	public void setjPushNewMonitorDao(IJPushNewMonitorDao jPushNewMonitorDao) {
		this.jPushNewMonitorDao = jPushNewMonitorDao;
	}
}
