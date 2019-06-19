package com.deppon.dpm.module.management.shared.exception;

/**
 * @author email 抛出异常
 * 
 */
public class EmailPasswordErrorException extends Exception {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 6203619300240376201L;
	/**
	 * 构造方法
	 */
	public EmailPasswordErrorException() {
	}

	/**
	 * @param message
	 *            参数信息
	 */
	public EmailPasswordErrorException(String message) {
		super(message);
	}

}
