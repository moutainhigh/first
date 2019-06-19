package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectBudgeEntity;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectBudgeEntries;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectBudgeNoConstructEntity;

/**
 * 
 * @Description : 工程项目预算调整单
 * @author : jianweiqiang
 * @date 2014-5-20 下午5:32:30
 * @since
 * @version v0.1
 */
public class ProjectbudgeVo {
	
	// 工程项目预算调整单主表
	private ProjectBudgeEntity projectBudgeEntity;
	// 工程项目预算调整单 工程项目预算调整单-分录实体类
	private ProjectBudgeEntries[] projectBudgeEntriesList;
	//工程项目预算调整单-非施工类预算实体类
	private ProjectBudgeNoConstructEntity[] projectBudgeNoConstructEntityList;
	//汇总查看页签
	private ProjectBudgeEntries[] projectBudgeTotalList;
	

	/**
	 * @Description : 返回 projectBudgeEntity属性的值
	 * @date 2014-5-21 上午8:25:15
	 */

	public ProjectBudgeEntity getProjectBudgeEntity() {
		return projectBudgeEntity;
	}

	/**
	 * @param 设置属性
	 *            projectBudgeEntity的值
	 */
	public void setProjectBudgeEntity(ProjectBudgeEntity projectBudgeEntity) {
		this.projectBudgeEntity = projectBudgeEntity;
	}

	/**
	 * @Description : 返回 projectBudgeEntriesList属性的值
	 * @date 2014-5-21 上午8:25:15
	 */

	public ProjectBudgeEntries[] getProjectBudgeEntriesList() {
		return projectBudgeEntriesList;
	}

	/**
	 * @param 设置属性
	 *            projectBudgeEntriesList的值
	 */
	public void setProjectBudgeEntriesList(
			ProjectBudgeEntries[] projectBudgeEntriesList) {
		this.projectBudgeEntriesList = projectBudgeEntriesList;
	}

	/**
	 * @Description : 返回 projectBudgeNoConstructEntityList属性的值
	 * @date 2014-5-21 上午8:25:15
	 */

	public ProjectBudgeNoConstructEntity[] getProjectBudgeNoConstructEntityList() {
		return projectBudgeNoConstructEntityList;
	}

	/**
	 * @param 设置属性
	 *            projectBudgeNoConstructEntityList的值
	 */
	public void setProjectBudgeNoConstructEntityList(
			ProjectBudgeNoConstructEntity[] projectBudgeNoConstructEntityList) {
		this.projectBudgeNoConstructEntityList = projectBudgeNoConstructEntityList;
	}

	/**
	 * @Description : 返回 projectBudgeTotalList属性的值
	 * @date 2014-5-21 上午9:59:15
	 */
	
	public ProjectBudgeEntries[] getProjectBudgeTotalList() {
		return projectBudgeTotalList;
	}

	/**
	 * @param  设置属性 projectBudgeTotalList的值
	 */
	public void setProjectBudgeTotalList(ProjectBudgeEntries[] projectBudgeTotalList) {
		this.projectBudgeTotalList = projectBudgeTotalList;
	}

	/**
	 * 
	 * @Description : 覆盖toString方法
	 * @author : jianweiqiang
	 * @date 2014-5-20 下午5:35:49
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
