package com.deppon.dpm.tongxunlu.server.service;

import java.util.Date;

import com.deppon.dpm.tongxunlu.shared.domain.MonitorTime;
import com.deppon.dpm.tongxunlu.shared.vo.SystemConfig;


/**
 * 推送消息提供的接口. TODO(描述类的职责)
 * <p style="display:none">
 * modifyRecord
 * </p>
 * <p style="display:none">
 * version:V1.0,author:130126,date:2014-4-10 下午3:50:39,content:TODO
 * </p>
 * 
 * @author 130126
 * @date 2014-4-10 下午3:50:39
 * @since
 * @version
 */
public interface ISystemConfigService {

	/**
	 * 查询配置信息
	 * querySingleSystemConfig: <br/>
	 * 
	 * Date:2014-8-5下午3:45:20
	 * @author 157229-zxy
	 * @param param
	 * @return
	 * @since JDK 1.6
	 */
	public SystemConfig querySingleSystemConfig(SystemConfig param);
	
	/**
	 * 更新配置信息
	 * updateSyncDateByLastSyncDate: <br/>
	 * 
	 * Date:2014-8-5下午4:01:39
	 * @author 157229-zxy
	 * @param oldLastSynDate
	 * @param newLastSynDate
	 * @return
	 * @since JDK 1.6
	 */
	public int updateSyncDateByLastSyncDate(Date oldLastSynDate, Date newLastSynDate);
	
	/**
	 * 功能访问监控
	 * @param userId
	 * @param monitorType
	 * @param lowerCase
	 */
	public void functionAccessMonitor(String userId, String monitorType,
			String osType);
	
	/**
	 * 数据监控dao层接口
	 * 监控模块访问时长
	 * @param monitorTime
	 */
	public void dataMonitorTime(MonitorTime monitorTime);
	
	/**
	 * 数据监控dao层接口
	 * 监控应用下载or卸载
	 * @param monitorDownload
	 */
	public void dataMonitorDownload(String empCode,int appId,int downType,String osType);
}
