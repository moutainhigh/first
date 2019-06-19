package com.deppon.dpm.module.management.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.IAppPermissionDao;
import com.deppon.dpm.module.management.server.dao.ILocationPermissionDao;
import com.deppon.dpm.module.management.shared.domain.AppPermissionEntity;
import com.deppon.dpm.module.management.shared.domain.LocationPermissionEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class LocationPermissionDao extends iBatis3DaoImpl implements ILocationPermissionDao {
	/**
	 * namespace
	 */
	private static final String NAME_SPACE =  "com.deppon.dpm.module.management.server.dao.impl.LocationPermissionDao.";

	@SuppressWarnings("unchecked")
	@Override
	public List<LocationPermissionEntity> getLocationPermission() {
		// TODO Auto-generated method stub
		return  this.getSqlSession().selectList(NAME_SPACE + "getPermission");
	}
	
 
}
