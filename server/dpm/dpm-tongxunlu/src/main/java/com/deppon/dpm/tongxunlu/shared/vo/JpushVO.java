package com.deppon.dpm.tongxunlu.shared.vo;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * 
 * 
 * <pre>
 * 人员实体类.
 * </pre>
 * 
 * @since
 * 
 *        <pre>
 *   modify by 130126 on 2014-4-1
 *    fix->1.
 *         2.
 * </pre>
 */
public class JpushVO implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4409637740522012381L;

	/**
	 * toString
	 */
	public String toString() {
		return JSON.toJSONString(this);
	}

	/**
	 * 推送id
	 */
	private int pushId;
	/**
	 * 工号
	 */
	private String userId;
	/**
	 * token
	 */
	private String token;
	/**
	 * 设备类型
	 */
	private String deviceType;
	/**
	 * 系统编码
	 */
	private String sysCode;

	/**
	 * get
	 * 
	 * @return
	 */
	public int getPushId() {
		return pushId;
	}

	/**
	 * set
	 * 
	 * @param pushId
	 */
	public void setPushId(int pushId) {
		this.pushId = pushId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * set
	 * 
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getToken() {
		return token;
	}

	/**
	 * set
	 * 
	 * @param token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getDeviceType() {
		return deviceType;
	}

	/**
	 * set
	 * 
	 * @param deviceType
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSysCode() {
		return sysCode;
	}

	/**
	 * set
	 * 
	 * @param sysCode
	 */
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}
}
