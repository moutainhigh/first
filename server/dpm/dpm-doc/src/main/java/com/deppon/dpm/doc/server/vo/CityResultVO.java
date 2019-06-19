package com.deppon.dpm.doc.server.vo;

import java.io.Serializable;
import java.util.List;

public class CityResultVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public CityResultVO(){
		super();
	}
	private int errno;
	private String errmsg;
	private List<CitiesClassVO> data;
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
//	public List<CitiesClassVO> getData() {
//		return data;
//	}
//	public void setData(List<CitiesClassVO> data) {
//		this.data = data;
//	}
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
	public List<CitiesClassVO> getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(List<CitiesClassVO> data) {
		this.data = data;
	}
	  
}
