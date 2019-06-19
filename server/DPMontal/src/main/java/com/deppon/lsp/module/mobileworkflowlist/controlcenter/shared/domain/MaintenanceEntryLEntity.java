package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;
import java.math.BigDecimal;
import com.deppon.foss.framework.entity.BaseEntity;

/**
*所需配件
*/
public class MaintenanceEntryLEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String fid;
	private Long fseq;                               		//单据分录序列号
	private String fparentID;                        
	private Long cfSeq;                              		//单据分录序列号
	private String cfMaterialNoID;                   		//物品id
	private String cfNorms;                          		//规格型号
	private String cfMaterialName;                   		//物品名称
	private String cfPrickle;                        		//计量单位
	private BigDecimal cfNumbers;                    		//数量
	private BigDecimal cfPrice;                      		//单价
	private BigDecimal cfClCountCost;                		//物品总费用
	private String cfMaterialReqBill;                		//领料出库单Id
	private String cfMaterialReqEntryId;             		//领料出库单分录id
	private String cfMaterialReqNumber;              		//物料编码

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
	public void setCfMaterialNoID(String cfMaterialNoID){
		this.cfMaterialNoID=cfMaterialNoID;
	}
	public String getCfMaterialNoID(){
		return cfMaterialNoID;
	}
	public void setCfNorms(String cfNorms){
		this.cfNorms=cfNorms;
	}
	public String getCfNorms(){
		return cfNorms;
	}
	public void setCfMaterialName(String cfMaterialName){
		this.cfMaterialName=cfMaterialName;
	}
	public String getCfMaterialName(){
		return cfMaterialName;
	}
	public void setCfPrickle(String cfPrickle){
		this.cfPrickle=cfPrickle;
	}
	public String getCfPrickle(){
		return cfPrickle;
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
	public void setCfClCountCost(BigDecimal cfClCountCost){
		this.cfClCountCost=cfClCountCost;
	}
	public BigDecimal getCfClCountCost(){
		return cfClCountCost;
	}
	public void setCfMaterialReqBill(String cfMaterialReqBill){
		this.cfMaterialReqBill=cfMaterialReqBill;
	}
	public String getCfMaterialReqBill(){
		return cfMaterialReqBill;
	}
	public void setCfMaterialReqEntryId(String cfMaterialReqEntryId){
		this.cfMaterialReqEntryId=cfMaterialReqEntryId;
	}
	public String getCfMaterialReqEntryId(){
		return cfMaterialReqEntryId;
	}
	public void setCfMaterialReqNumber(String cfMaterialReqNumber){
		this.cfMaterialReqNumber=cfMaterialReqNumber;
	}
	public String getCfMaterialReqNumber(){
		return cfMaterialReqNumber;
	}
}

