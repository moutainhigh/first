package com.deppon.dpm.tongxunlu.shared.vo;

import java.io.Serializable;

public class PortraitResponse implements Serializable{

	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = 2140691615620109918L;
	
	// 返回的消息
	private String result;
	// 请求状态 0成功   1失败
	private int errorCode;
	// 错误信息
	private String errorMsg;

	// getter
	public String getResult() {
		return result;
	}

	// setter
	public void setResult(String result) {
		this.result = result;
	}

	// getter
	public int getErrorCode() {
		return errorCode;
	}

	// setter
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	// getter
	public String getErrorMsg() {
		return errorMsg;
	}

	// setter
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
