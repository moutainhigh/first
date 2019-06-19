package com.deppon.dpm.module.announce.server.cache;

import java.util.List;

import com.deppon.dpm.module.announce.shared.domain.AnnounceEntity;
import com.deppon.foss.framework.cache.DefaultTTLRedisCache;

/**
 * 公告缓存信息
 * 
 * @author 231586
 * 
 */
public class AnnounceCache extends DefaultTTLRedisCache<List<AnnounceEntity>> {
	/**
	 * UUID
	 */
	private static final String UUID = AnnounceCache.class.getName();

	/**
	 * get
	 */
	@Override
	public String getUUID() {
		// 返回UUID
		return UUID;
	}
}
