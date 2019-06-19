package com.deppon.dpm.module.wfs.shared.domain;

import java.io.Serializable;

public class EmpEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//部门编码
	private String  finasyscode;
	//部门名称
	private String  orgName;
	//工号
	private String empCode;
	//姓名
	private String empName;
	//人员级别
	private String jobName;
	/**
	 * @return the finasyscode
	 */
	public String getFinasyscode() {
		return finasyscode;
	}
	/**
	 * @param finasyscode the finasyscode to set
	 */
	public void setFinasyscode(String finasyscode) {
		this.finasyscode = finasyscode;
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
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}
	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
}
