package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.service.IServeOrigWorkService;
import com.deppon.dpm.module.management.shared.domain.ServeOriginatorsInfoEntity;
import com.deppon.dpm.module.management.shared.domain.ServeParticipantsInfoEntity;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**   
* @Description: 拼车吧
* @author 268087 张广波
* @date 2015-11-16 下午2:46:31 
* @version V1.0 
*/
public class ServeOrigWorkAction extends BaseAction {
	Logger logger = LoggerFactory.getLogger(ServeOrigWorkAction.class);
	private static final long serialVersionUID = 1L;
	/** 
	* @Fields serveOrigWorkService 拼车吧service
	*/ 
	private IServeOrigWorkService serveOrigWorkService;
	
	/** 
	* @Description: 所有更新发布信息接口
	* @author 268087 张广波
	* @date 2015-11-3 上午9:22:39  
	*/
	public void updateOrigInfo() throws Exception {
		HttpServletResponse response = setPageHead();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		if ("POST".equals(ServletActionContext.getRequest().getMethod())) {			
			retMap.put("resultFlag",false);
			retMap.put("failureReason","参数获取不到!");
			String res = "";
			BufferedReader bu = null;
			String str = "";
			try {
				bu = ServletActionContext.getRequest().getReader();
				str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
				logger.info("传入参数为：" + str);
				if (!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {	
					//如果报名截止时间和当前时间重叠，就不允许修改
					if (checkPartTime(str)) {
						retMap.put("resultFlag",false);
						retMap.put("failureReason","出发时间与当前时间临近期间不能修改!");
						res = JsonUtil.mapToJsonString(retMap);
						writeToPage(response, res);
						return;
					}
					//获取前端传过的参数实例化对象
					ServeOriginatorsInfoEntity infoEntity = JsonUtil.jsonToEntity(JsonUtil.jsonGetValueBykey(str, "infoEntity"), ServeOriginatorsInfoEntity.class);
					if (infoEntity!=null) {
						//发布者更新发布信息
						int retInt = serveOrigWorkService.updateOrigInfo(infoEntity);
						if (retInt>0) {
							retMap.put("resultFlag",true);
							retMap.put("failureReason","修改成功!");
						}
						else {
							retMap.put("resultFlag",false);
							retMap.put("failureReason","修改失败!");
						}
					}
					else {
						retMap.put("resultFlag",false);
						retMap.put("failureReason","对象实例化失败!");
					}
				}
			}catch (Exception e) {
				logger.info("====异常信息==》调用活动拼车更新发布信息接口出现异常!");
				retMap.put("resultFlag",false);
				retMap.put("failureReason","调用活动拼车更新发布信息接口出现异常!");
			}		
			res = JsonUtil.mapToJsonString(retMap);
			writeToPage(response, res);
		}
	}

	/** 
	* @Description: 所有更新参与信息接口
	* @author 268087 张广波
	* @date 2015-11-3 上午9:22:39  
	*/
	public void updatePartInfo() {
		HttpServletResponse response = setPageHead();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		if ("POST".equals(ServletActionContext.getRequest().getMethod())) {			
			retMap.put("resultFlag",false);
			retMap.put("failureReason","参数获取不到!");
			String res = "";
			BufferedReader bu = null;
			String str = "";
			try {
				bu = ServletActionContext.getRequest().getReader();
				str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
				logger.info("传入参数为：" + str);
				if (!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {	
					//如果报名截止时间和当前时间重叠，就不允许修改
					/*if (checkPartTime(str)) {
						retMap.put("resultFlag",false);
						retMap.put("failureReason","出发时间与当前时间临近期间不能修改!");
						res = JsonUtil.mapToJsonString(retMap);
						writeToPage(response, res);
						return;
					}*/
					//获取前端传过的参数实例化对象
					ServeParticipantsInfoEntity infoEntity = JsonUtil.jsonToEntity(JsonUtil.jsonGetValueBykey(str, "infoEntity"), ServeParticipantsInfoEntity.class);					
					if (infoEntity!=null) {
						//修改参与信息
						int retInt = serveOrigWorkService.updatePartInfo(infoEntity);
						if (retInt>0) {
							retMap.put("resultFlag",true);
							retMap.put("failureReason","修改成功!");
						}
						else {
							retMap.put("resultFlag",false);
							retMap.put("failureReason","修改失败!");
						}
					}
					else {
						retMap.put("resultFlag",false);
						retMap.put("failureReason","对象实例化失败!");
					}
				}
			}catch (Exception e) {
				logger.info("====异常信息==》调用活动拼车更新参与信息接口出现异常!");
				retMap.put("resultFlag",false);
				retMap.put("failureReason","调用活动拼车更新参与信息接口出现异常!");
			}		
			res = JsonUtil.mapToJsonString(retMap);
			writeToPage(response, res);
		}
	}
	
	/** 
	* @Description: 比较出发时间和当前时间
	* @author 268087 张广波
	* @date 2015-11-16 下午2:50:10 
	*  @param str
	*  @return
	 * @throws ParseException 
	*/
	private  boolean checkPartTime(String str) throws ParseException {		
		boolean flag = false;
		JSONObject json = new JSONObject().parseObject(str);
		if (!StringUtil.isBlank(json.getString("startTime"))) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			//报名截止时间
			Date partTime = sdf.parse(json.getString("startTime"));
			//当前时间
			Date dt = new Date();
			flag = partTime.after(dt);
		}
		return flag;
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
	* @Description: 获取拼车吧service
	* @author 268087 张广波
	* @date 2015-11-16 下午5:26:44 
	*  @return 
	*/
	public IServeOrigWorkService getServeOrigWorkService() {
		return serveOrigWorkService;
	}

	/** 
	* @Description: 设置拼车吧service
	* @author 268087 张广波
	* @date 2015-11-16 下午5:26:57 
	*  @param serveOrigWorkService 
	*/
	public void setServeOrigWorkService(IServeOrigWorkService serveOrigWorkService) {
		this.serveOrigWorkService = serveOrigWorkService;
	}
}
