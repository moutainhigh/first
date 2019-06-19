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
 * PROJECT NAME	: bse-baseinfo-api
 * 
 * FILE PATH        	: src/main/java/com/deppon/foss/module/frameworkimpl/server/context/FossUserContext.java
 * 
 * FILE NAME        	: FossUserContext.java
 * 
 * AUTHOR			: FOSS综合管理开发组
 * 
 * HOME PAGE		:  http://www.deppon.com
 * 
 * COPYRIGHT		: Copyright (c) 2013  Deppon All Rights Reserved.
 ******************************************************************************/
package com.deppon.dpm.login.server.util;

import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;
import com.deppon.foss.framework.exception.security.UserNotLoginException;
import com.deppon.foss.framework.server.context.SessionContext;
import com.deppon.foss.framework.server.context.UserContext;

/**
 * FOSS系统当前用户上下文信息类
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2014-8-19 上午10:25:01 <br/>
 *
 * @author 157229-zxy
 * @version 
 * @since JDK 1.6
 */
public final class FossUserContext {
	
	/**
	 * Constructor，单例模式
	 */
	private FossUserContext() {
		super();
	}

	/**
	 * 获取当前会话的用户
	 * 
	 * @return UserEntity 当前用户
	 */
	public static UserEntity getCurrentUser() {
		UserEntity user = (UserEntity) (UserContext.getCurrentUser());
		if (user == null) {
			throw new UserNotLoginException();
		}
		return user;
	}

	/**
	 * 获取当前用户设置的当前部门编码 getCurrentDeptCode
	 * 
	 * @return String 当前部门编码
	 * @since:
	 */
	public static String getCurrentDeptCode() {
		return(String) SessionContext.getSession().getObject("FOSS_KEY_CURRENT_DEPTCODE");
	}
	
	/**
	 * 获取当前用户设置的当前部门名称 getCurrentDeptName
	 * 
	 * @return String 当前部门名称
	 * @since:
	 */
	public static String getCurrentDeptName() {
		return(String) SessionContext.getSession().getObject(Constants.FOSS_KEY_CURRENT_DEPTNAME);
	}

}
