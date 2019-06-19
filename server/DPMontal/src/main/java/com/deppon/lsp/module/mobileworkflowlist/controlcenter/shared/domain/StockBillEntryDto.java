package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 封装备货申请单明细的DTO
 * 
 * @author 谢飞
 * @date 2013-10-26 下午2:49:19
 * @since
 * @version
 */
public class StockBillEntryDto implements Serializable {
	private static final long serialVersionUID = 4639523552185234802L;
	// 表头fid
	private String parentId;
	// 分录FID
	private String id;
	// 物料代码
	private String materialsFnumber;
	// 物料名称
	private String materialsName;
	// 物料类型
	private String materialType;
	// 物料规格
	private String materialsStadarts;
	// 采购员ID
	private String purchasemanId;
	// 采购员姓名
	private String purchasemanName;
	// 采购类型
	private String purchaseType;
	// 单价
	private BigDecimal price;
	// 单位
	private String unit;
	// 申请备货量
	private BigDecimal stockAccount;
	// 预计金额
	private BigDecimal accountMoney;
	// 使用部门
	private String department;
	// 采购周期
	private Integer purchaseDate;
	// 预计交货时间
	private Date changeDate;
	// 备货原因
	private String stockReason;

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getPurchasemanId() {
		return purchasemanId;
	}

	public void setPurchasemanId(String purchasemanId) {
		this.purchasemanId = purchasemanId;
	}

	public String getPurchasemanName() {
		return purchasemanName==null?"":purchasemanName;
	}

	public void setPurchasemanName(String purchasemanName) {
		this.purchasemanName = purchasemanName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMaterialsFnumber() {
		return materialsFnumber;
	}

	public void setMaterialsFnumber(String materialsFnumber) {
		this.materialsFnumber = materialsFnumber;
	}

	public String getMaterialsName() {
		return materialsName;
	}

	public void setMaterialsName(String materialsName) {
		this.materialsName = materialsName;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getMaterialsStadarts() {
		return materialsStadarts;
	}

	public void setMaterialsStadarts(String materialsStadarts) {
		this.materialsStadarts = materialsStadarts;
	}

	public String getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getStockAccount() {
		return stockAccount;
	}

	public void setStockAccount(BigDecimal stockAccount) {
		this.stockAccount = stockAccount;
	}

	public BigDecimal getAccountMoney() {
		return accountMoney;
	}

	public void setAccountMoney(BigDecimal accountMoney) {
		this.accountMoney = accountMoney;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Integer purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public String getStockReason() {
		return stockReason;
	}

	public void setStockReason(String stockReason) {
		this.stockReason = stockReason;
	}

	/**
	 * 覆盖TOSTRING
	 * 
	 * @author 谢飞
	 * @date 2013-10-26 下午3:51:39
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
