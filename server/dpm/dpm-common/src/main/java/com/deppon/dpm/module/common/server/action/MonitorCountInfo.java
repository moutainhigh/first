package com.deppon.dpm.module.common.server.action;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.deppon.dpm.module.common.server.service.IMonitorCountInfoService;
import com.deppon.dpm.module.common.shared.domain.MonitorCountInfoEntity;

/**
 * 数据监控action
 * @date 2015-06-02 16:32:14
 * @author 237986
 *
 */
public class MonitorCountInfo extends BaseAction {
	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = 1L;
	private int monitorType;//接收统计数据的类型
	
	//longitude
	private String longitude;
	//latitude
	private String latitude;
	/**
	 * getter
	 */
	public int getMonitorType() {
		return monitorType;
	}
	
	/**
	 * setter
	 */
	public void setMonitorType(int monitorType) {
		this.monitorType = monitorType;
	}
	
	/**
	 * service
	 */
	private IMonitorCountInfoService monitorCountInfoService;
	
	/**
	 * setter
	 */
	public void setMonitorCountInfoService(
			IMonitorCountInfoService monitorCountInfoService) {
		this.monitorCountInfoService = monitorCountInfoService;
	}
	

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * 保存监控数据
	 */
	public String recordCount(){
		//获取response
		HttpServletResponse response = ServletActionContext.getResponse();
		//当前日期时间
		Date date=new Date();
		//保存
		monitorCountInfoService.saveMonitorCountInfo(userId, date, date, monitorType);
		//响应结果
		writeToPage(response, "{\"result\":\"1\"}");
		return null;
	}
	
	/**
	 * 保存打卡监控数据
	 */
	public String recordPunchCount(){
		//获取response
		HttpServletResponse response = ServletActionContext.getResponse();
		//当前日期时间
		Date date=new Date();
		//保存
		if (userId != null && monitorType != 0) {
			MonitorCountInfoEntity queryInfoEntity = new MonitorCountInfoEntity();
			queryInfoEntity.setUserId(userId);
			queryInfoEntity.setStartTime(date);
			queryInfoEntity.setEndTime(date);
			queryInfoEntity.setType(monitorType);
			queryInfoEntity.setJobName(longitude);//longitude
			queryInfoEntity.setJobGroups(latitude);//latitude
			monitorCountInfoService.recordPunchCount(queryInfoEntity);
		}
		//响应结果
		writeToPage(response, "{\"result\":\"1\"}");
		return null;
	}
}
