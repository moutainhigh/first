package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

/**
 * @title: MaintenanceVo 
 * @description： 维修保养单
 * @author： wuyaqing
 * @date： 2014-5-23 上午10:34:04
 */
public class MaintenancebillVo {

	//维修保养单表头信息
	private MaintenanceEntity maintenanceEntity;
	//所需配件（内修）及物品明细分录
	private MaintenanceEntryLEntity[] maintenanceEntryLList;
	//所需配件（外修）及物品明细分录
	private MaintenanceEntryWEntity[] maintenanceEntryWList;
	//内修分录
	private MaintenanceIREntity[] maintenanceIREntity;
	//外修分录
	private MaintenanceMatthewWilderEntity[] maintenanceMatthewWilderList;
	
	public MaintenanceEntity getMaintenanceEntity() {
		return maintenanceEntity;
	}
	public void setMaintenanceEntity(MaintenanceEntity maintenanceEntity) {
		this.maintenanceEntity = maintenanceEntity;
	}
	public MaintenanceEntryLEntity[] getMaintenanceEntryLList() {
		if (maintenanceEntryLList == null) {
			maintenanceEntryLList = new MaintenanceEntryLEntity[0];
		}
		return maintenanceEntryLList;
	}
	public void setMaintenanceEntryLList(
			MaintenanceEntryLEntity[] maintenanceEntryLList) {
		this.maintenanceEntryLList = maintenanceEntryLList;
	}
	public MaintenanceEntryWEntity[] getMaintenanceEntryWList() {
		if (maintenanceEntryWList == null) {
			maintenanceEntryWList = new MaintenanceEntryWEntity[0];
		}
		return maintenanceEntryWList;
	}
	public void setMaintenanceEntryWList(
			MaintenanceEntryWEntity[] maintenanceEntryWList) {
		this.maintenanceEntryWList = maintenanceEntryWList;
	}
	public MaintenanceIREntity[] getMaintenanceIREntity() {
		if (maintenanceIREntity == null) {
			maintenanceIREntity = new MaintenanceIREntity[0];
		}
		return maintenanceIREntity;
	}
	public void setMaintenanceIREntity(MaintenanceIREntity[] maintenanceIREntity) {
		this.maintenanceIREntity = maintenanceIREntity;
	}
	public MaintenanceMatthewWilderEntity[] getMaintenanceMatthewWilderList() {
		if (maintenanceMatthewWilderList == null) {
			maintenanceMatthewWilderList = new MaintenanceMatthewWilderEntity[0];
		}
		return maintenanceMatthewWilderList;
	}
	public void setMaintenanceMatthewWilderList(
			MaintenanceMatthewWilderEntity[] maintenanceMatthewWilderList) {
		this.maintenanceMatthewWilderList = maintenanceMatthewWilderList;
	}
	
}
