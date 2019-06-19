package com.deppon.dpm.module.announce.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.announce.server.dao.IAnnounceUserDao;
import com.deppon.dpm.module.announce.shared.domain.AnnounceUserEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 
* @ClassName: AnnounceDao 
* @Description: 公告用户DAO实现层 
* @author 045925/YANGBIN
* @date 2015-3-18 下午3:15:18 
*
 */
@SuppressWarnings("unchecked")
public class AnnounceUserDao extends iBatis3DaoImpl implements IAnnounceUserDao {
	private static final String NAME_SPACE="com.deppon.dpm.module.announce.shared.domain.AnnounceUserEntity.";
	/**
	 * 
	* @Title: insert 
	* @Description: 插入公告
	* @param @param entity
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	@Override
	public int insert(AnnounceUserEntity entity) {
		// 插入
		return getSqlSession().insert(NAME_SPACE+"insert", entity);
	}
	/**
	 * 
	* @Title: update 
	* @Description: 更新公告
	* @param @param entity
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	@Override
	public int delete(String id) {
		// 删除
		return getSqlSession().delete(NAME_SPACE+"delete", id);
	}
	
	/**
	 * 
	* @Title: queryCommonCount 
	* @Description: 根据查询参数返回公告条数
	* @param @param queryParam
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	@Override
	public String queryCommonId(AnnounceUserEntity queryParam) {
		// 查询
		return (String) getSqlSession().selectOne(NAME_SPACE+"queryCommonId", queryParam);
	}

	@Override
	public List<AnnounceUserEntity> queryCommonAll(AnnounceUserEntity queryParam) {
		// 查询
		return getSqlSession().selectList(NAME_SPACE+"queryCommonAll", queryParam);
	}
	@Override
	public int update(AnnounceUserEntity entity) {
		// 更新
		return getSqlSession().update(NAME_SPACE+"update", entity);
	}

}
