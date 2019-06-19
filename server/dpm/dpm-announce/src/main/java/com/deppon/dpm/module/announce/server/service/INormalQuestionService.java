package com.deppon.dpm.module.announce.server.service;

import java.util.List;

import com.deppon.dpm.module.announce.shared.domain.NormalQuestionEntity;
import com.deppon.foss.framework.service.IService;

/**
 * 常用问题接口
 * 
 * @author 231586
 * 
 */
public interface INormalQuestionService extends IService {
	// 获取常见问题
	public List<NormalQuestionEntity> getNormalQuestion();
}