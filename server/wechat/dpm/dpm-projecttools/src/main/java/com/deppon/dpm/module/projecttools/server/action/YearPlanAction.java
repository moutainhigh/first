package com.deppon.dpm.module.projecttools.server.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.projecttools.server.service.IDppmMonitorService;
import com.deppon.dpm.module.projecttools.server.service.IYearPlanService;
import com.deppon.dpm.module.projecttools.server.util.com.deppon.dpm.module.wfs.server.util.monitor.MonitorUtil;
/**
 * 项目管理 年度规划
 * @author gcl
 * 2015-10-16
 */
public class YearPlanAction extends BaseAction {
	/*** 日志*/
	private Logger logger = LoggerFactory.getLogger(YearPlanAction.class);
	
	private static final long serialVersionUID = 1L;
	
	/*** service*/
	private IYearPlanService yearPlanSrv;
	//数据监控service
	private IDppmMonitorService dppmMonitorService;
	/**
	 * 项目编号
	 */
	private int project_id;
	/**
	 * 项目类型
	 */
    private int gh_type;
    
    
	/**
	 *  年度规划项目列表查询 分部门，分项目级别（ 战略项目，IT项目）
	 */
	public void projList() {
		//初始化 json数据
		String json = "";
		try {
			// 查询
			json = this.yearPlanSrv.projList(this.userId);
		} catch (Exception e) {
			logger.info("查询年度规划项目列表出现异常！", e);
			e.printStackTrace();
		} finally {
			//数据监控
			MonitorUtil monitorUtil = new MonitorUtil();
			monitorUtil.dateMonitor(this.userId, "15", null, dppmMonitorService);
		}
		writeToPage(json);
	}
	
	/**
	 *  年度规划 详情查询 及资源信息查询
	 */
	public void projInfo() {
		//初始化 json数据
		String json = "";
		try {
			// 查询
			json = this.yearPlanSrv.projInfo(project_id, gh_type);
		} catch (Exception e) {
			logger.info("查询年度规划详情及资源信息出现异常！", e);
			e.printStackTrace();
		}
		writeToPage(json);
	}


	/**
	 * @param yearPlanSrv
	 */
	public void setYearPlanSrv(IYearPlanService yearPlanSrv) {
		this.yearPlanSrv = yearPlanSrv;
	}

	/**
	 * @param project_id
	 */
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	/**
	 * @param gh_type
	 */
	public void setGh_type(int gh_type) {
		this.gh_type = gh_type;
	}

	/**
	 * @param dppmMonitorService
	 */
	public void setDppmMonitorService(IDppmMonitorService dppmMonitorService) {
		this.dppmMonitorService = dppmMonitorService;
	}

}
