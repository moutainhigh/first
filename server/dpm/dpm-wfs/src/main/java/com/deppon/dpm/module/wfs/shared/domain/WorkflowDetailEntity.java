package com.deppon.dpm.module.wfs.shared.domain;

import java.util.List;

/**
 * 详情页实体
 * @author 491275
 *
 */
public class WorkflowDetailEntity {
	
	//workflowRequestInfo
	private weaver.workflow.webservices.WorkflowRequestInfo requestInfo;
	//审批记录头像地址
	private List<NwfsPicPathEntity> picPaths;
	
	
	public weaver.workflow.webservices.WorkflowRequestInfo getRequestInfo() {
		return requestInfo;
	}
	public void setRequestInfo(weaver.workflow.webservices.WorkflowRequestInfo requestInfo) {
		this.requestInfo = requestInfo;
	}
	public List<NwfsPicPathEntity> getPicPaths() {
		return picPaths;
	}
	public void setPicPaths(List<NwfsPicPathEntity> picPaths) {
		this.picPaths = picPaths;
	}

}
