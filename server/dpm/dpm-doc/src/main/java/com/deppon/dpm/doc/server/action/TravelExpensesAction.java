package com.deppon.dpm.doc.server.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.deppon.dpm.doc.server.util.HttpClientUtil;
import com.deppon.dpm.doc.server.vo.TravelVo;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

@SuppressWarnings("all")
public class TravelExpensesAction extends BaseAction{
	
	private static final long serialVersionUID = -1736732639378451048L;
	
	private static final Logger logger = LoggerFactory.getLogger(TravelExpensesAction.class);
	
	//工号
	private String userId;
	
	private String travelExpenseUrl;
	
	//Map<报账单号,Map<审批流程状态,List<TravelVo>>>
	/**
	 * 查询某员工审批中或已通过的差旅工作流
	 */
	public void getTravelWorkflow(){
		JSONObject jsonObject = new JSONObject();
		if(StringUtils.isNotEmpty(userId)){
			TravelVo travelVo = new TravelVo();
			try {
				logger.info(userId + "查询差旅工作流--------");
				String queryresults = HttpClientUtil.httpPost(travelExpenseUrl,userId);
				System.out.println(queryresults);
				logger.info(userId + "查询差旅工作流结果：" + queryresults);
				Map<String,Map<String,List<TravelVo>>> map1 = (Map<String,Map<String,List<TravelVo>>>)JSON.parseObject(queryresults,LinkedHashMap.class,Feature.OrderedField);
                /*JSONObject json = new JSONObject(true);
                json.putAll(map1);*/
                System.out.println(map1);
				if(queryresults != null && !queryresults.isEmpty()){
					jsonObject.put("result", map1);
					jsonObject.put("error", "0");
					if(map1.containsKey("")){
						jsonObject.put("result", map1);
						jsonObject.put("error", "2");
					}
				}else{
					jsonObject.put("result", "");
					jsonObject.put("error", "1");
				}
				writeToPage(jsonObject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				jsonObject.put("error", "1");
				jsonObject.put("errorinfo", e);
			}
		}else{
			jsonObject.put("error", "1");
			jsonObject.put("errorinfo", "工号不能为空");
		}
		writeToPage(jsonObject);
	}
	
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getTravelExpenseUrl() {
		return travelExpenseUrl;
	}



	public void setTravelExpenseUrl(String travelExpenseUrl) {
		this.travelExpenseUrl = travelExpenseUrl;
	}
	
	

}
