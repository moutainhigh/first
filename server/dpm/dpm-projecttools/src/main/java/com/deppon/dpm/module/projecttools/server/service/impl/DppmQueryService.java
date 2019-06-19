package com.deppon.dpm.module.projecttools.server.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.projecttools.server.dao.IDppmQueryDao;
import com.deppon.dpm.module.projecttools.server.dao.IDppmTaskDao;
import com.deppon.dpm.module.projecttools.server.dao.impl.DppmQueryDao;
import com.deppon.dpm.module.projecttools.server.service.IDppmQueryService;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectMinutes;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectResources;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectStrutsInfo;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * TODO 项目管理工具
 * @author 石学钢
 * 2015-9-24
 */
public class DppmQueryService implements IDppmQueryService {
	// 日志
	Logger logger = LoggerFactory.getLogger(DppmQueryDao.class);

	//PMO权限判断
	IDppmTaskDao dppmTaskDao;

	//项目列表查询
	private IDppmQueryDao dppmQueryDao;
	
	/**
	 * 查询个人项目管理的列表信息
	 */
	public static final int NUMBER_OF_EIGHT = 8;

	@Override
	public String queryProjectInfo(String userId,String jobLevel) throws BusinessException {
		//判断用户权限
		boolean power,isPmo = false;
		try{	
			//判断band级别是否大于7和是否是POM
			power=(!StringUtil.isEmpty(jobLevel)
					&&!"undefined".equals(jobLevel)&&(jobLevel.trim().toUpperCase().equals("C")
							||jobLevel.trim().toUpperCase().equals("D")
							||Integer.parseInt(jobLevel)>=NUMBER_OF_EIGHT));
			isPmo = dppmTaskDao.isPMOByEmCode(userId);
		} catch (BusinessException e) {
			//传过来的参数转换异常就无权限
			logger.info("数据转换异常");
			power=false;
		}
		return dppmQueryDao.queryproject(userId,jobLevel,power,isPmo);
	}
	/** 
	 * TODO 查询部门项目管理的列表信息
	 * @author Gang
	 * 2015-9-24
	 * @see com.deppon.dpm.module.projecttools.server.service.IDppmQueryService#queryDepartmentProjectInfo(java.lang.String, java.lang.String)
	 */
	@Override
	public String queryDepartmentProjectInfo(String userId, String jobNumber) {
		return JsonUtil.mapToJsonString(dppmQueryDao.queryDepartmentproject(userId, jobNumber));
	}

	/** 
	 * TODO 查询项目明细信息接口
	 * @author Gang
	 * 2015-9-24
	 * @see com.deppon.dpm.module.projecttools.server.service.IDppmQueryService#queryProjectDeatil(java.lang.String)
	 */
	
	@Override
	public Map<String, Object> queryProjectDeatil(String projectCode ) throws BusinessException {
			return dppmQueryDao.queryProjectDeatil(projectCode);
		}
	
	/** 
	 * TODO
	 * @author 查询项目状态详情接口
	 * 2015-9-24
	 * @see com.deppon.dpm.module.projecttools.server.service.IDppmQueryService#queryStatusDetailInfoservice(java.lang.String)
	 */
	@Override
	public Map<String,ProjectStrutsInfo> queryStatusDetailInfoservice(String projectCode)
			throws BusinessException {
		return dppmQueryDao.queryStrutsInfo(projectCode);
		}

	/** 
	 * TODO 审核接口
	 * @author 石学钢
	 * 2015-9-24
	 * @see com.deppon.dpm.module.projecttools.server.service.IDppmQueryService#audit(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String audit(String checkStatus, String taskId,String opinion) throws BusinessException {
		return dppmQueryDao.audit(checkStatus, taskId,opinion);
	}
	
	/** 
	 * TODO 项目收藏列表查询
	 * @author 石学钢
	 * 2015-9-24
	 * @see com.deppon.dpm.module.projecttools.server.service.IDppmQueryService#collectProjectInfo(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> collectProjectInfo(String userId,String power,String jobNumber) throws BusinessException {
		return dppmQueryDao.queryCollectProject(userId,power,jobNumber);
	}
	/** 
	 * TODO 查询会议纪要
	 * @author 石学钢
	 * 2015-9-16
	 * @throws BusinessException 
	 * @see com.deppon.dpm.module.projecttools.server.service.IDppmQueryService#InsertMonitor(com.deppon.dpm.module.projecttools.shared.domain.ProjectMonitroInfo)
	 */
	@Override
	public ProjectMinutes queryprojectMinutes(String msId) {
		return dppmQueryDao.queryprojectMinutes(msId);
	}
	/**
	 * @param dppmTaskDao the dppmTaskDao to set
	 */
	public void setDppmTaskDao(IDppmTaskDao dppmTaskDao) {
		this.dppmTaskDao = dppmTaskDao;
	}
	/**
	 * @param dppmQueryDao the dppmQueryDao to set
	 */
	public void setDppmQueryDao(IDppmQueryDao dppmQueryDao) {
		this.dppmQueryDao = dppmQueryDao;
	}

	/**
	 *  Title:查看项目资源
	 *  @param projectCode
	 *  Author: 280769
	 * 	Date: 2015-9-28
	 * */
	@Override
	public Map<String, Object> queryProjectResources(String projectCode) {
		//return dppmQueryDao.queryProjectResources(projectCode);
		List<ProjectResources> listA=dppmQueryDao.queryProjectResources(projectCode);
		//项目资源list甲方
		List<ProjectResources> listJia = new ArrayList<ProjectResources>();
		BigDecimal roleProceJia = new BigDecimal(0);
		//项目资源list乙方
		List<ProjectResources> listYi = new ArrayList<ProjectResources>();
		BigDecimal roleProceYi = new BigDecimal(0);
		BigDecimal roleProceYii = new BigDecimal(0);
		//项目资源list其他
		List<ProjectResources> listQt = new ArrayList<ProjectResources>();
		BigDecimal roleProceQt = new BigDecimal(0);
		for (ProjectResources projectResources : listA) {
			String cflag = projectResources.getCflag();
			//判断是甲、乙还是其他的
			//0是甲 1是乙  2是其他
			if("0".equals(cflag)){
				listJia.add(projectResources);
//				roleProceJia = roleProceJia.add(projectResources.getAllProce());
				roleProceJia = roleProceJia.add(projectResources.getRolePrice());
			}else if("1".equals(cflag)){
				if(projectResources.getPackPrice().longValue() > 0){
					roleProceYi = roleProceYi.add(projectResources.getPackPrice());
				}else {
					roleProceYii = roleProceYi.add(projectResources.getAllProce());
				}
				listYi.add(projectResources);
			}else{
				listQt.add(projectResources);
				roleProceQt = roleProceQt.add(projectResources.getRolePrice());
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ProjectResourcesJia", listJia);
		map.put("ProjectResourcesYi", listYi);
		map.put("ProjectResourcesQt", listQt);
		if(roleProceYi.longValue() > 0){
			map.put("allsum", (roleProceJia.add(roleProceYi).add(roleProceQt)));
		}
		else{
			map.put("allsum", (roleProceJia.add(roleProceYii).add(roleProceQt)));
		}
		return map;
	}
}
