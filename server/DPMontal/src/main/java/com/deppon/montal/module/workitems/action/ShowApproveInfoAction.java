/**
 * 
 */
package com.deppon.montal.module.workitems.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.model.OaApprovalInfo;
import com.deppon.montal.model.OmEmployee;
import com.deppon.montal.module.workitems.service.IWorkItemsService;
import com.deppon.montal.module.workitems.service.WorkItemsService;
import com.deppon.montal.module.workitems.webservice.client.WorkItemsWebServiceClient;

/**
 * @author Administrator
 *
 */
public class ShowApproveInfoAction extends AppDelegateAction {

	IWorkItemsService workItemsService = new WorkItemsService();
	
	@Override
	protected void response() {
		
		String workId = reqPara.get("workId");
		//查询处理记录
        List<OaApprovalInfo> apprList = workItemsService.queryApprovalInfoList(workId);
        
        StringBuffer empHtml = new StringBuffer();
		
		//获取UI标记
		String ui_type = reqPara.get("ui_type");
		int index = 0;
		if(null != ui_type && ui_type.equals(F_Constants.UI_IOS)){
			for(OaApprovalInfo app:apprList){
			    String appdate = "";
				if(index == 0){
				    appdate = "<li class='first'>处理时间:<em>"+app.getApprovedate()+"</em></li>";
				}else{
				    appdate = "<li class='line'>处理时间:<em>"+app.getApprovedate()+"</em></li>";
				}
				empHtml.append(appdate);
				empHtml.append("<li>处理人:<em>"+app.getApprover()+"</em></li>").toString();
				empHtml.append("<li>处理结果:<em>"+F_Constants.WORKFLOW_RESULT_MAP.get(app.getIsagree())+"</em></li>").toString();
				empHtml.append("<li>处理意见:<em>"+(app.getApproverver()==null?" ":app.getApproverver())+"</em></li>").toString();
				index++;
			}
		}else{
			for(OaApprovalInfo app:apprList){
				empHtml.append("<tr class='topLine sh'><th>处理时间</th><td>"+app.getApprovedate()+"</td></tr>");
				empHtml.append("<tr class='sh'><th>处理人</th><td>"+app.getApprover()+"</td></tr>");
				empHtml.append("<tr class='sh'><th>处理结果</th><td>"+F_Constants.WORKFLOW_RESULT_MAP.get(app.getIsagree())+"</td></tr>");
				empHtml.append("<tr class='sh'><th>处理意见</th><td>"+(app.getApproverver()==null?" ":app.getApproverver())+"</td></tr>");
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
		// TODO Auto-generated method stub
		super.mapParameters();
	}

}
