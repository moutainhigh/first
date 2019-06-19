package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 * 
 * 定标单物料分类实体
 * 
 * @author wangmingzhao
 * @date 2014-2-25 下午2:39:51
 * @since
 * @version
 */
public class CalibrateBillEntryEntity extends BaseEntity{

	/**
	 * 序列
	 */  	 
	private static final long serialVersionUID = -7195570425946860668L;
	/**
	 * 物品编码
	 */
	private String materialNumber;
	/**
	 * 物品名称
	 */
	private String materialName;
	/**
	 * 物品类型
	 */
	private String materialType;
	/**
	 * 物品规格
	 */
	private String materialModel;
	/**
	 * 数量
	 */
	private double num ;
	/**
	 * 计量单位
	 */
	private String unit;
	/**
	 * 表头ID
	 */
	private String parentId;
	/**
	 *
	 * @return the materialNumber
	 *
	 */
	public String getMaterialNumber() {
		return materialNumber;
	}
	/**
	 *
	 * @param materialNumber the materialNumber to set
	 *
	 */
	public void setMaterialNumber(String materialNumber) {
		this.materialNumber = materialNumber;
	}
	/**
	 *
	 * @return the materialName
	 *
	 */
	public String getMaterialName() {
		return materialName;
	}
	/**
	 *
	 * @param materialName the materialName to set
	 *
	 */
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	/**
	 *
	 * @return the materialType
	 *
	 */
	public String getMaterialType() {
		return materialType;
	}
	/**
	 *
	 * @param materialType the materialType to set
	 *
	 */
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}
	/**
	 *
	 * @return the materialModel
	 *
	 */
	public String getMaterialModel() {
		return materialModel;
	}
	/**
	 *
	 * @param materialModel the materialModel to set
	 *
	 */
	public void setMaterialModel(String materialModel) {
		this.materialModel = materialModel;
	}
	/**
	 *
	 * @return the num
	 *
	 */
	public double getNum() {
		return num;
	}
	/**
	 *
	 * @param num the num to set
	 *
	 */
	public void setNum(double num) {
		this.num = num;
	}
	/**
	 *
	 * @return the unit
	 *
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 *
	 * @param unit the unit to set
	 *
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 *
	 * @return the parentId
	 *
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 *
	 * @param parentId the parentId to set
	 *
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	
	
}
