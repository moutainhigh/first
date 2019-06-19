package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

public class RFQBill extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**RFQ申请单号*/
	private String rfqclaimerNumber;
	
	/**RFQ类型*/
	private String rfqtype;
	
	/**询价轮次*/
	private int enquiry;
	
	/**单据状态*/
	private String state;
	
	/**询价日期*/
	private Date enquiryTurn;
	
	/**询价部门*/
	private String enquiryDepartment;
	
	/**询价人*/
	private String enquiryer;
	
	/**采购申请单号*/
	private String purApplyNumber;
	
	/**制单人是否为总部人员*/
	private boolean dpzb;
	
	/**单据编号*/
	private String number;
	
	/**业务日期*/
	private Date bizDate;
	
	/**经手人*/
	private String handler;
	
	/**参考信息*/
	private String description;
	
	/**是否曾经生效*/
	private boolean hasEffected;
	
	/**审核人*/
	private String auditor;
	
	/**原始单据ID*/
	private String sourceBillId;
	
	/**来源功能*/
	private String sourceFunction;
	
	/**创建者*/
	private String creator;
	
	/**创建时间*/
	private Date createTime;
	
	/**最后修改者*/
	private String lastUpdateUser;
	
	/**最后修改时间*/
	private Date lastUpdateTime;
	
	/**控制单元*/
	private  String cu;
	
	/**ID*/
	private String fid;
	
	/**登陆人的id单据里面是没有的，但是为了在审批的时候取到，而使用*/
	private String pmUserID;  
	
	/**采购寻源采购员*/
	private String purchaseAndSearcherID;
	/**rfq单是否可以进行下游单据的推送*/
	private String isCreateTo;
	/*
	 * 新增加字段总金额
	 * 2014-07-16
	 */
	private String amountMoney;

	public String getAmountMoney() {
		return amountMoney;
	}

	public void setAmountMoney(String amountMoney) {
		this.amountMoney = amountMoney;
	}

	public String getIsCreateTo() {
		return isCreateTo;
	}

	public void setIsCreateTo(String isCreateTo) {
		this.isCreateTo = isCreateTo;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:02:28
	* @version：
	* @return String
	 */
	public String getPurchaseAndSearcherID() {
		return purchaseAndSearcherID;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:02:32
	* @version：
	* @param purchaseAndSearcherID void
	 */
	public void setPurchaseAndSearcherID(String purchaseAndSearcherID) {
		this.purchaseAndSearcherID = purchaseAndSearcherID;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:02:37
	* @version：
	* @return String
	 */
	public String getPmUserID() {
		return pmUserID;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:02:40
	* @version：
	* @param pmUserID void
	 */
	public void setPmUserID(String pmUserID) {
		this.pmUserID = pmUserID;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:02:43
	* @version：
	* @return String
	 */
	public String getRfqclaimerNumber() {
		return rfqclaimerNumber;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:02:47
	* @version：
	* @param rfqclaimerNumber void
	 */
	public void setRfqclaimerNumber(String rfqclaimerNumber) {
		this.rfqclaimerNumber = rfqclaimerNumber;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:02:51
	* @version：
	* @return String
	 */
	public String getRfqtype() {
		return rfqtype;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:02:56
	* @version：
	* @param rfqtype void
	 */
	public void setRfqtype(String rfqtype) {
		this.rfqtype = rfqtype;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:03:00
	* @version：
	* @return int
	 */
	public int getEnquiry() {
		return enquiry;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:03:03
	* @version：
	* @param enquiry void
	 */
	public void setEnquiry(int enquiry) {
		this.enquiry = enquiry;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:03:06
	* @version：
	* @return String
	 */
	public String getState() {
		return state;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:03:09
	* @version：
	* @param state void
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:03:12
	* @version：
	* @return Date
	 */
	public Date getEnquiryTurn() {
//		return FormatUtil.formatDate(enquiryTurn);
		return enquiryTurn;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:03:15
	* @version：
	* @param enquiryTurn void
	 */
	public void setEnquiryTurn(Date enquiryTurn) {
		this.enquiryTurn = enquiryTurn;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:03:18
	* @version：
	* @return String
	 */
	public String getEnquiryDepartment() {
		return enquiryDepartment;
	}

	public void setEnquiryDepartment(String enquiryDepartment) {
		this.enquiryDepartment = enquiryDepartment;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:03:21
	* @version：
	* @return String
	 */
	public String getEnquiryer() {
		return enquiryer;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:03:24
	* @version：
	* @param enquiryer void
	 */
	public void setEnquiryer(String enquiryer) {
		this.enquiryer = enquiryer;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:03:27
	* @version：
	* @return String
	 */
	public String getPurApplyNumber() {
		return purApplyNumber;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:03:30
	* @version：
	* @param purApplyNumber void
	 */
	public void setPurApplyNumber(String purApplyNumber) {
		this.purApplyNumber = purApplyNumber;
	}



	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:03:35
	* @version：
	* @return boolean
	 */
	public boolean isDpzb() {
		return dpzb;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:03:38
	* @version：
	* @param dpzb void
	 */
	public void setDpzb(boolean dpzb) {
		this.dpzb = dpzb;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:03:42
	* @version：
	* @return String
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:03:46
	* @version：
	* @param number void
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:03:49
	* @version：
	* @return Date
	 */
	public Date getBizDate() {
		return bizDate;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:03:52
	* @version：
	* @param bizDate void
	 */
	public void setBizDate(Date bizDate) {
		this.bizDate = bizDate;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:03:55
	* @version：
	* @return String
	 */
	public String getHandler() {
		return handler;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:03:59
	* @version：
	* @param handler void
	 */
	public void setHandler(String handler) {
		this.handler = handler;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:04:02
	* @version：
	* @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:04:08
	* @version：
	* @param description void
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:04:11
	* @version：
	* @return boolean
	 */
	public boolean isHasEffected() {
		return hasEffected;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:04:14
	* @version：
	* @param hasEffected void
	 */
	public void setHasEffected(boolean hasEffected) {
		this.hasEffected = hasEffected;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:04:17
	* @version：
	* @return String
	 */
	public String getAuditor() {
		return auditor;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:04:21
	* @version：
	* @param auditor void
	 */
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:04:24
	* @version：
	* @return String
	 */
	public String getSourceBillId() {
		return sourceBillId;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:04:28
	* @version：
	* @param sourceBillId void
	 */
	public void setSourceBillId(String sourceBillId) {
		this.sourceBillId = sourceBillId;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:04:33
	* @version：
	* @return String
	 */
	public String getSourceFunction() {
		return sourceFunction;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:04:36
	* @version：
	* @param sourceFunction void
	 */
	public void setSourceFunction(String sourceFunction) {
		this.sourceFunction = sourceFunction;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:04:39
	* @version：
	* @return String
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:04:44
	* @version：
	* @param creator void
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:04:47
	* @version：
	* @return Date
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:04:51
	* @version：
	* @param createTime void
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:04:54
	* @version：
	* @return String
	 */
	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:04:59
	* @version：
	* @param lastUpdateUser void
	 */
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:05:03
	* @version：
	* @return Date
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:05:06
	* @version：
	* @param lastUpdateTime void
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:05:10
	* @version：
	* @return String
	 */
	public String getCu() {
		return cu;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:05:13
	* @version：
	* @param cU void
	 */
	public void setCu(String cU) {
		cu = cU;
	}

/**
 * 
* TODO
* @description： 
* @author：130355
* @date：2014-4-9 下午5:05:18
* @version：
* @return long
 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:05:22
	* @version：
	* @return String
	 */
	public String getFid() {
		return fid;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:05:25
	* @version：
	* @param fid void
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}
	
	
	
	
	

}
