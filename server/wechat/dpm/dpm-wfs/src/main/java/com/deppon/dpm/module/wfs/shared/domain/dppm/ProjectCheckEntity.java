package com.deppon.dpm.module.wfs.shared.domain.dppm;

import java.sql.Date;

import com.deppon.foss.framework.entity.BaseEntity;

public class ProjectCheckEntity extends BaseEntity {

	private int projectCode;
	// 审批处理人工号
	private String checkHandler;
	// 审批意见
	private String checkSuggestion;
	// 审批结果0为同意 ，1为不同意
	private int checkResult;
	// 工作流号
	private String wfsId;
	// 工作流节点id
	private String wfsActivityDefid;
	//
	private String wfsActivityInstID;
	// 工作项ID
	private String wfsWorkItemID;
	// 工作流是否结束0没有 1结束
	private int wfsIsOver;
	// 当前节点是否活动节点的状态标示
	private int checkStatus;
	// 审批时间
	private Date checkTime;
	private ApprovelEntity approvelEntity;

	/**
	 * @return the approvelEntity
	 */
	public ApprovelEntity getApprovelEntity() {
		return approvelEntity;
	}

	/**
	 * @param approvelEntity
	 *            the approvelEntity to set
	 */
	public void setApprovelEntity(ApprovelEntity approvelEntity) {
		this.approvelEntity = approvelEntity;
	}

	/**
	 * @return the checkTime
	 */
	public Date getCheckTime() {
		return checkTime;
	}

	/**
	 * @param checkTime
	 *            the checkTime to set
	 */
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	/**
	 * @return the projectCode
	 */
	public int getProjectCode() {
		return projectCode;
	}

	/**
	 * @param projectCode
	 *            the projectCode to set
	 */
	public void setProjectCode(int projectCode) {
		this.projectCode = projectCode;
	}

	/**
	 * @return the checkHandler
	 */
	public String getCheckHandler() {
		return checkHandler;
	}

	/**
	 * @param checkHandler
	 *            the checkHandler to set
	 */
	public void setCheckHandler(String checkHandler) {
		this.checkHandler = checkHandler;
	}

	/**
	 * @return the checkSuggestion
	 */
	public String getCheckSuggestion() {
		return checkSuggestion;
	}

	/**
	 * @param checkSuggestion
	 *            the checkSuggestion to set
	 */
	public void setCheckSuggestion(String checkSuggestion) {
		this.checkSuggestion = checkSuggestion;
	}

	/**
	 * @return the checkResult
	 */
	public int getCheckResult() {
		return checkResult;
	}

	/**
	 * @param checkResult
	 *            the checkResult to set
	 */
	public void setCheckResult(int checkResult) {
		this.checkResult = checkResult;
	}

	/**
	 * @return the wfsId
	 */
	public String getWfsId() {
		return wfsId;
	}

	/**
	 * @param wfsId
	 *            the wfsId to set
	 */
	public void setWfsId(String wfsId) {
		this.wfsId = wfsId;
	}

	/**
	 * @return the wfsActivityDefid
	 */
	public String getWfsActivityDefid() {
		return wfsActivityDefid;
	}

	/**
	 * @param wfsActivityDefid
	 *            the wfsActivityDefid to set
	 */
	public void setWfsActivityDefid(String wfsActivityDefid) {
		this.wfsActivityDefid = wfsActivityDefid;
	}

	/**
	 * @return the wfsActivityInstID
	 */
	public String getWfsActivityInstID() {
		return wfsActivityInstID;
	}

	/**
	 * @param wfsActivityInstID
	 *            the wfsActivityInstID to set
	 */
	public void setWfsActivityInstID(String wfsActivityInstID) {
		this.wfsActivityInstID = wfsActivityInstID;
	}

	/**
	 * @return the wfsWorkItemID
	 */
	public String getWfsWorkItemID() {
		return wfsWorkItemID;
	}

	/**
	 * @param wfsWorkItemID
	 *            the wfsWorkItemID to set
	 */
	public void setWfsWorkItemID(String wfsWorkItemID) {
		this.wfsWorkItemID = wfsWorkItemID;
	}

	/**
	 * @return the wfsIsOver
	 */
	public int getWfsIsOver() {
		return wfsIsOver;
	}

	/**
	 * @param wfsIsOver
	 *            the wfsIsOver to set
	 */
	public void setWfsIsOver(int wfsIsOver) {
		this.wfsIsOver = wfsIsOver;
	}

	/**
	 * @return the checkStatus
	 */
	public int getCheckStatus() {
		return checkStatus;
	}

	/**
	 * @param i
	 *            the checkStatus to set
	 */
	public void setCheckStatus(int i) {
		this.checkStatus = i;
	}

}
