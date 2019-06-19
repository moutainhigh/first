package com.deppon.dpm.doc.server.service;

import java.util.Map;

/**
 * 企业微信推送消息
 * 
 * @author gwl
 *	
 */

public interface IWeChatPushMsgService {

	/*
	 *企业微信获取access_token
	 */
	public Map<String,Object> pushWeChat(Map<String,Object> pushMap,Map<String,Object> textMap) ;
	
	
}
