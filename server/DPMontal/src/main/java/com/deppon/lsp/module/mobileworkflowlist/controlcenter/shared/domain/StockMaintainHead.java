package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @ClassName: StockMaintainHead
 * @Description: 封装备货维护表头信息DTO
 * @author 谢飞
 * @date 2013-11-16 下午4:59:59
 * 
 */
public class StockMaintainHead implements Serializable {
	private static final long serialVersionUID = 6674332754724788496L;
	// 维护单FID
	private String id;
	// 维护单单号
	private String fnumber;
	// 备货申请单FID
	private String stockBillId;
	// 备货申请单单号
	private String stockBillNumber;
	// 采购员
	private String buyerName;
	// 申请人
	private String applyUser;
	// 申请日期
	private Date bizDate;
	// 备货类型
	private String stockType;
	// 需求汇总单FID
	private String needsSummary;
	// 需求汇总单单号
	private String needsSummaryNumber;
	// 备货区域
	private String storeArea;
	// 库存组织
	private String stockOrg;
	// 仓库
	private String warehouse;
	// 单据状态
	private String billState;
	// 是否德邦物流
	private Integer isDpStock;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFnumber() {
		return fnumber;
	}

	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}

	public String getStockBillId() {
		return stockBillId;
	}

	public void setStockBillId(String stockBillId) {
		this.stockBillId = stockBillId;
	}

	public String getStockBillNumber() {
		return stockBillNumber;
	}

	public void setStockBillNumber(String stockBillNumber) {
		this.stockBillNumber = stockBillNumber;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getApplyUser() {
		return applyUser;
	}

	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}

	public Date getBizDate() {
		return bizDate;
	}

	public void setBizDate(Date bizDate) {
		this.bizDate = bizDate;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public String getNeedsSummary() {
		return needsSummary == null ? "" : needsSummary;
	}

	public void setNeedsSummary(String needsSummary) {
		this.needsSummary = needsSummary;
	}

	public String getNeedsSummaryNumber() {
		return needsSummaryNumber == null ? "":needsSummaryNumber;
	}

	public void setNeedsSummaryNumber(String needsSummaryNumber) {
		this.needsSummaryNumber = needsSummaryNumber;
	}

	public String getStoreArea() {
		return storeArea;
	}

	public void setStoreArea(String storeArea) {
		this.storeArea = storeArea;
	}

	public String getStockOrg() {
		return stockOrg == null ? "":stockOrg;
	}

	public void setStockOrg(String stockOrg) {
		this.stockOrg = stockOrg;
	}

	public String getWarehouse() {
		return warehouse == null ? "" : warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public String getBillState() {
		return billState;
	}

	public void setBillState(String billState) {
		this.billState = billState;
	}

	public Integer getIsDpStock() {
		return isDpStock;
	}

	public void setIsDpStock(Integer isDpStock) {
		this.isDpStock = isDpStock;
	}

	/**
	 * 覆盖toString
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
