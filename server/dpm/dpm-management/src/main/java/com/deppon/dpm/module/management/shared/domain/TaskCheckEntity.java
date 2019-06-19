package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * 
 * @author 王亚男
 * 工程验收
 */
public class TaskCheckEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3088377417874554551L;
	public TaskCheckEntity(){}
	
	/**
	 * 部门code
	 */
	private String deptCode;
	/**
	 * 部门名称
	 */
	private String deptName;
	
	/**
	 * 
	 */
	private String providerName;
	
	/**
	 * 验收工号
	 */
	private String checkEmpNo;
	/**
	 * 验收人
	 */
	private String checkEmpName;
	
	//setter getter
	public String getDeptCode() {
		return deptCode;
	}
	//setter getter
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	//setter getter
	public String getDeptName() {
		return deptName;
	}
	//setter getter
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	//setter getter
	public String getProviderName() {
		return providerName;
	}
	//setter getter
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	//setter getter
	public String getCheckEmpNo() {
		return checkEmpNo;
	}
	//setter getter
	public void setCheckEmpNo(String checkEmpNo) {
		this.checkEmpNo = checkEmpNo;
	}
	//setter getter
	public String getCheckEmpName() {
		return checkEmpName;
	}
	//setter getter
	public void setCheckEmpName(String checkEmpName) {
		this.checkEmpName = checkEmpName;
	}

}
