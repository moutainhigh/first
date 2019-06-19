package com.deppon.dpm.tongxunlu.server.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.tongxunlu.server.dao.ISystemConfigDao;
import com.deppon.dpm.tongxunlu.server.service.ISystemConfigService;
import com.deppon.dpm.tongxunlu.shared.domain.MonitorDownload;
import com.deppon.dpm.tongxunlu.shared.domain.MonitorTime;
import com.deppon.dpm.tongxunlu.shared.vo.SystemConfig;

/**
 * 系统配置服务service
 * ClassName: SystemConfigService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2014-8-5 下午5:45:09 <br/>
 *
 * @author 157229-zxy
 * @version 
 * @since JDK 1.6
 */
public class SystemConfigService implements ISystemConfigService{
	
	@Autowired
	// set injection
	private ISystemConfigDao systemConfigDao;

	@Override
	public SystemConfig querySingleSystemConfig(SystemConfig param) {
		// 查询系统配置
		return systemConfigDao.querySingleSystemConfig(param);
	}

	@Override
	public int updateSyncDateByLastSyncDate(Date oldLastSynDate,
			Date newLastSynDate) {
		// 根据上次同步时间查询系统信息
		return systemConfigDao.updateSyncDateByLastSyncDate(oldLastSynDate, newLastSynDate);
	}
	
	/**
	 * 功能访问监控
	 */
	@Override
	public void functionAccessMonitor(String userId, String monitorType,
			String osType) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", userId);
		map.put("monitorType", monitorType);
		map.put("osType", osType);
		systemConfigDao.functionAccessMonitor(map);
	}
	
	/**
	 * 数据监控dao层接口
	 * 监控模块访问时长
	 * @param monitorTime
	 */
	@Override
	public void dataMonitorTime(MonitorTime monitorTime) {
		// 设置条件
		MonitorTime monitor = new MonitorTime();
		if(StringUtils.isNotBlank(monitorTime.getEmpCode())){
			monitor.setEmpCode(monitorTime.getEmpCode());
		}
		if(StringUtils.isNotBlank(monitorTime.getOsType())){
			monitor.setOsType(monitorTime.getOsType());
		}
		if(StringUtils.isNotBlank(monitorTime.getTotalDuration())){
			monitor.setTotalDuration(monitorTime.getTotalDuration());
		}
		if(StringUtils.isNotBlank(monitorTime.getMonitorType())){
			monitor.setMonitorType(monitorTime.getMonitorType());
		}
		// TODO 处理开始时间
		if(null != monitorTime.getBeginTime()){
			monitor.setBeginTime(monitorTime.getBeginTime());
		}
		// TODO 处理开始时间
		if(null != monitorTime.getEndTime()){
			monitor.setEndTime(monitorTime.getEndTime());
		}
		// 插入数据库
		systemConfigDao.dataMonitorTime(monitor);
	}
	
	/**
	 * 数据监控dao层接口
	 * 监控应用下载or卸载
	 * @param monitorDownload
	 */
	@Override
	public void dataMonitorDownload(String empCode,int appId,int downType,String osType){
		// 参数
		MonitorDownload monitorDownload = new MonitorDownload();
		// 用户工号
		if(StringUtils.isNotBlank(empCode)){
			monitorDownload.setEmpCode(empCode);
		}
		// 设备类型
		if(StringUtils.isNotBlank(osType)){
			monitorDownload.setOsType(osType);
		}
		// 应用id
		if(appId != 0){
			monitorDownload.setAppId(appId);
		}
		// 下载or卸载 下载:1,卸载:2
		if(downType != 0){
			monitorDownload.setDownType(downType);
		}
		// 插入数据库
		systemConfigDao.dataMonitorDownload(monitorDownload);
	}

	/********************************getter and setter*********************************/
	
	/**
	 * get
	 * @return
	 */
	public ISystemConfigDao getSystemConfigDao() {
		return systemConfigDao;
	}

	/**
	 * set
	 * @param systemConfigDao
	 */
	public void setSystemConfigDao(ISystemConfigDao systemConfigDao) {
		this.systemConfigDao = systemConfigDao;
	}
}
