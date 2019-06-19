package com.deppon.dpm.module.management.shared.domain;

/**
 * 邮箱附件实体
 *
 */
public class MailAttachment {

	//附件id
	private String id;
	
	//附件名
	private String attachmentName;
	
	//附件的Url
	private String attachmentUrl;

	//getter
	public String getId() {
		return id;
	}

	//setter
	public void setId(String id) {
		this.id = id;
	}

	//getter
	public String getAttachmentName() {
		return attachmentName;
	}

	//setter
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	//getter
	public String getAttachmentUrl() {
		return attachmentUrl;
	}

	//setter
	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}
}
