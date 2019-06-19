package com.deppon.dpm.module.wfs.server.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.service.impl.MySSLProtocolSocketFactory;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.wfs.server.service.INetWorkPlanService;

/**
 * 网点规划查询、审批用Service
 * @author 251624
 *
 */
public class NetWorkPlanService implements INetWorkPlanService {
	static Logger logger = LoggerFactory.getLogger(NetWorkPlanService.class);
	/**
	 * ESB查询请求Url
	 */
	String queryUrl;
	String departurl;
	public void setDeparturl(String departurl) {
		this.departurl = departurl;
	}
	public void setQueryUrl(String queryUrl) {
		this.queryUrl = queryUrl;
	}
	
	/**
	 * ESB审批请求Url
	 */
	String approveUrl;
	public void setApproveUrl(String approveUrl) {
		this.approveUrl = approveUrl;
	}
	
	/**
	 * 向网点规划查询商铺租赁工作流信息
	 * @param paramMap
	 * 			网点规划系统的接口参数
	 * @return
	 * @throws Exception 
	 */
	@Override
	public String queryNetWorkPlanInfo(String jsonStr) throws Exception {
		
		return requestClient(jsonStr, queryUrl, "ESB_DPAPP2ESB_QUERY_RENT_WORKFLOW");
	}
	
	/**
	 * 审批网点规划的商铺租贷工作流
	 * @return
	 * @throws Exception
	 */
	@Override
	public String approve(String jsonStr) throws Exception{
		
		return requestClient(jsonStr, approveUrl, "ESB_DPAPP2ESB_APPROVAL_RENT_WORKFLOW");
	}
	/**
	 * 根据参数模糊查询部门名字
	 * <p>Description: TODO</p>
	 * @param 查询部门的条件
	 * @return 部门名字
	 */
	@Override
	public String departmentQeury(HashMap<String, Object> departmentmap )throws Exception{
		return requestClient(JsonUtil.mapToJsonString(departmentmap),departurl, "ESB_APP2ESB_QUERY_DECLARE_DEPARTMENT");
	}
	/**
	 * request请求
	 * @param param
	 * @param esbServiceCode
	 * @return
	 * @throws Exception
	 */
	String requestClient(String param, String url, String esbServiceCode)
			throws Exception {
		HttpClient hc = new HttpClient();

		// 设置编码格式
		hc.getParams().setContentCharset("UTF-8");

		// 设置超时时间
		HttpConnectionManagerParams managerParams = hc
				.getHttpConnectionManager().getParams();

		// 设置连接超时时间(单位毫秒)
		managerParams.setConnectionTimeout(60000);

		// 设置读数据超时时间(单位毫秒)
		managerParams.setSoTimeout(30000);
		Protocol myhttps = new Protocol("https",
				new MySSLProtocolSocketFactory(), 443);
		Protocol.registerProtocol("https", myhttps);

		//header设置
		Map<String, String> map = new HashMap<String, String>();
		map.put("version", "1.0");
		map.put("Content-Type", "application/json;charset=UTF-8");
		map.put("esbServiceCode", esbServiceCode);
		map.put("requestId", UUID.randomUUID().toString());
		map.put("sourceSystem", "DPM");
		
		//参数设置
		String headerJson = JsonUtil.mapToJsonString(map);
		
		RequestEntity entity = new StringRequestEntity(
		        param, "application/json", "UTF-8");
		PostMethod post = new PostMethod(url);
		post.setRequestEntity(entity);
		post.addRequestHeader("Content-Type", "application/json;charset=UTF-8");
		post.addRequestHeader("requestHeaders", headerJson);
		
		logger.info("post url ==========>" + url);
		logger.info("post paramter ==========>" + param);
		logger.info("post header ==========>" + headerJson);
		
		// 执行postMethod
		hc.executeMethod(post);

		String result = post.getResponseBodyAsString();
		logger.info(esbServiceCode + " response data : " + result);

		return result;
	}
}
