/**
 * 
 */
package com.deppon.montal.module.notice.action;

import java.io.IOException;

import javax.servlet.ServletException;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.model.OaRollNews;
import com.deppon.montal.module.notice.service.AnnounceMentService;
import com.deppon.montal.module.notice.service.IAnnounceMentService;

/**
 * @author yin
 * 查看图片新闻列表
 *
 */
public class RollNewsDetailAction extends AppDelegateAction {

	  private static final long serialVersionUID = 1L;

	  private static IAnnounceMentService announceMentService = new AnnounceMentService();
	  
	  protected void response() {
		  
		  String ggid = reqPara.get("ggid");
		  String filename = reqPara.get("filename");
		  
		  String unread = reqPara.get("unread");
			
			if(unread != null){
				//未读
				if(unread.equals("0")){
					//LoginUser login = (LoginUser)request.getSession().getAttribute("loginUser");
					LoginUser login = (LoginUser)getUserRedisService().getFromRedisBySession(getSessionId());
					announceMentService.insertBulletinClick(ggid, login.getEmpId(), login.getEmpName());
				}
			}
		  
		  OaRollNews rollnew = announceMentService.getRollnewDetail(ggid);
		  rollnew.setFilename(filename);
		  
		  request.setAttribute("rollnew", rollnew);
		  
		  String ui_type = reqPara.get("ui_type");
		  
		  try {
			  if(null != ui_type && ui_type.equals(F_Constants.UI_IOS)){
				  forward(F_Constants.IOS_ROLLNEWS_LIST_DETAIL);
			  }else{
				  forward(F_Constants.ROLLNEWS_LIST_DETAIL);
			  }
			  return;
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		  
	  }
	 
	  
	  
	  
	  @Override
	  protected void mapParameters() {
	      super.mapParameters();
	  }
}
