package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/***
 * 
 * @ClassName: StockMaintainEntryDto
 * @Description: 备货维护分录DTO
 * @author 谢飞
 * @date 2013-11-19 上午11:41:27
 * 
 */
public class StockMaintainEntryDto extends StockMaintainEntryEntity {
	private static final long serialVersionUID = -3835418522185825926L;
	// 物品编码
	private String materialNumber;

	public String getMaterialNumber() {
		return materialNumber;
	}

	public void setMaterialNumber(String materialNumber) {
		this.materialNumber = materialNumber;
	}

	/**
	 * 覆盖toString
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
