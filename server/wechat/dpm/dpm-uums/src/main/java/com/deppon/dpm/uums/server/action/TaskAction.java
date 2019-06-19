/*package com.deppon.dpm.uums.server.action;

import java.util.List;

import com.deppon.dpm.tongxunlu.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.shared.vo.Result;
import com.deppon.dpm.uums.server.domain.Task;
import com.deppon.dpm.uums.server.service.ITaskService;

*//**
 * 我的任务
 * 
 * @author 245968
 * 
 *//*
public class TaskAction extends BaseAction {

	private static final long serialVersionUID = -7828466495747369700L;

	private int id;
	private Task task;
	private ITaskService taskService;
	private int type;// 列表类型,0 待我执行未完成，1 待我执行已完成, 2我的指派未完成，3我的指派已完成
	private String savePath;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public ITaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(ITaskService taskService) {
		this.taskService = taskService;
	}

	----------------------action方法-------------------------------
	public void insert() {
		taskService.insert(task, userId, savePath);
		Result<Object> result = new Result<Object>();
		result.setData("新增任务");
		writeToPage(result);
	}

	public void select() {
		writeToPage(taskService.getTaskById(id));
	}

	public void delete() {
		taskService.delete(id);
		Result<Object> result = new Result<Object>();
		result.setData("删除任务");
		writeToPage(result);
	}

	public void update() {
		taskService.update(task, savePath);
		Result<Object> result = new Result<Object>();
		result.setData("更新任务");
		writeToPage(result);
	}

	public void getTasks() {
		Result<Object> result = new Result<Object>();
		List<Task> tasks = taskService.getTasks(type, userId);
		int count = taskService.selectTasksCount(type, userId);
		result.setData(tasks);
		result.setCount(count);
		writeToPage(result);
	}

	*//**
	 * 清空任务
	 *//*
	public void clear() {
		taskService.clear(type, userId);
		Result<Object> result = new Result<Object>();
		result.setData("清空任务");
		writeToPage(result);
	}

	*//**
	 * 任务转发
	 *//*
	public void dispatcher() {
		taskService.updateByMapDispatcher(task, userId);
		Result<Object> result = new Result<Object>();
		result.setData("转发任务");
		writeToPage(result);
	}

	*//**
	 * 任务完成
	 *//*
	public void finish() {
		taskService.updateByMapFinish(id, userId);
		Result<Object> result = new Result<Object>();
		result.setData("完成任务");
		writeToPage(result);
	}

	*//**
	 * 任务重启
	 *//*
	public void restart() {
		taskService.updateByMapRestart(task, userId, savePath);
		Result<Object> result = new Result<Object>();
		result.setData("重启任务");
		writeToPage(result);
	}

}
*/