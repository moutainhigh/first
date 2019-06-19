package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * 封装表头信息的封装类
 * 
 * @author 谢飞
 * @date 2013-10-24 上午8:47:06
 * @since
 * @version
 */
public class StockBillHeaderDto implements Serializable {
	private static final long serialVersionUID = -4797612665683183264L;
	// 单据编号
	private String id;
	// 单据编码
	private String fnumber;
	// 需求汇总单
	private String needsSummaryNum;
	// 备货类型
	private String stockType;
	// 备货区域
	private String stockArea;
	// 库存组织
	private String stockOrg;
	// 仓库
	private String warehouse;
	// 是否德邦物流
	private Integer isDpStock;
	// 采购类型
	private String billPurType;
	// 申请人
	private String applier;
	// 申请部门
	private String applyDepart;
	// 单据状态
	private String billState;
	// 业务日期(申请日期)
	private Date bizDate;

	public Date getBizDate() {
		return bizDate;
	}

	public void setBizDate(Date bizDate) {
		this.bizDate = bizDate;
	}

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

	public String getNeedsSummaryNum() {
		return needsSummaryNum;
	}

	public void setNeedsSummaryNum(String needsSummaryNum) {
		this.needsSummaryNum = needsSummaryNum;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public Integer getIsDpStock() {
		return isDpStock;
	}

	public void setIsDpStock(Integer isDpStock) {
		this.isDpStock = isDpStock;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public String getStockArea() {
		return stockArea;
	}

	public void setStockArea(String stockArea) {
		this.stockArea = stockArea;
	}

	public String getStockOrg() {
		return stockOrg;
	}

	public void setStockOrg(String stockOrg) {
		this.stockOrg = stockOrg;
	}

	public String getBillPurType() {
		return billPurType == null?"":billPurType;
	}

	public void setBillPurType(String billPurType) {
		this.billPurType = billPurType;
	}

	public String getApplier() {
		return applier;
	}

	public void setApplier(String applier) {
		this.applier = applier;
	}

	public String getApplyDepart() {
		return applyDepart;
	}

	public void setApplyDepart(String applyDepart) {
		this.applyDepart = applyDepart;
	}

	public String getBillState() {
		return billState;
	}

	public void setBillState(String billState) {
		this.billState = billState;
	}

	/**
	 * 覆盖toString
	 * 
	 * @author 谢飞
	 * @date 2013-10-24 上午9:05:24
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
