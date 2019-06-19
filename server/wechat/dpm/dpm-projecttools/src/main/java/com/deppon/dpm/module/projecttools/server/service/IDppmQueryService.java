package com.deppon.dpm.module.projecttools.server.service;

import java.util.Map;

import com.deppon.dpm.module.projecttools.shared.domain.ProjectMinutes;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectStrutsInfo;


public interface IDppmQueryService {
	
	/**
	 * 查询项目列表接口
	 * @return
	 * @throws Exception
	 */

	public String queryProjectInfo(String userId,String jobLevel) throws Exception;
	/**
	 * 部门查询项目列表接口
	 * @return
	 * @throws Exception
	 */
	public String queryDepartmentProjectInfo(String userId,String jobNumber);
	
	/**
	 * 查询项目明细信息接口
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> queryProjectDeatil(String param) throws Exception;
	/**
	 * 查询项目状态信息接口
	 * @param param
	 * @return String
	 * @throws Exception
	 */

	public Map<String,ProjectStrutsInfo> queryStatusDetailInfoservice(String projectCode) throws Exception;
	/**
	 * <p>Description: 项目管理工具审核接口</p>
	 * @param checkStatus 审核状态
	 * @param taskId 审核ID
	 * @return String
	 * @throws Exception
	 */
	public String audit(String checkStatus, String taskId,String opinion)throws Exception;
	/**
	 * <p>Description: 项目管理工具收藏列表查询</p>
	 * @param userId 用户ID
	 * @return String
	 */
	public Map<String, Object> collectProjectInfo(String userId,String power,String jobNumber)throws Exception;

	/**
	 * <p>Description: 查询会议纪要</p>
	 * @param msId 里程碑对应的节点ID
	 * @return List
	 */
	public ProjectMinutes queryprojectMinutes(String msId);
	/**
	 *  Title:查看项目资源
	 *  @param projectCode
	 *  Author: 280769
	 * 	Date: 2015-9-28
	 * */
	public Map<String, Object> queryProjectResources(String projectCode);
}
