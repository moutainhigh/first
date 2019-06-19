
package com.deppon.montal.module.workitems.action; 

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.deppon.bamp.module.log.client.LogRestServiceClient;
import com.deppon.bamp.module.log.util.LogClientUtil;
import com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain.Auditparameters;
import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.module.workitems.webservice.client.LSP_ESBWorkItemServiceClient;
import com.deppon.montal.module.workitems.webservice.client.LSP_ESBWorkItemServiceClientSecond;
import com.deppon.montal.util.RestfulUtil;
   /** 
 * @Title: LSPESBApproveAction.java
 * @Package com.deppon.montal.module.workitems.action 
 * @Description: DLSP工作流审批Action 
 * @author 关波 
 * @date 2014-4-21 下午4:11:18 
 * @version V1.0 
 */
public class LSPESBApproveAction extends AppDelegateAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger  = Logger.getLogger(OtherSysApproveWFAction.class);
	protected void response() {
		Date begindate=new Date();
		String errorInfo="";
		LoginUser login = (LoginUser)getUserRedisService().getFromRedisBySession(getSessionId());
		String interfaceBatchLSP = (String)reqPara.get("interfaceBatchLSP");
		int result = 0;
		if ("1".equals(interfaceBatchLSP)) {
			//获得服务层
			LSP_ESBWorkItemServiceClient client = LSP_ESBWorkItemServiceClient.getLSP_ESBWorkItemServiceClient();
			result = client.approvalLSPWorkflow(reqPara, login.getUserId(), login.getEmpName());
		}else if ("2".equals(interfaceBatchLSP)) {
			LSP_ESBWorkItemServiceClientSecond client = LSP_ESBWorkItemServiceClientSecond.getLSP_ESBWorkItemServiceClient();
			result = client.approvalLSPWorkflow(reqPara, login.getUserId(), login.getEmpName());
		}else if("3".equals(interfaceBatchLSP)){
			//封装调用接口参数
			Auditparameters audit = LSP_ESBWorkItemServiceClient.initLmsApprov(reqPara, login.getUserId(), login.getEmpName());
			//调用接口
			String resultApp = RestfulUtil.querylmsInfo("lsp_esb_ws_restApprov_link", audit);
			errorInfo=resultApp;
			//审批异常处理
			int exeception = resultApp.indexOf("exceptionType");
			if(exeception == -1){
				if(resultApp == null || "".equals(resultApp)){
					//审批失败
					resultApp = "0";
				}
			}else{
				logger.error("审批异常信息："+resultApp);
				//审批失败
				resultApp = "0";
			}
			result = Integer.parseInt(resultApp);
		}
		
		HttpServletResponse rs = response;
     	rs.setHeader( "Pragma", "no-cache" );
     	rs.addHeader( "Cache-Control", "must-revalidate" );
     	rs.addHeader( "Cache-Control", "no-cache" );
     	rs.addHeader( "Cache-Control", "no-store" );
     	rs.setDateHeader("Expires", 0); 
    	PrintWriter write = null;
    	
		try {
			write = rs.getWriter();
			write.write("{\"msg\":\"" + (result==1?1:0) + "\"}");
			//数据监控
			String issuccess="0";
	    	if(result==1){
	    		issuccess="1";
	    	}
	    	try {
	    		new ToApproveAction().requestClient(login.getUserId(),(String)request.getSession().getAttribute("newflowtype"),begindate,new Date(),(String)request.getSession().getAttribute("newbusino"),issuccess,"1",errorInfo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e1) {
			logger.error("后勤接口箱前台页面写入时候获取输出流异常" + e1.getMessage(),e1);
		}finally {
			write.close();
		}
	}

	@Override
	protected void mapParameters() {
		super.mapParameters();
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


