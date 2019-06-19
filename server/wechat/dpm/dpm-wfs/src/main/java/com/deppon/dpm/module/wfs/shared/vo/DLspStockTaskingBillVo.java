package com.deppon.dpm.module.wfs.shared.vo;

/**
 * 固定资产盘点单明细详情
 */

public class DLspStockTaskingBillVo {
     private String barCode;//管理编码
     private String assetNum;//资产编码
     private String assetCatName;//资产名称
     private String stockStatus;//盘点状态
     private String description;//备注
	/**
	 * @return the barCode
	 */
	public String getBarCode() {
		return barCode;
	}
	/**
	 * @param barCode the barCode to set
	 */
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	/**
	 * @return the assetNum
	 */
	public String getAssetNum() {
		return assetNum;
	}
	/**
	 * @param assetNum the assetNum to set
	 */
	public void setAssetNum(String assetNum) {
		this.assetNum = assetNum;
	}
	/**
	 * @return the assetCatName
	 */
	public String getAssetCatName() {
		return assetCatName;
	}
	/**
	 * @param assetCatName the assetCatName to set
	 */
	public void setAssetCatName(String assetCatName) {
		this.assetCatName = assetCatName;
	}
	/**
	 * @return the stockStatus
	 */
	public String getStockStatus() {
		return stockStatus;
	}
	/**
	 * @param stockStatus the stockStatus to set
	 */
	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
