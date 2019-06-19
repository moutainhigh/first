package com.deppon.dpm.module.wfs.server.service;


/**
 * 
 * 报账信息 Interface
 **/
public interface IFSSCWorkInfoService {
	/**
	 * 工作流查询  根据请求参数 调用服务端地址 获得工作流详情
	 * @param workflowInfo 查询参数
	 */
	public String queryWorkInfo(Object[] workflowInfo);
	/**
	 * 工作流审批  根据请求参数审批信息 执行审批操作
	 * @param obj
	 */
	public String approveWorkInfo(Object[] obj);
	/**
	 * 工作流查询  根据请求参数 调用服务端地址 获得工作流详情
	 * @param workflowInfo 查询参数
	 */
	public String fssQueryWorkInfo(String  json);
	/**
	 * 工作流审批  根据请求参数审批信息 执行审批操作
	 * @param obj
	 */
	public String fssApproveWorkInfo(String str);
}
