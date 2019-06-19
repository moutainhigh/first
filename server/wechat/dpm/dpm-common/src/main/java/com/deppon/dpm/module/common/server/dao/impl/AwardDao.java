package com.deppon.dpm.module.common.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deppon.dpm.module.common.server.dao.IAwardDao;
import com.deppon.dpm.module.common.shared.domain.AwardDetailEntity;
import com.deppon.dpm.module.common.shared.domain.AwardEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * dao层实现
 * 
 * @date 2015-08-28
 * @author 231586
 * 
 */
public class AwardDao extends iBatis3DaoImpl implements IAwardDao {
	/**
	 * namespace
	 */
	private final static String NAMESPACE = "com.deppon.dpm.module.common.server.dao.awardInfo.";

	@Override
	@SuppressWarnings("unchecked")
	public List<AwardEntity> getAwardList(int begin, int pageSize) {
		// 定义返回map
		Map<String, Integer> map = new HashMap<String, Integer>();
		// 开始
		map.put("begin", begin);
		// 页面大小
		map.put("pageSize", pageSize);
		// 获取列表
		return getSqlSession().selectList(NAMESPACE + "getAwardList", map);
	}

	@Override
	public int insertReply(AwardDetailEntity entity) {
		// 插入
		return getSqlSession().insert(NAMESPACE + "insertReply", entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AwardDetailEntity> getAwardDetail(String articleID, int begin,
			int pageSize) {
		// 定义返回map
		Map<String, Object> map = new HashMap<String, Object>();
		// 文章id
		map.put("articleID", articleID);
		// 开始
		map.put("begin", begin);
		// 大小
		map.put("pageSize", pageSize);
		// 返回集合
		return getSqlSession().selectList(NAMESPACE + "getAwardDetail", map);
	}

	/**
	 * 插入悬赏内容
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public int insertAward(AwardEntity entity) {
		// 插入悬赏内容
		return getSqlSession().insert(NAMESPACE + "insertAward", entity);
	}

	/**
	 * 删除悬赏内容
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public int deleteAward(AwardEntity entity) {
		// 悬赏信息id
		String awardId = entity.getArticleID();
		if (StringUtils.isNotEmpty(awardId)) {
			// 删除悬赏信息
			return getSqlSession().delete(NAMESPACE + "deleteAward", awardId);
		} else {
			return 0;
		}
	}
	
	/**
	 * 批量删除悬赏
	 */
	@Override
	public int deleteAwardsByIds(String[] ids) {
		Map<String,String[]> map = new HashMap<String,String[]>();
		map.put("ids", ids);
		return getSqlSession().delete(NAMESPACE + "deleteAwardsByIds", map);
	}

	/**
	 * 更新悬赏内容
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public int updateAward(AwardEntity entity) {
		// 更新悬赏内容
		return getSqlSession().update(NAMESPACE + "updateAward", entity);
	}

	/**
	 * 获取悬赏内容信息
	 * @param entity
	 * @return
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AwardEntity getAwardEntity(AwardEntity entity) {
		//获取悬赏内容id
		String articleID = entity.getArticleID();
		// 定义返回map
		Map map = new HashMap();
		// 开始
		map.put("begin", 0);
		// 页面大小
		map.put("pageSize", 1);
		// 悬赏内容id
		map.put("articleID", articleID);
		// 获取列表
		AwardEntity awardEntity = (AwardEntity) getSqlSession().selectOne(
				NAMESPACE + "getAwardList", map);
		return awardEntity;
	}

	/**
	 * 查询总悬赏总条数
	 */
	@Override
	public Long queryCount() {
		return (Long)getSqlSession().selectOne(NAMESPACE + "queryCount");
	}
}
