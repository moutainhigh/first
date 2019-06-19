package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

public class InquiryConfirmEntity extends BaseEntity {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 3689449858880746880L;
	
	/**
	 * 单据id
	 */
	private String fid;
	
	/**
	 * 询价确认单据编号
	 */
	private String fnumber;
	
	/**
	 * 报价分析单号Id
	 */
	private String ffquoteNumberID;
	
	/**
	 * 报价分析单号
	 */
	private String fquoteNumber;
	
	/**
	 * RFQ单号Id
	 */
	private String cfrfqNumberID;
	
	/**
	 * RFQ单号
	 */
	private String cfrfqNumber;
	
	/**
	 * 单据状态
	 */
	private String cFBillState;
	
	/**
	 * 询价轮次
	 */
	private String cFInquiryNum;
	
	/**
	 * RFQ类型Id
	 */
	private String cFRFQTypeID;
	
	/**
	 * RFQ类型
	 */
	private String cFRFQTypeName;
	
	/**
	 * 备注
	 */
	private String cFRemark;
	
	/**
	 * 创建者
	 */
	private String fCreatorID;
	
	/**
	 * 创建时间
	 */
	private Date fCreateTime;
	
	/**
	 * 最后修改者
	 */
	private String fLastUpdateUserID;
	
	/**
	 * 最后修改时间
	 */
	private Date fLastUpdateTime;
	
	/**
	 * 控制单元
	 */
	private String fControlUnitID;
	
	/**
	 * 审核人
	 */
	private String fAuditorID;
	
	/**
	 * 原始单据ID
	 */
	private String fSourceBillID;
	
	/**
	 * 审核日期
	 */
	private Date cFAuditDate;
	
	/**
	 * 总金额
	 */
	private String amountMoney;
	
	public String getAmountMoney() {
		return amountMoney;
	}

	public void setAmountMoney(String amountMoney) {
		this.amountMoney = amountMoney;
	}

	/**
	 * @return the fid
	 */
	public String getFid() {
		return fid;
	}

	/**
	 * @param fid the fid to set
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}

	/**
	 * @return the fnumber
	 */
	public String getFnumber() {
		return fnumber;
	}

	/**
	 * @param fnumber the fnumber to set
	 */
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}

	/**
	 * @return the ffquoteNumberID
	 */
	public String getFfquoteNumberID() {
		return ffquoteNumberID;
	}

	/**
	 * @param ffquoteNumberID the ffquoteNumberID to set
	 */
	public void setFfquoteNumberID(String ffquoteNumberID) {
		this.ffquoteNumberID = ffquoteNumberID;
	}

	/**
	 * @return the cfrfqNumberID
	 */
	public String getCfrfqNumberID() {
		return cfrfqNumberID;
	}

	/**
	 * @param cfrfqNumberID the cfrfqNumberID to set
	 */
	public void setCfrfqNumberID(String cfrfqNumberID) {
		this.cfrfqNumberID = cfrfqNumberID;
	}

	/**
	 * @return the cFBillState
	 */
	public String getcFBillState() {
		return cFBillState;
	}

	/**
	 * @param cFBillState the cFBillState to set
	 */
	public void setcFBillState(String cFBillState) {
		this.cFBillState = cFBillState;
	}

	/**
	 * @return the cFInquiryNum
	 */
	public String getcFInquiryNum() {
		return cFInquiryNum;
	}

	/**
	 * @param cFInquiryNum the cFInquiryNum to set
	 */
	public void setcFInquiryNum(String cFInquiryNum) {
		this.cFInquiryNum = cFInquiryNum;
	}

	/**
	 * @return the cFRFQTypeID
	 */
	public String getcFRFQTypeID() {
		return cFRFQTypeID;
	}

	/**
	 * @param cFRFQTypeID the cFRFQTypeID to set
	 */
	public void setcFRFQTypeID(String cFRFQTypeID) {
		this.cFRFQTypeID = cFRFQTypeID;
	}

	/**
	 * @return the cFRemark
	 */
	public String getcFRemark() {
		return cFRemark;
	}

	/**
	 * @param cFRemark the cFRemark to set
	 */
	public void setcFRemark(String cFRemark) {
		this.cFRemark = cFRemark;
	}

	/**
	 * @return the fCreatorID
	 */
	public String getfCreatorID() {
		return fCreatorID;
	}

	/**
	 * @param fCreatorID the fCreatorID to set
	 */
	public void setfCreatorID(String fCreatorID) {
		this.fCreatorID = fCreatorID;
	}

	/**
	 * @return the fCreateTime
	 */
	public Date getfCreateTime() {
		return fCreateTime;
	}

	/**
	 * @param fCreateTime the fCreateTime to set
	 */
	public void setfCreateTime(Date fCreateTime) {
		this.fCreateTime = fCreateTime;
	}

	/**
	 * @return the fLastUpdateUserID
	 */
	public String getfLastUpdateUserID() {
		return fLastUpdateUserID;
	}

	/**
	 * @param fLastUpdateUserID the fLastUpdateUserID to set
	 */
	public void setfLastUpdateUserID(String fLastUpdateUserID) {
		this.fLastUpdateUserID = fLastUpdateUserID;
	}

	/**
	 * @return the fLastUpdateTime
	 */
	public Date getfLastUpdateTime() {
		return fLastUpdateTime;
	}

	/**
	 * @param fLastUpdateTime the fLastUpdateTime to set
	 */
	public void setfLastUpdateTime(Date fLastUpdateTime) {
		this.fLastUpdateTime = fLastUpdateTime;
	}

	/**
	 * @return the fControlUnitID
	 */
	public String getfControlUnitID() {
		return fControlUnitID;
	}

	/**
	 * @param fControlUnitID the fControlUnitID to set
	 */
	public void setfControlUnitID(String fControlUnitID) {
		this.fControlUnitID = fControlUnitID;
	}

	/**
	 * @return the fAuditorID
	 */
	public String getfAuditorID() {
		return fAuditorID;
	}

	/**
	 * @param fAuditorID the fAuditorID to set
	 */
	public void setfAuditorID(String fAuditorID) {
		this.fAuditorID = fAuditorID;
	}

	/**
	 * @return the fSourceBillID
	 */
	public String getfSourceBillID() {
		return fSourceBillID;
	}

	/**
	 * @param fSourceBillID the fSourceBillID to set
	 */
	public void setfSourceBillID(String fSourceBillID) {
		this.fSourceBillID = fSourceBillID;
	}
	
	

	/**
	 * @return the cFAuditDate
	 */
	public Date getcFAuditDate() {
		return cFAuditDate;
	}

	/**
	 * @param cFAuditDate the cFAuditDate to set
	 */
	public void setcFAuditDate(Date cFAuditDate) {
		this.cFAuditDate = cFAuditDate;
	}

	/**
	 * @return the fquoteNumber
	 */
	public String getFquoteNumber() {
		return fquoteNumber;
	}

	/**
	 * @param fquoteNumber the fquoteNumber to set
	 */
	public void setFquoteNumber(String fquoteNumber) {
		this.fquoteNumber = fquoteNumber;
	}

	/**
	 * @return the cfrfqNumber
	 */
	public String getCfrfqNumber() {
		return cfrfqNumber;
	}

	/**
	 * @param cfrfqNumber the cfrfqNumber to set
	 */
	public void setCfrfqNumber(String cfrfqNumber) {
		this.cfrfqNumber = cfrfqNumber;
	}

	/**
	 * @return the cFRFQTypeName
	 */
	public String getcFRFQTypeName() {
		return cFRFQTypeName;
	}

	/**
	 * @param cFRFQTypeName the cFRFQTypeName to set
	 */
	public void setcFRFQTypeName(String cFRFQTypeName) {
		this.cFRFQTypeName = cFRFQTypeName;
	}
	
	
}
