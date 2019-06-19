package com.deppon.dpm.module.announce.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.announce.server.dao.INormalQuestionDao;
import com.deppon.dpm.module.announce.shared.domain.NormalQuestionEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 常见问题dao层实现
 * 
 * @author 231586
 * 
 */
public class NormalQuestionDao extends iBatis3DaoImpl implements INormalQuestionDao {
	/**
	 * namespace
	 */
	private static final String NAME_SPACE = "com.deppon.dpm.module.announce.shared.domain.AnnounceEntity.";

	/**
	 * 获取常见问题
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<NormalQuestionEntity> getNormalQuestion() {
		// 常见问题获取
		return getSqlSession().selectList(NAME_SPACE + "getNormalQuestion");
	}

}
