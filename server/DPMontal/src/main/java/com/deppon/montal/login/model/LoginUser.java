package com.deppon.montal.login.model;

/**
 * 登录者信息
 * @author Administrator
 *
 */
public class LoginUser {

	/**
	 * 员工工号
	 */
	private String userId;
	/**
	 * empId
	 */
	private long empId;
	
	/**
	 * 员工姓名
	 */
	private String empName;
	
	/**
	 * 职位名称
	 */
	private String jobName;
	/**
	 * 工作流权限
	 */
	private String syscodes;

	public String getSyscodes() {
		return syscodes;
	}

	public void setSyscodes(String syscodes) {
		this.syscodes = syscodes;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	
}
