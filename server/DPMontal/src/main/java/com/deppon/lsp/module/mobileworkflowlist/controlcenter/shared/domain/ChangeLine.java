/**   
* @Title: ChangeLine.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 徐丁钉   
* @date 2013-11-4 下午6:12:51  
*/
package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.montal.util.FormatUtil;

/** 
 * @ClassName: ChangeLine 
 * @Description: TODO(变更明细实体) 
 * @author 徐丁钉
 * @date 2013-11-4 下午6:12:51 
 *  
 */
public class ChangeLine  extends BaseEntity{
	  /** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;

	//单据id
	  private String fId;     
	  
	  private long fSeq; 
	  
	  private String fParentId; 
	  
	  private long cfSeq;  
	  //施工区域
	  private String cfConstructAreaId;
	  //施工区域
	  private String cfConstructAreaName;
	  //费用名称（工程项目）
	  private String cfCostNameId;  
	  //费用名称（工程项目）
	  private String cfCostName; 
	  //预计耗损率%
	  private String cfPredictLoss; 
	  //品牌、规格、型号
	  private String cfStandard;
	  //	备注
	  private String cfRemark;  
	  //是否增项
	  private String cfGivea;  
	  //增项时间
	  private Date cfGiveaTime;  
	  //是否甲供
	  private String cfArmorfor; 
	  //单位
	  private String fUnitId; 
	  private String fUnitName;
	  //	定标数量
	  private String fCaliAmount;  
	  //合同损耗率
	  private String fContractLoss;
	  //应用阶段计划
	  private String fPlansTage; 
	  private String fPlansTageName;
	  private long cfUnitPricePe;    
	  private long cfUnitPriceMe;    
	  //数量
	  private long cfAmount;
	  
	  
	  
	  
/************************getter/setter************************************/
	
	  
	/**
	 * @return the fId
	 */
	public String getfId() {
		return fId;
	}
	/**
	 * @param fId the fId to set
	 */
	public void setfId(String fId) {
		this.fId = fId;
	}
	/**
	 * @return the fSeq
	 */
	public long getfSeq() {
		return fSeq;
	}
	/**
	 * @param fSeq the fSeq to set
	 */
	public void setfSeq(long fSeq) {
		this.fSeq = fSeq;
	}
	/**
	 * @return the fParentId
	 */
	public String getfParentId() {
		return fParentId;
	}
	/**
	 * @param fParentId the fParentId to set
	 */
	public void setfParentId(String fParentId) {
		this.fParentId = fParentId;
	}
	/**
	 * @return the cfSeq
	 */
	public long getCfSeq() {
		return cfSeq;
	}
	/**
	 * @param cfSeq the cfSeq to set
	 */
	public void setCfSeq(long cfSeq) {
		this.cfSeq = cfSeq;
	}
	/**
	 * @return the cfConstructAreaId
	 */
	public String getCfConstructAreaId() {
		return cfConstructAreaId;
	}
	/**
	 * @param cfConstructAreaId the cfConstructAreaId to set
	 */
	public void setCfConstructAreaId(String cfConstructAreaId) {
		this.cfConstructAreaId = cfConstructAreaId;
	}
	/**
	 * @return the cfConstructAreaName
	 */
	public String getCfConstructAreaName() {
		if (cfConstructAreaName == null) {
			cfConstructAreaName = "";
		}
		return cfConstructAreaName;
	}
	/**
	 * @param cfConstructAreaName the cfConstructAreaName to set
	 */
	public void setCfConstructAreaName(String cfConstructAreaName) {
		this.cfConstructAreaName = cfConstructAreaName;
	}
	/**
	 * @return the cfCostNameId
	 */
	public String getCfCostNameId() {
		return cfCostNameId;
	}
	/**
	 * @param cfCostNameId the cfCostNameId to set
	 */
	public void setCfCostNameId(String cfCostNameId) {
		this.cfCostNameId = cfCostNameId;
	}
	
	/**
	 * @return the cfCostName
	 */
	public String getCfCostName() {
		if (cfCostName == null) {
			cfCostName = "";
		}
		return cfCostName;
	}
	/**
	 * @param cfCostName the cfCostName to set
	 */
	public void setCfCostName(String cfCostName) {
		this.cfCostName = cfCostName;
	}
	/**
	 * @return the cfPredictLoss
	 */
	public String getCfPredictLoss() {
		if (cfPredictLoss == null) {
			cfPredictLoss = "";
		}
		return cfPredictLoss;
	}
	/**
	 * @param cfPredictLoss the cfPredictLoss to set
	 */
	public void setCfPredictLoss(String cfPredictLoss) {
		this.cfPredictLoss = cfPredictLoss;
	}
	/**
	 * @return the cfStandard
	 */
	public String getCfStandard() {
		if (cfStandard == null){
			cfStandard = "";
		}
		return cfStandard;
	}
	/**
	 * @param cfStandard the cfStandard to set
	 */
	public void setCfStandard(String cfStandard) {
		this.cfStandard = cfStandard;
	}
	/**
	 * @return the cfRemark
	 */
	public String getCfRemark() {
		if (cfRemark == null) {
			cfRemark = "";
		}
		return cfRemark;
	}
	/**
	 * @param cfRemark the cfRemark to set
	 */
	public void setCfRemark(String cfRemark) {
		this.cfRemark = cfRemark;
	}
	/**
	 * @return the cfGivea
	 */
	public String getCfGivea() {
		if (cfGivea == null){
			cfGivea = "";
		}
		return cfGivea;
	}
	/**
	 * @param cfGivea the cfGivea to set
	 */
	public void setCfGivea(String cfGivea) {
		this.cfGivea = cfGivea;
	}
	/**
	 * @return the cfGiveaTime
	 */
	public Date getCfGiveaTime() {
		return cfGiveaTime;
	}
	
	public String getCfGiveaTimeStr() {
		return FormatUtil.formatDate(cfGiveaTime,"yyyy-MM-dd");
	}
	/**
	 * @param cfGiveaTime the cfGiveaTime to set
	 */
	public void setCfGiveaTime(Date cfGiveaTime) {
		this.cfGiveaTime = cfGiveaTime;
	}
	/**
	 * @return the cfArmorfor
	 */
	public String getCfArmorfor() {
		if (cfArmorfor == null) {
			cfArmorfor = "";
		}
		return cfArmorfor;
	}
	/**
	 * @param cfArmorfor the cfArmorfor to set
	 */
	public void setCfArmorfor(String cfArmorfor) {
		this.cfArmorfor = cfArmorfor;
	}
	/**
	 * @return the fUnitId
	 */
	public String getfUnitId() {
		return fUnitId;
	}
	/**
	 * @param fUnitId the fUnitId to set
	 */
	public void setfUnitId(String fUnitId) {
		this.fUnitId = fUnitId;
	}
	/**
	 * @return the fCaliAmount
	 */
	public String getfCaliAmount() {
		if (fCaliAmount == null) {
			fCaliAmount = "";
		}
		return fCaliAmount;
	}
	/**
	 * @param fCaliAmount the fCaliAmount to set
	 */
	public void setfCaliAmount(String fCaliAmount) {
		this.fCaliAmount = fCaliAmount;
	}
	/**
	 * @return the fContractLoss
	 */
	public String getfContractLoss() {
		if (fContractLoss == null) {
			fContractLoss = "";
		}
		return fContractLoss;
	}
	/**
	 * @param fContractLoss the fContractLoss to set
	 */
	public void setfContractLoss(String fContractLoss) {
		this.fContractLoss = fContractLoss;
	}
	/**
	 * @return the fPlansTage
	 */
	public String getfPlansTage() {
		if (fPlansTage == null) {
			fPlansTage = "";
		}
		return fPlansTage;
	}
	/**
	 * @param fPlansTage the fPlansTage to set
	 */
	public void setfPlansTage(String fPlansTage) {
		this.fPlansTage = fPlansTage;
	}
	/**
	 * @return the cfUnitPricePe
	 */
	public long getCfUnitPricePe() {
		return cfUnitPricePe;
	}
	/**
	 * @param cfUnitPricePe the cfUnitPricePe to set
	 */
	public void setCfUnitPricePe(long cfUnitPricePe) {
		this.cfUnitPricePe = cfUnitPricePe;
	}
	/**
	 * @return the cfUnitPriceMe
	 */
	public long getCfUnitPriceMe() {
		return cfUnitPriceMe;
	}
	/**
	 * @param cfUnitPriceMe the cfUnitPriceMe to set
	 */
	public void setCfUnitPriceMe(long cfUnitPriceMe) {
		this.cfUnitPriceMe = cfUnitPriceMe;
	}
	/**
	 * @return the cfAmount
	 */
	public long getCfAmount() {
		return cfAmount;
	}
	/**
	 * @param cfAmount the cfAmount to set
	 */
	public void setCfAmount(long cfAmount) {
		this.cfAmount = cfAmount;
	}
	/**
	 * @return the fUnitName
	 */
	public String getfUnitName() {
		if (fUnitName == null) {
			fUnitName = "";
		}
		return fUnitName;
	}
	/**
	 * @param fUnitName the fUnitName to set
	 */
	public void setfUnitName(String fUnitName) {
		this.fUnitName = fUnitName;
	}
	/**
	 * @return the fPlansTageName
	 */
	public String getfPlansTageName() {
		return fPlansTageName;
	}
	/**
	 * @param fPlansTageName the fPlansTageName to set
	 */
	public void setfPlansTageName(String fPlansTageName) {
		this.fPlansTageName = fPlansTageName;
	}
	  
}
