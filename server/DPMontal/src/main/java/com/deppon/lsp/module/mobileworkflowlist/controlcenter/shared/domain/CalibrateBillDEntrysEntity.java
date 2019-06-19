package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;
/**
 * 
 * 定标单供应商报价明细分录实体
 * 
 * 
 * @author wangmingzhao
 * @date 2014-2-25 下午3:06:08
 * @since
 * @version
 */
public class CalibrateBillDEntrysEntity extends BaseEntity {

	/**
	 * 序列 
	 */  	 
	private static final long serialVersionUID = 4019407457943679002L;
	/**
	 * 供应商编码
	 */
	private String supplierNumber;
	/**
	 * 供应商名称
	 */
	private String supplierName;
	/**
	 * 单价
	 */
	private double price;
	/**
	 * 物品明细分录ID
	 */
	private String parentId;
	/**
	 *
	 * @return the supplierNumber
	 *
	 */
	public String getSupplierNumber() {
		return supplierNumber;
	}
	/**
	 *
	 * @param supplierNumber the supplierNumber to set
	 *
	 */
	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}
	/**
	 *
	 * @return the supplierName
	 *
	 */
	public String getSupplierName() {
		return supplierName;
	}
	/**
	 *
	 * @param supplierName the supplierName to set
	 *
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	/**
	 *
	 * @return the price
	 *
	 */
	public double getPrice() {
		return price;
	}
	/**
	 *
	 * @param price the price to set
	 *
	 */
	public void setPrice(double price) {
		this.price = price;
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
