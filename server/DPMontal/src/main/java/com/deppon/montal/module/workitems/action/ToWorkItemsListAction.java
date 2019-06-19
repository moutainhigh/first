package com.deppon.montal.module.workitems.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.login.service.UserLoginService;
import com.deppon.montal.model.OaWorkItem;
import com.deppon.montal.module.workitems.service.IWorkItemsService;
import com.deppon.montal.module.workitems.service.WorkItemsService;
import com.deppon.montal.util.Base64;

public class ToWorkItemsListAction extends AppDelegateAction{

    private static final long serialVersionUID = -1127239000241002862L;
    private static final String FORWARD_PATH_TODOLIST = "/jsp/workitems/work_items.jsp";
    private static final String IOS_FORWARD_PATH_TODOLIST = "/jsp/ios/workitems/work_items.jsp";
    private static final String addWorkItemNames = "com.deppon.bpms.module.fssc.bpsdesign.kgBorrowBill.welfareFee"
    												+",com.deppon.bpms.module.fssc.bpsdesign.kgBorrowBill.commcation"
  +",com.deppon.bpms.module.fssc.bpsdesign.kgBorrowBill.consult"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgBorrowBill.culturalActivity"
  +",com.deppon.bpms.module.fssc.bpsdesign.kgBorrowBill.dailycost"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgBorrowBill.financeFee"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgBorrowBill.investment"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgBorrowBill.party"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgBorrowBill.rentFee"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgBorrowBill.taxes"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgBorrowBill.train"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgBorrowBill.travel"
  +" ,com.deppon.bpms.module.fssc.bpsdesign.kgBorrowBill.unusualExpenses"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgReimburse.commcation"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgReimburse.consult"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgReimburse.culturalActivity"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgReimburse.dailycost"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgReimburse.financeFee"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgReimburse.investment"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgReimburse.party"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgReimburse.rentFee"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgReimburse.taxes"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgReimburse.train"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgReimburse.travel"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgReimburse.unusualExpenses"
 +" ,com.deppon.bpms.module.fssc.bpsdesign.kgReimburse.welfareFee"
 +" ,com.deppon.bpms.module.lsp.bpsdesign.fixProperty.fixPropertyCheck"
 
	+" ,com.deppon.bpms.module.nhr.bpsdesign.personnel.overtimePayApply"
	+" ,com.deppon.bpms.module.nhr.bpsdesign.personnel.repairAttendance"
	+" ,com.deppon.bpms.module.wdgh.bpsdesign.operate.storeRent"
	+" ,com.deppon.bpms.module.wdgh.bpsdesign.operate.siteRent";
    private UserLoginService loginService = new UserLoginService();
    
    private static Logger logger = Logger.getLogger(ToWorkItemsListAction.class);
    @Override
    protected void response() {
    	Object versionObject=request.getSession().getAttribute("version");
    	System.out.println(versionObject+"=================version");
    	if(versionObject!=null&&versionObject.toString().equals("new")){
    		//审批成功后 跳转列表界面
        	try {
    			forward("/toworkitemList.jsp");
    		} catch (ServletException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}else{
    	//	System.out.println("[ToWorkItemsListAction] response");
    		
    	//	putParameters(null);
    		try {
    		//	String useridss = new String(Base64.decryptBASE64(reqPara.get("useridss")));
    		//	String userid = "";
    		//	String password = "";
    		//	userid = useridss.substring(0, useridss.indexOf("|"));
    		/*	password = useridss.substring(useridss.indexOf("|") + 1);
    			logger.info("userid=" + userid + "" + "password=" + password);
    			String sessionId = getSessionId();
    			LoginUser user = (LoginUser) getUserRedisService().getFromRedisBySession(sessionId);
    			System.out.println(user + "===========");
    			HttpSession session = request.getSession();
    			// 验证通过，封装用户信息
    			String sid = session.getId();
    			logger.info("SSOLogonAction------------------->userid = " + userid + " ,sessionId = " + sid);
    			LoginUser login = null;
    			if (userid != null) {
    				// 先从redis缓存中查询用户是否存在
    				login = (LoginUser) getUserRedisService().getFromRedis(userid);
    			}
    			if (login == null) {
    				// 若是redis缓存中不存在user信息，再到数据库中核对有没有该用户
    				login = loginService.getLoginUser(userid);
    				if (login != null) {
    					// 向redis缓存中添加用户信息
    					getUserRedisService().add2Redis(login);
    				}
    			}
    			System.out.println(login + "---------" + userid + "---------" + password);
    			if (null != login) {
    				user = login;
    				// 首先把用户的信息与session绑定到一块
    				getUserRedisService().add2Redis(sid, userid);
    				request.getSession().setAttribute("loginUser", login);
    				// response.getWriter().write("success");//成功
    			} else {
    				response.getWriter().write("error");
    				request.setAttribute("errors", "工号或密码错误！");
    				return ;
    			}*/
			//LoginUser login = (LoginUser)request.getSession().getAttribute("loginUser");
			LoginUser login = (LoginUser)getUserRedisService().getFromRedisBySession(getSessionId());
//			String syscode = login.getSyscodes();
			IWorkItemsService workItemsService = new WorkItemsService();
//			List<OaWorkItem> workItems = workItemsService.queryWorkItem(login.getUserId(),syscode);
			List<OaWorkItem> workItems = workItemsService.queryWorkItem(login.getUserId(),"");
    			List<OaWorkItem> oldWorkItems = new ArrayList<OaWorkItem>();
    			for (OaWorkItem oaWorkItem : workItems) {
					if(addWorkItemNames.indexOf(oaWorkItem.getFlowtype())<0){
						oldWorkItems.add(oaWorkItem);
					}
				}
    			request.setAttribute("workItems",oldWorkItems);
    			request.setAttribute("flowTypes", F_Constants.ALL_WORKFLOW);
    			//获取UI标记
    			String ui_type = reqPara.get("ui_type");
    			if(null != ui_type && ui_type.equals(F_Constants.UI_IOS)){
    				forward(IOS_FORWARD_PATH_TODOLIST);
    			} else {
    				forward(FORWARD_PATH_TODOLIST);
    			}
    			return;
    		} catch (Exception e) {
    			logger.error("ERROR:[ToWorkItemsListAction Forward Error...]" +
    					e.getMessage());
    		} 
    	}
    }
    
    @Override
    protected void mapParameters() {
        super.mapParameters();
    }
    
}
