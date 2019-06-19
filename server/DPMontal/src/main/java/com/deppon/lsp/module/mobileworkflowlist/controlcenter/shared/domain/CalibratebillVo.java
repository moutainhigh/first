package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.util.Map;


public class CalibratebillVo {
		//定标单表头信息
		private CalibrateBillEntity calibrateBillEntity;
		//定标单物料分录
		private CalibrateBillEntryEntity[] materialEntryList;
		//定标单供应商报价明细分录
		private Map<String,CalibrateBillDEntrysEntity[]> supplierPriceMap;
		//定标单定标结果分录
		private Map<String,CalibrateBillThreeEntrysEntity[]> CalibrateBillResultMap;
		//定标单评委信息分录
		private CalibrateBillFourEntryEntity[] judgePersonList;
		
		public CalibrateBillEntity getCalibrateBillEntity() {
			return calibrateBillEntity;
		}
		public void setCalibrateBillEntity(CalibrateBillEntity calibrateBillEntity) {
			this.calibrateBillEntity = calibrateBillEntity;
		}
		public CalibrateBillEntryEntity[] getMaterialEntryList() {
			if (materialEntryList == null) {
				materialEntryList = new CalibrateBillEntryEntity[0];
			}
			return materialEntryList;
		}
		public void setMaterialEntryList(CalibrateBillEntryEntity[] materialEntryList) {
			this.materialEntryList = materialEntryList;
		}
		public CalibrateBillFourEntryEntity[] getJudgePersonList() {
			if (judgePersonList == null) {
				judgePersonList = new CalibrateBillFourEntryEntity[0];
			}
			return judgePersonList;
		}
		public void setJudgePersonList(CalibrateBillFourEntryEntity[] judgePersonList) {
			this.judgePersonList = judgePersonList;
		}
		public Map<String, CalibrateBillDEntrysEntity[]> getSupplierPriceMap() {
			return supplierPriceMap;
		}
		public void setSupplierPriceMap(
				Map<String, CalibrateBillDEntrysEntity[]> supplierPriceMap) {
			this.supplierPriceMap = supplierPriceMap;
		}
		public Map<String, CalibrateBillThreeEntrysEntity[]> getCalibrateBillResultMap() {
			return CalibrateBillResultMap;
		}
		public void setCalibrateBillResultMap(
				Map<String, CalibrateBillThreeEntrysEntity[]> calibrateBillResultMap) {
			CalibrateBillResultMap = calibrateBillResultMap;
		}
		
}
