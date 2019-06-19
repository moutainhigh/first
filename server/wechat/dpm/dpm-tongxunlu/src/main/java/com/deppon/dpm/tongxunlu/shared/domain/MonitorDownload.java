package com.deppon.dpm.tongxunlu.shared.domain;

/**
 * 数据监控 应用下载与卸载量监控
 * 
 */
public class MonitorDownload {

	/**
	 * 用户工号
	 */
	private String empCode;
	/**
	 * 应用id
	 */
	private int appId;
	/**
	 * 下载or卸载，下载：1，卸载：2
	 */
	private int downType;
	/**
	 * 设备类型
	 */
	private String osType;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getEmpCode() {
		return empCode;
	}

	/**
	 * set
	 * 
	 * @param empCode
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getOsType() {
		return osType;
	}

	/**
	 * set
	 * 
	 * @param osType
	 */
	public void setOsType(String osType) {
		this.osType = osType;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getAppId() {
		return appId;
	}

	/**
	 * set
	 * 
	 * @param appId
	 */
	public void setAppId(int appId) {
		this.appId = appId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getDownType() {
		return downType;
	}

	/**
	 * set
	 * 
	 * @param downType
	 */
	public void setDownType(int downType) {
		this.downType = downType;
	}

}
