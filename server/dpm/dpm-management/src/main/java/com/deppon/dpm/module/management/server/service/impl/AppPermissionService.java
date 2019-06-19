package com.deppon.dpm.module.management.server.service.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.IAppPermissionDao;
import com.deppon.dpm.module.management.server.service.IAppPermissionService;
import com.deppon.dpm.module.management.shared.domain.AppPermissionEntity;

public class AppPermissionService implements IAppPermissionService {
	private IAppPermissionDao permissionDao;
	
	@Override
	public List<AppPermissionEntity> getAppPermission(
			int appid) {
		// TODO Auto-generated method stub
		
		return permissionDao.getAppPermission(appid);
	}

	@Override
	public String getDeptSeqByUserId(String userId) {
		// TODO Auto-generated method stub
		return permissionDao.getDeptSeqByUserId(userId);
	}
	
	public void setPermissionDao(IAppPermissionDao permissionDao) {
		this.permissionDao = permissionDao;
	}


}
