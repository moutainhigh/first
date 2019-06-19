package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;
import java.math.BigDecimal;
import java.util.Date;
import com.deppon.foss.framework.entity.BaseEntity;

/**
*维修结算单
*/
public class RepairSettlementEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String fid;
	private String fcreatorID;                                                     		//创建者
	private Date fcreateTime;                                                      		//创建时间
	private String flastUpdateUserID;                                              		//最后修改者
	private Date flastUpdateTime;                                                  		//最后修改时间
	private String fcontrolUnitID;                                                 		//控制单元
	private String fnumber;                                                        		//单据编号
	private Date fbizDate;                                                         		//业务日期
	private String fhandlerID;                                                     		//经手人
	private String fdescription;                                                   		//参考信息
	private Long fhasEffected;                                                     		//是否曾经生效
	private String fauditorID;                                                     		//审核人
	private String fsourceBillID;                                                  		//原始单据ID
	private String fsourceFunction;                                                		//来源功能
	private Long ffivouchered;                                                     		//是否生成凭证
	private Date cfAuditTime;                                                      		//审核时间
	private String cfRepairSupplierID;                                             		//维修供应商
	private Date cfClearMonth;                                                     		//结算日期
	private String cfCreateDepID;                                                  		//创建部门
	private BigDecimal cfClearTotal;                                               		//结算总计
	private String cfStatus;    
	//                                                   		//单据状态
	private String cfClearTotalDto;
	
	
	private String pmUserID;	//登录人ID														//用户ID
	

	public void setFcreatorID(String fcreatorID){
		this.fcreatorID=fcreatorID;
	}
	public String getCfClearTotalDto() {
		return cfClearTotalDto;
	}
	public void setCfClearTotalDto(String cfClearTotalDto) {
		this.cfClearTotalDto = cfClearTotalDto;
	}
	public String getFcreatorID(){
		return fcreatorID;
	}
	public void setFcreateTime(Date fcreateTime){
		this.fcreateTime=fcreateTime;
	}
	public Date getFcreateTime(){
		return fcreateTime;
	}
	public void setFlastUpdateUserID(String flastUpdateUserID){
		this.flastUpdateUserID=flastUpdateUserID;
	}
	public String getFlastUpdateUserID(){
		return flastUpdateUserID;
	}
	public void setFlastUpdateTime(Date flastUpdateTime){
		this.flastUpdateTime=flastUpdateTime;
	}
	public Date getFlastUpdateTime(){
		return flastUpdateTime;
	}
	public void setFcontrolUnitID(String fcontrolUnitID){
		this.fcontrolUnitID=fcontrolUnitID;
	}
	public String getFcontrolUnitID(){
		return fcontrolUnitID;
	}
	public void setFnumber(String fnumber){
		this.fnumber=fnumber;
	}
	public String getFnumber(){
		return fnumber;
	}
	public void setFbizDate(Date fbizDate){
		this.fbizDate=fbizDate;
	}
	public Date getFbizDate(){
		return fbizDate;
	}
	public void setFhandlerID(String fhandlerID){
		this.fhandlerID=fhandlerID;
	}
	public String getFhandlerID(){
		return fhandlerID;
	}
	public void setFdescription(String fdescription){
		this.fdescription=fdescription;
	}
	public String getFdescription(){
		return fdescription;
	}
	public void setFhasEffected(Long fhasEffected){
		this.fhasEffected=fhasEffected;
	}
	public Long getFhasEffected(){
		return fhasEffected;
	}
	public void setFauditorID(String fauditorID){
		this.fauditorID=fauditorID;
	}
	public String getFauditorID(){
		return fauditorID;
	}
	public void setFsourceBillID(String fsourceBillID){
		this.fsourceBillID=fsourceBillID;
	}
	public String getFsourceBillID(){
		return fsourceBillID;
	}
	public void setFsourceFunction(String fsourceFunction){
		this.fsourceFunction=fsourceFunction;
	}
	public String getFsourceFunction(){
		return fsourceFunction;
	}
	public void setFid(String fid){
		this.fid=fid;
	}
	public String getFid(){
		return fid;
	}
	public void setFfivouchered(Long ffivouchered){
		this.ffivouchered=ffivouchered;
	}
	public Long getFfivouchered(){
		return ffivouchered;
	}
	public void setCfAuditTime(Date cfAuditTime){
		this.cfAuditTime=cfAuditTime;
	}
	public Date getCfAuditTime(){
		return cfAuditTime;
	}
	public void setCfRepairSupplierID(String cfRepairSupplierID){
		this.cfRepairSupplierID=cfRepairSupplierID;
	}
	public String getCfRepairSupplierID(){
		return cfRepairSupplierID;
	}
	public void setCfClearMonth(Date cfClearMonth){
		this.cfClearMonth=cfClearMonth;
	}
	public Date getCfClearMonth(){
		return cfClearMonth;
	}
	public void setCfCreateDepID(String cfCreateDepID){
		this.cfCreateDepID=cfCreateDepID;
	}
	public String getCfCreateDepID(){
		return cfCreateDepID;
	}
	public void setCfClearTotal(BigDecimal cfClearTotal){
		this.cfClearTotal=cfClearTotal;
	}
	public BigDecimal getCfClearTotal(){
		return cfClearTotal;
	}
	public void setCfStatus(String cfStatus){
		this.cfStatus=cfStatus;
	}
	public String getCfStatus(){
		return cfStatus;
	}
	public String getPmUserID() {
		return pmUserID;
	}
	public void setPmUserID(String pmUserID) {
		this.pmUserID = pmUserID;
	}
	
}

