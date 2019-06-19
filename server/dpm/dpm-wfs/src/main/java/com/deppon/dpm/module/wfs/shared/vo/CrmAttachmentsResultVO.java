package com.deppon.dpm.module.wfs.shared.vo;

import java.io.Serializable;

public class CrmAttachmentsResultVO implements Serializable {

	/**
	 * 构造方法
	 */
	public CrmAttachmentsResultVO(){
		super();
	}
	
	
	private static final long serialVersionUID = 1L;
	
	private int errorCode;
	private String errorMessage;
	private String stream;
	/**
	 * @return the errCode
	 */
	public int getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errCode the errCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the errMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errMessage the errMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the stream
	 */
	public String getStream() {
		return stream;
	}
	/**
	 * @param stream the stream to set
	 */
	public void setStream(String stream) {
		this.stream = stream;
	}
	
	 
//	public int getErrno() {
//		return errno;
//	}
//	public void setErrno(int errno) {
//		this.errno = errno;
//	}
//	public String getErrmsg() {
//		return errmsg;
//	}
//	public void setErrmsg(String errmsg) {
//		this.errmsg = errmsg;
//	}
//	public Object getData() {
//		return data;
//	}
//	public void setData(Object data) {
//		this.data = data;
//	}

	
}
