package com.deppon.dpm.module.wfs.server.service;

import com.deppon.dpm.module.wfs.shared.domain.crm.CrmApproveParam;
import com.deppon.dpm.module.wfs.shared.vo.QueryParamVo;

/**
 * 
 * crm Interface
 **/
public interface ICrmWorkInfoService {

	/**
     * 工作流查询  根据请求参数 调用服务端地址 获得工作流详情
     * @param query 
     */
	public String queryWorkInfo(QueryParamVo query);
	/**
     * 工作流审批  根据请求参数审批信息 执行审批操作
     * @param audit 
     */
	public String approveWorkInfo(CrmApproveParam audit);
}
