package com.deppon.dpm.module.wfs.shared.domain.nhr;

/**
 * 异动工作流审批参数，工作交接人
 * 
 */
public class TransferEmpBean {

	/**
	 * 工号
	 */
	private String trasferEmpCode;
	/**
	 * 姓名
	 */
	private String trasferEmpName;
	/**
	 * 部门编码
	 */
	private String trasferOrgCode;
	/**
	 * 部门名称
	 */
	private String trasferOrgName;
	/**
	 * 异动调配or离职
	 */
	private String flag;
	/**
	 * 转交是否有效
	 */
	private String isEffective;

	public String getTrasferEmpCode() {
		return trasferEmpCode;
	}

	public void setTrasferEmpCode(String trasferEmpCode) {
		this.trasferEmpCode = trasferEmpCode;
	}

	public String getTrasferEmpName() {
		return trasferEmpName;
	}

	public void setTrasferEmpName(String trasferEmpName) {
		this.trasferEmpName = trasferEmpName;
	}

	public String getTrasferOrgCode() {
		return trasferOrgCode;
	}

	public void setTrasferOrgCode(String trasferOrgCode) {
		this.trasferOrgCode = trasferOrgCode;
	}

	public String getTrasferOrgName() {
		return trasferOrgName;
	}

	public void setTrasferOrgName(String trasferOrgName) {
		this.trasferOrgName = trasferOrgName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getIsEffective() {
		return isEffective;
	}

	public void setIsEffective(String isEffective) {
		this.isEffective = isEffective;
	}

}
