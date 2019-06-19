package com.deppon.lsp.module.mobileworkflow.shared.domain;

import java.util.Date;

import com.deppon.lsp.module.pay.payapply.shared.domain.PayApplyEntryEntity;

public class PayApplyEntryVo extends PayApplyEntryEntity {
	private static final long serialVersionUID = 1082995436207783320L;
	/**
	 * 付款日期
	 */
	private String payDayStr;
	public String getPayDayStr() {
		return payDayStr;
	}
	public void setPayDayStr(String payDayStr) {
		this.payDayStr = payDayStr;
	}
}
