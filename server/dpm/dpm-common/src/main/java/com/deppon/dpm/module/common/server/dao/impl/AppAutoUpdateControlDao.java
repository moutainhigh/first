package com.deppon.dpm.module.common.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.common.server.dao.IAppAutoUpdateControlDao;
import com.deppon.dpm.module.common.shared.domain.AppAutoRefreshControlEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class AppAutoUpdateControlDao extends iBatis3DaoImpl implements IAppAutoUpdateControlDao{

	private static final String NAME_SPACE  = "com.deppon.dpm.module.common.server.dao.impl.AppAutoUpdateControlDao.";

	@Override
	public void deleteByAppId(int appId) {
		this.getSqlSession().delete(NAME_SPACE + "deleteByAppId", appId);
	}

	@Override
	public void batchInsert(
			List<AppAutoRefreshControlEntity> appAutoRefreshControlList) {
		this.getSqlSession().insert(NAME_SPACE + "batchInsert", appAutoRefreshControlList);
	}
}
