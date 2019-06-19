package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;


public class VehicleapplyVo {
	//车辆申请单表头数据
	private SonApplicationNeedsVo sonApplicationNeeds;
	//车辆申请单分录数据
	private SonAneVehicleVo[] sonAneVehicleVoList;
	public SonApplicationNeedsVo getSonApplicationNeeds() {
		return sonApplicationNeeds;
	}
	public void setSonApplicationNeeds(SonApplicationNeedsVo sonApplicationNeeds) {
		this.sonApplicationNeeds = sonApplicationNeeds;
	}
	public SonAneVehicleVo[] getSonAneVehicleVoList() {
		if (sonAneVehicleVoList == null){
			SonAneVehicleVo temp = new SonAneVehicleVo();
			sonAneVehicleVoList = new SonAneVehicleVo[1];
			sonAneVehicleVoList[0] = temp;
		}
		return sonAneVehicleVoList;
	}
	public void setSonAneVehicleVoList(SonAneVehicleVo[] sonAneVehicleVoList) {
		this.sonAneVehicleVoList = sonAneVehicleVoList;
	}
	
}
