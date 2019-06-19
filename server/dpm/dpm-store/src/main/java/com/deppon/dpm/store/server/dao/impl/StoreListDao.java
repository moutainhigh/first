package com.deppon.dpm.store.server.dao.impl;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.store.server.dao.IStoreListDao;
import com.deppon.dpm.store.server.entity.StoreLike;
import com.deppon.dpm.store.server.entity.StoreLikelog;
import com.deppon.dpm.store.server.entity.StoreList;
import com.deppon.dpm.store.server.vo.StoreListVo;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 榜单
 * @author XiaoTian
 *
 */
public class StoreListDao extends iBatis3DaoImpl implements IStoreListDao {

	private static final String NAME_SPACE = "com.deppon.dpm.store.server.dao.IStoreListDao.";

	/**
	 * 查询榜单
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StoreListVo> fineList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(NAME_SPACE + "fineList",map);
	}
	/**
	 * 查询当前用户是否进行点赞或者警告
	 */
	@Override
	public int fineCountlikeIf(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return (Integer) this.getSqlSession().selectOne(NAME_SPACE + "fineCountlikeIf",map);
	}
	/**
	 * 点赞
	 */
	@Override
	public int updateNum(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.getSqlSession().update(NAME_SPACE+"updateNum", map);
	}
	/**
	 * 添加点赞日志
	 */
	@Override
	public int insertStorelog(StoreLikelog storeLikelog) {
		// TODO Auto-generated method stub
		return this.getSqlSession().insert(NAME_SPACE+"insertStorelog", storeLikelog);
	}
}
