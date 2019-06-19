package com.deppon.dpm.module.announce.server.service;

import java.util.List;

import com.deppon.dpm.module.announce.shared.domain.AnnounceUserEntity;

/**
 * 
 * @ClassName: AnnounceService
 * @Description: 公告用户管理Service接口
 * @author 045925/YANGBIN
 * @date 2015-3-18 下午3:28:20
 * 
 */
public interface IAnnounceUserService {
	/**
	 * 公告用户操作插入
	 * @param entity
	 * @return
	 */
	public int insert(AnnounceUserEntity entity);

	/**
	 * 公告用户操作删除
	 * @param entity
	 * @return
	 */
	public int delete(String id);

	/**
	 * 公告用户操作更新
	 * @param entity
	 * @return
	 */
	public int update(AnnounceUserEntity entity);

	/**
	 * 根据参数查询
	 * @param entity
	 * @return
	 */
	public String queryCommonId(AnnounceUserEntity queryParam);

	/**
	 * 查询所有
	 * @param entity
	 * @return
	 */
	public List<AnnounceUserEntity> queryCommonAll(AnnounceUserEntity queryParam);

}
