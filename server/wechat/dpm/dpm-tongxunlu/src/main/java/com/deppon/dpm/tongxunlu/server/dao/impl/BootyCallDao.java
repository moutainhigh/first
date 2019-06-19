package com.deppon.dpm.tongxunlu.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.tongxunlu.server.dao.IBootyCallDao;
import com.deppon.dpm.tongxunlu.shared.domain.BootyCallEntity;
import com.deppon.dpm.tongxunlu.shared.domain.BootyEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 约吧dao曾实现
 * 
 * @date 2015-09-14
 * @author 231586
 * 
 */
public class BootyCallDao extends iBatis3DaoImpl implements IBootyCallDao {
	/**
	 * namespace
	 */
	private final static String NAMESPACE = "com.deppon.dpm.tongxunlu.server.dao.impl.BootyCallDao.";

	/**
	 * 发布约吧信息
	 */
	@Override
	public int publishBootyCallInfo(BootyCallEntity entity) {
		// 发布约吧信息
		return getSqlSession().insert(NAMESPACE + "publishBootyCallInfo", entity);
	}

	/**
	 * 获取约吧数据
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getBootyCallInfo(Map<String, Object> map) {
		// 获取约吧数据
		return getSqlSession().selectList(NAMESPACE + "getBootyCallInfo", map);
	}

	/**
	 * 加入约吧
	 */
	@Override
	public int joinBootyCall(Map<String, Object> map) {
		// 加入约吧
		return getSqlSession().update(NAMESPACE + "joinBootyCall", map);
	}

	/**
	 * 获取加入人员工号
	 */
	@Override
	public String getJoinedPerson(int id) {
		// 获取加入人员工号
		return (String) getSqlSession().selectOne(NAMESPACE + "getJoinedPerson", id);
	}
	
	/**
	 * 查询约吧参加人员信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BootyEntity> queryJoinEmpsByEmpCodes(String[] ress) {
		Map<String,String[]> map = new HashMap<String,String[]>();
		map.put("ress", ress);
		return (List<BootyEntity>)getSqlSession().selectList(NAMESPACE + "queryJoinEmpsByEmpCodes", map);
	}

}
