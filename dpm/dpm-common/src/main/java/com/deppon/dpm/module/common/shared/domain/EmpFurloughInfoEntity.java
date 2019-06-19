package com.deppon.dpm.module.common.shared.domain;

/**
 * NHR人员休假信息实体
 * 
 */
public class EmpFurloughInfoEntity {

	/**
	 * 休假类型
	 */
	private int furloughType;
	/**
	 * 休假交接人工号
	 */
	private String handoverEmpCode;
	/**
	 * 休假交接人姓名
	 */
	private String handoverEmpName;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getHandoverEmpCode() {
		return handoverEmpCode;
	}

	/**
	 * set
	 * 
	 * @param handoverEmpCode
	 */
	public void setHandoverEmpCode(String handoverEmpCode) {
		this.handoverEmpCode = handoverEmpCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getHandoverEmpName() {
		return handoverEmpName;
	}

	/**
	 * set
	 * 
	 * @param handoverEmpName
	 */
	public void setHandoverEmpName(String handoverEmpName) {
		this.handoverEmpName = handoverEmpName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getFurloughType() {
		return furloughType;
	}

	/**
	 * set
	 * 
	 * @param furloughType
	 */
	public void setFurloughType(int furloughType) {
		this.furloughType = furloughType;
	}

}
