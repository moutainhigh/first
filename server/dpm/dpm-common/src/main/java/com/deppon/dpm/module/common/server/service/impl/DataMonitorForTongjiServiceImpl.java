package com.deppon.dpm.module.common.server.service.impl;

import java.util.List;

import com.deppon.dpm.module.common.server.dao.IDataMonitorForTongjiDao;
import com.deppon.dpm.module.common.server.service.IDataMonitorForTongjiService;
import com.deppon.dpm.module.common.shared.domain.DataMonitorForTongjiEntity;

/**
 * 查询领导访问情况接口
 */
public class DataMonitorForTongjiServiceImpl implements IDataMonitorForTongjiService{

	// 注入dao
	private IDataMonitorForTongjiDao dataMonitorForTongjiDao;
	
	// 条件查询
	public List<DataMonitorForTongjiEntity> queryByCondition(
			DataMonitorForTongjiEntity entity) {
		// 返回查询结果
		return dataMonitorForTongjiDao.queryByCondition(entity);
	}

	// setter
	public void setDataMonitorForTongjiDao(
			IDataMonitorForTongjiDao dataMonitorForTongjiDao) {
		this.dataMonitorForTongjiDao = dataMonitorForTongjiDao;
	}

}
