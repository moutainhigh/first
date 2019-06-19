package com.deppon.dpm.module.common.server.dao;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.UserOperationMonitorEntity;
import com.deppon.dpm.module.common.shared.domain.UserOperationMonitorTypeEntity;

public interface IUserOperationMonitorDao {

	void save(UserOperationMonitorEntity entity);

	List<UserOperationMonitorEntity> queryByUserIdAndTime(
			int start, int rows, UserOperationMonitorEntity entity);

	List<UserOperationMonitorTypeEntity> queryUserOperationMonitorType();

	long queryCount(UserOperationMonitorEntity entity);

}
