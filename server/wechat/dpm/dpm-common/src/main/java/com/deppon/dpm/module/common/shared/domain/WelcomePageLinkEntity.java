package com.deppon.dpm.module.common.shared.domain;

/**
 * 配置欢迎页的链接实体
 */
public class WelcomePageLinkEntity {
	
	// 应用id
	private Integer appId;
	// 应用中文名
	private String appCName;
	// getter
	public Integer getAppId() {
		return appId;
	}
	// setter
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	// getter
	public String getAppCName() {
		return appCName;
	}
	// setter
	public void setAppCName(String appCName) {
		this.appCName = appCName;
	}
	
	/**
	 * 构造
	 * @param appId
	 * @param appCName
	 */
	public WelcomePageLinkEntity(Integer appId, String appCName) {
		super();
		this.appId = appId;
		this.appCName = appCName;
	}
	
	/**
	 * 空参构造
	 */
	public WelcomePageLinkEntity() {
		super();
	}
	
}
