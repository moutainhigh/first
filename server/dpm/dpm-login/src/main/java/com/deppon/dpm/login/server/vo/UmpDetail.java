package com.deppon.dpm.login.server.vo;

import java.io.Serializable;

/**
 * 消息body
 * 
 * @author 616580
 *
 */
public class UmpDetail implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4613945968013607174L;
	// 发送环节  1.only(只发微信) 2.fail(失败后转发短信)
	private Integer pushType;
	/**
	 * 短信实体
	 */
	private SmsReq sms;
	/**
	 * 微信公众号实体
	 */
	private WeChatPubInfo weChatPubInfo;
	/**
	 * 企业微信实体
	 */
	private WechartOfficial wechartOfficial;

	public Integer getPushType() {
		return pushType;
	}

	public void setPushType(Integer pushType) {
		this.pushType = pushType;
	}

	public WeChatPubInfo getWeChatPubInfo() {
		return weChatPubInfo;
	}
	public void setWeChatPubInfo(WeChatPubInfo weChatPubInfo) {
		this.weChatPubInfo = weChatPubInfo;
	}
	public WechartOfficial getWechartOfficial() {
		return wechartOfficial;
	}
	public void setWechartOfficial(WechartOfficial wechartOfficial) {
		this.wechartOfficial = wechartOfficial;
	}

	public SmsReq getSms() {
		return sms;
	}

	public void setSms(SmsReq sms) {
		this.sms = sms;
	}
}
