package com.deppon.dpm.tongxunlu.shared.vo;

import java.io.Serializable;

/**
 * 公用返回
 * 
 * @param <T>
 */
public class Result<T> implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2114042297120241494L;
	/**
	 * 存储数据
	 */
	private T data;
	/**
	 * errorCode
	 */
	private int errorCode;
	/**
	 * count
	 */
	private int count;
	/**
	 * errorMessage
	 */
	private String errorMessage;

	/**
	 * get
	 * 
	 * @return
	 */
	public int getCount() {
		return count;
	}

	/**
	 * set
	 * 
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public T getData() {
		return data;
	}

	/**
	 * set
	 * 
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * set
	 * 
	 * @param errorCode
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * set
	 * 
	 * @param errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
