package com.deppon.dpm.module.management.server.service;

public interface IProcMaintainRightControlService {

	/**
	 * 工程权限控制
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public String checkRightControl(String str) throws Exception;
}
