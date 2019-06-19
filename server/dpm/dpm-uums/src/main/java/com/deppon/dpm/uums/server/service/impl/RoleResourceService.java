/**
 * Project Name:dpm-uums
 * File Name:RoleService.java
 * Package Name:com.deppon.dpm.uums.server.service.impl
 * Date:2014-8-16下午7:21:17
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.deppon.dpm.uums.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;
import com.deppon.dpm.uums.server.dao.ILogDao;
import com.deppon.dpm.uums.server.dao.IRoleResourceDao;
import com.deppon.dpm.uums.server.domain.LogEntity;
import com.deppon.dpm.uums.server.domain.ResourceEntity;
import com.deppon.dpm.uums.server.domain.RoleEntity;
import com.deppon.dpm.uums.server.domain.RoleResourceEntity;
import com.deppon.dpm.uums.server.service.IResourceService;
import com.deppon.dpm.uums.server.service.IRoleResourceService;
import com.deppon.dpm.uums.server.service.IRoleService;
import com.deppon.dpm.uums.server.vo.AppRoleResourceVo;
import com.deppon.foss.framework.cache.CacheManager;
import com.deppon.foss.framework.entity.IUser;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.context.UserContext;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * 
 * @ClassName: RoleService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yuyongxiang-134019-yuyongxiang@deppon.com
 * @date 2014年8月26日 上午8:11:23
 *
 */
public class RoleResourceService implements IRoleResourceService {

	/**
	 * 
	 */
	private IRoleResourceDao roleResourceDao;
	private IResourceService resourceService;
	private IRoleService roleService;
	private ILogDao logDao;

	/**
	 * @Title: insertOrUpdateOne
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author yuyongxiang-134019-yuyongxiang@deppon.com
	 * @date 2014年8月26日 上午8:10:39
	 * @param @param resourceEntity
	 * @param @return
	 * @param @throws BusinessException 设定文件
	 * @throws
	 */
	@Override
	public int insertOrUpdateOne(AppRoleResourceVo vo)
			throws BusinessException {
		int i = 0;
		//查出所有的老的权限数据
		List<ResourceEntity>  resourceList=new ArrayList<ResourceEntity>();
		
		resourceList=this.selectRolelimit(vo.getRoleEntity().getId());
		
		UserEntity user = (UserEntity) (UserContext.getCurrentUser());
		
		Map<String, Object> map = new HashMap<String, Object>(1);
		
		map.put("id", vo.getRoleEntity().getId());

		//根据老的code老的关联关系数据
		List<RoleEntity> rolelist = roleService.selectlimit(map);
		RoleEntity roleEntity =rolelist.get(0);
		
		//删除老的历史数据
		RoleResourceEntity roleResourceEntity=new RoleResourceEntity();
		roleResourceEntity.setRoleCode(roleEntity.getCode());
		roleResourceDao.deleteRoleResourceByRoleCode(roleResourceEntity);

		//插入新的权限数据
		roleService.insertOrUpdateOne(vo.getRoleEntity());
		
		if(CollectionUtils.isNotEmpty(vo.getResourceList())){
			
			for(ResourceEntity re: vo.getResourceList()){
				
				roleResourceEntity=new RoleResourceEntity();
				
				//设置功能code
				roleResourceEntity.setResourceCode(re.getCode());
				//设置权限code
				roleResourceEntity.setRoleCode(vo.getRoleEntity().getCode());
				//设置创建user
				roleResourceEntity.setCreateUser(user.getEmpCode());
				
				//处理空格
				roleResourceEntity.setResourceCode(StringUtil.trim(roleResourceEntity.getResourceCode()));
				roleResourceEntity.setRoleCode(StringUtil.trim(roleResourceEntity.getRoleCode()));
				
				roleResourceDao.addRoleResource(roleResourceEntity);
			}
		}
		
		//处理日志
		LogEntity log = new LogEntity();
		
		//sonar 整改
//		String oldContent="";
//		String newContent="";
//		for (ResourceEntity entity : resourceList) {
//			oldContent+=entity.getName()+",";
//		}
//		
//		for (ResourceEntity entity : vo.getResourceList()) {
//			newContent+=entity.getName()+",";
//		}
//		oldContent=oldContent.substring(0, oldContent.length()-1);
//		newContent=newContent.substring(0, newContent.length()-1);
		
		StringBuilder oldContents = new StringBuilder();
		StringBuilder newContents = new StringBuilder();
		for (ResourceEntity entity : resourceList) {
			if(0 != oldContents.length())
				oldContents.append(",");
			oldContents.append(entity.getName());
		}
		for (ResourceEntity entity : vo.getResourceList()) {
			if(0 != newContents.length())
				newContents.append(",");
			newContents.append(entity.getName());
		}
		String oldContent=oldContents.toString();
		String newContent=newContents.toString();
		
		//如果新数据没有老数据有那么则是删除权限
		if(CollectionUtils.isEmpty(vo.getResourceList()) || CollectionUtils.isNotEmpty(resourceList)){
			log.setCode("delete");
			log.setName("删除");
			log.setContent("删除角色所有的权限! 权限:" +oldContent);
		}else if(CollectionUtils.isNotEmpty(vo.getResourceList()) || CollectionUtils.isEmpty(resourceList)){
			log.setCode("add");
			log.setName("新增");
			log.setContent("新增角色权限! 权限:"+newContent);
		}else if(CollectionUtils.isNotEmpty(vo.getResourceList()) || CollectionUtils.isNotEmpty(resourceList)){
			log.setCode("update");
			log.setName("修改");
			log.setContent("修改角色权限 原权限: "+oldContent + " 新权限: " +newContent);
		}
		
		log.setUserCode(user.getEmpCode());
		log.setUserName(user.getEmpName());
		log.setOrganizationName(user.getOrganization().getOrgName());
		log.setOrganizationCode(user.getOrganization().getOrgCode());
		logDao.insert(log);
		
		CacheManager.getInstance().getCache(IUser.class.getName()).invalid();
		return i;
	}

	/**
	 * @Title: selectlimit
	 * @Description: 去掉已经配置的功能
	 * @author yuyongxiang-134019-yuyongxiang@deppon.com
	 * @date 2014年8月26日 上午8:10:39
	 * @param @param map
	 * @param @return
	 * @param @throws BusinessException 设定文件
	 * @throws
	 */
	@Override
	public List<ResourceEntity> selectlimit(String id) throws BusinessException {

		Map<String, Object> map = new HashMap<String, Object>(1);

		RoleResourceEntity roleResourceEntity = new RoleResourceEntity();
		if (StringUtil.isNotBlank(id)) {

			map.put("id", id);

			List<RoleEntity> rolelist = roleService.selectlimit(map);
			if (rolelist.size() != 1) {
				return new ArrayList<ResourceEntity>(0);
			}
			RoleEntity roleEntity = rolelist.get(0);

			roleResourceEntity.setRoleCode(roleEntity.getCode());
		}
		List<RoleResourceEntity> list = roleResourceDao
				.queryRoleResourceByEntity(roleResourceEntity);

		map.clear();
		List<ResourceEntity> resourceList = resourceService.selectlimit(map);

		if (CollectionUtils.isEmpty(list) || StringUtil.isBlank(id)) {
			return resourceList;
		} else if (CollectionUtils.isNotEmpty(resourceList)) {
			List<ResourceEntity> resourceListTemp = new ArrayList<ResourceEntity>();
			boolean bool = true;
			for (ResourceEntity entity : resourceList) {
				bool = true;
				for (RoleResourceEntity rr : list) {
					if (StringUtil.equals(rr.getResourceCode(),
							entity.getCode())) {
						bool = false;
						break;
					}
				}
				if (bool) {
					resourceListTemp.add(entity);
				}

			}

			return resourceListTemp;

		}

		return resourceList;
	}

	/**
	 * @Title: selectRolelimit
	 * @Description: 获取已经配置的功能
	 * @author yuyongxiang-134019-yuyongxiang@deppon.com
	 * @date 2014年8月26日 下午12:41:55
	 * @param @return
	 * @param @throws BusinessException 设定文件
	 * @throws
	 */
	@Override
	public List<ResourceEntity> selectRolelimit(String id)
			throws BusinessException {
		Map<String, Object> map = new HashMap<String, Object>(1);
		List<ResourceEntity> resourceListTemp = new ArrayList<ResourceEntity>();

		RoleResourceEntity roleResourceEntity = new RoleResourceEntity();
		if (StringUtil.isNotBlank(id)) {

			map.put("id", id);

			List<RoleEntity> rolelist = roleService.selectlimit(map);
			if (rolelist.size() != 1) {
				return resourceListTemp;
			}
			RoleEntity roleEntity = rolelist.get(0);

			roleResourceEntity.setRoleCode(roleEntity.getCode());
		}
		List<RoleResourceEntity> list = roleResourceDao
				.queryRoleResourceByEntity(roleResourceEntity);

		map.clear();
		List<ResourceEntity> resourceList = resourceService.selectlimit(map);


		if (CollectionUtils.isEmpty(list) || StringUtil.isBlank(id)) {
			return resourceListTemp;
		} else if (CollectionUtils.isNotEmpty(resourceList)) {
			for (ResourceEntity entity : resourceList) {
				for (RoleResourceEntity rr : list) {
					if (StringUtil.equals(rr.getResourceCode(),
							entity.getCode())) {
						resourceListTemp.add(entity);
						break;
					}
				}

			}
			return resourceListTemp;
		}

		return resourceListTemp;
	}

	/********************* getter and setter *************************/

	/**
	 * @return roleResourceDao
	 */
	public IRoleResourceDao getRoleResourceDao() {
		return roleResourceDao;
	}

	/**
	 * @param roleResourceDao
	 *            要设置的 roleResourceDao
	 */
	public void setRoleResourceDao(IRoleResourceDao roleResourceDao) {
		this.roleResourceDao = roleResourceDao;
	}

	/**
	 * @return resourceService
	 */
	public IResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * @param resourceService
	 *            要设置的 resourceService
	 */
	public void setResourceService(IResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * @return roleService
	 */
	public IRoleService getRoleService() {
		return roleService;
	}

	/**
	 * @param roleService
	 *            要设置的 roleService
	 */
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	/** 
	 * @return logDao 
	 */
	public ILogDao getLogDao() {
		return logDao;
	}

	/** 
	 * @param logDao 要设置的 logDao 
	 */
	public void setLogDao(ILogDao logDao) {
		this.logDao = logDao;
	}

}
