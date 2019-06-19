package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ServeAddressBean;
/**
 * 监控保存和地址查询
 * @author 274858
 *
 */
public interface IServeMonitoringOrAddressDao {
	/* 
	 * 地址查询
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IServeMonitoringOrAddressDao#queryAddressNationwide()
	 */
	public List<ServeAddressBean> queryAddressNationwide () throws Exception;
	/*
	 * 监控保存
	 *  (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IServeMonitoringOrAddressDao#saveMonitoring(com.deppon.dpm.module.management.shared.domain.ServeAddressBean)
	 */
	public int saveMonitoring(ServeAddressBean parBean) throws Exception;
	/**工程勘测小红点
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public int queryProcTask(String userNo) throws Exception;
	/**拼车小红点
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public int queryServeTask(String userNo) throws Exception;
	
	/**
	 * 更新工程勘测小红点
	 * @param userNo
	 * @return
	 * @throws Exception
	 */
	public int  updateServeTask(String userNo) throws Exception;
}
