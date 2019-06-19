package com.deppon.dpm.module.common.server.service;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.NativePushCfgEntity;
import com.deppon.dpm.module.common.shared.domain.UserFuncMonitorEntity;

public interface IUserFuncMonitorService {

	// 保存
	void save(UserFuncMonitorEntity entity);

	List<NativePushCfgEntity> queryByPage(int start, int rows, String userId);

	// 查询总数
	long queryCount(String userId);

}
