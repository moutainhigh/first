package com.deppon.dpm.module.common.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.common.server.dao.IDataMonitorForTongjiDao;
import com.deppon.dpm.module.common.shared.domain.DataMonitorForTongjiEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 查询领导访问情况接口
 */
public class DataMonitorForTongjiDaoImpl extends iBatis3DaoImpl implements IDataMonitorForTongjiDao{

	// NAMESPACE
	private static final String NAMESPACE= "com.deppon.dpm.module.common.server.dao.DataMonitorForTongji.";
	
	// 条件查询
	@SuppressWarnings("unchecked")
	@Override
	public List<DataMonitorForTongjiEntity> queryByCondition(
			DataMonitorForTongjiEntity entity) {
		// 返回查询结果
		return this.getSqlSession().selectList(NAMESPACE + "queryByCondition", entity);
	}

}
