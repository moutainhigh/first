package com.deppon.dpm.module.wfs.shared.dto;

import java.io.Serializable;
/**
 * 工作流列表 Dto封装 前台使用
 * @author gcl
 */
public class WorkItemsDto implements Serializable {

	private static final long serialVersionUID = -7495947552332506957L;
	
	private String id;
	/**
	 * 用户名
	 */
	private String userId;
	/**
	 * 工作流类型list
	 */
	private String[] processTypeList;
	private String processType;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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
	 * @return the processTypeList
	 */
	public String[] getProcessTypeList() {
		return processTypeList;
	}
	/**
	 * @param processTypeList the processTypeList to set
	 */
	public void setProcessTypeList(String[] processTypeList) {
		this.processTypeList = processTypeList;
	}
	/**
	 * @return the processType
	 */
	public String getProcessType() {
		return processType;
	}
	/**
	 * @param processType the processType to set
	 */
	public void setProcessType(String processType) {
		this.processType = processType;
	}
}
