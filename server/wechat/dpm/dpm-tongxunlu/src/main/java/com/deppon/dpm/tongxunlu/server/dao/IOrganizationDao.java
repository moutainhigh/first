package com.deppon.dpm.tongxunlu.server.dao;

import java.util.List;

import com.deppon.dpm.tongxunlu.shared.domain.HotLine;
import com.deppon.dpm.tongxunlu.shared.domain.OrganizationEntity;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;

/**
 * 组织机构实体vo.
 */
public interface IOrganizationDao {
	/**
	 * 添加组织机构.
	 */
	public int insert(OrganizationEntity org);

	/**
	 * 查询结果集合.
	 */
	public List<OrganizationVO> query(OrganizationVO org, int start,
			int pageSize);
	
	/**
	 * 查询合伙人权限的组织列表
	 */
	public List<OrganizationVO> queryForPartner(OrganizationVO org, int start,
			int pageSize);

	/**
	 * 更新组织机构.
	 */
	public int update(OrganizationVO emp);
	/**
	 * 组织信息更新
	 * @param orgEntity
	 * @return
	 */
	public int update(OrganizationEntity orgEntity);

	/**
	 * 删除组织机构
	 */
	public int del(int orgid);

	/**
	 * 查询数目
	 */
	public Integer querySize(OrganizationVO org);

	/**
	 * 查询组织信息
	 */
	public OrganizationEntity queryOrganizationByOrgEntity(OrganizationVO org);

	/**
	 * 热线
	 * @return
	 */
	public List<HotLine> hotLine();

	/**
	 * // 组织名查询
	 * @param orgName
	 * @return
	 */
	public List<OrganizationEntity> searchOrgArchitecture(String orgName);
}
