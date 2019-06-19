package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;

/**
 * 员工信息
 * @author Administrator
 *
 */
public class OmEmployee {
	/**
	 * 员工id
	 */
	private BigDecimal empId;
	/**
	 * 员工工号
	 */
	private String userId;
	/**
	 * 员工姓名
	 */
	private String empName;
	/**
	 * 性别
	 */
	private String gender;	
	/**
	 * 手机
	 */
	private String mobileNo;
	/**
	 * 办公电话
	 */
	private String telephone;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 部门id
	 */
	private BigDecimal orgId;
	/**
	 * 部门名称
	 */
	private String orgName;
	/**
	 * 职位
	 */
	private String jobName;
	/**
	 * 工作职责
	 */
	private String workExp;
	
	public BigDecimal getEmpId() {
		return empId;
	}

	public void setEmpId(BigDecimal empId) {
		this.empId = empId;
	}

	public String getUserId() {
		return F_Constants.chageNull(userId);
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmpName() {
		return F_Constants.chageNull(empName);
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getGender() {
		return F_Constants.chageNull(gender);
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return F_Constants.chageNull(mobileNo);
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getTelephone() {
		return F_Constants.chageNull(telephone);
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return F_Constants.chageNull(email);
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getOrgId() {
		return orgId;
	}

	public void setOrgId(BigDecimal orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return F_Constants.chageNull(orgName);
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getJobName() {
		return F_Constants.chageNull(jobName);
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getWorkExp() {
		return F_Constants.chageNull(workExp);
	}

	public void setWorkExp(String workExp) {
		this.workExp = workExp;
	}

	
}
