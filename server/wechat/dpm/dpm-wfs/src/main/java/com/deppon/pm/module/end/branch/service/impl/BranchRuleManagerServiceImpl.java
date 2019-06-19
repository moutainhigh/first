package com.deppon.pm.module.end.branch.service.impl;

import java.util.Map;

import com.deppon.bpmsapi.module.client.util.BPMSConstant;
import com.deppon.dpm.module.wfs.server.dao.IDppmWorkInfoDao;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ProjectClosingEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ProjectFallGroundEntity;
import com.deppon.pm.module.end.branch.service.IBranchRuleManagerService;
/**
 * <p>项目结项与落地的分支规则</p>
 * @author 106140
 * @date 2014-11-4 下午2:34:21
 * @since
 * @version
 */
public class BranchRuleManagerServiceImpl implements IBranchRuleManagerService {

	/**
	 * 项目结项,落地DAO
	 */
	private IDppmWorkInfoDao dao;
	/** 
	 * <p>研发型返回true</p> 
	 * @author 106140
	 * @date 2014-11-4 下午2:34:21
	 * @param map
	 * @return 
	 * @throws Exception 
	 * @see com.deppon.pm.module.end.branch.service.IBranchRuleManagerService#getProjectType(java.util.Map)
	 */
	@Override
	public boolean projectTypeIsDevelopment(Map map) throws Exception {
		//业务编号
		String busino = (String) map.get(BPMSConstant.BIZCODE);
		//通过业务编号获取结项信息
		ProjectClosingEntity projectClosingEntity = dao.projClosingDetail(busino);
		String projectType = projectClosingEntity.getProjectType();
		//如果项目类型为“研发型”则返回true,否则返回false
		if(projectType.endsWith("研发型")){
			return true;
		}else{
			return false;
		}
	}
	
	/** 
	 * <p>战略级返回true</p> 
	 * @author 106140
	 * @date 2014-11-4 下午2:34:21
	 * @param map
	 * @return 
	 * @throws Exception 
	 * @see com.deppon.pm.module.end.branch.service.IBranchRuleManagerService#getProjectType(java.util.Map)
	 */
	@Override
	public boolean projectLevelIsStrategy(Map map)  throws Exception{
		//业务编号
		String busino = (String) map.get(BPMSConstant.BIZCODE);
		//通过业务编号获取结项信息
		ProjectClosingEntity projectClosingEntity = dao.projClosingDetail(busino);
		String projectLevel = projectClosingEntity.getProjectLevel();
		//如果项目级别为“战略级”则返回true,否则返回false
		if(projectLevel.equals("战略级")){
			return true;
		}else{
			return false;
		}
	}

	/** 
	 * <p>战略级返回true</p> 
	 * @author 106140
	 * @date 2014-11-4 下午2:34:21
	 * @param map
	 * @return 
	 * @throws Exception 
	 * @see com.deppon.pm.module.end.branch.service.IBranchRuleManagerService#levelIsStrategyGround(java.util.Map)
	 */
	@Override
	public boolean levelIsStrategyGround(Map map) throws Exception {
		//业务编号
		String busino = (String) map.get(BPMSConstant.BIZCODE);
		//通过业务编号获取落地信息
		ProjectFallGroundEntity projectFallGroundEntity = dao.projFallGroundDetail(busino);
		String projectLevel = projectFallGroundEntity.getProjectLevel();
		//如果项目级别为“战略级”则返回true,否则返回false
		if(projectLevel.equals("战略级")){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * @return the dao
	 */
	public IDppmWorkInfoDao getDao() {
		return dao;
	}

	/**
	 * @param dao
	 */
	public void setDao(IDppmWorkInfoDao dao) {
		this.dao = dao;
	}
	

}
