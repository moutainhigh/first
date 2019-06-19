
    package com.deppon.montal.module.workitems.webservice.client; 

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.deppon.montal.login.service.SSOLogonService;
import com.deppon.montal.model.WfWorkItem;
import com.deppon.montal.module.workitems.service.SQLManager;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
import com.deppon.montal.util.IHttpClient;
import com.deppon.montal.util.InitDataServlet;
import com.deppon.montal.util.NetUtil;
import com.deppon.montal.util.StringUtil;
import com.eos.foundation.common.utils.DateUtil;


   /** 
 * @Title: WorkItemsWebServiceClient.java
 * @Package com.deppon.montal.module.workitems.webservice.client 
 * @Description: TODO(添加描述) 
 * @author 廖建雄 
 * @date 2013-2-21 下午6:53:08 
 * @version V1.0 
 */
public class WorkItemsHttpClient {
    private static Logger logger  = Logger.getLogger(WorkItemsHttpClient.class);
    
    /**===================================拼装条件SQL查询===============================================*/
    public String wfApprove(HTTPBo bo) throws UnsupportedEncodingException{
	String sql = SQLManager.QUERY_WFWORKITEM;
	Object[] params = {bo.getUserId(),bo.getUserId(),bo.getProcessinstId()};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	WfWorkItem wfWorkItem = new WfWorkItem();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List  resultList = ConvertPojoUtil.resultSetToList(rs);
	    if (resultList.size() < 1) {
		return "failure"+"★★resultList.size() < 1";
	    }
	    wfWorkItem = (WfWorkItem) ConvertPojoUtil.mapToBean(new WfWorkItem(), 
		    (Map)resultList.get(0));
	} catch (SQLException e1) {
	       logger.error("ERROR: WorkItemsHttpClient.wfApprove SQL ......" + e1.getMessage());
	       return "failure"+"★★ERROR: WorkItemsHttpClient.wfApprove SQL ......" + e1.getMessage();
	} catch (IOException e) {
	    logger.error("ERROR: wfApprove ConvertPojoUtil failure ......" + e.getMessage());
	    return "failure"+"★★ERROR: wfApprove ConvertPojoUtil failure ......" + e.getMessage();
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	SSOLogonService service = new SSOLogonService();
	String path = InitDataServlet.getValue("wf_approve");
	String url = service.doClientLogin(InitDataServlet.prop.getProperty("cas_login_url")+ "?service="
			+ URLEncoder.encode(path + wfWorkItem.getActionurl(), "utf8"), null, bo.getCookie());
	Map map = approveHttpService(bo, url, wfWorkItem);
	
	try {
	    return postApprove(url, map, bo.getsId());
	} catch (Exception e) {
	    logger.error("ERROR: postApprove failure......" + e.getMessage());
	    return "failure"+"★★ERROR: postApprove failure......" + e.getMessage();
	}
    }
    
    /**==============================封装数据=========================================*/
    private Map approveHttpService(HTTPBo bo, String url, WfWorkItem wfWorkItem) {
	Map<String, String> map = new HashMap<String, String>();
	map.put("APPLYNO", wfWorkItem.getApplyno().toString());
	map.put("APPROVER", bo.getUserName());
	map.put("activityDefID", wfWorkItem.getActivitydefid());
	map.put("activityDefName", wfWorkItem.getActivityinstname());
	map.put("activityInstID", wfWorkItem.getActivityinstid().toString());
	map.put("applyNo", wfWorkItem.getApplyno().toString());
	map.put("currentPage", "1");
	map.put("processInstID", bo.getProcessinstId());
	map.put("workItemID", wfWorkItem.getWorkitemid().toString());
	map.put("oaapprovalinfo/APPROVEVER", bo.getApprovever());
	map.put("oaapprovalinfo/APPROVER", bo.getUserName());
	map.put("oaapprovalinfo/APPROVEDATE", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
	map.put("oaapprovalinfo/ACTIVITYDEFID", wfWorkItem.getActivitydefid());
	map.put("oaapprovalinfo/ZCFLAG", String.valueOf(0));
	map.put("oaapprovalinfo/ACTIVITYDEFNAME", wfWorkItem.getActivityinstname());
	map.put("oaapprovalinfo/APPLYNO", wfWorkItem.getApplyno().toString());
	map.put("oaapprovalinfo/PROCESSINSTID", bo.getProcessinstId());
	map.put("oaapprovalinfo/WORKITEMID", wfWorkItem.getWorkitemid().toString());
	map.put("oaapprovalinfo/ISAGREE", bo.getIsagree());
	map.put("oaapprovalinfo/managerid", bo.getDevManagerId());
	map.put("oaapprovalinfo/userid",bo.getDevId());
	map.put("oaapprovalinfo/need",bo.getNeed());//外请车是否需要总裁审批
	map.put("oaapprovalinfo/checkceo", bo.getNeed());//日常费用报销是否需要总裁审批
	map.put("oaapprovalinfo/LOCALPERSONNEL", bo.getLocalPersonnel());//所属人事部
	map.put("oaapprovalinfo/isNeed",bo.getIsNeed());//是否需要财务审批
	map.put("oaapprovalinfo/level",bo.getLevel());//当前审批人职级
	map.put("userid", bo.getDevId());
	
	return map;
    }
    
    /**=========HTTP Client==================发送请求远程审批工作流=======================*/
    private String postApprove(String url, Map<String, String> params,
	    String sid) throws Exception {
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
	System.out.println("HTTPURL=" + param);
	httpClient.send(param);
	ByteArrayOutputStream out = httpClient.getOutputStream();
	String html = out.toString("UTF-8");
	System.out.println(html);
	Document doc = Jsoup.parse(html);
	System.out.println("=============================HTML DIV BIGEN=====================");
	Elements linksElements = doc.select("div#errorInfo");
	String element = "";
	System.out.println("==================Elements====="+linksElements);
	for (Element ele : linksElements) {
	    element = ele.text();
	}
	if (StringUtil.isEmptyOrNull(element))
	    throw new Exception("HTTP BACK ELEMENT NULL");
	    
	element = element.trim().substring(0, 1);
	System.out.println("==================element====="+element);
	System.out.println("=============================HTML DIV END=======================");
	return "1".equals(element) ? "success": "failure";
    }
}

