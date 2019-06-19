package com.deppon.dpm.module.fssc.shared.domain;

import java.util.Date;
import java.util.List;

/**
 * 请求参数详情实体类
 * @author JFeng
 */
public class PriorApplicationEntity {
	
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
	 * @return 起草的String类型时间
	 */
	public String getApplyDateStr() {
		return applyDateStr;
	}

	/**
	 * @param applyDateStr 起草的String类型时间
	 */
	public void setApplyDateStr(String applyDateStr) {
		this.applyDateStr = applyDateStr;
	}

	/**
	 * @return 明细信息
	 */
	public List<DetailInfoEntity> getDetailInfoList() {
		return detailInfoList;
	}

	/**
	 * @param detailInfoList 明细信息
	 */
	public void setDetailInfoList(List<DetailInfoEntity> detailInfoList) {
		this.detailInfoList = detailInfoList;
	}


	/**
	 * @return 单据编号(工作流id)
	 */
	public String getClaimNo() {
		return claimNo;
	}

	/**
	 * @param claimNo 单据编号(工作流id)
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	/**
	 * @return 工作流审批状态
	 */
	public String getAuditState() {
		return auditState;
	}

	/**
	 * @param auditState 工作流审批状态
	 */
	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	/**
	 * @return 状态
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state 状态
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * @return 起草时间
	 */
	public Date getApplyDate() {
		return applyDate;
	}

	/**
	 * @param applyDate 起草时间
	 */
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	/**
	 * @return 申请人工号
	 */
	public String getApplyEmpNo() {
		return applyEmpNo;
	}

	/**
	 * @param applyEmpNo 申请人工号
	 */
	public void setApplyEmpNo(String applyEmpNo) {
		this.applyEmpNo = applyEmpNo;
	}

	/**
	 * @return 预计总费用
	 */
	public float getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost 预计总费用
	 */
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}
	
	
}
