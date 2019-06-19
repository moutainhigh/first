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
 * FILE PATH        	: src/main/java/com/deppon/foss/module/base/baseinfo/server/cache/ResourceUriCacheProvider.java
 * 
 * FILE NAME        	: ResourceUriCacheProvider.java
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
package com.deppon.dpm.uums.test.cache;

import com.deppon.dpm.uums.server.dao.IResourceDao;
import com.deppon.foss.framework.cache.provider.ITTLCacheProvider;
import com.deppon.foss.framework.entity.IFunction;

/**
 * 资源数据生产者 ClassName: ResourceUriCacheProvider <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2014-8-19 上午10:15:50 <br/>
 * 
 * @author 157229-zxy
 * @version
 * @since JDK 1.6
 */
public class ResourceUriCacheProvider implements ITTLCacheProvider<IFunction> {
	/**
	 * set injection
	 */
	private IResourceDao resourceDao;

	/**
	 * 
	 * @date Mar 11, 2013 3:05:41 PM
	 * @param resourceDao
	 * @see
	 */
	public void setResourceDao(IResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	/**
	 * get
	 */
	@Override
	public IFunction get(String uri) {
		// test
		// ResourceEntity resourceEntity = new ResourceEntity();
		// resourceEntity.setActive("Y");
		// resourceEntity.setCode("test");
		// resourceEntity.setName("测试");
		// resourceEntity.setEntryUri(uri);
		// return resourceDao.getResourceByUri(uri);
		return resourceDao.getcurResourceByURI(uri);

	}
}
