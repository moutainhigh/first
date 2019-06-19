package com.deppon.foss.module.sync.esb.exception;

/**
 * 自定义异常
 * 
 * @author 231586
 * 
 */
public class ConvertException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 消息实体
	 */
	private String message;

	/**
	 * Constructor
	 */
	public ConvertException() {
		super();
	}

	/**
	 * Constructor
	 */
	public ConvertException(String message) {
		super(message);
		this.message = message;
	}

	/**
	 * Constructor
	 */
	public ConvertException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	/**
	 * get
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * set
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
