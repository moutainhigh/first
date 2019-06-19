package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 存储登录用户的信息 date:2015-02-04 13:53:00
 * 
 * @author tianyong
 */
public class LoginInfoEntity extends BaseEntity {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 唯一标识
	 */
	private String userId;
	/**
	 * 工号
	 */
	private String userCode;
	/**
	 * 登录时间
	 */
	private Date loginTime;
	/**
	 * app端登陆 分为安卓和ios
	 */
	private String osType;
	/**
	 * 0 表示老版本登陆， 1 表示新版本,2是自动登陆
	 */
	private String loginType;
	/**
	 * 应用版本号
	 */
	private String appVersion;

	/**
	 * get
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * set
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * get
	 * @return
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * set
	 * @param userCode
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * get
	 * @return
	 */
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * set
	 * @param loginTime
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * get
	 * @return
	 */
	public String getOsType() {
		return osType;
	}

	/**
	 * set
	 * @param osType
	 */
	public void setOsType(String osType) {
		this.osType = osType;
	}

	/**
	 * get
	 * @return
	 */
	public String getLoginType() {
		return loginType;
	}

	/**
	 * set
	 * @param loginType
	 */
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	
	/**
	 * getter
	 * @return
	 */
	public String getAppVersion() {
		return appVersion;
	}

	/**
	 * setter
	 * @param appVersion
	 */
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	
}