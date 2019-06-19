package com.deppon.dpm.module.projecttools.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.projecttools.shared.domain.ProjectMinutes;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectResources;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectStrutsInfo;



public interface IDppmQueryDao {

/**
 * <p>Description: 项目列表查询</p>
 * @param userId 用户ID
 * @return 项目列表
 */
public String queryproject(String userId,String jobLevel,boolean isBand,boolean isPmo);

/**
 * <p>Description: 部门项目列表查询</p>
 * @param userId 用户ID
 * @return 项目列表
 */
public Map<String, Object>  queryDepartmentproject(String userId,String jobnumber);

/**
 * <p>Description: 项目状态详情查询</p>
 * @param projectCode 项目编号
 * @return 项目列表详情
 */
public Map<String,ProjectStrutsInfo> queryStrutsInfo(String projectCode);
/**
 * <p>Description: 项目基本详情查询</p>
 * @param projectCode 项目编号
 * @return String
 */
public Map<String, Object> queryProjectDeatil(String projectCode);

/**
 * <p>Description: 项目任务审核修改</p>
 * @param checkStatus 审核状态
 * @param taskId 审核ID
 * @return String
 */
public String audit(String checkStatus, String taskId,String opinion);
/**查询收藏列表**/
public Map<String, Object> queryCollectProject(String userId,String power,String jobNumber);
/**查询会议纪要**/
public ProjectMinutes queryprojectMinutes(String msId);
/**
 *  Title:查看项目资源
 *  @param projectCode
 *  Author: 280769
 * 	Date: 2015-9-28
 * */
public List<ProjectResources> queryProjectResources(String projectCode);


}	
