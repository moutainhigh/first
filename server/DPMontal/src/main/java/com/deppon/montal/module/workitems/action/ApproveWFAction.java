/**
 * 
 */
package com.deppon.montal.module.workitems.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.deppon.bamp.module.log.client.LogRestServiceClient;
import com.deppon.bamp.module.log.util.LogClientUtil;
import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.module.workitems.service.IOperationLogService;
import com.deppon.montal.module.workitems.service.OperationLogServiceImpl;
import com.deppon.montal.module.workitems.webservice.client.HTTPBo;
import com.deppon.montal.module.workitems.webservice.client.WorkItemsHttpClient;
import com.deppon.montal.util.Util;
import com.deppon.wfs.workflow.domain.OperationMessage;

/**
 * @author Administrator
 *
 */
public class ApproveWFAction extends AppDelegateAction {
    private static Logger logger  = Logger.getLogger(ApproveWFAction.class);
    	WorkItemsHttpClient htppClient = new WorkItemsHttpClient();
	 @Override
	protected void response() {
		 String issuccess="0";
		 String status="";
		 String errorInfo="";
		 Date begindate=new Date();
		 //LoginUser login = (LoginUser)request.getSession().getAttribute("loginUser");
		 LoginUser login = (LoginUser)getUserRedisService().getFromRedisBySession(getSessionId());
		 String isAgree = reqPara.get("agree");
		 String workId = reqPara.get("workid"); 
		 String approvever=reqPara.get("approvever");
		 String devid = reqPara.get("devid");
		 String devmanagerid = reqPara.get("devmanagerid");
		 String need = reqPara.get("need");
		 String localPersonnel = reqPara.get("localPersonnel");
		 String level = reqPara.get("level");
		 String isNeed = reqPara.get("isNeed");
		 String sid = (String) request.getSession().getAttribute("CAS-SESSIONID");
		 String cookie = (String) request.getSession().getAttribute("CAS-LOGIN-TGC");
		 try {
    		     	HTTPBo bo = new HTTPBo();
    		     	bo.setProcessinstId(workId);
    		     	bo.setCookie(cookie);
    		     	bo.setsId(sid);
    		     	bo.setUserName(login.getEmpName());
    		     	bo.setUserId(login.getUserId());
    		     	bo.setApprovever(approvever);
    		     	bo.setIsagree(isAgree);
    		     	bo.setDevId(devid);
    		     	bo.setIsNeed(isNeed);
    		     	bo.setDevManagerId(devmanagerid);
		     	bo.setNeed(need);
		     	bo.setLocalPersonnel(localPersonnel);
		     	bo.setLevel(level);
		     	status =  htppClient.wfApprove(bo);
		     	HttpServletResponse rs = response;
		     	rs.setHeader( "Pragma", "no-cache" );
		     	rs.addHeader( "Cache-Control", "must-revalidate" );
		     	rs.addHeader( "Cache-Control", "no-cache" );
		     	rs.addHeader( "Cache-Control", "no-store" );
		     	rs.setDateHeader("Expires", 0); 
		    	System.out.println("==============HttpRequest return element:"+status);
		    	//记录操作
		    	OperationMessage message = new OperationMessage(Util.newBizCode(), login.getUserId(), login.getEmpName(), new Date(), "0".equals(isAgree)==true?"同意":"不同意", workId ,"老OA");
		    	boolean isLog = OperationLog(message);
		    	logger.info("【操作记录日志:" + "姓名 " + login.getEmpName() + " 工号:" + login.getUserId() +  " 操作类型" + isAgree + "  工作流号" + workId + " 是否记录成功" + isLog + "】");
		    	errorInfo=status;
		    	if(status.indexOf("★★")>-1){
		    		status=status.substring(0,status.indexOf("★★"));
		    	}
		    	rs.getWriter().write(status);
		    	
		 } catch (UnsupportedEncodingException e) {
		    logger.error("ERROR: wfApprove url failure ......" + e.getMessage());
		    errorInfo="★★ERROR: wfApprove url failure ......" + e.getMessage();
		 } catch (IOException e) {
		    logger.error("ERROR: ApproveWFAction IO ......" + e.getMessage());
		    errorInfo="★★ERROR: ApproveWFAction IO ......" + e.getMessage();
		}finally{
			ToApproveAction app=new ToApproveAction();
	    	
	    	if(status!=null&&status.equals("success")){
	    		issuccess="1";
	    	}
	    	//★
	    	try {
				app.requestClient(login.getUserId(),(String)request.getSession().getAttribute("newflowtype"),begindate,new Date(),(String)request.getSession().getAttribute("newbusino"),issuccess,"1",errorInfo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		busiOpertEntity.setOperationContent("审批老OA工作流");
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
