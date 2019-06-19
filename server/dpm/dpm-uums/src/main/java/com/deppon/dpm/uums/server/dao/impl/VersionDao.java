/**
 * Project Name:dpm-uums
 * File Name:RoleDao.java
 * Package Name:com.deppon.dpm.uums.server.dao.impl
 * Date:2014-8-16下午7:23:13
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.deppon.dpm.uums.server.dao.impl;

import java.util.Date;
import java.util.List;

import com.deppon.dpm.uums.server.dao.IVersionDao;
import com.deppon.dpm.uums.server.domain.VersionEntity;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * ClassName:RoleDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * 
 * Date:     2014-8-16 下午7:23:13 <br/>
 * @author   157229-zxy
 * @version  
 * @since    JDK 1.6
 */
public class VersionDao extends iBatis3DaoImpl implements IVersionDao{
	//命名空间
	private String NAMESPACE = "com.deppon.dpm.uums.server.dao.versionEntityMapper.";

	/** 
	* @Title: insert 
	* @Description: 除了name,code,notes,createUserCode,modifUserCode 这五个参数是前台穿过来的不做变更其他的都赋值初始化值
	* @author yuyongxiang-134019-yuyongxiang@deppon.com
	* @date 2014年8月25日 上午10:07:03 
	* @param @param resourceEntity
	* @param @return    设定文件 
	* @throws 
	*/
	@Override
	public String updateVersion(VersionEntity entity) {
		//封装基础数据
		if(null == entity){
			return "-1";
		}
		
		//设置ID
		entity.setCreateDate(new Date());
		entity.setUpdateTime(new Date());
		
		this.getSqlSession().insert(NAMESPACE + "updateVersion", entity );
		return entity.getId();
	}

	/** 
	* @Title: selectlimit 
	* @Description: 根据分页查询所有的 功能类数据
	* @author yuyongxiang-134019-yuyongxiang@deppon.com
	* @date 2014年8月25日 下午5:11:32 
	* @param @param map
	* @param @return
	* @param @throws BusinessException    设定文件 
	* @throws 
	*/
	@SuppressWarnings("unchecked")
	@Override
	public List<VersionEntity> selectVersions()
			throws BusinessException {
		return this.getSqlSession().selectList(NAMESPACE + "selectVersion");
	}
}

