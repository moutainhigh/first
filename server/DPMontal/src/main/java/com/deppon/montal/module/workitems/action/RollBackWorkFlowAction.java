/**
 * 
 */
package com.deppon.montal.module.workitems.action;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.module.workitems.service.IOperationLogService;
import com.deppon.montal.module.workitems.service.IWorkItemsService;
import com.deppon.montal.module.workitems.service.OperationLogServiceImpl;
import com.deppon.montal.module.workitems.service.WorkItemsService;
import com.deppon.montal.module.workitems.webservice.client.WorkItemsWebServiceClient;
import com.deppon.montal.util.Util;
import com.deppon.wfs.workflow.domain.OperationMessage;

/**
 * @author Administrator
 *
 */
public class RollBackWorkFlowAction extends AppDelegateAction {
    private static Logger logger = Logger.getLogger(RollBackWorkFlowAction.class);

	 @Override
	protected  void response() {
		 IWorkItemsService workItemsService = new WorkItemsService();
		 LoginUser login = (LoginUser)getUserRedisService().getFromRedisBySession(getSessionId());
		 String workId = reqPara.get("workid"); 
		 String rollBackId = reqPara.get("rollBackId"); 
		 String type = reqPara.get("type"); 
		 String approvever=reqPara.get("approvever");
		 Map map = workItemsService.getActivityStartId(workId);
		 String startActId = String.valueOf(map.get("startActId"));
		 String currentActId = String.valueOf(map.get("currentActId"));
		 //参数
		 Object[] args = new Object[]{workId,approvever,login.getUserId(),
			 startActId,rollBackId,currentActId,"normalClaim"};
		 //RPC调用接口
		 String returnStr = null;
		     try {	
			 	HttpServletResponse rs = response;
				returnStr = WorkItemsWebServiceClient.rollBack(args);
				 System.out.println("----------------code-----------"+returnStr+"-------------------------------------------");
				 rs.setHeader( "Pragma", "no-cache" );
				 rs.addHeader( "Cache-Control", "must-revalidate" );
				 rs.addHeader( "Cache-Control", "no-cache" );
				 rs.addHeader( "Cache-Control", "no-store" );
				 rs.setDateHeader("Expires", 0);
				 if(F_Constants.APPORVE_TYPE_SUCCESS.equals(returnStr)){
				    System.err.println(response.toString());
				    OperationMessage message = new OperationMessage(Util.newBizCode(), login.getUserId(), login.getEmpName(), new Date(), "回退", workId,"老OA");
				    boolean isLog = OperationLog(message);
				    logger.info("【操作记录日志:" + "姓名 " + login.getEmpName() + " 工号:" + login.getUserId() +  " 操作类型" + "回退" + "  工作流号" + workId + " 是否记录成功" + isLog + "】");
					rs.getWriter().write(F_Constants.APPORVE_TYPE_SUCCESS);
				 }else{
				     rs.getWriter().write(returnStr == null?"回退失败":returnStr);
				 }
//			} catch (AxisFault e) {
//			    logger.error(" ERROR:RollBackWorkFlowAction" + e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
	}
	//记录操作	
	boolean OperationLog(OperationMessage message) {
		IOperationLogService service = new OperationLogServiceImpl();
		return service.operationLog(message);
	}
	 
	@Override
	protected void mapParameters() {
		// TODO Auto-generated method stub
		super.mapParameters();
	}
	
}
