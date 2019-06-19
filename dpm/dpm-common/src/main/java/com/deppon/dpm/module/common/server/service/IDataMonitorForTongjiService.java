package com.deppon.dpm.module.common.server.service;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.DataMonitorForTongjiEntity;
/**
 * 查询领导访问情况接口
 */
public interface IDataMonitorForTongjiService {

	// 根据条件查询
	List<DataMonitorForTongjiEntity> queryByCondition(
			DataMonitorForTongjiEntity model);

}
