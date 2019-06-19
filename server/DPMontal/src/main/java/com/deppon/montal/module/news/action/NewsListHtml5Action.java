/**
 * 
 */
package com.deppon.montal.module.news.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.login.service.UserLoginService;
import com.deppon.montal.model.OaRollNews;
import com.deppon.montal.module.notice.service.AnnounceMentService;
import com.deppon.montal.module.notice.service.IAnnounceMentService;
import com.deppon.montal.util.Base64;
import com.deppon.montal.util.InitDataServlet;
import com.deppon.montal.util.JSONUtil;

/**
 * @author yin
 * 查看图片新闻列表
 *
 */
public class NewsListHtml5Action extends AppDelegateAction {
	  private static final long serialVersionUID = 1L;

		private UserLoginService loginService = new UserLoginService();
	  private static IAnnounceMentService announceMentService = new AnnounceMentService();
		/**
		 * 日志
		 */
	  private static Logger logger = Logger.getLogger(NewsListHtml5Action.class);
	  protected void response() {
		  System.out.println("[NewsListHtml5Action] response");
			putParameters(null);
			try
			{
				String useridss = new String(Base64.decryptBASE64(reqPara
						.get("useridss")));
				String userid = "";
				String password = "";
				userid = useridss.substring(0, useridss.indexOf("|"));
				password = useridss.substring(useridss.indexOf("|") + 1);
				logger.info("userid=" + userid + "" + "password=" + password);
				
		  
		  
		  logger.info("读取新闻列表");
		  int pageNum = Integer.parseInt(reqPara.get("pageNum"));
		  int pageSize = Integer.parseInt(reqPara.get("pageSize"));
		  //LoginUser user = (LoginUser)request.getSession().getAttribute("loginUser");
		  //Android 异步请求session失效处理 --没办法的办法
		  String sessionId = getSessionId();
		  String userAgent = request.getHeader("user-agent");
		  LoginUser user = (LoginUser)getUserRedisService().getFromRedisBySession(sessionId);
//		  if(user==null){
//			  try {
//	    			response.getWriter().write("userisnull");
//	    			return;
//	    		} catch (IOException e) {
//					e.printStackTrace();
//				}
//		  }
		  
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
	
		  String path = ((HttpServletRequest)request).getContextPath();   
		  String basePath = InitDataServlet.getValue("dpm_domain_url") + "://"   
		            + request.getServerName() + ":" + request.getServerPort()   
		            + path;
//		  String absolutePath = request.getSession().getServletContext().getRealPath("/");
		  List<OaRollNews> newsList = announceMentService.queryNewsList(user.getEmpId(), pageNum, pageSize);
//		  ImageService imsgeService = new ImageService();
//		  for (int i = 0; i < newsList.size(); i++) {
//			imsgeService.imageHandler(absolutePath, newsList.get(i).getFilename());
//		  }
		//  StringBuffer htmlBuffer = new StringBuffer("");
		 JSONArray jsonArray = new JSONArray();
		  for(OaRollNews rollnew : newsList){
			  rollnew.setContent("");
			  String fileNameString=rollnew.getFilename();
			  try {
				jsonArray.add(JSONUtil.encapsulateJsonObject(rollnew));
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		  }
		JSONObject newsJson = new JSONObject();
		newsJson.accumulate("news", jsonArray);
		  try {			  
			 response.getWriter().write(newsJson.toString());
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
