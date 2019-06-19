package com.deppon.dpm.module.common.server.dao.impl;

import com.deppon.dpm.module.common.server.dao.ILeaderCallMonitorDao;
import com.deppon.dpm.module.common.shared.domain.LeaderCallMonitorEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class LeaderCallMonitorDao extends iBatis3DaoImpl implements ILeaderCallMonitorDao{

	private static final String NAME_SPACE = "com.deppon.dpm.module.common.server.dao.impl.LeaderCallMonitorDao.";

	@Override
	public void save(LeaderCallMonitorEntity entity) {
		this.getSqlSession().insert(NAME_SPACE + "save", entity);
	}
	
}
