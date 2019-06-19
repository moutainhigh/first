package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.shared.domain.MonitorCountInfoEntity;
import com.deppon.dpm.module.management.server.service.IBusSiteService;
import com.deppon.dpm.module.management.shared.domain.BusMessageView;
import com.deppon.dpm.module.management.shared.domain.BusSiteInfo;

/**   
* @Description: 站点管理Action
* @author 268087 张广波
* @date 2015-11-16 下午2:51:39 
* @version V1.0 
*/
public class BusSiteAction extends BaseAction {
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(BusSiteAction.class);
	private static final long serialVersionUID = 1L;
	/** 
	* @Fields busSiteService 站点管理service
	*/ 
	private IBusSiteService busSiteService;

	/** 
	* @Description: 查询所有站点集合
	* @author 268087 张广波
	* @date 2015-11-16 下午2:51:54  
	*/
	public void queryAllBusSite(){
			String res = "{\"busSiteList\":";
			HttpServletResponse response = setPageHead();
			try {
				//获取所有站点
				List<BusSiteInfo> busSiteList = busSiteService.queryAllBusSite();		
				res+=JsonUtil.beanToJsonString(busSiteList);					
			} catch (Exception e) {
				e.printStackTrace();
			}
			res+="}";
			// 返回给页面
			writeToPage(response, res);
	}

	/** 
	* @Description: 数据监控
	* @author 268087 张广波
	* @date 2015-11-16 下午2:51:23  
	*/
	public void busServiceWatch(){
		Date startDate = new Date();//起始时间
		HttpServletResponse response = setPageHead();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("resultFlag","false");
		retMap.put("failureReason","请求参数获取不到!");
		String res = "";
		BufferedReader bu = null;
		String str = "";
		try {
			bu = ServletActionContext.getRequest().getReader();
			str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			logger.info("**************传入监控参数为：" + str);
			if (!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {				
				JSONObject json = new JSONObject().parseObject(str);
				if(json.getString("userId")!=null&&json.getString("watchType")!=null){//判断前台提交的员工工号和监控类型				
					MonitorCountInfoEntity countInfoEntity = new MonitorCountInfoEntity();
					countInfoEntity.setUserId(json.getString("userId"));
					countInfoEntity.setStartTime(startDate);
					countInfoEntity.setEndTime(new Date());//结束时间
					countInfoEntity.setType(Integer.parseInt(json.getString("watchType")));
					//插入监控信息
					int resInt = busSiteService.busServiceWatch(countInfoEntity);
					if (resInt==1) {
						retMap.put("resultFlag","true");
						retMap.put("failureReason","监控成功!");
					}
					else{
						retMap.put("resultFlag","false");
						retMap.put("failureReason","监控失败!");
					}
				}
			}			
			res = JsonUtil.mapToJsonString(retMap);
			writeToPage(response, res);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	/** 
	* @Description: 根据起始时间获取线路站点集合
	* @author 268087 张广波
	* @date 2015-11-16 下午2:52:15 
	*  @throws ParseException 
	*/
	public void selectBusSiteLineByTime() throws ParseException   {
		HttpServletResponse response = setPageHead();
		HttpServletRequest request = ServletActionContext.getRequest();
		String res = "{\"busMessageView\":";		
		List<BusMessageView> busMessageViewList = new ArrayList<BusMessageView>();
		if(request.getParameter("startTime")!=null&&!"".equals(request.getParameter("startTime"))){
			String strDate = request.getParameter("startTime").trim();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			//起始时间
			Date startDate =sdf.parse(strDate);	
			//传入一个Date类型的参数
			busMessageViewList  = busSiteService.selectBusSiteLineByTime(startDate);		
			for (int i = 0; i < busMessageViewList.size(); i++) {
				busMessageViewList.get(i).setStartTime(strDate);
			}
			res+=JsonUtil.beanToJsonString(busMessageViewList);
		}
		res+="}";
		// 返回给页面
		writeToPage(response, res);
	}

	/** 
	* @Description: 修改站点信息
	* @author 268087 张广波
	* @date 2015-11-16 下午2:52:27 
	*  @throws IOException 
	*/
	public void updateBusSite() throws IOException{
		HttpServletResponse response = setPageHead();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("resultFlag","false");
		retMap.put("failureReason","站点ID获取不到!");	
		String res = "";
		BufferedReader bu = null;
		String str = "";
		try {
			bu = ServletActionContext.getRequest().getReader();
			str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			logger.info("传入修改站点参数为：" + str);
			if (!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {				
				JSONObject json = new JSONObject().parseObject(str);
				if(json.getString("id")!=null){//如果站点ID不为空
					int id = json.getInteger("id");
					//根据主键ID查询站点线路信息
					BusSiteInfo busSiteInfo = busSiteService.searchByID(id);	
					busSiteInfo.setSiteName(json.getString("siteName"));
					busSiteInfo.setAddress(json.getString("address"));
					busSiteInfo.setLineName(json.getString("lineName"));
					busSiteInfo.setUserName(json.getString("userName"));
					busSiteInfo.setTel(json.getString("tel"));
					int retInt = busSiteService.updateBusSite(busSiteInfo);
					if (retInt==1) {
						retMap.put("resultFlag","true");
						retMap.put("failureReason","更新成功!");
					}
					else{
						retMap.put("resultFlag","false");
						retMap.put("failureReason","更新失败!");
					}
				}	
			}			
			res = JsonUtil.mapToJsonString(retMap);
			writeToPage(response, res);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	/** 
	* @Description:  删除某条线路
	* @author 268087 张广波
	* @date 2015-11-16 下午2:52:41 
	*  @throws IOException 
	*/
	public void deleteBusLine() throws IOException{
		HttpServletResponse response = setPageHead();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("resultFlag","false");
		retMap.put("failureReason","线路ID获取不到!");
		HttpServletRequest request = ServletActionContext.getRequest();		
		if(request.getParameter("lineId")!=null){//如果站点ID不为空
			logger.info("*******************************线路ID="+request.getParameter("lineId").toString()+"****************************");
			int id = Integer.parseInt(request.getParameter("lineId").toString());
			//删除线路信息
			int retInt = busSiteService.deleteBusLine(id);
			if (retInt>1) {
				retMap.put("resultFlag","true");
				retMap.put("failureReason","更新成功!");
			}
			else{
				retMap.put("resultFlag","false");
				retMap.put("failureReason","更新失败!");
			}
		}	
		String retStr = JsonUtil.mapToJsonString(retMap);
		writeToPage(response, retStr);		
	}

	/** 
	* @Description: 判断当前用户是否是班车管理员
	* @author 268087 张广波
	* @date 2015-11-16 下午2:52:55  
	*/
	public void checkIsAdmin(){
		HttpServletResponse response = setPageHead();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("resultFlag","false");
		retMap.put("failureReason","员工号获取不到!");
		String res = "";
		BufferedReader bu = null;
		String str = "";
		try {
			bu = ServletActionContext.getRequest().getReader();
			str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			logger.info("传入参数为：" + str);
			if (!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {				
				JSONObject json = new JSONObject().parseObject(str);
				if(json.getString("uid")!=null){//如果站点ID不为空
					String empCode = json.getString("uid");
					//传入当前登录用户的员工号，如果是管理员就返回int类型数值1
					int retInt = busSiteService.checkIsAdmin(empCode);
					if (retInt==1) {
						retMap.put("isAdmin","true");
						retMap.put("resultFlag","true");
						retMap.put("failureReason","当前用户是管理员!");
					}
					else{
						retMap.put("isAdmin","false");
						retMap.put("resultFlag","false");
						retMap.put("failureReason","当前用户是乘车人!");
					}
				}	
			}			
			res = JsonUtil.mapToJsonString(retMap);
			writeToPage(response, res);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	/**
	 * 公共方法
	 * @return
	 */
	private HttpServletResponse setPageHead() {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		return response;
	}

	/** 
	* @Description: 获取站点管理service
	* @author 268087 张广波
	* @date 2015-11-16 下午5:27:45 
	*  @return 
	*/
	public IBusSiteService getBusSiteService() {
		return busSiteService;
	}

	/** 
	* @Description: 设置站点管理service
	* @author 268087 张广波
	* @date 2015-11-16 下午5:28:13 
	*  @param busSiteService 
	*/
	public void setBusSiteService(IBusSiteService busSiteService) {
		this.busSiteService = busSiteService;
	}
	
}
