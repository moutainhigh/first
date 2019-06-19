package com.deppon.dpm.store.server.action;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.store.server.service.ITaskManageService;
import com.deppon.dpm.store.server.util.ResultData;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

public class TaskManageAction extends BaseAction{

	
	private static final long serialVersionUID = 5377266740686351080L;
	
	//主任务id
	private String taskId;
	
	//注入service
	private ITaskManageService taskManageService;
	
	//日志
	private static final Logger logger = LoggerFactory.getLogger(TaskManageAction.class);

	/**
	 * 删除任务(修改状态)
	 * @author lvdefu
	 * @date   2018年8月3日16:04:08
	 * @param  taskId
	 * @return null
	 */
	@SuppressWarnings("all")
	//@CookieNotCheckedRequired
	public void deleteTaskByTaskId(){
		try {
			logger.info("(删除任务)修改任务状态开始------------");
			if(StringUtils.isNotEmpty(taskId.trim())){
				//查询主任务下所有子任务状态,只有子任务全部为待考评的任务才能删除
				boolean state=taskManageService.querySubTaskState(taskId);
				//返回为true的时候可以修改 主任务和子任务状态
				if(state){ 
					taskManageService.deleteTaskByTaskId(taskId);
					JSONObject json = ResultData.success("删除成功");
					writeToPage(json);
				}else{
					logger.info("修改失败,子任务已经有完成的------------");
					JSONObject json=ResultData.error("修改失败,子任务已经有完成的");
					writeToPage(json);
				}
			}else{
				logger.info("(删除任务)修改任务状态失败------------");
				JSONObject json = ResultData.error("主任务Id不能为空");
			}
		} catch (Exception e) {
			logger.info("(删除任务)修改任务状态时异常");
			JSONObject json=ResultData.error("修改任务状态时异常");
			writeToPage(json);
		}
	}
	
	
	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}


	public ITaskManageService getTaskManageService() {
		return taskManageService;
	}


	public void setTaskManageService(ITaskManageService taskManageService) {
		this.taskManageService = taskManageService;
	}
	

}
