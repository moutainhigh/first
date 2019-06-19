package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.AppPermissionEntity;
/**
 * 权限控制DAO
 * @author 276344
 *
 */
public interface IAppPermissionDao {
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
