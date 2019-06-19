package com.deppon.fssc.module.remote.mobile.shared;

import java.math.BigDecimal;

import com.deppon.fssc.module.claimsupport.shared.domain.ClaimLineBaseEntity;
import com.deppon.montal.conf.F_Constants;

public class ClaimLineFssc extends ClaimLineBaseEntity{

	private static final long serialVersionUID = -3689422128325596480L;
	private String bizOccurDateStr;

	public String getBizOccurDateStr() {
		return F_Constants.getDateyyyyMMdd(bizOccurDateStr);
	}

	public void setBizOccurDateStr(String bizOccurDateStr) {
		this.bizOccurDateStr = bizOccurDateStr;
	}
	
	/*************员工私人借支单特需要字段************************/
	// 工伤人员名称	
	private String injuryName;
	// 工伤人员工号
	private String injuryCode;
	// 工伤发生日期	
	private String injuryDateStr;
	// 工伤人员所属部门编码
	private String injuryDeptcode;
	// 工伤人员所属部门名称
	private String injuryDeptname;
	// 工伤人员所属公司编码
	private String injuryCompanynumber;
	// 工伤人员所属公司名称
	private String injuryCompanyname;
	// 工伤的编号
	private String injuryNum;
	
	/**********薪酬福利报账单明细需要字段***********************/
	// 社保主体编码
	private String securityCode;
	// 社保主体单位
	private String securityUnits;
	// 管理费
	private BigDecimal manageFee;
	// 个人社保总计
	private BigDecimal personalTotSocialSecurity;
	// 单位社保总计
	private BigDecimal compTotSocialSecurity;
	// 社保卡扣款--
	private BigDecimal socialSecurityCardFee;
	
	/**********暂收款报账单明细需要字段***********************/
	// 认领编号
	private String applyNum;
	// 押金系统编号
	private String depositSysnum;
	// 押金类型
	private String depositType;
	// 暂收款客户
	private String clientName;
	// 暂收款客户编码
	private String clientCode;
	// 暂收款总金额
	private BigDecimal depositTotAmount;
	// 收据编号
	private String receiptNum;
	// 可支付金额
	private BigDecimal ablePayAmount;
	// 暂收日期
	private String depositDate;
	// 招标日期
	private String inviteBidDate;
	// 合同/押金到期日
	private String expireDate;
	// 是否中标
	private String isWin;
	// 客户在本次业务往来中是否存在违约行为
	private String isBreach;
	// 扣除违约金额
	private BigDecimal deductBreachAmount;
	// 押金是否用于冲抵房租
	private String isOffsetRent;
	// 抵扣房租押金
	private BigDecimal offsetRentAmount;
	// 客户与我司在其他业务往来中是否存在欠款
	private String existDebt;
	// 客户欠款金额
	private BigDecimal debtAmount;
	//辅助账客户编码
	private String aidAttri;
	//辅助账客户名称
	private String aidAttriName;
	//汇款人账号
	private String accountNo;
	//退款日期
	private String refundDate;
	
	/**********FOSS报账单明细需要字段***********************/
	//单据号
	private String billNo;
	//运单号
	private String waybillNum;
	//差错编号
	private String mistakeCode;
	//预收单据编号
	private String priorBillCode;
	//汇款编号
	private String remitCode;
	//出发部门
	private String startDept;
	//到达部门
	private String arriveDept;
	//出发部门Name
	private String startDeptName;
	//到达部门Name
	private String arriveDeptName;
	//车次号
	private String carNum;
	//车牌号
	private String licensePlateNum;
	//司机
	private String driverName;
	//总额
	private BigDecimal totalAmount;
	//出发付款金额
	private BigDecimal startPayAmount;
	//到达付款金额
	private BigDecimal arrivePayAmount;
	//增减变化
	private String ragulationChange;
	//奖励/扣款
	private String rewardOrCutpay;
	//是否押回单
	private String isReturnBill;
	//是否月结
	private String isMonthStatement;
	
	/**********6.26 事前申请单明细需要字段***********************/
	//目的地
	private String destination;
	//业务发生日期
	private String  strDate;
	//业务结束日期
	private String endDate;
	//出差天数
	private BigDecimal travleDays;
	//最高同行人级别
	private String highestLev;
	
	
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getTravleDays() {
		return travleDays;
	}

	public void setTravleDays(BigDecimal travleDays) {
		this.travleDays = travleDays;
	}

	public String getHighestLev() {
		return highestLev;
	}

	public void setHighestLev(String highestLev) {
		this.highestLev = highestLev;
	}

	/**
	 * @return the manageFee
	 */
	public BigDecimal getManageFee() {
		return manageFee;
	}

	/**
	 * @param manageFee the manageFee to set
	 */
	public void setManageFee(BigDecimal manageFee) {
		this.manageFee = manageFee;
	}

	/**
	 * @return the personalTotSocialSecurity
	 */
	public BigDecimal getPersonalTotSocialSecurity() {
		return personalTotSocialSecurity;
	}

	/**
	 * @param personalTotSocialSecurity the personalTotSocialSecurity to set
	 */
	public void setPersonalTotSocialSecurity(BigDecimal personalTotSocialSecurity) {
		this.personalTotSocialSecurity = personalTotSocialSecurity;
	}

	/**
	 * @return the compTotSocialSecurity
	 */
	public BigDecimal getCompTotSocialSecurity() {
		return compTotSocialSecurity;
	}

	/**
	 * @param compTotSocialSecurity the compTotSocialSecurity to set
	 */
	public void setCompTotSocialSecurity(BigDecimal compTotSocialSecurity) {
		this.compTotSocialSecurity = compTotSocialSecurity;
	}

	/**
	 * @return the socialSecurityCardFee
	 */
	public BigDecimal getSocialSecurityCardFee() {
		return socialSecurityCardFee;
	}

	/**
	 * @param socialSecurityCardFee the socialSecurityCardFee to set
	 */
	public void setSocialSecurityCardFee(BigDecimal socialSecurityCardFee) {
		this.socialSecurityCardFee = socialSecurityCardFee;
	}

	/**
	 * @return the billNo
	 */
	public String getBillNo() {
		return billNo;
	}

	/**
	 * @param billNo the billNo to set
	 */
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	/**
	 * @return the waybillNum
	 */
	public String getWaybillNum() {
		return waybillNum;
	}

	/**
	 * @param waybillNum the waybillNum to set
	 */
	public void setWaybillNum(String waybillNum) {
		this.waybillNum = waybillNum;
	}

	/**
	 * @return the mistakeCode
	 */
	public String getMistakeCode() {
		return mistakeCode;
	}

	/**
	 * @param mistakeCode the mistakeCode to set
	 */
	public void setMistakeCode(String mistakeCode) {
		this.mistakeCode = mistakeCode;
	}

	/**
	 * @return the priorBillCode
	 */
	public String getPriorBillCode() {
		return priorBillCode;
	}

	/**
	 * @param priorBillCode the priorBillCode to set
	 */
	public void setPriorBillCode(String priorBillCode) {
		this.priorBillCode = priorBillCode;
	}

	/**
	 * @return the remitCode
	 */
	public String getRemitCode() {
		return remitCode;
	}

	/**
	 * @param remitCode the remitCode to set
	 */
	public void setRemitCode(String remitCode) {
		this.remitCode = remitCode;
	}

	/**
	 * @return the startDept
	 */
	public String getStartDept() {
		return startDept;
	}

	/**
	 * @param startDept the startDept to set
	 */
	public void setStartDept(String startDept) {
		this.startDept = startDept;
	}

	/**
	 * @return the arriveDept
	 */
	public String getArriveDept() {
		return arriveDept;
	}

	/**
	 * @param arriveDept the arriveDept to set
	 */
	public void setArriveDept(String arriveDept) {
		this.arriveDept = arriveDept;
	}

	/**
	 * @return the startDeptName
	 */
	public String getStartDeptName() {
		return startDeptName;
	}

	/**
	 * @param startDeptName the startDeptName to set
	 */
	public void setStartDeptName(String startDeptName) {
		this.startDeptName = startDeptName;
	}

	/**
	 * @return the arriveDeptName
	 */
	public String getArriveDeptName() {
		return arriveDeptName;
	}

	/**
	 * @param arriveDeptName the arriveDeptName to set
	 */
	public void setArriveDeptName(String arriveDeptName) {
		this.arriveDeptName = arriveDeptName;
	}

	/**
	 * @return the carNum
	 */
	public String getCarNum() {
		return carNum;
	}

	/**
	 * @param carNum the carNum to set
	 */
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	/**
	 * @return the licensePlateNum
	 */
	public String getLicensePlateNum() {
		return licensePlateNum;
	}

	/**
	 * @param licensePlateNum the licensePlateNum to set
	 */
	public void setLicensePlateNum(String licensePlateNum) {
		this.licensePlateNum = licensePlateNum;
	}

	/**
	 * @return the driverName
	 */
	public String getDriverName() {
		return driverName;
	}

	/**
	 * @param driverName the driverName to set
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	/**
	 * @return the totalAmount
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the startPayAmount
	 */
	public BigDecimal getStartPayAmount() {
		return startPayAmount;
	}

	/**
	 * @param startPayAmount the startPayAmount to set
	 */
	public void setStartPayAmount(BigDecimal startPayAmount) {
		this.startPayAmount = startPayAmount;
	}

	/**
	 * @return the arrivePayAmount
	 */
	public BigDecimal getArrivePayAmount() {
		return arrivePayAmount;
	}

	/**
	 * @param arrivePayAmount the arrivePayAmount to set
	 */
	public void setArrivePayAmount(BigDecimal arrivePayAmount) {
		this.arrivePayAmount = arrivePayAmount;
	}

	/**
	 * @return the ragulationChange
	 */
	public String getRagulationChange() {
		return ragulationChange;
	}

	/**
	 * @param ragulationChange the ragulationChange to set
	 */
	public void setRagulationChange(String ragulationChange) {
		this.ragulationChange = ragulationChange;
	}

	/**
	 * @return the rewardOrCutpay
	 */
	public String getRewardOrCutpay() {
		return rewardOrCutpay;
	}

	/**
	 * @param rewardOrCutpay the rewardOrCutpay to set
	 */
	public void setRewardOrCutpay(String rewardOrCutpay) {
		this.rewardOrCutpay = rewardOrCutpay;
	}

	/**
	 * @return the isReturnBill
	 */
	public String getIsReturnBill() {
		return isReturnBill;
	}

	/**
	 * @param isReturnBill the isReturnBill to set
	 */
	public void setIsReturnBill(String isReturnBill) {
		this.isReturnBill = isReturnBill;
	}

	/**
	 * @return the isMonthStatement
	 */
	public String getIsMonthStatement() {
		return isMonthStatement;
	}

	/**
	 * @param isMonthStatement the isMonthStatement to set
	 */
	public void setIsMonthStatement(String isMonthStatement) {
		this.isMonthStatement = isMonthStatement;
	}

	public String getInjuryName() {
		return injuryName;
	}

	public void setInjuryName(String injuryName) {
		this.injuryName = injuryName;
	}

	public String getInjuryCode() {
		return injuryCode;
	}

	public void setInjuryCode(String injuryCode) {
		this.injuryCode = injuryCode;
	}

	public String getInjuryDeptcode() {
		return injuryDeptcode;
	}

	public void setInjuryDeptcode(String injuryDeptcode) {
		this.injuryDeptcode = injuryDeptcode;
	}

	public String getInjuryDeptname() {
		return injuryDeptname;
	}

	public void setInjuryDeptname(String injuryDeptname) {
		this.injuryDeptname = injuryDeptname;
	}

	public String getInjuryCompanynumber() {
		return injuryCompanynumber;
	}

	public void setInjuryCompanynumber(String injuryCompanynumber) {
		this.injuryCompanynumber = injuryCompanynumber;
	}

	public String getInjuryCompanyname() {
		return injuryCompanyname;
	}

	public void setInjuryCompanyname(String injuryCompanyname) {
		this.injuryCompanyname = injuryCompanyname;
	}

	public String getInjuryNum() {
		return injuryNum;
	}

	public void setInjuryNum(String injuryNum) {
		this.injuryNum = injuryNum;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getSecurityUnits() {
		return securityUnits;
	}

	public void setSecurityUnits(String securityUnits) {
		this.securityUnits = securityUnits;
	}

	public String getInjuryDateStr() {
		return injuryDateStr;
	}

	public void setInjuryDateStr(String injuryDateStr) {
		this.injuryDateStr = injuryDateStr;
	}

	public String getApplyNum() {
		return applyNum;
	}

	public String getDepositSysnum() {
		return depositSysnum;
	}

	public String getDepositType() {
		return depositType;
	}

	public String getClientName() {
		return clientName;
	}

	public String getClientCode() {
		return clientCode;
	}

	public BigDecimal getDepositTotAmount() {
		return depositTotAmount;
	}

	public String getReceiptNum() {
		return receiptNum;
	}

	public BigDecimal getAblePayAmount() {
		return ablePayAmount;
	}

	public String getDepositDate() {
		return depositDate;
	}

	public String getInviteBidDate() {
		return inviteBidDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public String getIsWin() {
		return isWin;
	}

	public String getIsBreach() {
		return isBreach;
	}

	public BigDecimal getDeductBreachAmount() {
		return deductBreachAmount;
	}

	public String getIsOffsetRent() {
		return isOffsetRent;
	}

	public BigDecimal getOffsetRentAmount() {
		return offsetRentAmount;
	}

	public String getExistDebt() {
		return existDebt;
	}

	public BigDecimal getDebtAmount() {
		return debtAmount;
	}

	public String getAidAttri() {
		return aidAttri;
	}

	public String getAidAttriName() {
		return aidAttriName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public String getRefundDate() {
		return refundDate;
	}

	public void setApplyNum(String applyNum) {
		this.applyNum = applyNum;
	}

	public void setDepositSysnum(String depositSysnum) {
		this.depositSysnum = depositSysnum;
	}

	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public void setDepositTotAmount(BigDecimal depositTotAmount) {
		this.depositTotAmount = depositTotAmount;
	}

	public void setReceiptNum(String receiptNum) {
		this.receiptNum = receiptNum;
	}

	public void setAblePayAmount(BigDecimal ablePayAmount) {
		this.ablePayAmount = ablePayAmount;
	}

	public void setDepositDate(String depositDate) {
		this.depositDate = depositDate;
	}

	public void setInviteBidDate(String inviteBidDate) {
		this.inviteBidDate = inviteBidDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public void setIsWin(String isWin) {
		this.isWin = isWin;
	}

	public void setIsBreach(String isBreach) {
		this.isBreach = isBreach;
	}

	public void setDeductBreachAmount(BigDecimal deductBreachAmount) {
		this.deductBreachAmount = deductBreachAmount;
	}

	public void setIsOffsetRent(String isOffsetRent) {
		this.isOffsetRent = isOffsetRent;
	}

	public void setOffsetRentAmount(BigDecimal offsetRentAmount) {
		this.offsetRentAmount = offsetRentAmount;
	}

	public void setExistDebt(String existDebt) {
		this.existDebt = existDebt;
	}

	public void setDebtAmount(BigDecimal debtAmount) {
		this.debtAmount = debtAmount;
	}

	public void setAidAttri(String aidAttri) {
		this.aidAttri = aidAttri;
	}

	public void setAidAttriName(String aidAttriName) {
		this.aidAttriName = aidAttriName;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setRefundDate(String refundDate) {
		this.refundDate = refundDate;
	}
	
}
