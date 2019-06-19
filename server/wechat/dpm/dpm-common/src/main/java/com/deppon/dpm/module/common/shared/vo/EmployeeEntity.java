/**
 * Project Name:dpm-tongxunlu
 * File Name:EmployeeEntity.java
 * Package Name:com.deppon.dpm.tongxunlu.shared.domain
 * Date:2014-8-8上午10:09:39
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.deppon.dpm.module.common.shared.vo;

import java.util.Date;

/**
 * ClassName:EmployeeEntity <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * 
 * Date: 2014-8-8 上午10:09:39 <br/>
 * 
 * @author 157229-zxy
 * @version
 * @since JDK 1.6
 */
public class EmployeeEntity {
	/**
	 * 员工id
	 */
	private int empId;
	/**
	 * 员工code
	 */
	private String empCode;
	/**
	 * 员工姓名
	 */
	private String empName;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 生日
	 */
	private Date birthDate;
	/**
	 * 状态 on=在职
	 */
	private String empStatus;
	/**
	 * 类型
	 */
	private String cardType;
	/**
	 * 号码
	 */
	private String cardNo;
	/**
	 * 入职日期
	 */
	private Date inDate;
	/**
	 * 企业邮箱
	 */
	private String oEmail;
	/**
	 * 手机号
	 */
	private String mobileNo;
	/**
	 * 邮编
	 */
	private String hzipCode;
	/**
	 * 邮箱
	 */
	private String pEmail;
	/**
	 * 机构id
	 */
	private int orgId;
	/**
	 * 工作名
	 */
	private String jobName;
	/**
	 * 族群
	 */
	private String jobGroups;
	/**
	 * 等级
	 */
	private String jobLevel;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date lastUpdate;
	/**
	 * 工作序列
	 */
	private String jobSequence;
	/**
	 * 工作职责
	 */
	private String jobDuty;
	/**
	 * 电话
	 */
	private String tel;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 企业邮箱账号
	 */
	private String emailUserName;
	/**
	 * 企业邮箱密码
	 */
	private String emailPassword;
	/**
	 * 匹配次数
	 */
	private int callFrequency;
	/**
	 * 头像
	 */
	private String headPhoto;
	/**
	 * 组织名称
	 */
	private String orgName;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getHeadPhoto() {
		return headPhoto;
	}

	/**
	 * set
	 * 
	 * @param headPhoto
	 */
	public void setHeadPhoto(String headPhoto) {
		this.headPhoto = headPhoto;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getCallFrequency() {
		return callFrequency;
	}

	/**
	 * set
	 * 
	 * @param callFrequency
	 */
	public void setCallFrequency(int callFrequency) {
		this.callFrequency = callFrequency;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * set
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * set
	 * 
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * set
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * set
	 * 
	 * @param empId
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getEmpCode() {
		return empCode;
	}

	/**
	 * set
	 * 
	 * @param empCode
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * set
	 * 
	 * @param empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * set
	 * 
	 * @param birthDate
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getEmpStatus() {
		return empStatus;
	}

	/**
	 * set
	 * 
	 * @param empStatus
	 */
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getCardType() {
		return cardType;
	}

	/**
	 * set
	 * 
	 * @param cardType
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getCardNo() {
		return cardNo;
	}

	/**
	 * set
	 * 
	 * @param cardNo
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getInDate() {
		return inDate;
	}

	/**
	 * set
	 * 
	 * @param inDate
	 */
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getoEmail() {
		return oEmail;
	}

	/**
	 * set
	 * 
	 * @ptaram oEmail
	 */
	public void setoEmail(String oEmail) {
		this.oEmail = oEmail;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * set
	 * 
	 * @param mobileNo
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getHzipCode() {
		return hzipCode;
	}

	/**
	 * set
	 * 
	 * @param hzipCode
	 */
	public void setHzipCode(String hzipCode) {
		this.hzipCode = hzipCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getpEmail() {
		return pEmail;
	}

	/**
	 * set
	 * 
	 * @param pEmail
	 */
	public void setpEmail(String pEmail) {
		this.pEmail = pEmail;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getOrgId() {
		return orgId;
	}

	/**
	 * set
	 * 
	 * @param orgId
	 */
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * set
	 * 
	 * @param jobName
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getJobGroups() {
		return jobGroups;
	}

	/**
	 * set
	 * 
	 * @param jobGroups
	 */
	public void setJobGroups(String jobGroups) {
		this.jobGroups = jobGroups;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getJobLevel() {
		return jobLevel;
	}

	/**
	 * set
	 * 
	 * @param jobLevel
	 */
	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * set
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * set
	 * 
	 * @param lastUpdate
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getJobSequence() {
		return jobSequence;
	}

	/**
	 * set
	 * 
	 * @param jobSequence
	 */
	public void setJobSequence(String jobSequence) {
		this.jobSequence = jobSequence;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getJobDuty() {
		return jobDuty;
	}

	/**
	 * set
	 * 
	 * @param jobDuty
	 */
	public void setJobDuty(String jobDuty) {
		this.jobDuty = jobDuty;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getEmailUserName() {
		return emailUserName;
	}

	/**
	 * set
	 * 
	 * @param emailUserName
	 */
	public void setEmailUserName(String emailUserName) {
		this.emailUserName = emailUserName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getEmailPassword() {
		return emailPassword;
	}

	/**
	 * set
	 * 
	 * @param emailPassword
	 */
	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * set
	 * 
	 * @param orgName
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}
