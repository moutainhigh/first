package com.deppon.dpm.module.management.server.service;


/**
 * 判断有没有魔镜权限
 * @author 276344
 *
 */
public interface IBigDataAppPermissionService {
	/**
	 * 判断此工号有无魔镜权限
	 * @param userId
	 * @return
	 */
	public String hasBigDataAppPermission(String userId);
}
