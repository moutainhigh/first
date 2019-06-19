package com.deppon.lsp.module.purchase.purchasecontact.share.vo;

import java.io.Serializable;
import java.util.Date;

public class PurchaseContactVo implements Serializable{
	private static final long serialVersionUID = -2206329376701148054L;
	
	private String fid;
	private String applier;//申请人
	private Date applyDate;//申请时间
	private String contactNo;//合同编号
	private String contactName;//合同名称
	private String contactAmount;//合同金额
	private String partyA;//甲方
	private String partyB;//乙方（供应商）
	private String partyC;//丙方
	private String contactType;//合同类别
	private String type;//合同类型
	private String signedType;//签订类型
	private Date startDate;//开始日期
	private Date endDate;//截止日期
	private String department;//归档事业部
	private String projectNo;//项目编号
	private String projectName;//项目名称
	private String projectNumber; //项目编号
	private String projectsName; //项目名称
	private String sealParty;//优先盖章方
	private String remark;//备注
	private String signDepartment;//签订部门所属事业部
	private Long isSeal;//是否我方先盖章
	private String currency;//币种
	private String currencySign;//币种符号
	private String amountCn;//中文金额
	
	private String contactTypeNum;
	
	public String getContactTypeNum() {
		return contactTypeNum;
	}
	public void setContactTypeNum(String contactTypeNum) {
		this.contactTypeNum = contactTypeNum;
	}
	
	public String getCurrencySign() {
		return currencySign;
	}
	public void setCurrencySign(String currencySign) {
		this.currencySign = currencySign;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAmountCn() {
		return amountCn;
	}
	public void setAmountCn(String amountCn) {
		this.amountCn = amountCn;
	}
	public Long getIsSeal() {
		return isSeal;
	}
	public void setIsSeal(Long isSeal) {
		this.isSeal = isSeal;
	}
	public String getSignDepartment() {
		return signDepartment;
	}
	public void setSignDepartment(String signDepartment) {
		this.signDepartment = signDepartment;
	}
	public String getApplier() {
		return applier;
	}
	public void setApplier(String applier) {
		this.applier = applier;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactAmount() {
		return contactAmount;
	}
	public void setContactAmount(String contactAmount) {
		this.contactAmount = contactAmount;
	}
	public String getPartyA() {
		return partyA;
	}
	public void setPartyA(String partyA) {
		this.partyA = partyA;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getPartyB() {
		return partyB;
	}
	public void setPartyB(String partyB) {
		this.partyB = partyB;
	}
	public String getPartyC() {
		return partyC;
	}
	public void setPartyC(String partyC) {
		this.partyC = partyC;
	}
	public String getContactType() {
		return contactType;
	}
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSignedType() {
		return signedType;
	}
	public void setSignedType(String signedType) {
		this.signedType = signedType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getSealParty() {
		return sealParty;
	}
	public void setSealParty(String sealParty) {
		this.sealParty = sealParty;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the projectNumber
	 */
	public String getProjectNumber() {
		return projectNumber;
	}
	/**
	 * @param projectNumber the projectNumber to set
	 */
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}
	/**
	 * @return the projectsName
	 */
	public String getProjectsName() {
		return projectsName;
	}
	/**
	 * @param projectsName the projectsName to set
	 */
	public void setProjectsName(String projectsName) {
		this.projectsName = projectsName;
	}
	
}
