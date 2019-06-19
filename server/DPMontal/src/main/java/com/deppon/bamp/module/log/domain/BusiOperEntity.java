package com.deppon.bamp.module.log.domain;

import java.io.Serializable;

/**
 * @title: BusiOperEntity 
 * @description: 业务操作实体类
 * @author: wuyaqing
 * @date:  2014-4-23 上午11:11:39
 */
public class BusiOperEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -5956274018991838703L;

	//用户工号
	private String empCode;
	//操作时间
	private String operationTime;
	//模块名称
	private String moduleName;
	//操作内容
	private String operationContent;
	
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getOperationContent() {
		return operationContent;
	}
	public void setOperationContent(String operationContent) {
		this.operationContent = operationContent;
	}
	
}
