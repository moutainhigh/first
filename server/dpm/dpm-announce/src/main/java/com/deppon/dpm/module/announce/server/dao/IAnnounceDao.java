package com.deppon.dpm.module.announce.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.announce.shared.domain.AnnounceEntity;
import com.deppon.dpm.module.announce.shared.dto.AnnounceDto;

/**
 * 
* @ClassName: IAnnounceDao 
* @Description: 公告管理DAO 
* @author 045925/YANGBIN
* @date 2015-3-18 下午3:00:45 
*
 */
public interface IAnnounceDao {
	/**
	 * 公告插入
	 * @param entity
	 * @return
	 */
	public int insert(AnnounceEntity entity);
	/**
	 * 公告更新
	 * @param entity
	 * @return
	 */
	public int update(AnnounceEntity entity);
	/**
	 * 公告删除
	 * @param id
	 * @return
	 */
	public int delete(String id);
	/**
	 * 查询公告
	 * @param limit
	 * @param start
	 * @param queryParam
	 * @return
	 */
	public List<AnnounceEntity> queryCommonAll(int limit,int start,AnnounceDto queryParam);
	/**
	 * 数量查询
	 * @param queryParam
	 * @return
	 */
	public Long queryCommonCount(AnnounceDto queryParam);
	/**
	 * 查询一个公告
	 * @param queryParam
	 * @return
	 */
	public AnnounceEntity queryCommonOne(AnnounceDto queryParam);
	/**
	 * 根据oaId查询一个公告
	 * @param oaId
	 * @return
	 */
	public AnnounceEntity queryOneByOaId(String oaId);	
	/**
	 * 查询普通新闻资讯
	 * @param limit
	 * @param start
	 * @param queryParam
	 * @return
	 */
	public List<AnnounceEntity> queryNormalNews(int limit,int start,AnnounceDto queryParam);
	/**
	 * 查询滚动新闻
	 * @return
	 */
	public List<AnnounceEntity> queryScrollNews();
	/**
	 * 获取搜索的查询结果
	 * @param map
	 * @return
	 */
	public List<AnnounceEntity>  getSearchResult(Map<String, Object> map);
	/**
	 * 获取通告有哪些类型
	 * @since 2018-12-13
	 * */
	public List<String> getAnnounceTypes();
	/**
	 * 获取指定类型通告
	 * @since 2018-12-13
	 * */
	public List<AnnounceEntity> getAnnouncesByType(String type);
	/**
	 * 批量更新通告
	 * @since 2018-12-13
	 * */
	public int updateBatch4Path(List<AnnounceEntity> list);
}
