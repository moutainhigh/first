package com.deppon.dpm.module.announce.server.dao;

import java.util.List;

import com.deppon.dpm.module.announce.shared.domain.NormalQuestionEntity;

/**
 * 常见问题dao层
 * 
 * @author 231586
 * 
 */
public interface INormalQuestionDao {
	/**
	 * 常见问题获取
	 * 
	 * @return
	 */
	public List<NormalQuestionEntity> getNormalQuestion();
}
