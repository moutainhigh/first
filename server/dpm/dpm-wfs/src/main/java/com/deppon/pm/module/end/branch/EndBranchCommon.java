package com.deppon.pm.module.end.branch;

import java.util.Map;

import com.deppon.dpm.module.wfs.server.util.SpringContextUtil;
import com.deppon.pm.module.end.branch.service.IBranchRuleManagerService;
/**
 * 分支规则
 * @author 106140
 * @date 2014-11-4 下午2:22:03
 * @since
 * @version
 */
public class EndBranchCommon {
	
	private IBranchRuleManagerService branchRuleManagerService = ((IBranchRuleManagerService)SpringContextUtil.getBean("branchRuleManagerService"));
	/** 
	 * <p>研发型返回true</p> 
	 * @author 106140
	 * @date 2014-11-4 下午2:34:21
	 * @param map
	 * @return 
	 * @ 
	 * @see com.deppon.pm.module.end.branch.service.IBranchRuleManagerService#getProjectType(java.util.Map)
	 */
	public boolean projectTypeIsDevelopment(Map map)  {
		return branchRuleManagerService.projectTypeIsDevelopment(map);
	}
	
	/** 
	 * <p>战略型返回true</p> 
	 * @author 106140
	 * @date 2014-11-4 下午2:34:21
	 * @param map
	 * @return 
	 * @ 
	 * @see com.deppon.pm.module.end.branch.service.IBranchRuleManagerService#getProjectType(java.util.Map)
	 */
	public boolean projectLevelIsStrategy(Map map)  {
		return branchRuleManagerService.projectLevelIsStrategy(map);
	}
	
	/**
	 * <p>落地判断战略</p> 
	 * @author 106140
	 * @date 2014-11-5 上午9:39:14
	 * @param map
	 * @return
	 * @
	 * @see
	 */
	public boolean levelIsStrategyGround(Map map) {
		return branchRuleManagerService.levelIsStrategyGround(map);
	}

	/**
	 * @return  the branchRuleManagerService
	 */
	public IBranchRuleManagerService getBranchRuleManagerService() {
		return branchRuleManagerService;
	}

	/**
	 * @param branchRuleManagerService the branchRuleManagerService to set
	 */
	public void setBranchRuleManagerService(
			IBranchRuleManagerService branchRuleManagerService) {
		this.branchRuleManagerService = branchRuleManagerService;
	}
	
}
