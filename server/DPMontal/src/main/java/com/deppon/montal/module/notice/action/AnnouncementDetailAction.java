package com.deppon.montal.module.notice.action;

import java.io.IOException;

import javax.servlet.ServletException;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.model.OaAnnounceMent;
import com.deppon.montal.module.notice.service.AnnounceMentService;
import com.deppon.montal.module.notice.service.IAnnounceMentService;

public class AnnouncementDetailAction extends AppDelegateAction{

    
       /**
        * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
       */
    
    private static final long serialVersionUID = -1127239000241002862L;
    private static final String FORWARD_PATH_TODOLIST = "/jsp/notice/announcement_detail.jsp";

    @Override
    protected void response() {
	IAnnounceMentService announceMentService = new AnnounceMentService();
	try {
	    	// 取出页面回传参数ggId
		String ggId = reqPara.get("ggId");
		String unread = reqPara.get("unread");
		
		if(unread != null){
			//未读
			if(unread.equals("0")){
				//LoginUser login = (LoginUser)request.getSession().getAttribute("loginUser");
				LoginUser login = (LoginUser)getUserRedisService().getFromRedisBySession(getSessionId());
				announceMentService.insertBulletinClick(ggId, login.getEmpId(), login.getEmpName());
			}
		}
		
		// 查询公告详细
		if (ggId != null) {
		    OaAnnounceMent oaAnn = announceMentService.queryById(ggId);
		    request.setAttribute("oaAnn", oaAnn);
		}
		//获取UI标记
		String ui_type = reqPara.get("ui_type");
		
		if(null != ui_type && ui_type.equals(F_Constants.UI_IOS)){
		    	//ios风格
		    	forward(F_Constants.IOS_FORWARD_PATH_ANNDETAIL);
		    }else{
		    	//win8风格
			forward(F_Constants.FORWARD_PATH_ANNDETAIL);
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
