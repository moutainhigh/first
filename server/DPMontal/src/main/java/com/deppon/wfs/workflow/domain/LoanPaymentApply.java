package com.deppon.wfs.workflow.domain;


import java.math.BigDecimal;
import java.util.Date;


/**
 * 借支申请实体
 * @title: loanPaymentApply 
 * @author： lihai
 * @date： 2014-5-20 上午09:09:58
 */
public class LoanPaymentApply  {

	/**
	* 
	*/
	private static final long serialVersionUID = -6461312960093924828L;
	
	private String busino;
	
	/** 
	* 流程实例ID 
	*/
	private Long processinstid;
	
	/** 
	* 申请人工号
	*/
	private String applyPersonId;
	
	/** 
	* 申请人姓名 
	*/
	private String applyPersonName;
	
	/** 
	* 所属部门 
	*/
	private String applyDept;
	
	/** 
	* 所属子公司
	*/
	private String subsidiary;
	
	/** 
	* 借支类型
	*/
	private String loanType;
	
	/** 
	* 所属区域 
	*/
	private String area;
	
	/** 
	* 费用类型
	*/
	private String costType;
	
	/** 
	* 费用总金额 
	*/
	private BigDecimal totalMoney;
	
	/** 
	* 收款人 
	*/
	private String payee;
	
	/** 
	* 开户银行 
	*/
	private String depositBank;
	
	/** 
	* 开户支行名称 
	*/
	private String subBranchBank;
	
	/** 
	* 开户行所在省份 
	*/
	private String province;
	
	/** 
	* 开户行所在城市 
	*/
	private String city;
	
	/** 
	* 账号
	*/
	private String account;
	
	/** 
	* 最迟汇款日期
	*/
	private Date finalRemittance;
	
	/** 
	* 发票抬头 
	*/
	private String invoiceTitle;
	
	/** 
	* 费用发生日期 
	*/
	private Date occurencyDate;
	
	/** 
	* 付款用途 
	*/
	private String payUse;
	
	/** 
	* 费用划分部门 
	*/
	private String departmentaization;
	
	/** 
	* 短信通知手机号码 
	*/
	private String mobilePhonebysms;
	
	/** 
	* 申请事由 
	*/
	private String applyReason;
	
	/** 
	* 创建时间 
	*/
	private Date createTime;
	
	/** 
	* 修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 业务状态，是否有效（1-有效 0-无效） 
	*/
	private String isseffective;
	
	/** 
	* 备注1 
	*/
	private Long sparefield1;
	
	/** 
	* 备注2 
	*/
	private String sparefield2;
	
	/** 
	* 备注3 
	*/
	private String sparefield3;

	/**
	 * @return the busino
	 */
	public String getBusino() {
		return busino;
	}

	/**
	 * @param busino the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}

	/**
	 * @return the processinstid
	 */
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	 * @param processinstid the processinstid to set
	 */
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}

	

	/**
	 * @return the applyPersonId
	 */
	public String getApplyPersonId() {
		return applyPersonId;
	}

	/**
	 * @param applyPersonId the applyPersonId to set
	 */
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}

	/**
	 * @return the applyPersonName
	 */
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	 * @param applyPersonName the applyPersonName to set
	 */
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}

	/**
	 * @return the applyDept
	 */
	public String getApplyDept() {
		return applyDept;
	}

	/**
	 * @param applyDept the applyDept to set
	 */
	public void setApplyDept(String applyDept) {
		this.applyDept = applyDept;
	}

	/**
	 * @return the subsidiary
	 */
	public String getSubsidiary() {
		return subsidiary;
	}

	/**
	 * @param subsidiary the subsidiary to set
	 */
	public void setSubsidiary(String subsidiary) {
		this.subsidiary = subsidiary;
	}

	/**
	 * @return the loanType
	 */
	public String getLoanType() {
		return loanType;
	}

	/**
	 * @param loanType the loanType to set
	 */
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the costType
	 */
	public String getCostType() {
		return costType;
	}

	/**
	 * @param costType the costType to set
	 */
	public void setCostType(String costType) {
		this.costType = costType;
	}

	/**
	 * @return the totalMoney
	 */
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	/**
	 * @param totalMoney the totalMoney to set
	 */
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	/**
	 * @return the payee
	 */
	public String getPayee() {
		return payee;
	}

	/**
	 * @param payee the payee to set
	 */
	public void setPayee(String payee) {
		this.payee = payee;
	}

	/**
	 * @return the depositBank
	 */
	public String getDepositBank() {
		return depositBank;
	}

	/**
	 * @param depositBank the depositBank to set
	 */
	public void setDepositBank(String depositBank) {
		this.depositBank = depositBank;
	}

	/**
	 * @return the subBranchBank
	 */
	public String getSubBranchBank() {
		return subBranchBank;
	}

	/**
	 * @param subBranchBank the subBranchBank to set
	 */
	public void setSubBranchBank(String subBranchBank) {
		this.subBranchBank = subBranchBank;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	
	/**
	 * @return the invoiceTitle
	 */
	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	/**
	 * @param invoiceTitle the invoiceTitle to set
	 */
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	
	/**
	 * @return the finalRemittance
	 */
	public Date getFinalRemittance() {
		return finalRemittance;
	}

	/**
	 * @param finalRemittance the finalRemittance to set
	 */
	public void setFinalRemittance(Date finalRemittance) {
		this.finalRemittance = finalRemittance;
	}

	/**
	 * @return the occurencyDate
	 */
	public Date getOccurencyDate() {
		return occurencyDate;
	}

	/**
	 * @param occurencyDate the occurencyDate to set
	 */
	public void setOccurencyDate(Date occurencyDate) {
		this.occurencyDate = occurencyDate;
	}

	/**
	 * @return the payUse
	 */
	public String getPayUse() {
		return payUse;
	}

	/**
	 * @param payUse the payUse to set
	 */
	public void setPayUse(String payUse) {
		this.payUse = payUse;
	}

	/**
	 * @return the departmentaization
	 */
	public String getDepartmentaization() {
		return departmentaization;
	}

	/**
	 * @param departmentaization the departmentaization to set
	 */
	public void setDepartmentaization(String departmentaization) {
		this.departmentaization = departmentaization;
	}

	/**
	 * @return the mobilePhonebysms
	 */
	public String getMobilePhonebysms() {
		return mobilePhonebysms;
	}

	/**
	 * @param mobilePhonebysms the mobilePhonebysms to set
	 */
	public void setMobilePhonebysms(String mobilePhonebysms) {
		this.mobilePhonebysms = mobilePhonebysms;
	}

	/**
	 * @return the applyReason
	 */
	public String getApplyReason() {
		return applyReason;
	}

	/**
	 * @param applyReason the applyReason to set
	 */
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	

	/**
	 * @return the isseffective
	 */
	public String getIsseffective() {
		return isseffective;
	}

	/**
	 * @param isseffective the isseffective to set
	 */
	public void setIsseffective(String isseffective) {
		this.isseffective = isseffective;
	}

	/**
	 * @return the sparefield1
	 */
	public Long getSparefield1() {
		return sparefield1;
	}

	/**
	 * @param sparefield1 the sparefield1 to set
	 */
	public void setSparefield1(Long sparefield1) {
		this.sparefield1 = sparefield1;
	}

	/**
	 * @return the sparefield2
	 */
	public String getSparefield2() {
		return sparefield2;
	}

	/**
	 * @param sparefield2 the sparefield2 to set
	 */
	public void setSparefield2(String sparefield2) {
		this.sparefield2 = sparefield2;
	}

	/**
	 * @return the sparefield3
	 */
	public String getSparefield3() {
		return sparefield3;
	}

	/**
	 * @param sparefield3 the sparefield3 to set
	 */
	public void setSparefield3(String sparefield3) {
		this.sparefield3 = sparefield3;
	}
	
	
	
}
