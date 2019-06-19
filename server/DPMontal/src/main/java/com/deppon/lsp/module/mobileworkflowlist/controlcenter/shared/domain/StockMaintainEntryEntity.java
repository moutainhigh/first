package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 * @ClassName: StockMaintainEntryEntity
 * @Description: 备货维护单分录实体
 * @author 谢飞
 * @date 2013-11-19 上午10:04:42
 * 
 */
public class StockMaintainEntryEntity extends BaseEntity {
	private static final long serialVersionUID = 2226837236170305541L;
	// 序列
	private Long fseq;
	// 表头ID
	private String parentId;
	// 物品FID
	private String materialFid;
	// 物品名称
	private String materialName;
	// 物品类型
	private String materialType;
	// 物品规格
	private String materialStandard;
	// 单位
	private String unit;
	// 预计备货量
	private BigDecimal stockAmount;
	// 采购周期
	private BigDecimal period;
	// 预计总金额
	private BigDecimal predictAmount;
	// 预计交货时间
	private Date predictTime;
	// 物料属性
	private String materialAttId;
	// 原单据ID
	private String sourceBillId;

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

	public String getMaterialFid() {
		return materialFid;
	}

	public void setMaterialFid(String materialFid) {
		this.materialFid = materialFid;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(BigDecimal stockAmount) {
		this.stockAmount = stockAmount;
	}

	public BigDecimal getPeriod() {
		return period;
	}

	public void setPeriod(BigDecimal period) {
		this.period = period;
	}

	public BigDecimal getPredictAmount() {
		return predictAmount;
	}

	public void setPredictAmount(BigDecimal predictAmount) {
		this.predictAmount = predictAmount;
	}

	public Date getPredictTime() {
		return predictTime;
	}

	public void setPredictTime(Date predictTime) {
		this.predictTime = predictTime;
	}

	public String getMaterialAttId() {
		return materialAttId;
	}

	public void setMaterialAttId(String materialAttId) {
		this.materialAttId = materialAttId;
	}

	public String getSourceBillId() {
		return sourceBillId;
	}

	public void setSourceBillId(String sourceBillId) {
		this.sourceBillId = sourceBillId;
	}

	/**
	 * 覆盖toString
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
