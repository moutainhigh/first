package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * 移动端上报事件对应实体
 * @author 251624
 *
 */
public class AppraiseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 事件编号
	 */
	private String orderCode;
	/**
	 * 处理人名称
	 */
	private String currentUserName;
	/**
	 * 处理人工号
	 */
	private String currentUserCode;
	/**
	 * 未解决原因
	 */
	private String failReason;
	/**
	 * 是否解决：是 Y 否N
	 */
	private String isSolve;
	/**
	 * 问题/事件类型
	 */
	private String reportType;
	/**
	 * 状态变为待确认的时间
	 */
	private long confirmDate;
	/**
	 * 已完成时间
	 */
	private long finishDate;
	/**
	 * 时间状态: 待确认 0 已完成 1
	 */
	private String appraiseStatus;
	/**
	 * 用户评价使用的客户端类型
	 */
	private String os;
	/**
	 * 评价等级
	 */
	private String appraiseLevel;
	
	public String getAppraiseLevel() {
		return appraiseLevel;
	}
	public void setAppraiseLevel(String appraiseLevel) {
		this.appraiseLevel = appraiseLevel;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public long getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(long finishDate) {
		this.finishDate = finishDate;
	}
	public long getConfirmDate() {
		return confirmDate;
	}
	public void setConfirmDate(long confirmDate) {
		this.confirmDate = confirmDate;
	}
	public String getAppraiseStatus() {
		return appraiseStatus;
	}
	public void setAppraiseStatus(String appraiseStatus) {
		this.appraiseStatus = appraiseStatus;
	}
	/**
	 * @return the orderCode
	 */
	public String getOrderCode() {
		return orderCode;
	}
	/**
	 * @param orderCode the orderCode to set
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	/**
	 * @return the currentUserName
	 */
	public String getCurrentUserName() {
		return currentUserName;
	}
	/**
	 * @param currentUserName the currentUserName to set
	 */
	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}
	/**
	 * @return the currentUserCode
	 */
	public String getCurrentUserCode() {
		return currentUserCode;
	}
	/**
	 * @param currentUserCode the currentUserCode to set
	 */
	public void setCurrentUserCode(String currentUserCode) {
		this.currentUserCode = currentUserCode;
	}
	/**
	 * @return the failReason
	 */
	public String getFailReason() {
		return failReason;
	}
	/**
	 * @param failReason the failReason to set
	 */
	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}
	/**
	 * @return the isSolve
	 */
	public String getIsSolve() {
		return isSolve;
	}
	/**
	 * @param isSolve the isSolve to set
	 */
	public void setIsSolve(String isSolve) {
		this.isSolve = isSolve;
	}
}
