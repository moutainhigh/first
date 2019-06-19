package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;
import java.math.BigDecimal;
import java.util.Date;
import com.deppon.foss.framework.entity.BaseEntity;

/**
*维修保养单
*/
public class MaintenanceEntity extends BaseEntity {
	
	/**
	 */
	private static final long serialVersionUID = -7435382174989026352L;
	private String fid;
	private String fcreatorID;                       		//创建者
	private Date fcreateTime;                        		//创建时间
	private String flastUpdateUserID;                		//最后修改者
	private Date flastUpdateTime;                    		//最后修改时间
	private String fcontrolUnitID;                   		//控制单元
	private String fnumber;                          		//单据编号
	private Date fbizDate;                           		//业务日期
	private String fhandlerID;                       		//经手人
	private String fdescription;                     		//参考信息
	private Long fhasEffected;                       		//是否曾经生效
	private String fauditorID;                       		//审核人
	private String fsourceBillID;                    		//原始单据ID
	private String fsourceFunction;                  		//来源功能
	private Long ffivouchered;                       		//是否生成凭证
	private String cfObjectName;                     		//维保对象
	private Long cfIsMaintenance;                    		//保养
	private String cfCarNumberID;                    		//车牌号
	private String cfContainerNo;							//货柜号
	private String cfVehicleBrand;                   		//车辆品牌
	private BigDecimal cfCurrencyKM;                 		//当前公里数
	private String cfVehicleType;                    		//车型
	private String cfVehicleUse;                     		//车辆用途
	private String cfDriverID;                       		//司机
	private String cfIsBigOrSmallContainer;          		//大小柜
	private String cfPlateNumber;                    		//货柜牌照号
	private Date cfStratDate;                        		//开始使用日期
	private String cfMtContentID;                    		//报修部门
	private String mtContentId;								//报修部门id
	private String cfRepairID;                       		//报修人
	private BigDecimal cfAmount;                     		//维保预计金额
	private String cfMtUnitID;                       		//维保单位
	private String cfMtType;                         		//维保类型
	private String cfMtCategory;                     		//维保类别
	private Date cfMtStartDate;                      		//维保开始日期
	private Date cfMtEndDate;                        		//维保结束日期
	private String cfMtFactoryID;                    		//维修厂商
	private String cfMtTel;                          		//维修厂商电话
	private String cfForkliftNumberID;               		//叉车号
	private String cfForkliftModels;                 		//叉车类别
	private String cfForkliftBrand;                  		//叉车品牌
	private String cfModels;                         		//规格型号
	private BigDecimal cfMaterialCostTotal;          		//材料费用合计
	private BigDecimal cfWorkTimeCostTotal;          		//工时费用合计
	private BigDecimal cfMtCostTotal;                		//费用合计
	private String cfAssetsIdID;                     		//固定资产卡片
	private String cfBilllState;                     		//单据状态
	private String cfMaintenancePlotI;               		//保养计划单
	private Long cfperiodSeq;                        		//保养周期顺序
	private String cfCarAccidentID;                  		//事故单编号
	private String cfplonEntryId;                    		//保养计划分录id
	private Date cflastTimeMainten;                  		//上次叉车保养日期
	private String cfMgmtDeptID;                     		//管理部门
	private String cfMtUnitCu;                       		//维保单位CU
	private String cfmanufacturer;                   		//维修厂商
	private Long cfcooperation;                      		//是否合作供应商
	private String cfcontent;                        		//报修内容
	private Date cfrepairsTime;                      		//报修时间
	private String cffeeOwnerDept;                   		//费用承担部门
	private Long cfIsSupPay;                         		//是否供应商结算
	
	/**
	 * @return the mtContentId
	 */
	public String getMtContentId() {
		return mtContentId;
	}
	/**
	 * @param mtContentId the mtContentId to set
	 */
	public void setMtContentId(String mtContentId) {
		this.mtContentId = mtContentId;
	}
	public void setFcreatorID(String fcreatorID){
		this.fcreatorID=fcreatorID;
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
	public void setCfObjectName(String cfObjectName){
		this.cfObjectName=cfObjectName;
	}
	public String getCfObjectName(){
		return cfObjectName;
	}
	public void setCfIsMaintenance(Long cfIsMaintenance){
		this.cfIsMaintenance=cfIsMaintenance;
	}
	public Long getCfIsMaintenance(){
		return cfIsMaintenance;
	}
	public void setCfCarNumberID(String cfCarNumberID){
		this.cfCarNumberID=cfCarNumberID;
	}
	public String getCfCarNumberID(){
		return cfCarNumberID;
	}
	public void setCfVehicleBrand(String cfVehicleBrand){
		this.cfVehicleBrand=cfVehicleBrand;
	}
	public String getCfVehicleBrand(){
		return cfVehicleBrand;
	}
	public void setCfCurrencyKM(BigDecimal cfCurrencyKM){
		this.cfCurrencyKM=cfCurrencyKM;
	}
	public BigDecimal getCfCurrencyKM(){
		return cfCurrencyKM;
	}
	public void setCfVehicleType(String cfVehicleType){
		this.cfVehicleType=cfVehicleType;
	}
	public String getCfVehicleType(){
		return cfVehicleType;
	}
	public void setCfVehicleUse(String cfVehicleUse){
		this.cfVehicleUse=cfVehicleUse;
	}
	public String getCfVehicleUse(){
		return cfVehicleUse;
	}
	public void setCfDriverID(String cfDriverID){
		this.cfDriverID=cfDriverID;
	}
	public String getCfDriverID(){
		return cfDriverID;
	}
	public void setCfIsBigOrSmallContainer(String cfIsBigOrSmallContainer){
		this.cfIsBigOrSmallContainer=cfIsBigOrSmallContainer;
	}
	public String getCfIsBigOrSmallContainer(){
		return cfIsBigOrSmallContainer;
	}
	public void setCfPlateNumber(String cfPlateNumber){
		this.cfPlateNumber=cfPlateNumber;
	}
	public String getCfPlateNumber(){
		return cfPlateNumber;
	}
	public void setCfStratDate(Date cfStratDate){
		this.cfStratDate=cfStratDate;
	}
	public Date getCfStratDate(){
		return cfStratDate;
	}
	public void setCfMtContentID(String cfMtContentID){
		this.cfMtContentID=cfMtContentID;
	}
	public String getCfMtContentID(){
		return cfMtContentID;
	}
	public void setCfRepairID(String cfRepairID){
		this.cfRepairID=cfRepairID;
	}
	public String getCfRepairID(){
		return cfRepairID;
	}
	public void setCfAmount(BigDecimal cfAmount){
		this.cfAmount=cfAmount;
	}
	public BigDecimal getCfAmount(){
		return cfAmount;
	}
	public void setCfMtUnitID(String cfMtUnitID){
		this.cfMtUnitID=cfMtUnitID;
	}
	public String getCfMtUnitID(){
		return cfMtUnitID;
	}
	public void setCfMtType(String cfMtType){
		this.cfMtType=cfMtType;
	}
	public String getCfMtType(){
		return cfMtType;
	}
	public void setCfMtCategory(String cfMtCategory){
		this.cfMtCategory=cfMtCategory;
	}
	public String getCfMtCategory(){
		return cfMtCategory;
	}
	public void setCfMtStartDate(Date cfMtStartDate){
		this.cfMtStartDate=cfMtStartDate;
	}
	public Date getCfMtStartDate(){
		return cfMtStartDate;
	}
	public void setCfMtEndDate(Date cfMtEndDate){
		this.cfMtEndDate=cfMtEndDate;
	}
	public Date getCfMtEndDate(){
		return cfMtEndDate;
	}
	public void setCfMtFactoryID(String cfMtFactoryID){
		this.cfMtFactoryID=cfMtFactoryID;
	}
	public String getCfMtFactoryID(){
		return cfMtFactoryID;
	}
	public void setCfMtTel(String cfMtTel){
		this.cfMtTel=cfMtTel;
	}
	public String getCfMtTel(){
		return cfMtTel;
	}
	public void setCfForkliftNumberID(String cfForkliftNumberID){
		this.cfForkliftNumberID=cfForkliftNumberID;
	}
	public String getCfForkliftNumberID(){
		return cfForkliftNumberID;
	}
	public void setCfForkliftModels(String cfForkliftModels){
		this.cfForkliftModels=cfForkliftModels;
	}
	public String getCfForkliftModels(){
		return cfForkliftModels;
	}
	public void setCfForkliftBrand(String cfForkliftBrand){
		this.cfForkliftBrand=cfForkliftBrand;
	}
	public String getCfForkliftBrand(){
		return cfForkliftBrand;
	}
	public void setCfModels(String cfModels){
		this.cfModels=cfModels;
	}
	public String getCfModels(){
		return cfModels;
	}
	public void setCfMaterialCostTotal(BigDecimal cfMaterialCostTotal){
		this.cfMaterialCostTotal=cfMaterialCostTotal;
	}
	public BigDecimal getCfMaterialCostTotal(){
		return cfMaterialCostTotal;
	}
	public void setCfWorkTimeCostTotal(BigDecimal cfWorkTimeCostTotal){
		this.cfWorkTimeCostTotal=cfWorkTimeCostTotal;
	}
	public BigDecimal getCfWorkTimeCostTotal(){
		return cfWorkTimeCostTotal;
	}
	public void setCfMtCostTotal(BigDecimal cfMtCostTotal){
		this.cfMtCostTotal=cfMtCostTotal;
	}
	public BigDecimal getCfMtCostTotal(){
		return cfMtCostTotal;
	}
	public void setCfAssetsIdID(String cfAssetsIdID){
		this.cfAssetsIdID=cfAssetsIdID;
	}
	public String getCfAssetsIdID(){
		return cfAssetsIdID;
	}
	public void setCfBilllState(String cfBilllState){
		this.cfBilllState=cfBilllState;
	}
	public String getCfBilllState(){
		return cfBilllState;
	}
	public void setCfMaintenancePlotI(String cfMaintenancePlotI){
		this.cfMaintenancePlotI=cfMaintenancePlotI;
	}
	public String getCfMaintenancePlotI(){
		return cfMaintenancePlotI;
	}
	public void setCfperiodSeq(Long cfperiodSeq){
		this.cfperiodSeq=cfperiodSeq;
	}
	public Long getCfperiodSeq(){
		return cfperiodSeq;
	}
	public void setCfCarAccidentID(String cfCarAccidentID){
		this.cfCarAccidentID=cfCarAccidentID;
	}
	public String getCfCarAccidentID(){
		return cfCarAccidentID;
	}
	public void setCfplonEntryId(String cfplonEntryId){
		this.cfplonEntryId=cfplonEntryId;
	}
	public String getCfplonEntryId(){
		return cfplonEntryId;
	}
	public void setCflastTimeMainten(Date cflastTimeMainten){
		this.cflastTimeMainten=cflastTimeMainten;
	}
	public Date getCflastTimeMainten(){
		return cflastTimeMainten;
	}
	public void setCfMgmtDeptID(String cfMgmtDeptID){
		this.cfMgmtDeptID=cfMgmtDeptID;
	}
	public String getCfMgmtDeptID(){
		return cfMgmtDeptID;
	}
	public void setCfMtUnitCu(String cfMtUnitCu){
		this.cfMtUnitCu=cfMtUnitCu;
	}
	public String getCfMtUnitCu(){
		return cfMtUnitCu;
	}
	public void setCfmanufacturer(String cfmanufacturer){
		this.cfmanufacturer=cfmanufacturer;
	}
	public String getCfmanufacturer(){
		return cfmanufacturer;
	}
	public void setCfcooperation(Long cfcooperation){
		this.cfcooperation=cfcooperation;
	}
	public Long getCfcooperation(){
		return cfcooperation;
	}
	public void setCfcontent(String cfcontent){
		this.cfcontent=cfcontent;
	}
	public String getCfcontent(){
		return cfcontent;
	}
	public void setCfrepairsTime(Date cfrepairsTime){
		this.cfrepairsTime=cfrepairsTime;
	}
	public Date getCfrepairsTime(){
		return cfrepairsTime;
	}
	public void setCffeeOwnerDept(String cffeeOwnerDept){
		this.cffeeOwnerDept=cffeeOwnerDept;
	}
	public String getCffeeOwnerDept(){
		return cffeeOwnerDept;
	}
	public void setCfIsSupPay(Long cfIsSupPay){
		this.cfIsSupPay=cfIsSupPay;
	}
	public Long getCfIsSupPay(){
		return cfIsSupPay;
	}
	/**
	 * @return the cfContainerNo
	 */
	public String getCfContainerNo() {
		return cfContainerNo;
	}
	/**
	 * @param cfContainerNo the cfContainerNo to set
	 */
	public void setCfContainerNo(String cfContainerNo) {
		this.cfContainerNo = cfContainerNo;
	}
	
}

