package com.deppon.montal.module.workitems.action;

import java.util.List;


import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.model.OaWorkItem;
import com.deppon.montal.module.workitems.service.IWorkItemsService;
import com.deppon.montal.module.workitems.service.WorkItemsService;

public class ToWorkItemsListIOSAction extends AppDelegateAction{

    
       /**
        * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
       */
    
    private static final long serialVersionUID = -1127239000241002862L;

    @Override
    protected void response() {
    	
		try {
			//LoginUser login = (LoginUser)request.getSession().getAttribute("loginUser");
			LoginUser login = (LoginUser)getUserRedisService().getFromRedisBySession(getSessionId());
			String syscode = login.getSyscodes();
			int pageSize = Integer.parseInt(reqPara.get("pagesize"));
			int pageNum = Integer.parseInt(reqPara.get("pagenum"));
			String key = reqPara.get("key");
			
			IWorkItemsService workItemsService = new WorkItemsService();
			List<OaWorkItem> workItems = workItemsService.queryWorkItem(login.getUserId()
					                   , key, pageNum, pageSize,syscode);
			
			StringBuffer html = new StringBuffer();
			for(int i=0; i<workItems.size(); i++ ){
				OaWorkItem item = workItems.get(i);
				String pName = ""; 
   				String pNo = "";
   				if(!(item.getSyscode().equals(F_Constants.DIPOA_WORKFLOW_SYSCODE)
   						||item.getSyscode().equals(F_Constants.DWFS_WORKFLOW_SYSCODE))){//FSSC和DLSP工作流
   					String[] arr = item.getProcessinstname().split(item.getSyscode());
   					pName = arr[0];//名称   
   					pNo = item.getBusino();//流程号
   				}else{//老平台和门户二期
   					pName = item.getProcessinstname();
   					pNo = item.getProcessinstid().toString();
   				}
				html.append("<li onclick=\"showWf('"+item.getProcessinstid()+"','"+item.getFlowtype()+"','"+item.getSyscode()
						  +"','"+item.getBusino()+"','"+item.getWorkitemid()+"','"+item.getActivitydefid()+"','"+item.getActivityinstid()+"')\"><em>"+pNo+"</em>"+pName+"</li>");
			}
			
			//ajax不缓存
			response.setHeader( "Pragma", "no-cache" );
		    response.addHeader( "Cache-Control", "must-revalidate" );
		    response.addHeader( "Cache-Control", "no-cache" );
		    response.addHeader( "Cache-Control", "no-store" );
		    response.setDateHeader("Expires", 0);
			
			response.getWriter().write(html.toString());
		    
		} catch (Exception e) {
		    e.printStackTrace();
		} 
    }
    
    @Override
    protected void mapParameters() {
        
        super.mapParameters();
    }
    
	
	
}
