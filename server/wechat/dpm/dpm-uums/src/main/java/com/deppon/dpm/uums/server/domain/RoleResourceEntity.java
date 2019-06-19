package com.deppon.dpm.uums.server.domain;

import java.io.Serializable;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 角色权限entity对象
 * 
 */
public class RoleResourceEntity  extends BaseEntity implements Serializable {
	
    /**
     * 序列化ID
     */	
    private static final long serialVersionUID = -3967231350569569593L;

    /**
     * 数据版本号
     */	
    private Long versionNo;

    /**
    *虚拟编码
    */	
    private String virtualCode;
    
    /**
    *角色
    */	
    private String roleCode;

    /**
    *权限
    */	
    private String resourceCode;
    
    /**
    *角色名称
    */	
    private String roleName;

    /**
    *权限名称
    */	
    private String resourceName;

    /**
    *是否启用
    */	
    private String active;
    
    /**
     * 权限类别
     */
    private String belongSystemType;
    
    /**
     * 权限级别
     */
    private String resType;
    
    
	
	public String getResType() {
		return resType;
	}


	
	public void setResType(String resType) {
		this.resType = resType;
	}


	/**
	 * @return versionNo
	 */
	public Long getVersionNo() {
		return versionNo;
	}

	
	public String getBelongSystemType() {
		return belongSystemType;
	}

	
	public void setBelongSystemType(String belongSystemType) {
		this.belongSystemType = belongSystemType;
	}

	/**
	 * @param  versionNo  
	 */
	public void setVersionNo(Long versionNo) {
		this.versionNo = versionNo;
	}

	/**
	 * @return virtualCode
	 */
	public String getVirtualCode() {
		return virtualCode;
	}

	/**
	 * @param  virtualCode  
	 */
	public void setVirtualCode(String virtualCode) {
		this.virtualCode = virtualCode;
	}

	/**
	 * @return roleCode
	 */
	public String getRoleCode() {
		return roleCode;
	}

	/**
	 * @param  roleCode  
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	/**
	 * @return resourceCode
	 */
	public String getResourceCode() {
		return resourceCode;
	}

	/**
	 * @param  resourceCode  
	 */
	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	/**
	 * @return roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param  roleName  
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return resourceName
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * @param  resourceName  
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	/**
	 * @return active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param  active  
	 */
	public void setActive(String active) {
		this.active = active;
	}

}
