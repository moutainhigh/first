package com.deppon.dpm.module.common.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import com.deppon.dpm.module.common.server.dao.IMonitorCountInfoDao;
import com.deppon.dpm.module.common.server.service.IMonitorCountInfoService;
import com.deppon.dpm.module.common.shared.domain.MonitorCountInfoEntity;

/**
 * 存储请求盘点资产列表的开始时间和结束时间.
 * 
 * @author 233357
 * @date:2015/03/23
 */
public  class MonitorCountInfoService implements IMonitorCountInfoService {

	/**
	 * monitorCountInfoDao
	 */
	private IMonitorCountInfoDao monitorCountInfoDao;

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate
	 *            the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * jdbc
	 */
	private JdbcTemplate jdbcTemplate;

	/**
	 * get
	 * 
	 * @return
	 */
	public IMonitorCountInfoDao getMonitorCountInfoDao() {
		return monitorCountInfoDao;
	}

	/**
	 * set
	 * 
	 * @param monitorCountInfoDao
	 */
	public void setMonitorCountInfoDao(IMonitorCountInfoDao monitorCountInfoDao) {
		this.monitorCountInfoDao = monitorCountInfoDao;
	}

	/**
	 * 保存监控信息
	 */
	@Override
	public int recordPunchCount(MonitorCountInfoEntity queryInfoEntity) {
			return monitorCountInfoDao.saveMonitorCountInfo(queryInfoEntity);
	}
	
	/**
	 * 保存监控信息
	 */
	@Override
	public int saveMonitorCountInfo(String userId, Date startDate,
			Date endDate, int type) {
		int res = 0;
		if (userId != null && type != 0) {
			MonitorCountInfoEntity queryInfoEntity = new MonitorCountInfoEntity();
			queryInfoEntity.setUserId(userId);
			queryInfoEntity.setStartTime(startDate);
			queryInfoEntity.setEndTime(endDate);
			queryInfoEntity.setType(type);
			res = monitorCountInfoDao.saveMonitorCountInfo(queryInfoEntity);
		}
		return res;
	}

	// @Override
	// public int saveFixedAssetsCountInfo(FixedAssetsCountInfoEntity
	// countInfoEntity) {
	// return fixedAssetsCountInfoDao.saveFixedAssetsCountInfo(countInfoEntity);
	// }

	/**
	 * saveClackCountInfo
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public int saveClackCountInfo(Map map) {
		// TODO Auto-generated method stub
		return monitorCountInfoDao.saveClackCountInfo(map);
	}

	/**
	 * 查询当前任务是否已做过任务监控
	 */
	public int queryCountInfoCount(String billNo) {
		// TODO Auto-generated method stub
		return monitorCountInfoDao.queryCountInfoCount(billNo);
	}

	/**
	 * 调存储过程
	 */
	@Override
	public void saveHistory(String userId, Date startDate, Date endDate,
			int type) {

		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String sql = "call p_joblevel_insert_collect_countinfo('" + userId
				+ "','" + time.format(startDate) + "','" + time.format(endDate)
				+ "'," + type + ")";

		jdbcTemplate.execute(sql);
	}


}
