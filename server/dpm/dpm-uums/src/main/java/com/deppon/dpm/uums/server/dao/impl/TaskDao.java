/*package com.deppon.dpm.uums.server.dao.impl;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.uums.server.dao.ITaskDao;
import com.deppon.dpm.uums.server.domain.Task;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class TaskDao extends iBatis3DaoImpl implements ITaskDao {

	private String NAMESPACE = "com.deppon.dpm.uums.server.dao.taskEntityMapper.";

	@Override
	public void insert(Task task) {
		getSqlSession().insert(NAMESPACE + "insert", task);
	}

	@Override
	public void update(Task task) {
		getSqlSession().update(NAMESPACE + "update", task);
	}

	@Override
	public void delete(int id) {
		getSqlSession().delete(NAMESPACE + "delete", id);
	}

	@Override
	public Task getTaskById(int id) {
		return (Task) getSqlSession().selectOne(NAMESPACE + "selectById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> getTasks(Map<String, Object> map) {
		return getSqlSession().selectList(NAMESPACE + "selectByMap", map);
	}

	@Override
	public int selectTasksCount(Map<String, Object> map) {
		return (Integer) getSqlSession().selectOne(
				NAMESPACE + "selectByMapCount", map);
	}

	@Override
	public void updateByMapFinish(Map<String, Object> map) {
		getSqlSession().selectList(NAMESPACE + "updateByMapFinish", map);
	}

	@Override
	public void updateByMapDispatcher(Map<String, Object> map) {
		getSqlSession().selectList(NAMESPACE + "updateByMapDispatcher", map);
	}

	@Override
	public void updateByMapRestart(Task task) {
		getSqlSession().selectList(NAMESPACE + "updateByMapRestart", task);
	}

	@Override
	public void clear(Map<String, Object> map) {
		getSqlSession().delete(NAMESPACE + "clear", map);
	}

}
*/