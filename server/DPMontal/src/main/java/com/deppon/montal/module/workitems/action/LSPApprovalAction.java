
package com.deppon.montal.module.workitems.action; 

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.deppon.bamp.module.log.client.LogRestServiceClient;
import com.deppon.bamp.module.log.util.LogClientUtil;
import com.deppon.lsp.module.mobileworkflow.server.service.Auditparameters;
import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.module.workitems.service.IOperationLogService;
import com.deppon.montal.module.workitems.service.OperationLogServiceImpl;
import com.deppon.montal.module.workitems.webservice.client.LSPWorkItemServiceClient;
import com.deppon.montal.util.Util;
import com.deppon.wfs.workflow.domain.OperationMessage;
   /** 
 * @Title: LSPApprovalAction.java
 * @Package com.deppon.montal.module.workitems.action 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-11-11 下午2:13:16 
 * @version V1.0 
 */
public class LSPApprovalAction extends AppDelegateAction{
	
	   /**
	    * @Fields serialVersionUID : TODO(后勤LSP审批操作)
	   */
	
	private static final long serialVersionUID = 5638576374960078949L;
	private static Logger logger  = Logger.getLogger(LSPApprovalAction.class);
	LSPWorkItemServiceClient htppClient = LSPWorkItemServiceClient.getLSPWorkItemServiceClient();
	@Override
	protected void response() {
		Date begindate=new Date();
		String errorInfo="";
		LoginUser login = (LoginUser)getUserRedisService().getFromRedisBySession(getSessionId());
		HttpServletResponse rs = response;
		/**
		 * 够建审批实体
		 */
		Auditparameters auditparameters = new Auditparameters();
		auditparameters.setEmpCode(login.getUserId());
		auditparameters.setEmpName(login.getEmpName());
		auditparameters.setWfInstanceId(Long.parseLong(reqPara.get("workid")));
		auditparameters.setWfWorkItemId(Long.parseLong(reqPara.get("workItemId")));
		auditparameters.setAuditAdvise(reqPara.get("approvever"));
		auditparameters.setDecisionState(reqPara.get("agree"));
		auditparameters.setDocId(reqPara.get("busino"));
		auditparameters.setWfState(reqPara.get("wfState"));
		Object[] params = {auditparameters};
		
		String methodName = "";
		String type = reqPara.get("type");
		if(F_Constants.DLSP_PURCHASE_CONTRACT_CHANGE.equals(type)){
			methodName = "auditOperationInLsp";
		} else if (F_Constants.DLSP_PAYMENT_APPLY.equals(type)) {
			methodName = "PayApplyauditOperationInLsp";
		} else if (F_Constants.DLSP_PURCHASE_CONTRACT.equals(type)) {
			methodName = "auditOperationInLsp";
		}
		/**
		 * 审批操作
		 */
		String result =  htppClient.approveLSP(params ,methodName);
		OperationMessage message = new OperationMessage(Util.newBizCode(), login.getUserId(), login.getEmpName(), new Date(), "agree".equals(reqPara.get("agree"))==true?"同意":"回退", reqPara.get("workid"),"后勤系统"); 
			try {
				errorInfo=result;
				if(result.indexOf("★★")>-1){
					result=result.substring(0,result.indexOf("★★"));
		    	}
				if ("2".equals(result)) {
					logger.error("调用接口出现异常 异常编码2");
					rs.getWriter().write("2");
				} else {
					boolean isLog = OperationLog(message);
					logger.info("【操作记录日志:" + "姓名 " + login.getEmpName() + " 工号:" + login.getUserId() +  " 操作类型" + reqPara.get("agree") + "  工作流号" + reqPara.get("workid") + " 是否记录成功" + isLog + "】");
					rs.getWriter().write(result);
				}
			} catch (IOException e) {
				logger.error("后勤LSP审批错误" + e.getMessage());
				e.printStackTrace();
			}
			//数据监控
			String issuccess="0";
	    	if(result!=null&&result.equals("1")){
	    		issuccess="1";
	    	}
	    	try {
	    		new ToApproveAction().requestClient(login.getUserId(),(String)request.getSession().getAttribute("newflowtype"),begindate,new Date(),(String)request.getSession().getAttribute("newbusino"),issuccess,"1",errorInfo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	//记录操作	
	boolean OperationLog(OperationMessage message) {
		IOperationLogService service = new OperationLogServiceImpl();
		return service.operationLog(message);
	}
	
	/**
	 * @MethodName: initParamsInfos 
	 * @description: 重载初始化访问参数
	 * @author: wuyaqing 
	 * @date: 2014-5-12 上午8:32:44
	 */
	@Override
	protected void initParamsInfos() {
		//设置用户工号
		busiOpertEntity.setEmpCode(getUserId());
		//设置操作时间
		busiOpertEntity.setOperationTime(LogClientUtil.getNowDate());
		//设置模块名称
		busiOpertEntity.setModuleName("审批工作流");
		//设置操作内容
		busiOpertEntity.setOperationContent("审批LSP工作流");
	}
	
	/**
	 * @MethodName: saveAccessOperInfo 
	 * @description: 重载调用BAMP日志的方法
	 * @author: wuyaqing 
	 * @date: 2014-5-12 上午8:41:10
	 */
	@Override
	protected void saveAccessOperInfo() {
		//通过客户端调BPMS接口记录操作日志
		LogRestServiceClient.insertBusiOperInfo(busiOpertEntity);
	}
	
}

