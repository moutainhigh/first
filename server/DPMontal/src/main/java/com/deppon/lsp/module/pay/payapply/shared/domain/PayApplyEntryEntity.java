package com.deppon.lsp.module.pay.payapply.shared.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 * @author liuhongdong
 * @date 2013-9-28上午8:59:26
 * @description 付款申请单分录实体
 */
public class PayApplyEntryEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5509446637198036437L;
	
	/**
	 * 付款申请单分录ID
	 */
	private String payApplyEntryId;
	
	/**
	 * 付款申请单ID
	 */
	private String payApplyId;
	
	/**
	 * 付款类型
	 */
	private String payType;
	
	/**
	 * 来往类型
	 */
	private String asstType;
	
	/**
	 * 来往户编码
	 */
	private String asstNo;

	/**
	 * 来往户名称
	 */
	private String asstName;

	/**
	 * 审批付款金额
	 */
	private BigDecimal reqAmount;
	
	/**
	 * 审批金额
	 */
	private BigDecimal auditAmount;
	
	/**
	 * 付款日期
	 */
	private Date payDay;
	
	/**
	 * 源单未申请预付款金额
	 */
	private BigDecimal srcPrepAmount;
	
	/**
	 * 源单未审批付款金额
	 */
	private BigDecimal srcReqAmount;
	
	/**
	 * 累计付款金额
	 */
	private BigDecimal totalAmount;
	
	/**
	 * 未付款金额
	 */
	private BigDecimal unPayAmount;
	
	/**
	 * 往来户银行账号
	 */
	private String accountBankNo;
	
	/**
	 * 往来户开户银行
	 */
	private String accountBank;
	
	/**
	 * 结算方式编号
	 */
	private String banlanceType;
	
	/**
	 * 结算方式
	 */
	private String payBank;
	
	/**
	 * 付款银行
	 */
	private String payBankAccount;
	
	/**
	 * 付款账号
	 */
	private String feeOwnerDept;
	
	/**
	 * 费用承担部门
	 */
	private String banlanceTypeNo;
	
	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:15:29
	 * @description
	 * @return
	 */
	public String getBanlanceTypeNo() {
		return banlanceTypeNo;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:15:33
	 * @description
	 * @param banlanceTypeNo
	 */
	public void setBanlanceTypeNo(String banlanceTypeNo) {
		this.banlanceTypeNo = banlanceTypeNo;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:15:36
	 * @description
	 * @return
	 */
	public String getAsstNo() {
		return asstNo;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:15:40
	 * @description
	 * @param asstNo
	 */
	public void setAsstNo(String asstNo) {
		this.asstNo = asstNo;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:15:44
	 * @description
	 * @return
	 */
	public String getPayApplyEntryId() {
		return payApplyEntryId;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:15:49
	 * @description
	 * @param payApplyEntryId
	 */
	public void setPayApplyEntryId(String payApplyEntryId) {
		this.payApplyEntryId = payApplyEntryId;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:15:55
	 * @description
	 * @return
	 */
	public String getPayApplyId() {
		return payApplyId;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:15:59
	 * @description
	 * @param payApplyId
	 */
	public void setPayApplyId(String payApplyId) {
		this.payApplyId = payApplyId;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:16:03
	 * @description
	 * @return
	 */
	public String getPayType() {
		return payType;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:16:08
	 * @description
	 * @param payType
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:16:12
	 * @description
	 * @return
	 */
	public String getAsstType() {
		return asstType;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:16:16
	 * @description
	 * @param asstType
	 */
	public void setAsstType(String asstType) {
		this.asstType = asstType;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:16:20
	 * @description
	 * @return
	 */
	public String getAsstName() {
		return asstName;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:16:26
	 * @description
	 * @param asstName
	 */
	public void setAsstName(String asstName) {
		this.asstName = asstName;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:16:30
	 * @description
	 * @return
	 */
	public BigDecimal getReqAmount() {
		return reqAmount;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:16:36
	 * @description
	 * @param reqAmount
	 */
	public void setReqAmount(BigDecimal reqAmount) {
		this.reqAmount = reqAmount;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:16:42
	 * @description
	 * @return
	 */
	public BigDecimal getAuditAmount() {
		return auditAmount;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:16:47
	 * @description
	 * @param auditAmount
	 */
	public void setAuditAmount(BigDecimal auditAmount) {
		this.auditAmount = auditAmount;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:16:52
	 * @description
	 * @return
	 */
	public Date getPayDay() {
		return payDay;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:16:56
	 * @description
	 * @param payDay
	 */
	public void setPayDay(Date payDay) {
		this.payDay = payDay;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:17:00
	 * @description
	 * @return
	 */
	public BigDecimal getSrcPrepAmount() {
		return srcPrepAmount;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:17:06
	 * @description
	 * @param srcPrepAmount
	 */
	public void setSrcPrepAmount(BigDecimal srcPrepAmount) {
		this.srcPrepAmount = srcPrepAmount;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:17:10
	 * @description
	 * @return
	 */
	public BigDecimal getSrcReqAmount() {
		return srcReqAmount;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:17:14
	 * @description
	 * @param srcReqAmount
	 */
	public void setSrcReqAmount(BigDecimal srcReqAmount) {
		this.srcReqAmount = srcReqAmount;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:17:18
	 * @description
	 * @return
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:17:23
	 * @description
	 * @param totalAmount
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:17:28
	 * @description
	 * @return
	 */
	public BigDecimal getUnPayAmount() {
		return unPayAmount;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:17:33
	 * @description
	 * @param unPayAmount
	 */
	public void setUnPayAmount(BigDecimal unPayAmount) {
		this.unPayAmount = unPayAmount;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:17:36
	 * @description
	 * @return
	 */
	public String getAccountBankNo() {
		return accountBankNo;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:17:40
	 * @description
	 * @param accountBankNo
	 */
	public void setAccountBankNo(String accountBankNo) {
		this.accountBankNo = accountBankNo;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:17:44
	 * @description
	 * @return
	 */
	public String getAccountBank() {
		return accountBank;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:17:51
	 * @description
	 * @param accountBank
	 */
	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:17:54
	 * @description
	 * @return
	 */
	public String getBanlanceType() {
		return banlanceType;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:17:59
	 * @description
	 * @param banlanceType
	 */
	public void setBanlanceType(String banlanceType) {
		this.banlanceType = banlanceType;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:18:04
	 * @description
	 * @return
	 */
	public String getPayBank() {
		return payBank;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:18:08
	 * @description
	 * @param payBank
	 */
	public void setPayBank(String payBank) {
		this.payBank = payBank;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:18:12
	 * @description
	 * @return
	 */
	public String getPayBankAccount() {
		return payBankAccount;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:18:16
	 * @description
	 * @param payBankAccount
	 */
	public void setPayBankAccount(String payBankAccount) {
		this.payBankAccount = payBankAccount;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:18:20
	 * @description
	 * @return
	 */
	public String getFeeOwnerDept() {
		return feeOwnerDept;
	}

	/**
	 * 
	 * @author liuhongdong
	 * @date 2013-9-28上午11:18:24
	 * @description
	 * @param feeOwnerDept
	 */
	public void setFeeOwnerDept(String feeOwnerDept) {
		this.feeOwnerDept = feeOwnerDept;
	}


}
