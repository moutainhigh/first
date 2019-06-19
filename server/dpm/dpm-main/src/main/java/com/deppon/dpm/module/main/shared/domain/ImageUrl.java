package com.deppon.dpm.module.main.shared.domain;

/**
 * 滚动图片地址
 * @author 500612
 *
 */
public class ImageUrl {

	private String picUrl;
	private String uid;
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "ImageUrl [picUrl=" + picUrl + ", uid=" + uid + "]";
	}
	
	
}
