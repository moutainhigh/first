package com.deppon.lsp.module.mobileworkflow.shared.domain;

import java.util.Date;

import com.deppon.lsp.module.pay.payapply.shared.domain.PayApplyEntity;

public class PayApplyVo extends PayApplyEntity {
	private static final long serialVersionUID = 8780120064199400206L;
	/**
	 * 单据日期
	 */
	private String bizDateStr;
	/**
	 * 审核日期
	 */
	private String auditDateStr;
	
	/**
	 * 到期日期
	 */
    private String deadLineStr;

	public String getBizDateStr() {
		return bizDateStr;
	}

	public void setBizDateStr(String bizDateStr) {
		this.bizDateStr = bizDateStr;
	}

	public String getAuditDateStr() {
		return auditDateStr;
	}

	public void setAuditDateStr(String auditDateStr) {
		this.auditDateStr = auditDateStr;
	}

	public String getDeadLineStr() {
		return deadLineStr;
	}

	public void setDeadLineStr(String deadLineStr) {
		this.deadLineStr = deadLineStr;
	}
}
