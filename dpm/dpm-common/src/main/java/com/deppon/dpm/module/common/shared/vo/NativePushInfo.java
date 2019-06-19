package com.deppon.dpm.module.common.shared.vo;

/**
 * 请求人事接口获取本地推送信息对象
 */
public class NativePushInfo {

	private String flag;
	
	// 是否需要推送
	private String result;
	
	// 标题
	private String title;
	
	// 推送的内容
	private String reason;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
