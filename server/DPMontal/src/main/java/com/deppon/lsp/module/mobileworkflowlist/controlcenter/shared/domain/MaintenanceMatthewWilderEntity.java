package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;
import java.math.BigDecimal;
import com.deppon.foss.framework.entity.BaseEntity;

/**
*外修
*/
public class MaintenanceMatthewWilderEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String fid;
	private Long fseq;                               		//单据分录序列号
	private String fparentID;                        
	private Long cfSeq;                              		//单据分录序列号
	private String cfMaintainPorject;                		//维修项目
	private BigDecimal cfTotalAmout;                 		//总金额
	private String cfNote;                           		//备注
	private String cfWorkTimeCost;                   		//工时
	private String cfCarAccessoryID;                 		//车体附件
	private String fcarTireID;                       		// 轮胎

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
	public void setCfMaintainPorject(String cfMaintainPorject){
		this.cfMaintainPorject=cfMaintainPorject;
	}
	public String getCfMaintainPorject(){
		return cfMaintainPorject;
	}
	public void setCfTotalAmout(BigDecimal cfTotalAmout){
		this.cfTotalAmout=cfTotalAmout;
	}
	public BigDecimal getCfTotalAmout(){
		return cfTotalAmout;
	}
	public void setCfNote(String cfNote){
		this.cfNote=cfNote;
	}
	public String getCfNote(){
		return cfNote;
	}
	public void setCfWorkTimeCost(String cfWorkTimeCost){
		this.cfWorkTimeCost=cfWorkTimeCost;
	}
	public String getCfWorkTimeCost(){
		return cfWorkTimeCost;
	}
	public void setCfCarAccessoryID(String cfCarAccessoryID){
		this.cfCarAccessoryID=cfCarAccessoryID;
	}
	public String getCfCarAccessoryID(){
		return cfCarAccessoryID;
	}
	public void setFcarTireID(String fcarTireID){
		this.fcarTireID=fcarTireID;
	}
	public String getFcarTireID(){
		return fcarTireID;
	}
}

