package com.deppon.dpm.module.lsp.shared.domain;

import java.sql.Timestamp;

/**
 * @author 268101
 * 实体对象
 */
public class StockTaskingEntity {
	/**
	 *  stockTaskingNumber
	 */
	private String stockTaskingNumber;
	/**
	 * //是否部门负责人
	 */
	private String isLeader;
	
	/**
	 * //盘点结束时间
	 */
	private Timestamp stockTaskingEndDate;
	/**
	 * strStockTaskEndDate
	 */
	private String strStockTaskEndDate;
	
	/**
	 * //部门名称
	 */
	private String deptName;
	/**
	 * @return 部门名称
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * @param deptName 部门名称
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * @return stockTaskingNumber
	 */
	public String getStockTaskingNumber() {
		return stockTaskingNumber;
	}
	/**
	 * @param stockTaskingNumber stockTaskingNumber
	 */
	public void setStockTaskingNumber(String stockTaskingNumber) {
		this.stockTaskingNumber = stockTaskingNumber;
	}
	public String getIsLeader() {
		return isLeader;
	}
	public void setIsLeader(String isLeader) {
		this.isLeader = isLeader;
	}
	public Timestamp getStockTaskingEndDate() {
		return stockTaskingEndDate;
	}
	public void setStockTaskingEndDate(Timestamp stockTaskingEndDate) {
		this.stockTaskingEndDate = stockTaskingEndDate;
	}
	public String getStrStockTaskEndDate() {
		return strStockTaskEndDate;
	}
	public void setStrStockTaskEndDate(String strStockTaskEndDate) {
		this.strStockTaskEndDate = strStockTaskEndDate;
	}		
}
