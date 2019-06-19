package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectApprovalDEntryEntity;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectApprovalEntity;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectApprovalEntryEntity;

/**
 * 
 * @Description : 立项单
 * @author : jianweiqiang
 * @date 2014-5-20 下午5:32:30
 * @since
 * @version v0.1
 */
public class ProjectapprovalVo {
	// 立项单主表
	private ProjectApprovalEntity projectApprovalEntity;
	// 立项单分录
	private ProjectApprovalEntryEntity[] projectApprovalEntryEntityList;
	// 立项单分录
	private ProjectApprovalDEntryEntity[] projectApprovalDEntryEntityList;
	
	
	/**
	 * @Description : 返回 projectApprovalEntity属性的值
	 * @date 2014-5-21 上午10:05:45
	 */
	
	public ProjectApprovalEntity getProjectApprovalEntity() {
		return projectApprovalEntity;
	}


	/**
	 * @param  设置属性 projectApprovalEntity的值
	 */
	public void setProjectApprovalEntity(ProjectApprovalEntity projectApprovalEntity) {
		this.projectApprovalEntity = projectApprovalEntity;
	}


	/**
	 * @Description : 返回 projectApprovalEntryEntityList属性的值
	 * @date 2014-5-21 上午10:05:45
	 */
	
	public ProjectApprovalEntryEntity[] getProjectApprovalEntryEntityList() {
		if (projectApprovalEntryEntityList == null) {
			projectApprovalEntryEntityList = new ProjectApprovalEntryEntity[0];
		}
		return projectApprovalEntryEntityList;
	}


	/**
	 * @param  设置属性 projectApprovalEntryEntityList的值
	 */
	public void setProjectApprovalEntryEntityList(
			ProjectApprovalEntryEntity[] projectApprovalEntryEntityList) {
		this.projectApprovalEntryEntityList = projectApprovalEntryEntityList;
	}


	/**
	 * @Description : 返回 projectApprovalDEntryEntityList属性的值
	 * @date 2014-5-21 上午10:05:45
	 */
	
	public ProjectApprovalDEntryEntity[] getProjectApprovalDEntryEntityList() {
		if (projectApprovalDEntryEntityList == null) {
			projectApprovalDEntryEntityList = new ProjectApprovalDEntryEntity[0];
		}
		return projectApprovalDEntryEntityList;
	}


	/**
	 * @param  设置属性 projectApprovalDEntryEntityList的值
	 */
	public void setProjectApprovalDEntryEntityList(
			ProjectApprovalDEntryEntity[] projectApprovalDEntryEntityList) {
		this.projectApprovalDEntryEntityList = projectApprovalDEntryEntityList;
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
