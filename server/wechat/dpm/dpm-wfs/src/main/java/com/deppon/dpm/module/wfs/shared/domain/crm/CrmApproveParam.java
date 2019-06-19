package com.deppon.dpm.module.wfs.shared.domain.crm;

import java.io.Serializable;
/**
 * crm审批接口参数
 * @author gcl
 */
public class CrmApproveParam implements Serializable {
	private static final long serialVersionUID = 214030343632678379L;
	// 审批决策（同意 不同意）
	private String approveOperateType;
	// 审批意见
	private String approveOpinion;
	// 流程实例id
	private String processInstId;
	// 工作项id ---------wfWorkitemId
	private String workItemId;
	// 工作流定义名称
	private String processDefName;
	// 流水业务号 
	private String busino;
	// 审批人工号
	private String approverCode;
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
	
}
