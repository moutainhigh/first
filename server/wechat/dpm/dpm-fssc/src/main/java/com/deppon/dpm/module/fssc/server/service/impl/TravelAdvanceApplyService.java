package com.deppon.dpm.module.fssc.server.service.impl;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.fssc.server.service.ITravelAdvanceApplyService;
import com.google.gson.Gson;
/**
 * 事前申请单单点登录实现接口
 * @author 曹嵩
 * @date   2015.6.16
 */
public class TravelAdvanceApplyService implements ITravelAdvanceApplyService {
	
	private static Logger logger = Logger.getLogger(TravelAdvanceApplyService.class);

	//请求地址
	private String url="";
	//接入账号，携程分配给商旅公司
	private String appkey="";
	//接入密码，携程分配给商旅公司
	private String appsecurity="";
	//获取token类型
	private int tokentype;
	//卡号分组，需要携程提供
	private int groupid;
	
	//httpClient
	private HttpClient hclient;
	
	// 设置连接超时时间(单位毫秒)
	private static final int CONNECTION_TIMEOUT=30000;
	
	// 设置读数据超时时间(单位毫秒)
	private static final int READ_DATA_TIMEOUT=10000;
	
	@Override
	public String queryTravelAdvanceApply() {
		String rs = "";
		try {
			Gson gson = new Gson();
			hclient = new HttpClient();
			//设置编码格式
			hclient.getParams().setContentCharset("UTF-8");
			// 设置超时时间
			HttpConnectionManagerParams managerParams = hclient
								.getHttpConnectionManager().getParams();

			// 设置连接超时时间(单位毫秒)
			managerParams.setConnectionTimeout(CONNECTION_TIMEOUT);
			// 设置读数据超时时间(单位毫秒)
			managerParams.setSoTimeout(READ_DATA_TIMEOUT);
			
			PostMethod postMethod = new PostMethod(url);
			
			Map<String,String> map = new HashMap<String,String>();
			map.put("AppKey",appkey);
			map.put("AppSecurity", appsecurity);
			map.put("TokenType", String.valueOf(tokentype));
			map.put("GroupID", String.valueOf(groupid));
			String jsonStr = gson.toJson(map);
			
			// 设置消息体
			RequestEntity entity = new StringRequestEntity(jsonStr,"application/json","UTF-8");
			postMethod.setRequestEntity(entity);
			
			
			//调用请求获取响应
			hclient.executeMethod(postMethod);

			rs = postMethod.getResponseBodyAsString();
			JSONObject jsonObj = JSONObject.parseObject(rs);
			rs = jsonObj.toJSONString();
		} catch (Exception e) {
			logger.error("queryTravelAdvanceApply-------调用携程获取ticket出错", e);
			rs = "{\"resultFlag\":\"Y\",\"errorMsg\":\"抱歉   请求暂时出错   刷新试试！\",\"faults\":null,\"addresses\":null}";
		}
		return rs;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getAppsecurity() {
		return appsecurity;
	}

	public void setAppsecurity(String appsecurity) {
		this.appsecurity = appsecurity;
	}

	public int getTokentype() {
		return tokentype;
	}

	public void setTokentype(int tokentype) {
		this.tokentype = tokentype;
	}

	public int getGroupid() {
		return groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	
	

}
