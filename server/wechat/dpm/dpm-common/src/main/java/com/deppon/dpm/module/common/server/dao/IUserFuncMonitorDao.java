package com.deppon.dpm.module.common.server.dao;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.NativePushCfgEntity;
import com.deppon.dpm.module.common.shared.domain.UserFuncMonitorEntity;

public interface IUserFuncMonitorDao {

	// 保存
	void save(UserFuncMonitorEntity entity);

	// 根据工号分页查询
	List<NativePushCfgEntity> queryByPage(int start, int rows, String userId);

	// 查询总数
	long queryCount(String userId);

}
