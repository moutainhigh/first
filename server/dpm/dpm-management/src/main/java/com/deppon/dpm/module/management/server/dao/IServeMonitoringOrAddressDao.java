package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ServeAddressBean;
import com.deppon.foss.framework.exception.BusinessException;
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
	public List<ServeAddressBean> queryAddressNationwide () throws BusinessException;
	/*
	 * 监控保存
	 *  (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IServeMonitoringOrAddressDao#saveMonitoring(com.deppon.dpm.module.management.shared.domain.ServeAddressBean)
	 */
	public int saveMonitoring(ServeAddressBean parBean) throws BusinessException;
	/**工程勘测小红点
	 * @param str
	 * @return
	 * @throws BusinessException
	 */
	public int queryProcTask(String userNo) throws BusinessException;
	/**拼车小红点
	 * @param str
	 * @return
	 * @throws BusinessException
	 */
	public int queryServeTask(String userNo) throws BusinessException;
	
	/**
	 * 更新工程勘测小红点
	 * @param userNo
	 * @return
	 * @throws BusinessException
	 */
	public int  updateServeTask(String userNo) throws BusinessException;
}
