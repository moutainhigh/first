package com.deppon.dpm.module.announce.server.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.deppon.dpm.module.announce.server.dao.IAnnounceDao;
import com.deppon.dpm.module.announce.shared.domain.AnnounceEntity;
import com.deppon.dpm.module.announce.shared.dto.AnnounceDto;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 
* @ClassName: AnnounceDao 
* @Description: 公告DAO实现层 
* @author 045925/YANGBIN
* @date 2015-3-18 下午3:15:18 
*
 */
@SuppressWarnings("unchecked")
public class AnnounceDao extends iBatis3DaoImpl implements IAnnounceDao {
	private static final String NAME_SPACE="com.deppon.dpm.module.announce.shared.domain.AnnounceEntity.";
	/**
	 * 
	* @Title: insert 
	* @Description: 插入公告
	* @param entity
	* @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	@Override
	public int insert(AnnounceEntity entity) {
		// 插入
		return getSqlSession().insert(NAME_SPACE+"insert", entity);
	}
	/**
	 * 
	* @Title: update 
	* @Description: 更新公告
	* @param entity
	* @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	@Override
	public int update(AnnounceEntity entity) {
		// 更新
		return getSqlSession().update(NAME_SPACE+"update", entity);
	}
	/**
	 * 
	* @Title: delete 
	* @Description: 根据ID删除公告
	* @param id
	* @return 设定文件 
	* @return int 返回类型 
	* @throws
	 */
	@Override
	public int delete(String id) {
		// 删除
		return getSqlSession().update(NAME_SPACE+"delete", id);
	}
	
	/**
	 * 
	* @Title: queryCommonAll 
	* @Description: 分页查询公告
	* @param limit
	* @param start
	* @param queryParam
	* @return    设定文件 
	* @return List<AnnounceEntity>    返回类型 
	* @throws
	 */
	@Override
	public List<AnnounceEntity> queryCommonAll(int limit, int start,
			AnnounceDto queryParam) {
		// 分页
		RowBounds rowBounds = new RowBounds(start, limit);
		// 返回
		return getSqlSession().selectList(NAME_SPACE+"queryCommonAll", queryParam, rowBounds);
	}
	/**
	 * 
	* @Title: queryCommonCount 
	* @Description: 根据查询参数返回公告条数
	* @param queryParam
	* @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	@Override
	public Long queryCommonCount(AnnounceDto queryParam) {
		// 返回
		return (Long) getSqlSession().selectOne(NAME_SPACE+"queryCommonCount", queryParam);
	}
	/**
	 * 
	* @Title: queryCommonOne 
	* @Description: 根据查询参数返回公告
	* @param queryParam
	* @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	@Override
	public AnnounceEntity queryCommonOne(AnnounceDto queryParam) {
		// 查询所有
		List<AnnounceEntity> list = getSqlSession().selectList(NAME_SPACE+"queryCommonAll", queryParam);
		if(null != list
				&& list.size() > 0){
			// 返回
			return list.get(0);
		}
		// 返回
		return null;
	}
	/**
	 * 
	* @Title: queryOneByOaId 
	* @Description: 根据查询参数返回公告
	* @param  oaId
	* @param  设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	@Override
	public AnnounceEntity queryOneByOaId(String oaId) {
		// 查询一个
		List<AnnounceEntity> list = getSqlSession().selectList(NAME_SPACE+"queryOneByOaId", oaId);
		if(null != list
				&& list.size() > 0){
			// 返回
			return list.get(0);
		}
		// 返回
		return null;
	}
	/**
	 * 
	* @Title: queryNormalNews 
	* @Description: 查询普通新闻
	* @param limit
	* @param start
	* @param queryParam
	* @param  设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	@Override
	public List<AnnounceEntity> queryNormalNews(int limit, int start,
			AnnounceDto queryParam) {
		// 分页
		RowBounds rowBounds = new RowBounds(start, limit);
		// 返回
		return getSqlSession().selectList(NAME_SPACE+"queryNormalNews", queryParam, rowBounds);
	}
	/**
	 * 
	* @Title: queryNormalNews 
	* @Description: 查询滚动新闻
	* @param  设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	@Override
	public List<AnnounceEntity> queryScrollNews() {
		// 返回
		return getSqlSession().selectList(NAME_SPACE+"queryScrollNews");
	}
	/**
	 * 搜索结果查询
	 */
	@Override
	public List<AnnounceEntity> getSearchResult(Map<String, Object> map) {
		// 返回
		return getSqlSession().selectList(NAME_SPACE + "getSearchResult", map);
	}
}