package com.deppon.dpm.module.common.server.service.impl;

import com.deppon.dpm.module.common.server.dao.IAppToUseTimeMonitorDao;
import com.deppon.dpm.module.common.server.service.IAppToUseTimeMonitorService;
import com.deppon.dpm.module.common.shared.domain.AppToUseTimeMonitorEntity;

public class AppToUseTimeMonitorService implements IAppToUseTimeMonitorService{

	private IAppToUseTimeMonitorDao appToUseTimeMonitorDao;
	
	@Override
	public void save(AppToUseTimeMonitorEntity entity) {
		appToUseTimeMonitorDao.save(entity);
	}

	public void setAppToUseTimeMonitorDao(
			IAppToUseTimeMonitorDao appToUseTimeMonitorDao) {
		this.appToUseTimeMonitorDao = appToUseTimeMonitorDao;
	}
	
}
