package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.util.Map;

public class CalibratebillChangeVo {
	//定标变更单表头信息
	private CalibrateBillChangeEntity calibrateBillChangeEntity;
	//定标变更单物料分类实体
	private CalibrateBillChangeEntryEntity [] materialList;
	//定标变更单供应商报价明细分录实体
	Map<String,CalibrateBillChangeDEntrysEntity[]> supplierPriceMap;
	//定标变更单定标结果信息分录实体
	private Map<String,CalibrateBillChangeThreeEntrysEntity[]> ChangeResultMap;
	//定标变更单评委清单分录实体
	private CalibrateBillChangeFourEntryEntity[] judgePersonList;
	public CalibrateBillChangeEntity getCalibrateBillChangeEntity() {
		return calibrateBillChangeEntity;
	}
	public void setCalibrateBillChangeEntity(
			CalibrateBillChangeEntity calibrateBillChangeEntity) {
		this.calibrateBillChangeEntity = calibrateBillChangeEntity;
	}
	public CalibrateBillChangeEntryEntity[] getMaterialList() {
		if (materialList == null) {
			materialList = new CalibrateBillChangeEntryEntity[0];
		}
		return materialList;
	}
	public void setMaterialList(CalibrateBillChangeEntryEntity[] materialList) {
		this.materialList = materialList;
	}
	public Map<String, CalibrateBillChangeDEntrysEntity[]> getSupplierPriceMap() {
		return supplierPriceMap;
	}
	public void setSupplierPriceMap(
			Map<String, CalibrateBillChangeDEntrysEntity[]> supplierPriceMap) {
		this.supplierPriceMap = supplierPriceMap;
	}
	public Map<String, CalibrateBillChangeThreeEntrysEntity[]> getChangeResultMap() {
		return ChangeResultMap;
	}
	public void setChangeResultMap(
			Map<String, CalibrateBillChangeThreeEntrysEntity[]> changeResultMap) {
		ChangeResultMap = changeResultMap;
	}
	public CalibrateBillChangeFourEntryEntity[] getJudgePersonList() {
		if (judgePersonList == null) {
			judgePersonList = new CalibrateBillChangeFourEntryEntity[0];
		}
		return judgePersonList;
	}
	public void setJudgePersonList(
			CalibrateBillChangeFourEntryEntity[] judgePersonList) {
		this.judgePersonList = judgePersonList;
	} 
}
