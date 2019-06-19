package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.service.IProcCheckTaskService;

/**   
* @author 268087 张广波
* @date 2015-8-12 下午3:19:45 
* @version V1.0 
*/
public class ProcCheckWorkAction extends BaseAction {
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(ProcCheckWorkAction.class);
	private static final long serialVersionUID = 1L;
	/** 
	* @Fields checkTaskService 验收任务service
	*/ 
	private IProcCheckTaskService checkTaskService;
	
	/** 
	* @Description: 查询当前用户验收任务数量
	* @author 268087 张广波
	* @date 2015-8-14 下午2:55:09  
	*/
	public void queryTaskCount(){		
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
			logger.info("传入修改站点参数为：" + str);
			if (!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {				
				JSONObject json = new JSONObject().parseObject(str);
				//判断前台提交的员工工号和监控类型
				if(json.getString("empNo")!=null&&str.indexOf("empNo")>0){				
					int resInt = checkTaskService.queryTaskCount(json.getString("empNo"));
					if (resInt!=0) {
						retMap.put("checkTaskCount",resInt);
						retMap.put("resultFlag","true");
						retMap.put("failureReason","查询验收任务成功!");
					}
					else{
						retMap.put("resultFlag","false");
						retMap.put("failureReason","当前用户没有验收任务!");
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
	* @Description: 获取验收service
	* @author 268087 张广波
	* @date 2016-1-5 下午3:49:26 
	*  @return 
	*/
	public IProcCheckTaskService getCheckTaskService() {
		return checkTaskService;
	}

	/** 
	* @Description: 设置验收service
	* @author 268087 张广波
	* @date 2016-1-5 下午3:50:04 
	*  @param checkTaskService 
	*/
	public void setCheckTaskService(IProcCheckTaskService checkTaskService) {
		this.checkTaskService = checkTaskService;
	}	
}
