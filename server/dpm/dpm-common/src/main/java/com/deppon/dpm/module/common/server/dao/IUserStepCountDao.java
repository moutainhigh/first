package com.deppon.dpm.module.common.server.dao;

import com.deppon.dpm.module.common.shared.domain.UserStepCountEntity;

public interface IUserStepCountDao {

	void save(UserStepCountEntity entity);

	void update(UserStepCountEntity entity);

	UserStepCountEntity queryByUserIdAndDayTime(UserStepCountEntity entity);

}
