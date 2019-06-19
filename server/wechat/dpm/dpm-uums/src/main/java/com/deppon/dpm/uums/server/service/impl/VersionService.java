/**
 * Project Name:dpm-uums
 * File Name:RoleService.java
 * Package Name:com.deppon.dpm.uums.server.service.impl
 * Date:2014-8-16下午7:21:17
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.deppon.dpm.uums.server.service.impl;

import java.util.List;

import com.deppon.dpm.uums.server.dao.IVersionDao;
import com.deppon.dpm.uums.server.domain.VersionEntity;
import com.deppon.dpm.uums.server.service.IVersionService;
import com.deppon.foss.framework.exception.BusinessException;


/**
 * 
* @ClassName: VersionService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author yuyongxiang-134019-yuyongxiang@deppon.com
* @date 2014年8月26日 上午8:11:23 
*
 */
public class VersionService implements IVersionService{
	
	/**
	 * 
	 */
	private IVersionDao versionDao;
	

	/** 
	* @Title: insertOrUpdateOne 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author yuyongxiang-134019-yuyongxiang@deppon.com
	* @date 2014年8月26日 上午8:10:39 
	* @param @param resourceEntity
	* @param @return
	* @param @throws BusinessException    设定文件 
	* @throws 
	*/
	@Override
	public String updateVersion(VersionEntity entity)
			throws BusinessException {
		return versionDao.updateVersion(entity);
	}

	/** 
	* @Title: selectlimit 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author yuyongxiang-134019-yuyongxiang@deppon.com
	* @date 2014年8月26日 上午8:10:39 
	* @param @param map
	* @param @return
	* @param @throws BusinessException    设定文件 
	* @throws 
	*/
	@Override
	public List<VersionEntity> selectVersions()
			throws BusinessException {
		List<VersionEntity> list = versionDao.selectVersions();
		return list;
	}


	/********************* getter and setter *************************/
	
	

	

	public IVersionDao getVersionDao() {
		return versionDao;
	}

	public void setVersionDao(IVersionDao versionDao) {
		this.versionDao = versionDao;
	}

}

