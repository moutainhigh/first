/**
 * 
 */
package com.deppon.montal.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import com.deppon.bamp.module.log.client.LogRestServiceClient;
import com.deppon.bamp.module.log.domain.BusiOperEntity;
import com.deppon.bamp.module.log.domain.ReqInfoEntity;
import com.deppon.bamp.module.log.util.HttpRequestUtil;
import com.deppon.bamp.module.log.util.LogClientUtil;
import com.deppon.bamp.util.redis.service.ILogRedisService;
import com.deppon.bamp.util.redis.service.impl.LogRedisServiceImpl;
import com.deppon.foss.framework.shared.util.string.StringUtil;
import com.deppon.montal.conf.Constants;
import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.util.redis.service.IRedis;
import com.deppon.montal.util.redis.service.IRoleJobnameRedis;
import com.deppon.montal.util.redis.service.impl.RoleJobnameService;
import com.deppon.montal.util.redis.service.impl.UserRedisService;

/**
 * 应用代理ACTION，抽象整个应用通用的ACTION
 * 涵盖所有普遍适用于应用项目的ACTION方法
 * 
 * @author lin.liu
 *
 */
public class AppDelegateAction extends RootAbstractAction {

	protected Map<String, String> reqPara;
	
	private static IRedis redisService = null;
	
	private static IRoleJobnameRedis roleJobnameService = null;
	
	//日志redis服务类
	private static ILogRedisService logRedisService = null;
	
	//请求信息实体
	protected static ReqInfoEntity reqInfoEntity = new ReqInfoEntity();
	//业务操作实体
	protected static BusiOperEntity busiOpertEntity = new BusiOperEntity();
	
	/*
	  返回系统默认页面
	 
	protected void response() {
		System.out.println("[AppDelegateAction] response");
	}
	 */
	/**
	 * 获取reids对象
	 */
	public IRedis getUserRedisService(){
		
		if(redisService == null){
			redisService = new UserRedisService();
		}
		return redisService;
	}
	/**
	 * 权限验证
	 */
	public IRoleJobnameRedis getRoleJobnameRedisService(){
		if(roleJobnameService == null){
			roleJobnameService = new RoleJobnameService();
		}
		return roleJobnameService;
	}
	/**
	 * 获取sessionId
	 */
	public String getSessionId(){
		
		return request.getSession().getId();
	}
	
	/**
	 * @MethodName: getLogRedisService 
	 * @description: 获取logRedisService对象
	 * @author: wuyaqing 
	 * @date: 2014-4-19 上午11:42:34
	 * @return IlogRedisService
	 */
	public ILogRedisService getLogRedisService() {
		if(logRedisService == null) {
			logRedisService = new LogRedisServiceImpl();
		}
		return logRedisService;
	}
	
    /**
     * 验证用户的合法性
     * 参数赋值等普遍适用整个应用项目的初始操作
     */
	@Override
	public void initialize() {
		System.out.println("[AppDelegateAction] initialize");
		checkUserValidation();
		
		mapParameters();
		
		/**
		 * 初始化访问参数信息实体
		 */
//		initParamsInfos();
	}

	/**
	 * @see javax.servlet.RequestDispatcher#forward(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 * @param path
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void forward( String path ) throws ServletException, IOException{
		//设置传输文件的MIME类型
		//response.setContentType(Constants.MIME_TYPE_WAP_XHTML);
		
		request.getRequestDispatcher(path).forward(request, response);
		return;
		/**
		 * 调用批量存储请求日志方法
		 */
//		saveAccessInfos();
		
		/**
		 * 实时调用保存访问操作信息方法
		 */
//		saveAccessOperInfo();
	}
	
	/**
	 * @MethodName: initParamsInfos 
	 * @description: 初始化访问参数信息,由子类继承并完善
	 * @author: wuyaqing 
	 * @date: 2014-4-18 下午5:00:18 void
	 */
	protected void initParamsInfos() {
		//设置服务请求时间 时间格式：2014-04-16 08:10:01.123
		reqInfoEntity.setReqTime(LogClientUtil.getNowDate());
		//设置用户账号
		reqInfoEntity.setEmpCode(getUserId());
		//设置类名+方法名
		reqInfoEntity.setMethodName(LogClientUtil.getMethodName());
		//设置命名空间
		reqInfoEntity.setNamespace(request.getContextPath());
		//设置用户ip地址
		reqInfoEntity.setClientIp(getClientIpAddr());
		//http请求url
		reqInfoEntity.setRequestUrl(request.getRequestURL().toString());
		//http请求参数
		reqInfoEntity.setRequestPara(HttpRequestUtil.getParamters(request));
		//http请求其他信息 
		reqInfoEntity.setRequestInfo(HttpRequestUtil.getRequestInfo(request));
		//业务系统IP地址 
		reqInfoEntity.setServerIp(LogClientUtil.serverIp);
	}
	protected String sessionid(){
		String sid = getSessionId();
		if(StringUtil.isNotBlank(sid)) {
			getUserRedisService();
			LoginUser user = (LoginUser) redisService.getFromRedisBySession(sid);
			if(user==null){
				return "userisnull";
			}else{
				return "success";
			}
		}else{
			return "userisnull";
		}
		
	}
	/**
	 * @MethodName: getUserId 
	 * @description: 获取当前登录者的id
	 * @author: wuyaqing 
	 * @date: 2014-4-23 上午10:22:40
	 * @return String
	 */
	protected String getUserId() {
		//获取当前用户的sessionid
		String sid = getSessionId();
		String usreid = "";
		/**
		 * 如果session不为空，并且缓存里面有用户基本信息就从缓存里面取
		 */
		if(StringUtil.isNotBlank(sid)) {
			getUserRedisService();
			LoginUser user = (LoginUser) redisService.getFromRedisBySession(sid);
			if(user != null) {
				usreid = user.getUserId();
			}
		} else {
			/**
			 * 如果sessionid为空，就从请求参数里面取
			 */
			if(reqPara != null) {
				usreid = reqPara.get("userid");
			}
		}
		return usreid;
	}
	
	/**
	 * @MethodName: saveAccessInfos 
	 * @description: 批量保存：先保存访问请求信息到redis，达到一定数量后再调用接口保存到BAMP系统里
	 * @author: wuyaqing 
	 * @date: 2014-4-18 下午6:06:01 void
	 */
	protected void saveAccessInfos() {
		//设置服务响应时间
		reqInfoEntity.setRespTime(LogClientUtil.getNowDate());
		//初始化服务
		getLogRedisService();
		//从redis里面获取访问请求次数
		int count = logRedisService.getReqNumFromRedis();
		
		//当请求次数没有达到一定数量时，就先把请求信息保存到redis
		if(count < LogClientUtil.COUNT) {
			logRedisService.saveReqInfo(reqInfoEntity);
		} else {
			ReqInfoEntity logentity;
			List<ReqInfoEntity> list = new ArrayList<ReqInfoEntity>();
			for(int i=count;i>0;i--) {
				/**
				 * 从redis里面依次取出请求信息
				 */
				logentity = (ReqInfoEntity) logRedisService.getReqInfoFromRedis();
				list.add(logentity);
			}
			//通过客户端调BPMS接口记录操作日志
			LogRestServiceClient.saveReqInfos(list);
		}
	}
	
	/**
	 * @MethodName: saveAccessOperInfo 
	 * @description: 实时调用接口把访问操作信息保存到BAMP系统里
	 * @author: wuyaqing 
	 * @date: 2014-4-22 上午11:08:12 void
	 */
	protected void saveAccessOperInfo() {
		//设置服务响应时间
		reqInfoEntity.setRespTime(LogClientUtil.getNowDate());
		
		//通过客户端调BPMS接口记录操作日志
		LogRestServiceClient.insertReqInfo(reqInfoEntity);
	}
	
	/**
	 * @see 
	 * @param path
	 */
	protected void redirect( String path ){
		
	}
	
	/**
	 * 封装业务逻辑返回的结果集
	 * @param parameters
	 */
	protected void putParameters(Map<String, Collection> parameters){
		request.setAttribute(Constants.PAGE_RESULT, parameters);
	}
	
	/**
	 * 封装页面传入的参数
	 */
	protected void mapParameters(){
		System.out.println("[AppDelegateAction] mapParameters");
		Enumeration pm = request.getParameterNames();
		reqPara = new HashMap<String, String>();
		try {
			
			String userAgent = request.getHeader("user-agent");
			System.out.println("user-agent===="+userAgent);
			String ui_type = "";
			String app_ui = "";
			String isDisplayFiles = "";
			//根据user-agent 是否包含Mobile 判断是否是app访问
			if (userAgent.contains(F_Constants.IS_DISPLAY_FILES)) {
				isDisplayFiles = "display";
			}
			if(null == userAgent){//ios会出现为null，所以跳转ios
				request.getSession().setAttribute("ui_type", F_Constants.UI_IOS);
				request.getSession().setAttribute("app_ui", false);
				app_ui = "false";
				ui_type = F_Constants.UI_IOS;
			}else{
				if(userAgent.indexOf(F_Constants.APP_IOS) > -1){
					request.getSession().setAttribute("ui_type", F_Constants.UI_IOS);
					request.getSession().setAttribute("app_ui", true);
					app_ui = "ture";
					ui_type = F_Constants.UI_IOS;
				}else if(userAgent.indexOf(F_Constants.APP_Android) > -1){
					request.getSession().setAttribute("ui_type", F_Constants.UI_WIN8);
					request.getSession().setAttribute("app_ui", true);
					app_ui = "ture";
					ui_type = F_Constants.UI_WIN8;
				}else if(userAgent.indexOf(F_Constants.UI_IPHONE) > -1){
					request.getSession().setAttribute("ui_type", F_Constants.UI_IOS);
					request.getSession().setAttribute("app_ui", false);
					app_ui = "false";
					ui_type = F_Constants.UI_IOS;
				}else{
					request.getSession().setAttribute("ui_type", F_Constants.UI_WIN8);
					request.getSession().setAttribute("app_ui", false);
					app_ui = "false";
					ui_type = F_Constants.UI_WIN8;
				}
			}
			reqPara.put("isDisplayFiles", isDisplayFiles);
			reqPara.put("ui_type", ui_type);
			reqPara.put("app_ui", app_ui);
			
			while( pm.hasMoreElements() ){
				String pname = (String)pm.nextElement();
				String pvalue = request.getParameter( pname );
					//pvalue = new String(pvalue.getBytes("iso-8859-1"), "UTF-8");
				pvalue = java.net.URLDecoder.decode(pvalue,"UTF-8");
				reqPara.put(pname, pvalue);
				request.setAttribute(pname, pvalue);
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    /**
     * 校验用户的合法身份
     */
	private void checkUserValidation(){
	
	}
	
	/**
	 * 获得客户端IP，理论上可行，实际使用需谨慎
	 * 
	 * @return
	 */
	public final String getClientIpAddr() {  
        String ip = request.getHeader("X-Forwarded-For");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    }
}
