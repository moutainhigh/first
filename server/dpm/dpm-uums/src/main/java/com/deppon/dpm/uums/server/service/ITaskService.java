/*package com.deppon.dpm.uums.server.service;

import java.util.List;

import com.deppon.dpm.uums.server.domain.Task;

public interface ITaskService {

	*//**
	 * 新建任务
	 *//*
	public void insert(Task task, String userId, String savePath);

	*//**
	 * 编辑或任务转发
	 *//*
	public void update(Task task, String savePath);

	*//**
	 * 删除任务
	 *//*
	public void delete(int id);

	*//**
	 * 根据id返回任务
	 *//*
	public Task getTaskById(int id);

	*//**
	 * 分页返回列表，待我执行（待我执行未完成，待我执行已完成 ，我的指派未完成，我的指派已完成）
	 *//*
	public List<Task> getTasks(int type, String userId);

	public int selectTasksCount(int type, String userId);

	*//**
	 * 任务完成
	 *//*
	public void updateByMapFinish(int id, String userId);

	*//**
	 * 任务转发
	 *//*
	public void updateByMapDispatcher(Task task, String userId);

	*//**
	 * 任务重启
	 *//*
	public void updateByMapRestart(Task task, String userId, String savePath);

	*//**
	 * 清空任务
	 *//*
	public void clear(int type, String userId);
}
*/