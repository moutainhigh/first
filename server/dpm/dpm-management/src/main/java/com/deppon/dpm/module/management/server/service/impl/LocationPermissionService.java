package com.deppon.dpm.module.management.server.service.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.IAppPermissionDao;
import com.deppon.dpm.module.management.server.dao.ILocationPermissionDao;
import com.deppon.dpm.module.management.server.service.IAppPermissionService;
import com.deppon.dpm.module.management.server.service.ILocationPermissionService;
import com.deppon.dpm.module.management.shared.domain.AppPermissionEntity;
import com.deppon.dpm.module.management.shared.domain.LocationPermissionEntity;

public class LocationPermissionService implements ILocationPermissionService {
	private ILocationPermissionDao locationPermissionDao;

	@Override
	public List<LocationPermissionEntity> getLocationPermission() {
		// TODO Auto-generated method stub
		return locationPermissionDao.getLocationPermission();
	}

	public void setLocationPermissionDao(
			ILocationPermissionDao locationPermissionDao) {
		this.locationPermissionDao = locationPermissionDao;
	}
	



}
