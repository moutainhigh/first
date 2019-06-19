package com.deppon.dpm.uums.test.cache;

import com.deppon.dpm.uums.server.domain.ResourceEntity;
import com.deppon.foss.framework.entity.IFunction;

/**
 * 权限缓存
 * ClassName: ResourceUriCache <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2014-8-19 上午10:15:18 <br/>
 *
 * @author 157229-zxy
 * @version 
 * @since JDK 1.6
 */
public class ResourceUriCache extends BpmLocalCache<ResourceEntity>{
	/**
	 * 资源uri缓存 UUID
	 */
	public static final String RESOURCE_URI_CACHE_UUID = IFunction.class.getName();
	
	/**
	 * get
	 */
	public String getUUID() {
		return RESOURCE_URI_CACHE_UUID;
	}
	
}
