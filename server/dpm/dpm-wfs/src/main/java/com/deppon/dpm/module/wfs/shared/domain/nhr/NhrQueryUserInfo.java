package com.deppon.dpm.module.wfs.shared.domain.nhr;

/**
 * NHR人员选择器实体
 * 
 */
public class NhrQueryUserInfo {

	/**
	 * 工号
	 */
	private String empCode;
	/**
	 * 姓名
	 */
	private String empName;
	/**
	 * 岗位
	 */
	private String jobName;
	/**
	 * 族群
	 */
	private String jobGroups;
	/**
	 * 岗位层级
	 */
	private String jobLevel;
	/**
	 * 部门id
	 */
	private String orgId;
	/**
	 * 部门名称
	 */
	private String orgName;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroups() {
		return jobGroups;
	}

	public void setJobGroups(String jobGroups) {
		this.jobGroups = jobGroups;
	}

	public String getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

}
