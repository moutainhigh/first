package com.deppon.pm.module.end.branch.service;

import java.util.Map;
/**
 * @author 106140
 * @date 2014-11-4 下午2:30:03
 * @since
 * @version
 */
public interface IBranchRuleManagerService {
	/** 
	 * <p>项目结项研发型返回true</p> 
	 * @author 106140
	 * @date 2014-11-4 下午2:34:21
	 * @param map
	 * @return 
	 * @ 
	 * @see com.deppon.pm.module.end.branch.service.IBranchRuleManagerService#getProjectType(java.util.Map)
	 */
	boolean projectTypeIsDevelopment(Map map)  ;
	
	/** 
	 * <p>项目结项战略级返回true</p> 
	 * @author 106140
	 * @date 2014-11-4 下午2:34:21
	 * @param map
	 * @return 
	 * @ 
	 * @see com.deppon.pm.module.end.branch.service.IBranchRuleManagerService#getProjectType(java.util.Map)
	 */
	boolean projectLevelIsStrategy(Map map)  ;
	/**
	 * <p>落地判断战略</p> 
	 * @author 106140
	 * @date 2014-11-5 上午9:39:14
	 * @param map
	 * @return
	 * @
	 * @see
	 */
	boolean levelIsStrategyGround(Map map)  ;
}
