package com.deppon.dpm.module.announce.server.dao;


import com.deppon.dpm.module.announce.shared.domain.AnnounceLogEntity;

/**
 * 
* @ClassName: IAnnounceDao 
* @Description: 公告LOG管理DAO 
* @author 045925/YANGBIN
* @date 2015-3-18 下午3:00:45 
*
 */
public interface IAnnounceLogDao {
	public int insert(AnnounceLogEntity entity);
}
