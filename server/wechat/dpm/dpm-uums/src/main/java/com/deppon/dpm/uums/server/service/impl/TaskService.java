/*package com.deppon.dpm.uums.server.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.deppon.dpm.module.common.server.util.UploadUtil;
import com.deppon.dpm.module.news.server.service.ITpushNewsService;
import com.deppon.dpm.module.news.shared.domain.NewsCenterEntity;
import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;
import com.deppon.dpm.uums.server.dao.ITaskDao;
import com.deppon.dpm.uums.server.domain.Task;
import com.deppon.dpm.uums.server.service.ITaskService;
import com.deppon.foss.framework.server.context.UserContext;

public class TaskService implements ITaskService {

	private ITaskDao taskDao;

	*//**
	 * 推送服务
	 *//*
	private ITpushNewsService pushService;

	public ITaskDao getTaskDao() {
		return taskDao;
	}

	public void setTaskDao(ITaskDao taskDao) {
		this.taskDao = taskDao;
	}

	public ITpushNewsService getPushService() {
		return pushService;
	}

	public void setPushService(ITpushNewsService pushService) {
		this.pushService = pushService;
	}

	// -----------------------业务逻辑--------------------------
	@Override
	public void insert(Task task, String userId, String savePath) {
		userId = getCurrentUserId(userId);
		task.setCreateUserId(userId);
		task.setCurrentUserId(task.getOriginUserId());
		uploadFiles(task, savePath);
		taskDao.insert(task);
		pushMessage("新增任务", userId, task);
	}

	@Override
	public void update(Task task, String savePath) {
		uploadFiles(task, savePath);
		taskDao.update(task);
		pushMessage("更新任务", task.getCurrentUserId(), task);
	}

	@Override
	public void delete(int id) {
		taskDao.delete(id);
	}

	@Override
	public Task getTaskById(int id) {
		return taskDao.getTaskById(id);
	}

	@Override
	public List<Task> getTasks(int type, String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("empcode", getCurrentUserId(userId));
		return taskDao.getTasks(map);
	}

	@Override
	public int selectTasksCount(int type, String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("empcode", getCurrentUserId(userId));
		return taskDao.selectTasksCount(map);
	}

	@Override
	public void updateByMapFinish(int id, String userId) {
		Task task = getTaskById(id);
		if (!getCurrentUserId(userId).equals(task.getOriginUserId())) {
			throw new RuntimeException("第一指派人才可点击完成任务");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		taskDao.updateByMapFinish(map);
		pushMessage("完成任务", task.getCurrentUserId(), task);
	}

	@Override
	public void updateByMapDispatcher(Task task, String userId) {
		Task old = getTaskById(task.getId());
		if (!old.getOriginUserId().equals(getCurrentUserId(userId))) {
			throw new RuntimeException("第一指派人才可点击转发任务");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", task.getId());
		map.put("secondUserId", task.getSecondUserId());
		taskDao.updateByMapDispatcher(map);
		pushMessage("转发任务", task.getCurrentUserId(), task);
	}

	@Override
	public void updateByMapRestart(Task task, String userId, String savePath) {
		Task old = getTaskById(task.getId());
		if (!getCurrentUserId(userId).equals(old.getCreateUserId())) {
			throw new RuntimeException("任务创建人才可重启任务");
		}
		uploadFiles(task, savePath);
		taskDao.updateByMapRestart(task);
		pushMessage("重启任务", task.getCurrentUserId(), task);
	}

	@Override
	public void clear(int type, String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("userId", getCurrentUserId(userId));
		taskDao.clear(map);
	}

	private String getCurrentUserId(String userId) {
		if (userId == null) {
			UserEntity user = (UserEntity) UserContext.getCurrentUser();
			if (user != null) {
				userId = user.getEmpCode();
			}
		}
		return userId;
	}

	private String getSavePath(String savePath) {
		if (savePath == null) {
			savePath = ServletActionContext.getServletContext().getRealPath(
					"/task");
		}
		return savePath;
	}

	private void uploadFiles(Task task, String savePath) {
		savePath = getSavePath(savePath);
		try {
			List<String> uploadImage = UploadUtil.uploadFiles(task.getFiles(),
					savePath, task.getFilesFileName());
			if (uploadImage != null && uploadImage.size() > 0) {
				String path = uploadImage.toString().substring(1,
						uploadImage.toString().length() - 1);
				task.setPath(path);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	*//**
	 * 推送消息
	 *//*
	private void pushMessage(String content, String userId, Task task) {
		NewsCenterEntity entity = new NewsCenterEntity(String.valueOf(task
				.getId()), 5, 0, 1, "我的任务");
		pushService.pushUserNews(task.getCurrentUserId(), task.getTitle(),
				task.getContent(), entity);
	}

}
*/