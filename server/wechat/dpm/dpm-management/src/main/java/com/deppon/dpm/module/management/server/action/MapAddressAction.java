package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.HttpUtil;

import com.deppon.dpm.module.management.server.service.IMapAddressService;

/**
 * 
 * @author 王亚男
 * 工程验收 地图 获取项目Action
 */
public class MapAddressAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2845766873793037923L;
	
	private Logger logger = LoggerFactory.getLogger(MapAddressAction.class);
	
	/**
	 * 地图类信息service
	 */
	private IMapAddressService addressService;
	
	public MapAddressAction(){
		
	}
	
	/**
	 * 查询最近地理位置部门信息
	 * latitude纬度  longitude经度
	 */
	public void getMapAddress(){
		logger.info("getMapAddress by x,y");
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		BufferedReader bu = null;
		//设置响应信息
		String str = "";
		String res = "";
		try{
			bu = ServletActionContext.getRequest().getReader();
			str = com.deppon.dpm.module.common.server.util.StringUtil
					.bufferString(bu);
			//参数是否为空
			if(StringUtils.isNotEmpty(str)){
				JSONObject json = JSON.parseObject(str);
				logger.info("参数为:" + json);
				String latitude = json.getString("latitude");
				String longitude = json.getString("longitude");
				//判断经纬度是否为空
				if(StringUtils.isNotEmpty(latitude)&&StringUtils.isNotEmpty(longitude)){
					res = this.addressService.getNameInfoByXY(longitude, latitude);	
				}else{
					//经纬度为空
					res = "{\"resultFlag\":false,\"failureReason\":\"参数为空!\"}";
				}
				str = getCurrentAddressInfo(latitude,longitude);
			}else{
				//参数为空
				res = "{\"resultFlag\":false,\"failureReason\":\"参数为空!\"}";
				str = "{\"resultMapFlag\":false,\"failureReason\":\"参数为空!\"}";
			}
		}catch (Exception e) {
			logger.error("getMapAddressList has error");
			res = "{\"resultFlag\":false,\"failureReason\":\"没有查询结果!\"}";
		}
		if(StringUtils.isEmpty(res)){
			res = "{\"resultFlag\":false,\"failureReason\":\"没有查询结果!\"}";
		}
		if(StringUtils.isEmpty(str)){
			res = "{\"resultMapFlag\":false,\"failureReason\":\"没有查询结果!\"}";
		}
		res = "["+res+","+str+"]";
		writeToPage(response, res);
	}
	
	
	
	/**
	 * 根据经纬对获取地理位置信息
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	public String getCurrentAddressInfo(String latitude,String longitude){
		String res = "";
		//经纬度是否为空
		if(StringUtils.isNotEmpty(latitude)&&StringUtils.isNotEmpty(longitude)){
			//不为空
			try{
				//百度map api URL
				String url = "http://api.map.baidu.com/geocoder";
				//设置参数格式
				String param = "location=" + latitude + "," + longitude
						+ "&output=json&key=28bcdd84fae25699606ffad27f8da77b";
				//发送参数 并 接收结果
				String result = HttpUtil.getHttp(url, param, "utf-8");
				//解析返回结果 为 JOSN
				JSONObject object = ((JSONObject) JSONObject.parseObject(result).get(
						"result"));
				//获取需要的结果信息
				String forAddress = object.getString("formatted_address");
				//设置返回格式
				res = "{\"resultMapFlag\":true,\"address\":\""+forAddress+"\"}";
				logger.info("address"+res+"::::"+object.toJSONString());
			}catch (Exception e) {
				logger.info("getBaiduMap has error");
				res = "{\"resultMapFlag\":false,\"failureReason\":\"百度地位出现异常!\"}";
			}
		}else{
			//经纬为空
			res = "{\"resultMapFlag\":false,\"failureReason\":\"参数为空!\"}";
		}
		return res;
		
	}
	
	public IMapAddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(IMapAddressService addressService) {
		this.addressService = addressService;
	}
	
	
}
