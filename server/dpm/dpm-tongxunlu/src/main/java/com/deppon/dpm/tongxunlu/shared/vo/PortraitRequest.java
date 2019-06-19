package com.deppon.dpm.tongxunlu.shared.vo;

import java.io.Serializable;

public class PortraitRequest implements Serializable{

	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = -3005181395793708233L;

	// 工号
	private String userId;
	
	// sessionId
	private String sessionId;
	
	// casCookie
	private String casCookie;

	// getter
	public String getUserId() {
		return userId;
	}

	// setter
	public void setUserId(String userId) {
		this.userId = userId;
	}

	// getter
	public String getSessionId() {
		return sessionId;
	}

	// setter
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	// getter
	public String getCasCookie() {
		return casCookie;
	}

	// setter
	public void setCasCookie(String casCookie) {
		this.casCookie = casCookie;
	}
	
}
