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
 * FILE PATH        	: src/main/java/com/deppon/foss/module/base/baseinfo/api/server/service/IRoleService.java
 * 
 * FILE NAME        	: IRoleService.java
 * 
 * AUTHOR			: FOSS综合管理开发组
 * 
 * HOME PAGE		:  http://www.deppon.com
 * 
 * COPYRIGHT		: Copyright (c) 2013  Deppon All Rights Reserved.
 ******************************************************************************/
package com.deppon.dpm.uums.server.service;

import java.util.List;

import com.deppon.dpm.uums.server.domain.ResourceEntity;
import com.deppon.dpm.uums.server.vo.AppRoleResourceVo;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.service.IService;

/**
 * 
* @ClassName: IRoleService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author yuyongxiang-134019-yuyongxiang@deppon.com
* @date 2014年8月26日 上午8:09:43 
*
 */
public interface IRoleResourceService extends IService {
  
	/**
	 * 
	 * @Title: insertOrUpdateOne 
	 *
	 * @Description: 插入一条功能类数据(或 修改一条数据)
	 *
	 * @author 134019-yuyongxiang@deppon.com
	 *
	 * @date 2014年8月25日 上午10:28:09 
	 *
	 * @param resourceEntity
	 * @return int    返回类型 
	 *
	 * @throws 
	 * @see yu
	 */
	public int insertOrUpdateOne(AppRoleResourceVo vo) throws BusinessException;
	
	/**
	 * 
	 * @Title: selectlimit 
	 *
	 * @Description: 根据分页查询所有的 功能类数据
	 *
	 * @author 134019-yuyongxiang@deppon.com
	 *
	 * @date 2014年8月25日 下午5:10:33 
	 *
	 * @param map
	 * @return List<ResourceEntity> 
	 * @throws BusinessException 
	 *
	 * @throws 
	 * @see yu
	 */
	public List<ResourceEntity> selectRolelimit(String id) throws BusinessException;
	/**
	 * 
	 * @Title: selectlimit 
	 *
	 * @Description: 根据分页查询所有的 功能类数据
	 *
	 * @author 134019-yuyongxiang@deppon.com
	 *
	 * @date 2014年8月25日 下午5:10:33 
	 *
	 * @param map
	 * @return List<ResourceEntity> 
	 * @throws BusinessException 
	 *
	 * @throws 
	 * @see yu
	 */
	public List<ResourceEntity> selectlimit(String id) throws BusinessException;
}
