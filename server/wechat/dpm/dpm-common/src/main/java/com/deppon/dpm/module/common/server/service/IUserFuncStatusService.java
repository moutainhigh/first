package com.deppon.dpm.module.common.server.service;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.UserFuncStatusEntity;

public interface IUserFuncStatusService {

	// 删除
	void delete(Integer id);

	// 更新
	void update(UserFuncStatusEntity entity);

	// 保存
	void insert(UserFuncStatusEntity entity);

	// 根据工号查询
	List<UserFuncStatusEntity> queryByUserId(String userId);

}
