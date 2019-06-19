package com.deppon.dpm.module.management.server.service;

import java.rmi.RemoteException;

/**
 * 判断有没有BI权限
 * @author 276344
 *
 */
public interface IBIPermissionService {
	/**
	 * 判断此工号有无BI权限
	 * @param userId
	 * @return
	 */
	public Boolean hasBiPermission(String userId);
}
