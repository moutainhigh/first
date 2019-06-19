package com.deppon.dpm.uums.server.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.foss.framework.entity.IRole;

/**
 * 角色entity对象
 * 
 */
public class RoleEntity extends BaseEntity implements IRole,Serializable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -3967231350438328890L;

    /**
    * 数据版本号
    */	
    private Long versionNo;

    /**
    * 角色名称
    */
    private String name;

    /**
    * 角色编码
    */
    private String code;

    /**
     * 角色描述
     */
    private String notes;

    /**
     * 是否启用
     */
    private String active;

    /**
     * 功能对象ID
     */
    private Collection<String> resIds;
    
    /**
     * 
     */
    private List<RoleResourceEntity> roleResourceEntityList;
    
    /**
     * 唯一ID(标明一组数据)
     */
    private String UUID;
    

	/**
	 * @return resIds
	 */
    @Override
    public Collection<String> getFunctionIds() {
	return this.resIds;
    }
    
	/**
	 * @param  value  
	 */
    public void setFunctionIds(Collection<String> value) {
    	this.resIds = value;
    }

	/**
	 * @return versionNo
	 */
	public Long getVersionNo() {
		return versionNo;
	}

	/**
	 * @param  versionNo  
	 */
	public void setVersionNo(Long versionNo) {
		this.versionNo = versionNo;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param  name  
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param  code  
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param  notes  
	 */
	public void setNotes(String notes) {
		this.notes = notes;
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

	/**
	 * @return resIds
	 */
	public Collection<String> getResIds() {
		return resIds;
	}

	/**
	 * @param  resIds  
	 */
	public void setResIds(Collection<String> resIds) {
		this.resIds = resIds;
	}

	/**
	 * @return roleResourceEntityList
	 */
	public List<RoleResourceEntity> getRoleResourceEntityList() {
		return roleResourceEntityList;
	}

	/**
	 * @param  roleResourceEntityList  
	 */
	public void setRoleResourceEntityList(
			List<RoleResourceEntity> roleResourceEntityList) {
		this.roleResourceEntityList = roleResourceEntityList;
	}

	/** 
	 * @return uUID 
	 */
	public String getUUID() {
		return UUID;
	}

	/** 
	 * @param uUID 要设置的 uUID 
	 */
	public void setUUID(String uUID) {
		UUID = uUID;
	}
}