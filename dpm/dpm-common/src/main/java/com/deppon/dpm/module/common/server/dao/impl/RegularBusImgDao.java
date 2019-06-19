package com.deppon.dpm.module.common.server.dao.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.deppon.dpm.module.common.server.dao.IRegularBusImgDao;
import com.deppon.dpm.module.common.shared.domain.RegularBusImgEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class RegularBusImgDao extends iBatis3DaoImpl implements IRegularBusImgDao{
	
	private static final String NAME_SPACE = "com.deppon.dpm.module.common.server.dao.impl.RegularBusImgDao.";

	/**
	 * 保存
	 */
	@Override
	public void save(RegularBusImgEntity entity) {
		this.getSqlSession().insert(NAME_SPACE + "save", entity);
	}

	/**
	 * 分页查询
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RegularBusImgEntity> pageQuery(RegularBusImgEntity entity) {
		return this.getSqlSession().selectList(NAME_SPACE + "pageQuery", null, new RowBounds(entity.getStart(), entity.getRows()));
	}

	/**
	 * 查询总条数
	 */
	@Override
	public Long queryTotalCount() {
		return (Long) this.getSqlSession().selectOne(NAME_SPACE + "queryTotalCount");
	}

	/**
	 * 查询班车上下班图片
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RegularBusImgEntity> queryBusImgs() {
		return this.getSqlSession().selectList(NAME_SPACE + "queryBusImgs");
	}

	/**
	 * 删除班车图片信息
	 */
	@Override
	public void delete(Integer id) {
		this.getSqlSession().delete(NAME_SPACE + "delete", id);
	}

}
