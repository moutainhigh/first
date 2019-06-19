package com.deppon.dpm.store.server.result;

import org.apache.poi.ss.formula.functions.T;

/**
 * 
 * @author XiaoTian
 *
 */
public abstract class BaseResult {
	/**
	 * code
	 */
	private int code;
	/**
	 * msg
	 */
	private String msg;
	/**
	 * data
	 */
	private T data;
	
	/**
	 * 
	 * @param msg
	 */
	public BaseResult(String msg) {
		this(400,msg);
	}
	/**
	 * 
	 * @param code
	 * @param msg
	 */
	public BaseResult(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	/**
	 * 
	 * @return
	 */
	public int getCode() {
		return code;
	}
	/**
	 * 
	 * @return
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * 
	 * @return
	 */
	public T getData() {
		return data;
	}
	
}
