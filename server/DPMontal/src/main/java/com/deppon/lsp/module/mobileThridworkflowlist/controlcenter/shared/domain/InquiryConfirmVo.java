package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.io.Serializable;

/**
 * 移动办公询价确认单vo
 * @author 151266
 */
public class InquiryConfirmVo implements Serializable{
	private static final long serialVersionUID = -1058361900202940505L;
	
	private InquiryConfirmEntity entity;
	private InquiryConfirmEntryEntity[] entrys;
	private InquiryConfirmEntryDEntity[] entryDEs;
	
	public InquiryConfirmEntity getEntity() {
		return entity;
	}
	public void setEntity(InquiryConfirmEntity entity) {
		this.entity = entity;
	}
	public InquiryConfirmEntryEntity[] getEntrys() {
		return entrys;
	}
	public void setEntrys(InquiryConfirmEntryEntity[] entrys) {
		this.entrys = entrys;
	}
	public InquiryConfirmEntryDEntity[] getEntryDEs() {
		return entryDEs;
	}
	public void setEntryDEs(InquiryConfirmEntryDEntity[] entryDEs) {
		this.entryDEs = entryDEs;
	}
}
