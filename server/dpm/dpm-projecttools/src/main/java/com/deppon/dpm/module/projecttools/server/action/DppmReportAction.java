package com.deppon.dpm.module.projecttools.server.action;

import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.projecttools.server.service.IDppmMonitorService;
import com.deppon.dpm.module.projecttools.server.service.IDppmReportService;
import com.deppon.dpm.module.projecttools.server.util.DateUtil;
import com.deppon.dpm.module.projecttools.server.util.com.deppon.dpm.module.wfs.server.util.monitor.MonitorUtil;
/**
 * 报表管理  
 * 任务工时上报、需求上线时效、需求点均成本
 * @author gcl
 * 2015-08-22
 */
public class DppmReportAction extends BaseAction {
	/*** 日志*/
	private Logger logger = LoggerFactory.getLogger(DppmReportAction.class);

	private static final long serialVersionUID = 1L;
	
	//调用数据监控的service
	private IDppmMonitorService dppmMonitorService;
	
	/*** service*/
	private IDppmReportService dppmReportService;
	//查询日期 （开始日期）
	private String date;
	// 结束日期
	private String edate;
	//用户工号
	private String userId;
	//项目名称
	private String proName;
	//搜索类型 (搜索承接部门 2 or 搜索项目名称 1)
	private int type;

	/**
	 *  任务工时上报
	 *  1、按日期 最近一周的企发办平均上报率
	 *  2、当天（日期可选）副总下所属企发办中高级总监 和 总监所属部门排名
	 */
	public void taskTimeReport() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			this.logger.info("任务工时上报查询  date is :" + this.date);
			String info = this.dppmReportService.taskTimeReport(this.userId,this.date);

			writeToPage(response, info);
			this.logger.info("任务工时上报查询  返回信息 :" + info);
		} catch (Exception e) {
			this.logger.info("任务工时上报查询 出现异常！", e);
			writeToPage(response, "");
		} finally {
			//数据监控
			MonitorUtil monitorUtil = new MonitorUtil();
			monitorUtil.dateMonitor(this.userId, "6", null, dppmMonitorService);
		}
	} 
	/**
	 * 企发办最近一周平均上报工时 (曲线图)
	 */
	public void taskWeekReport() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			String info = this.dppmReportService.taskWeekReport(this.userId,this.date);

			writeToPage(response, info);
			this.logger.info("任务工时上报（最近一周）查询  返回信息 :" + info);
		} catch (Exception e) {
			this.logger.info("任务工时上报（最近一周）查询 出现异常！", e);
			writeToPage(response, "");
		} 
	}
	/**
	 *  需求上线时效
	 *  1、根据开始日期，结束日期 查询三个高级总监对应的部门 数据比较
	 *  2、各个高级总监下面的部门 具体数据
	 */
	public void demandOnlineAging() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			this.logger.info("需求上线时效查询  date is :" + this.date + " edate is " + this.edate);
			String info = this.dppmReportService.demandOnlineAging(this.date, this.edate);

			writeToPage(response, info);
			this.logger.info("需求上线时效查询  返回信息 :" + info);
		} catch (Exception e) {
			this.logger.info("需求上线时效查询 出现异常！", e);
			writeToPage(response, "");
		} finally {
			//数据监控
			MonitorUtil monitorUtil = new MonitorUtil();
			monitorUtil.dateMonitor(this.userId, "7", null, dppmMonitorService);
		}
	}
	/**
	 *  需求点击成本
	 *  根据开始日期，结束日期 查询时间段内的整体点均成本 和部门的输出成本等
	 */
	public void demandPointMoney() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			this.logger.info("需求点击成本查询  date is :" + this.date + " edate is " + this.edate);
			String info = this.dppmReportService.demandPointMoney(this.date, this.edate);

			writeToPage(response, info);
			this.logger.info("需求点击成本查询  返回信息 :" + info);
		} catch (Exception e) {
			this.logger.info("需求点击成本查询 出现异常！", e);
			writeToPage(response, "");
		} finally {
			//数据监控
			MonitorUtil monitorUtil = new MonitorUtil();
			monitorUtil.dateMonitor(this.userId, "8", null, dppmMonitorService);
		}
	}
	/**
	 *  需求点击成本(最近一年整体点均成本)曲线图
	 */
	public void demandPointAging() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			//			logger.info("需求点击成本(最近一年)查询  date is :"+date+" edate is "+edate);
			String info = this.dppmReportService.demandPointAging();

			writeToPage(response, info);
			this.logger.info("需求点击成本(最近一年)查询  返回信息 :" + info);
		} catch (Exception e) {
			this.logger.info("需求点击成本(最近一年)查询 出现异常！", e);
			writeToPage(response, "");
		} 
	}
	/**
	 *  功能点完成率（日常需求人均功能点数）
	 *  按月查询
	 */
	public static final int NUMBER_OF_DATE = 7;

	public void funcCompleteRate() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			this.logger.info("功能点完成率查询  date is :" + this.date);
			// 开始日期
			String bdate = this.date + "-01";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//结束日期
			String enddate = sdf.format(new Date());
			//当月的 默认结束日期是当前日期 其他月的 是 月底
			if(!enddate.substring(0,NUMBER_OF_DATE).equals(this.date)) {
				enddate = DateUtil.queryLastdayOfMonth(this.date);
			}
			String info = this.dppmReportService.funcCompleteRate(bdate, enddate, this.date);

			writeToPage(response, info);
			this.logger.info("功能点完成率查询  返回信息 :" + info);
		} catch (Exception e) {
			this.logger.info("功能点完成率查询 出现异常！", e);
			writeToPage(response, "");
		} finally {
			//数据监控
			MonitorUtil monitorUtil = new MonitorUtil();
			monitorUtil.dateMonitor(this.userId, "9", null, dppmMonitorService);
		}
	}
	/**
	 * 报表权限 
	 * 所有管理层人员 具有权限查看报表   
	 * 15.12.7 添加当前人员代办任务
	 */
	public void powerReport() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			this.logger.info("是否有权限查询报表  userid is :" + this.userId);
			String info = this.dppmReportService.powerReport(this.userId);

			writeToPage(response, info);
			this.logger.info("是否有权限查询报表  返回信息 :" + info);
		} catch (Exception e) {
			this.logger.info("是否有权限查询报表 出现异常！", e);
			writeToPage(response, "0");
		} 
	}
	/**
	 * 项目进度成本
	 * 实现高级搜索：年份，所属部门，承接部门，项目名称，项目类型，项目级别
	 */
	public void projectCostQuery() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			String str = StringUtil.bufferString(bu);
			this.logger.info("项目进度成本查询  param is :" + str);
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)){
				String info = this.dppmReportService.projectCostQuery(str);
				writeToPage(response, info);
				this.logger.info("项目进度成本查询  返回信息 :" + info);
			}
		} catch (Exception e) {
			this.logger.info("项目进度成本查询 出现异常！", e);
			writeToPage(response, "");
		} finally {
			//数据监控
			MonitorUtil monitorUtil = new MonitorUtil();
			monitorUtil.dateMonitor(this.userId, "10", null, dppmMonitorService);
		}
	}
	/**
	 * 项目进度成本 加载搜索界面时 默认加载数据  （数据字典）
	 * 项目类型， 项目级别，所属本部
	 * 9.12
	 */
	public void proTypeQuery() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			this.logger.info("进入项目进度成本高级搜索界面----加载项目类型，级别，所属本部");
			String info = this.dppmReportService.proTypeQuery();

			writeToPage(response, info);
			this.logger.info("进入项目进度成本高级搜索 返回信息 :" + info);
		} catch (Exception e) {
			this.logger.info("进入项目进度成本高级搜索 出现异常！", e);
			writeToPage(response, "");
		} 
	}
	/**
	 * 项目进度成本 高级搜索  按名称模糊搜索 项目名称，承接部门
	 * 9.14
	 */
	public void proDeptQuery() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			this.logger.info("进入项目进度成本高级搜索界面----加载承接部门，项目名称...param is :" + this.type + ".." + this.proName);
			String info = this.dppmReportService.proDeptQuery(this.type, this.proName);

			writeToPage(response, info);
			this.logger.info("进入项目进度成本高级搜索加载承接部门，项目名称  返回信息 :" + info);
		} catch (Exception e) {
			this.logger.info("进入项目进度成本高级搜索加载承接部门，项目名称  出现异常！", e);
			writeToPage(response, "");
		}
	}
	/**
	 * kpi 数据统计 项目管理，报表管理，任务管理，年度规划管理 四个模块的人员访问量统计
	 * @author 高春玲
	 * 11.16
	 */
	public void queryKpi() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			this.logger.info("进入项目管理kpi数据统计----param is :" + this.userId + "..搜索日期---" + this.date);
			String info = this.dppmReportService.queryKpi(this.date);
            
			writeToPage(response, info);
			this.logger.info("进入项目管理kpi数据统计----result is :" + info);
		} catch (Exception e) {
			this.logger.info("进入项目管理kpi数据统计出现异常！", e);
			writeToPage(response, "");
		}
	}
	/**
	 * @param dppmReportService
	 */
	public void setDppmReportService(IDppmReportService dppmReportService) {
		this.dppmReportService = dppmReportService;
	}
	/**
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @param edate
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}
	/**
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @param proName
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}
	/**
	 * @param type
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @param dppmMonitorService the dppmMonitorService to set
	 */
	public void setDppmMonitorService(IDppmMonitorService dppmMonitorService) {
		this.dppmMonitorService = dppmMonitorService;
	}
}
