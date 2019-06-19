package com.deppon.montal.module.workitems.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;


import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.model.OaWorkItem;
import com.deppon.montal.module.workitems.service.IWorkItemsService;
import com.deppon.montal.module.workitems.service.WorkItemsService;

/**
 * 废弃了
 * @author Administrator
 *
 */
public class QueryWorkItemsListAction extends AppDelegateAction{

    
       /**
        * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
       */
    
    private static final long serialVersionUID = -1127239000241002862L;
    private static final String FORWARD_PATH_TODOLIST = "/jsp/workitems/work_items.jsp";

    @Override
    protected void response() {
		
		//LoginUser login = (LoginUser)request.getSession().getAttribute("loginUser");
		LoginUser login = (LoginUser)getUserRedisService().getFromRedisBySession(getSessionId());
		String syscode = login.getSyscodes();
		IWorkItemsService workItemsService = new WorkItemsService();
		List<OaWorkItem> workItems = workItemsService.queryWorkItem(login.getUserId(),syscode);
		StringBuffer empHtml = new StringBuffer();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
	        	for(OaWorkItem workItem:workItems){
	        	    empHtml.append("<tr class='tr1' id='"+workItem.getProcessinstid()+"&type="+workItem.getFlowtype()+"'>");
	    		    empHtml.append("<th scope='row' class='thc'>"+workItem.getProcessinstname()+"</th>");
	    		    empHtml.append("<td class='thr'>"+format.format(workItem.getCreatetime())+"</td>");
	    		    empHtml.append("</tr>");
	        	}
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
