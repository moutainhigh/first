
package com.deppon.montal.module.workitems.action; 

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.deppon.bamp.module.log.client.LogRestServiceClient;
import com.deppon.bamp.module.log.util.LogClientUtil;
import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.module.workitems.service.OperationLogServiceImpl;
import com.deppon.montal.module.workitems.webservice.client.FSSCWorkItemServiceClient;
import com.deppon.montal.util.Util;
import com.deppon.wfs.workflow.domain.OperationMessage;
   /** 
 * @Title: FsscApproveWFAction.java
 * @Package com.deppon.montal.module.workitems.action 
 * @Description: FSSC工作流审批Action 
 * @author yinrongping 
 * @date 2013-11-12 下午4:11:18 
 * @version V1.0 
 */
public class FSSCApproveWFAction extends AppDelegateAction {

	private static Logger logger  = Logger.getLogger(FSSCApproveWFAction.class);
	
	protected void response() {
		//数据监控
		String issuccess="0";
		String errorInfo="";
		String result = null;	
		String userid="";
		Date begindate=new Date();
		try{
			LoginUser login = (LoginUser)getUserRedisService().getFromRedisBySession(getSessionId());
			userid=login.getUserId();
			String opinion = reqPara.get("opinion");//决策
			String decision = reqPara.get("decision");//意见
			String busino = reqPara.get("busino");//业务编号
			String workitemid = reqPara.get("workitemid");//工作项ID
			String backnode = reqPara.get("backnode");//回退节点
			
//			String result = null;		
			logger.info("FSSCApproveWFAction args is [workitemid:"+workitemid+" busino:"+busino+" opinion:"+opinion+" backnode:"+backnode+"]");
			if(null != opinion && null != busino && null != workitemid){
				logger.info("begin approveFSSC...");
				Object[] obj = new Object[]{Long.parseLong(workitemid),login.getUserId(),decision,opinion,busino,backnode};
//			obj = new Object[]{218222,"000165","cxf接天天测试","agree","FSSC111140416000005","null"};
				try {
					result = FSSCWorkItemServiceClient.approveFSSC(obj);
					errorInfo=result;
					if(result.indexOf("★★")>-1){
						result=result.substring(0,result.indexOf("★★"));
			    	}
				} catch (ServletException e) {
					logger.error("报账系统接口客户端异常，异常信息" + e.getMessage(), e);
					errorInfo="★★报账系统接口客户端异常，异常信息" + e.getMessage();
					result = "2";
				}
				
				//记录操作
				String type = "";
				if ("agree".equals(opinion)){
					type = "同意";
				} else if ("disagree".equals(opinion)) {
					type = "不同意";
				} else if ("back".equals(opinion)){
					type = "回退";
				}
				OperationMessage message = new OperationMessage(Util.newBizCode(), login.getUserId(), login.getEmpName(), new Date(), type, busino ,"报账系统");
				boolean isLog =  new OperationLogServiceImpl().operationLog(message);
				logger.info("【操作记录日志:" + "姓名 " + login.getEmpName() + " 工号:" + login.getUserId() +  " 操作类型" + type + "  工作流号" + busino + " 是否记录成功" + isLog + "】");
				logger.info("end   approveFSSC...");
			}
			
			HttpServletResponse rs = response;
			rs.setHeader( "Pragma", "no-cache" );
			rs.addHeader( "Cache-Control", "must-revalidate" );
			rs.addHeader( "Cache-Control", "no-cache" );
			rs.addHeader( "Cache-Control", "no-store" );
			rs.setDateHeader("Expires", 0); 
			//返回结果
			rs.getWriter().write(result);
			System.out.println("==============FSSCApproveWFAction return result:"+result);
		}catch(Exception e){
			e.printStackTrace();
			errorInfo="★★"+e.getMessage();
		}finally{
			try {
		    	if(result!=null&&result.equals("1")){
		    		issuccess="1";
		    	}
		    	try {
		    		new ToApproveAction().requestClient(userid,(String)request.getSession().getAttribute("newflowtype"),begindate,new Date(),(String)request.getSession().getAttribute("newbusino"),issuccess,"1",errorInfo);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	
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
		busiOpertEntity.setOperationContent("审批FSSC工作流");
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

