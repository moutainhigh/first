package com.deppon.dpm.module.management.shared.domain;

/**
 * @author email日志
 * 
 */
public class EmailErrorLog {

	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 错误信息
	 */
	private String errorMessage;

	/**
	 * @return 用户id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            用户id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return 用户密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            用户密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return 错误信息
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            错误信息
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public EmailErrorLog() {
	}

	/**
	 * @param userId
	 *            用户id
	 * @param password
	 *            用户密码
	 * @param errorMessage
	 *            错误信息
	 */
	public EmailErrorLog(String userId, String password, String errorMessage) {
		this.userId = userId;
		this.password = password;
		this.errorMessage = errorMessage;
	}

}
