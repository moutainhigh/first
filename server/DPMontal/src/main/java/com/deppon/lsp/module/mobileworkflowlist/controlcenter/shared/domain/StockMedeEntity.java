package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 * @ClassName: StockMedeEntity
 * @Description: 备货维护分录实体
 * @author 谢飞
 * @date 2013-11-20 上午9:51:39
 * 
 */
public class StockMedeEntity extends BaseEntity {
	private static final long serialVersionUID = -3225399684917248908L;
	// 序列
	private Long fseq;
	// 表头ID
	private String parentId;
	// 物品编码
	private String materialNumberId;
	// 物品名称
	private String materialName;
	// 物品类型
	private String materialType;
	// 物品规格
	private String materialStandard;
	// 备货数量
	private BigDecimal stockAmount;
	// 备货配比是否按合同约定
	private Integer isContractRatio;
	// 采购合同编号
	private String contractNumberId;
	// 备货单价
	private BigDecimal stockPrice;
	// 备货总金额
	private BigDecimal stockAmounts;
	// 配额类型
	private String quotaType;
	// 配额说明
	private String quotaExplain;
	// 包装方式
	private String packWay;
	// 预计交货时间
	private Date deliveryTime;
	// 供应商编码
	private String supplierNumberId;
	// 供应商名称
	private String supplierName;
	// 配货配额
	private String stockQuota;
	// 物料属性
	private String materialAttId;

	public BigDecimal getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(BigDecimal stockAmount) {
		this.stockAmount = stockAmount;
	}

	public Integer getIsContractRatio() {
		return isContractRatio;
	}

	public void setIsContractRatio(Integer isContractRatio) {
		this.isContractRatio = isContractRatio;
	}

	public BigDecimal getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(BigDecimal stockPrice) {
		this.stockPrice = stockPrice;
	}

	public BigDecimal getStockAmounts() {
		return stockAmounts;
	}

	public void setStockAmounts(BigDecimal stockAmounts) {
		this.stockAmounts = stockAmounts;
	}

	public void setFseq(Long fseq) {
		this.fseq = fseq;
	}

	public Long getFseq() {
		return fseq;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getMaterialNumberId() {
		return materialNumberId;
	}

	public void setMaterialNumberId(String materialNumberId) {
		this.materialNumberId = materialNumberId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getMaterialStandard() {
		return materialStandard;
	}

	public void setMaterialStandard(String materialStandard) {
		this.materialStandard = materialStandard;
	}

	public String getContractNumberId() {
		return contractNumberId;
	}

	public void setContractNumberId(String contractNumberId) {
		this.contractNumberId = contractNumberId;
	}

	public String getQuotaType() {
		return quotaType;
	}

	public void setQuotaType(String quotaType) {
		this.quotaType = quotaType;
	}

	public String getQuotaExplain() {
		return quotaExplain == null ? "":quotaExplain;
	}

	public void setQuotaExplain(String quotaExplain) {
		this.quotaExplain = quotaExplain;
	}

	public String getPackWay() {
		return packWay == null?"":packWay;
	}

	public void setPackWay(String packWay) {
		this.packWay = packWay;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getSupplierNumberId() {
		return supplierNumberId;
	}

	public void setSupplierNumberId(String supplierNumberId) {
		this.supplierNumberId = supplierNumberId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getStockQuota() {
		return stockQuota == null ? "" : stockQuota;
	}

	public void setStockQuota(String stockQuota) {
		this.stockQuota = stockQuota;
	}

	public String getMaterialAttId() {
		return materialAttId == null ? "":materialAttId;
	}

	public void setMaterialAttId(String materialAttId) {
		this.materialAttId = materialAttId;
	}

	/**
	 * 覆盖toString
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
