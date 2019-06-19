package com.deppon.dpm.module.wfs.shared.domain;

import java.util.List;

/**
 * 待办列表 把泛微返回的实体和 我们数据库中存的每类工作流对应的页面地址拼为一个实体
 * @author 276344
 *
 */

public class WorkflowListEntity {
	//详情页面地址
	private String pageAdress;
	//workflowRequestInfo
	private weaver.workflow.webservices.WorkflowRequestInfo requestInfo;
	//搜索接口里面的workflowRequestInfo
	private weaver.workflow.webservices.WorkflowRequestInfo searchRequestInfo;
	//工作流状态（新工作流，老工作流）
	private String status;
	//头像地址
	private List<NwfsPicPathEntity> picPaths;
	
	/**
	 * get
	 * @return
	 */
	public String getPageAdress() {
		return pageAdress;
	}
	/**
	 * set
	 * @param pageAdress
	 */
	public void setPageAdress(String pageAdress) {
		this.pageAdress = pageAdress;
	}
	/**
	 * get
	 * @return
	 */
	public weaver.workflow.webservices.WorkflowRequestInfo getRequestInfo() {
		return requestInfo;
	}
	/**
	 * set
	 * @param requestInfo
	 */
	public void setRequestInfo(
			weaver.workflow.webservices.WorkflowRequestInfo requestInfo) {
		this.requestInfo = requestInfo;
	}
	/**
	 * get
	 * @return
	 */
	public weaver.workflow.webservices.WorkflowRequestInfo getSearchRequestInfo() {
		return searchRequestInfo;
	}
	/**
	 * set
	 * @param searchRequestInfo
	 */
	public void setSearchRequestInfo(
			weaver.workflow.webservices.WorkflowRequestInfo searchRequestInfo) {
		this.searchRequestInfo = searchRequestInfo;
	}
	/**
	 * get
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * set
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * get
	 * @return
	 */
	public List<NwfsPicPathEntity> getPicPaths() {
		return picPaths;
	}
	/**
	 * set
	 * @param picPaths
	 */
	public void setPicPaths(List<NwfsPicPathEntity> picPaths) {
		this.picPaths = picPaths;
	}
	
}
