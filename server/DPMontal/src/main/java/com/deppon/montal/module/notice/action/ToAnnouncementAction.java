package com.deppon.montal.module.notice.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.model.OaAnnounceMent;
import com.deppon.montal.module.notice.service.AnnounceMentService;
import com.deppon.montal.module.notice.service.IAnnounceMentService;

public class ToAnnouncementAction extends AppDelegateAction{

    
       /**
        * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
       */
    
    private static final long serialVersionUID = -1127239000241002862L;
    private static final String FORWARD_PATH_TODOLIST = "/jsp/notice/appoint_rmoval_announcement.jsp";

    @Override
    protected void response() {
    	
    	String key = reqPara.get("key");
		int pageNum = Integer.parseInt(reqPara.get("pageNum"));
		int pageSize = Integer.parseInt(reqPara.get("pageSize"));
		//LoginUser user = (LoginUser)request.getSession().getAttribute("loginUser");
		//Android 异步请求session失效处理 --没办法的办法
		String sessionId = getSessionId();
		String userAgent = request.getHeader("user-agent");
		/*if(userAgent.indexOf(F_Constants.APP_Android) > -1){
			 sessionId = request.getParameter("ajaxAndroidSession");
		}*/
		
		LoginUser user = (LoginUser)getUserRedisService().getFromRedisBySession(sessionId);
    	IAnnounceMentService announceMentService = new AnnounceMentService();
    	List<OaAnnounceMent> annList = announceMentService.queryAnnounceMentList(user.getEmpId(),key,pageNum,pageSize);

    	StringBuffer empHtml = new StringBuffer();
    	SimpleDateFormat format = new SimpleDateFormat("MM-dd");
    	
		//获取UI标记
		String ui_type = reqPara.get("ui_type");
	    
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
	    }
		try {
			
			//ajax不缓存
			response.setHeader( "Pragma", "no-cache" );
		    response.addHeader( "Cache-Control", "must-revalidate" );
		    response.addHeader( "Cache-Control", "no-cache" );
		    response.addHeader( "Cache-Control", "no-store" );
		    response.setDateHeader("Expires", 0);
			
			response.getWriter().write(empHtml.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
    
    @Override
    protected void mapParameters() {
        super.mapParameters();
    }
}
