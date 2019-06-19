package com.deppon.dpm.module.fssc.shared.domain;

import java.util.Date;

/**
 * 酒店订单信息实体类
 * @author JFeng
 */
public class HotelOrderInfoEntity {
	
	/**
	 * 对应主表的明细行id
	 */
	private String claimLineId;
	
	/**
	 * 酒店订单编号
	 */
	private String orderNo;
	
	/**
	 * 酒店订单状态
	 */
	private int orderState;
	
	/**
	 * 费用承担部门编码
	 */
	private String costCenterNo;
	
	/**
	 * 费用承担部门
	 */
	private String costCenterName;
	
	/**
	 * 业务发生时间
	 */
	private Date bizOccurStartDate;
	
	/**
	 * 业务结束时间
	 */
	private Date bizOccurEndDate;


	/**
	 * 前台接收开始时间
	 */
	private String bizStartTime;
	
	/**
	 * 结束时间
	 */
	private String bizEndTime;

	/**
	 * @return 前台接收开始时间
	 */
	public String getBizStartTime() {
		return bizStartTime;
	}

	/**
	 * @param bizStartTime 前台接收开始时间
	 */
	public void setBizStartTime(String bizStartTime) {
		this.bizStartTime = bizStartTime;
	}

	/**
	 * @return 结束时间
	 */
	public String getBizEndTime() {
		return bizEndTime;
	}

	/**
	 * @param bizEndTime 结束时间
	 */
	public void setBizEndTime(String bizEndTime) {
		this.bizEndTime = bizEndTime;
	}

	/**
	 * 同行人最高等级
	 */
	private int highestLev;
	
	/**
	 * 出差申请人
	 */
	private String empName;
	
	/**
	 * 出差申请人工号
	 */
	private String empNo;
	
	/**
	 * 出差人等级
	 */
	private int empLve;
	
	/**
	 * 预计金额
	 */
	private float planAmount;
	
	/**
	 * 入住城市
	 */
	private String stayCity;
	
	/**
	 * 费用标准
	 */
	private String costStandard;
	
	/**
	 * 入住天数
	 */
	private String stayDays;

	/**
	 * @return 对应主表的明细行id
	 */
	public String getClaimLineId() {
		return claimLineId;
	}

	/**
	 * @param claimLineId 对应主表的明细行id
	 */
	public void setClaimLineId(String claimLineId) {
		this.claimLineId = claimLineId;
	}

	/**
	 * @return 酒店订单编号
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * @param orderNo 酒店订单编号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * @return 酒店订单状态
	 */
	public int getOrderState() {
		return orderState;
	}

	/**
	 * @param orderState 酒店订单状态
	 */
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	/**
	 * @return 费用承担部门编码
	 */
	public String getCostCenterNo() {
		return costCenterNo;
	}

	/**
	 * @param costCenterNo 费用承担部门编码
	 */
	public void setCostCenterNo(String costCenterNo) {
		this.costCenterNo = costCenterNo;
	}

	/**
	 * @return 费用承担部门
	 */
	public String getCostCenterName() {
		return costCenterName;
	}

	/**
	 * @param costCenterName 费用承担部门
	 */
	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	/**
	 * @return bizOccurStartDate
	 */
	public Date getBizOccurStartDate() {
		return bizOccurStartDate;
	}

	/**
	 * @param bizOccurStartDate bizOccurStartDate
	 */
	public void setBizOccurStartDate(Date bizOccurStartDate) {
		this.bizOccurStartDate = bizOccurStartDate;
	}

	/**
	 * @return bizOccurEndDate
	 */
	public Date getBizOccurEndDate() {
		return bizOccurEndDate;
	}

	/**
	 * @param bizOccurEndDate bizOccurEndDate
	 */
	public void setBizOccurEndDate(Date bizOccurEndDate) {
		this.bizOccurEndDate = bizOccurEndDate;
	}

	public int getHighestLev() {
		return highestLev;
	}

	public void setHighestLev(int highestLev) {
		this.highestLev = highestLev;
	}

	/**
	 * @return 出差申请人
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName 出差申请人
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return 工号
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo 工号
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return 出差人等级
	 */
	public int getEmpLve() {
		return empLve;
	}

	/**
	 * @param empLve 出差人等级
	 */
	public void setEmpLve(int empLve) {
		this.empLve = empLve;
	}

	/**
	 * @return 预计金额
	 */
	public float getPlanAmount() {
		return planAmount;
	}

	/**
	 * @param planAmount 预计金额
	 */
	public void setPlanAmount(float planAmount) {
		this.planAmount = planAmount;
	}

	/**
	 * @return 入住城市
	 */
	public String getStayCity() {
		return stayCity;
	}

	/**
	 * @param stayCity 入住城市
	 */
	public void setStayCity(String stayCity) {
		this.stayCity = stayCity;
	}

	/**
	 * @return 费用标准
	 */
	public String getCostStandard() {
		return costStandard;
	}

	/**
	 * @param costStandard 费用标准
	 */
	public void setCostStandard(String costStandard) {
		this.costStandard = costStandard;
	}

	/**
	 * @return 入住天数
	 */
	public String getStayDays() {
		return stayDays;
	}

	/**
	 * @param stayDays 入住天数
	 */
	public void setStayDays(String stayDays) {
		this.stayDays = stayDays;
	}

}


