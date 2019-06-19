package com.deppon.dpm.module.lsp.shared.domain;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author 268101
 * 
 *         实体对象
 */
public class StockByEndDateEntity {
	/**
	 * 时间戳
	 */
	private Timestamp stockEndDate;
	/**
	 * 结束时间
	 */
	private String strStockEndDate;
	/**
	 * List<StockEndDateListEntity> 对象
	 */
	private List<StockEndDateListEntity> dateListEntities;

	/**
	 * @return 结束时间
	 */
	public String getStrStockEndDate() {
		return strStockEndDate;
	}

	/**
	 * @param strStockEndDate 结束时间
	 */
	public void setStrStockEndDate(String strStockEndDate) {
		this.strStockEndDate = strStockEndDate;
	}

	/**
	 * @return 结束时间
	 */ 
	public Timestamp getStockEndDate() {
		return stockEndDate;
	}

	public void setStockEndDate(Timestamp stockEndDate) {
		this.stockEndDate = stockEndDate;
	}

	public List<StockEndDateListEntity> getDateListEntities() {
		return dateListEntities;
	}

	public void setDateListEntities(
			List<StockEndDateListEntity> dateListEntities) {
		this.dateListEntities = dateListEntities;
	}
}
