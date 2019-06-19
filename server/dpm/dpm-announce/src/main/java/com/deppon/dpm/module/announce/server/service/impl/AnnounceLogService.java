package com.deppon.dpm.module.announce.server.service.impl;

import com.deppon.dpm.module.announce.server.dao.IAnnounceLogDao;
import com.deppon.dpm.module.announce.server.service.IAnnounceLogService;
import com.deppon.dpm.module.announce.shared.domain.AnnounceLogEntity;

/**
 * 
 * @ClassName: AnnounceService
 * @Description: 公告管理Service实现类
 * @author 045925/YANGBIN
 * @date 2015-3-18 下午3:32:20
 * 
 */
public class AnnounceLogService implements IAnnounceLogService {
	private IAnnounceLogDao announceLogDao;

	/**
	 * 
	 * @Title: insert
	 * @Description: 插入公告
	 * @param @param entity
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	@Override
	public int insert(AnnounceLogEntity entity) {
		// 日志插入
		return announceLogDao.insert(entity);
	}

	/**
	 * set
	 * 
	 * @param announceLogDao
	 */
	public void setAnnounceLogDao(IAnnounceLogDao announceLogDao) {
		this.announceLogDao = announceLogDao;
	}

}
