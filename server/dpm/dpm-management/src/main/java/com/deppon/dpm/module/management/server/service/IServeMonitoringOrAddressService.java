package com.deppon.dpm.module.management.server.service;

import com.deppon.foss.framework.exception.BusinessException;

/**
 * 监控保存和地址查询
 * 
 * @author 274858
 * 
 */
public interface IServeMonitoringOrAddressService {
	/*
	 * 地址查询 (non-Javadoc)
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.dao.IServeMonitoringOrAddressDao
	 * #queryAddressNationwide()
	 */
	public String queryAddressNationwide() throws BusinessException;

	/*
	 * 监控保存 (non-Javadoc)
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.dao.IServeMonitoringOrAddressDao
	 * #saveMonitoring
	 * (com.deppon.dpm.module.management.shared.domain.ServeAddressBean)
	 */
	public String saveMonitoring(String str) throws BusinessException;
	/**工程勘测小红点
	 * @param str
	 * @return
	 * @throws BusinessException
	 */
	public String queryProcTask(String str) throws BusinessException;
	/**拼车小红点
	 * @param str
	 * @return
	 * @throws BusinessException
	 */
	public String queryServeTask(String str) throws BusinessException;
	
}
