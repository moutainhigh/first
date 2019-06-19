package com.deppon.dpm.module.wfs.server.service.impl;

import java.util.List;

import com.deppon.dpm.module.wfs.server.dao.INwfsPicpathDao;
import com.deppon.dpm.module.wfs.server.service.INwfsPicpathService;
import com.deppon.dpm.module.wfs.shared.domain.NwfsPicPathEntity;

public class NwfsPicpathService implements INwfsPicpathService {
	private INwfsPicpathDao picDao; 
	/**
	 * 根据工号数组查询头像地址
	 * @param userIds
	 * @return
	 */
	@Override
	public List<NwfsPicPathEntity> picturePaths(List<String> userIds) {
		return picDao.picturePaths(userIds);
	}
	
	/**
	 * set
	 * @param picDao
	 */
	public void setPicDao(INwfsPicpathDao picDao) {
		this.picDao = picDao;
	}
}
