package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *工程项目状态申请单VO
 */
public class ProjectStatusVo {
	//工程项目状态申请单表头
	private ProjectStatusEntity projectStatusEntity;
	//工程项目状态申请单分录
	private List<ProjectStatusEntry> projectStatusEntry;
	public ProjectStatusEntity getProjectStatusEntity() {
		return projectStatusEntity;
	}
	public void setProjectStatusEntity(ProjectStatusEntity projectStatusEntity) {
		this.projectStatusEntity = projectStatusEntity;
	}
	public List<ProjectStatusEntry> getProjectStatusEntry() {
		if (projectStatusEntry == null) {
			projectStatusEntry = new ArrayList<ProjectStatusEntry>();
		}
		return projectStatusEntry;
	}
	public void setProjectStatusEntry(List<ProjectStatusEntry> projectStatusEntry) {
		this.projectStatusEntry = projectStatusEntry;
	}
	
	
	
}
