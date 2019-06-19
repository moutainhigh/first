/**
 * Project Name:dpm-login
 * File Name:BpmLocalCache.java
 * Package Name:com.deppon.dpm.login.server.cache
 * Date:2014-8-23下午5:33:44
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.deppon.dpm.login.server.cache;

import com.deppon.foss.framework.cache.DefaultLocalCache;

/**
 * 扩展本地缓存功能
 * Function: TODO ADD FUNCTION. <br/>
 * 
 * Date:     2014-8-23 下午5:33:44 <br/>
 * @author   157229-zxy
 * @version  
 * @since    JDK 1.6
 */
public abstract class BpmLocalCache<V> extends DefaultLocalCache<V>{
	
	/**
	 * 清空缓存信息
	 * @see com.deppon.foss.framework.cache.DefaultLocalCache#invalid()
	 */
	@Override
	public void invalid() {
		// 清空
		cacheStorage.clear();
	}

}

