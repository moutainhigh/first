package com.deppon.dpm.uums.server.vo;

import java.io.Serializable;
import java.util.List;

import com.deppon.dpm.uums.server.domain.ResourceEntity;

/** 
 * @ClassName: AppFunctionVo 
 * @Description: 功能权限的VO
 * @author yuyongxiang-134019-yuyongxiang@deppon.com
 * @date 2014年8月22日 下午4:10:23 
 *  
 */
public class AppFunctionVo implements Serializable {

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 1L;
	
	/**
	 * 功能类的基础映射
	 */
	private ResourceEntity resourceEntity;
	
	/**
	 * 功能类的基础list映射
	 */
	private List<ResourceEntity> resourceList;
	
	/**
	 * 总数
	 */
	private  Long totalCount;
	

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

}
