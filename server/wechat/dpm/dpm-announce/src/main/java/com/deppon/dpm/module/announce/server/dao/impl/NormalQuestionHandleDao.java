package com.deppon.dpm.module.announce.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.announce.server.dao.INormalQuestionHandleDao;
import com.deppon.dpm.module.announce.shared.domain.NormalQuestionHandleEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 常见问题处理人Dao层实现
 * @author 276344
 *
 */
public class NormalQuestionHandleDao extends iBatis3DaoImpl implements
		INormalQuestionHandleDao {
	/**
	 * namespace
	 */
	private static final String NAME_SPACE = "com.deppon.dpm.module.announce.shared.domain.AnnounceEntity.";
	@Override
	@SuppressWarnings("unchecked")
	public List<NormalQuestionHandleEntity> getNormalQuestionHandle() {
		//常见问题处理人数据获取
		return getSqlSession().selectList(NAME_SPACE + "getNormalQuestionHandle");
	};

}
