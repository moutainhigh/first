package com.deppon.dpm.module.wfs.shared.domain;

import java.io.Serializable;

public class DepEntity implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    //标杆编码
    String orgCode;
    //名称
    String orgName;
	/**
	 * @return the orgCode
	 */
	public String getOrgCode() {
		return orgCode;
	}
	/**
	 * @param orgCode the orgCode to set
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
}
