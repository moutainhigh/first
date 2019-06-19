package com.deppon.dpm.store.server.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.deppon.dpm.store.server.dao.IStoreTaskSublistDao;
import com.deppon.dpm.store.server.entity.StoreTaskSublist;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class StoreTaskSublistDao extends iBatis3DaoImpl implements IStoreTaskSublistDao {

	private static final String NAME_SPACE="com.deppon.dpm.store.server.dao.IStoreTaskSublistDao";

	/**
	 * 批量插入数据
	 * @return List 包含id
	 */
	@Override
	public List<StoreTaskSublist> insertSelectives(List<StoreTaskSublist> list) {
		// TODO Auto-generated method stub
		this.getSqlSession().insert(NAME_SPACE+".insertSelectives",list);
		return list;
	}

	@Override
	public int updateByPrimaryKeySelective(StoreTaskSublist record) {
		// TODO Auto-generated method stub
		return this.getSqlSession().update(NAME_SPACE+".updateByPrimaryKeySelective", record);
	}

	@Override
	public List<StoreTaskSublist> finelistdept(String taskid) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(NAME_SPACE+".finelistdept", taskid);
	}
}
