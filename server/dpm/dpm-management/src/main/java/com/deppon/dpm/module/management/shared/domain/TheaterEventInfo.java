package com.deppon.dpm.module.management.shared.domain;


/**
 * 事件类型信息
 * 
 */
public class TheaterEventInfo {

	/**
	 * 事件/问题编码
	 */
	private String orderCode;
	/**
	 * 事件类型id
	 */
	private String faultCode;
	/**
	 * 事件类型
	 */
	private String faultName;
	/**
	 * 类型描述id
	 */
	private String faultSubcode;
	/**
	 * 类型描述
	 */
	private String faultDesc;
	/**
	 * 详细类别id
	 */
	private String modulCode;
	/**
	 * 详细类别
	 */
	private String faultModul;

	/**
	 * @return 事件/问题编码
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * @param orderCode 事件/问题编码
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	/**
	 * @return 事件类型id
	 */
	public String getFaultCode() {
		return faultCode;
	}

	/**
	 * @param faultCode 事件类型id
	 */
	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}

	/**
	 * @return 事件类型
	 */
	public String getFaultName() {
		return faultName;
	}

	/**
	 * @param faultName 事件类型
	 */
	public void setFaultName(String faultName) {
		this.faultName = faultName;
	}

	/**
	 * @return 类型描述
	 */
	public String getFaultDesc() {
		return faultDesc;
	}

	/**
	 * @param faultDesc 类型描述
	 */
	public void setFaultDesc(String faultDesc) {
		this.faultDesc = faultDesc;
	}

	/**
	 * @return 详细类别id
	 */
	public String getModulCode() {
		return modulCode;
	}

	/**
	 * @param modulCode 详细类别id
	 */
	public void setModulCode(String modulCode) {
		this.modulCode = modulCode;
	}

	/**
	 * @return 详细类别
	 */
	public String getFaultModul() {
		return faultModul;
	}

	/**
	 * @param faultModul 详细类别
	 */
	public void setFaultModul(String faultModul) {
		this.faultModul = faultModul;
	}

	/**
	 * @return 事件/问题编码
	 */
	public String getFaultSubcode() {
		return faultSubcode;
	}

	/**
	 * @param faultSubcode   事件/问题编码
	 */ 
	public void setFaultSubcode(String faultSubcode) {
		this.faultSubcode = faultSubcode;
	}

}
