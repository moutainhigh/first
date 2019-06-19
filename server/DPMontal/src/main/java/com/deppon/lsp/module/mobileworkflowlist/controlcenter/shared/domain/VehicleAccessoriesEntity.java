/**
 * 
 */
package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 作者：刘长鸣-综合系统开发
 * 编写时间：2014年3月7日
 * 描述：分录车辆附件
 * 更新记录：
 */
public class VehicleAccessoriesEntity extends BaseEntity{

	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = -1453307503944372126L;

	//车辆附件
	private String vehicleAccessory;
	
	//是否变卖
	private Boolean isSell;

	/**
	 * @return the vehicleAccessory
	 */
	public String getVehicleAccessory() {
		if (vehicleAccessory == null) {
			vehicleAccessory = "";
		}
		return vehicleAccessory;
	}


	/**
	 * @param vehicleAccessory the vehicleAccessory to set
	 */
	public void setVehicleAccessory(String vehicleAccessory) {
		this.vehicleAccessory = vehicleAccessory;
	}


	/**
	 * @return the isSell
	 */
	public Boolean getIsSell() {
		return isSell;
	}

	public String getIsSellStr() {
		if (isSell == null) {
			return "";
		}
		if (isSell) {
			return "是";
		}else{
			return "否";
		}
	}

	/**
	 * @param isSell the isSell to set
	 */
	public void setIsSell(Boolean isSell) {
		this.isSell = isSell;
	}

	/**
	 * 作者：刘长鸣-综合系统开发
	 * 编写时间：2014年3月7日
	 * 描述：重写toString方法
	 */
	@Override
	public String toString() {
		return "VehicleAccessoriesEntity [vehicleAccessory=" + vehicleAccessory
				+ ", isSell=" + isSell + "]";
	}

}
