package com.deppon.dpm.module.common.server.service.impl;

import com.deppon.dpm.module.common.server.dao.ILoginInfoMonitorDao;
import com.deppon.dpm.module.common.server.service.ILoginInfoMonitorService;
import com.deppon.dpm.module.common.shared.domain.LoginInfoMonitorEntity;
import com.deppon.dpm.module.common.shared.vo.MobileInfoVo;

public class LoginInfoMonitorService implements ILoginInfoMonitorService{
	
	private ILoginInfoMonitorDao loginInfoMonitorDao;

	/**
	 * 保存登录信息
	 */
	public void saveLoginInfo(LoginInfoMonitorEntity entity) {
		loginInfoMonitorDao.saveLoginInfo(entity);
	}
	
	/**
	 * 保存手机信息
	 */
	public void saveMobileInfo(MobileInfoVo moVo) {
		loginInfoMonitorDao.saveMobileInfo(moVo);
	}
	

	/**
	 * setter
	 */
	public void setLoginInfoMonitorDao(ILoginInfoMonitorDao loginInfoMonitorDao) {
		this.loginInfoMonitorDao = loginInfoMonitorDao;
	}

	
}
