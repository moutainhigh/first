package com.deppon.dpm.module.lsp.shared.domain;

import java.util.Date;

/**
 * 消息推送到移动端
 * 将生成的盘点单信息推送到移动端，移动端根据信息进行对应的消息推送
 * @author 148122
 */
public class StockTaskingNotice {

	//盘点人名称
	private String stockTaskingName;
	//盘点人工号
	private String stockTaskingEmpCode;
	//盘点单编号
	private String stockTaskingNumber;
	//盘点开始时间
	private Date stockTaskingBeginDate;
	//盘点结束时间
	//private Date stockTaskingEndDate;
	private long stockTaskingEndDate;
	/**
	 *  useDeptName  部门名称
	 */
	private String useDeptName;
	/**
	 *  部门code
	 */
	private String useDeptCode;		
	
	/** 
	* @Fields parea 车牌号信息
	*/ 
	private String parea;
	/**
	 * @return 部门名称
	 */
	public String getUseDeptName() {
		return useDeptName;
	}
	/**
	 * @param useDeptName 部门名称
	 */
	public void setUseDeptName(String useDeptName) {
		this.useDeptName = useDeptName;
	}
	/** 
	* @Description: 获取车牌号信息
	* @date 2015-11-17 上午10:31:31 
	*  @return 
	*/
	public String getParea() {
		return parea;
	}
	/** 
	* @Description: 设置车牌号信息
	* @date 2015-11-17 上午10:31:34 
	*  @param parea 
	*/
	public void setParea(String parea) {
		this.parea = parea;
	}
	/**
	 * @return 部门code
	 */
	public String getUseDeptCode() {
		return useDeptCode;
	}
	/**
	 * @param useDeptCode 部门code
	 */
	public void setUseDeptCode(String useDeptCode) {
		this.useDeptCode = useDeptCode;
	}
	/**
	 * @return 盘点单编号
	 */
	public String getStockTaskingName() {
		return stockTaskingName;
	}
	/**
	 * @param stockTaskingName 盘点单编号
	 */
	public void setStockTaskingName(String stockTaskingName) {
		this.stockTaskingName = stockTaskingName;
	}
	/**
	 * @return 盘点人工号
	 */
	public String getStockTaskingEmpCode() {
		return stockTaskingEmpCode;
	}
	/**
	 * @param stockTaskingEmpCode 盘点人工号
	 */
	public void setStockTaskingEmpCode(String stockTaskingEmpCode) {
		this.stockTaskingEmpCode = stockTaskingEmpCode;
	}
	public String getStockTaskingNumber() {
		return stockTaskingNumber;
	}
	public void setStockTaskingNumber(String stockTaskingNumber) {
		this.stockTaskingNumber = stockTaskingNumber;
	}
	public Date getStockTaskingBeginDate() {
		return stockTaskingBeginDate;
	}
	public void setStockTaskingBeginDate(Date stockTaskingBeginDate) {
		this.stockTaskingBeginDate = stockTaskingBeginDate;
	}
	public long getStockTaskingEndDate() {
		return stockTaskingEndDate;
	}
	public void setStockTaskingEndDate(long stockTaskingEndDate) {
		this.stockTaskingEndDate = stockTaskingEndDate;
	}

	
}
