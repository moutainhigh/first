package com.deppon.dpm.tongxunlu.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.deppon.dpm.tongxunlu.server.dao.ISystemConfigDao;
import com.deppon.dpm.tongxunlu.shared.domain.MonitorDownload;
import com.deppon.dpm.tongxunlu.shared.domain.MonitorTime;
import com.deppon.dpm.tongxunlu.shared.vo.SystemConfig;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 系统信息dao层实现
 */
public class SystemConfigDao extends iBatis3DaoImpl implements ISystemConfigDao {
	/**
	 * jdbc模板
	 */
	private JdbcTemplate template;
	/**
	 * 命名空间
	 */
	private String NAMESPACE = "com.deppon.dpm.tongxunlu.server.dao.systemConfig.";
	/**
	 * 查询系统配置
	 */
	private String QUERY_SINGLE_SYSTEM_CONFIG = "querySingleSystemConfig";
	/**
	 * 更新同步时间
	 */
	private String UPDATE_SYNCDATE_BY_LASTSYNC_DATE = "updateSyncDateByLastSyncDate";
	/**
	 * 增加通讯录访问次数
	 */
	private String DATA__MONITOR = "dataMonitor";
	/**
	 * 功能访问监控数
	 */
	private static final String FUNCTION_ACCESS_MONITOR = "functionAccessMonitor";
	/**
	 * 监控模块访问时长
	 */
	private static final String DATA__MONITOR_TIME = "dataMonitorTime";
	/**
	 * 监控应用下载or卸载
	 */
	private static final String DATA__MONITOR_DOWNLOAD = "dataMonitorDownload";

	/**
	 * 查看应用版本（没有被调用）
	 */
	public SystemConfig seeVersion(final String appName) {
		// sql
		String sql = "select * from system_config where appname = ?";
		// 执行
		List<SystemConfig> list = template.query(sql, new RowMapper<SystemConfig>(){
			// 复写的方法
			@Override
			public SystemConfig mapRow(ResultSet rs, int rowNum) throws SQLException {
				// 返回的实体
				SystemConfig systemConfig = new SystemConfig();
				// android_url
				systemConfig.setAndroidUrl(rs.getString("android_url"));
				// android_version
				systemConfig.setAndroidVersion(rs.getString("android_version"));
				// iphone_url
				systemConfig.setIphoneUrl(rs.getString("iphone_url"));
				// iphone_version
				systemConfig.setIphoneVersion(rs.getString("iphone_version"));
				// content
				systemConfig.setContent(rs.getString("content"));
				// iphoneForce
				systemConfig.setIphoneForce(rs.getString("iphoneForce"));
				// androidForce
				systemConfig.setAndroidForce(rs.getString("androidForce"));
				return systemConfig;
			}
			
		},appName);
		// 判断
		if (null != list && list.size() > 0){
			// 返回第一个元素
			return list.get(0);
		}
		// 返回null
		return null;
	}

	/**
	 * 查询单个系统版本
	 */
	@Override
	public SystemConfig querySingleSystemConfig(SystemConfig param) {
		// 查询
		return (SystemConfig) this.getSqlSession().selectOne(NAMESPACE + QUERY_SINGLE_SYSTEM_CONFIG, param);
	}

	/**
	 * 查看是否需要版本更新
	 */
	@Override
	public int updateSyncDateByLastSyncDate(Date oldLastSynDate,
			Date newLastSynDate) {
		// 用于参数拼接
		Map<String, Object> param = new HashMap<String, Object>();
		// 老版本时间
		param.put("oldLastSynDate", oldLastSynDate);
		// 新版本时间
		param.put("newLastSynDate", newLastSynDate);
		// 数据库查询
		return this.getSqlSession().update(NAMESPACE + UPDATE_SYNCDATE_BY_LASTSYNC_DATE, param);
	}

	/**
	 * 数据监控dao层接口
	 */
	@Override
	public void dataMonitor(int monitorType, String empCode, String osType) {
		// 用于参数拼接
		Map<String, Object> param = new HashMap<String, Object>();
		// 监控类型，
		param.put("monitorType", monitorType);
		// 工号
		param.put("empCode", empCode);
		// 设备类型
		param.put("osType", osType);
		// 插入数据库
		getSqlSession().insert(NAMESPACE + DATA__MONITOR, param);
	}
	
	/**
	 * 数据监控dao层接口
	 * 监控模块访问时长
	 */
	@Override
	public void dataMonitorTime(MonitorTime monitorTime) {
		// 插入数据库
		this.getSqlSession().insert(NAMESPACE + DATA__MONITOR_TIME, monitorTime);
	}
	
	/**
	 * 数据监控dao层接口
	 * 监控应用下载or卸载
	 */
	@Override
	public void dataMonitorDownload(MonitorDownload monitorDownload) {
		// 插入数据库
		this.getSqlSession().insert(NAMESPACE + DATA__MONITOR_DOWNLOAD, monitorDownload);
	}
	
	/**
	 * 功能访问监控
	 */
	@Override
	public void functionAccessMonitor(Map<String, String> map) {
		this.getSqlSession().insert(NAMESPACE + FUNCTION_ACCESS_MONITOR, map);
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public JdbcTemplate getTemplate() {
		return template;
	}

	/**
	 * set
	 * 
	 * @param template
	 */
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

}
