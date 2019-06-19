package com.deppon.dpm.module.common.server.dao.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.deppon.dpm.module.common.server.dao.IProjectManageDeptDao;
import com.deppon.dpm.module.common.shared.domain.ProjectManageDeptEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 工程管理部门
 *
 */
public class ProjectManageDeptDao extends iBatis3DaoImpl implements IProjectManageDeptDao{

	private static final String NAME_SPACE = "com.deppon.dpm.module.common.server.dao.impl.ProjectManageDeptDao.";

	// 删除
	public void delete(String[] orgcodes) {
		this.getSqlSession().delete(NAME_SPACE + "delete", orgcodes);
	}

	// 分页查询
	@SuppressWarnings("unchecked")
	public List<ProjectManageDeptEntity> list(int page, int rows) {
		RowBounds rowBounds = new RowBounds(page, rows);
		return this.getSqlSession().selectList(NAME_SPACE + "list", null, rowBounds);
	}

	// 新增
	public void save(ProjectManageDeptEntity entity) {
		this.getSqlSession().insert(NAME_SPACE + "save", entity);
	}
	
	// 查询总记录数
	public long queryCount() {
		return (Long) this.getSqlSession().selectOne(NAME_SPACE + "queryCount");
	}
}
