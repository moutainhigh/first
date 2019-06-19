package com.deppon.dpm.store.server.dao.impl;

import java.util.List;

import com.deppon.dpm.store.server.dao.IStoreMarkDao;
import com.deppon.dpm.store.server.entity.QueryModInfo;
import com.deppon.dpm.store.server.entity.StoreMark;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 模块打分
 * @author XiaoTian
 *
 */
public class StoreMarkDao extends iBatis3DaoImpl implements IStoreMarkDao {
	/*
	 * 接口全类名
	 */
	private static final String NAME_SPACE = "com.deppon.dpm.store.server.dao.IStoreMarkDao.";

	/**
	 * @author XiaoTian
	 */
	@Override
	public int insertSelective(List<StoreMark> list) {
		// TODO Auto-generated method stub
		this.getSqlSession().insert(NAME_SPACE + "insertSelective", list);
		return 0;
	}
	/**
	 * @param  list
	 * @return int
	 */
	@Override
	public int selectList(List<StoreMark> list) {
		// TODO Auto-generated method stub
		return (Integer) this.getSqlSession().selectOne(NAME_SPACE + "selectList", list);
	}
	/**
	 * @param  list
	 * @return int
	 */
	@Override
	public int updateSelective(List<StoreMark> list) {
		// TODO Auto-generated method stub
		this.getSqlSession().update(NAME_SPACE + "updateSelective", list);
		return 0;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<QueryModInfo> selectFirstmod() {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(NAME_SPACE + "selectFirstmod");
	}
}
