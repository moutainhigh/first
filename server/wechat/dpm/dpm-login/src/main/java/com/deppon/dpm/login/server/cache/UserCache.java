/*******************************************************************************
 * Copyright 2013 BSE TEAM
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * PROJECT NAME	: bse-baseinfo
 * 
 * FILE PATH        	: src/main/java/com/deppon/foss/module/base/baseinfo/server/cache/UserCache.java
 * 
 * FILE NAME        	: UserCache.java
 * 
 * AUTHOR			: FOSS综合管理开发组
 * 
 * HOME PAGE		:  http://www.deppon.com
 * 
 * COPYRIGHT		: Copyright (c) 2013  Deppon All Rights Reserved.
 ******************************************************************************/
/*
 * Copyright by Deppon and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about Deppon from
 *
 *      http://www.deppon.com
 *
 */ 
package com.deppon.dpm.login.server.cache;


//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

import com.deppon.foss.framework.entity.IUser;

/**
 * 用户缓存
 * ClassName: UserCache <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2014-8-19 上午10:16:28 <br/>
 *
 * @author 157229-zxy
 * @version 
 * @since JDK 1.6
 */
public class UserCache extends BpmLocalCache<IUser>{
	/**
	 * 用户缓存 UUID
	 */
	public static final String USER_CACHE_UUID = IUser.class.getName();
//	private static final Log LOG = LogFactory.getLog(UserCache.class);
	/**
	 * get
	 */
	public String getUUID() {
		return USER_CACHE_UUID;
	}
	/**
	 * 
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.deppon.foss.framework.cache.DefaultLocalCache#get(java.lang.String)
	 */
//	@Override
//	public IUser get(String key) {
//		if(StringUtils.isBlank(key)) {
//            throw new RuntimeException("key does not allow for null!");
//        }
//		IUser value = null;
//        try {
//        	value = cacheStorage.get(getKey(key));
//        } catch(ValueIsBlankException e) {
//            LOG.warn("缓存["+getUUID()+"]，key["+key+"]存在，value为空串，返回结果[null]");
//            //key存在，value为空串
//            return null;
//        } catch(ValueIsNullException ex) {
//			value = cacheProvider.get(key);
//			cacheStorage.put(key, value, timeOut);
//        } catch(KeyIsNotFoundException ex1) {
//            //key不存在
//            value = cacheProvider.get(key);
//            LOG.warn("缓存["+getUUID()+"]，key["+key+"]不存在，走数据库查询，返回结果["+value+"]");
//            cacheStorage.put(getKey(key), value, timeOut);
//        } catch(RedisConnectionException exx) {
//            //redis 连接出现异常
//            value = cacheProvider.get(key);
//            LOG.warn("redis连接出现异常，走数据库查询!");
//            return value;
//        }
//        if(value == null){
//			value = cacheProvider.get(key);
//			cacheStorage.put(key, value, timeOut);
//		}
//        return value;
//	}
}
