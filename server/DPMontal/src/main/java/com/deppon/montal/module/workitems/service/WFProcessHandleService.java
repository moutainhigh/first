package com.deppon.montal.module.workitems.service;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.login.service.SSOLogonService;
import com.deppon.montal.util.IHttpClient;
import com.deppon.montal.util.InitDataServlet;
import com.deppon.montal.util.NetUtil;

public class WFProcessHandleService {
	private static Logger logger  = Logger.getLogger(WFProcessHandleService.class);
	
	public  String approve(String loaction, String sid) throws Exception{
		try {
			HashMap<String, String> user = new HashMap<String, String>();
			//DataObject oaapprovalinfo = null;
			user.put("APPLYNO", "4486422");
			user.put("APPROVER", "柳发勇");
			//oaapprovalinfo = createOaapprovalinfo(user);
			//String loginInfo = ApproveUtils.userLogin("070818");
			user.put("activityDefID", "manualActivity4");
			user.put("activityDefName", "逐级审批至总部副总直管人员");
			user.put("activityInstID", "28740108");
			user.put("applyNo", "4486422");
			user.put("currentPage", "1");
			user.put("processInstID", "6583642");
			user.put("workItemID", "15953944");
			user.put("oaapprovalinfo/APPROVEVER", "测试测试");
			user.put("oaapprovalinfo/APPROVER", "柳发勇");
			user.put("oaapprovalinfo/APPROVEDATE", "2013-03-19 17:41:29");
			user.put("oaapprovalinfo/ACTIVITYDEFID", "manualActivity4");
			user.put("oaapprovalinfo/ZCFLAG", String.valueOf(0));
			user.put("oaapprovalinfo/ACTIVITYDEFNAME", "逐级审批至总部副总直管人员");
			user.put("oaapprovalinfo/USERID", "070818");
			user.put("oaapprovalinfo/APPLYNO", "4486422");
			user.put("oaapprovalinfo/PROCESSINSTID", "6583642");
			user.put("oaapprovalinfo/WORKITEMID", "15953944");
			user.put("oaapprovalinfo/ISAGREE", "0");
			
			String url = "http://192.168.17.23:8080/dipApp/dip.workflow.common.approveStart.flow";
			String post = postApprove(
					loaction,
					user,
					sid);
			
			//HttpPost httppost=new HttpPost(url);  

			//String get = doGet("http://127.0.0.1/html4/login_mobile.php", "name",
			//	"admin");
//			System.out.println("Post:" + post);
			//System.out.println("Get:" + get);
			System.out.println(post);
		} catch (Throwable e) {
			e.printStackTrace();
	return "yichang";
		}
		return "tongguo";
	}
	
	private  String postApprove(String url, Map<String, String> params,String sid) throws Exception {
		String strResult = "";
		String param = "_eosFlowAction=checkend";
		IHttpClient httpClient = NetUtil.fetchHttpClient();
		httpClient.setRequestURL(url);
		httpClient.setCookie("JSESSIONID=" + sid + "; Path=/dipApp");

		Collection keyset = params.keySet();
		for (Iterator iter = keyset.iterator(); iter.hasNext();) {
			String argName = (String) iter.next();
			String argValue = (String) params.get(argName);
			param += "&" + argName + "=" + URLEncoder.encode(argValue, "utf8");

		}

		httpClient.send(param);
		System.out.println("----------------------------------------");

		ByteArrayOutputStream out = httpClient.getOutputStream();
		logger.info(out.toString("UTF-8"));
		return strResult;
	}
}
