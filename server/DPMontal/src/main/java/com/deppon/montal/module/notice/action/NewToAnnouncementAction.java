package com.deppon.montal.module.notice.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.login.service.UserLoginService;
import com.deppon.montal.model.OaAnnounceMent;
import com.deppon.montal.module.notice.service.AnnounceMentService;
import com.deppon.montal.module.notice.service.IAnnounceMentService;
import com.deppon.montal.util.Base64;
import com.deppon.montal.util.JSONUtil;

/**
 * Servlet implementation class NewToAnnouncementAction
 */
public class NewToAnnouncementAction extends AppDelegateAction {

	    private static final long serialVersionUID = -1127239000241002862L;
	    
	    private static Logger logger  = Logger.getLogger(NewToAnnouncementAction.class);
	    
	    private UserLoginService loginService = new UserLoginService();

	    @Override
	    protected void response() {
	    	
	    	
	    	System.out.println("[NewToAnnouncementAction] response");
			putParameters(null);
		  try {
				String useridss =new String(Base64.decryptBASE64(reqPara.get("useridss")));
//				String password = new String(Base64.decryptBASE64(reqPara.get("password")));
				
				//LoginUser login1 = null;
				String userid = "";
			String password = "";
			userid = useridss.substring(0, useridss.indexOf("|"));
			password = useridss.substring(useridss.indexOf("|") + 1);
			logger.info("userid=" + userid + "" + "password=" + password);
			String sessionId = getSessionId();
				LoginUser user = (LoginUser) getUserRedisService()
					.getFromRedisBySession(sessionId);
			System.out.println(user + "============");
//				if (user == null)
//			{
//					try {
//						response.getWriter().write("userisnull");
//						return;
//					} catch (IOException e) {
//					e.printStackTrace();
//					}	
//			}
				HttpSession session = request.getSession();
				// 验证通过，封装用户信息
				String sid = session.getId();
				logger.info("SSOLogonAction------------------->userid = "
						+ userid + " ,sessionId = " + sid);

				LoginUser login = null;
				if (userid != null)
				{// 先从redis缓存中查询用户是否存在
					login = (LoginUser) getUserRedisService().getFromRedis(
							userid);
				}
				if (login == null)
				{// 若是redis缓存中不存在user信息，再到数据库中核对有没有该用户
					login = loginService.getLoginUser(userid);
					if (login != null)
					{
						// 向redis缓存中添加用户信息
						getUserRedisService().add2Redis(login);
					}
				}
				System.out.println(login + "---------" + userid + "---------"
						+ password);
				if (null != login)
				{
					user = login;
					// TODO 首先把用户的信息与session绑定到一块
					getUserRedisService().add2Redis(sid, userid);
					request.getSession().setAttribute("loginUser", login);
					// response.getWriter().write("success");//成功
				}
				else
				{
					response.getWriter().write("error");// 用户名密码错误
					request.setAttribute("errors", "工号或密码错误！");
					return ;
				}
			
			
	    	String key = null;
	    	try {
				key = new String(reqPara.get("key").getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}  

	    	int pageNum = Integer.parseInt(reqPara.get("pageNum"));
			int pageSize = Integer.parseInt(reqPara.get("pageSize"));

//			String userAgent = request.getHeader("user-agent");
//		
//			
//				if(user==null){
//					try {
//						response.getWriter().write("userisnull");
//						return;
//					} catch (IOException e) {
//					e.printStackTrace();
//					}
//		  	} 

			
			IAnnounceMentService announceMentService = new AnnounceMentService();
	    	List<OaAnnounceMent> annList = announceMentService.queryAnnounceMentList(user.getEmpId(),key,pageNum,pageSize);
	    	// TODO JSON
	        JSONArray jsonArray = new JSONArray();
	    	for(OaAnnounceMent an : annList) { 
				// annList.get(i).setFbdate(null);// 这里要处理一下这个时间
	    		try {
					jsonArray.add(JSONUtil.encapsulateJsonObject(an));
				} catch (JsonGenerationException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				response.getWriter().write(jsonArray.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}

	    }catch (Exception e2)
		{
			logger.error("登录验证失败！", e2);
			e2.printStackTrace();
		}
}
	    
	    @Override
	    protected void mapParameters() {
	        super.mapParameters();
	    }
}
