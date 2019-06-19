package com.deppon.montal.util;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.login.service.SSOLogonService;
import com.deppon.montal.login.service.UserLoginService;
import com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient;
import com.deppon.montal.util.redis.service.IRedis;
import com.deppon.montal.util.redis.service.impl.UserRedisService;

/**
 * 验证用户是否已经登录UserLoginCheckFilter
 */
public class UserLoginCheckFilter implements Filter {

	
		private List list = new ArrayList();
		private static Logger logger  = Logger.getLogger(UserLoginCheckFilter.class);
		private IRedis redisService = new UserRedisService();
		private UserLoginService loginService = new UserLoginService();
		public void destroy() {
			
		}

		public void doFilter(ServletRequest request, ServletResponse response,
				FilterChain chain) throws IOException, ServletException {
			 
			String path=((HttpServletRequest)request).getServletPath();
			logger.info("===================当前访问路径:" + path);
			String controller=((HttpServletRequest)request).getParameter("controller");
			if(path.indexOf("/html5/")>-1||controller!=null&&"1".equals(controller)){
				logger.info("path路径中有/html5======================");
				chain.doFilter(request, response);
			}else if(path.indexOf("/downloadFiles") > -1){
				chain.doFilter(request, response);
			}else{
				
			
			boolean flag = true;
			
			if(path.equals("/login") || path.equals("/logincheck") || path.equals("/login_redirect.jsp") ||path.equals("/rollnewsimage")
					||path.equals("/autofresh") || path.equals("/appTimeOut.jsp")|| path.equals("/services") || "/error.jsp".equals(path)){
				logger.info("path路径中有/login======================");
				chain.doFilter(request, response);
			}else{
				
				if(path.indexOf(".")==-1 || path.indexOf(".jsp")!=-1|| path.indexOf(".html")!=-1){//需要拦截
					//校验是否通过 当前用户会话是否存在
					logger.info("校验是否通过 当前用户会话是否存在==============");
					flag = false;
					//跳转地址
					String path1 = ((HttpServletRequest)request).getContextPath(); 
					logger.info("跳转地址path1==============");
					String basePath = InitDataServlet.getValue("dpm_domain_url") + "://"   
				            + request.getServerName() + ":" + request.getServerPort()   
				            + path1;
					
					//是否APP访问
					String app_ui = "";
					String userAgent = ((HttpServletRequest)request).getHeader("user-agent");
					if(null == userAgent){//ios会出现为null，所以跳转ios
						logger.info("ios会出现为null，所以跳转ios==============");
						app_ui = "false";
					}else{
						if(userAgent.indexOf(F_Constants.APP_IOS) > -1){
							logger.info("app_ios==============");
							app_ui = "true";
						}else if(userAgent.indexOf(F_Constants.APP_Android) > -1){
							logger.info("APP_Android==============");
							app_ui = "true";
						}else if(userAgent.indexOf(F_Constants.UI_IPHONE) > -1){
							logger.info("UI_IPHONE==============");
							app_ui = "false";
						}else{
							logger.info("走最后的else==============");
							app_ui = "false";
						}
					}
					
					String sessionId = ((HttpServletRequest)request).getSession().getId();
					logger.info("本次请求会话ID------------>sessionId = " + sessionId);
					//校验sessionid
 					boolean b = redisService.checkExists(sessionId);
					logger.info("本次请求sessionID是否有效---------------->b = " + b);
					if(b==false){
						logger.info("-------------------->进入用户名密码验证 ggggggggggg=" + b);
						HttpServletRequest request2=((HttpServletRequest)request);
						logger.info("b=false=============="+request2);
						String userid=request2.getParameter("userid");
						String password=request2.getParameter("password");
						logger.info("userid================password");
						try {
							
							LoginUser login = null;
							
							//用户密码验证
							login = loginService.loginCheck(userid, password);
							logger.info("-------------------->进入用户名密码验证 ggggggggggg=" + userid+"---密码+"+password);
							if(null != login){
								logger.info("login不等于null的情况==============");
								//request.getSession().setAttribute("loginUser", login);
								//response.getWriter().write("success");//成功
								
								//暂时不验证权限
								 if(null != login.getJobName()){
									logger.info("login.getJobName()不等于null的=============="+login.getJobName());
									boolean bool = loginService.validateLoginRole(userid,login.getJobName());
									if(bool){
										logger.info("bool=================="+bool);
										request2.getSession().setAttribute("loginUser", login);
										b=true;
										logger.info("-------------------->进入用户名密码验证 登录成功=" + b);
									}else{
										logger.info("bool=================="+bool);
//										response.getWriter().write("overrole");//无权限
									}
								}
							}else{
								logger.info("判断是否登录走最后的 else=========");
//								response.getWriter().write("error");//用户名密码错误
							}
						} catch (Exception e2) {
							logger.error("登录验证失败！", e2);
							e2.printStackTrace();
						}
					}
					String actionUrl = "";
					//Android  异步调用 session无效处理
					if(userAgent.indexOf(F_Constants.APP_Android) > -1 && b == false){
						logger.info("Android  异步调用 session无效处理==================");
						//ajax 且 校验失败
//							sessionId = request.getParameter("ajaxAndroidSession");
							//不是ajax 请求失效。
							if("".equals(sessionId) || sessionId == null){
								logger.info("sessionId为空的处理==================");
							}else{
								logger.info("android ajax请求session无效处理，ajaxAndroidSession = " + sessionId);
								//校验sessionid
								b = redisService.checkExists(sessionId);
								logger.info("本次请求sessionID是否有效---------------->b = " + b);
							}
					}else{
						//校验casCookie
						logger.info("校验casCookie==================");
						SSOLogonService service = new SSOLogonService();
						actionUrl = service.doClientLogin(InitDataServlet.prop.getProperty("cas_login_url")+ "?service="
								+ URLEncoder.encode(DWFSWorkItemServiceClient.DWFS_DETAILS_URL, "utf8"), null, (String) ((HttpServletRequest)request).getSession().getAttribute("CAS-LOGIN-TGC"));
						if(actionUrl == null){
							logger.info("-------------------->actionUrl=" + actionUrl);
							actionUrl="1";
						}
					}
					
					//测试
					/*if(path.equals("/pages/html5/assistant/assistant.html")){
						b = false;
					}*/
					logger.info("-------------------->test---test=" + b);
					if (b == false) {//session不存在需要拦截
						logger.info("session不存在需要拦截==================");
						if("true".equals(app_ui)){
							//app访问页面过期  页面跳转apptimeOut页面
							logger.info("app访问页面过期  页面跳转apptimeOut页面==================");
							 if(path.indexOf(".html")!=-1){
								 logger.info("path.indexOf('.html')!=-1==================");
//								 ((HttpServletResponse)response).sendRedirect(basePath +"/appTimeOut.jsp");
								 response.getWriter().write("<script type=\"text/javascript\">window.location.href='"+basePath +"/appTimeOut.jsp"+"';</script>");
							 }else{
								 ((HttpServletResponse)response).sendRedirect(basePath +"/appTimeOut.jsp");
							 }
						}else{
//							//测试
//							if(path.equals("/html5/pages/assistant/assistant.html")){
//								flag = true;
//							}else{
								//跳转登录页面
							    ((HttpServletResponse)response).sendRedirect(basePath);
//							}
						    
						}
						
					}else{
						//cas 失效
						if(actionUrl == null && "true".equals(app_ui)){
							//app登录 调整提示页面
							((HttpServletResponse)response).sendRedirect(basePath +"/appTimeOut.jsp");
						}else if(actionUrl == null && "false".equals(app_ui)){
							 //跳转登录页面
						    ((HttpServletResponse)response).sendRedirect(basePath);
						}else{
							//若用户存在进行正常操作的话，每次走进来重新设置会话时间
							redisService.setExpiredTime(sessionId);
							LoginUser u = (LoginUser)redisService.getFromRedisBySession(sessionId);
							System.out.println(u.getEmpName());
							chain.doFilter(request, response);
						}
					}
					
				}
                                                                                                                                                                                                                                                                                                                                                       				
//				if(path.indexOf(".")==-1 || path.indexOf(".jsp")!=-1){//需要拦截
//					flag = false;
//					if (((HttpServletRequest) request).getSession().getAttribute("loginUser") == null) {//session不存在需要拦截
//						String path1 = ((HttpServletRequest)request).getContextPath();   
//					    String basePath = InitDataServlet.getValue("dpm_domain_url") + "://"   
//					            + request.getServerName() + ":" + request.getServerPort()   
//					            + path1; 
//					    //跳转登录页面
//					    ((HttpServletResponse)response).sendRedirect(basePath);
//					}else{
//						Object obj = ((HttpServletRequest) request).getSession().getAttribute("loginUser");
//						LoginUser u = (LoginUser)obj;
//						System.out.println(u.getEmpName());
//						chain.doFilter(request, response);
//					}
//					
//				}
				
				if(flag){
					chain.doFilter(request, response);
				}
			}
			}
		}

	public void init(FilterConfig filterConfig) throws ServletException {
		
		 //初始化需要拦截的文件夹
		 String include = filterConfig.getInitParameter("include");
		 if (include != null) {
				StringTokenizer st = new StringTokenizer(include, ",");
				list.clear();
				while (st.hasMoreTokens()) {
					list.add("/"+st.nextToken()+"/");
				}
		 }
		
	}

}
