package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.LocationPermissionEntity;

public interface ILocationPermissionDao {

	List<LocationPermissionEntity> getLocationPermission();

}
