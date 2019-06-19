package com.deppon.dpm.module.common.shared.domain;

/**
 * 应用自动更新控制条件实体类
 */
public class AppAutoRefreshControlEntity extends BaseEntity{

	// 主键id
	private Integer id;
	
	// 应用id
	private Integer appId;
	
	// 系统操作类型 android/iphone
	private String osType;
	
	// 自动更新控制条件判断符号  0:等于  1:大于等于 2:小于等于
	private Integer judgeSymbol;
	
	// 应用版本号
	private String appVersion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public Integer getJudgeSymbol() {
		return judgeSymbol;
	}

	public void setJudgeSymbol(Integer judgeSymbol) {
		this.judgeSymbol = judgeSymbol;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	
}
