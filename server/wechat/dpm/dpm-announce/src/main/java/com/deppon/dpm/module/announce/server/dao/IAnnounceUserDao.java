package com.deppon.dpm.module.announce.server.dao;


import java.util.List;

import com.deppon.dpm.module.announce.shared.domain.AnnounceUserEntity;

/**
 * 
* @ClassName: IAnnounceDao 
* @Description: 公告用户管理DAO 
* @author 045925/YANGBIN
* @date 2015-3-18 下午3:00:45 
*
 */
public interface IAnnounceUserDao {
	/**
	 * 插入
	 * @param entity
	 * @return
	 */
	public int insert(AnnounceUserEntity entity);
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int delete(String id);
	/**
	 * 更新
	 * @param entity
	 * @return
	 */
	public int update(AnnounceUserEntity entity);
	/**
	 * 查询
	 * @param queryParam
	 * @return
	 */
	public String queryCommonId(AnnounceUserEntity queryParam);
	/**
	 * 查询全部
	 * @param queryParam
	 * @return
	 */
	public List<AnnounceUserEntity> queryCommonAll(AnnounceUserEntity queryParam);
}
