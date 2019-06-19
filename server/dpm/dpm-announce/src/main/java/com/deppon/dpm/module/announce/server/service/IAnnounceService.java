package com.deppon.dpm.module.announce.server.service;

import java.util.List;

import com.deppon.dpm.module.announce.shared.domain.AnnounceEntity;
import com.deppon.dpm.module.announce.shared.domain.AnnounceUserEntity;
import com.deppon.dpm.module.announce.shared.dto.AnnounceDto;

/**
 * 
 * @ClassName: AnnounceService
 * @Description: 公告管理Service接口
 * @author 045925/YANGBIN
 * @date 2015-3-18 下午3:28:20
 * 
 */
public interface IAnnounceService {
	/**
	 * 插入
	 * 
	 * @param entity
	 * @return
	 */
	public int insert(AnnounceEntity entity);

	/**
	 * 更新
	 * 
	 * @param entity
	 * @return
	 */
	public int update(AnnounceEntity entity);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int delete(String id);

	/**
	 * 查询新闻资讯
	 * 
	 * @param limit
	 * @param start
	 * @param queryParam
	 * @return
	 */
	public List<AnnounceEntity> queryCommonAll(int limit, int start,
			AnnounceDto queryParam);

	/**
	 * 根据查询参数返回查询数量
	 * 
	 * @param queryParam
	 * @return
	 */
	public Long queryCommonCount(AnnounceDto queryParam);

	/**
	 * 更新公告状态
	 * 
	 * @param dto
	 * @return
	 */
	public int updateAnnounceState(AnnounceDto dto);

	/**
	 * 查询公告详情
	 * 
	 * @param id
	 * @return
	 */
	public AnnounceEntity queryCommonOne(String id);

	/**
	 * 查询公告详情
	 * 
	 * @param id
	 * @param userId
	 * @return
	 */
	public AnnounceEntity queryDetialRead(String id, String userId);

	/**
	 * 查询所有的我的收藏
	 * 
	 * @param empCode
	 * @return
	 */
	public List<AnnounceUserEntity> queryMyCollectAll(String empCode);

	/**
	 * 删除我的收藏
	 * 
	 * @param collIds
	 * @return
	 */
	public int deleteMyColls(String collIds);

	/**
	 * 根据id查询咨询详情
	 * 
	 * @param oaId
	 * @return
	 */
	public AnnounceEntity queryOneByOaId(String oaId);

	/**
	 * 查询新闻咨询
	 * 
	 * @param limit
	 * @param start
	 * @return
	 */
	public List<AnnounceEntity> queryNormalNews(int limit, int start);

	/**
	 * 查询滚动新闻
	 * 
	 * @return
	 */
	public List<AnnounceEntity> queryScrollNews();

	/**
	 * 搜索列表查询
	 * 
	 * @param searchString
	 * @param limit
	 * @param start
	 * @return
	 */
	public List<AnnounceEntity> getSearchResult(String searchString, int limit,
			int start);

	/**
	 * 搜索结果详情
	 * 
	 * @param searchString
	 * @param announceId
	 * @param userId
	 * @return
	 */
	public AnnounceEntity getDetailSearchResultByAnnounceId(
			String searchString, String announceId, String userId);
}
