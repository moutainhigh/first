package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @ClassName: StockMedeDto
 * @Description: 备货维护分录显示信息
 * @author 谢飞
 * @date 2013-11-20 下午1:44:20
 * 
 */
public class StockMedeDto extends StockMedeEntity {
	private static final long serialVersionUID = 5013461634471784553L;
	// 物品编码
	private String materialNumber;
	// 物品属性名称
	private String materialAttName;
	// 供应商编码
	private String supplierNumber;
	// 采购合同编号
	private String contractNumber;

	public String getContractNumber() {
		return contractNumber == null ? "" :contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getMaterialNumber() {
		return materialNumber;
	}

	public void setMaterialNumber(String materialNumber) {
		this.materialNumber = materialNumber;
	}

	public String getMaterialAttName() {
		return materialAttName;
	}

	public void setMaterialAttName(String materialAttName) {
		this.materialAttName = materialAttName;
	}

	public String getSupplierNumber() {
		return supplierNumber;
	}

	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}

	/**
	 * 覆盖toString
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
