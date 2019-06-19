package com.deppon.dpm.module.common.shared.vo;

/**
 * 公用返回结果类
 * 
 * @author 231586
 * 
 * @param <T>
 */
public class Result<T> {
	/**
	 * 返回的结果
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
	 * result
	 */
	private String result;

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

	/**
	 * get
	 * 
	 * @return
	 */
	public String getResult() {
		return result;
	}

	/**
	 * set
	 * 
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}
}
