package com.deppon.montal.module.notice.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.login.service.UserLoginService;
import com.deppon.montal.model.BusAssistantMent;
import com.deppon.montal.module.notice.service.BusAssistantMentService;
import com.deppon.montal.module.notice.service.IBusAssistantMentService;
import com.deppon.montal.util.Base64;

/**
 * 出差小助手
 * @author 106460
 *
 */
public class ToBusAssistantAction extends AppDelegateAction{

    
   /**
    * 
    */
    private static final long serialVersionUID = -1127239000241002862L;
    
    private static Logger logger  = Logger.getLogger(ToBusAssistantAction.class);
    
    private UserLoginService loginService = new UserLoginService();

    @Override
    protected void response() {
    	
    	
    	System.out.println("[ToBusAssistantAction] response");
		putParameters(null);
	  try {
			String useridss =new String(Base64.decryptBASE64(reqPara.get("useridss")));
//			String password = new String(Base64.decryptBASE64(reqPara.get("password")));
			
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
			
//			if (user == null)
//			{
//				
//				try {
//					response.getWriter().write("userisnull");
//					return;
//				} catch (IOException e) {
//				e.printStackTrace();
//				}
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
			
    	
    	
    	
    	String key = reqPara.get("key");
		int pageNum = Integer.parseInt(reqPara.get("pageNum"));
		int pageSize = Integer.parseInt(reqPara.get("pageSize"));
		String userAgent = request.getHeader("user-agent");

		IBusAssistantMentService busassistantmentservice = new BusAssistantMentService();
    	List<BusAssistantMent> annList = busassistantmentservice.queryAssistantMentList(user.getEmpId(),key,pageNum,pageSize);

    	JSONArray rspJstr =JSONArray.fromObject(annList.toArray()); 
//    	
//    	StringBuffer empHtml = new StringBuffer();
//    	SimpleDateFormat format = new SimpleDateFormat("MM-dd");
    
    	
    	
		//获取UI标记
	//	String ui_type = reqPara.get("ui_type");
	    /*
	    if(null != ui_type && ui_type.equals(F_Constants.UI_IOS)){
		
		int index = 0;
	    	//ios风格
	    	for(OaAnnounceMent oaAnnounceMent:annList){
	    	    String listr = "";
	    		if(null == oaAnnounceMent.getCkbh()){//未读
	    			if(index == 0 && pageNum ==1){
		    	    	listr = "<li class=\"bold\" onclick=\"showDetail('"+oaAnnounceMent.getGgid()+"',this)\" >";
		    	    	index++;
		    	    } else{
		    	    	listr = "<li class=\"bold\" onclick=\"showDetail('"+oaAnnounceMent.getGgid()+"',this)\" >";
		    	    }
//	    			empHtml.append(listr + "<div class=\"border-b pb15\">"+
//        					"<span class=\"to_right\">" +
//        					"</span><span class=\"fr\">" + format.format(oaAnnounceMent.getFbdate()) + "</span>" +
//        					"<span class=\"li-code\">" + oaAnnounceMent.getHeader()  + "</span>" +
//        					"</div></li>");
	    			empHtml.append(listr +
	    					"<div class=\"lin3\"><div class=\"line2\">" + oaAnnounceMent.getHeader()  + "</div></div>" +
    					"<div class=\"line1\">" + format.format(oaAnnounceMent.getFbdate()) + "</div>" +
    					"</li>");
	    		}else{
	    			if(index == 0 && pageNum ==1){
		    	    	listr = "<li class=\"ed\" onclick=\"showDetail('"+oaAnnounceMent.getGgid()+"',this)\" >";
		    	    	index++;
		    	    } else{
		    	    	listr = "<li class=\"ed\" onclick=\"showDetail('"+oaAnnounceMent.getGgid()+"',this)\" >";
		    	    }
//	    			empHtml.append(listr +
//	    					"<div class=\"border-b pb15\">"+
//        					"<span class=\"to_right\">" +
//        					"</span><span class=\"fr\">" + format.format(oaAnnounceMent.getFbdate()) + "</span>" +
//        					"<span class=\"li-code\">" + oaAnnounceMent.getHeader()  + "</span>" +
//        					"</div></li>");
	    			empHtml.append(listr +
	    					"<div class=\"lin3\"><div class=\"line2\">"+ oaAnnounceMent.getHeader()  + "</div></div>" +
	    					"<div class=\"line1\">"+ format.format(oaAnnounceMent.getFbdate()) + "</div>" +
	    					"</li>");
	    		}
		}
	    }else{
	    	//win8风格
    		for(OaAnnounceMent oaAnnounceMent:annList){
    			
    			if(null == oaAnnounceMent.getCkbh()){//未读
    				empHtml.append("<tr class=\"bold\" id='"+oaAnnounceMent.getGgid()+"'>");
    				empHtml.append("<td width=\"70%\">"+oaAnnounceMent.getHeader()+"</td>");
    				empHtml.append("<td width=\"30%\" class=\"fyy-textRt\">"+format.format(oaAnnounceMent.getFbdate())+"</td>");
    			}else{
    				empHtml.append("<tr class=\"ed\" id='"+oaAnnounceMent.getGgid()+"'>");
    				empHtml.append("<td width=\"70%\">"+oaAnnounceMent.getHeader()+"</td>");
    				empHtml.append("<td width=\"30%\" class=\"fyy-textRt\">"+format.format(oaAnnounceMent.getFbdate())+"</td>");
    			}
    			empHtml.append("</tr>");
    		}
	    }*/
		try {
			
			//ajax不缓存
			response.setHeader( "Pragma", "no-cache" );
		    response.addHeader( "Cache-Control", "must-revalidate" );
		    response.addHeader( "Cache-Control", "no-cache" );
		    response.addHeader( "Cache-Control", "no-store" );
		    response.setDateHeader("Expires", 0);
			
			response.getWriter().write(rspJstr.toString());
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
