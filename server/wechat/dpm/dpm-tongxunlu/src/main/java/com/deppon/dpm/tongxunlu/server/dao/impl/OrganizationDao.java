package com.deppon.dpm.tongxunlu.server.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.deppon.dpm.tongxunlu.server.dao.IOrganizationDao;
import com.deppon.dpm.tongxunlu.shared.domain.HotLine;
import com.deppon.dpm.tongxunlu.shared.domain.OrganizationEntity;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 查询组织机构数据库操作类.
 * 
 * @author 130126
 * 
 */
public class OrganizationDao extends iBatis3DaoImpl implements IOrganizationDao {
	// namespace
	private static final String NAMESPACE = "com.deppon.dpm.tongxunlu.server.dao.organization.";
	// jdbc模板
	private JdbcTemplate template;

	/**
	 * 新增组织机构
	 * 
	 * @see com.deppon.dpm.tongxunlu.server.dao.IOrganizationDao#insert(com.deppon.dpm.tongxunlu.shared.domain.OrganizationEntity)
	 * @update zxy 20140808 DPM-299 修改
	 */
	public int insert(final OrganizationEntity org) {
		// 插入
		return this.getSqlSession().insert(NAMESPACE + "insert", org);
	}

	/**
	 * 组织机构查询
	 */
	@SuppressWarnings("unchecked")
	public List<OrganizationVO> query(OrganizationVO org, int start,
			int pageSize) {
		// 定义返回类型
		List<OrganizationVO> result = new ArrayList<OrganizationVO>();
		// 页面大小
		org.setLimit(pageSize);
		// 其实值
		org.setStart(start);
		// 数据查询
		result = this.getSqlSession().selectList(NAMESPACE + "getOrgs", org);
		return result;
	}
	
	/**
	 * 查询合伙人权限的组织列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OrganizationVO> queryForPartner(OrganizationVO org, int start,
			int pageSize) {
		// 定义返回类型
		List<OrganizationVO> result = new ArrayList<OrganizationVO>();
		// 页面大小
		org.setLimit(pageSize);
		// 其实值
		org.setStart(start);
		// 数据查询
		result = this.getSqlSession().selectList(NAMESPACE + "getOrgsForPartner", org);
		return result;
	}

	/**
	 * 组织查询大小
	 */
	@Override
	public Integer querySize(OrganizationVO org) {
		// 数量查询
		return (Integer) this.getSqlSession().selectOne(
				NAMESPACE + "getOrgsSize", org);
	}

	/**
	 * 更新
	 */
	@Override
	public int update(OrganizationVO emp) {
		// 组织机构跟新
		return this.getSqlSession().update(NAMESPACE + "update", emp);
	}
	
	/**
	 * 更新
	 */
	@Override
	public int update(OrganizationEntity orgEntity) {
		// 组织机构更新
		return this.getSqlSession().update(NAMESPACE + "updateByEntity", orgEntity);
	}

	/**
	 * 删除
	 */
	@Override
	public int del(int orgid) {
		// 组织机构删除
		return this.getSqlSession().delete(NAMESPACE + "delete", orgid);
	}

	/**
	 * 查询
	 */
	@Override
	public OrganizationEntity queryOrganizationByOrgEntity(OrganizationVO org) {
		// 查询组织机构
		return (OrganizationEntity) this.getSqlSession().selectOne(NAMESPACE + "queryOrganizationByOrgEntity", org);
	}

	/**
	 * 热线
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<HotLine> hotLine() {
		// 热线查询
		List<HotLine> selectList = getSqlSession().selectList(NAMESPACE + "hotLine", HotLine.class);
		return selectList;
	}

	/**
	 * 查询
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<OrganizationEntity> searchOrgArchitecture(String orgName) {
		// 用于参数拼接
		Map<String, String> map = new HashMap<String, String>();
		// 参数拼接
		map.put("orgName", orgName);
		// 根据组织名查询组织机构
		return getSqlSession().selectList(NAMESPACE + "searchOrgArchitecture",map);
	}
	
	/**
	 * get
	 * 
	 * @return
	 */
	public JdbcTemplate getTemplate() {
		return template;
	}

	/**
	 * set
	 * 
	 * @param template
	 */
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
}
