package com.deppon.montal.module.notice.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.model.OaRollNews;
import com.deppon.montal.module.notice.service.AnnounceMentService;
import com.deppon.montal.module.notice.service.IAnnounceMentService;
import com.deppon.montal.util.ImgUtil;
import com.deppon.montal.util.InitDataServlet;
import com.deppon.montal.util.JSONUtil;

/**
 * Servlet implementation class NewOfRollNewsDetailAction
 */
public class NewOfRollNewsDetailAction extends AppDelegateAction {

	  private static final long serialVersionUID = 1L;

	  private static IAnnounceMentService announceMentService = new AnnounceMentService();
	  
	  protected void response() {
		  // 资源ID
		  String ggid = reqPara.get("ggid");
		  // 图片名字
		  String filename = reqPara.get("filename");
		  //是否已读
		  String unread = reqPara.get("unread");
			
		  // 图片完整路径
		  String path = ((HttpServletRequest)request).getContextPath();   
		  String basePath = InitDataServlet.getValue("dpm_domain_url") + "://"   
		            + request.getServerName() + ":" + request.getServerPort()   
		            + path;
		  
			if(unread != null){
				//未读
				if(unread.equals("0")){
					//LoginUser login = (LoginUser)request.getSession().getAttribute("loginUser");
					LoginUser login = (LoginUser)getUserRedisService().getFromRedisBySession(getSessionId());
					announceMentService.insertBulletinClick(ggid, login.getEmpId(), login.getEmpName());
				}
			}
		String rtn = "";
		if (ggid != null) {
			OaRollNews rollnew = announceMentService.getRollnewDetail(ggid);
			if (rollnew != null) {
				String content = rollnew.getContent();
				if (content != null) {
					content = ImgUtil.filterHtmlImg(content);
				}else{
					content = "";
				}
				
				rollnew.setContent(content);
				rollnew.setFilename(basePath+"/oaupload/oaGg/"+filename);
				// 处理内容
				try {
					rtn = JSONUtil.encapsulateJsonObject(rollnew);
				} catch (JsonGenerationException e1) {
					e1.printStackTrace();
				} catch (JsonMappingException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		try {
			// ajax不缓存
			response.setHeader("Pragma", "no-cache");
			response.addHeader("Cache-Control", "must-revalidate");
			response.addHeader("Cache-Control", "no-cache");
			response.addHeader("Cache-Control", "no-store");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(rtn);
		} catch (IOException e) {
			e.printStackTrace();
		}
	  } 

	  @Override
	  protected void mapParameters() {
	      super.mapParameters();
	  }
}
