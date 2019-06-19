package com.deppon.dpm.module.common.server.dao;

import com.deppon.dpm.module.common.shared.domain.JpushMonitorEntity;

public interface IJPushNewMonitorDao {

	void savePushInfo(JpushMonitorEntity monitorResult);

}
