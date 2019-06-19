package com.deppon.dpm.module.wfs.server.service.impl;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.deppon.dpm.module.wfs.server.service.IFSSCWorkInfoService;
import com.deppon.dpm.module.wfs.server.util.RestfulUtil;
import com.deppon.dpm.module.wfs.server.webservice.FSSCWorkItemServiceClient;
import com.google.gson.Gson;

/**
 * 
 * 报账工作流Service
 * 
 * <p style="display:none">
 * version:V1.0,author:195406 高春玲,date:2015-3-20 下午1:45:08,content:报账工作流
 * </p>
 * 
 * @author 195406 高春玲
 * @date 2015-3-30 下午1:45:08
 **/
public class FSSCWorkInfoService implements IFSSCWorkInfoService {
	/**
	 * log日志
	 */
	private Logger logger  = LoggerFactory.getLogger(FSSCWorkInfoService.class);
    //服务端接口地址
	private String uri;
	//查询接口地址
	private String fssUri;
	//审批接口地址
	private String approveUrl;
    
	/**
	 * @return the fssUri
	 */
	public String getFssUri() {
		return fssUri;
	}
	/**
	 * @param fssUri the fssUri to set
	 */
	public void setFssUri(String fssUri) {
		this.fssUri = fssUri;
	}
	/**
	 * @return the approveUrl
	 */
	public String getApproveUrl() {
		return approveUrl;
	}
	/**
	 * @param approveUrl the approveUrl to set
	 */
	public void setApproveUrl(String approveUrl) {
		this.approveUrl = approveUrl;
	}
	/**
	 * 工作流查询  根据请求参数 调用服务端地址 获得工作流详情
	 * @param workflowInfo 查询参数
	 */
	@Override
	public String queryWorkInfo(Object[] workflowInfo) {
		logger.info("fssc querywfs url is :" + this.uri);
		String s = null;
		try {
			/**
			 * 调用查看接口
			 */
			Object object = FSSCWorkItemServiceClient.getFSSCWorkItemInfo(workflowInfo, this.uri);
			if(object != null){
				s = new Gson().toJson(object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	/**
	 * 工作流审批  根据请求参数审批信息 执行审批操作
	 * @param obj
	 */
	@Override
	public String approveWorkInfo(Object[] obj) {
		String s = null;
		try {
			/**
			 * 调用审批接口
			 */
			s = FSSCWorkItemServiceClient.approveFSSC(obj,this.uri);
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return s;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * 工作流查询  根据请求参数 调用服务端地址 获得工作流详情
	 * @param json  查询参数
	 * @author 280769 张彬
	 * @date 2015-9-16 下午2:00:08
	 */
	@Override
	public String fssQueryWorkInfo(String json)  {
		logger.info("fssc querywfs url is :" + this.fssUri);
//		Map<String, Object> obj=new HashMap<String, Object>();
//		obj.put("claimNo;",workflowInfo);
//		obj.put("userId",workflowInfo);
//		obj.put("workitemid",workflowInfo);
//		JsonUtil.mapToJsonObject(obj).toString()
		logger.info(json);
		return RestfulUtil.restfulWork(fssUri,"ESB_APP2ESB_WORKFLOW_QUERY_INTF",json,"fssc");
	}
	
	/**
	 * 工作流审批  根据请求参数审批信息 执行审批操作
	 * @param json
	 * @author 280769 张彬
	 * @date 2015-9-16 下午
	 */
	@Override
	public String fssApproveWorkInfo(String json) {
		logger.info("fssc approvewfs url is :" + this.approveUrl);
//		String json = JSONObject.toJSONString(audit);
		return RestfulUtil.restfulWork(approveUrl, "ESB_APP2ESB_EXAMINATION_WORKFOLW_INTF", json, "fssc");
	}
}
