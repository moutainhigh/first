package com.deppon.dpm.module.projecttools.server.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.projecttools.server.service.IDppmMonitorService;
import com.deppon.dpm.module.projecttools.server.service.IDppmTaskService;
import com.deppon.dpm.module.projecttools.server.service.ITaskLogService;
import com.deppon.dpm.module.projecttools.server.util.TaskMonitor;
import com.deppon.dpm.module.projecttools.server.util.com.deppon.dpm.module.wfs.server.util.monitor.MonitorUtil;
import com.deppon.dpm.module.projecttools.shared.domain.TasksEntity;
import com.deppon.foss.framework.shared.util.string.StringUtil;

public class DppmTaskAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 4705675101897434047L;
	private IDppmMonitorService dppmMonitorService;
	public void setDppmMonitorService(IDppmMonitorService dppmMonitorService) {
		this.dppmMonitorService = dppmMonitorService;
	}
	/*** service*/
	private ITaskLogService tasklogService;
    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(DppmTaskAction.class);
    /**
     * 查询的工号
     */
    String emCode;
    /**
     * 任务ID
     */
    String taskId;
    
    IDppmTaskService dppmTaskService;
    /**
     * 查询任务列表
     */
    public void taskList(){
        HttpServletResponse response = ServletActionContext.getResponse();
        Map<String,Object> retMapInfo = null;
        //查询有List
        try{
        	//打印日志
            logger.info("务列表查询参数==> emCode: " + emCode);
            //参数不为空时调用service
            if(!StringUtil.isEmpty(this.emCode)){
                retMapInfo = dppmTaskService.taskList(emCode);
            }else{
                retMapInfo = new HashMap<String, Object>();
            }
        }catch(Exception e){
        	//异常处理
            logger.info("查询任务列表出现异常",e);
        } finally {
			//数据监控
        	//数据监控
			MonitorUtil monitorUtil = new MonitorUtil();
			monitorUtil.dateMonitor(this.userId, "11", null, dppmMonitorService);
		}
        
        //返回页面
        response.setHeader("Access-Control-Allow-Origin", "*");
        writeToPage(response, JsonUtil.beanToJsonString(retMapInfo));
    }
    
    /**
     * 根据任务Id查询子任务
     */
    public void subTaskList(){
        HttpServletResponse response = ServletActionContext.getResponse();
        List<JSONObject> list = null;
        try{
        	//日志打印
            logger.info("查询参数 taskId: " + taskId);
            //参数不为空调用service
            if(!StringUtil.isEmpty(this.taskId)){
                list = dppmTaskService.getSubTaskList(this.taskId);
            }else{
                list = new ArrayList<JSONObject>();
            }
        }catch(Exception e){
        	//异常处理
            logger.info("查询子任务出现异常",e);
        }
        
        //返回页面
        response.setHeader("Access-Control-Allow-Origin", "*");
        writeToPage(response, JsonUtil.beanToJsonString(list));
    }
    
    /**
     * 我的任务
     */
    public void myTaskList(){
        HttpServletResponse response = ServletActionContext.getResponse();
        List<JSONObject> list = null;
        try{
            logger.info("我的任务查询参数 emCode: " + emCode);
            //参数不为空调用service
            if(!StringUtil.isEmpty(emCode)){
                list = dppmTaskService.myTask(emCode);
            }else{
            //为空new一个实体类
                list = new ArrayList<JSONObject>();
            }
        }catch(Exception e){
        	//异常处理
            logger.info("查询我的任务出现异常",e);
        } finally {
			//数据监控
			MonitorUtil monitorUtil = new MonitorUtil();
			monitorUtil.dateMonitor(this.userId, "12", null, dppmMonitorService);
		}
        
        //返回页面
        response.setHeader("Access-Control-Allow-Origin", "*");
        writeToPage(response, JsonUtil.beanToJsonString(list));
    }
    
    /**
     * 任务新建 保存任务信息
     * @author 高春玲
     * @date 2015-10-21
     */
    public void addTask(){
    	HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
	    //初始化json 界面返回值  -1：问题风险任务，工时查过挂靠项目的总工时
		String json = "";
		// post提交时 执行审批
		if("POST".equals(request.getMethod())) {
			TasksEntity entity = null;
			try {
				// 获得前端封装的json数据
				String str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(request.getReader());
				this.logger.info("任务新建 前端参数 param: " + str);
				// 转换为任务实体
				entity = JSONObject.parseObject(str,
			    		TasksEntity.class);
				// 执行保存获得保存信息
				json = this.dppmTaskService.addTask(entity) + "";
				this.logger.info("任务新建 保存返回结果 result：" + json);
				if(Integer.parseInt(json) > 0 && "2".equals(entity.getTaskStatus())) {
					//新增日志成功 异步调用发送邮件到提醒人
					TaskMonitor tm = new TaskMonitor();
					// 设置service
					tm.service = this.tasklogService;
					// 设置 任务实体
					tm.task = entity;
					// 创建线程
					Thread t = new Thread(tm);
					// 启动线程
					t.start();
				}
				//保存成功后 如果为任务分配 进行邮件发送
			} catch (Exception e) {
				e.printStackTrace();
				// 失败 返回 0 
				json = "0";
			} finally {
				//任务为分配时 进行数据监控
				if(entity != null && "2".equals(entity.getTaskStatus())) {
					//数据监控
					MonitorUtil monitorUtil = new MonitorUtil();
					monitorUtil.dateMonitor(this.userId, "16", null, dppmMonitorService);
				}
			}
		}
		writeToPage(response, json);
    }

    /**
     * 任务修改 更新任务信息
     * @author 高春玲
     * @date 2015-11-13
     */
    public void updateTask() {
    	HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
	    //初始化json 界面返回值
		String json = "";
		// post提交时 执行审批
		if("POST".equals(request.getMethod())) {
			TasksEntity entity = null;
			try {
				// 获得前端封装的json数据
				String str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(request.getReader());
				this.logger.info("任务修改 前端参数 param: " + str);
				// 转换为任务实体
				entity = JSONObject.parseObject(str,
			    		TasksEntity.class);
				// 执行保存获得保存信息
				json = this.dppmTaskService.updateTask(entity) + "";
				this.logger.info("任务修改 保存返回结果 result：" + json);
				if(Integer.parseInt(json) > 0 && "2".equals(entity.getTaskStatus())) {
					//新增日志成功 异步调用发送邮件到提醒人
					TaskMonitor tm = new TaskMonitor();
					// 设置service
					tm.service = this.tasklogService;
					// 设置 任务实体
					tm.task = entity;
					// 创建线程
					Thread t = new Thread(tm);
					// 启动线程
					t.start();
				}
				//保存成功后 如果为任务分配 进行邮件发送
			} catch (Exception e) {
				e.printStackTrace();
				// 失败 返回 0 
				json = "0";
			} /*finally {
				//任务为分配时 进行数据监控
				if(entity != null && "2".equals(entity.getTaskStatus())) {
					//数据监控
					MonitorUtil monitorUtil = new MonitorUtil();
					monitorUtil.dateMonitor(this.userId, "16", null, dppmMonitorService);
				}
			}*/
		}
		writeToPage(response, json);
    }
    /**
     * 任务删除
     * @author 高春玲
     * @date 2015-11-13
     */
    public void delTask() {
    	//日志打印
    	this.logger.info("删除任务  param is : " + userId + "----" + taskId);
    	//获取返回
    	HttpServletResponse response = ServletActionContext.getResponse();
    	//resInfo返回信息
    	String resInfo = "";
    	try {
    		resInfo = this.dppmTaskService.delTask(taskId) + "";
    		this.logger.info("删除任务 result is :---------" + resInfo);
    	} catch (Exception e) {
    		this.logger.info("删除任务出现异常！",e);
    		resInfo = "0";
    	}
    	//返回页面
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	writeToPage(response, resInfo);
    }
    /**
     * 任务终止
     * @author 高春玲
     * @date 2015-11-16
     */
    public void stopTask() {
    	//日志打印
    	this.logger.info("终止任务  param is : " + userId + "----" + taskId);
    	//获取返回
    	HttpServletResponse response = ServletActionContext.getResponse();
    	//resInfo返回信息
    	String resInfo = "";
    	try {
    		resInfo = this.dppmTaskService.stopTask(taskId) + "";
    		this.logger.info("终止任务 result is :---------" + resInfo);
    	} catch (Exception e) {
    		this.logger.info("终止任务出现异常！",e);
    		resInfo = "0";
    	}
    	//返回页面
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	writeToPage(response, resInfo);
    }
    
    /**
	 * 暂存查询
	 * */
	public void queryTask(){
		//日志打印
		logger.info("暂存查询  param is : " + userId+"----"+taskId);
		//获取返回
		HttpServletResponse response = ServletActionContext.getResponse();
		//resInfo返回信息
		String resInfo = "";
		try {
//			Map<String, Object> ret=dppmTaskService.queryTask(taskId);
//			resInfo = JsonUtil.mapToJsonString(ret);
			resInfo=dppmTaskService.queryTask(taskId);
			logger.info("json is ;---------"+resInfo);
		} catch (Exception e) {
			logger.info("暂存查询出现异常！",e);
			resInfo = "[]";
		}
	/*	finally {
			//数据监控
			MonitorUtil monitorUtil = new MonitorUtil();
			monitorUtil.dateMonitor(this.userId, "16", null, dppmMonitorService);
		}*/
		//返回页面
		response.setHeader("Access-Control-Allow-Origin", "*");
		writeToPage(response, resInfo);
	}
    
    
    
	/**
	 * @param emCode the emCode to set
	 */
	public void setEmCode(String emCode) {
		this.emCode = emCode;
	}

	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	/**
	 * @param dppmTaskService the dppmTaskService to set
	 */
	public void setDppmTaskService(IDppmTaskService dppmTaskService) {
		this.dppmTaskService = dppmTaskService;
	}

	/**
	 * @param tasklogService
	 */
	public void setTasklogService(ITaskLogService tasklogService) {
		this.tasklogService = tasklogService;
	}
	
}
