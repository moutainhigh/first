package com.deppon.dpm.module.management.server.service;

import com.deppon.foss.framework.exception.BusinessException;

public interface IProcMaintainRightControlService {

	/**
	 * 工程权限控制
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public String checkRightControl(String str) throws BusinessException;
}
