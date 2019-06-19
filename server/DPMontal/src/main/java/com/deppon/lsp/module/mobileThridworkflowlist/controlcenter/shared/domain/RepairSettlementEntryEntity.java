package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;
import java.math.BigDecimal;
import java.util.Date;
import com.deppon.foss.framework.entity.BaseEntity;

/**
*分录
*/
public class RepairSettlementEntryEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String fid;
	private Long fseq;                                                             		//单据分录序列号
	private String fparentID;                                                      
	private String cfRepairRecordNum;                                              		//维修记录单编号
	private String cfRepairApplyNum;                                               		//维修申请/计划单编号
	private String cfByServiceDepID;                                               		//被服务部门
	private String cfBelongsAreaID;                                                		//所属大区
	private String cfInvoiceTitleID;                                               		//发票抬头
	private String cfMaintenanceMatte;                                             		//维修事项
	private Date cfDateStartRepair;                                                		//维修开始日期
	private Date cfDateComRepair;                                                  		//维修完成日期
	private BigDecimal cfTotalAmount;                                              		//结算总额
	private String cfIfProvision;                                                  		//是否预提
	private String cfArrangerID;                                                   		//安排人
	private String cfRepairrecordeid;                                              		//维修记录单id
	private String cfITitleID;                                                     		//发票抬头
	private String cfFeeAssumeDeptID;      
	//                                        		//费用承担部门
	private String cfTotalAmountDto;   
	
	public String getCfTotalAmountDto() {
		return cfTotalAmountDto;
	}
	public void setCfTotalAmountDto(String cfTotalAmountDto) {
		this.cfTotalAmountDto = cfTotalAmountDto;
	}
	public void setFseq(Long fseq){
		this.fseq=fseq;
	}
	public Long getFseq(){
		return fseq;
	}
	public void setFid(String fid){
		this.fid=fid;
	}
	public String getFid(){
		return fid;
	}
	public void setFparentID(String fparentID){
		this.fparentID=fparentID;
	}
	public String getFparentID(){
		return fparentID;
	}
	public void setCfRepairRecordNum(String cfRepairRecordNum){
		this.cfRepairRecordNum=cfRepairRecordNum;
	}
	public String getCfRepairRecordNum(){
		return cfRepairRecordNum;
	}
	public void setCfRepairApplyNum(String cfRepairApplyNum){
		this.cfRepairApplyNum=cfRepairApplyNum;
	}
	public String getCfRepairApplyNum(){
		return cfRepairApplyNum;
	}
	public void setCfByServiceDepID(String cfByServiceDepID){
		this.cfByServiceDepID=cfByServiceDepID;
	}
	public String getCfByServiceDepID(){
		return cfByServiceDepID;
	}
	public void setCfBelongsAreaID(String cfBelongsAreaID){
		this.cfBelongsAreaID=cfBelongsAreaID;
	}
	public String getCfBelongsAreaID(){
		return cfBelongsAreaID;
	}
	public void setCfInvoiceTitleID(String cfInvoiceTitleID){
		this.cfInvoiceTitleID=cfInvoiceTitleID;
	}
	public String getCfInvoiceTitleID(){
		return cfInvoiceTitleID;
	}
	public void setCfMaintenanceMatte(String cfMaintenanceMatte){
		this.cfMaintenanceMatte=cfMaintenanceMatte;
	}
	public String getCfMaintenanceMatte(){
		return cfMaintenanceMatte;
	}
	public void setCfDateStartRepair(Date cfDateStartRepair){
		this.cfDateStartRepair=cfDateStartRepair;
	}
	public Date getCfDateStartRepair(){
		return cfDateStartRepair;
	}
	public void setCfDateComRepair(Date cfDateComRepair){
		this.cfDateComRepair=cfDateComRepair;
	}
	public Date getCfDateComRepair(){
		return cfDateComRepair;
	}
	public void setCfTotalAmount(BigDecimal cfTotalAmount){
		this.cfTotalAmount=cfTotalAmount;
	}
	public BigDecimal getCfTotalAmount(){
		return cfTotalAmount;
	}
	public void setCfIfProvision(String cfIfProvision){
		this.cfIfProvision=cfIfProvision;
	}
	public String getCfIfProvision(){
		return cfIfProvision;
	}
	public void setCfArrangerID(String cfArrangerID){
		this.cfArrangerID=cfArrangerID;
	}
	public String getCfArrangerID(){
		return cfArrangerID;
	}
	public void setCfRepairrecordeid(String cfRepairrecordeid){
		this.cfRepairrecordeid=cfRepairrecordeid;
	}
	public String getCfRepairrecordeid(){
		return cfRepairrecordeid;
	}
	public void setCfITitleID(String cfITitleID){
		this.cfITitleID=cfITitleID;
	}
	public String getCfITitleID(){
		return cfITitleID;
	}
	public void setCfFeeAssumeDeptID(String cfFeeAssumeDeptID){
		this.cfFeeAssumeDeptID=cfFeeAssumeDeptID;
	}
	public String getCfFeeAssumeDeptID(){
		return cfFeeAssumeDeptID;
	}
}

