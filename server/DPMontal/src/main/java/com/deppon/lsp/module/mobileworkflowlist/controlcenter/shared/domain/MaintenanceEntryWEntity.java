package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;
import java.math.BigDecimal;
import com.deppon.foss.framework.entity.BaseEntity;

/**
*所需配件
*/
public class MaintenanceEntryWEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String fid;
	private Long fseq;                               		//单据分录序列号
	private String fparentID;                        
	private Long cfSeq;                              		//单据分录序列号
	private String cfNorms;                          		//规格型号
	private String cfUnitID;                         		//计量单位
	private BigDecimal cfNumbers;                    		//数量
	private BigDecimal cfPrice;                      		//单价
	private String cfMaterialName;                   		//物品名称
	private BigDecimal cfClCountCost;                		//物品总费用
	public void setFid(String fid){
		this.fid=fid;
	}
	public String getFid(){
		return fid;
	}
	public void setFseq(Long fseq){
		this.fseq=fseq;
	}
	public Long getFseq(){
		return fseq;
	}
	public void setFparentID(String fparentID){
		this.fparentID=fparentID;
	}
	public String getFparentID(){
		return fparentID;
	}
	public void setCfSeq(Long cfSeq){
		this.cfSeq=cfSeq;
	}
	public Long getCfSeq(){
		return cfSeq;
	}
	public void setCfNorms(String cfNorms){
		this.cfNorms=cfNorms;
	}
	public String getCfNorms(){
		return cfNorms;
	}
	public void setCfUnitID(String cfUnitID){
		this.cfUnitID=cfUnitID;
	}
	public String getCfUnitID(){
		return cfUnitID;
	}
	public void setCfNumbers(BigDecimal cfNumbers){
		this.cfNumbers=cfNumbers;
	}
	public BigDecimal getCfNumbers(){
		return cfNumbers;
	}
	public void setCfPrice(BigDecimal cfPrice){
		this.cfPrice=cfPrice;
	}
	public BigDecimal getCfPrice(){
		return cfPrice;
	}
	public void setCfMaterialName(String cfMaterialName){
		this.cfMaterialName=cfMaterialName;
	}
	public String getCfMaterialName(){
		return cfMaterialName;
	}
	public void setCfClCountCost(BigDecimal cfClCountCost){
		this.cfClCountCost=cfClCountCost;
	}
	public BigDecimal getCfClCountCost(){
		return cfClCountCost;
	}
}

