package com.deppon.dpm.module.wfs.shared.domain.dlsp;

import java.io.Serializable;

public class Auditparameters implements Serializable {
	private static final long serialVersionUID = 214030343632678379L;
	// 审批决策（同意 不同意）
	private String decisionState;
	// 审批意见
	private String auditAdvise;
	// 流程实例id-------- wfProcInstId
	private long wfInstanceId;
	// 工作项id ---------wfWorkitemId
	private long wfWorkItemId;
	// 当前活动定义ID --------activityDefId
	private String wfState;
	// 流水业务号 ------DLSPZCG-20130920-03461
	private String docId;
	// 单据FID
	private String docNo;
	// 审批人工号
	private String empCode;
	// 审批人名称
	private String empName;
	private TaxDlspEntity obj;
	//是否有闲置资产
	private String fixPropertyEmployId;
	//转交人的工号
	protected String transferPersonCode;
	/**
	 * @return the fixPropertyEmployId
	 */
	public String getFixPropertyEmployId() {
		return fixPropertyEmployId;
	}

	/**
	 * @param fixPropertyEmployId the fixPropertyEmployId to set
	 */
	public void setFixPropertyEmployId(String fixPropertyEmployId) {
		this.fixPropertyEmployId = fixPropertyEmployId;
	}

	/**
	 * @return the transferPersonCode
	 */
	public String getTransferPersonCode() {
		return transferPersonCode;
	}

	/**
	 * @param transferPersonCode the transferPersonCode to set
	 */
	public void setTransferPersonCode(String transferPersonCode) {
		this.transferPersonCode = transferPersonCode;
	}

	/**
	 * @return the decisionState
	 */
	public String getDecisionState() {
		return decisionState;
	}

	/**
	 * @param decisionState the decisionState to set
	 */
	public void setDecisionState(String decisionState) {
		this.decisionState = decisionState;
	}

	/**
	 * @return the auditAdvise
	 */
	public String getAuditAdvise() {
		return auditAdvise;
	}

	/**
	 * @param auditAdvise the auditAdvise to set
	 */
	public void setAuditAdvise(String auditAdvise) {
		this.auditAdvise = auditAdvise;
	}

	/**
	 * @return the wfInstanceId
	 */
	public long getWfInstanceId() {
		return wfInstanceId;
	}

	/**
	 * @param wfInstanceId the wfInstanceId to set
	 */
	public void setWfInstanceId(long wfInstanceId) {
		this.wfInstanceId = wfInstanceId;
	}

	/**
	 * @return the wfWorkItemId
	 */
	public long getWfWorkItemId() {
		return wfWorkItemId;
	}

	/**
	 * @param wfWorkItemId the wfWorkItemId to set
	 */
	public void setWfWorkItemId(long wfWorkItemId) {
		this.wfWorkItemId = wfWorkItemId;
	}

	/**
	 * @return the wfState
	 */
	public String getWfState() {
		return wfState;
	}

	/**
	 * @param wfState the wfState to set
	 */
	public void setWfState(String wfState) {
		this.wfState = wfState;
	}

	/**
	 * @return the docId
	 */
	public String getDocId() {
		return docId;
	}

	/**
	 * @param docId the docId to set
	 */
	public void setDocId(String docId) {
		this.docId = docId;
	}

	/**
	 * @return the docNo
	 */
	public String getDocNo() {
		return docNo;
	}

	/**
	 * @param docNo the docNo to set
	 */
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	/**
	 * @return the empCode
	 */
	public String getEmpCode() {
		return empCode;
	}

	/**
	 * @param empCode the empCode to set
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the obj
	 */
	public TaxDlspEntity getObj() {
		return obj;
	}

	/**
	 * @param obj the obj to set
	 */
	public void setObj(TaxDlspEntity obj) {
		this.obj = obj;
	}
}
