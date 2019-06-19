package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.util.List;

/**
 * 
 * TODO 维修结算单 VO对象
 * <p style="display:none">modifyRecord</p>
 * <p style="display:none">version:V1.0,author:198759,date:2014-8-1 下午4:48:06,content:TODO </p>
 * @author 198759 <a href='daizhiqing@deppon.com'>戴智青</a> 
 * @date 2014-8-1 下午4:48:06
 * @since
 * @version
 */
public class ProjectRepairVo {

	//维修结算单表头信息
	private RepairSettlementEntity repairSettlementEntity;
	//维修结算单分录实体
	private List<RepairSettlementEntryEntity>  repairSettlementEntryEntities;

	public RepairSettlementEntity getRepairSettlementEntity() {
		return repairSettlementEntity;
	}

	public void setRepairSettlementEntity(
			RepairSettlementEntity repairSettlementEntity) {
		this.repairSettlementEntity = repairSettlementEntity;
	}

	public List<RepairSettlementEntryEntity> getRepairSettlementEntryEntities() {
		return repairSettlementEntryEntities;
	}

	public void setRepairSettlementEntryEntities(
			List<RepairSettlementEntryEntity> repairSettlementEntryEntities) {
		this.repairSettlementEntryEntities = repairSettlementEntryEntities;
	}
}
