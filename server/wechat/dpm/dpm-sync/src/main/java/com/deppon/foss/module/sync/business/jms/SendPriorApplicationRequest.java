package com.deppon.foss.module.sync.business.jms;

import java.util.Date;
import java.util.List;

public class SendPriorApplicationRequest {

	/**
	 * 单据编号(工作流id)
	 */
	private String claimNo;

	/**
	 * 工作流审批状态
	 */
	private String auditState;

	/**
	 * 状态
	 */
	private int state;

	/**
	 * 起草时间
	 */
	private Date applyDate;

	/**
	 * 起草的String类型时间
	 */
	private String applyDateStr;

	/**
	 * 申请人工号
	 */
	private String applyEmpNo;

	/**
	 * 预计总费用
	 */
	private float totalCost;

	/**
	 * 明细信息
	 */
	private List<DetailInfoEntity> detailInfoList;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getApplyDateStr() {
		return applyDateStr;
	}

	/**
	 * set
	 * 
	 * @param applyDateStr
	 */
	public void setApplyDateStr(String applyDateStr) {
		this.applyDateStr = applyDateStr;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public List<DetailInfoEntity> getDetailInfoList() {
		return detailInfoList;
	}

	/**
	 * set
	 * 
	 * @param detailInfoList
	 */
	public void setDetailInfoList(List<DetailInfoEntity> detailInfoList) {
		this.detailInfoList = detailInfoList;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getClaimNo() {
		return claimNo;
	}

	/**
	 * set
	 * 
	 * @param claimNo
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAuditState() {
		return auditState;
	}

	/**
	 * set
	 * 
	 * @param auditState
	 */
	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getState() {
		return state;
	}

	/**
	 * set
	 * 
	 * @param state
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getApplyDate() {
		return applyDate;
	}

	/**
	 * set
	 * 
	 * @param applyDate
	 */
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getApplyEmpNo() {
		return applyEmpNo;
	}

	/**
	 * set
	 * 
	 * @param applyEmpNo
	 */
	public void setApplyEmpNo(String applyEmpNo) {
		this.applyEmpNo = applyEmpNo;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public float getTotalCost() {
		return totalCost;
	}

	/**
	 * set
	 * 
	 * @param totalCost
	 */
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

}
