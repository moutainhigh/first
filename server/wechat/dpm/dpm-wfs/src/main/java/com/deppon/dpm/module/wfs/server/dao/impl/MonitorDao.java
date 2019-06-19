package com.deppon.dpm.module.wfs.server.dao.impl;

import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.JdbcTemplate;

import com.deppon.dpm.module.wfs.server.dao.IMonitorDao;
import com.deppon.dpm.module.wfs.shared.vo.WfsMonitorVo;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 工作流数据监控  对于工作流的查看和审批 记录日志  kpi数据保存
 * @author gcl
 */
public class MonitorDao extends iBatis3DaoImpl implements IMonitorDao {
	
	private JdbcTemplate template;

	// 命名空间
	private String NAMESPACE = "com.deppon.dpm.module.wfs.server.dao.workitems.";

	// 工作流在移动端审批次数
	private String WORKFLOW__MONITOR = "addWfsMonitor";

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
    /**
     * 保存数据监控日志
     */
	@Override
	public void addWfsMonitor(WfsMonitorVo vo) {
		//对于dpm 中记录的开始时间和结束时间进行转换 转化为字符串（毫秒） 
		//dpmontal 老工作流中时间为字符串 不进行转化
		if(vo.getBdateStr() == null || vo.getBdateStr().equals("")){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
			vo.setBdateStr(sdf.format(vo.getBegindate()));
			vo.setEdateStr(sdf.format(vo.getEnddate()));
		}
		//执行数据库插入
		getSqlSession().insert(NAMESPACE + WORKFLOW__MONITOR, vo);
	}

}
