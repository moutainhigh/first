package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.io.Serializable;

/**
 * 移动办公工程预算明细单
 * @author 146831
 *
 */
public class ProjectBudgeDetailVo implements Serializable{
    
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 9100613674898682018L;
	
	/**
	 * 表头
	 */
	private ProjectBudgeDetailEntity projectBudgeDetailEntity;
	
	/**
	 * 明细分录
	 */
	private DetailEntity[]  detailEntities;
	
	/**
	 * 非施工类的明细分录
	 */
	private NonConstructionEntity[] nonConstructionEntities;

	public ProjectBudgeDetailEntity getProjectBudgeDetailEntity() {
		return projectBudgeDetailEntity;
	}

	public void setProjectBudgeDetailEntity(
			ProjectBudgeDetailEntity projectBudgeDetailEntity) {
		this.projectBudgeDetailEntity = projectBudgeDetailEntity;
	}

	public DetailEntity[] getDetailEntities() {
		return detailEntities;
	}

	public void setDetailEntities(DetailEntity[] detailEntities) {
		this.detailEntities = detailEntities;
	}

	public NonConstructionEntity[] getNonConstructionEntities() {
		return nonConstructionEntities;
	}

	public void setNonConstructionEntities(
			NonConstructionEntity[] nonConstructionEntities) {
		this.nonConstructionEntities = nonConstructionEntities;
	}
	
	
	
	

}
