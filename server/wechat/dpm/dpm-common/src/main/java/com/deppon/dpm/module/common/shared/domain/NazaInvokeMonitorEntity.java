package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Naza接口调用信息监控
 */
public class NazaInvokeMonitorEntity {
	// id
	private Integer id;
	// 工号
	private String userId;
	// ip
	private String ip;
	// 手机机型
	private String phoneModel;
	// 操作系统
	private String osVersion;
	// 手机型号 android/ios
	private String osType;
	// 应用版本号
	private String appVersion;
	// 应用名称
	private String appName;
	// 网络
	private String network;
	// 运营商
	private String netProvider;
	// 接口名
	private String serviceName;
	// 调用时长
	private Integer invokeTime;
	// 错误信息
	private String errorInfo;
	// 创建时间
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	
	
	/****查询条件参数 start*****/
	// 起始时间
	private Date startTime;
	// 结束时间
	private Date endTime;
	/****查询条件参数 end*****/
	
	// getter
	public Integer getId() {
		return id;
	}
	// setter
	public void setId(Integer id) {
		this.id = id;
	}
	
	// getter
	public String getUserId() {
		return userId;
	}
	
	// setter
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	// getter
	public String getIp() {
		return ip;
	}
	
	// setter
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	// getter
	public String getPhoneModel() {
		return phoneModel;
	}
	
	//setter
	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}
	
	// getter
	public String getOsVersion() {
		return osVersion;
	}
	
	// setter
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	
	// getter
	public String getOsType() {
		return osType;
	}
	
	// setter
	public void setOsType(String osType) {
		this.osType = osType;
	}
	
	// getter
	public String getAppVersion() {
		return appVersion;
	}
	
	// setter
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	
	// getter
	public String getNetwork() {
		return network;
	}
	
	// setter
	public void setNetwork(String network) {
		this.network = network;
	}
	
	// getter
	public String getNetProvider() {
		return netProvider;
	}
	
	// setter
	public void setNetProvider(String netProvider) {
		this.netProvider = netProvider;
	}
	
	// getter
	public Integer getInvokeTime() {
		return invokeTime;
	}
	
	// setter
	public void setInvokeTime(Integer invokeTime) {
		this.invokeTime = invokeTime;
	}
	
	// getter
	public String getErrorInfo() {
		return errorInfo;
	}
	
	// setter
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	// getter
	public Date getCreateTime() {
		return createTime;
	}
	
	// setter
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	// getter
	public String getAppName() {
		return appName;
	}
	
	// setter
	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	// getter
	public String getServiceName() {
		return serviceName;
	}
	
	// setter
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	// getter
	public Date getStartTime() {
		return startTime;
	}
	
	// setter
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	// getter
	public Date getEndTime() {
		return endTime;
	}
	
	// setter
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
