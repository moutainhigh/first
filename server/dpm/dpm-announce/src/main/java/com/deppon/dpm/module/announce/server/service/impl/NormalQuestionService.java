package com.deppon.dpm.module.announce.server.service.impl;

import java.util.List;

import com.deppon.dpm.module.announce.server.dao.INormalQuestionDao;
import com.deppon.dpm.module.announce.server.service.INormalQuestionService;
import com.deppon.dpm.module.announce.shared.domain.NormalQuestionEntity;

/**
 * 常见问题service实现层
 * 
 * @author 231586
 * 
 */
public class NormalQuestionService implements INormalQuestionService {
	/**
	 * set injection
	 */
	private INormalQuestionDao normalQuestionDao;

	/**
	 * 常见问题获取
	 */
	@Override
	public List<NormalQuestionEntity> getNormalQuestion() {
		// 常见问题获取
		return normalQuestionDao.getNormalQuestion();
	}

	/**
	 * set
	 * 
	 * @param normalQuestionDao
	 */
	public void setNormalQuestionDao(INormalQuestionDao normalQuestionDao) {
		this.normalQuestionDao = normalQuestionDao;
	}
}