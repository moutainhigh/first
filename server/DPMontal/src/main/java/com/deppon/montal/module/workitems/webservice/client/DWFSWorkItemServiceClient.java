package com.deppon.montal.module.workitems.webservice.client;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import com.deppon.montal.util.IHttpClient;
import com.deppon.montal.util.InitDataServlet;
import com.deppon.montal.util.NetUtil;

public class DWFSWorkItemServiceClient {
	/*
	 * 详情url
	 */
	public static String DWFS_DETAILS_URL;
	/*
	 * 校验课程研发审核的工作流号
	 */
	public static String  DWFS_CURRICULUM;
	/*
	 * 获取可回退列表url
	 */
	public static String DWFS_GETBACKARRAY_URL;
	/*
	 * 回退url
	 */
	public static String DWFS_ROLL_BACK_URL;
	/*
	 * 审批url 只有域名  没有具体的action名 需要动态增加
	 */
	public static String DWFS_APPROVAL_URL;
	/*
	 * 获取审批记录list
	 */
	public static String DWFS_APPROVAL_LIST_URL;
	
	static {
		DWFS_DETAILS_URL = InitDataServlet.getValue("dwfs_details_url");
		DWFS_GETBACKARRAY_URL = InitDataServlet.getValue("dwfs_back_array_url");
		DWFS_ROLL_BACK_URL = InitDataServlet.getValue("dwfs_roll_back_url");
		DWFS_APPROVAL_URL = InitDataServlet.getValue("dwfs_approval_url");
		DWFS_APPROVAL_LIST_URL = InitDataServlet.getValue("dwfs_approval_list");
		DWFS_CURRICULUM  = InitDataServlet.getValue("dwfs_curriculum");
	}
	
	public String postToDWFS (String url, Map<String, String> params, String sid) throws UnsupportedEncodingException {
		IHttpClient client = NetUtil.fetchHttpClient();
		client.setRequestURL(url);
		client.setCookie("JSESSIONID=" + sid);
		Iterator iterator = params.keySet().iterator();
		String key = null;
		String value = null;
		String param = "" ;
		String result = null;
		while (iterator.hasNext()) {
			key = (String) iterator.next(); 
			value = params.get(key);
			param  += "&" + key + "=" + URLEncoder.encode(value, "utf8");
		}
		param = param.substring(1);
		client.send(param);
		result = client.getOutputStream().toString("utf-8"); 
		return result;
	}
	
//	public static void main(String[] args) throws UnsupportedEncodingException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
		
		/**获取详情DEMO*/
		/**
		DWFSWorkItemServiceClient client = new DWFSWorkItemServiceClient();
		String url = "http://127.0.0.1:8881/wfs/workflow/getDetails.action";
		String sid = "123";
		Map map = new HashMap();
		map.put("busino", "DWFS131115366009916");
		map.put("processDefName", "com.deppon.bpms.module.wfs.bpsdesign.personnel.resignation");
		String result = client.postToDWFS(url, map, sid);
		System.out.println(result);
		ResignationBean bean = new ResignationBean();
		Object object = JSONUtil.translateToBean(bean.getClass(), result);
		*/
		
		/**审批DEMO*/
		/**
		String approvalURL = "http://127.0.0.1:8881/wfs/workflow/approvalWorkFlow.action";
		Map param = new HashMap();
		param.put("approvelEntity.processinstid", "36305");
		param.put("approvelEntity.workItemId", "70093");
		param.put("approvelEntity.activityDefId", "immediateSuperior");
		param.put("approvelEntity.activityinstid", "95849");
		param.put("approvelEntity.isAgree", "0");
		param.put("approvelEntity.approveOpinion", "审批同意");
		DWFSWorkItemServiceClient client = new DWFSWorkItemServiceClient();
		String result = client.postToDWFS(approvalURL, param, "");
		System.out.println(result);
		if (result.contains("\"success\":true")) {
			System.out.println("审批成功");
		} 
		*/
		
		/**获取回退列表*/
		/**
		DWFSWorkItemServiceClient client = new DWFSWorkItemServiceClient();
		String getRollBackUrl = "http://127.0.0.1:8881/wfs/workflowmsg/getRollBackArray.action";
		Map param = new HashMap();
		param.put("workItemId", "69940");
		param.put("processinstid", "35964");
		String result = client.postToDWFS(getRollBackUrl, param, "");
		System.out.println(result);
		//[{"currentActivity":{"activityDefId":"manualActivity","activityInstId":95605,"activityName":"直接上级","back":false,"joinMode":null,"levelByLevel":false,"participants":null,"paticipantRule":null,"splitMode":null,"sysApprove":false},
		//"nextActivity":{"activityDefId":"Drafter","activityInstId":0,"activityName":"起草人","back":false,"joinMode":null,"levelByLevel":false,"participants":null,"paticipantRule":null,"splitMode":null,"sysApprove":false},"processDefId":1761,"processDefName":"com.deppon.bpms.module.wfs.bpsdesign.finance.BankAccount","rule":null}]
		*/
		
		/**回退操作*/
//		DWFSWorkItemServiceClient client = new DWFSWorkItemServiceClient();
//		String rollBackUrl = "http://192.168.20.166/wfs/workflow/rollBack.action";
//		Map map = new HashMap();
//		map.put("approvelEntity.processinstid", "35536");
//		map.put("approvelEntity.workItemId", "68140");
//		map.put("approvelEntity.activityDefId", "manualActivity");
//		map.put("approvelEntity.activityinstid", "92912");
//		map.put("nextActitvityID", "Drafter");
//		map.put("approvelEntity.approveOpinion", "");
//		String result = client.postToDWFS(rollBackUrl, map, "");
//		System.out.println(result);
//		if("true".equals(result)) {
//			System.out.println("回退成功");
//		}
//	}
}
