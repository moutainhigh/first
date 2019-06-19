package com.deppon.dpm.module.wfs.shared.domain.wdgh;

import java.io.Serializable;

public class WdghEntity implements Serializable {
	
	/****/
	private static final long serialVersionUID = 1L;
	/*** 客户唯一性编号 */
	private String busiNo;
	
	/*** 流程定义名称 */
	private String processDefName;
    
    /*** 工作流号 */
    private String processInstId;
    
    /*** 审批人工号 */
    private String approverCode;
    
    /*** 审批人名称 */
    private String approverName;
    
	/*** 单据编号 */
    private String workItemId;
	
	/*** 审批决策 0:同意 1:不同意*/
    private String approveOperateType;
		
	/*** 意见 */
	private String approveOpinion;
	
	private String activtyId;
	
	private String activtyCurrentId;
	private TaxWdghEntity obj;
	/**
	 * @return the busiNo
	 */
	public String getBusiNo() {
		return busiNo;
	}
	/**
	 * @param busiNo the busiNo to set
	 */
	public void setBusiNo(String busiNo) {
		this.busiNo = busiNo;
	}
	/**
	 * @return the processDefName
	 */
	public String getProcessDefName() {
		return processDefName;
	}
	/**
	 * @param processDefName the processDefName to set
	 */
	public void setProcessDefName(String processDefName) {
		this.processDefName = processDefName;
	}
	/**
	 * @return the processInstId
	 */
	public String getProcessInstId() {
		return processInstId;
	}
	/**
	 * @param processInstId the processInstId to set
	 */
	public void setProcessInstId(String processInstId) {
		this.processInstId = processInstId;
	}
	/**
	 * @return the approverCode
	 */
	public String getApproverCode() {
		return approverCode;
	}
	/**
	 * @param approverCode the approverCode to set
	 */
	public void setApproverCode(String approverCode) {
		this.approverCode = approverCode;
	}
	/**
	 * @return the approverName
	 */
	public String getApproverName() {
		return approverName;
	}
	/**
	 * @param approverName the approverName to set
	 */
	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}
	/**
	 * @return the workItemId
	 */
	public String getWorkItemId() {
		return workItemId;
	}
	/**
	 * @param workItemId the workItemId to set
	 */
	public void setWorkItemId(String workItemId) {
		this.workItemId = workItemId;
	}
	/**
	 * @return the approveOperateType
	 */
	public String getApproveOperateType() {
		return approveOperateType;
	}
	/**
	 * @param approveOperateType the approveOperateType to set
	 */
	public void setApproveOperateType(String approveOperateType) {
		this.approveOperateType = approveOperateType;
	}
	/**
	 * @return the approveOpinion
	 */
	public String getApproveOpinion() {
		return approveOpinion;
	}
	/**
	 * @param approveOpinion the approveOpinion to set
	 */
	public void setApproveOpinion(String approveOpinion) {
		this.approveOpinion = approveOpinion;
	}
	/**
	 * @return the activtyId
	 */
	public String getActivtyId() {
		return activtyId;
	}
	/**
	 * @param activtyId the activtyId to set
	 */
	public void setActivtyId(String activtyId) {
		this.activtyId = activtyId;
	}
	/**
	 * @return the activtyCurrentId
	 */
	public String getActivtyCurrentId() {
		return activtyCurrentId;
	}
	/**
	 * @param activtyCurrentId the activtyCurrentId to set
	 */
	public void setActivtyCurrentId(String activtyCurrentId) {
		this.activtyCurrentId = activtyCurrentId;
	}
	/**
	 * @return the obj
	 */
	public TaxWdghEntity getObj() {
		return obj;
	}
	/**
	 * @param obj the obj to set
	 */
	public void setObj(TaxWdghEntity obj) {
		this.obj = obj;
	}
}
