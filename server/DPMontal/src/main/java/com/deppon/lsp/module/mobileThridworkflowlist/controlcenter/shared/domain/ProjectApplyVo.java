package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.util.List;
/**
 * 2014-08-01
 * @author 203906
 * 包含项目工程申请所有相关业务数据
 */
public class ProjectApplyVo {
	
	
	//工程项目申请单表头信息查询
	private ProjectApplyEntity billl;
	
	//工程项目申请单分录明细信息查询
	private List<ProjectApplyEntryEntity> entryList;
	
	//工程项目申请单车辆配套明细分录实体
	private List<ProjectApplyE2Entity> entryList2;
	
	//工程项目申请单 资源描述 分录实体
	private List<ProjectApplyE3Entity> entryList3;
	
	//工程项目申请单 办公配套 分录实体
	private List<ProjectApplyE4Entity> entryList4;
	
	
	public ProjectApplyEntity getBilll() {
		return billl;
	}
	public void setBilll(ProjectApplyEntity billl) {
		this.billl = billl;
	}
	public List<ProjectApplyEntryEntity> getEntryList() {
		return entryList;
	}
	public void setEntryList(List<ProjectApplyEntryEntity> entryList) {
		this.entryList = entryList;
	}
	public List<ProjectApplyE2Entity> getEntryList2() {
		return entryList2;
	}
	public void setEntryList2(List<ProjectApplyE2Entity> entryList2) {
		this.entryList2 = entryList2;
	}
	public List<ProjectApplyE3Entity> getEntryList3() {
		return entryList3;
	}
	public void setEntryList3(List<ProjectApplyE3Entity> entryList3) {
		this.entryList3 = entryList3;
	}
	public List<ProjectApplyE4Entity> getEntryList4() {
		return entryList4;
	}
	public void setEntryList4(List<ProjectApplyE4Entity> entryList4) {
		this.entryList4 = entryList4;
	}
	
	
	


}
