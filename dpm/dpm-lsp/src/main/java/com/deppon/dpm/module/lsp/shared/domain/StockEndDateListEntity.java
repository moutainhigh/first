package com.deppon.dpm.module.lsp.shared.domain;


/**
 * @author 268101
 * 实体对象
 */
public class StockEndDateListEntity {
	/**
	 * stockTaskingNumber
	 */
	private String stockTaskingNumber;
	/**
	 * 是否部门负责人
	 */
	private String isLeader;//是否部门负责人
	
	/**
	 *  部门名称
	 */
	private String deptName;
	public String getStockTaskingNumber() {
		return stockTaskingNumber;
	}
	public void setStockTaskingNumber(String stockTaskingNumber) {
		this.stockTaskingNumber = stockTaskingNumber;
	}
	/**
	 * @return 是否部门负责人
	 */
	public String getIsLeader() {
		return isLeader;
	}
	/**
	 * @param isLeader 是否部门负责人
	 */
	public void setIsLeader(String isLeader) {
		this.isLeader = isLeader;
	}
	/**
	 * @return  部门名称
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * @param deptName  部门名称
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}	
}	
