package com.deppon.dpm.module.wfs.server.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.wfs.server.service.ICrmWorkInfoService;
import com.deppon.dpm.module.wfs.server.util.RestfulUtil;
import com.deppon.dpm.module.wfs.shared.domain.crm.CrmApproveParam;
import com.deppon.dpm.module.wfs.shared.vo.QueryParamVo;

/**
 * 
 * crm客户关系管理工作流Service
 * 
 * version:V1.0
 * @author 195406 高春玲
 * @date 2015-6-29 下午1:45:08
 **/
public class CrmWorkInfoService implements ICrmWorkInfoService {
	
	private Logger logger = LoggerFactory.getLogger(CrmWorkInfoService.class);
    /**
     * 工作流查看接口地址
     */
	private String uri;
	/**
	 * 工作流审批接口地址
	 */
	private String uriA;

    /**
     * 工作流查询  根据请求参数 调用服务端地址 获得工作流详情
     * @param query 
     */
	@Override
	public String queryWorkInfo(QueryParamVo query) {
		logger.info("crm querywfs url is :" + uri);
		String json = JSONObject.toJSONString(query);
		
//		uri = "http://10.224.65.111:8080/crm-interface/ws/custrepeat/queryRepetitiveCustWorkFlowInfo";

		return RestfulUtil.restfulWork(uri, "ESB_DPM2ESB_MOBILEOFFICE_DISPOSEQUERY", json, "crm");
	}
	/**
     * 工作流审批  根据请求参数审批信息 执行审批操作
     * @param audit 
     */
	@Override
	public String approveWorkInfo(CrmApproveParam audit) {
		logger.info("crm approvewfs url is :" + uriA);
		String json = JSONObject.toJSONString(audit);
		return RestfulUtil.restfulWork(uriA, "ESB_DPM2ESB_WORKFLOW_APPROVAL", json, "crm");
	}
    
	

	public void setUri(String uri) {
		this.uri = uri;
	}

	public void setUriA(String uriA) {
		this.uriA = uriA;
	}

}
