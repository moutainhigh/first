package com.deppon.dpm.module.common.server.service;

import com.deppon.dpm.module.common.shared.domain.JpushMonitorEntity;

public interface IJPushNewMonitorService {

	void savePushInfo(JpushMonitorEntity monitorResult);

}
