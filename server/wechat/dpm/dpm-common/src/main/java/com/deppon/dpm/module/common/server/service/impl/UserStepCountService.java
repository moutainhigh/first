package com.deppon.dpm.module.common.server.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.deppon.dpm.module.common.server.dao.IUserStepCountDao;
import com.deppon.dpm.module.common.server.service.IUserStepCountService;
import com.deppon.dpm.module.common.shared.domain.UserStepCountEntity;

public class UserStepCountService implements IUserStepCountService{
	
	private IUserStepCountDao userStepCountDao;
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 保存或更新
	 * @throws ParseException 
	 */
	@Override
	public void saveOrUpdate(UserStepCountEntity entity) throws ParseException {
		if(entity.getStepCount() == 0) {
			return;
		}
		entity.setDayTime(DATE_FORMAT.parse(DATE_FORMAT.format(new Date())));
		UserStepCountEntity userStepCount = userStepCountDao.queryByUserIdAndDayTime(entity);
		if(null == userStepCount) {
			// 保存
			userStepCountDao.save(entity);
		} else {
			entity.setId(userStepCount.getId());
			// 更新
			userStepCountDao.update(entity);
		}
	}

	public void setUserStepCountDao(IUserStepCountDao userStepCountDao) {
		this.userStepCountDao = userStepCountDao;
	}
	
}
