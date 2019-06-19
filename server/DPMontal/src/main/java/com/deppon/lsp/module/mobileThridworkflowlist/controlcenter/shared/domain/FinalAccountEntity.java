/**   
 * @Title: finalAccountEntity.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 徐丁钉   
 * @date 2013-12-11 下午5:49:53  
 */
package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.util.Date;

/**
 * @ClassName: finalAccountEntity
 * @Description: 决算申请单实体；
 * @author 徐丁钉
 * @date 2013-12-11 下午5:49:53
 * 
 */
public class FinalAccountEntity {

	private String fCreatorId; // 创建者
	private Date fCreateTime; // 创建时间
	private String fLastUpdateUserId; // 最后修改者
	private Date fLastUpdateTime; // 最后修改时间
	private String fControlUnitId; // 控制单元
	private String fNumber; // 单据状态
	private Date fBizdate; // 业务日期
	private String fHandlerId; // 经手人
	private String fDescription; // 参考信息
	private String fHasEffected; // 是否曾经生效
	private String fAuditorId; // 审核人
	private String fSourceBillId; // 原始单据编号
	private String fSourceFunction; // 来源功能
	private String fid;
	private String fFivouchered; // 是否生产凭证
	private String cfProjectNumberId; // 项目编号
	private String cfProjectName; // 项目名称
	private Date cfStartTime; // 项目开始时间
	private Date cfStartDate; // 项目竣工时间
	private String cfSupplierId; // 供应商
	private String cfApplyAmount; // 决算金额
	private Date cfApplyTime; // 决算时间
	private String cfState; // 单据状态
	private Date cfAuditTime; // 审核日期
	private String fPromanagerId; // 项目经理
	private String fPersonnelId; // 决算申请人
	private String fCreatorgId; // 创建部门
	private String cfSupplierName;//
	private String fPromanagerName;
	private String fPersonnelName;
	private String fCreatorgName;
	private String cfProjectNumberName;

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
	 * @return the fLastUpdateUserId
	 */
	public String getfLastUpdateUserId() {
		return fLastUpdateUserId;
	}

	/**
	 * @param fLastUpdateUserId
	 *            the fLastUpdateUserId to set
	 */
	public void setfLastUpdateUserId(String fLastUpdateUserId) {
		this.fLastUpdateUserId = fLastUpdateUserId;
	}

	/**
	 * @return the fLastUpdateTime
	 */
	public Date getfLastUpdateTime() {
		return fLastUpdateTime;
	}

	/**
	 * @param fLastUpdateTime
	 *            the fLastUpdateTime to set
	 */
	public void setfLastUpdateTime(Date fLastUpdateTime) {
		this.fLastUpdateTime = fLastUpdateTime;
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
	public Date getfBizdate() {
		return fBizdate;
	}

	/**
	 * @param fBizdate
	 *            the fBizdate to set
	 */
	public void setfBizdate(Date fBizdate) {
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
	 * @return the fHasEffected
	 */
	public String getfHasEffected() {
		return fHasEffected;
	}

	/**
	 * @param fHasEffected
	 *            the fHasEffected to set
	 */
	public void setfHasEffected(String fHasEffected) {
		this.fHasEffected = fHasEffected;
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
	 * @return the cfStartDate
	 */
	public Date getCfStartDate() {
		return cfStartDate;
	}

	/**
	 * @param cfStartDate
	 *            the cfStartDate to set
	 */
	public void setCfStartDate(Date cfStartDate) {
		this.cfStartDate = cfStartDate;
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
	 * @return the cfApplyAmount
	 */
	public String getCfApplyAmount() {
		return cfApplyAmount;
	}

	/**
	 * @param cfApplyAmount
	 *            the cfApplyAmount to set
	 */
	public void setCfApplyAmount(String cfApplyAmount) {
		this.cfApplyAmount = cfApplyAmount;
	}

	/**
	 * @return the cfApplyTime
	 */
	public Date getCfApplyTime() {
		return cfApplyTime;
	}

	/**
	 * @param cfApplyTime
	 *            the cfApplyTime to set
	 */
	public void setCfApplyTime(Date cfApplyTime) {
		this.cfApplyTime = cfApplyTime;
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
	 * @return the fPromanagerId
	 */
	public String getfPromanagerId() {
		return fPromanagerId;
	}

	/**
	 * @param fPromanagerId
	 *            the fPromanagerId to set
	 */
	public void setfPromanagerId(String fPromanagerId) {
		this.fPromanagerId = fPromanagerId;
	}

	/**
	 * @return the fPersonnelId
	 */
	public String getfPersonnelId() {
		return fPersonnelId;
	}

	/**
	 * @param fPersonnelId
	 *            the fPersonnelId to set
	 */
	public void setfPersonnelId(String fPersonnelId) {
		this.fPersonnelId = fPersonnelId;
	}

	/**
	 * @return the fCreatorgId
	 */
	public String getfCreatorgId() {
		return fCreatorgId;
	}

	/**
	 * @param fCreatorgId
	 *            the fCreatorgId to set
	 */
	public void setfCreatorgId(String fCreatorgId) {
		this.fCreatorgId = fCreatorgId;
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
	 * @return the fPromanagerName
	 */
	public String getfPromanagerName() {
		return fPromanagerName;
	}

	/**
	 * @param fPromanagerName
	 *            the fPromanagerName to set
	 */
	public void setfPromanagerName(String fPromanagerName) {
		this.fPromanagerName = fPromanagerName;
	}

	/**
	 * @return the fPersonnelName
	 */
	public String getfPersonnelName() {
		return fPersonnelName;
	}

	/**
	 * @param fPersonnelName
	 *            the fPersonnelName to set
	 */
	public void setfPersonnelName(String fPersonnelName) {
		this.fPersonnelName = fPersonnelName;
	}

	/**
	 * @return the fCreatorgName
	 */
	public String getfCreatorgName() {
		return fCreatorgName;
	}

	/**
	 * @param fCreatorgName
	 *            the fCreatorgName to set
	 */
	public void setfCreatorgName(String fCreatorgName) {
		this.fCreatorgName = fCreatorgName;
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

}
