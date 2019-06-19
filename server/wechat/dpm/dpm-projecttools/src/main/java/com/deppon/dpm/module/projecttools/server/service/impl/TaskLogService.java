package com.deppon.dpm.module.projecttools.server.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.projecttools.server.dao.ITaskLogDao;
import com.deppon.dpm.module.projecttools.server.service.ITaskLogService;
import com.deppon.dpm.module.projecttools.server.util.MailUtil;
import com.deppon.dpm.module.projecttools.shared.domain.TaskLogEntity;
import com.deppon.dpm.module.projecttools.shared.domain.TasksEntity;
/**
 * 任务管理 任务详情======任务日志跟踪和任务详细信息查询 service
 * @author gcl
 */
public class TaskLogService implements ITaskLogService {
	private static Logger logger = LoggerFactory.getLogger(TaskLogService.class);
	private ITaskLogDao dao;
	//邮件发送方 邮局小天使
	private String emailFrom;
	//邮件服务器 公司邮箱地址
	private String emailHost;
	//邮件 用户名
	private String emailUsername;
	//密码
	private String emailPassword;
	
	/**
	 * 任务详情信息查询
	 * @return
	 * @throws Exception
	 */
	public String queryLog(int taskid) throws Exception {
		Map<String, Object> map = this.dao.queryLog(taskid);
		return JSON.toJSONString(map);
	}
	/**
	 * 新增任务跟踪日志
	 * @param e 日志实体
	 * @return 是否保存成功
	 */
	public int addtasklog(TaskLogEntity e){
		return this.dao.addtasklog(e);
	}
	/**
	 * 我的待办任务
	 * @param userId 用户工号
	 * @return
	 */
	public String queryMytask(String userId){
		return this.dao.queryMytask(userId);
	}
	/**
	 * 邮件 提醒    新增任务跟踪日志后发送给提醒人
	 * @param log
	 */
	public void mailSend(TaskLogEntity log) {
		String email = log.getEmail();
		if(email != null) {
			//
			String[] sm = email.split(";");
			//定义接收人数组
			String[] toEmail = new String[sm.length];
			logger.info("跟踪日志提交邮件提醒 person --" + email);
			for(int i = 0 ; i < sm.length ; i++) {
				if(sm[i].split("\\|").length >= 3) {
					toEmail[i] = sm[i].split("\\|")[2];
				}
			}
			//获得任务对应的项目信息
			TasksEntity task = this.dao.queryTaskById(log.getTaskId());
			//设置邮件主题
			String title = "[" + task.getTaskProjectName() == null ? "" : task.getTaskProjectName() + "]" + task.getTaskName() + "进度更新为" + log.getPercentComplete();
			//邮件内容
			StringBuffer info = new StringBuffer();
			info.append("项目名称：" + task.getTaskProjectName() + "<br>任务名称：" + task.getTaskName() + "<br>");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			info.append("计划开始时间：" + sdf.format(task.getTaskStartTime()) + "<br>计划结束时间：" + sdf.format(task.getTaskEndTime()) + "<br>");
			//计划进度
			// (当前时间-计划开始时间/计划结束时间-计划开始时间)*100
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			Date date2 = new Date();
			long nowtime = System.currentTimeMillis();
			String start = sdf.format(task.getTaskStartTime()) + " 00:00:01";
			String end = sdf.format(task.getTaskEndTime()) + " 23:59:59";
			try {
			    date = format.parse(start);
			    date2 = format.parse(end);
			}catch(Exception e){
				e.printStackTrace();
			}
			long starttime = date.getTime();
			long endtime = date2.getTime();
			if(nowtime > endtime){
				nowtime = endtime;
			}
			BigDecimal ddd = new BigDecimal(nowtime-starttime);
			BigDecimal ddd2 = new BigDecimal(endtime-starttime);
			info.append("已工作小时数：" + log.getWorkedHour() + "<br>计划进度：" + ddd.divide(ddd2,2,BigDecimal.
					ROUND_HALF_UP).doubleValue() * 100 + "%<br>实际进度：" + log.getPercentComplete()+"%<br>");
			info.append("任务描述：" + log.getDesc());
			info.append("<br>任务处理者：" + task.getTaskProcesserName() + "<br>任务分配者：" + task.getTaskOwerName());
			
			// 邮件提醒
			MailUtil.sendMail(toEmail,
					title, info.toString(), this.emailHost, this.emailFrom, this.emailUsername,
					this.emailPassword);
		}
	}
	/**
	 * 邮件 提醒    新增任务时分配任务给任务处理人发送给处理人
	 * @param task
	 */
	public void mailSendTask(TasksEntity task) {
		//处理人
		String email = task.getTaskProcesserEmail();
		logger.info("新增任务时分配任务给任务处理人--发送给处理人邮箱:" + email);
		if(email != null) {
			//定义接收人数组
			String[] toEmail = new String[1];
			toEmail[0] = email;
			logger.info("任务分配发送邮件提醒 person --" + email);
			//设置邮件主题
			String title = "[" + task.getTaskProjectName() == null ? "" :task.getTaskProjectName() + "]" + task.getTaskName() + "  已添加";
			//邮件内容
			StringBuffer info = new StringBuffer();
			//项目类任务时 添加项目类型等的提醒
			if(task.getTaskCategoryId() == 1) {
				info.append("项目类型：" + task.getTaskProjectType() + "<br>");
				info.append("项目：" + task.getTaskProjectName() + "<br>");
			}
			info.append("任务名称：" + task.getTaskName() + "<br>");
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			info.append("计划开始时间：" + task.getTaskstartTime() + "<br>计划结束时间：" + task.getTaskendTime() + "<br>");
			
			info.append("连接地址：<br>");
			info.append("任务描述：" + task.getTaskDesc());
			info.append("<br>任务分配者：" + task.getTaskOwerName());
			
			// 邮件提醒
			MailUtil.sendMail(toEmail,
					title, info.toString(), this.emailHost, this.emailFrom, this.emailUsername,
					this.emailPassword);
		}
	}
	/**
	 * 项目变更
	 * 审批同意后 变更内容为里程碑、关键节点或结项时间系统自动发邮件至项目组织中所有的执行个人
	 * @param toEmail
	 * @param title
	 * @param info
	 */
	public void mailToExecutor(String[] toEmail,String title,String info) {
		// 邮件提醒
		MailUtil.sendMail(toEmail,
				title, info.toString(), this.emailHost, this.emailFrom, this.emailUsername,
				this.emailPassword);
	}
	/**
	 * @param dao
	 */
	public void setDao(ITaskLogDao dao) {
		this.dao = dao;
	}
	/**
	 * @param emailFrom
	 */
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	/**
	 * @param emailHost
	 */
	public void setEmailHost(String emailHost) {
		this.emailHost = emailHost;
	}
	/**
	 * @param emailUsername
	 */
	public void setEmailUsername(String emailUsername) {
		this.emailUsername = emailUsername;
	}
	/**
	 * @param emailPassword
	 */
	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}
	
}
