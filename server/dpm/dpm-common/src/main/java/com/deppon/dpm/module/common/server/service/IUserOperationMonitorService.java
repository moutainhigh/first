package com.deppon.dpm.module.common.server.service;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.UserOperationMonitorEntity;
import com.deppon.dpm.module.common.shared.domain.UserOperationMonitorTypeEntity;

public interface IUserOperationMonitorService {

	// 保存
	void save(UserOperationMonitorEntity entity);

	// 条件查询
	List<UserOperationMonitorEntity> queryByUserIdAndTime(
			int start, int rows, UserOperationMonitorEntity entity);

	// 查询用户操作监控号名称对应关系
	List<UserOperationMonitorTypeEntity> queryUserOperationMonitorType();

	long queryCount(UserOperationMonitorEntity entity);

}
