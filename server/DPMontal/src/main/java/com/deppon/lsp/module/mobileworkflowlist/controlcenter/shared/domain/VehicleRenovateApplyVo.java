package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.util.ArrayList;
import java.util.List;

import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.TyreInformationEntity;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.VehicleAccessoriesEntity;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.VehicleRenovateApplyEntity;

public class VehicleRenovateApplyVo {
	//轮胎分录信息
	private List<TyreInformationEntity> tyreInformation;
	//分录车辆附件
	private List<VehicleAccessoriesEntity> vehicleAccessories;
	//车辆更新申请单
	private VehicleRenovateApplyEntity vehicleRenovateApply;
	
	
	public List<TyreInformationEntity> getTyreInformation() {
		if (tyreInformation == null) {
			tyreInformation = new ArrayList<TyreInformationEntity>();
		}
		return tyreInformation;
	}
	public void setTyreInformation(List<TyreInformationEntity> tyreInformation) {
		this.tyreInformation = tyreInformation;
	}
	public List<VehicleAccessoriesEntity> getVehicleAccessories() {
		if (vehicleAccessories == null) {
			vehicleAccessories =  new ArrayList<VehicleAccessoriesEntity>();
		}
		return vehicleAccessories;
	}
	public void setVehicleAccessories(
			List<VehicleAccessoriesEntity> vehicleAccessories) {
		this.vehicleAccessories = vehicleAccessories;
	}
	public VehicleRenovateApplyEntity getVehicleRenovateApply() {
		if (vehicleRenovateApply == null) {
			vehicleRenovateApply = new VehicleRenovateApplyEntity();
		}
		return vehicleRenovateApply;
	}
	public void setVehicleRenovateApply(
			VehicleRenovateApplyEntity vehicleRenovateApply) {
		this.vehicleRenovateApply = vehicleRenovateApply;
	}
	
	
}
