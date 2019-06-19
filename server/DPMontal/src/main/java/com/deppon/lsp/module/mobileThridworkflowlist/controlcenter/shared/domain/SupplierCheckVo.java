package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.util.List;

public class SupplierCheckVo {
	//供应商审核单表头信息
		private SupplierCheckEntity supplierCheckEntity;
		//供应商审核单分录信息
		private List<SupplierCheckBillEntity> supplierCheckEntryList;
		public SupplierCheckEntity getSupplierCheckEntity() {
			return supplierCheckEntity;
		}
		public void setSupplierCheckEntity(SupplierCheckEntity supplierCheckEntity) {
			this.supplierCheckEntity = supplierCheckEntity;
		}
		public List<SupplierCheckBillEntity> getSupplierCheckEntryList() {
			return supplierCheckEntryList;
		}
		public void setSupplierCheckEntryList(
				List<SupplierCheckBillEntity> supplierCheckEntryList) {
			this.supplierCheckEntryList = supplierCheckEntryList;
		}
}
