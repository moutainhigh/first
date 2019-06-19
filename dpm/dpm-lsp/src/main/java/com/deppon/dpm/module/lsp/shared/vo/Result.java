package com.deppon.dpm.module.lsp.shared.vo;

/**
 * @author 268101
 * 结果实体
 * @param <T>
 */
public class Result<T> {
	/**
	 *  data
	 */
	private T data;
	/**
	 * 错误标志
	 */
	private int errorCode;
	/**
	 * 总数
	 */
	private int count;
	/**
	 * 错误信息
	 */
	private String errorMessage;

	/**
	 * @return 总数
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count 总数
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return  data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return 错误标志
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode 错误标志
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return errorMessage 错误信息
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage 错误信息
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
