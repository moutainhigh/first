package com.deppon.dpm.module.common.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 异地登陆提示实体类
 * 
 * @author 231586
 * 
 */
public class LoginLocationEntity extends BaseEntity {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7139805048805625344L;
	/**
	 * 登陆地点
	 */
	private String location;
	/**
	 * 登录时间
	 */
	private String loginTime;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * set
	 * 
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getLoginTime() {
		return loginTime;
	}

	/**
	 * set
	 * 
	 * @param loginTime
	 */
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * Constructor
	 * 
	 * @param location
	 * @param loginTime
	 */
	public LoginLocationEntity(String location, String loginTime) {
		super();
		this.location = location;
		this.loginTime = loginTime;
	}

	/**
	 * Constructor
	 */
	public LoginLocationEntity() {
	}
}
