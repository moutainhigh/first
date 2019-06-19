package com.deppon.dpm.module.fssc.shared.domain;

import java.util.Date;

/**
 * 	航班订单信息实体类
 * @author JFeng
 */
public class FlightOrderInfoEntity {
	
	/**
	 * 对应主表的明细行id
	 */
	private String claimLineId;
	
	/**
	 * 航班订单号
	 */
	private String orderNo;
	
	/**
	 * 航班订单状态 
	 */
	private int orderState;
	
	/**
	 * 费用承担部门
	 */
	private String costCenterNo;
	
	/**
	 * 费用承担部门
	 */
	private String costCenterName;
	
	/**
	 * 业务发生日期
	 */
	private Date bizOccurStartDate;
	
	/**
	 * 前台接收开始时间
	 */
	private String bizStartTime;
	
	/**
	 * 结束时间
	 */
	private String bizEndTime;
	
	/**
	 * 业务结束日期
	 */
	private Date bizOccurEndDate;
	
	/**
	 * 同行人最高等级
	 */
	private int highestLev;
	
	/**
	 * 出差申请人姓名
	 */
	private String empName;
	
	/**
	 * 出差申请人工号
	 */
	private String empNo;
	
	/**
	 * 出差人级别
	 */
	private int empLve;
	
	/**
	 * 出差目的地
	 */
	private String destination;
	
	/**
	 * 预计金额
	 */
	private float planAmount;
	
	/**
	 * 出发城市
	 */
	private String startCity;
	
	/**
	 * 到达城市
	 */
	private String endCity;
	
	/**
	 * 折扣标准
	 */
	private String discountStandard;


	/**
	 * @return  对应主表的明细行id
	 */
	public String getClaimLineId() {
		return claimLineId;
	}

	/**
	 * @param claimLineId  对应主表的明细行id
	 */
	public void setClaimLineId(String claimLineId) {
		this.claimLineId = claimLineId;
	}

	/**
	 * @return 航班订单号
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * @param orderNo 航班订单号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * @return 航班订单状态 
	 */
	public int getOrderState() {
		return orderState;
	}

	/**
	 * @param orderState 航班订单状态 
	 */
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	/**
	 * @return 费用承担部门
	 */
	public String getCostCenterNo() {
		return costCenterNo;
	}

	/**
	 * @param costCenterNo 费用承担部门
	 */
	public void setCostCenterNo(String costCenterNo) {
		this.costCenterNo = costCenterNo;
	}

	public String getCostCenterName() {
		return costCenterName;
	}

	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	/**
	 * @return 业务发生日期
	 */
	public Date getBizOccurStartDate() {
		return bizOccurStartDate;
	}

	/**
	 * @param bizOccurStartDate 业务发生日期
	 */
	public void setBizOccurStartDate(Date bizOccurStartDate) {
		this.bizOccurStartDate = bizOccurStartDate;
	}

	/**
	 * @return 业务结束日期
	 */
	public Date getBizOccurEndDate() {
		return bizOccurEndDate;
	}

	/**
	 * @param bizOccurEndDate 业务结束日期
	 */
	public void setBizOccurEndDate(Date bizOccurEndDate) {
		this.bizOccurEndDate = bizOccurEndDate;
	}

	/**
	 * @return 同行人最高等级
	 */
	public int getHighestLev() {
		return highestLev;
	}

	/**
	 * @param highestLev 同行人最高等级
	 */
	public void setHighestLev(int highestLev) {
		this.highestLev = highestLev;
	}

	/**
	 * @return 出差申请人姓名
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName 出差申请人姓名
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return 出差申请人工号
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo 出差申请人工号
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return 出差人级别
	 */
	public int getEmpLve() {
		return empLve;
	}

	/**
	 * @param empLve 出差人级别
	 */
	public void setEmpLve(int empLve) {
		this.empLve = empLve;
	}

	/**
	 * @return 出差目的地
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination 出差目的地
	 */
	public void setDestination(String destination) {
		this.destination = destination;
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
	 * @return 出发城市
	 */
	public String getStartCity() {
		return startCity;
	}

	/**
	 * @param startCity 出发城市
	 */
	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}

	/**
	 * @return 到达城市
	 */
	public String getEndCity() {
		return endCity;
	}

	/**
	 * @param endCity 到达城市
	 */
	public void setEndCity(String endCity) {
		this.endCity = endCity;
	}

	/**
	 * @return 折扣标准
	 */
	public String getDiscountStandard() {
		return discountStandard;
	}

	/**
	 * @param discountStandard 折扣标准
	 */
	public void setDiscountStandard(String discountStandard) {
		this.discountStandard = discountStandard;
	}
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

}
