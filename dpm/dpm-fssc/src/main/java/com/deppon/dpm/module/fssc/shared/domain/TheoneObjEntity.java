package com.deppon.dpm.module.fssc.shared.domain;

import java.util.Date;

/**
 * 用来存储数据的实体类
 * @author JFeng
 */
public class TheoneObjEntity {

	/**
	 * 单据编号
	 */
	private String claimNo;
	/**
	 * 明细行id
	 */
	private String claimLineId;
	/**
	 * 订单编号
	 */
	private String orderNo;
	/**
	 * 订单状态
	 */
	private String orderState;
	
	/**
	 * 开始 时间
	 */
	private Date bizOccurStartDate;
	
	/**
	 * 结束时间
	 */
	private Date bizOccurEndDate;
	/**
	 * 目的地
	 */
	private String destination;
	
	/**
	 * 审批状态
	 */
	private String auditState;
	
	/**
	 * 起草时间
	 */
	private Date applyDate;
	
	/**
	 * 业务开始时间
	 */
	private String startDate;
	/**
	 * 业务结束时间
	 */
	private String endDate;
	
	/**
	 * @return
	 */
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return 审批状态
	 */
	public String getAuditState() {
		return auditState;
	}
	/**
	 * @param auditState 审批状态
	 */
	public void setAuditState(String auditState) {
		this.auditState = auditState;
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
	 * @return 单据编号
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * @param claimNo 单据编号
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	/**
	 * @return  明细行id
	 */
	public String getClaimLineId() {
		return claimLineId;
	}
	/**
	 * @param claimLineId  明细行id
	 */
	public void setClaimLineId(String claimLineId) {
		this.claimLineId = claimLineId;
	}
	/**
	 * @return 订单编号
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * @param orderNo 订单编号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * @return 订单状态
	 */
	public String getOrderState() {
		return orderState;
	}
	/**
	 * @param orderState 订单状态
	 */
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	/**
	 * @return 开始时间
	 */
	public Date getBizOccurStartDate() {
		return bizOccurStartDate;
	}
	/**
	 * @param bizOccurStartDate 结束时间
	 */
	public void setBizOccurStartDate(Date bizOccurStartDate) {
		this.bizOccurStartDate = bizOccurStartDate;
	}
	public Date getBizOccurEndDate() {
		return bizOccurEndDate;
	}
	public void setBizOccurEndDate(Date bizOccurEndDate) {
		this.bizOccurEndDate = bizOccurEndDate;
	}
	/**
	 * @return 目的地
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @param destination 目的地
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
}
