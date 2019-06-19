package com.deppon.montal.module.workitems.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.module.workitems.service.IWorkItemsService;
import com.deppon.montal.module.workitems.service.WorkItemsService;

public class QueryWfActivityInstListAction extends AppDelegateAction {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */

    private static final long serialVersionUID = -1127239000241002862L;

    @Override
    protected void response() {
	String workId = reqPara.get("workid");
	long lworkId = Long.parseLong(workId);
	IWorkItemsService workItemsService = new WorkItemsService();
	 String activityList = workItemsService.getWfActivityInstInfo(lworkId);
	try {
	    	HttpServletResponse rs = response;
	    	rs.setHeader( "Pragma", "no-cache" );
	    	rs.addHeader( "Cache-Control", "must-revalidate" );
	    	rs.addHeader( "Cache-Control", "no-cache" );
	    	rs.addHeader( "Cache-Control", "no-store" );
	    	rs.setDateHeader("Expires", 0); 
	    	rs.getWriter().write(activityList);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    @Override
    protected void mapParameters() {

	super.mapParameters();
    }

}
