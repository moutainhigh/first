/**
 * 
 */
package com.deppon.montal.login.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.conf.F_Constants;

/**
 * 
 * 用户请求响应ACTION
 * 
 * @author lin.liu
 *
 */
public class UserLoginAction extends AppDelegateAction {

	private static Logger logger  = Logger.getLogger(UserLoginAction.class);
	
	@Override
	protected void response() {
		System.out.println("[UserLoginAction] response");
		request.setAttribute("year", new Date().getYear() + 1900);
		logger.info("-----------remote client IP: "+getClientIpAddr());
		putParameters(null);
		try {
			if(null != reqPara.get("ui_type")){
				if(reqPara.get("ui_type").equals(F_Constants.UI_IOS)){
					forward(F_Constants.IOS_FORWARD_PATH_LOGIN);
				}else{
					forward(F_Constants.FORWARD_PATH_LOGIN);
				}
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void mapParameters(){
		System.out.println("[UserLoginAction] mapParameters");
		super.mapParameters();
	}
}
