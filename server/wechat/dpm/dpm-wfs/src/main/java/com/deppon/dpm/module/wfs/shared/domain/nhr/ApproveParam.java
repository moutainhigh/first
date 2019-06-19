package com.deppon.dpm.module.wfs.shared.domain.nhr;

import java.io.Serializable;

public class ApproveParam implements Serializable {
	private static final long serialVersionUID = 214030343632678379L;
	// 审批决策（同意 不同意）
	private String decision;
	// 审批意见
	private String opinion;
	// 流程实例id-------- wfProcInstId
	private String activityinstid;
	// 工作项id ---------wfWorkitemId
	private String workitemid;
	// 当前活动定义ID --------activityDefId
	private String wfState;
	// 流水业务号 ------DLSPZCG-20130920-03461
	private String busino;
	// 审批人工号
	private String dealEmpCode;
	// 审批人名称
	private String dealEmpName;
	private String workFlowType;
	private String spareFieldOne;//领导打分
	private String  spareFieldThree;//转正日期
	private String spareFieldTwo;//起草人
	// 工作交接人
	/*private TransferEmpBean transferEmpBean;
	
	public TransferEmpBean getTransferEmpBean() {
		return transferEmpBean;
	}

	public void setTransferEmpBean(TransferEmpBean transferEmpBean) {
		this.transferEmpBean = transferEmpBean;
	}*/

	/**
	 * @return the spareFieldThree
	 */
	public String getSpareFieldThree() {
		return spareFieldThree;
	}

	/**
	 * @param spareFieldThree the spareFieldThree to set
	 */
	public void setSpareFieldThree(String spareFieldThree) {
		this.spareFieldThree = spareFieldThree;
	}

	/**
	 * @return the spareFieldTwo
	 */
	public String getSpareFieldTwo() {
		return spareFieldTwo;
	}

	/**
	 * @param spareFieldTwo the spareFieldTwo to set
	 */
	public void setSpareFieldTwo(String spareFieldTwo) {
		this.spareFieldTwo = spareFieldTwo;
	}

	/**
	 * @return the date
	 */
	

	/**
	 * @return the spareFieldOne
	 */
	public String getSpareFieldOne() {
		return spareFieldOne;
	}

	/**
	 * @param spareFieldOne the spareFieldOne to set
	 */
	public void setSpareFieldOne(String spareFieldOne) {
		this.spareFieldOne = spareFieldOne;
	}

	/**
	 * @return the decision
	 */
	public String getDecision() {
		return decision;
	}

	/**
	 * @param decision the decision to set
	 */
	public void setDecision(String decision) {
		this.decision = decision;
	}

	/**
	 * @return the opinion
	 */
	public String getOpinion() {
		return opinion;
	}

	/**
	 * @param opinion the opinion to set
	 */
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	/**
	 * @return the activityinstid
	 */
	public String getActivityinstid() {
		return activityinstid;
	}

	/**
	 * @param activityinstid the activityinstid to set
	 */
	public void setActivityinstid(String activityinstid) {
		this.activityinstid = activityinstid;
	}

	/**
	 * @return the workitemid
	 */
	public String getWorkitemid() {
		return workitemid;
	}

	/**
	 * @param workitemid the workitemid to set
	 */
	public void setWorkitemid(String workitemid) {
		this.workitemid = workitemid;
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
	 * @return the dealEmpCode
	 */
	public String getDealEmpCode() {
		return dealEmpCode;
	}

	/**
	 * @param dealEmpCode the dealEmpCode to set
	 */
	public void setDealEmpCode(String dealEmpCode) {
		this.dealEmpCode = dealEmpCode;
	}

	/**
	 * @return the dealEmpName
	 */
	public String getDealEmpName() {
		return dealEmpName;
	}

	/**
	 * @param dealEmpName the dealEmpName to set
	 */
	public void setDealEmpName(String dealEmpName) {
		this.dealEmpName = dealEmpName;
	}

	/**
	 * @return the workFlowType
	 */
	public String getWorkFlowType() {
		return workFlowType;
	}

	/**
	 * @param workFlowType the workFlowType to set
	 */
	public void setWorkFlowType(String workFlowType) {
		this.workFlowType = workFlowType;
	}

	

}
