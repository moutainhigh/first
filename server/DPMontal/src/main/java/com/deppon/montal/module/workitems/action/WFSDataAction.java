package com.deppon.montal.module.workitems.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.deppon.bamp.module.log.client.LogRestServiceClient;
import com.deppon.bamp.module.log.util.LogClientUtil;
import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.login.service.SSOLogonService;
import com.deppon.montal.module.workitems.service.IOperationLogService;
import com.deppon.montal.module.workitems.service.OperationLogServiceImpl;
import com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient;
import com.deppon.montal.util.InitDataServlet;
import com.deppon.montal.util.StringUtil;
import com.deppon.montal.util.Util;
import com.deppon.wfs.workflow.domain.OperationMessage;
/**
 * 
* @title: WFSApprovalAction 
* @description：门户二期httpClient操作
* @author： 何玲菠
* @date： 2013-11-26 上午9:16:39
 */
public class WFSDataAction extends AppDelegateAction{
	private static Logger logger = Logger.getLogger(WFSDataAction.class);
	private DWFSWorkItemServiceClient client = new DWFSWorkItemServiceClient();
	/* (non-Javadoc)
	* @see com.deppon.montal.action.RootAbstractAction#response()
	*/
	@Override
	protected void response() {
		Date begindate=new Date();
		String errorInfo="";
		SSOLogonService service = new SSOLogonService();
		String result = null;
		HttpServletResponse rs = response;
		LoginUser login = (LoginUser)getUserRedisService().getFromRedisBySession(getSessionId());
		try {
			String actionUrl = service.doClientLogin(InitDataServlet.prop.getProperty("cas_login_url")+ "?service="
					+ URLEncoder.encode((String)reqPara.get("actionUrl"), "utf8"), null, (String) request.getSession().getAttribute("CAS-LOGIN-TGC"));
			result =  client.postToDWFS(actionUrl, reqPara, (String) request.getSession().getAttribute("CAS-SESSIONID"));
			errorInfo=result;
			logger.info("httpClient response string is:" + result);
			//记录操作日志，审批同意和不同意 、回退等。
			if (!StringUtil.isEmptyOrNull( reqPara.get("approvelEntity.isAgree"))||reqPara.get("actionUrl").contains("rollBack.action")) {
				
				IOperationLogService operationLogservice = new OperationLogServiceImpl();
				String type = null;
				if ("0".equals(reqPara.get("approvelEntity.isAgree"))){
					type = "同意";
				} else if ("1".equals(reqPara.get("approvelEntity.isAgree"))){
					type = "不同意";
				}
				if (reqPara.get("actionUrl").contains("rollBack.action")){
					type = "回退";
				}
				OperationMessage message = new OperationMessage(Util.newBizCode(), login.getUserId(), login.getEmpName(), new Date(), type, reqPara.get("approvelEntity.processinstid"),"门户二期");
				operationLogservice.operationLog(message);
				logger.info("【操作记录日志:" + "姓名 " + login.getEmpName() + " 工号:" + login.getUserId() +  " 操作类型" + type + "  工作流号" + reqPara.get("approvelEntity.processinstid") + "】");
			}
//			rs.getWriter().write(result);
//			rs.getWriter().flush();
		} catch (UnsupportedEncodingException e) {
			logger.error("post to dwfs error,异常信息："+e.getMessage(), e);
			if(result == null || result == ""){
				result = "[{\"name\":\"failure\",\"failReason\":\"回退操作失败，请稍后重试！\"}]";
			}
		}finally{
			try {
				rs.getWriter().write(result);
				rs.getWriter().flush();
				if (!StringUtil.isEmptyOrNull( reqPara.get("approvelEntity.isAgree"))||reqPara.get("actionUrl").contains("rollBack.action")) {
				//数据监控
				String issuccess="0";
				if(result!=null&&result.indexOf("true")>=0){
					issuccess="1";
				}
				try {
		    		new ToApproveAction().requestClient(login.getUserId(),(String)request.getSession().getAttribute("newflowtype"),begindate,new Date(),(String)request.getSession().getAttribute("newbusino"),issuccess,"1",errorInfo);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			} catch (IOException e) {
				logger.error("返回结果异常，异常信息："+e.getMessage(),e);
			}
		}
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
		busiOpertEntity.setOperationContent("审批DWFS工作流");
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
