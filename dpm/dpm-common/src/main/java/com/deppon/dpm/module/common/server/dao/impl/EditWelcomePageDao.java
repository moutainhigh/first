package com.deppon.dpm.module.common.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.common.server.dao.IEditWelcomePageDao;
import com.deppon.dpm.module.common.shared.domain.WelcomePageEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 实现层
 * @date 2015-08-24
 * @author 231586
 *
 */
public class EditWelcomePageDao extends iBatis3DaoImpl implements IEditWelcomePageDao{
	/**
	 * namespace
	 */
	private final String NAMESPACE = "com.deppon.dpm.module.common.server.dao.welcomeInfo.";

	/**
	 * 信息保存
	 */
	@Override
	public int savePic(WelcomePageEntity pageEntity) {
		// 保存信息
		return getSqlSession().insert(NAMESPACE + "savePic", pageEntity);
	}

	/**
	 * 信息获取
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<WelcomePageEntity> getDetails(String userId) {
		// 获取信息
		return getSqlSession().selectList(NAMESPACE + "getDetails",userId);
	}

	/**
	 * 获取欢迎页列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<WelcomePageEntity> getWelcomePageList(int begin,
			int rows) {
		//条件参数
		Map<String,Object> map = new HashMap<String,Object>();
		//开始索引
		map.put("begin", begin);
		//查询条数
		map.put("rows", rows);
		return this.getSqlSession().selectList(NAMESPACE + "getWelcomePageList", map);
	}
	
	/**
	 * 查询数据总条数
	 */
	@Override
	public Long queryCount() {
		return (Long)this.getSqlSession().selectOne(NAMESPACE + "queryCount");
	}

	/**
	 * 根据ids查询出配置页信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> selectWelcomePages(Map<String, String[]> map) {
		return this.getSqlSession().selectList(NAMESPACE + "selectWelcomePages", map);
	}

	/**
	 * 根据ids删除配置页信息
	 */
	@Override
	public int delWelcomePages(Map<String, String[]> map) {
		return this.getSqlSession().delete(NAMESPACE + "delWelcomePages", map);
	}
	
}
