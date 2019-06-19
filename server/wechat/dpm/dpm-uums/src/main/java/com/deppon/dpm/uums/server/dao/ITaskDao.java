/*package com.deppon.dpm.uums.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.uums.server.domain.Task;

*//**
 * 我的任务
 * 
 * @author 245968
 * 
 *//*
public interface ITaskDao {

	*//**
	 * 新建任务
	 *//*
	public void insert(Task task);

	*//**
	 * 编辑或任务转发
	 *//*
	public void update(Task task);

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
	public List<Task> getTasks(Map<String, Object> map);

	public int selectTasksCount(Map<String, Object> map);

	*//**
	 * 任务完成
	 *//*
	public void updateByMapFinish(Map<String, Object> map);

	*//**
	 * 任务转发
	 *//*
	public void updateByMapDispatcher(Map<String, Object> map);

	*//**
	 * 任务重启
	 *//*
	public void updateByMapRestart(Task task);

	*//**
	 * 清空任务
	 *//*
	public void clear(Map<String, Object> map);
}
*/