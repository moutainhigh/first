package com.deppon.montal.login.action;



import org.apache.log4j.Logger;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.login.service.UserLoginService;

/**
 * 显示首页Action
 * @author yin
 *
 */
public class UserShowMainAction extends AppDelegateAction {
	
	private static Logger logger  = Logger.getLogger(UserShowMainAction.class);
	
	
	
	private UserLoginService loginService = new UserLoginService();
	
	@Override
	protected void response() {
		System.out.println("[UserLoginCheckAction] response");
		putParameters(null);
		//获取UI标记
		String ui_type = reqPara.get("ui_type");
		try {
			//LoginUser login = (LoginUser)request.getSession().getAttribute("loginUser");
			String sessionId = getSessionId();
			LoginUser login = (LoginUser)getUserRedisService().getFromRedisBySession(sessionId);
			//缓存中未获取到登录用户
			if(login == null){
				request.setAttribute("errors", "会话失效，请重新登录！");
				if(null != ui_type && ui_type.equals(F_Constants.UI_IOS)){
					forward(F_Constants.IOS_FORWARD_PATH_LOGIN);
				}else{
					forward(F_Constants.FORWARD_PATH_LOGIN);
				}
				return;
			}
			
//			String syscode = login.getSyscodes();
//			logger.info("UserShowMainAction syscode---->"+syscode);
			request.setAttribute("flowCount", loginService.getWorkFlowCountByUserId(login.getUserId(),""));//计数
			
			System.out.println("UserShowMainAction----------------->"+login.getUserId()+ " ,sessionId = " + sessionId);
			
			String rollnews = loginService.queryRollNews(login.getEmpId()+"",5);
			request.setAttribute("rollnews", rollnews);
			
			if(null != ui_type && ui_type.equals(F_Constants.UI_IOS)){
				forward(F_Constants.IOS_FORWARD_PATH_MAIN);
			}else{
				forward(F_Constants.FORWARD_PATH_MAIN);
			}
			return;
		}catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	protected void mapParameters(){
		System.out.println("[UserLoginCheckAction] mapParameters");
		super.mapParameters();
	}
}
