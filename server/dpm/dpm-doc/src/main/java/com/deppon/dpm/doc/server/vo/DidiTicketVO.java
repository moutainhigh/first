package com.deppon.dpm.doc.server.vo;

import java.io.Serializable;

public class DidiTicketVO implements Serializable {
	
	/**
	 * 构造方法
	 */
	public DidiTicketVO(){
		super();
	}
	
	private static final long serialVersionUID = 1L;
	
	private String client_id;
	
	private String data_encode;

	/**
	 * @return the client_id
	 */
	public String getClient_id() {
		return client_id;
	}

	/**
	 * @param client_id the client_id to set
	 */
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	/**
	 * @return the data_encode
	 */
	public String getData_encode() {
		return data_encode;
	}

	/**
	 * @param data_encode the data_encode to set
	 */
	public void setData_encode(String data_encode) {
		this.data_encode = data_encode;
	}

//	public String getClient_id() {
//		return client_id;
//	}
//
//	public void setClient_id(Stri ng client_id) {
//		this.client_id = client_id;
//	}
//
//	public String getData_encode() {
//		return data_encode;
//	}
//
//	public void setData_encode(String data_encode) {
//		this.data_encode = data_encode;
//	}
	
	

}
