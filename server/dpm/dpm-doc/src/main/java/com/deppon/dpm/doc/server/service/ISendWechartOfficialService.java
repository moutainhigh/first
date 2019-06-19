package com.deppon.dpm.doc.server.service;

public interface ISendWechartOfficialService {
	/*
	 * 把消息推送至企业微信
	 * */
	public String sendWechartOfficial(String WxContent,String WxTouser);
}
