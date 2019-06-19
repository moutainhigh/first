package com.deppon.dpm.doc.server.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deppon.dpm.doc.server.service.IWeChatPushMsgService;
import com.deppon.dpm.doc.server.util.HttpClientUtil;

public class WeChatPushMsgService implements IWeChatPushMsgService {

	private static final Logger logger = LoggerFactory.getLogger(WeChatPushMsgService.class);
	private String wechat_pushurl;
	
	private String wechat_corpid;
	
	private String wechat_corpsecret;
	
	private String wechat_agentid;
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String,Object> pushWeChat(Map<String, Object> pushMap , Map<String, Object> textMap) {
		//返回状态Map
		Map<String,Object> result = new HashMap<String,Object>();
		
		try {
			//获取access_token
			logger.info("企业微信推送消息获取access_token开始》》》》》》》》》》》》》》");
			String gettoken_url = wechat_pushurl + "gettoken";
			String param = "corpid=" + "wx55b0c14412683cbb" + "&corpsecret="+"BdNBU_jHFFIF0Qx_wi0bJr3LUnKBQIklBbrJuRWKpXY";
			
			String orderdatail = HttpClientUtil. sendGet(gettoken_url, param);
			Map<String,Object> tokenMap = JSON.parseObject(orderdatail, Map.class);
			Object access_token = tokenMap.get("access_token");
			logger.info("企业微信推送消息开始》》》》》》》》》》》》》》");
			String push_url = wechat_pushurl + "message/send?access_token="+access_token+"";
			//推送消息
			String orderdatailaaa = HttpClientUtil.httpPost(push_url,JSON.toJSONString(pushMap,SerializerFeature.WriteNullStringAsEmpty));
			Map<String,Object> weChatResultMap = JSON.parseObject(orderdatailaaa, Map.class);
			Object errcode = weChatResultMap.get("errcode");
			Object errmsg = weChatResultMap.get("errmsg");
			//加载返回数据
			result.put("errcode", errcode);
			result.put("errmsg", errmsg);
			result.put("success", true);
			
		} catch (IOException e) {
			result.put("errcode", 1);
			result.put("errmsg", e.getMessage());
			result.put("success", false);
			logger.error("企业微信推送消息异常》》》》》》》》",e.getMessage());
		}
		return result;
	}

	/**
	 * @return the wechat_pushurl
	 */
	public String getWechat_pushurl() {
		return wechat_pushurl;
	}

	/**
	 * @return the wechat_corpid
	 */
	public String getWechat_corpid() {
		return wechat_corpid;
	}

	/**
	 * @return the wechat_corpsecret
	 */
	public String getWechat_corpsecret() {
		return wechat_corpsecret;
	}

	/**
	 * @return the wechat_agentid
	 */
	public String getWechat_agentid() {
		return wechat_agentid;
	}

	/**
	 * @param wechat_pushurl the wechat_pushurl to set
	 */
	public void setWechat_pushurl(String wechat_pushurl) {
		this.wechat_pushurl = wechat_pushurl;
	}

	/**
	 * @param wechat_corpid the wechat_corpid to set
	 */
	public void setWechat_corpid(String wechat_corpid) {
		this.wechat_corpid = wechat_corpid;
	}

	/**
	 * @param wechat_corpsecret the wechat_corpsecret to set
	 */
	public void setWechat_corpsecret(String wechat_corpsecret) {
		this.wechat_corpsecret = wechat_corpsecret;
	}

	/**
	 * @param wechat_agentid the wechat_agentid to set
	 */
	public void setWechat_agentid(String wechat_agentid) {
		this.wechat_agentid = wechat_agentid;
	}

}
