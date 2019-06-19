package com.deppon.dpm.module.announce.server.dao;

import java.util.List;

import com.deppon.dpm.module.announce.shared.domain.NormalQuestionEntity;
import com.deppon.dpm.module.announce.shared.domain.NormalQuestionHandleEntity;

/**
 * 常见问题处理人dao层
 * @author 276344
 *
 */
public interface INormalQuestionHandleDao {
	/**
	 * 常见问题处理人获取数据
	 * @return
	 */
	public List<NormalQuestionHandleEntity> getNormalQuestionHandle();
}
