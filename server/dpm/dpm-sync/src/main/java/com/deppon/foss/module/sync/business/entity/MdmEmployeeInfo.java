package com.deppon.foss.module.sync.business.entity;

import java.io.Serializable;
import java.util.Date;

public class MdmEmployeeInfo implements Serializable{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 480695819019213369L;
	// 中间表变更ID
	private String employeeChangeId;
	// UUMS部门表ID
	private int deptId;
	// 员工工号
	private String empCode;
	// 员工姓名
	private String empName;
	// 性别
	private int gender;
	// 所属组织名称
	private String deptName;
	// 所属组织标杆编码
	private String deptStandCode;
	// 职位
	private String position;
	// 职级
	private String positionGrade;
	// 证件号码
	private String docNumber;
	// 上装码

	private Double withCode;
	// 裤腰码
	private Double waistCode;
	// 身高

	private Double height;
	// 体重
	private Double weight;
	// 出生日期

	private Date birthDate;
	// 人员状态

	private int status;
	// 入职日期
	private Date inDate;
	// 离职日期

	private Date outDate;
	// 办公电话
	private String officeTel;
	// 办公地址
	private String officeAddress;
	//办公邮箱
	private String officeEmail;
	//手机号码
	private String mobile;
	// 家庭电话
	private String homeTel;
	// 家庭地址
	private String homeAddress;
	// 私人邮箱
	private String personalEmail;
	// 工作描述
	private String workexp;
	// 岗位编码
	private String jobCode;
	// 岗位职责
	private String jobDuty;
	// 岗位族群
	private String jobGroups;
	// 岗位等级
	private String jobLevel;

	// 岗位序列
	private String jobSequence;
	// 是否临时人员
	private int isTempEmp;
	// 创建时间yyyy-MM-dd HH:mm:ss SSS
	private String createDate;
	// 创建人
	private String createUser;
	// 最后修改时间yyyy-MM-dd HH:mm:ss SSS
	private String modifyDate;
	// 最后修改人
	private String modifyUser;
	// 开始时间yyyy-MM-dd HH:mm:ss SSS
	private String beginTime;
	// 结束时间yyyy-MM-dd HH:mm:ss SSS
	private String endTime;
	// 民族
	private String nationality;
	// 学历
	private String education;

	// 毕业院校
	private String school;
	// 婚姻状况
	private String marital;
	// 户口性质
	private String characterRpr;
	// 所属组织编码
	private String deptCode;
	//是否合伙人
	private String isPartner;
	//备用字段
	private String spare;
	
	public int getIsTempEmp() {
		return isTempEmp;
	}
	public void setIsTempEmp(int isTempEmp) {
		this.isTempEmp = isTempEmp;
	}
	public String getIsPartner() {
		return isPartner;
	}
	public void setIsPartner(String isPartner) {
		this.isPartner = isPartner;
	}
	public String getSpare() {
		return spare;
	}
	public void setSpare(String spare) {
		this.spare = spare;
	}
	public String getEmployeeChangeId() {
		return employeeChangeId;
	}
	public void setEmployeeChangeId(String employeeChangeId) {
		this.employeeChangeId = employeeChangeId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
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
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptStandCode() {
		return deptStandCode;
	}
	public void setDeptStandCode(String deptStandCode) {
		this.deptStandCode = deptStandCode;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPositionGrade() {
		return positionGrade;
	}
	public void setPositionGrade(String positionGrade) {
		this.positionGrade = positionGrade;
	}
	public String getDocNumber() {
		return docNumber;
	}
	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}
	public Double getWithCode() {
		return withCode;
	}
	public void setWithCode(Double withCode) {
		this.withCode = withCode;
	}
	public Double getWaistCode() {
		return waistCode;
	}
	public void setWaistCode(Double waistCode) {
		this.waistCode = waistCode;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	public String getOfficeTel() {
		return officeTel;
	}
	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getOfficeEmail() {
		return officeEmail;
	}
	public void setOfficeEmail(String officeEmail) {
		this.officeEmail = officeEmail;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getHomeTel() {
		return homeTel;
	}
	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getPersonalEmail() {
		return personalEmail;
	}
	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}
	public String getWorkexp() {
		return workexp;
	}
	public void setWorkexp(String workexp) {
		this.workexp = workexp;
	}
	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public String getJobDuty() {
		return jobDuty;
	}
	public void setJobDuty(String jobDuty) {
		this.jobDuty = jobDuty;
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
	public String getJobSequence() {
		return jobSequence;
	}
	public void setJobSequence(String jobSequence) {
		this.jobSequence = jobSequence;
	}
	public int isTempEmp() {
		return isTempEmp;
	}
	public void setTempEmp(int isTempEmp) {
		this.isTempEmp = isTempEmp;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getModifyUser() {
		return modifyUser;
	}
	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMarital() {
		return marital;
	}
	public void setMarital(String marital) {
		this.marital = marital;
	}
	public String getCharacterRpr() {
		return characterRpr;
	}
	public void setCharacterRpr(String characterRpr) {
		this.characterRpr = characterRpr;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
