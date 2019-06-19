package com.deppon.dpm.module.common.server.dao.impl;

import com.deppon.dpm.module.common.server.dao.IAppLoadTimeMonitorDao;
import com.deppon.dpm.module.common.shared.domain.AppLoadTimeMonitorEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class AppLoadTimeMonitorDao extends iBatis3DaoImpl implements IAppLoadTimeMonitorDao{

	private static final String NAME_SPACE = "com.deppon.dpm.module.common.server.dao.impl.AppLoadTimeMonitorDao.";

	public void save(AppLoadTimeMonitorEntity entity) {
		this.getSqlSession().insert(NAME_SPACE + "save", entity);
	}
}
