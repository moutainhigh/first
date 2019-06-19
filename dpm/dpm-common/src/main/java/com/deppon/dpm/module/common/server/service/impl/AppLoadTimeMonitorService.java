package com.deppon.dpm.module.common.server.service.impl;

import com.deppon.dpm.module.common.server.dao.IAppLoadTimeMonitorDao;
import com.deppon.dpm.module.common.server.service.IAppLoadTimeMonitorService;
import com.deppon.dpm.module.common.shared.domain.AppLoadTimeMonitorEntity;

public class AppLoadTimeMonitorService implements IAppLoadTimeMonitorService{

	private IAppLoadTimeMonitorDao appLoadTimeMonitorDao;

	public void save(AppLoadTimeMonitorEntity entity) {
		appLoadTimeMonitorDao.save(entity);
	}
	
	public void setAppLoadTimeMonitorDao(
			IAppLoadTimeMonitorDao appLoadTimeMonitorDao) {
		this.appLoadTimeMonitorDao = appLoadTimeMonitorDao;
	}
	
}
