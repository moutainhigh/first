package com.deppon.dpm.module.management.server.service;


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
	public String hasBiPermission(String userId);
}
