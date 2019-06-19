package com.deppon.dpm.module.projecttools.server.action;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.projecttools.server.service.IDppmMonitorService;
import com.deppon.dpm.module.projecttools.server.service.ITaskLogService;
import com.deppon.dpm.module.projecttools.server.util.TaskMonitor;
import com.deppon.dpm.module.projecttools.server.util.com.deppon.dpm.module.wfs.server.util.monitor.MonitorUtil;
import com.deppon.dpm.module.projecttools.shared.domain.TaskLogEntity;
/**
 * 任务管理  任务详情======任务日志跟踪和任务详细信息查询
 * @author gcl
 * 2015-08-08
 */
public class TaskLogAction extends BaseAction {
	/*** 日志*/
	private Logger logger = LoggerFactory.getLogger(TaskLogAction.class);
	
	private static final long serialVersionUID = 1L;
	
	/*** service*/
	private ITaskLogService tasklogService;
	//任务编号
	private int taskid;
	//用户工号
	private String userId;
	private IDppmMonitorService dppmMonitorService;
	public void setDppmMonitorService(IDppmMonitorService dppmMonitorService) {
		this.dppmMonitorService = dppmMonitorService;
	}

	/**
	 *  任务详情查询
	 *  任务日志跟踪和任务详细信息查询
	 */
	public void queryLog() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			this.logger.info("点击任务查看详情  taskid is :" + this.taskid);
			// 根据任务编号 获得任务详情及任务跟踪日志
			String info = this.tasklogService.queryLog(this.taskid);
			// 返回前端
			writeToPage(response, info);
			this.logger.info("点击任务查看详情  返回信息 :" + info);
		} catch (Exception e) {
			this.logger.info("点击任务查看详情 出现异常！", e);
			// 如有异常 返回前端为 “”
			writeToPage(response, "");
		} 
	}
	/**
	 *  新增任务跟踪日志
	 */
	public void addTasklog() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request=ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String resinfo = "";
		if ("POST".equals(request.getMethod())) {
			try {
				//获取请求参数
				BufferedReader bu = ServletActionContext.getRequest().getReader();
				TaskLogEntity vo = null;
				//请求参数转换成String
				String str = StringUtil.bufferString(bu);
				this.logger.info("点击新增跟踪日志提交  param is :" + str);
				// 获得前端封装的日志信息
				if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
					// 对前端传输数据进行转换为 log 实体
					vo = JSONObject.parseObject(str,
							TaskLogEntity.class);
					// 保存日志信息
					vo.setEmpcode(this.userId);
					int info = this.tasklogService.addtasklog(vo);
					resinfo = info + "";
					// 对保存实体 是否成功返回前端显示
//					writeToPage(response, info + "");
					this.logger.info("点击新增跟踪日志提交  返回信息 :" + info);
					// 如果新增跟踪日志保存成功 发送邮件提醒 对应提醒人
					if(info == 1) {
						//新增日志成功 异步调用发送邮件到提醒人
						TaskMonitor tm = new TaskMonitor();
						// 设置service
						tm.service = this.tasklogService;
						// 设置 日志
						tm.log = vo;
						// 创建线程
						Thread t = new Thread(tm);
						// 启动线程
						t.start();
					}
				}
			} catch (Exception e) {
				//异常处理
				this.logger.info("点击新增任务提交 出现异常！", e);
				// 保存日志失败 返回前端为""
//				writeToPage(response, "");
			} finally {
				//数据监控
				MonitorUtil monitorUtil = new MonitorUtil();
				monitorUtil.dateMonitor(this.userId, "13", null, dppmMonitorService);
			}
		}
		writeToPage(response, resinfo);
	}
	/**
	 *  获得我的任务 
	 *  包括 未完成进度<100 还有待审核的
	 */
	public void queryMytask() {
		//获取返回
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			//日志打印
			this.logger.info("点击我的待办任务  userid is :" + this.userId);
			// 根据当前用户 获得我的代办任务
			String info = this.tasklogService.queryMytask(this.userId);
			// 我的任务返回前端
			writeToPage(response, info);
			this.logger.info("点击我的待办任务  返回信息 :" + info);
		} catch (Exception e) {
			//异常处理
			this.logger.info("点击我的待办任务 出现异常！", e);
			writeToPage(response, "");
		} 
	}

	/**
	 * @param tasklogService
	 */
	public void setTasklogService(ITaskLogService tasklogService) {
		this.tasklogService = tasklogService;
	}

	/**
	 * @param taskid
	 */
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}

	/**
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
