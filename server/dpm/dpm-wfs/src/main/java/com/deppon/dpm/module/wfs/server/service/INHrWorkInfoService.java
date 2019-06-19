package com.deppon.dpm.module.wfs.server.service;

import com.deppon.dpm.module.wfs.shared.domain.nhr.ApproveParam;
import com.deppon.dpm.module.wfs.shared.domain.nhr.QueryLeaveParams;
import com.deppon.dpm.module.wfs.shared.domain.nhr.QueryParam;
import com.deppon.dpm.module.wfs.shared.vo.NhrQueryParamVo;

/**
 * 
 * hr Interface
 **/
public interface INHrWorkInfoService {
	/**
	 * 工作流查询 根据请求参数 调用服务端地址 获得工作流详情
	 */
	public String queryWorkInfo(QueryParam query);
	
	/**
	 * 离职申请 工作流查询 根据请求参数 调用服务端地址 获得工作流详情
	 */
	public String queryLeaveWorkInfo(QueryLeaveParams queryLeave);

	/**
	 * 工作流查询 根据请求参数 调用服务端地址 获得工作流详情
	 */
	public String approveWorkInfo(ApproveParam audit);

	/**
	 * NHR工作流，人员选择器 
	 * P7异动，直属上级M6，可选择任何等级P类人员交接。
	 * 职能事业群高级总监M9离职/异动，直属上级为高级副总裁D，可选择D及以下人员交接 
	 * C>D>10
	 * 
	 * @param paramVo
	 * @param userId
	 * @return
	 */
	public String queryUserInfo(NhrQueryParamVo paramVo, String userId);
	
}
