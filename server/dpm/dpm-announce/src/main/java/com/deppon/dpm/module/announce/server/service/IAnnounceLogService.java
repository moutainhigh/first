package com.deppon.dpm.module.announce.server.service;

import com.deppon.dpm.module.announce.shared.domain.AnnounceLogEntity;

/**
 * 
* @ClassName: AnnounceService 
* @Description: 公告LOG管理Service接口 
* @author 045925/YANGBIN
* @date 2015-3-18 下午3:28:20 
*
 */
public interface IAnnounceLogService {
	/**
	 * 日志插入
	 * @param entity
	 * @return
	 */
	public int insert(AnnounceLogEntity entity);
}
