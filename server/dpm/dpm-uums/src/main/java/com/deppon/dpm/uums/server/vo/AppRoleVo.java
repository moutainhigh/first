package com.deppon.dpm.uums.server.vo;

import java.io.Serializable;
import java.util.List;

import com.deppon.dpm.uums.server.domain.RoleEntity;

/** 
 * @ClassName: AppFunctionVo 
 * @Description: 功能权限的VO
 * @author yuyongxiang-134019-yuyongxiang@deppon.com
 * @date 2014年8月22日 下午4:10:23 
 *  
 */
public class AppRoleVo implements Serializable {

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 1L;
	
	/**
	 * 功能类的基础映射
	 */
	private RoleEntity roleEntity;
	
	/**
	 * 功能类的基础list映射
	 */
	private List<RoleEntity> roleList;
	
	/**
	 * 总数
	 */
	private  Long totalCount;

	/** 
	 * @return totalCount 
	 */
	public Long getTotalCount() {
		return totalCount;
	}

	/** 
	 * @param totalCount 要设置的 totalCount 
	 */
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
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
	 * @return roleList 
	 */
	public List<RoleEntity> getRoleList() {
		return roleList;
	}

	/** 
	 * @param roleList 要设置的 roleList 
	 */
	public void setRoleList(List<RoleEntity> roleList) {
		this.roleList = roleList;
	}

}
