/**
 * Project Name:dpm-login
 * File Name:DefaultLocalCacheStorage.java
 * Package Name:com.deppon.dpm.login.server.cache
 * Date:2014-8-17下午3:53:20
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.deppon.dpm.login.server.cache;

import com.deppon.foss.framework.cache.storage.LocalCacheStorage;
import com.deppon.foss.framework.cache.storage.exception.KeyIsNotFoundException;

/**
 * 本地存储器
 * ClassName:DefaultLocalCacheStorage <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * 
 * Date:     2014-8-17 下午3:53:20 <br/>
 * @author   157229-zxy
 * @version  
 * @since    JDK 1.6
 */
public class DefaultLocalCacheStorage<K, V> extends LocalCacheStorage<K, V>{
	
	/**
	 * 获取
	 */
	public V get(K key) {
		// 如果包含
        if(super.containsKey(key)){
        	// 获取
        	return super.get(key);
        }else{
        	// 抛出异常
        	throw new KeyIsNotFoundException("key["+key+"]不存在");
        }
	}
}

