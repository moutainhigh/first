
package com.deppon.dpm.module.projecttools.server.dao;

import com.deppon.dpm.module.projecttools.shared.domain.ProjectMonitroInfo;

/**
 * TODO 项目管理工具数据监控
 * @author 石学钢
 * 2015-9-16
 */
public interface IDppmMonitorDao {

/**
 * TODO 插入监控数据
 * @author Gang
 * 上午10:48:49
 */
public void insertMonitor(ProjectMonitroInfo monitroInfo)throws Exception;

}
