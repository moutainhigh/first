package com.deppon.dpm.doc.server.action;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deppon.dpm.doc.server.service.IAddMessageService;
import com.deppon.dpm.doc.server.util.HttpClientUtil;
import com.deppon.dpm.module.anps.server.service.IReceiveObjectService;
import com.deppon.dpm.tongxunlu.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.service.IJPushNewService;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

public class MessageTestAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 推送消息服务
	private IJPushNewService jPushNewService;
	private String budgetqryurl;
	private IAddMessageService addmessageservice;
	private String wechat_pushurl;
	private IReceiveObjectService receiveobjectservice;
	
	@SuppressWarnings("unchecked")
	@CookieNotCheckedRequired
	public void sendMessage(){
		JSONObject jonum = new JSONObject();
		try {
			String push_url = wechat_pushurl + "gettoken";
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("corpid", "wx55b0c14412683cbb");
			map.put("corpsecret", "");
			String param = "corpid=" + "wx55b0c14412683cbb" + "&corpsecret="+"BdNBU_jHFFIF0Qx_wi0bJr3LUnKBQIklBbrJuRWKpXY";
			
			String orderdatail = HttpClientUtil. sendGet(push_url, param);
			Map<String,Object> map1 = JSON.parseObject(orderdatail, Map.class);
			Object access_token = map1.get("access_token");
			
			String push_url222 = wechat_pushurl + "message/send?access_token="+access_token+"";
			HashMap<String, Object> mapaaa = new HashMap<String, Object>();
			mapaaa.put("touser", "496837");
			mapaaa.put("toparty", "");
			mapaaa.put("totag", "");
			mapaaa.put("msgtype", "text");
			mapaaa.put("agentid", "1000142");
			mapaaa.put("content", "风萧萧兮易水寒,\n壮士一去兮不复还.\n<a href=\"http://shared.youdao.com/market/xmdh/163.html/\">点我点我</a>");
			mapaaa.put("safe", "0");
			
			String orderdatailaaa = HttpClientUtil.httpPost(push_url222,JSON.toJSONString(mapaaa,SerializerFeature.WriteNullStringAsEmpty));
			
			jonum.put("url", orderdatailaaa);
		} catch (Exception e) {
			e.getMessage();
			jonum.put("error", e.getMessage());
		}
		writeToPage(jonum);
	}
	
	/**
	 * @param jPushNewService the jPushNewService to set
	 */
	public void setjPushNewService(IJPushNewService jPushNewService) {
		this.jPushNewService = jPushNewService;
	}

	/**
	 * @param budgetqryurl the budgetqryurl to set
	 */
	public void setBudgetqryurl(String budgetqryurl) {
		this.budgetqryurl = budgetqryurl;
	}

	/**
	 * @return the jPushNewService
	 */
	public IJPushNewService getjPushNewService() {
		return jPushNewService;
	}

	/**
	 * @param addmessageservice the addmessageservice to set
	 */
	public void setAddmessageservice(IAddMessageService addmessageservice) {
		this.addmessageservice = addmessageservice;
	}

	/**
	 * @param receiveobjectservice the receiveobjectservice to set
	 */
	public void setReceiveobjectservice(IReceiveObjectService receiveobjectservice) {
		this.receiveobjectservice = receiveobjectservice;
	}

	/**
	 * @return the wechat_pushurl
	 */
	public String getWechat_pushurl() {
		return wechat_pushurl;
	}

	/**
	 * @param wechat_pushurl the wechat_pushurl to set
	 */
	public void setWechat_pushurl(String wechat_pushurl) {
		this.wechat_pushurl = wechat_pushurl;
	}

}
