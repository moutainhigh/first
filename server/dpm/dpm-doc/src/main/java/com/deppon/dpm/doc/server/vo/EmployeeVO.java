package com.deppon.dpm.doc.server.vo;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;

/**
 * 
 * 
 * <pre>
 * 人员实体类.
 * </pre>
 * 
 * @since
 * 
 *        <pre>
 *   modify by 130126 on 2014-4-1
 *    fix->1.
 *         2.
 * </pre>
 */
public class EmployeeVO implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4409637740522012381L;
	
	/**
	 * 构造方法
	 */
	public EmployeeVO(){
		super();
	}
	
	/**
	 * 起始
	 */
	private int start;
	/**
	 * 条数
	 */
	private int limit;
	/**
	 * 员工id
	 */
	private int empId;
	/**
	 * 工号
	 */
	private String empCode;
	/**
	 * 姓名
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
	 * 员工状态
	 */
	private String empStatus;
	/**
	 * 证件类型
	 */
	private String cardType;
	/**
	 * 证件号
	 */
	private String cardNo;
	/**
	 * 入职日期
	 */
	private Date inDate;
	/**
	 * 企业邮箱账号
	 */
	private String emailUserName;
	/**
	 * 手机号
	 */
	private String mobileNo;
	/**
	 * 邮政编号
	 */
	private String zipCode;
	/**
	 * 私人邮箱
	 */
	private String email;
	/**
	 * 组织编号
	 */
	private int orgId;
	/**
	 * 职位名称
	 */
	private String jobName;
	/**
	 * 职位族群
	 */
	private String jobGroups;
	/**
	 * 职位等级
	 */
	private String jobLevel;
	/**
	 * 创建日期
	 */
	private Date createTime;
	/**
	 * 更新日期
	 */
	private Date updateTime;
	/**
	 * 职位序列
	 */
	private String jobSequence;
	/**
	 * 职责
	 */
	private String jobDuty;
	/**
	 * 联系方式
	 */
	private String tel;
	/**
	 * 地址
	 */
	private String address;
	private String depart;
	/**
	 * 匹配次数
	 */
	private int callFrequency;
	/**
	 * 企业邮箱密码
	 */
	private String emailPassword;
	/**
	 * 头像
	 */
	private String headPhoto;
	/**
	 * 判断是否是常用联系人
	 */
	private String myFavoritesStatus;
	/**
	 * 父组织id
	 */
	private String parentOrgId;
	/**
	 * 组织名
	 */
	private String orgName;
	/**
	 * 组织序列关系
	 */
	private String deptSeq;
	/**
	 * 休假信息
	 */
	private int furlough;
	/**
	 * 休假交接人
	 */
	private String handoverPerson;
	
	/**
	 * get
	 * @return
	 */
	public String getHandoverPerson() {
		return handoverPerson;
	}

	/**
	 * set
	 * @param handoverPerson
	 */
	public void setHandoverPerson(String handoverPerson) {
		this.handoverPerson = handoverPerson;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getStart() {
		return start;
	}

	/**
	 * set
	 * 
	 * @param start
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * set
	 * 
	 * @param limit
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getParentOrgId() {
		return parentOrgId;
	}

	/**
	 * set
	 * 
	 * @param parentOrgId
	 */
	public void setParentOrgId(String parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

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
	public String getDepart() {
		return depart;
	}

	/**
	 * set
	 * 
	 * @param depart
	 */
	public void setDepart(String depart) {
		this.depart = depart;
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
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * set
	 * 
	 * @param zipCode
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * set
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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
	public String getEmail() {
		return email;
	}

	/**
	 * set
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getMyFavoritesStatus() {
		return myFavoritesStatus;
	}

	/**
	 * set
	 * 
	 * @param myFavoritesStatus
	 */
	public void setMyFavoritesStatus(String myFavoritesStatus) {
		this.myFavoritesStatus = myFavoritesStatus;
	}
	
	/**
	 * getter
	 * @return
	 */
	public String getDeptSeq() {
		return deptSeq;
	}

	/**
	 * setter
	 * @param deptSeq
	 */
	public void setDeptSeq(String deptSeq) {
		this.deptSeq = deptSeq;
	}

	/**
	 * toString
	 */
	public String toString() {
		return JSON.toJSONString(this);
	}

	public int getFurlough() {
		return furlough;
	}

	public void setFurlough(int furlough) {
		this.furlough = furlough;
	}
	
}
