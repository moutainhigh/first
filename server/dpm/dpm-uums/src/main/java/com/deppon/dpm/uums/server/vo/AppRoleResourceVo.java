package com.deppon.dpm.uums.server.vo;

import java.io.Serializable;
import java.util.List;

import com.deppon.dpm.uums.server.domain.ResourceEntity;
import com.deppon.dpm.uums.server.domain.RoleEntity;
import com.deppon.dpm.uums.server.domain.RoleResourceEntity;

/** 
 * @ClassName: AppFunctionVo 
 * @Description: 功能权限的VO
 * @author yuyongxiang-134019-yuyongxiang@deppon.com
 * @date 2014年8月22日 下午4:10:23 
 *  
 */
public class AppRoleResourceVo implements Serializable {

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 1L;
	
	/**
	 * 功能类的基础映射
	 */
	private ResourceEntity resourceEntity;
	/**
	 * 功能类的基础映射
	 */
	private RoleResourceEntity roleResourceEntity;
	
	/**
	 * 功能类的基础映射
	 */
	private RoleEntity roleEntity;
	
	/**
	 * 功能类的基础list映射
	 */
	private List<ResourceEntity> resourceList;
	
	/**
	 * 已分配的功能
	 */
	private List<ResourceEntity> resourceedSelectedList;

	/** 
	 * @return resourceEntity 
	 */
	public ResourceEntity getResourceEntity() {
		return resourceEntity;
	}

	/** 
	 * @param resourceEntity 要设置的 resourceEntity 
	 */
	public void setResourceEntity(ResourceEntity resourceEntity) {
		this.resourceEntity = resourceEntity;
	}

	/** 
	 * @return resourceList 
	 */
	public List<ResourceEntity> getResourceList() {
		return resourceList;
	}

	/** 
	 * @param resourceList 要设置的 resourceList 
	 */
	public void setResourceList(List<ResourceEntity> resourceList) {
		this.resourceList = resourceList;
	}

	/** 
	 * @return roleResourceEntity 
	 */
	public RoleResourceEntity getRoleResourceEntity() {
		return roleResourceEntity;
	}

	/** 
	 * @param roleResourceEntity 要设置的 roleResourceEntity 
	 */
	public void setRoleResourceEntity(RoleResourceEntity roleResourceEntity) {
		this.roleResourceEntity = roleResourceEntity;
	}

	/** 
	 * @return roleEntity 
	 */
	public RoleEntity getRoleEntity() {
		return roleEntity;
	}

	/** 
	 * @param roleEntity 要设置的 roleEntity 
	 */
	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}

	/** 
	 * @return resourceedSelectedList 
	 */
	public List<ResourceEntity> getResourceedSelectedList() {
		return resourceedSelectedList;
	}

	/** 
	 * @param resourceedSelectedList 要设置的 resourceedSelectedList 
	 */
	public void setResourceedSelectedList(
			List<ResourceEntity> resourceedSelectedList) {
		this.resourceedSelectedList = resourceedSelectedList;
	}
	
	

}
