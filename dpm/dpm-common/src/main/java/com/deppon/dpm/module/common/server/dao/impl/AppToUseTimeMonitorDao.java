package com.deppon.dpm.module.common.server.dao.impl;

import com.deppon.dpm.module.common.server.dao.IAppToUseTimeMonitorDao;
import com.deppon.dpm.module.common.shared.domain.AppToUseTimeMonitorEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class AppToUseTimeMonitorDao extends iBatis3DaoImpl implements IAppToUseTimeMonitorDao{

	private static final String NAME_SPACE = "com.deppon.dpm.module.common.server.dao.impl.AppToUseTimeMonitorDao.";

	@Override
	public void save(AppToUseTimeMonitorEntity entity) {
		this.getSqlSession().insert(NAME_SPACE + "save", entity);
	}
}
