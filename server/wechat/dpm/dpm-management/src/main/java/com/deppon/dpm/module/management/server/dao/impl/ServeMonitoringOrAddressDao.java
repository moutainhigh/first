package com.deppon.dpm.module.management.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.IServeMonitoringOrAddressDao;
import com.deppon.dpm.module.management.shared.domain.ServeAddressBean;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;


/**
 * 监控保存和地址查询
 * @author 274858
 *
 */
@SuppressWarnings("unchecked")
public class ServeMonitoringOrAddressDao extends iBatis3DaoImpl implements IServeMonitoringOrAddressDao{

	private String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.busmanager.serveMonitoringOrAddressDao";

	/* 
	 * 地址查询
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IServeMonitoringOrAddressDao#queryAddressNationwide()
	 */
	@Override
	public List<ServeAddressBean> queryAddressNationwide() throws Exception {
		 
		return this.getSqlSession().selectList(mapperNameSpace+".queryAddressNationwide");
	}

	/*
	 * 监控保存
	 *  (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IServeMonitoringOrAddressDao#saveMonitoring(com.deppon.dpm.module.management.shared.domain.ServeAddressBean)
	 */
	@Override
	public int saveMonitoring(ServeAddressBean parBean) throws Exception {
		return this.getSqlSession().insert(mapperNameSpace+".saveMonitoring",parBean);
	}

	/*  工程勘测小红点
	 *  (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IServeMonitoringOrAddressDao#queryProcTask(java.lang.String)
	 */
	@Override
	public int queryProcTask(String userNo) throws Exception {
		
		return (Integer) this.getSqlSession().selectOne(mapperNameSpace+".queryProcTask",userNo);
	}

	/* 拼车小红点
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IServeMonitoringOrAddressDao#queryServeTask(java.lang.String)
	 */
	@Override
	public int queryServeTask(String userNo) throws Exception {
		
		return (Integer)this.getSqlSession().selectOne(mapperNameSpace+".queryServeTask",userNo);
	}

	@Override
	public int updateServeTask(String userNo) throws Exception {
		
		return this.getSqlSession().update(mapperNameSpace+".updateServeTask", userNo);
	}

}
