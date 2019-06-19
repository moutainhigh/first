package com.deppon.dpm.module.projecttools.shared.domain;

/**
 * <p>ClassName: 项目状态详情信息</p>
 * <p>Description: TODO</p>
 * <p>Author: 石学钢</p>
 * <p>Date: 2015-7-30</p>
 */
public class ProjectStrutsInfo {
	//项目状态
	private String currentstatus;
	
	//项目描述
	private String reason;
	
	//项目时间
	private String modifytime;
	
	//修改人姓名
	private String modifyperson;
	
	//修改人工号
	private String modifypersoncode;
	
	//修改人部门
	private String modifypersondept;

	/**
	 * currentstatus
	 * @return the currentstatus
	 */
	public String getCurrentstatus() {
		return currentstatus;
	}

	/**
	 * @param currentstatus the currentstatus to set
	 */
	public void setCurrentstatus(String currentstatus) {
		this.currentstatus = currentstatus;
	}

	/**
	 * reason
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * modifytime
	 * @return the modifytime
	 */
	public String getModifytime() {
		return modifytime;
	}

	/**
	 * @param modifytime the modifytime to set
	 */
	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}

	/**
	 * modifyperson
	 * @return the modifyperson
	 */
	public String getModifyperson() {
		return modifyperson;
	}

	/**
	 * @param modifyperson the modifyperson to set
	 */
	public void setModifyperson(String modifyperson) {
		this.modifyperson = modifyperson;
	}

	/**
	 * modifypersoncode
	 * @return the modifypersoncode
	 */
	public String getModifypersoncode() {
		return modifypersoncode;
	}

	/**
	 * @param modifypersoncode the modifypersoncode to set
	 */
	public void setModifypersoncode(String modifypersoncode) {
		this.modifypersoncode = modifypersoncode;
	}

	/**
	 * modifypersondept
	 * @return the modifypersondept
	 */
	public String getModifypersondept() {
		return modifypersondept;
	}

	/**
	 * @param modifypersondept the modifypersondept to set
	 */
	public void setModifypersondept(String modifypersondept) {
		this.modifypersondept = modifypersondept;
	}
	
}
