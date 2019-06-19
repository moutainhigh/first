package com.deppon.dpm.module.common.server.service.impl;

import com.deppon.dpm.module.common.server.dao.ILoginInfoMonitorDao;
import com.deppon.dpm.module.common.server.service.ILoginInfoMonitorService;
import com.deppon.dpm.module.common.shared.domain.LoginInfoMonitorEntity;

public class LoginInfoMonitorService implements ILoginInfoMonitorService{
	
	private ILoginInfoMonitorDao loginInfoMonitorDao;

	/**
	 * 保存登录信息
	 */
	public void saveLoginInfo(LoginInfoMonitorEntity entity) {
		loginInfoMonitorDao.saveLoginInfo(entity);
	}

	/**
	 * setter
	 */
	public void setLoginInfoMonitorDao(ILoginInfoMonitorDao loginInfoMonitorDao) {
		this.loginInfoMonitorDao = loginInfoMonitorDao;
	}

	
}
