package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.montal.util.FormatUtil;
/**
 * 维修申请单分录明细实体
 * @author wangmingzhao
 * @date 2013-9-2 下午1:55:17
 * @since
 * @version
 */
public class MaintenRequestEntryEntity extends BaseEntity{
    
	private static final long serialVersionUID = -2820940053683966199L;

    //序号
    private Long seq;

    //表头ID
    private String parentId;

    //维修类别
    private MtypeEntity repairType;
    //维修类别ID
    private String repairTypeId;

    //维修事项
    private RepairMatterEntity repairMatter;
    //维修事项ID
    private String repairMatterId;
    
    //维修区域
    private MareaEntity repairArea;
    //维修区域ID
    private String repairAreaId;

    //损坏原因
    private String damageReason;

    //期望维修时间
    private Date expRepairTime;
    //维修性质
    private String maintenanceNature;
	//质保期
	private String warrantyDate;

    /**
     * @return 序号
    */
	public Long getSeq() {
		return seq;
	}
	public String getSeqStr() {
		if (seq == null){
			return "";
		}
		return seq + "";
	}
	/**
     * @param 序号
    */
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	/**
     * @return 表头ID
    */
	public String getParentId() {
		return parentId;
	}
	/**
     * @param 表头ID
    */
	public void setParentId(String parentId) {
		this.parentId = parentId==null?null:parentId.trim();
	}
	/**
     * @return 维修类型
    */
	public MtypeEntity getRepairType() {
		if (repairType == null) {
			repairType = new MtypeEntity();
		}
		return repairType;
	}
	/**
     * @param 维修类型
    */
	public void setRepairType(MtypeEntity repairType) {
		this.repairType = repairType;
	}
	/**
     * @return 维修事项
    */
	public RepairMatterEntity getRepairMatter() {
		if (repairMatter == null) {
			repairMatter = new RepairMatterEntity();
		}
		return repairMatter;
	}
	/**
     * @param 维修事项
    */
	public void setRepairMatter(RepairMatterEntity repairMatter) {
		this.repairMatter = repairMatter;
	}
	/**
     * @return 维修区域
    */
	public MareaEntity getRepairArea() {
		if (repairArea == null) {
			repairArea = new MareaEntity();
		}
		return repairArea;
	}
	/**
     * @param 维修区域
    */
	public void setRepairArea(MareaEntity repairArea) {
		this.repairArea = repairArea;
	}
	/**
     * @return 损坏原因
    */
	public String getDamageReason() {
		if (damageReason == null) {
			damageReason ="";
		}
		return damageReason;
	}
	/**
     * @param 损坏原因
    */
	public void setDamageReason(String damageReason) {
		this.damageReason = damageReason==null?null:damageReason.trim();
	}
	/**
     * @return 预计维修时间
    */
	public Date getExpRepairTime() {
		return expRepairTime;
	}
	
	public String getExpRepairTimeStr() {
		return FormatUtil.formatDate(expRepairTime, "yyyy-MM-dd");
	}

	/**
     * @param 预计维修时间
    */
	public void setExpRepairTime(Date expRepairTime) {
		this.expRepairTime = expRepairTime;
	}
	/**
     * @return 维修性质
    */
	public String getMaintenanceNature() {
		if (maintenanceNature == null) {
			maintenanceNature = "";
		}
		return maintenanceNature;
	}
	/**
     * @param 维修性质
    */
	public void setMaintenanceNature(String maintenanceNature) {
		this.maintenanceNature = maintenanceNature==null ? "": maintenanceNature.trim();
	}
	/**
     * @return 维修类别ID
    */
	public String getRepairTypeId() {
		return repairTypeId;
	}
	/**
     * @param 维修类别ID
    */
	public void setRepairTypeId(String repairTypeId) {
		this.repairTypeId = repairTypeId==null?null:repairTypeId.trim();
	}
	/**
     * @return 维修事项ID
    */
	public String getRepairMatterId() {
		return repairMatterId;
	}
	/**
     * @param 维修事项ID
    */
	public void setRepairMatterId(String repairMatterId) {
		this.repairMatterId = repairMatterId==null?null:repairMatterId.trim();
	}
	/**
     * @return 维修区域ID
    */
	public String getRepairAreaId() {
		return repairAreaId;
	}
	/**
     * @param 维修区域ID
    */
	public void setRepairAreaId(String repairAreaId) {
		this.repairAreaId = repairAreaId==null?null:repairAreaId.trim();
	}
	/**
	 * @return the warrantyDate
	 */
	public String getWarrantyDate() {
		return warrantyDate;
	}
	/**
	 * @param warrantyDate the warrantyDate to set
	 */
	public void setWarrantyDate(String warrantyDate) {
		this.warrantyDate = warrantyDate;
	}

   
}