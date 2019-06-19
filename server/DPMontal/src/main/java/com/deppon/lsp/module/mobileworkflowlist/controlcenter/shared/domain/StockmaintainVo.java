package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @Description : 备货维护单
 * @author : jianweiqiang
 * @date 2014-5-20 下午5:32:30
 * @since
 * @version v0.1
 */
/**
 * @Description : 描述类的职责
 * @author : jianweiqiang
 * @date 2014-5-24 上午8:30:03
 * @since
 * @version v0.1
 */
public class StockmaintainVo {
	// // 备货维护单主表
	// private StockMaintainEntity stockMaintainEntity;
	// // 备货维护单分录
	// private StockMaintainEntryEntity[] stockMaintainEntryEntityList;
	// // 备货维护单分录
	// private StockMedeEntity[] stockMedeEntityList;
	// 备货维护单主表
	private StockMaintainHead stockMaintainHead;
	// 备货维护单分录
	private StockMaintainEntryDto[] stockMaintainEntryDtoList;
	// 备货维护单分录
	private StockMedeDto[] stockMedeDtoList;

	/**
	 * @Description : 返回 stockMaintainHead属性的值
	 * @date 2014-5-24 上午8:38:57
	 */

	public StockMaintainHead getStockMaintainHead() {
		return stockMaintainHead;
	}

	/**
	 * @param 设置属性
	 *            stockMaintainHead的值
	 */
	public void setStockMaintainHead(StockMaintainHead stockMaintainHead) {
		this.stockMaintainHead = stockMaintainHead;
	}

	/**
	 * @Description : 返回 stockMaintainEntryDtoList属性的值
	 * @date 2014-5-24 上午8:38:57
	 */

	public StockMaintainEntryDto[] getStockMaintainEntryDtoList() {
		if (stockMaintainEntryDtoList == null) {
			stockMaintainEntryDtoList = new StockMaintainEntryDto[0];
		}
		return stockMaintainEntryDtoList;
	}

	/**
	 * @param 设置属性
	 *            stockMaintainEntryDtoList的值
	 */
	public void setStockMaintainEntryDtoList(
			StockMaintainEntryDto[] stockMaintainEntryDtoList) {
		this.stockMaintainEntryDtoList = stockMaintainEntryDtoList;
	}

	/**
	 * @Description : 返回 stockMedeDtoList属性的值
	 * @date 2014-5-24 上午8:38:57
	 */

	public StockMedeDto[] getStockMedeDtoList() {
		if (stockMedeDtoList == null) {
			stockMedeDtoList = new StockMedeDto[0];
		}
		return stockMedeDtoList;
	}

	/**
	 * @param 设置属性
	 *            stockMedeDtoList的值
	 */
	public void setStockMedeDtoList(StockMedeDto[] stockMedeDtoList) {
		this.stockMedeDtoList = stockMedeDtoList;
	}

	/**
	 * 
	 * @Description : 覆盖toString方法
	 * @author : jianweiqiang
	 * @date 2014-5-20 下午5:35:49
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
