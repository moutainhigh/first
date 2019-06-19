/**
 * 
 */
package com.deppon.dpm.module.projecttools.server.service;

import com.deppon.dpm.module.projecttools.shared.domain.ProjectMonitroInfo;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * TODO
 * @author Gang
 * 2015-9-16
 */
public interface IDppmMonitorService {
	/**
	 * TODO 插入监控数据
	 * @author Gang
	 * 上午10:48:49
	 */
	public void insertMonitor(ProjectMonitroInfo monitroInfo)throws BusinessException;

}
