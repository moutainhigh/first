package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;
import java.math.BigDecimal;
import com.deppon.foss.framework.entity.BaseEntity;

/**
*内修
*/
public class MaintenanceIREntity extends BaseEntity {
	private static final long serialVersionUID = -5415612104576707873L;
	private String fid;
	private Long fseq;                               		//单据分录序列号
	private String fparentID;                        
	private Long cfSeq;                              		//单据分录序列号
	private String cfMaintenanceItemI;               		//保养项目
	private String cfMaintainIdID;                   		//维修项目
	private String cfMtContent;                      		//维保内容
	private BigDecimal cfWorkTimeCost;               		//工时费
	private String cfMechanic;                       		//修理工
	private String cfMechanicNumber;                 		//修理工工号
	private String cfMuchanicsId;                    		//修理工ids
	private String cfCarAccessoryID;                 		//车体附件
	private String cfRepairs;                        		//保修内容
	private Long cfIsCarAccessory;                   		//是否车体附件
	private String fcarTireID;                       		//轮胎

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
	public void setCfMaintenanceItemI(String cfMaintenanceItemI){
		this.cfMaintenanceItemI=cfMaintenanceItemI;
	}
	public String getCfMaintenanceItemI(){
		return cfMaintenanceItemI;
	}
	public void setCfMaintainIdID(String cfMaintainIdID){
		this.cfMaintainIdID=cfMaintainIdID;
	}
	public String getCfMaintainIdID(){
		return cfMaintainIdID;
	}
	public void setCfMtContent(String cfMtContent){
		this.cfMtContent=cfMtContent;
	}
	public String getCfMtContent(){
		return cfMtContent;
	}
	public void setCfWorkTimeCost(BigDecimal cfWorkTimeCost){
		this.cfWorkTimeCost=cfWorkTimeCost;
	}
	public BigDecimal getCfWorkTimeCost(){
		return cfWorkTimeCost;
	}
	public void setCfMechanic(String cfMechanic){
		this.cfMechanic=cfMechanic;
	}
	public String getCfMechanic(){
		return cfMechanic;
	}
	public void setCfMechanicNumber(String cfMechanicNumber){
		this.cfMechanicNumber=cfMechanicNumber;
	}
	public String getCfMechanicNumber(){
		return cfMechanicNumber;
	}
	public void setCfMuchanicsId(String cfMuchanicsId){
		this.cfMuchanicsId=cfMuchanicsId;
	}
	public String getCfMuchanicsId(){
		return cfMuchanicsId;
	}
	public void setCfCarAccessoryID(String cfCarAccessoryID){
		this.cfCarAccessoryID=cfCarAccessoryID;
	}
	public String getCfCarAccessoryID(){
		return cfCarAccessoryID;
	}
	public void setCfRepairs(String cfRepairs){
		this.cfRepairs=cfRepairs;
	}
	public String getCfRepairs(){
		return cfRepairs;
	}
	public void setCfIsCarAccessory(Long cfIsCarAccessory){
		this.cfIsCarAccessory=cfIsCarAccessory;
	}
	public Long getCfIsCarAccessory(){
		return cfIsCarAccessory;
	}
	public void setFcarTireID(String fcarTireID){
		this.fcarTireID=fcarTireID;
	}
	public String getFcarTireID(){
		return fcarTireID;
	}
}

