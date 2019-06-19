/**   
 * @Title: finalAccountEntity.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 徐丁钉   
 * @date 2013-12-11 下午5:49:53  
 */
package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.util.Date;

import com.deppon.montal.util.FormatUtil;



/**
 * @ClassName: finalAccountEntity
 * @Description: 决算申请单实体；
 * @author 徐丁钉
 * @date 2013-12-11 下午5:49:53
 * 
 */
public class FinalAccountApplyEntity {

	private String fCreatorId;// 创建者
	private String fCreatorName;
	private Date fCreateTime;// 创建时间
	private String fLastUpDateUserId;// 最后修改者
	private Date fLastUpDateTime;// 最后修改时间
	private String fControlUnitId;// 控制单元
	private String fNumber;// 单据编号
	private String fBizdate;// 业务日期
	private String fHandlerId;// 经手人
	private String fDescription;// 参考信息
	private String fHaseffected;// 是否曾经生效
	private String fAuditorId;// 审核人
	private String fSourceBillId;// 原始单据ID
	private String fSourceFunction;// 来源功能
	private String fid;//
	private String fFivouchered;// 是否生产凭证
	private String cfProjectNumberId;// 项目编号
	private String cfProjectName;// 项目名称
	private Date cfStartTime;// 项目开始日期
	private Date cfCompletedTime;// 项目竣工时间
	private String cfContractNumberId;// 合同编号
	private String cfContractName;// 合同名称
	private String cfContractAmount;// 合同金额
	private String cfPaymentAmount;// 合同已支付金额
	private String cfWithHoldTotal;// 扣款总计
	private String cfBudgetAmount;// 决算总金额
	private String cfTaxRate;// 税率
	private String cfTaxAmount;// 税额
	private String cfMeetingSubject;// 会议主题
	private Date cfMeetingTime;// 会审时间
	private String cfMeetinoplegpId;// 会议人员
	private String cfMeetingResult;// 会审决议
	private String cfBudgetingAmount;// 预算金额
	private String cfDeviation;// 偏离度
	private String cfAcceptWithHold;// 验收扣款
	private String cfAcceptPoints;// 验收扣分
	private String cfDeviateReason;// 备注
	private String cfAuditDepartmenti;// 审计部门
	private String cfAuditUnit;// 审计单位
	private String cfAuditFind;// 审计发现
	private String cfAuditResults;// 审计原因
	private String cfBudgetAmountTax;// 总额价税合计
	private String cfState;// 单据状态
	private String cfSupplierId;// 供应商
	private String cfPayAmount;// 本次付款金额
	private String cfGuaranteeAmount;// 保修金额
	private String cfSubsidiaryId;// 所属子公司
	private Date cfBudgetTime;// 决算时间
	private String cfCreateorGunitId;// 创建部门
	private Date cfAuditTime;// 审核时间
	private String cfProjectStatus;// 项目状态
	private String fCompanyId;// 文本
	private String fPersonNumber;//
	private String cfProjectNumberName;// 项目编号
	private String cfContractNumberName;// 合同编号
	private String cfMeetinOplegPName;// 会议人员
	private String cfAuditDepartmentName;// 审计部门
	private String cfSupplierName;// 供应商
	private String cfCreateOrgUnitName;// 创建部门
	private String fCompanyName;// 公司（财务组织）
	private String fProjectModel;
	private String cfSubsidiaryName;// 所属子公司名称；

	/**
	 * @return the fCreatorId
	 */
	public String getfCreatorId() {
		return fCreatorId;
	}

	/**
	 * @param fCreatorId
	 *            the fCreatorId to set
	 */
	public void setfCreatorId(String fCreatorId) {
		this.fCreatorId = fCreatorId;
	}

	/**
	 * @return the fCreateTime
	 */
	public Date getfCreateTime() {
		return fCreateTime;
	}

	/**
	 * @param fCreateTime
	 *            the fCreateTime to set
	 */
	public void setfCreateTime(Date fCreateTime) {
		this.fCreateTime = fCreateTime;
	}

	/**
	 * @return the fLastUpDateUserId
	 */
	public String getfLastUpDateUserId() {
		return fLastUpDateUserId;
	}

	/**
	 * @param fLastUpDateUserId
	 *            the fLastUpDateUserId to set
	 */
	public void setfLastUpDateUserId(String fLastUpDateUserId) {
		this.fLastUpDateUserId = fLastUpDateUserId;
	}

	/**
	 * @return the fLastUpDateTime
	 */
	public Date getfLastUpDateTime() {
		return fLastUpDateTime;
	}

	/**
	 * @param fLastUpDateTime
	 *            the fLastUpDateTime to set
	 */
	public void setfLastUpDateTime(Date fLastUpDateTime) {
		this.fLastUpDateTime = fLastUpDateTime;
	}

	/**
	 * @return the fControlUnitId
	 */
	public String getfControlUnitId() {
		return fControlUnitId;
	}

	/**
	 * @param fControlUnitId
	 *            the fControlUnitId to set
	 */
	public void setfControlUnitId(String fControlUnitId) {
		this.fControlUnitId = fControlUnitId;
	}

	/**
	 * @return the fNumber
	 */
	public String getfNumber() {
		return fNumber;
	}

	/**
	 * @param fNumber
	 *            the fNumber to set
	 */
	public void setfNumber(String fNumber) {
		this.fNumber = fNumber;
	}

	/**
	 * @return the fBizdate
	 */
	public String getfBizdate() {
		return fBizdate;
	}

	/**
	 * @param fBizdate
	 *            the fBizdate to set
	 */
	public void setfBizdate(String fBizdate) {
		this.fBizdate = fBizdate;
	}

	/**
	 * @return the fHandlerId
	 */
	public String getfHandlerId() {
		return fHandlerId;
	}

	/**
	 * @param fHandlerId
	 *            the fHandlerId to set
	 */
	public void setfHandlerId(String fHandlerId) {
		this.fHandlerId = fHandlerId;
	}

	/**
	 * @return the fDescription
	 */
	public String getfDescription() {
		return fDescription;
	}

	/**
	 * @param fDescription
	 *            the fDescription to set
	 */
	public void setfDescription(String fDescription) {
		this.fDescription = fDescription;
	}

	/**
	 * @return the fHaseffected
	 */
	public String getfHaseffected() {
		return fHaseffected;
	}

	/**
	 * @param fHaseffected
	 *            the fHaseffected to set
	 */
	public void setfHaseffected(String fHaseffected) {
		this.fHaseffected = fHaseffected;
	}

	/**
	 * @return the fAuditorId
	 */
	public String getfAuditorId() {
		return fAuditorId;
	}

	/**
	 * @param fAuditorId
	 *            the fAuditorId to set
	 */
	public void setfAuditorId(String fAuditorId) {
		this.fAuditorId = fAuditorId;
	}

	/**
	 * @return the fSourceBillId
	 */
	public String getfSourceBillId() {
		return fSourceBillId;
	}

	/**
	 * @param fSourceBillId
	 *            the fSourceBillId to set
	 */
	public void setfSourceBillId(String fSourceBillId) {
		this.fSourceBillId = fSourceBillId;
	}

	/**
	 * @return the fSourceFunction
	 */
	public String getfSourceFunction() {
		return fSourceFunction;
	}

	/**
	 * @param fSourceFunction
	 *            the fSourceFunction to set
	 */
	public void setfSourceFunction(String fSourceFunction) {
		this.fSourceFunction = fSourceFunction;
	}

	/**
	 * @return the fid
	 */
	public String getFid() {
		return fid;
	}

	/**
	 * @param fid
	 *            the fid to set
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}

	/**
	 * @return the fFivouchered
	 */
	public String getfFivouchered() {
		return fFivouchered;
	}

	/**
	 * @param fFivouchered
	 *            the fFivouchered to set
	 */
	public void setfFivouchered(String fFivouchered) {
		this.fFivouchered = fFivouchered;
	}

	/**
	 * @return the cfProjectNumberId
	 */
	public String getCfProjectNumberId() {
		return cfProjectNumberId;
	}

	/**
	 * @param cfProjectNumberId
	 *            the cfProjectNumberId to set
	 */
	public void setCfProjectNumberId(String cfProjectNumberId) {
		this.cfProjectNumberId = cfProjectNumberId;
	}

	/**
	 * @return the cfProjectName
	 */
	public String getCfProjectName() {
		return cfProjectName;
	}

	/**
	 * @param cfProjectName
	 *            the cfProjectName to set
	 */
	public void setCfProjectName(String cfProjectName) {
		this.cfProjectName = cfProjectName;
	}

	/**
	 * @return the cfStartTime
	 */
	public Date getCfStartTime() {
		return cfStartTime;
	}

	/**
	 * @param cfStartTime
	 *            the cfStartTime to set
	 */
	public void setCfStartTime(Date cfStartTime) {
		this.cfStartTime = cfStartTime;
	}

	/**
	 * @return the cfCompletedTime
	 */
	public Date getCfCompletedTime() {
		return cfCompletedTime;
	}

	/**
	 * @param cfCompletedTime
	 *            the cfCompletedTime to set
	 */
	public void setCfCompletedTime(Date cfCompletedTime) {
		this.cfCompletedTime = cfCompletedTime;
	}

	/**
	 * @return the cfContractNumberId
	 */
	public String getCfContractNumberId() {
		return cfContractNumberId;
	}

	/**
	 * @param cfContractNumberId
	 *            the cfContractNumberId to set
	 */
	public void setCfContractNumberId(String cfContractNumberId) {
		this.cfContractNumberId = cfContractNumberId;
	}

	/**
	 * @return the cfContractName
	 */
	public String getCfContractName() {
		return cfContractName;
	}

	/**
	 * @param cfContractName
	 *            the cfContractName to set
	 */
	public void setCfContractName(String cfContractName) {
		this.cfContractName = cfContractName;
	}

	/**
	 * @return the cfContractAmount
	 */
	public String getCfContractAmount() {
		return FormatUtil.formatDouble("###,###,###,###.00", cfContractAmount);
	}

	/**
	 * @param cfContractAmount
	 *            the cfContractAmount to set
	 */
	public void setCfContractAmount(String cfContractAmount) {
		this.cfContractAmount = cfContractAmount;
	}

	/**
	 * @return the cfPaymentAmount
	 */
	public String getCfPaymentAmount() {
		return FormatUtil.formatDouble("###,###,###,###.00", cfPaymentAmount);
	}

	/**
	 * @param cfPaymentAmount
	 *            the cfPaymentAmount to set
	 */
	public void setCfPaymentAmount(String cfPaymentAmount) {
		this.cfPaymentAmount = cfPaymentAmount;
	}

	/**
	 * @return the cfWithHoldTotal
	 */
	public String getCfWithHoldTotal() {
		return FormatUtil.formatDouble("###,###,###,###.00", cfWithHoldTotal);
	}

	/**
	 * @param cfWithHoldTotal
	 *            the cfWithHoldTotal to set
	 */
	public void setCfWithHoldTotal(String cfWithHoldTotal) {
		this.cfWithHoldTotal = cfWithHoldTotal;
	}

	/**
	 * @return the cfBudgetAmount
	 */
	public String getCfBudgetAmount() {
		return FormatUtil.formatDouble("###,###,###,###.00", cfBudgetAmount);
	}

	/**
	 * @param cfBudgetAmount
	 *            the cfBudgetAmount to set
	 */
	public void setCfBudgetAmount(String cfBudgetAmount) {
		this.cfBudgetAmount = cfBudgetAmount;
	}

	/**
	 * @return the cfTaxRate
	 */
	public String getCfTaxRate() {
		return cfTaxRate;
	}

	/**
	 * @param cfTaxRate
	 *            the cfTaxRate to set
	 */
	public void setCfTaxRate(String cfTaxRate) {
		this.cfTaxRate = cfTaxRate;
	}

	/**
	 * @return the cfTaxAmount
	 */
	public String getCfTaxAmount() {
		return FormatUtil.formatDouble("###,###,###,###.00", cfTaxAmount);
	}

	/**
	 * @param cfTaxAmount
	 *            the cfTaxAmount to set
	 */
	public void setCfTaxAmount(String cfTaxAmount) {
		this.cfTaxAmount = cfTaxAmount;
	}

	/**
	 * @return the cfMeetingSubject
	 */
	public String getCfMeetingSubject() {
		return cfMeetingSubject;
	}

	/**
	 * @param cfMeetingSubject
	 *            the cfMeetingSubject to set
	 */
	public void setCfMeetingSubject(String cfMeetingSubject) {
		this.cfMeetingSubject = cfMeetingSubject;
	}

	/**
	 * @return the cfMeetingTime
	 */
	public Date getCfMeetingTime() {
		return cfMeetingTime;
	}

	/**
	 * @param cfMeetingTime
	 *            the cfMeetingTime to set
	 */
	public void setCfMeetingTime(Date cfMeetingTime) {
		this.cfMeetingTime = cfMeetingTime;
	}

	/**
	 * @return the cfMeetinoplegpId
	 */
	public String getCfMeetinoplegpId() {
		return cfMeetinoplegpId;
	}

	/**
	 * @param cfMeetinoplegpId
	 *            the cfMeetinoplegpId to set
	 */
	public void setCfMeetinoplegpId(String cfMeetinoplegpId) {
		this.cfMeetinoplegpId = cfMeetinoplegpId;
	}

	/**
	 * @return the cfMeetingResult
	 */
	public String getCfMeetingResult() {
		return cfMeetingResult;
	}

	/**
	 * @param cfMeetingResult
	 *            the cfMeetingResult to set
	 */
	public void setCfMeetingResult(String cfMeetingResult) {
		this.cfMeetingResult = cfMeetingResult;
	}

	/**
	 * @return the cfBudgetingAmount
	 */
	public String getCfBudgetingAmount() {
		return FormatUtil.formatDouble("###,###,###,###.00", cfBudgetingAmount);
	}

	/**
	 * @param cfBudgetingAmount
	 *            the cfBudgetingAmount to set
	 */
	public void setCfBudgetingAmount(String cfBudgetingAmount) {
		this.cfBudgetingAmount = cfBudgetingAmount;
	}

	/**
	 * @return the cfDeviation
	 */
	public String getCfDeviation() {
		return cfDeviation;
	}

	/**
	 * @param cfDeviation
	 *            the cfDeviation to set
	 */
	public void setCfDeviation(String cfDeviation) {
		this.cfDeviation = cfDeviation;
	}

	/**
	 * @return the cfAcceptWithHold
	 */
	public String getCfAcceptWithHold() {
		return cfAcceptWithHold;
	}

	/**
	 * @param cfAcceptWithHold
	 *            the cfAcceptWithHold to set
	 */
	public void setCfAcceptWithHold(String cfAcceptWithHold) {
		this.cfAcceptWithHold = cfAcceptWithHold;
	}

	/**
	 * @return the cfAcceptPoints
	 */
	public String getCfAcceptPoints() {
		return cfAcceptPoints;
	}

	/**
	 * @param cfAcceptPoints
	 *            the cfAcceptPoints to set
	 */
	public void setCfAcceptPoints(String cfAcceptPoints) {
		this.cfAcceptPoints = cfAcceptPoints;
	}

	/**
	 * @return the cfDeviateReason
	 */
	public String getCfDeviateReason() {
		return cfDeviateReason;
	}

	/**
	 * @param cfDeviateReason
	 *            the cfDeviateReason to set
	 */
	public void setCfDeviateReason(String cfDeviateReason) {
		this.cfDeviateReason = cfDeviateReason;
	}

	/**
	 * @return the cfAuditDepartmenti
	 */
	public String getCfAuditDepartmenti() {
		return cfAuditDepartmenti;
	}

	/**
	 * @param cfAuditDepartmenti
	 *            the cfAuditDepartmenti to set
	 */
	public void setCfAuditDepartmenti(String cfAuditDepartmenti) {
		this.cfAuditDepartmenti = cfAuditDepartmenti;
	}

	/**
	 * @return the cfAuditUnit
	 */
	public String getCfAuditUnit() {
		return cfAuditUnit;
	}

	/**
	 * @param cfAuditUnit
	 *            the cfAuditUnit to set
	 */
	public void setCfAuditUnit(String cfAuditUnit) {
		this.cfAuditUnit = cfAuditUnit;
	}

	/**
	 * @return the cfAuditFind
	 */
	public String getCfAuditFind() {
		return cfAuditFind;
	}

	/**
	 * @param cfAuditFind
	 *            the cfAuditFind to set
	 */
	public void setCfAuditFind(String cfAuditFind) {
		this.cfAuditFind = cfAuditFind;
	}

	/**
	 * @return the cfAuditResults
	 */
	public String getCfAuditResults() {
		return cfAuditResults;
	}

	/**
	 * @param cfAuditResults
	 *            the cfAuditResults to set
	 */
	public void setCfAuditResults(String cfAuditResults) {
		this.cfAuditResults = cfAuditResults;
	}

	/**
	 * @return the cfBudgetAmountTax
	 */
	public String getCfBudgetAmountTax() {
		return FormatUtil.formatDouble("###,###,###,###.00", cfBudgetAmountTax);
	}

	/**
	 * @param cfBudgetAmountTax
	 *            the cfBudgetAmountTax to set
	 */
	public void setCfBudgetAmountTax(String cfBudgetAmountTax) {
		this.cfBudgetAmountTax = cfBudgetAmountTax;
	}

	/**
	 * @return the cfState
	 */
	public String getCfState() {
		return cfState;
	}

	/**
	 * @param cfState
	 *            the cfState to set
	 */
	public void setCfState(String cfState) {
		this.cfState = cfState;
	}

	/**
	 * @return the cfSupplierId
	 */
	public String getCfSupplierId() {
		return cfSupplierId;
	}

	/**
	 * @param cfSupplierId
	 *            the cfSupplierId to set
	 */
	public void setCfSupplierId(String cfSupplierId) {
		this.cfSupplierId = cfSupplierId;
	}

	/**
	 * @return the cfPayAmount
	 */
	public String getCfPayAmount() {
		return FormatUtil.formatDouble("###,###,###,###.00", cfPayAmount);
	}

	/**
	 * @param cfPayAmount
	 *            the cfPayAmount to set
	 */
	public void setCfPayAmount(String cfPayAmount) {
		this.cfPayAmount = cfPayAmount;
	}

	/**
	 * @return the cfGuaranteeAmount
	 */
	public String getCfGuaranteeAmount() {
		return FormatUtil.formatDouble("###,###,###,###.00", cfGuaranteeAmount);
	}

	/**
	 * @param cfGuaranteeAmount
	 *            the cfGuaranteeAmount to set
	 */
	public void setCfGuaranteeAmount(String cfGuaranteeAmount) {
		this.cfGuaranteeAmount = cfGuaranteeAmount;
	}

	/**
	 * @return the cfSubsidiaryId
	 */
	public String getCfSubsidiaryId() {
		return cfSubsidiaryId;
	}

	/**
	 * @param cfSubsidiaryId
	 *            the cfSubsidiaryId to set
	 */
	public void setCfSubsidiaryId(String cfSubsidiaryId) {
		this.cfSubsidiaryId = cfSubsidiaryId;
	}

	/**
	 * @return the cfBudgetTime
	 */
	public Date getCfBudgetTime() {
		return cfBudgetTime;
	}

	/**
	 * @param cfBudgetTime
	 *            the cfBudgetTime to set
	 */
	public void setCfBudgetTime(Date cfBudgetTime) {
		this.cfBudgetTime = cfBudgetTime;
	}

	/**
	 * @return the cfCreateorGunitId
	 */
	public String getCfCreateorGunitId() {
		return cfCreateorGunitId;
	}

	/**
	 * @param cfCreateorGunitId
	 *            the cfCreateorGunitId to set
	 */
	public void setCfCreateorGunitId(String cfCreateorGunitId) {
		this.cfCreateorGunitId = cfCreateorGunitId;
	}

	/**
	 * @return the cfAuditTime
	 */
	public Date getCfAuditTime() {
		return cfAuditTime;
	}

	/**
	 * @param cfAuditTime
	 *            the cfAuditTime to set
	 */
	public void setCfAuditTime(Date cfAuditTime) {
		this.cfAuditTime = cfAuditTime;
	}

	/**
	 * @return the cfProjectStatus
	 */
	public String getCfProjectStatus() {
		return cfProjectStatus;
	}

	/**
	 * @param cfProjectStatus
	 *            the cfProjectStatus to set
	 */
	public void setCfProjectStatus(String cfProjectStatus) {
		this.cfProjectStatus = cfProjectStatus;
	}

	/**
	 * @return the fCompanyId
	 */
	public String getfCompanyId() {
		return fCompanyId;
	}

	/**
	 * @param fCompanyId
	 *            the fCompanyId to set
	 */
	public void setfCompanyId(String fCompanyId) {
		this.fCompanyId = fCompanyId;
	}

	/**
	 * @return the fPersonNumber
	 */
	public String getfPersonNumber() {
		return fPersonNumber;
	}

	/**
	 * @param fPersonNumber
	 *            the fPersonNumber to set
	 */
	public void setfPersonNumber(String fPersonNumber) {
		this.fPersonNumber = fPersonNumber;
	}

	/**
	 * @return the cfProjectNumberName
	 */
	public String getCfProjectNumberName() {
		return cfProjectNumberName;
	}

	/**
	 * @param cfProjectNumberName
	 *            the cfProjectNumberName to set
	 */
	public void setCfProjectNumberName(String cfProjectNumberName) {
		this.cfProjectNumberName = cfProjectNumberName;
	}

	/**
	 * @return the cfContractNumberName
	 */
	public String getCfContractNumberName() {
		return cfContractNumberName;
	}

	/**
	 * @param cfContractNumberName
	 *            the cfContractNumberName to set
	 */
	public void setCfContractNumberName(String cfContractNumberName) {
		this.cfContractNumberName = cfContractNumberName;
	}

	/**
	 * @return the cfMeetinOplegPName
	 */
	public String getCfMeetinOplegPName() {
		return cfMeetinOplegPName;
	}

	/**
	 * @param cfMeetinOplegPName
	 *            the cfMeetinOplegPName to set
	 */
	public void setCfMeetinOplegPName(String cfMeetinOplegPName) {
		this.cfMeetinOplegPName = cfMeetinOplegPName;
	}

	/**
	 * @return the cfAuditDepartmentName
	 */
	public String getCfAuditDepartmentName() {
		return cfAuditDepartmentName;
	}

	/**
	 * @param cfAuditDepartmentName
	 *            the cfAuditDepartmentName to set
	 */
	public void setCfAuditDepartmentName(String cfAuditDepartmentName) {
		this.cfAuditDepartmentName = cfAuditDepartmentName;
	}

	/**
	 * @return the cfSupplierName
	 */
	public String getCfSupplierName() {
		return cfSupplierName;
	}

	/**
	 * @param cfSupplierName
	 *            the cfSupplierName to set
	 */
	public void setCfSupplierName(String cfSupplierName) {
		this.cfSupplierName = cfSupplierName;
	}

	/**
	 * @return the cfCreateOrgUnitName
	 */
	public String getCfCreateOrgUnitName() {
		return cfCreateOrgUnitName;
	}

	/**
	 * @param cfCreateOrgUnitName
	 *            the cfCreateOrgUnitName to set
	 */
	public void setCfCreateOrgUnitName(String cfCreateOrgUnitName) {
		this.cfCreateOrgUnitName = cfCreateOrgUnitName;
	}

	/**
	 * @return the fCompanyName
	 */
	public String getfCompanyName() {
		return fCompanyName;
	}

	/**
	 * @param fCompanyName
	 *            the fCompanyName to set
	 */
	public void setfCompanyName(String fCompanyName) {
		this.fCompanyName = fCompanyName;
	}

	/**
	 * @return the cfSubsidiaryName
	 */
	public String getCfSubsidiaryName() {
		return cfSubsidiaryName;
	}

	/**
	 * @param cfSubsidiaryName
	 *            the cfSubsidiaryName to set
	 */
	public void setCfSubsidiaryName(String cfSubsidiaryName) {
		this.cfSubsidiaryName = cfSubsidiaryName;
	}

	/**
	 * @return the fProjectModel
	 */
	public String getfProjectModel() {
		return fProjectModel;
	}

	/**
	 * @param fProjectModel the fProjectModel to set
	 */
	public void setfProjectModel(String fProjectModel) {
		this.fProjectModel = fProjectModel;
	}

	/**
	 * @return the fCreatorName
	 */
	public String getfCreatorName() {
		return fCreatorName;
	}

	/**
	 * @param fCreatorName the fCreatorName to set
	 */
	public void setfCreatorName(String fCreatorName) {
		this.fCreatorName = fCreatorName;
	}

}
