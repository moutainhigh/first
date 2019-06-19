/**
 * Project Name:dpm-tongxunlu
 * File Name:BaseSyncInfo.java
 * Package Name:com.deppon.dpm.tongxunlu.shared.dto
 * Date:2014-8-8上午8:51:44
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
*//*

package com.deppon.dpm.tongxunlu.shared.vo;
*//**
 * ClassName:BaseSyncInfo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * 
 * Date:     2014-8-8 上午8:51:44 <br/>
 * @author   157229-zxy
 * @version  
 * @since    JDK 1.6
 *//*
public class BaseSyncInfo {
	
	//员工更新总数
	private int empUpdateCount;
	//员工插入总数
	private int empInsertCount;
	//员工删除总数
	private int empDelCount;
	//机构更新总数
	private int orgUpdateCount;
	//机构插入总数
	private int orgInsertCount;
	//机构删除总数
	private int orgDelCount;
	//异常信息
	private StringBuffer sbMessage = new StringBuffer();
	//同步状态 0=成功 -1=失败
	private String syncStatus;
	
	public int getEmpUpdateCount() {
		return empUpdateCount;
	}
	public void setEmpUpdateCount(int empUpdateCount) {
		this.empUpdateCount = empUpdateCount;
	}
	public int getEmpInsertCount() {
		return empInsertCount;
	}
	public void setEmpInsertCount(int empInsertCount) {
		this.empInsertCount = empInsertCount;
	}
	public int getEmpDelCount() {
		return empDelCount;
	}
	public void setEmpDelCount(int empDelCount) {
		this.empDelCount = empDelCount;
	}
	public int getOrgUpdateCount() {
		return orgUpdateCount;
	}
	public void setOrgUpdateCount(int orgUpdateCount) {
		this.orgUpdateCount = orgUpdateCount;
	}
	public int getOrgInsertCount() {
		return orgInsertCount;
	}
	public void setOrgInsertCount(int orgInsertCount) {
		this.orgInsertCount = orgInsertCount;
	}
	public int getOrgDelCount() {
		return orgDelCount;
	}
	public void setOrgDelCount(int orgDelCount) {
		this.orgDelCount = orgDelCount;
	}
	public void addMessage(String msg) {
		sbMessage.append("|").append(msg);
	}
	
	public void addMessageToHeader(String msg) {
		sbMessage.insert(0, "|" + msg);
	}
	
	public String getMessage() {
		if(sbMessage.length() > 480){
			return sbMessage.substring(0, 480) + "......";
		}else
			return sbMessage.toString();
	}
	public String getSyncStatus() {
		return syncStatus;
	}
	public void setSyncStatus(String syncStatus) {
		this.syncStatus = syncStatus;
	}

}

*/