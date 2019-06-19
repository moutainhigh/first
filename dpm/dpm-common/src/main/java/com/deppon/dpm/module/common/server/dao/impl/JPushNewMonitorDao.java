package com.deppon.dpm.module.common.server.dao.impl;

import com.deppon.dpm.module.common.server.dao.IJPushNewMonitorDao;
import com.deppon.dpm.module.common.shared.domain.JpushMonitorEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class JPushNewMonitorDao extends iBatis3DaoImpl implements IJPushNewMonitorDao{

	private static final String NAME_SPACE = "com.deppon.dpm.module.common.server.dao.impl.JPushNewMonitorDao.";

	/**
	 * 保存推送监控信息
	 */
	public void savePushInfo(JpushMonitorEntity monitorResult) {
		this.getSqlSession().insert(NAME_SPACE + "save", monitorResult);
	}
}
