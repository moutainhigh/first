package com.deppon.dpm.module.wfs.shared.domain.acms;

import java.io.Serializable;

public class AcmsApproveSubParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long workItemId;
	private long processinstid;
	private String approveOpinion;
	private String isAgree;
	private String activityDefId;
	/**
	 * @return the workItemId
	 */
	public long getWorkItemId() {
		return workItemId;
	}
	/**
	 * @param workItemId the workItemId to set
	 */
	public void setWorkItemId(long workItemId) {
		this.workItemId = workItemId;
	}
	/**
	 * @return the processinstid
	 */
	public long getProcessinstid() {
		return processinstid;
	}
	/**
	 * @param processinstid the processinstid to set
	 */
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
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
	 * @return the isAgree
	 */
	public String getIsAgree() {
		return isAgree;
	}
	/**
	 * @param isAgree the isAgree to set
	 */
	public void setIsAgree(String isAgree) {
		this.isAgree = isAgree;
	}
	/**
	 * @return the activityDefId
	 */
	public String getActivityDefId() {
		return activityDefId;
	}
	/**
	 * @param activityDefId the activityDefId to set
	 */
	public void setActivityDefId(String activityDefId) {
		this.activityDefId = activityDefId;
	}
}
