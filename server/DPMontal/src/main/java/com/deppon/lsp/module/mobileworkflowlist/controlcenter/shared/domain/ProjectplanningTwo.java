package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 * 工程规划单实体
 * @author 徐丁丁
 * @date 2013-10-25 下午3:42:11
 * @since
 * @version
 */
public class ProjectplanningTwo extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//ID;FID
	private String fId;
	//单据分录序列号；FSEQ
	private long fSeq;
	//FPARENTID
	private String fParentId;
	//FFSEQ0
	private long fFseq;
	//物品编码；FMATERIALlongID
	private String fMateriallongId;
	//物品名称；fMaterialName
	private String fMaterialName;
	//计划数量；FPLANQUANTITY
	private String fPlanQuantity;
	//物品类型；FMATERIALTYPE
	private String fMaterialType;
	//计量单位；FUNITS
	private String fUnits;
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
	public String getfMateriallongId() {
		return fMateriallongId;
	}
	public void setfMateriallongId(String fMateriallongId) {
		this.fMateriallongId = fMateriallongId;
	}
	public String getfMaterialName() {
		return fMaterialName;
	}
	public void setfMaterialName(String fMaterialName) {
		this.fMaterialName = fMaterialName;
	}
	public String getfPlanQuantity() {
		return fPlanQuantity;
	}
	public void setfPlanQuantity(String fPlanQuantity) {
		this.fPlanQuantity = fPlanQuantity;
	}
	public String getfMaterialType() {
		return fMaterialType;
	}
	public void setfMaterialType(String fMaterialType) {
		this.fMaterialType = fMaterialType;
	}
	public String getfUnits() {
		return fUnits;
	}
	public void setfUnits(String fUnits) {
		this.fUnits = fUnits;
	}
	
	
	
}
