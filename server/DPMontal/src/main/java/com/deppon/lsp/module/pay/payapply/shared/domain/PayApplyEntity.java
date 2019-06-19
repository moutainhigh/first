package com.deppon.lsp.module.pay.payapply.shared.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 * @author liuhongdong
 * @date 2013-9-28上午8:49:57
 * @description 付款申请表头实体
 */
public class PayApplyEntity extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1766380682162429909L;
	
	/**
	 * 付款申请单ID
	 */
	private String payApplyId;
	
	/**
	 * 付款申请单编号
	 */
	private String payApplyNo;
	
	/**
	 * 公司ID
	 */
	private String companyId;
	
	/**
	 * 公司名称
	 */
	private String companyName;
	
	/**
	 * 审批类型
	 */
	private String approvalType;
	
	/**
	 * 单据日期
	 */
	private Date bizDate;
	
	/**
	 * 采购组织ID
	 */
	private String purOrgId;
	
	/**
	 * 采购组织名称
	 */
	private String purOrgName;
	
	/**
	 * 申请人ID
	 */
	private String userId;
	
	/**
	 * 申请人工号
	 */
	private String userNumber;
	
	/**
	 * 申请人名称
	 */
	private String userName;

	/**
	 * 申请金额
	 */
	private BigDecimal requestAmount;
	
	/**
	 * 审批金额
	 */
	private BigDecimal auditAmount;
	
	/**
	 * 付款情况
	 */
	private String situation;
	
	/**
	 * 付款事由
	 */
	private String explain;
	
	/**
	 * 单据状态
	 */
	private String billStatus;
	
	/**
	 * 是否需要总裁审批
	 */
	private String isNeedLeader;
	
	/**
	 * 票据单号
	 */
	private String billNumber;
	
	/**
	 * 审批人ID
	 */
	private String auditorId;
	
	/**
	 * 审核日期
	 */
	private Date auditDate;
	
	/**
	 * 到期日期
	 */
    private Date deadLine;
	
    /**
     * 请款理由
     */
	private String requestReason;
	
	/**
	 * 币别名称
	 */
	private String currencyName;
	
	/**
	 * 中文金额
	 */
	private String currencyUpCase;
	
	/**
	 * 应付科目
	 * @return
	 */
	private String  faccountid;
	/**
	 * 付款金额
	 * @return
	 */
	private BigDecimal fPayAmount;
	
	
	
	

	public BigDecimal getfPayAmount() {
		return fPayAmount;
	}

	public void setfPayAmount(BigDecimal fPayAmount) {
		this.fPayAmount = fPayAmount;
	}

	public String getFaccountid() {
		return faccountid;
	}

	public void setFaccountid(String faccountid) {
		this.faccountid = faccountid;
	}

	public String getCurrencyUpCase() {
		return currencyUpCase;
	}

	public void setCurrencyUpCase(String currencyUpCase) {
		this.currencyUpCase = currencyUpCase;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getCurrencySign() {
		return currencySign;
	}

	public void setCurrencySign(String currencySign) {
		this.currencySign = currencySign;
	}

	/**
	 * 币别符号
	 */
	private String currencySign;
	
	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:10:23
	 * @description
	 * @return
	 */
	public String getAuditorId() {
		return auditorId;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:10:28
	 * @description
	 * @param auditorId
	 */
	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:10:33
	 * @description
	 * @return
	 */
	public Date getAuditDate() {
		return auditDate;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:10:36
	 * @description
	 * @param auditDate
	 */
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:10:41
	 * @description
	 * @return
	 */
	public String getBillNumber() {
		return billNumber;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:10:44
	 * @description
	 * @param billNumber
	 */
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:10:51
	 * @description
	 * @return
	 */
	public Date getDeadLine() {
		return deadLine;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:10:55
	 * @description
	 * @param deadLine
	 */
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:10:58
	 * @description
	 * @return
	 */
	public String getRequestReason() {
		return requestReason;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:11:03
	 * @description
	 * @param requestReason
	 */
	public void setRequestReason(String requestReason) {
		this.requestReason = requestReason;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:11:08
	 * @description
	 * @return
	 */
	public String getIsNeedLeader() {
		return isNeedLeader;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:11:13
	 * @description
	 * @param isNeedLeader
	 */
	public void setIsNeedLeader(String isNeedLeader) {
		this.isNeedLeader = isNeedLeader;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:11:17
	 * @description
	 * @return
	 */
	public String getBillStatus() {
		return billStatus;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:11:21
	 * @description
	 * @param billStatus
	 */
	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:11:25
	 * @description
	 * @return
	 */
	public String getUserNumber() {
		return userNumber;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:11:29
	 * @description
	 * @param userNumber
	 */
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:11:33
	 * @description
	 * @return
	 */
	public String getPayApplyId() {
		return payApplyId;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:11:44
	 * @description
	 * @param payApplyId
	 */
	public void setPayApplyId(String payApplyId) {
		this.payApplyId = payApplyId;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:11:48
	 * @description
	 * @return
	 */
	public String getPayApplyNo() {
		return payApplyNo;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:11:52
	 * @description
	 * @param payApplyNo
	 */
	public void setPayApplyNo(String payApplyNo) {
		this.payApplyNo = payApplyNo;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:11:59
	 * @description
	 * @return
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:12:04
	 * @description
	 * @param companyId
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:12:08
	 * @description
	 * @return
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:12:13
	 * @description
	 * @param companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:12:17
	 * @description
	 * @return
	 */
	public String getApprovalType() {
		return approvalType;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:12:23
	 * @description
	 * @param approvalType
	 */
	public void setApprovalType(String approvalType) {
		this.approvalType = approvalType;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:12:31
	 * @description
	 * @return
	 */
	public Date getBizDate() {
		return bizDate;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:12:28
	 * @description
	 * @param bizDate
	 */
	public void setBizDate(Date bizDate) {
		this.bizDate = bizDate;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:12:36
	 * @description
	 * @return
	 */
	public String getPurOrgId() {
		return purOrgId;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:12:43
	 * @description
	 * @param purOrgId
	 */
	public void setPurOrgId(String purOrgId) {
		this.purOrgId = purOrgId;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:12:48
	 * @description
	 * @return
	 */
	public String getPurOrgName() {
		return purOrgName;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:12:51
	 * @description
	 * @param purOrgName
	 */
	public void setPurOrgName(String purOrgName) {
		this.purOrgName = purOrgName;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:12:56
	 * @description
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:13:01
	 * @description
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:13:05
	 * @description
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:13:12
	 * @description
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:13:18
	 * @description
	 * @return
	 */
	public BigDecimal getRequestAmount() {
		return requestAmount;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:13:22
	 * @description
	 * @param requestAmount
	 */
	public void setRequestAmount(BigDecimal requestAmount) {
		this.requestAmount = requestAmount;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:13:30
	 * @description
	 * @return
	 */
	public BigDecimal getAuditAmount() {
		return auditAmount;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:14:35
	 * @description
	 * @param auditAmount
	 */
	public void setAuditAmount(BigDecimal auditAmount) {
		this.auditAmount = auditAmount;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:14:48
	 * @description
	 * @return
	 */
	public String getSituation() {
		return situation;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:14:52
	 * @description
	 * @param situation
	 */
	public void setSituation(String situation) {
		this.situation = situation;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:14:57
	 * @description
	 * @return
	 */
	public String getExplain() {
		return explain;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:15:01
	 * @description
	 * @param explain
	 */
	public void setExplain(String explain) {
		this.explain = explain;
	}

}
