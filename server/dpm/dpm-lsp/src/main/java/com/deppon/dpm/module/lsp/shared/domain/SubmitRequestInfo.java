package com.deppon.dpm.module.lsp.shared.domain;

/**
 * @author 268101
 * 实体对象
 */
public class SubmitRequestInfo {

	//固定资产盘点单单据编号
	private String stockTaskingFnumber;
	/*
	 * 操作状态
	 */
	private String operatStatus;
	/*
	 *盘点单备注信息
	 */
	private String description;
	/**
	 * @return 固定资产盘点单单据编号
	 */
	public String getStockTaskingFnumber() {
		return stockTaskingFnumber;
	}
	/**
	 * @param stockTaskingFnumber 固定资产盘点单单据编号
	 */
	public void setStockTaskingFnumber(String stockTaskingFnumber) {
		this.stockTaskingFnumber = stockTaskingFnumber;
	}
	/**
	 * @return 操作状态
	 */
	public String getOperatStatus() {
		return operatStatus;
	}
	/**
	 * @param operatStatus 操作状态
	 */
	public void setOperatStatus(String operatStatus) {
		this.operatStatus = operatStatus;
	}
	/**
	 * @return 盘点单备注信息
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description 盘点单备注信息
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
