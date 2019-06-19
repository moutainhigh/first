
package com.deppon.dpm.module.wfs.shared.domain.dppm;

import java.io.Serializable;
/**
* 审批实体
* @title: ApprovelEntity 
* @author： lihai
* @date： 2014-7-3 下午04:09:43
 */
public class ApprovelEntity implements Serializable{

	private static final long serialVersionUID = 2446823110582952780L;
	
	//工作项ID
	private long workItemId;
	//流程实例ID
	private long processinstid;
	//活动定义ID
	private String activityDefId;
	//审批意见
	private String approveOpinion;
	//审批结果
	private String isAgree;
	//活动实例ID
	private String activityinstid;
	
	private String busino;
	
	public ApprovelEntity() {
	}

	
	
	/**
	 * @return  the busino
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
	 * @return workItemId
	 */
	public long getWorkItemId() {
		return workItemId;
	}

	/**
	 * @param workItemId 要设置的 workItemId
	 */
	public void setWorkItemId(long workItemId) {
		this.workItemId = workItemId;
	}

	/**
	 * @return processInstId
	 */
	public long getProcessinstid() {
		return processinstid;
	}

	/**
	 * @param processInstId 要设置的 processInstId
	 */
	public void setProcessinstid(long processinstid) {
		this.processinstid = processinstid;
	}

	/**
	 * @return activityDefId
	 */
	public String getActivityDefId() {
		return activityDefId;
	}

	/**
	 * @param activityDefId 要设置的 activityDefId
	 */
	public void setActivityDefId(String activityDefId) {
		this.activityDefId = activityDefId;
	}

	/**
	 * @return approveOpinion
	 */
	public String getApproveOpinion() {
		return approveOpinion;
	}

	/**
	 * @param approveOpinion 要设置的 approveOpinion
	 */
	public void setApproveOpinion(String approveOpinion) {
		this.approveOpinion = approveOpinion;
	}

	/**
	 * @return isAgree
	 */
	public String getIsAgree() {
		return isAgree;
	}

	/**
	 * @param isAgree 要设置的 isAgree
	 */
	public void setIsAgree(String isAgree) {
		this.isAgree = isAgree;
	}

}
