package com.deppon.dpm.module.announce.server.cache;

import java.util.List;

import com.deppon.dpm.module.announce.server.service.IAnnounceService;
import com.deppon.dpm.module.announce.shared.domain.AnnounceEntity;
import com.deppon.dpm.module.announce.shared.dto.AnnounceDto;
import com.deppon.foss.framework.cache.provider.ITTLCacheProvider;

/**
 * 公告缓存提供
 * 
 * @author 231586
 * 
 */
public class AnnounceProvider implements ITTLCacheProvider<List<AnnounceEntity>> {
	/**
	 * set injection
	 */
	private IAnnounceService announceService;

	@Override
	public List<AnnounceEntity> get(String key) {
		// 查询实体
		AnnounceDto queryParam = new AnnounceDto();
		/*
		 * Calendar date = Calendar.getInstance(); date.set(Calendar.DATE,
		 * date.get(Calendar.DATE) - 30); Date startTime = date.getTime(); Date
		 * endTime = new Date(); queryParam.setStartTime(startTime);
		 * queryParam.setEndTime(endTime);
		 */
		// 查询
		Long count = announceService.queryCommonCount(queryParam);
		// 查询出数据
		if (count > 0) {
			// 起始
			int start = 0;
			// 转化
			int limit = count.intValue();
			// 返回查询值
			return announceService.queryCommonAll(limit, start, queryParam);
		}
		// 跳出
		return null;
	}

	/**
	 * set
	 * 
	 * @param announceService
	 */
	public void setAnnounceService(IAnnounceService announceService) {
		this.announceService = announceService;
	}
}
