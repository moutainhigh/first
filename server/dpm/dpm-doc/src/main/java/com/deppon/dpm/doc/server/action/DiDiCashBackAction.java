package com.deppon.dpm.doc.server.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.entity.DiDiCashBackEntity;
import com.deppon.dpm.doc.server.util.HttpClientUtil;
import com.deppon.dpm.doc.server.util.MD5Sign;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

/**
 * didi返款
 * @author 
 * 
 */
public class DiDiCashBackAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 滴滴client_id
	 */
	private String didi_client_id;
	private String company_id;
	/**
	 * 滴滴client_secret
	 */
	private String didi_client_secret;
	/**
	 * 滴滴key
	 */
	private String didi_key;
	/**
	 * 滴滴公共电话
	 */
	private String didi_pubiphone;
	/**
	 * 滴滴didi_didilist
	 */
	private String didi_didilist;
	
	/**
	 * @return the didi_client_id
	 */
	public String getDidi_client_id() {
		return didi_client_id;
	}
	/**
	 * @return the didi_client_secret
	 */
	public String getDidi_client_secret() {
		return didi_client_secret;
	}
	/**
	 * @return the didi_key
	 */
	public String getDidi_key() {
		return didi_key;
	}
	/**
	 * @return the didi_pubiphone
	 */
	public String getDidi_pubiphone() {
		return didi_pubiphone;
	}
	/**
	 * @param didi_client_id the didi_client_id to set
	 */
	public void setDidi_client_id(String didi_client_id) {
		this.didi_client_id = didi_client_id;
	}
	/**
	 * @param didi_client_secret the didi_client_secret to set
	 */
	public void setDidi_client_secret(String didi_client_secret) {
		this.didi_client_secret = didi_client_secret;
	}
	/**
	 * @param didi_key the didi_key to set
	 */
	public void setDidi_key(String didi_key) {
		this.didi_key = didi_key;
	}
	/**
	 * @param didi_pubiphone the didi_pubiphone to set
	 */
	public void setDidi_pubiphone(String didi_pubiphone) {
		this.didi_pubiphone = didi_pubiphone;
	}
	public DiDiCashBackAction(){
		super();
	}
	
	private static final Logger logger = LoggerFactory.getLogger(DiDiCashBackAction.class);
	
	@SuppressWarnings("rawtypes")
	@CookieNotCheckedRequired
	public  void cashBack(){
		JSONObject jonum = new JSONObject();
		String url = didi_didilist + "Order/get";
		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			long time = System.currentTimeMillis();
			map.put("client_id", didi_client_id);
			map.put("access_token", didi_client_secret);
			map.put("timestamp", time);
			map.put("company_id", company_id);
			map.put("offset", 1);
			map.put("length", 100);
			String sign = MD5Sign.sign(map, didi_key);
			map.put("sign", sign);
			
			String param = "client_id=" + didi_client_id + "&access_token="
					+ didi_client_secret + "&timestamp=" +time+ "&company_id=" 
					+ company_id + "&offset=" + 1 + "&length=" + 100 + "&sign=" +sign;
					
			logger.info("滴滴返款订单查询开始>>>>>>>>>" , url +"?"+ param);
			String orderdatail = HttpClientUtil.sendGet(url,param);
			logger.info("滴滴返款订单查询结束>>>>>>>>>" + orderdatail);
			Map jsonmap = (Map) JSONObject.parse(orderdatail);
			float totalPrice = 0 ;
			List<DiDiCashBackEntity> ddcashBackList = new ArrayList<DiDiCashBackEntity>();
 			if(jsonmap != null){
				Object stringData = jsonmap.get("data");
				if(stringData != null){
					Map dataMap = (Map) JSONObject.parse(stringData.toString());
					JSONArray detailObj = (JSONArray) dataMap.get("records");
					if(detailObj != null){
						for(int i = 0 ; i < detailObj.size() ; i++){
							String job = detailObj.getJSONObject(i).toString();
							DiDiCashBackEntity cashentity = JSON.parseObject(job, DiDiCashBackEntity.class);
							if(cashentity != null){
								totalPrice  = totalPrice + cashentity.getTotal_price();
							}
							ddcashBackList.add(cashentity);
						}
					}
				}
			}
 			jonum.put("jsonmap", jsonmap);
 			jonum.put("url", url +"?"+ param);
 			jonum.put("ddcashBackList", ddcashBackList);
 			jonum.put("size", ddcashBackList.size());
 			jonum.put("totalPrice", totalPrice);
			writeToPage(jonum);
		} catch (Exception e) {
			logger.info("滴滴返款订单查询异常>>>>>>>>>" + e.getMessage());
			resultMap.put("errno", 1);
			resultMap.put("errmsg", "滴滴返款订单查询异常>>>>>>>>>" + e.getMessage());
			writeToPage(resultMap);
		}
		
	}
	/**
	 * @return the didi_didilist
	 */
	public String getDidi_didilist() {
		return didi_didilist;
	}
	/**
	 * @param didi_didilist the didi_didilist to set
	 */
	public void setDidi_didilist(String didi_didilist) {
		this.didi_didilist = didi_didilist;
	}
	/**
	 * @return the company_id
	 */
	public String getCompany_id() {
		return company_id;
	}
	/**
	 * @param company_id the company_id to set
	 */
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	
}
