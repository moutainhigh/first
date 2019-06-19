package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.util.List;


/**
 * 
 * @author 150973
 * @date 2014年8月4日 17:18:19
 * @describe 工程项目预算调整单实体Vo
 */
public class ProjectbudgeVo {

	//表头
	private ProjectBudgeEntity projectBudgeEntity;
	//汇总查看分录
	private List<ProjectBudgeEntries> projectBudgeCollectList;
	//施工类明细分录
	private List<ProjectBudgeEntries> projectBudgeEntriesList;
	//非施工预算实体类集合
	private List<ProjectBudgeNoConstructEntity> projectBudgeNoConstructEntityList;
	/**
	 * @return the projectBudgeEntity
	 */
	public ProjectBudgeEntity getProjectBudgeEntity() {
		return projectBudgeEntity;
	}
	/**
	 * @param projectBudgeEntity the projectBudgeEntity to set
	 */
	public void setProjectBudgeEntity(ProjectBudgeEntity projectBudgeEntity) {
		this.projectBudgeEntity = projectBudgeEntity;
	}
	/**
	 * @return the projectBudgeCollectList
	 */
	public List<ProjectBudgeEntries> getProjectBudgeCollectList() {
		return projectBudgeCollectList;
	}
	/**
	 * @param projectBudgeCollectList the projectBudgeCollectList to set
	 */
	public void setProjectBudgeCollectList(
			List<ProjectBudgeEntries> projectBudgeCollectList) {
		this.projectBudgeCollectList = projectBudgeCollectList;
	}
	/**
	 * @return the projectBudgeEntriesList
	 */
	public List<ProjectBudgeEntries> getProjectBudgeEntriesList() {
		return projectBudgeEntriesList;
	}
	/**
	 * @param projectBudgeEntriesList the projectBudgeEntriesList to set
	 */
	public void setProjectBudgeEntriesList(
			List<ProjectBudgeEntries> projectBudgeEntriesList) {
		this.projectBudgeEntriesList = projectBudgeEntriesList;
	}
	/**
	 * @return the projectBudgeNoConstructEntityList
	 */
	public List<ProjectBudgeNoConstructEntity> getProjectBudgeNoConstructEntityList() {
		return projectBudgeNoConstructEntityList;
	}
	/**
	 * @param projectBudgeNoConstructEntityList the projectBudgeNoConstructEntityList to set
	 */
	public void setProjectBudgeNoConstructEntityList(
			List<ProjectBudgeNoConstructEntity> projectBudgeNoConstructEntityList) {
		this.projectBudgeNoConstructEntityList = projectBudgeNoConstructEntityList;
	}
	
	
}
