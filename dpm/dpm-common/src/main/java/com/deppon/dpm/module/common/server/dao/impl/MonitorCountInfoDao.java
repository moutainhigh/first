package com.deppon.dpm.module.common.server.dao.impl;

import java.util.Map;

import com.deppon.dpm.module.common.server.dao.IMonitorCountInfoDao;
import com.deppon.dpm.module.common.shared.domain.MonitorCountInfoEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 存储请求盘点资产列表的开始时间和结束时间.
 * 
 * @author 233357
 * @date:2015/03/23
 */
public class MonitorCountInfoDao extends iBatis3DaoImpl implements IMonitorCountInfoDao {

	@Override
	public int saveMonitorCountInfo(MonitorCountInfoEntity countInfoEntity) {
		return this.getSqlSession().insert("com.deppon.dpm.module.common.server.dao.monitorCountInfo.insert", countInfoEntity);
	}

	@Override
	public int saveClackCountInfo(Map map) {
		// TODO Auto-generated method stub
		return this.getSqlSession().insert("com.deppon.dpm.module.common.server.dao.monitorCountInfo.checkInsert", map);
	}
	
	//查询当前任务是否已做过任务监控
	public int queryCountInfoCount(String billNo){
		
		return (Integer)this.getSqlSession().selectOne("com.deppon.dpm.module.common.server.dao.monitorCountInfo.queryCountInfo", billNo);
	}

}
