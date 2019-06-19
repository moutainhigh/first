package com.deppon.dpm.module.announce.server.service;

import java.util.List;

import com.deppon.dpm.module.announce.shared.domain.NormalQuestionHandleEntity;
import com.deppon.foss.framework.service.IService;

/**
 * 常见问题处理人接口
 * @author 276344
 *
 */
public interface INormalQuestionHandleService extends IService {
	// 获取常见问题处理人
	public List<NormalQuestionHandleEntity> getNormalQuestionHandle();
}
