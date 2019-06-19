package com.deppon.dpm.module.common.server.dao;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.AppAutoRefreshControlEntity;

public interface IAppAutoUpdateControlDao {

	void deleteByAppId(int appId);

	void batchInsert(List<AppAutoRefreshControlEntity> appAutoRefreshControlList);

}
