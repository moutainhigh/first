package com.deppon.dpm.module.anps.shared.domain;

public class ReadPeopleDetail {
	//阅读人员工号
	private String reciveUserId;
    //阅读人员头像
	private String headPath;
	//阅读人员姓名
	private String empName;
	//组织名称
	private String orgName;
	//组织名称
	private String jobName;
	//组织架构序列关系
	private String  deptseq;
	//是否读取公文 0 未读  1 已读
	private Integer  isRead;
	//组织ID
	private Integer orgId;
	//组织登记
	private Integer orgLevel;
	//事业部
	private String division;
	//大区
	private String region;
	//小区
	private String community;
	   
	
	
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCommunity() {
		return community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	public Integer getOrgLevel() {
		return orgLevel;
	}
	public void setOrgLevel(Integer orgLevel) {
		this.orgLevel = orgLevel;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	public String getDeptseq() {
		return deptseq;
	}
	public void setDeptseq(String deptseq) {
		this.deptseq = deptseq;
	}
	public Integer getIsRead() {
		return isRead;
	}
	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public String getReciveUserId() {
		return reciveUserId;
	}
	public void setReciveUserId(String reciveUserId) {
		this.reciveUserId = reciveUserId;
	}
	public String getHeadPath() {
		return headPath;
	}
	public void setHeadPath(String headPath) {
		this.headPath = headPath;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	

	

	
	

}
