/**
 * 
 */
package com.deppon.montal.module.notice.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.model.OaRollNews;
import com.deppon.montal.module.notice.service.AnnounceMentService;
import com.deppon.montal.module.notice.service.IAnnounceMentService;
import com.deppon.montal.util.FormatUtil;
import com.deppon.montal.util.InitDataServlet;

/**
 * @author yin
 * 查看图片新闻列表
 *
 */
public class RollNewsListAction extends AppDelegateAction {

	  private static final long serialVersionUID = 1L;

	  private static IAnnounceMentService announceMentService = new AnnounceMentService();
	  
	  protected void response() {
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
		  System.out.println("RollNewsListAction------------------->userId = " + user.getUserId() + " ,sessionId = " + sessionId);
		  String path = ((HttpServletRequest)request).getContextPath();   
		  String basePath = InitDataServlet.getValue("dpm_domain_url") + "://"   
		            + request.getServerName() + ":" + request.getServerPort()   
		            + path;
		  
		  List<OaRollNews> newsList = announceMentService.queryRollnews(user.getEmpId(), pageNum, pageSize);
		  
		  StringBuffer htmlBuffer = new StringBuffer("");
		 
		  for(OaRollNews rollnew : newsList){
			  htmlBuffer.append(createDL(rollnew,basePath));
		  }
		  try {
			  
			//ajax不缓存
			response.setHeader( "Pragma", "no-cache" );
		    response.addHeader( "Cache-Control", "must-revalidate" );
		    response.addHeader( "Cache-Control", "no-cache" );
		    response.addHeader( "Cache-Control", "no-store" );
		    response.setDateHeader("Expires", 0); 
			  
			 response.getWriter().write(htmlBuffer.toString());
		  } catch (IOException e) {
			 e.printStackTrace();
		  }
	  }
	 
	  /**
	   * 创建Html-DL
	   * @param rollnew
	   * @return
	   */
	  private StringBuffer createDL(OaRollNews rollnew,String basePath){
		  
		  StringBuffer newhtml = new StringBuffer("<dl onclick=\"showNewDetail(this,'"+rollnew.getGgid()+"','"+rollnew.getFilename()+"','"+(rollnew.getCkbh()==null?"0":"1")+"')\"><dt>");
		  newhtml.append("<img src=\""+basePath+"/oaupload/oaGg/list/"+rollnew.getFilename()+"\" width=\"100%\" />");
		  newhtml.append("</dt><dd>");
		  if(null != rollnew.getCkbh()){
			  newhtml.append("<div class=\"ico readed\">已读</div>");
		  }else{
			  newhtml.append("<div class=\"ico toread\">未读</div>");
		  }
		  int index = rollnew.getHeader().indexOf("】")+1;
		  String title_type = rollnew.getHeader().substring(0,index);
		  String title_header = rollnew.getHeader().substring(index);
		  newhtml.append("<div class=\"newTit\">"+title_type+"&nbsp;"+"</div>");
		  newhtml.append("<p class=\"new-tit\">"+title_header+"</p>");
		  //newhtml.append("<div class=\"new-tit\">");
		  //获取新闻部分详细信息到列表中
		 // newhtml.append("<p class=\"new-con fc87\">"+rollnew.getContent()+"</p>");
		  newhtml.append("<p class=\"new-time tar fc87\">"+FormatUtil.formatDate(rollnew.getFbdate())+"</p>");
		  newhtml.append("</dd></dl>");
		  
		  return  newhtml;
	  }
	  
	  
	  @Override
	  protected void mapParameters() {
	      super.mapParameters();
	  }
}
