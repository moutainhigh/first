package com.deppon.dpm.tongxunlu.server.dao;

import java.util.Date;
import java.util.Map;

import com.deppon.dpm.tongxunlu.shared.domain.MonitorDownload;
import com.deppon.dpm.tongxunlu.shared.domain.MonitorTime;
import com.deppon.dpm.tongxunlu.shared.vo.SystemConfig;


/**
 * 职员操作. TODO(描述类的职责)
 * <p style="display:none">
 * modifyRecord
 * </p>
 * <p style="display:none">
 * version:V1.0,author:130126,date:2014-4-10 上午11:11:58,content:TODO
 * </p>
 * 
 * @author 130126
 * @date 2014-4-10 上午11:11:58
 * @since
 * @version
 */
public interface ISystemConfigDao {
	/**
	 * 检查版本信息. 
	 * @param appName 
	 * @return
	 */
	public SystemConfig seeVersion( String appName );
	
	/**
	 * 查询系统配置 -DPM-299
	 * @return
	 */
	public SystemConfig querySingleSystemConfig(SystemConfig param);
	
	/**
	 * 更新配置信息同步时间 -DPM-299
	 * updateSyncDateByLastSyncDate: <br/>
	 * 
	 * Date:2014-8-5下午4:02:42
	 * @author 157229-zxy
	 * @param oldLastSynDate
	 * @param newLastSynDate
	 * @return
	 * @since JDK 1.6
	 */
	public int updateSyncDateByLastSyncDate(Date oldLastSynDate,
			Date newLastSynDate);

	/**
	 * 数据监控
	 * @param monitorType
	 * @param empCode
	 * @param osType
	 */
	public void dataMonitor(int monitorType, String empCode, String osType);
	
	/**
	 * 功能访问监控
	 * @param map
	 * @return
	 */
	public void functionAccessMonitor(Map<String, String> map);
	
	/**
	 * 数据监控dao层接口
	 * 监控模块访问时长
	 * @param monitorTime
	 */
	public void dataMonitorTime(MonitorTime monitorTime);
	
	/**
	 * 数据监控dao层接口
	 * 监控应用下载or卸载
	 */
	public void dataMonitorDownload(MonitorDownload monitorDownload);
}
