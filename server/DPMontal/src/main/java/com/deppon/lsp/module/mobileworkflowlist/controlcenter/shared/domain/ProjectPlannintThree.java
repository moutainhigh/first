package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

public class ProjectPlannintThree extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fId;
	//单据分录序列号；FSEQ
	private long fSeq;
	//FPARENTID
	private String fParentId;
	//FFSEQ0
	private long fFseq;
	//FSOURCINGTYPEID 寻源类型
	private String fSourcIngTypeId;
	//FSOURCINGTYPEID 寻源类型
	private String fSourcIngTypeName;
	//FPLANAMOUNT 计划数量
	private String fPlanAmount;
	//备注；FREMARK
	private String fRemark;
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	public long getfSeq() {
		return fSeq;
	}
	public void setfSeq(long fSeq) {
		this.fSeq = fSeq;
	}
	public String getfParentId() {
		return fParentId;
	}
	public void setfParentId(String fParentId) {
		this.fParentId = fParentId;
	}
	public long getfFseq() {
		return fFseq;
	}
	public void setfFseq(long fFseq) {
		this.fFseq = fFseq;
	}
	public String getfSourcIngTypeId() {
		return fSourcIngTypeId;
	}
	public void setfSourcIngTypeId(String fSourcIngTypeId) {
		this.fSourcIngTypeId = fSourcIngTypeId;
	}
	public String getfPlanAmount() {
		return fPlanAmount;
	}
	public void setfPlanAmount(String fPlanAmount) {
		this.fPlanAmount = fPlanAmount;
	}
	public String getfRemark() {
		return fRemark;
	}
	public void setfRemark(String fRemark) {
		this.fRemark = fRemark;
	}
	public String getfSourcIngTypeName() {
		return fSourcIngTypeName;
	}
	public void setfSourcIngTypeName(String fSourcIngTypeName) {
		this.fSourcIngTypeName = fSourcIngTypeName;
	}
	
	
	
}
