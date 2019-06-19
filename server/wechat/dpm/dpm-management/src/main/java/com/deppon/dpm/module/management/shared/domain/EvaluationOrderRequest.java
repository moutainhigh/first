package com.deppon.dpm.module.management.shared.domain;

/**
 * 
* @ClassName: EvaluationOrderRequest 
* @Description: 事件评价对接移动请求实体 
* @author 123240 
* @date 2015-5-19 下午3:17:53
 */
public class EvaluationOrderRequest {
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
