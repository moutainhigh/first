package com.deppon.dpm.module.wfs.shared.domain;
/**
 * 新工作流员工信息实体
 * @author 276344
 *
 */
public class EmployeeInfo {
	/**
	 * 员工工号
	 */
	private String empCode;
	/**
	 * 员工姓名
	 */
	private String empName;
	/**
	 * get
	 * @return
	 */
	public String getEmpCode() {
		return empCode;
	}
	/**
	 * set
	 * @param empCode
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	/**
	 * get
	 * @return
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * set
	 * @param empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
}
