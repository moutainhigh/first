/**
 * 
 */
package com.deppon.montal.login.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.login.service.SSOLogonService;
import com.deppon.montal.login.service.UserLoginService;
import com.deppon.montal.util.Base64;
import com.deppon.montal.util.StringUtil;

/**
 * 单点登录ACTION
 * 取代UserLoginAction
 * 
 * @author lin.liu 2013-03-04
 *
 */
public class SSOLogonAction extends AppDelegateAction {
	private static Logger logger  = Logger.getLogger(SSOLogonAction.class);
	
	private UserLoginService loginService = new UserLoginService();
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	protected void response() {
		HttpSession session = request.getSession();
		SSOLogonService service = new SSOLogonService();
		String userId = reqPara.get("userid");
		//获取UI标记
		String ui_type = reqPara.get("ui_type");
		//是否APP访问
		String app_ui = reqPara.get("app_ui");
		String cookie = "";
		String casSid = "";
		try{
		    //是否APP访问
		    if(!"ture".equals(app_ui)) {
			Map validInfo = new HashMap();
			//得到CAS的认证信息
			service.fetchCASValidInfo(validInfo);
			validInfo.put("username", userId);
			validInfo.put("password", new String(Base64.decryptBASE64(reqPara.get("password"))));
			cookie = service.doSSOLogon(validInfo, userId);
			
			
			if(StringUtil.isEmptyOrNull(cookie)){
				//response.getWriter().write("error");//用户名密码错误
				request.setAttribute("errors", "工号或密码错误！");
				if(null != ui_type && ui_type.equals(F_Constants.UI_IOS)){
					forward(F_Constants.IOS_FORWARD_PATH_LOGIN);
				}else{
					forward(F_Constants.FORWARD_PATH_LOGIN);
				}
				return;
			}
			
			casSid = (String) validInfo.get("sessionId");
		    } else { 
			
			//APP访问 直接获取cookie sessionId
			cookie = reqPara.get("CASTGC");
			casSid = reqPara.get("sessionId");
			
		    }
		    if(cookie.indexOf("Path=/cas") > -1){
		    	request.getSession().setAttribute("CAS-LOGIN-TGC", cookie);
			}else{
				String app_cookies = "CASTGC=" + cookie + "; Path=/cas";
				request.getSession().setAttribute("CAS-LOGIN-TGC", app_cookies);
			}
			request.getSession().setAttribute("CAS-SESSIONID", casSid);
			//验证通过，封装用户信息
			String sid = session.getId();
			logger.info("SSOLogonAction------------------->userid = " + userId + " ,sessionId = " + sid);
			
			
			LoginUser login = null;
			if(userId != null){//先从redis缓存中查询用户是否存在
				login = (LoginUser)getUserRedisService().getFromRedis(userId);
			}
			if(login == null){//若是redis缓存中不存在user信息，再到数据库中核对有没有该用户
				login = loginService.getLoginUser(userId);
				if(login != null){
					//向redis缓存中添加用户信息
					getUserRedisService().add2Redis(login);
				}
			}
			if(null != login){
				//TODO 首先把用户的信息与session绑定到一块
				getUserRedisService().add2Redis(sid, userId);
				//验证权限
				//boolean bool = loginService.validateLoginRole(userId,login.getJobName());
				/*boolean bool = getRoleJobnameRedisService().validateLoginRole(userId, login.getJobName());
				if(bool){
					request.setAttribute("errors", "");
					response.sendRedirect("showmain"); 
					
				}else{
					//response.getWriter().write("overrole");//无权限
					request.setAttribute("errors", "该工号暂无权限！");
					if(null != ui_type && ui_type.equals(F_Constants.UI_IOS)){
						forward(F_Constants.IOS_FORWARD_PATH_LOGIN);
					}else{
						forward(F_Constants.FORWARD_PATH_LOGIN);
					}
				}*/
				//取消权限验证
				request.setAttribute("errors", "");
				response.sendRedirect("showmain"); 
			}else{
				//response.getWriter().write("error");//用户名密码错误
				request.setAttribute("errors", "工号或密码错误！");
				if(null != ui_type && ui_type.equals(F_Constants.UI_IOS)){
					forward(F_Constants.IOS_FORWARD_PATH_LOGIN);
				}else{
					forward(F_Constants.FORWARD_PATH_LOGIN);
				}
			}
			//结束封装
			
			//记录登陆信息到数据库
//			UserLoginService userLoginService = new UserLoginService();
//			LoginMessage message = new LoginMessage(Util.newBizCode(),userId , login.getEmpName(),new Date());
//			boolean isLog = userLoginService.logLoginMessage(message);
//			logger.info("【登陆记录   工号:" + userId + "  姓名:" + login.getEmpName() + "  是否记录成功:" + isLog + "】");
			
		}catch (Exception e){
			e.printStackTrace();
			logger.error("Invoke SSOLogonAction encounter exception: "+e.getMessage());
			  //获取UI标记
//			String ui_type = reqPara.get("ui_type");
			
			try {
			    	if(null != ui_type && ui_type.equals(F_Constants.UI_IOS)){
			    	    forward(F_Constants.IOS_FORWARD_PATH_LOGIN);
			    	}else{
			    	     forward(F_Constants.FORWARD_PATH_LOGIN);
				}
			    	return;
			} catch (ServletException e1) {
				   e1.printStackTrace();
			} catch (IOException e1) {
				   e1.printStackTrace();
			}
		}
	}
	
}
