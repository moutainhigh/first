
    package com.deppon.montal.module.workitems.action; 

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.model.OmEmployee;
import com.deppon.montal.module.workitems.service.IWFSysDataChangesService;
import com.deppon.montal.module.workitems.service.WFSysDataChangesService;
/** 
 * @Title: WFSysDataChangesAction.java
 * @Package com.deppon.montal.module.workitems.action 
 * @Description: TODO(添加描述) 
 * @author 廖建雄 
 * @date 2013-4-11 上午9:31:49 
 * @version V1.0 
 */
public class GetWFApproverAction extends AppDelegateAction{

    
       /**
        * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
       */
    
    private static final long serialVersionUID = 4676819032213721586L;
    
    IWFSysDataChangesService service = new WFSysDataChangesService();
    @Override
    protected void response() {
	//LoginUser login = (LoginUser)request.getSession().getAttribute("loginUser");
	LoginUser login = (LoginUser)getUserRedisService().getFromRedisBySession(getSessionId());
	Map map = service.getApprover(login);
	
	List<OmEmployee> devAppList = (List<OmEmployee>) map.get("devAppList");
	List<OmEmployee> devManageAppList = (List<OmEmployee>) map.get("devManageAppList");
	StringBuffer empHtml = new StringBuffer();
	if (devAppList.size() >0){
		 empHtml.append("<div class=\"tableBox\" id=\"devAppId\" style=\"display: none\">");
		 empHtml.append("<table class=\"tbList\"");
		for (OmEmployee omEmployee : devAppList) {
		    empHtml.append("<tr>");
		    empHtml.append("<td><input type=\"radio\" name=\"appuser\" value =\""+omEmployee.getUserId()+ "\">");
		    empHtml.append("<th>").append(omEmployee.getOrgName()).append("</th>");
		    empHtml.append("<th>").append(omEmployee.getUserId()).append("</th>");
		    empHtml.append("<th id=\""+omEmployee.getUserId()+"\">").append(omEmployee.getEmpName()).append("</th>");
		    empHtml.append("</tr>");
		}
		 empHtml.append("</table>");
		 empHtml.append("</div>");
		 
		 empHtml.append("<div class=\"tableBox\" id=\"devManegeId\" style=\"display: none\">");
		 empHtml.append("<table class=\"tbList\">");
		for (OmEmployee omEmployee : devManageAppList) {
		    empHtml.append("<tr>");
		    empHtml.append("<td><input type=\"radio\" name=\"appuser\" value =\""+omEmployee.getUserId()+ "\"></td>");
		    empHtml.append("<th>").append(omEmployee.getOrgName()).append("</th>");
		    empHtml.append("<th>").append(omEmployee.getUserId()).append("</th>");
		    empHtml.append("<th id=\""+omEmployee.getUserId()+"\">").append(omEmployee.getEmpName()).append("</th>");
		    empHtml.append("</tr>");
		}
		 empHtml.append("</table>");
		 empHtml.append("</div>");
	 }
	try {
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

