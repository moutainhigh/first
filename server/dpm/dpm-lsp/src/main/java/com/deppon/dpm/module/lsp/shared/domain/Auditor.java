package com.deppon.dpm.module.lsp.shared.domain;

/**
 * @author 268101 审批表
 */
public class Auditor {
	
	/**
	 * // 审批人的工号
	 */
	private String empCode;
	
	/**
	 * // 审批人的姓名
	 */
	private String empName;

	/**
	 * @return 审批人的工号
	 */
	public String getEmpCode() {
		return empCode;
	}

	/**
	 * @param empCode 审批人的工号
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	/**
	 * @return  审批人的姓名
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName  审批人的姓名
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

}
