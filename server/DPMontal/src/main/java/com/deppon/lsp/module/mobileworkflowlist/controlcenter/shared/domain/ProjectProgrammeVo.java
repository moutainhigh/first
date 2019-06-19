package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.util.ArrayList;
import java.util.List;

public class ProjectProgrammeVo {
	//工程项目规划表头信息
	private ProgrammingEntity programmingEntity;
	//工程项目规划明细
	private List<ProjectPlannintLineEntity> ppEntityList;
	//工程项目规划物品明细
	private List<ProjectplanningTwo> articleLineEntityList;
	//工程项目规划寻源明细
	private List<ProjectPlannintThree> ppThreeList;
	
	
	public ProgrammingEntity getProgrammingEntity() {
		return programmingEntity;
	}
	public void setProgrammingEntity(ProgrammingEntity programmingEntity) {
		this.programmingEntity = programmingEntity;
	}
	public List<ProjectPlannintLineEntity> getPpEntityList() {
		if(ppEntityList == null) {
			ppEntityList = new ArrayList<ProjectPlannintLineEntity>();
		}
		return ppEntityList;
	}
	public void setPpEntityList(List<ProjectPlannintLineEntity> ppEntityList) {
		this.ppEntityList = ppEntityList;
	}
	public List<ProjectplanningTwo> getArticleLineEntityList() {
		if(articleLineEntityList == null) {
			articleLineEntityList = new ArrayList<ProjectplanningTwo>();
		}
		return articleLineEntityList;
	}
	public void setArticleLineEntityList(
			List<ProjectplanningTwo> articleLineEntityList) {
		this.articleLineEntityList = articleLineEntityList;
	}
	public List<ProjectPlannintThree> getPpThreeList() {
		if(ppThreeList == null) {
			ppThreeList = new ArrayList<ProjectPlannintThree>();
		}
		return ppThreeList;
	}
	public void setPpThreeList(List<ProjectPlannintThree> ppThreeList) {
		this.ppThreeList = ppThreeList;
	}
	
}
