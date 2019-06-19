package com.deppon.dpm.module.management.shared.exception;

/**
 * @author 
 * email 抛出异常
 *
 */
public class EmailNullPointException extends Exception {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -4818544749354614531L;
	/**
	 * 构造方法
	 */
	public EmailNullPointException() {

	}
	/**
	 * @param message 参数信息
	 */
	public EmailNullPointException(String message) {
		super(message);
	}
}
