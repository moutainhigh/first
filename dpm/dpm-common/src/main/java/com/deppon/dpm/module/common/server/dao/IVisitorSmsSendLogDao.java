package com.deppon.dpm.module.common.server.dao;

import com.deppon.dpm.module.common.shared.domain.VisitorSmsSendInfo;

/**
 * 访客系统短信发送日志记录Dao接口
 * 
 */
public interface IVisitorSmsSendLogDao {

	/**
	 * 保存访客系统短信发送日志记录
	 * 
	 * @param entity
	 */
	public void saveSmsSendLog(VisitorSmsSendInfo entity);

}
