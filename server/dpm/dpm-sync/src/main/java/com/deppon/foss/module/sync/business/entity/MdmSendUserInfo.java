package com.deppon.foss.module.sync.business.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class MdmSendUserInfo  implements Serializable{
	private static final long serialVersionUID = -8998243297473798132L;
	
    private String accountChangeId;
    //工号
    private String empCode;
    //工号
    private String userName;
    //姓名
    private String empName;
    //密码
    private String desPassword;
    //系统简码
    private String sysName;
    //部门名称
    private String orgName;
    //部门标杆编码
    private String orgBenchmarkCode;
    //部门编码
    private String orgCode;
    //岗位
    private String position;
    //同工号
    private String workCode;
    //性别
    private String gender;
    //是否临时人员
    private boolean isTemp;
    //是否激活
    private boolean isActive;
    private Date validDate;
    private Date invalidDate;
    private Date lastModifyTime;
    //修改方式
    private String changeType;
    private Date changeDate;
    private List<UserRoleInfo> roleInfo;
    private String roleInfoO;
    
    
    
	public String getRoleInfoO() {
		return roleInfoO;
	}
	public void setRoleInfoO(String roleInfoO) {
		this.roleInfoO = roleInfoO;
	}
	public String getAccountChangeId() {
		return accountChangeId;
	}
	public void setAccountChangeId(String accountChangeId) {
		this.accountChangeId = accountChangeId;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDesPassword() {
		return desPassword;
	}
	public void setDesPassword(String desPassword) {
		this.desPassword = desPassword;
	}
	public String getSysName() {
		return sysName;
	}
	public void setSysName(String sysName) {
		this.sysName = sysName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgBenchmarkCode() {
		return orgBenchmarkCode;
	}
	public void setOrgBenchmarkCode(String orgBenchmarkCode) {
		this.orgBenchmarkCode = orgBenchmarkCode;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getWorkCode() {
		return workCode;
	}
	public void setWorkCode(String workCode) {
		this.workCode = workCode;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isTemp() {
		return isTemp;
	}
	public void setTemp(boolean isTemp) {
		this.isTemp = isTemp;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Date getValidDate() {
		return validDate;
	}
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}
	public Date getInvalidDate() {
		return invalidDate;
	}
	public void setInvalidDate(Date invalidDate) {
		this.invalidDate = invalidDate;
	}
	public Date getLastModifyTime() {
		return lastModifyTime;
	}
	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
	public String getChangeType() {
		return changeType;
	}
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	public List<UserRoleInfo> getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(List<UserRoleInfo> roleInfo) {
		this.roleInfo = roleInfo;
	}
    
    
    
}
