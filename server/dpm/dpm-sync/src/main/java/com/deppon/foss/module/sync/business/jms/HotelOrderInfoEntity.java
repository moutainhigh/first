package com.deppon.foss.module.sync.business.jms;

import java.util.Date;

/**
 * 酒店订单信息实体类
 * 
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
	 * get
	 * 
	 * @return
	 */
	public String getBizStartTime() {
		return bizStartTime;
	}

	/**
	 * set
	 * 
	 * @param bizStartTime
	 */
	public void setBizStartTime(String bizStartTime) {
		this.bizStartTime = bizStartTime;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getBizEndTime() {
		return bizEndTime;
	}

	/**
	 * set
	 * 
	 * @param bizEndTime
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
	 * get
	 * 
	 * @return
	 */
	public String getClaimLineId() {
		return claimLineId;
	}

	/**
	 * set
	 * 
	 * @param claimLineId
	 */
	public void setClaimLineId(String claimLineId) {
		this.claimLineId = claimLineId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * set
	 * 
	 * @param orderNo
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getOrderState() {
		return orderState;
	}

	/**
	 * set
	 * 
	 * @param orderState
	 */
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getCostCenterNo() {
		return costCenterNo;
	}

	/**
	 * set
	 * 
	 * @param costCenterNo
	 */
	public void setCostCenterNo(String costCenterNo) {
		this.costCenterNo = costCenterNo;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getCostCenterName() {
		return costCenterName;
	}

	/**
	 * set
	 * 
	 * @param costCenterName
	 */
	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getBizOccurStartDate() {
		return bizOccurStartDate;
	}

	/**
	 * set
	 * 
	 * @param bizOccurStartDate
	 */
	public void setBizOccurStartDate(Date bizOccurStartDate) {
		this.bizOccurStartDate = bizOccurStartDate;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getBizOccurEndDate() {
		return bizOccurEndDate;
	}

	/**
	 * set
	 * 
	 * @param bizOccurEndDate
	 */
	public void setBizOccurEndDate(Date bizOccurEndDate) {
		this.bizOccurEndDate = bizOccurEndDate;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getHighestLev() {
		return highestLev;
	}

	/**
	 * set
	 * 
	 * @param highestLev
	 */
	public void setHighestLev(int highestLev) {
		this.highestLev = highestLev;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * set
	 * 
	 * @param empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * set
	 * 
	 * @param empNo
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getEmpLve() {
		return empLve;
	}

	/**
	 * set
	 * 
	 * @param empLve
	 */
	public void setEmpLve(int empLve) {
		this.empLve = empLve;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public float getPlanAmount() {
		return planAmount;
	}

	/**
	 * set
	 * 
	 * @param planAmount
	 */
	public void setPlanAmount(float planAmount) {
		this.planAmount = planAmount;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getStayCity() {
		return stayCity;
	}

	/**
	 * set
	 * 
	 * @param stayCity
	 */
	public void setStayCity(String stayCity) {
		this.stayCity = stayCity;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getCostStandard() {
		return costStandard;
	}

	/**
	 * set
	 * 
	 * @param costStandard
	 */
	public void setCostStandard(String costStandard) {
		this.costStandard = costStandard;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getStayDays() {
		return stayDays;
	}

	/**
	 * set
	 * 
	 * @param stayDays
	 */
	public void setStayDays(String stayDays) {
		this.stayDays = stayDays;
	}

}
