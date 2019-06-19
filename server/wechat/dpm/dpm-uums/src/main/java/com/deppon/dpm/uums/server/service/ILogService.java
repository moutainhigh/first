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
 * PROJECT NAME	: dpm-uums
 * 
 * FILE PATH        	: /dpm-uums/src/main/java/com/deppon/dpm/uums/server/service/ILogService.java
 * 
 * FILE NAME        	: ILogService.java
 * 
 * AUTHOR			: yuyongxiang@deppon.com
 * 
 * HOME PAGE		:  http://www.deppon.com
 * 
 * COPYRIGHT		: Copyright (c) 2013  Deppon All Rights Reserved.
 ******************************************************************************/
package com.deppon.dpm.uums.server.service;

import com.deppon.dpm.uums.server.vo.AppLogVo;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.service.IService;

/**
 * 
* @ClassName: ILogService 
* @Description: 查询所有的操作日志
* @author yuyongxiang-134019-yuyongxiang@deppon.com
* @date 2014年09月18日15:48:46
*
 */
public interface ILogService extends IService {
  
		
	/**
	 * 
	 * @Title: select 
	 *
	 * @Description: 查询所有的操作日志
	 *
	 * @author 134019-yuyongxiang@deppon.com
	 *
	 * @date 2014年09月18日15:49:13
	 *
	 * @param resourceEntity
	 * @return int    返回类型 
	 *
	 * @throws 
	 * @see yu
	 */
	public AppLogVo  select(AppLogVo vo) throws BusinessException;
}
