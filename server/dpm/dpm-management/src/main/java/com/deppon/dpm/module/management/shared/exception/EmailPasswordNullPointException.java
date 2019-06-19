package com.deppon.dpm.module.management.shared.exception;

/**
 * @author email 抛出异常
 * 
 */
public class EmailPasswordNullPointException extends Exception {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 5115014112776710162L;

	/**
	 * 构造方法
	 */
	public EmailPasswordNullPointException() {

	}

	/**
	 * @param message
	 *            参数信息
	 */
	public EmailPasswordNullPointException(String message) {
		super(message);
	}

}
