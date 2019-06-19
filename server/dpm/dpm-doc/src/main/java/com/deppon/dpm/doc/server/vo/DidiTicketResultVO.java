package com.deppon.dpm.doc.server.vo;

import java.io.Serializable;

public class DidiTicketResultVO implements Serializable {

	/**
	 * 构造方法
	 */
	public DidiTicketResultVO(){
		super();
	}
	
	
	private static final long serialVersionUID = 1L;
	
	private int errno;
	private String errmsg;
	private Object data;
	/**
	 * @return the errno
	 */
	public int getErrno() {
		return errno;
	}
	/**
	 * @param errno the errno to set
	 */
	public void setErrno(int errno) {
		this.errno = errno;
	}
	/**
	 * @return the errmsg
	 */
	public String getErrmsg() {
		return errmsg;
	}
	/**
	 * @param errmsg the errmsg to set
	 */
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
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
