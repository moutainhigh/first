package com.deppon.dpm.module.common.server.service.impl;

import java.util.List;

import com.deppon.dpm.module.common.server.dao.ISmsDao;
import com.deppon.dpm.module.common.server.service.ISmsService;
import com.deppon.dpm.module.common.shared.domain.SmsEntity;

/**
 * 短信开关
 *
 */
public class SmsService implements ISmsService{

	// 注入
	private ISmsDao smsDao;

	// 根据工号查询
	public List<SmsEntity> queryByEmpcode(String userId) {
		return smsDao.queryByEmpcode(userId);
	}
	
	// 删除
	public void delete(int id) {
		smsDao.delete(id);
	}
	
	// 更新
	public void update(SmsEntity entity) {
		smsDao.update(entity);
	}
	
	// 新增
	public void insert(SmsEntity entity) {
		smsDao.insert(entity);
	}
	
	// setter
	public void setSmsDao(ISmsDao smsDao) {
		this.smsDao = smsDao;
	}
}
