/**
 * Project Name:dpm-uums
 * File Name:IResourceService.java
 * Package Name:com.deppon.dpm.uums.server.service
 * Date:2014-8-16下午8:40:27
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.deppon.dpm.uums.server.service;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.uums.server.domain.ResourceEntity;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * ClassName:IResourceService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * 
 * Date:     2014-8-16 下午8:40:27 <br/>
 * @author   157229-zxy
 * @version  
 * @since    JDK 1.6
 */
public interface IResourceService {
	/**
	 * 查询下一级资源
	 * getDirectChildResourceByCode: <br/>
	 * 
	 * Date:2014-8-16下午8:41:11
	 * @author 157229-zxy
	 * @param parentCode
	 * @return
	 * @since JDK 1.6
	 */
	List<ResourceEntity> getDirectChildResourceByCode(String parentCode);
	
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
	public int insertOrUpdateOne(ResourceEntity resourceEntity) throws BusinessException;
	
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
	public List<ResourceEntity> selectlimit(Map<String, Object> map) throws BusinessException;
	
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
	public  Long selectlimitCount(Map<String, Object> map) throws BusinessException;
	
	/**
	 * 
	 * @Title: deleteFuncrionResource 
	 *
	 * @Description: 根据 传进来的ID从逻辑上删除一条数据
	 *
	 * @author 134019-yuyongxiang@deppon.com
	 *
	 * @date 2014年8月25日 下午2:21:59 
	 *
	 * @param id
	 * @return int    返回类型 
	 *
	 * @throws 
	 * @see yu
	 */
	public int deleteFuncrionResource(String id) throws BusinessException;
}

