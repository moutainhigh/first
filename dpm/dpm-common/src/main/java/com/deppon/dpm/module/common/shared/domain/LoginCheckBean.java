package com.deppon.dpm.module.common.shared.domain;

import java.io.Serializable;

/**
 * 验证类
 * 
 * @author 231586
 * 
 */
public class LoginCheckBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4107571973770934331L;
	/**
	 * casSessionId
	 */
	private String casSessionId;
	/**
	 * cookie
	 */
	private String cookie;
	/**
	 * get
	 * 
	 * @return
	 */
	public String getCasSessionId() {
		return casSessionId;
	}

	/**
	 * set
	 * 
	 * @param casSessionId
	 */
	public void setCasSessionId(String casSessionId) {
		this.casSessionId = casSessionId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getCookie() {
		return cookie;
	}

	/**
	 * set
	 * 
	 * @param cookie
	 */
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	/**
	 * 空参构造
	 */
	public LoginCheckBean() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param casSessionId
	 * @param cookie
	 */
	public LoginCheckBean(String casSessionId, String cookie) {
		this.casSessionId = casSessionId;
		this.cookie = cookie;
	}

	/**
	 * hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((casSessionId == null) ? 0 : casSessionId.hashCode());
		result = prime * result + ((cookie == null) ? 0 : cookie.hashCode());
		return result;
	}

	/**
	 * equals
	 */
	@Override
	public boolean equals(Object obj) {
		// 相等
		if (this == obj)
			return true;
		// 为null
		if (obj == null)
			return false;
		// class不等
		if (getClass() != obj.getClass())
			return false;
		// obj强转
		LoginCheckBean other = (LoginCheckBean) obj;
		// 为null
		if (casSessionId == null) {
			if (other.casSessionId != null)
				return false;
			// 不等
		} else if (!casSessionId.equals(other.casSessionId))
			return false;
		// 为null
		if (cookie == null) {
			if (other.cookie != null)
				return false;
		} else if (!cookie.equals(other.cookie))
			return false;
		// 否则相等
		return true;
	}
}