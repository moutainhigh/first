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
 * FILE PATH        	: src/main/java/com/deppon/foss/module/base/baseinfo/server/cache/UserCacheProvider.java
 * 
 * FILE NAME        	: UserCacheProvider.java
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

import java.util.List;

import com.deppon.dpm.login.server.service.ILoginService;
import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;
import com.deppon.foss.framework.cache.provider.ITTLCacheProvider;
import com.deppon.foss.framework.entity.IUser;
import com.deppon.foss.framework.server.context.SessionContext;

/**
 * 用户信息生产者 ClassName: UserCacheProvider <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2014-8-19 上午10:17:10 <br/>
 * 
 * @author 157229-zxy
 * @version
 * @since JDK 1.6
 */
public class UserCacheProvider implements ITTLCacheProvider<IUser> {
	/**
	 * set injection
	 */
	private ILoginService loginService;

	/**
	 * 从数据库加载数据到缓存中
	 * 
	 * @see com.deppon.foss.framework.cache.provider.ITTLCacheProvider#get(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public IUser get(String key) {
		// 用户信息
		UserEntity userEntity = null;
		// 从sesseion中获取
		List<String> roles = (List<String>) SessionContext.getSession().getObject("FOSS_KEY_CURRENT_ROLES");
		// 查询
		userEntity = loginService.queryUser(key, roles);
		// 返回
		return userEntity;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public ILoginService getLoginService() {
		return loginService;
	}

	/**
	 * set
	 * 
	 * @param loginService
	 */
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

}
