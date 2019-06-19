package com.deppon.dpm.module.wfs.shared.domain.nhr;

import java.io.Serializable;

public class QueryParam implements Serializable {
	private static final long serialVersionUID = 214030343632678379L;
	//工作流号
	private String workFlowNum;
	// 审批人工号
	private String empCode;
	// 审批人名称
	private String empName;
	//工作流类型
	private String workFlowType;
	/**
	 * @return the workFlowNum
	 */
	public String getWorkFlowNum() {
		return workFlowNum;
	}
	/**
	 * @param workFlowNum the workFlowNum to set
	 */
	public void setWorkFlowNum(String workFlowNum) {
		this.workFlowNum = workFlowNum;
	}
	/**
	 * @return the empCode
	 */
	public String getEmpCode() {
		return empCode;
	}
	/**
	 * @param empCode the empCode to set
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * @return the workFlowType
	 */
	public String getWorkFlowType() {
		return workFlowType;
	}
	/**
	 * @param workFlowType the workFlowType to set
	 */
	public void setWorkFlowType(String workFlowType) {
		this.workFlowType = workFlowType;
	}
}
