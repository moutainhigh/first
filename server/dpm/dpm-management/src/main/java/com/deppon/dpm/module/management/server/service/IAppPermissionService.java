package com.deppon.dpm.module.management.server.service;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.AppPermissionEntity;
/**
 * 应用权限控制
 * 组织权限（orgid） 员工权限（userid）  层级权限(level) 全员权限(当某个应用的所有权限的status为off时即为全员权限)
 * @author 276344
 *
 */
public interface IAppPermissionService {
	/**
	 * 获取应用权限
	 * @param condition
	 */
	public List<AppPermissionEntity> getAppPermission(int appid);
	/**
	 * 根据工号获取组织序列
	 * @param userId
	 * @return
	 */
	public String getDeptSeqByUserId(String userId);
}
