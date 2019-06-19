package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.StockBillEntryDto;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.StockBillHeaderDto;

/**
 * @title: StockApplybillVo 
 * @description： 备货申请单vo
 * @author： wuyaqing
 * @date： 2014-5-26 上午10:46:06
 */
public class StockApplybillVo {

	//备货申请单表头信息
	private StockBillHeaderDto stockBillHeaderDto;
	//备货申请单分录实体类
	private StockBillEntryDto[] stockBillEntryDto;
	
	public StockBillEntryDto[] getStockBillEntryDto() {
		if (stockBillEntryDto == null) {
			stockBillEntryDto = new StockBillEntryDto[0];
		}
		return stockBillEntryDto;
	}
	public void setStockBillEntryDto(StockBillEntryDto[] stockBillEntryDto) {
		this.stockBillEntryDto = stockBillEntryDto;
	}
	public StockBillHeaderDto getStockBillHeaderDto() {
		return stockBillHeaderDto;
	}
	public void setStockBillHeaderDto(StockBillHeaderDto stockBillHeaderDto) {
		this.stockBillHeaderDto = stockBillHeaderDto;
	}
	
}
