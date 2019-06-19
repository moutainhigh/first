/**
 * Project Name:DPMotal_20140925
 * File Name:AddScheduleServlet.java
 * Package Name:com.deppon.montal.module.calendar.action
 * Date:2014-10-13下午6:36:19
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.deppon.montal.module.calendar.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.login.service.UserLoginService;
import com.deppon.montal.module.calendar.service.ICalendarManagerService;
import com.deppon.montal.util.Base64;
import com.deppon.montal.util.JSONUtil;
import com.google.gson.Gson;

/**
 * ClassName:AddScheduleServlet <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * 
 * Date:     2014-10-13 下午6:36:19 <br/>
 * @author   157229-zxy
 * @version  
 * @since    JDK 1.6
 */
public class CalendarManagerServlet extends AppDelegateAction{
	
	/**
	 * 日志
	 */
	private static Logger logger = Logger.getLogger(CalendarManagerServlet.class);
	
	/**
	 * 新增
	 */
	private final static String CALENDAR_ADD = "ADD";
	
	/**
	 * 修改
	 */
	private final static String CALENDAR_UPDATE = "UPDATE";
	
	/**
	 * 删除
	 */
	private final static String CALENDAR_DELETE = "DELETE";
	
	/**
	 * 查询单日
	 */
	private final static String CALENDAR_QUERY_DATE = "QUERY_DATE";
	
	/**
	 * 查询月
	 */
	private final static String CALENDAR_QUERY_MONTH = "QUERY_MONTH";
	
	private ICalendarManagerService calendarManagerService;
	
	private final static String SUCCESS = "1";
	
	private final static String ERROR = "0";
	private UserLoginService loginService = new UserLoginService();
	private void userinfocheck(String useridss){
		try {
			System.out.println("userid==============="+useridss);
			useridss =new String(Base64.decryptBASE64(useridss));
			String userId = useridss.substring(0, useridss.indexOf("|"));
			String password = useridss.substring(useridss.indexOf("|") + 1);
			logger.info("userId=" + userId + "" + "password=" + password);
			String sessionId = getSessionId();
			LoginUser user = (LoginUser) getUserRedisService()
				.getFromRedisBySession(sessionId);
			System.out.println(user + "============");
			HttpSession session = request.getSession();
			// 验证通过，封装用户信息
			String sid = session.getId();
			logger.info("SSOLogonAction------------------->userid = "
					+ userId + " ,sessionId = " + sid);

			LoginUser login = null;
			if (userId != null)
			{// 先从redis缓存中查询用户是否存在
				login = (LoginUser) getUserRedisService().getFromRedis(
						userId);
			}
			if (login == null)
			{// 若是redis缓存中不存在user信息，再到数据库中核对有没有该用户
				login = loginService.getLoginUser(userId);
				if (login != null)
				{
					// 向redis缓存中添加用户信息
					getUserRedisService().add2Redis(login);
				}
			}
			System.out.println(login + "---------" + userId + "---------"
					+ password);
			if (null != login)
			{
				user = login;
				// TODO 首先把用户的信息与session绑定到一块
				getUserRedisService().add2Redis(sid, userId);
				request.getSession().setAttribute("loginUser", login);
				// response.getWriter().write("success");//成功
			}
			else
			{
				response.getWriter().write("error");// 用户名密码错误
				request.setAttribute("errors", "工号或密码错误！");
				return ;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	protected void response() {
		logger.info("日程操作开始[CalendarManagerServlet start...]");
		//操作类型:ADD,DELETE,UPDATE,QUERY
		String oprateType = reqPara.get("oprateType");
		String content = reqPara.get("content");
//		String version = reqPara.get("version");
//		if("new".equals(version)){
			String useridss=reqPara.get("userid");
			userinfocheck(useridss);
//		}
		logger.info("参数[oprateType:" + oprateType + ",content:" + content + "]");
		if(calendarManagerService == null)
			calendarManagerService = getService("calendarManagerService");
		String resultCode = SUCCESS;
		String resultContent = "";
		try{
			//参数验证
			if(StringUtils.isBlank(oprateType)){
				throw new Exception("oprateType不能为空");
			}
			if(StringUtils.isBlank(content)){
				throw new Exception("content不能为空");
			}
			if(!CALENDAR_ADD.equals(oprateType) && !CALENDAR_UPDATE.equals(oprateType)
					&& !CALENDAR_DELETE.equals(oprateType) && !CALENDAR_QUERY_DATE.equals(oprateType)
					&& !CALENDAR_QUERY_MONTH.equals(oprateType)){
				throw new Exception("操作类型无法识别[oprateType:" + oprateType + "]");
			}
//			if(!"new".equals(version)){
//				String sessionid=sessionid();
//				System.out.println("---------------"+sessionid);
//				if(sessionid.equals("userisnull")){
//					response.getWriter().write("userisnull");
//					return;
//				}
//			}
			//调用服务
			if(CALENDAR_ADD.equals(oprateType)){
				calendarManagerService.addSchedule(translate2AddContent(content));
			}else if(CALENDAR_UPDATE.equals(oprateType)){
				calendarManagerService.updateSchedule(translate2UpdContent(content));
			}else if(CALENDAR_DELETE.equals(oprateType)){
				calendarManagerService.deleteSchedule(translate2DelContent(content));
			}else if(CALENDAR_QUERY_DATE.equals(oprateType)){
				resultContent = calendarManagerService.querySchedule(translate2QueryDateContent(content));
			}else if(CALENDAR_QUERY_MONTH.equals(oprateType)){
				resultContent = calendarManagerService.querySchedule(translate2QueryMonthContent(content));
			}
		}catch(Exception e){
			logger.error("日程操作失败", e);
			resultContent = e.getMessage();
			resultCode = ERROR;
		}
		
		//返回json报文
		Map<String,String> resultMap = new HashMap<String, String>();
		resultMap.put("resultCode", resultCode);
		resultMap.put("resultContent", resultContent);
		Gson gson = new Gson();
		try {
			response.getWriter().write(gson.toJson(resultMap));
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("日程操作结束[CalendarManagerServlet end.]");
	}
	
	/**
	 * 转换成删除报文
	 * translate2DelContent: <br/>
	 * 
	 * Date:2014-10-20下午2:21:59
	 * @author 157229-zxy
	 * @param content
	 * @return
	 * @throws Exception
	 * @since JDK 1.6
	 */
	private String translate2DelContent(String content) throws Exception{
		//\r\n是转义符号，json转换报错
		content = content.replaceAll("\\n", "\\\\r\\\\n");
		Map paramMap = JSONUtil.toMap(content,String.class,Object.class);
		if(StringUtils.isBlank((String)paramMap.get("date"))){
			throw new Exception("date  is null");
		}
		Map resultMap = new HashMap<String,Object>();
		resultMap.put("type", 4);
		resultMap.put("userid", getUserId());
		resultMap.put("date", paramMap.get("date"));
		return JSONUtil.encapsulateJsonObject(resultMap);
	}
	
	/**
	 * 转换成查询日报文
	 * translate2QueryDateContent: <br/>
	 * 
	 * Date:2014-10-20下午2:21:32
	 * @author 157229-zxy
	 * @param content
	 * @return
	 * @throws Exception
	 * @since JDK 1.6
	 */
	private String translate2QueryDateContent(String content) throws Exception{
		//\r\n是转义符号，json转换报错
		content = content.replaceAll("\\n", "\\\\r\\\\n");
		Map paramMap = JSONUtil.toMap(content,String.class,Object.class);
		if(StringUtils.isBlank((String)paramMap.get("date"))){
			throw new Exception("date is null");
		}
		Map resultMap = new HashMap<String,Object>();
		resultMap.put("type", 5);
		resultMap.put("userid", getUserId());
		resultMap.put("date", paramMap.get("date"));
		return JSONUtil.encapsulateJsonObject(resultMap);
	}
	
	/**
	 * 转换成查询月报文
	 * translate2QueryMonthContent: <br/>
	 * 
	 * Date:2014-10-20下午2:21:19
	 * @author 157229-zxy
	 * @param content
	 * @return
	 * @throws Exception
	 * @since JDK 1.6
	 */
	private String translate2QueryMonthContent(String content) throws Exception{
		//\r\n是转义符号，json转换报错
		content = content.replaceAll("\\n", "\\\\r\\\\n");
		Map paramMap = JSONUtil.toMap(content,String.class,Object.class);
		if(StringUtils.isBlank((String)paramMap.get("month"))){
			throw new Exception("month is null");
		}
		Map resultMap = new HashMap<String,Object>();
		resultMap.put("type", 1);
		resultMap.put("userid", getUserId());
		resultMap.put("month", paramMap.get("month"));
		return JSONUtil.encapsulateJsonObject(resultMap);
	}

	
	/**
	 * 转换成新增报文
	 * translate2AddContent: <br/>
	 * 
	 * Date:2014-10-20上午10:55:41
	 * @author 157229-zxy
	 * @param content
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @since JDK 1.6
	 */
	private String translate2AddContent(String content) throws Exception{
		//\r\n是转义符号，json转换报错
		content = content.replaceAll("\\n", "\\\\r\\\\n");
		Map paramMap = JSONUtil.toMap(content,String.class,Object.class);
		if(StringUtils.isBlank((String)paramMap.get("date"))){
			throw new Exception("create is null");
		}
		if(StringUtils.isBlank((String)paramMap.get("notice"))){
			throw new Exception("body is null");
		}
		Map resultMap = new HashMap<String,Object>();
		resultMap.put("type", 2);
		resultMap.put("userid", getUserId());
		resultMap.put("date", paramMap.get("date"));
		resultMap.put("operatorid", paramMap.get("operate"));
		resultMap.put("finish", paramMap.get("finish"));
		resultMap.put("notice", paramMap.get("notice"));
		return JSONUtil.encapsulateJsonObject(resultMap);
	}
	
	/**
	 * 转换成修改报文
	 * translate2UpdContent: <br/>
	 * 
	 * Date:2014-10-20上午10:55:57
	 * @author 157229-zxy
	 * @param content
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @since JDK 1.6
	 */
	private String translate2UpdContent(String content) throws Exception{

		content = content.replaceAll("\\n", "\\\\r\\\\n");
		Map paramMap = JSONUtil.toMap(content,String.class,Object.class);
		Map resultMap = new HashMap<String,Object>();
		if(StringUtils.isBlank((String)paramMap.get("date"))){
			throw new Exception("create is null");
		}
		if(StringUtils.isBlank((String)paramMap.get("notice"))){
			throw new Exception("body is null");
		}
		resultMap.put("type", 3);
		resultMap.put("userid", getUserId());
		resultMap.put("date", paramMap.get("date"));
		resultMap.put("operatorid", paramMap.get("operate"));
		resultMap.put("finish", paramMap.get("finish"));
		resultMap.put("notice", paramMap.get("notice"));
		return JSONUtil.encapsulateJsonObject(resultMap);
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

