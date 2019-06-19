/**
 * Project Name:DPMontal_20141030
 * File Name:AfficheManagerServlet.java
 * Package Name:com.deppon.montal.module.affiche.action
 * Date:2014-10-18上午11:33:10
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.deppon.montal.module.affiche.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.module.affiche.service.IAfficheManagerService;
import com.deppon.montal.module.calendar.service.ICalendarManagerService;
import com.google.gson.Gson;

/**
 * ClassName:AfficheManagerServlet <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * 
 * Date:     2014-10-18 上午11:33:10 <br/>
 * @author   157229-zxy
 * @version  
 * @since    JDK 1.6
 */
public class AfficheManagerServlet extends AppDelegateAction{
	
	/**
	 * 日志
	 */
	private static Logger logger = Logger.getLogger(AfficheManagerServlet.class);
	
	private IAfficheManagerService afficheManagerService;
	
	private final static String SUCCESS = "0";
	
	private final static String ERROR = "1";
	
	@Override
	protected void response() {
		logger.info("公告图片操作开始[AfficheManagerServlet start...]");
		String content = reqPara.get("content");
		logger.info("参数[content:" + content);
		String json = "";
		String resultCode = SUCCESS;
		if(afficheManagerService == null)
			afficheManagerService = getService("afficheManagerService");
		try {
			json = afficheManagerService.queryInnerGg("{\"content\":\"\"}");
		} catch (Exception e1) {
			e1.printStackTrace();
			json = e1.getMessage();
			resultCode = ERROR;
		}
		System.out.println(json+"----------");
		//返回json报文
		Map<String,String> resultMap = new HashMap<String, String>();
		
		resultMap.put("resultCode", resultCode);
		resultMap.put("resultContent", json);
		Gson gson = new Gson();
		try {
			response.getWriter().write(gson.toJson(resultMap));
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("公告图片操作结束[AfficheManagerServlet end.]");
	}
	
	/**
	 * 获取服务
	 * getCalendarManagerService: <br/>
	 * 
	 * Date:2014-10-14上午9:46:56
	 * @author 157229-zxy
	 * @return
	 * @since JDK 1.6
	 */
	private<T> T getService(String serviceName){
		ServletContext servletContext = this.getServletContext();  
		  
        WebApplicationContext ctx = WebApplicationContextUtils  
                .getWebApplicationContext(servletContext);  
  
        T service = (T) ctx.getBean(serviceName);
        return service;
	}

}

