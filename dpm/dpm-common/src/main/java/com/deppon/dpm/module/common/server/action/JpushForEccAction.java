package com.deppon.dpm.module.common.server.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.util.HttpUtil;
import com.deppon.dpm.module.common.shared.vo.EccPushLinkInfo;

public class JpushForEccAction extends BaseAction {
	
	private static final Logger LOG = LoggerFactory.getLogger(JpushForEccAction.class);
	
	private String eccPushLinkInfoUrl;
	
	public void searchEccLink(){
		String resultStr = null;
		String searchKey = null;
		List<EccPushLinkInfo> list = new ArrayList<EccPushLinkInfo>();
		try {
			searchKey = ServletActionContext.getRequest().getParameter("searchKey");
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("title", searchKey);
			resultStr = HttpUtil.doPost(eccPushLinkInfoUrl, params);
			if(null != resultStr) {
				JSONObject jsonObject = JSON.parseObject(resultStr);
				if(jsonObject.getBooleanValue("resultFlag")){
					list = JSON.parseArray(jsonObject.getString("info"),EccPushLinkInfo.class);
				}
			}
			
			writeToPage(list);
		} catch (Exception e) {
			LOG.error("请求ECC推送链接信息出错!!!  请求参数："+searchKey+",请求结果：" + resultStr, e);
		}
	}

	public String getEccPushLinkInfoUrl() {
		return eccPushLinkInfoUrl;
	}

	public void setEccPushLinkInfoUrl(String eccPushLinkInfoUrl) {
		this.eccPushLinkInfoUrl = eccPushLinkInfoUrl;
	}

}
