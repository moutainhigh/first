package com.deppon.dpm.tongxunlu.shared.domain;

import java.util.Map;

public class MyConsumptionRequestEntity {
	private String deptName; //部门名称
	private String deptId;//部门编码
	private String empName;	 //人员
	private String empNo; //人员编码
	private String order; //级别
	private String jobGroups; //族群
	private String leaderCode; //子部门领导工号
	private String leaderName; //子部门领导姓名
	private String pictPath; //人员图片
	private Map<String,String> allchilddep;//子部门的子部门们
	//private List<MyConsumptionRequestEntity> allchilddep;
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getJobGroups() {
		return jobGroups;
	}
	public void setJobGroups(String jobGroups) {
		this.jobGroups = jobGroups;
	}
	public String getLeaderCode() {
		return leaderCode;
	}
	public void setLeaderCode(String leaderCode) {
		this.leaderCode = leaderCode;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public Map<String, String> getAllchilddep() {
		return allchilddep;
	}
	public void setAllchilddep(Map<String, String> allchilddep) {
		this.allchilddep = allchilddep;
	}
	public String getPictPath() {
		return pictPath;
	}
	public void setPictPath(String pictPath) {
		this.pictPath = pictPath;
	}
	@Override
	public String toString() {
		return "MyConsumptionRequestEntity [deptName=" + deptName + ", deptId="
				+ deptId + ", empName=" + empName + ", empNo=" + empNo
				+ ", order=" + order + ", jobGroups=" + jobGroups
				+ ", leaderCode=" + leaderCode + ", leaderName=" + leaderName
				+ ", pictPath=" + pictPath + ", allchilddep=" + allchilddep
				+ "]";
	}

}
