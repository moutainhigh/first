package com.deppon.wfs.workflow.domain;

import java.util.Date;
/**
 * 
* @title: OperationMessage 
* @description：工作流类型操作记录实体
* @author： 何玲菠
* @date： 2014-2-18 下午5:03:45
 */
public class OperationMessage {
	/**
	 * id
	 */
	long id;
	/**
	 * 工号
	 */
	String userId;
	/**
	 * 姓名
	 */
	String userName;
	/**
	 * 操作时间
	 */
	Date operationDate;
	/**
	 * 操作类型
	 */
	String operationType;
	/**
	 * 工作流号
	 */
	String processinstid;
	/**
	 * 所属系统
	 */
	String sysCode;
	
	public OperationMessage(long id ,String userId ,String userName , Date operationDate , String operationType , String processinstid ,String sysCode){
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.operationDate = operationDate;
		this.operationType = operationType;
		this.processinstid = processinstid;
		this.sysCode = sysCode;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the operationDate
	 */
	public Date getOperationDate() {
		return operationDate;
	}
	/**
	 * @param operationDate the operationDate to set
	 */
	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}
	/**
	 * @return the operationType
	 */
	public String getOperationType() {
		return operationType;
	}
	/**
	 * @param operationType the operationType to set
	 */
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	/**
	 * @return the processinstid
	 */
	public String getProcessinstid() {
		return processinstid;
	}
	/**
	 * @param processinstid the processinstid to set
	 */
	public void setProcessinstid(String processinstid) {
		this.processinstid = processinstid;
	}
	/**
	 * @return the sysCode
	 */
	public String getSysCode() {
		return sysCode;
	}
	/**
	 * @param sysCode the sysCode to set
	 */
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}
	
}
