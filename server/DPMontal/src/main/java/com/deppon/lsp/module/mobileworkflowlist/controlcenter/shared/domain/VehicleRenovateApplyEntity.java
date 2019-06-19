package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.montal.util.FormatUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class VehicleRenovateApplyEntity.
 */
public class VehicleRenovateApplyEntity extends BaseEntity{

	/** 生成随即序列化id. */
	private static final long serialVersionUID = -9118612300410429700L;
	
	//单据编号
	/** The fnumber. */
	private String fnumber;
	
	//车牌号
	/** The plate number. */
	private String plateNumber;
	
	//车牌号id
	/** The cfplatenumberid. */
	private String cfplatenumberid;
	
	//资产所属子公司
	/** The affiliation company. */
	private String affiliationCompany;
	
	//所属办公室
	/** The affiliation office. */
	private String affiliationOffice;
	
	//所属办公室id
	/** The cfaffiliationoffic. */
	private String cfaffiliationoffic;

	//车型
	/** The vehicle type. */
	private String vehicleType;
		
	//固定资产编码
	/** The fixed assets. */
	private String fixedAssets;

	//车辆品牌
	/** The vehicle brand. */
	private String vehicleBrand;
	
	//吨位
	/** The tonnage. */
	private String tonnage;
	
	//开始使用日期
	/** The starte use time. */
	private Date starteUseTime;
	
	//申请部门
	/** The product department. */
	private String productDepartment;
	
	//申请部门id
	/** The cfproductdepartmen. */
	private String cfproductdepartmen;

	//判定结果
	/** The result. */
	private String result;
		
	//使用部门所属子公司
	/** The using finance. */
	private String usingFinance;
	
	//使用部门所属子公司id
	/** The cfusingfinance. */
	private String cfusingfinance;
	
	//申请事由
	/** The description. */
	private String description;

	/** 审批时反写状态时，用到的字段. */
	//单据id
	private String fid;

	//状态
	/** The cfbillstate. */
	private String cfbillstate;
	
	//审核人
	/** The fauditorid. */
	private String fauditorid;
	
	//审核时间
	/** The fbizdate. */
	private Date fbizdate; 
	
	/**
	 * Gets the fnumber.
	 *
	 * @return the fnumber
	 */
	public String getFnumber() {
		if (fnumber == null) {
			fnumber = "";
		}
		return fnumber;
	}

	/**
	 * Sets the fnumber.
	 *
	 * @param fnumber the fnumber to set
	 */
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}

	/**
	 * Gets the plate number.
	 *
	 * @return the plateNumber
	 */
	public String getPlateNumber() {
		if (plateNumber == null){
			plateNumber = "";
		}
		return plateNumber;
	}

	/**
	 * Sets the plate number.
	 *
	 * @param plateNumber the plateNumber to set
	 */
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	/**
	 * Gets the cfplatenumberid.
	 *
	 * @return the cfplatenumberid
	 */
	public String getCfplatenumberid() {
		return cfplatenumberid;
	}

	/**
	 * Sets the cfplatenumberid.
	 *
	 * @param cfplatenumberid the cfplatenumberid to set
	 */
	public void setCfplatenumberid(String cfplatenumberid) {
		this.cfplatenumberid = cfplatenumberid;
	}

	/**
	 * Gets the affiliation company.
	 *
	 * @return the affiliationCompany
	 */
	public String getAffiliationCompany() {
		if (affiliationCompany == null) {
			affiliationCompany = "";
		}
		return affiliationCompany;
	}

	/**
	 * Sets the affiliation company.
	 *
	 * @param affiliationCompany the affiliationCompany to set
	 */
	public void setAffiliationCompany(String affiliationCompany) {
		this.affiliationCompany = affiliationCompany;
	}

	/**
	 * Gets the affiliation office.
	 *
	 * @return the affiliationOffice
	 */
	public String getAffiliationOffice() {
		if (affiliationOffice == null) {
			affiliationOffice = "";
		}
		return affiliationOffice;
	}

	/**
	 * Sets the affiliation office.
	 *
	 * @param affiliationOffice the affiliationOffice to set
	 */
	public void setAffiliationOffice(String affiliationOffice) {
		this.affiliationOffice = affiliationOffice;
	}

	/**
	 * Gets the cfaffiliationoffic.
	 *
	 * @return the cfaffiliationoffic
	 */
	public String getCfaffiliationoffic() {
		return cfaffiliationoffic;
	}

	/**
	 * Sets the cfaffiliationoffic.
	 *
	 * @param cfaffiliationoffic the cfaffiliationoffic to set
	 */
	public void setCfaffiliationoffic(String cfaffiliationoffic) {
		this.cfaffiliationoffic = cfaffiliationoffic;
	}

	/**
	 * Gets the vehicle type.
	 *
	 * @return the vehicleType
	 */
	public String getVehicleType() {
		if (vehicleType == null) {
			vehicleType = "";
		}
		return vehicleType;
	}

	/**
	 * Sets the vehicle type.
	 *
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * Gets the fixed assets.
	 *
	 * @return the fixedAssets
	 */
	public String getFixedAssets() {
		if (fixedAssets == null) {
			fixedAssets = "";
		}
		return fixedAssets;
	}

	/**
	 * Sets the fixed assets.
	 *
	 * @param fixedAssets the fixedAssets to set
	 */
	public void setFixedAssets(String fixedAssets) {
		this.fixedAssets = fixedAssets;
	}

	/**
	 * Gets the vehicle brand.
	 *
	 * @return the vehicleBrand
	 */
	public String getVehicleBrand() {
		if (vehicleBrand == null) {
			vehicleBrand = "";
		}
		return vehicleBrand;
	}

	/**
	 * Sets the vehicle brand.
	 *
	 * @param vehicleBrand the vehicleBrand to set
	 */
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	/**
	 * Gets the tonnage.
	 *
	 * @return the tonnage
	 */
	public String getTonnage() {
		if (tonnage == null) {
			tonnage = "";
		}
		return tonnage;
	}

	/**
	 * Sets the tonnage.
	 *
	 * @param tonnage the tonnage to set
	 */
	public void setTonnage(String tonnage) {
		this.tonnage = tonnage;
	}

	/**
	 * Gets the starte use time.
	 *
	 * @return the starteUseTime
	 */
	public Date getStarteUseTime() {
		return starteUseTime;
	}
	
	/**
	 * Gets the starte use time str.
	 *
	 * @return the starte use time str
	 */
	public String getStarteUseTimeStr() {
		return  FormatUtil.formatDate(starteUseTime,"yyyy-MM-dd");
	}

	/**
	 * Sets the starte use time.
	 *
	 * @param starteUseTime the starteUseTime to set
	 */
	public void setStarteUseTime(Date starteUseTime) {
		this.starteUseTime = starteUseTime;
	}

	/**
	 * Gets the product department.
	 *
	 * @return the productDepartment
	 */
	public String getProductDepartment() {
		if (productDepartment == null) {
			productDepartment = "";
		}
		return productDepartment;
	}

	/**
	 * Sets the product department.
	 *
	 * @param productDepartment the productDepartment to set
	 */
	public void setProductDepartment(String productDepartment) {
		this.productDepartment = productDepartment;
	}

	/**
	 * Gets the cfproductdepartmen.
	 *
	 * @return the cfproductdepartmen
	 */
	public String getCfproductdepartmen() {
		return cfproductdepartmen;
	}

	/**
	 * Sets the cfproductdepartmen.
	 *
	 * @param cfproductdepartmen the cfproductdepartmen to set
	 */
	public void setCfproductdepartmen(String cfproductdepartmen) {
		this.cfproductdepartmen = cfproductdepartmen;
	}

	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public String getResult() {
		if (result == null) {
			result = "";
		}
		return result;
	}

	/**
	 * Sets the result.
	 *
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * Gets the using finance.
	 *
	 * @return the usingFinance
	 */
	public String getUsingFinance() {
		if (usingFinance == null) {
			usingFinance = "";
		}
		return usingFinance;
	}

	/**
	 * Sets the using finance.
	 *
	 * @param usingFinance the usingFinance to set
	 */
	public void setUsingFinance(String usingFinance) {
		this.usingFinance = usingFinance;
	}

	/**
	 * Gets the cfusingfinance.
	 *
	 * @return the cfusingfinance
	 */
	public String getCfusingfinance() {
		return cfusingfinance;
	}

	/**
	 * Sets the cfusingfinance.
	 *
	 * @param cfusingfinance the cfusingfinance to set
	 */
	public void setCfusingfinance(String cfusingfinance) {
		this.cfusingfinance = cfusingfinance;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		if (description == null) {
			description = "";
		}
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the fid.
	 *
	 * @return the fid
	 */
	public String getFid() {
		return fid;
	}

	/**
	 * Sets the fid.
	 *
	 * @param fid the fid to set
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}

	/**
	 * Gets the cfbillstate.
	 *
	 * @return the cfbillstate
	 */
	public String getCfbillstate() {
		return cfbillstate;
	}

	/**
	 * Sets the cfbillstate.
	 *
	 * @param cfbillstate the cfbillstate to set
	 */
	public void setCfbillstate(String cfbillstate) {
		this.cfbillstate = cfbillstate;
	}

	/**
	 * Gets the fauditorid.
	 *
	 * @return the fauditorid
	 */
	public String getFauditorid() {
		return fauditorid;
	}

	/**
	 * Sets the fauditorid.
	 *
	 * @param fauditorid the fauditorid to set
	 */
	public void setFauditorid(String fauditorid) {
		this.fauditorid = fauditorid;
	}

	/**
	 * Gets the fbizdate.
	 *
	 * @return the fbizdate
	 */
	public Date getFbizdate() {
		return fbizdate;
	}

	/**
	 * Sets the fbizdate.
	 *
	 * @param fbizdate the fbizdate to set
	 */
	public void setFbizdate(Date fbizdate) {
		this.fbizdate = fbizdate;
	}

	/**
	 * 作者：刘长鸣-综合系统开发
	 * 编写时间：2014年2月28日
	 * 描述：重写toString().
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "VehicleRenovateApplyEntity [fnumber=" + fnumber
				+ ", plateNumber=" + plateNumber + ", cfplatenumberid="
				+ cfplatenumberid + ", affiliationCompany="
				+ affiliationCompany + ", affiliationOffice="
				+ affiliationOffice + ", cfaffiliationoffic="
				+ cfaffiliationoffic + ", vehicleType=" + vehicleType
				+ ", fixedAssets=" + fixedAssets + ", vehicleBrand="
				+ vehicleBrand + ", tonnage=" + tonnage + ", starteUseTime="
				+ starteUseTime + ", productDepartment=" + productDepartment
				+ ", cfproductdepartmen=" + cfproductdepartmen + ", result="
				+ result + ", usingFinance=" + usingFinance
				+ ", cfusingfinance=" + cfusingfinance + ", description="
				+ description + ", fid=" + fid + ", cfbillstate=" + cfbillstate
				+ ", fauditorid=" + fauditorid + ", fbizdate=" + fbizdate + "]";
	}

}
