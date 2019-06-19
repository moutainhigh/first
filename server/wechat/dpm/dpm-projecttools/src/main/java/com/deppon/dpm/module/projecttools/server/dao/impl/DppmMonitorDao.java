
package com.deppon.dpm.module.projecttools.server.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.deppon.dpm.module.projecttools.server.dao.IDppmMonitorDao;
import com.deppon.dpm.module.projecttools.server.util.SqlUtil;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectMonitroInfo;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * TODO 项目管理工具数据监控
 * @author 石学钢
 * 2015-9-16
 */


public class DppmMonitorDao extends iBatis3DaoImpl implements IDppmMonitorDao {
	// 日志
    private Logger logger = LoggerFactory.getLogger(DppmMonitorDao.class);

	//JDBC连接
	private JdbcTemplate template;

	/** 
	 * TODO 插入监控数据
	 * @author 石学钢
	 * 2015-9-16
	 * @see
	 */
	
	@Override
	public void insertMonitor(ProjectMonitroInfo monitroInfo) throws Exception{
		String sql=SqlUtil.getMonitroinsertsql();
		logger.info("执行数据监控插入"+sql+"##"+monitroInfo.getUserId()+"##"+monitroInfo.getType()+"##"+monitroInfo.getDetails());
		template.update(sql,new Object[]{monitroInfo.getUserId(),monitroInfo.getType(),monitroInfo.getDetails()},new int[]{java.sql.Types.VARCHAR,java.sql.Types.VARCHAR,java.sql.Types.VARCHAR});
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
}
