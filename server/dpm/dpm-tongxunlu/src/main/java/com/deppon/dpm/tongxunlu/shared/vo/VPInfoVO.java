package com.deppon.dpm.tongxunlu.shared.vo;

import java.io.Serializable;

public class VPInfoVO  implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 工号
	 */
	private String empCode; 
	/**
	 * 姓名
	 */
	private String empName;
	/**
	 * 组织id
	 */
	private String orgId;
	/**
	 * 部门名
	 */
	private String orgName;
	/**
	 * 职位
	 */
	private String jobName;
	/**
	 * 等级
	 */
	private String jobLevel;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 头像
	 */
	private String pictPath;
	/**
	 * 头像地址
	 */
	private String headPhoto;
	
	
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
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobLevel() {
		return jobLevel;
	}
	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPictPath() {
		return pictPath;
	}
	public void setPictPath(String pictPath) {
		this.pictPath = pictPath;
	}
	public String getHeadPhoto() {
		return headPhoto;
	}
	public void setHeadPhoto(String headPhoto) {
		this.headPhoto = headPhoto;
	}

	
}
