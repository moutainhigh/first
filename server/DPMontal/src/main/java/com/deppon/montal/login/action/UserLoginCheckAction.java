package com.deppon.montal.login.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.StringUtil;
import com.eos.foundation.common.utils.CryptoUtil;

/**
 * 用户登录验证Action
 * @author yin
 *
 */
public class UserLoginCheckAction extends AppDelegateAction {
	
	private static final long serialVersionUID = 1L;

	private static Logger logger  = Logger.getLogger(UserLoginCheckAction.class);
	
	private UserLoginService loginService = new UserLoginService();
	
	@Override
	protected void response() {
		System.out.println("[UserLoginCheckAction] response");
		putParameters(null);
		
		try {
			
			LoginUser login1 = null;
			
			String userid = reqPara.get("userid");
			String password = reqPara.get("password");
			
			HttpSession session = request.getSession();
			try{
				//验证通过，封装用户信息
				String sid = session.getId();
				logger.info("SSOLogonAction------------------->userid = " + userid + " ,sessionId = " + sid);
				
				LoginUser login = null;
				if(userid != null){//先从redis缓存中查询用户是否存在
					login = (LoginUser)getUserRedisService().getFromRedis(userid);
				}
				if(login == null){//若是redis缓存中不存在user信息，再到数据库中核对有没有该用户
					login = loginService.getLoginUser(userid);
					if(login != null){
						//向redis缓存中添加用户信息
						getUserRedisService().add2Redis(login);
					}
				}
				System.out.println(login+"---------"+userid+"------"+password);
				if(null != login){
					//TODO 首先把用户的信息与session绑定到一块
					getUserRedisService().add2Redis(sid, userid);
					request.getSession().setAttribute("loginUser", login);
					response.getWriter().write("success");//成功
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
					/*request.setAttribute("errors", "");
					response.sendRedirect("showmain"); */
				}else{
					response.getWriter().write("error");//用户名密码错误
					request.setAttribute("errors", "工号或密码错误！");
//					if(null != ui_type && ui_type.equals(F_Constants.UI_IOS)){
//						forward(F_Constants.IOS_FORWARD_PATH_LOGIN);
//					}else{
//						forward(F_Constants.FORWARD_PATH_LOGIN);
//					}
				}
				//结束封装
				
				//记录登陆信息到数据库
//				UserLoginService userLoginService = new UserLoginService();
//				LoginMessage message = new LoginMessage(Util.newBizCode(),userId , login.getEmpName(),new Date());
//				boolean isLog = userLoginService.logLoginMessage(message);
//				logger.info("【登陆记录   工号:" + userId + "  姓名:" + login.getEmpName() + "  是否记录成功:" + isLog + "】");
				
			}catch (Exception e){
				e.printStackTrace();
				logger.error("Invoke SSOLogonAction encounter exception: "+e.getMessage());
				  //获取UI标记
//				String ui_type = reqPara.get("ui_type");
				
				/*try {
				    	if(null != ui_type && userid.equals(F_Constants.UI_IOS)){
				    	    forward(F_Constants.IOS_FORWARD_PATH_LOGIN);
				    	}else{
				    	     forward(F_Constants.FORWARD_PATH_LOGIN);
					}
				    	return;
				} catch (ServletException e1) {
					   e1.printStackTrace();
				} catch (IOException e1) {
					   e1.printStackTrace();
				}*/
			}
		} catch (Exception e2) {
			logger.error("登录验证失败！", e2);
			e2.printStackTrace();
		}
	}

	protected void mapParameters(){
		System.out.println("[UserLoginCheckAction] mapParameters");
		super.mapParameters();
	}
}
