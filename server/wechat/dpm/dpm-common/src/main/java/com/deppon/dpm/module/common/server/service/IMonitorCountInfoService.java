package com.deppon.dpm.module.common.server.service;

import java.util.Date;
import java.util.Map;

import com.deppon.dpm.module.common.shared.domain.MonitorCountInfoEntity;

/**
 * 存储请求盘点资产列表的开始时间和结束时间.
 * 
 * @author 233357
 * @date:2015/03/23
 */
public interface IMonitorCountInfoService {
    // public int saveFixedAssetsCountInfo(FixedAssetsCountInfoEntity countInfoEntity);

    //盘点任务应盘个数监控
	public int saveClackCountInfo(Map map);
	
	//查询当前任务是否已做过任务监控
	public int queryCountInfoCount(String billNo);
	
	/**
	 * 调用存储过程
	 * @param userId
	 * @param startDate
	 * @param endDate
	 * @param type
	 */
	public void saveHistory(String userId,Date startDate,Date endDate,int type);
	
	public int recordPunchCount(MonitorCountInfoEntity queryInfoEntity);
	
	public int saveMonitorCountInfo(String userId,Date startDate,Date endDate,int type);
	
}
