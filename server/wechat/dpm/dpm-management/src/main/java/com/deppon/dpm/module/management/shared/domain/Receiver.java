package com.deppon.dpm.module.management.shared.domain;

/**
 * 接收人
 * 
 * @author 231586
 * 
 */
public class Receiver {
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 地址
	 */
	private String address;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * set
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * set
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param address
	 */
	public Receiver(String name, String address) {
		this.name = name;
		this.address = address;
	}

}
