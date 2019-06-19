package com.deppon.dpm.module.common.shared.vo;


public class EccPushLinkInfo {
	// 标题
	private String title;
	// 类型
	private String type;
	// 链接
	private String pushLink;
	// 参数
	private String linkParam;
	// 发布时间
	private String pubTime;
	
	public EccPushLinkInfo() {
		super();
	}
	
	public EccPushLinkInfo(String title, String type, String pushLink,
			String linkParam, String pubTime) {
		super();
		this.title = title;
		this.type = type;
		this.pushLink = pushLink;
		this.linkParam = linkParam;
		this.pubTime = pubTime;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPushLink() {
		return pushLink;
	}

	public void setPushLink(String pushLink) {
		this.pushLink = pushLink;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getPubTime() {
		return pubTime;
	}
	
	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}

	public String getLinkParam() {
		return linkParam;
	}

	public void setLinkParam(String linkParam) {
		this.linkParam = linkParam;
	}
	
}
