package com.deppon.dpm.module.common.server.service;

import java.text.ParseException;

import com.deppon.dpm.module.common.shared.domain.UserStepCountEntity;

public interface IUserStepCountService {

	void saveOrUpdate(UserStepCountEntity entity) throws ParseException;

}
