/**
 * Project Name:dpm-uums
 * File Name:ResourceService.java
 * Package Name:com.deppon.dpm.uums.server.service.impl
 * Date:2014-8-16下午8:41:50
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.deppon.dpm.uums.server.service.impl;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;
import com.deppon.dpm.uums.server.dao.ILogDao;
import com.deppon.dpm.uums.server.dao.IResourceDao;
import com.deppon.dpm.uums.server.dao.IRoleResourceDao;
import com.deppon.dpm.uums.server.domain.LogEntity;
import com.deppon.dpm.uums.server.domain.ResourceEntity;
import com.deppon.dpm.uums.server.domain.RoleResourceEntity;
import com.deppon.dpm.uums.server.service.IResourceService;
import com.deppon.foss.framework.cache.CacheManager;
import com.deppon.foss.framework.entity.IUser;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.context.UserContext;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * ClassName:ResourceService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * 
 * Date: 2014-8-16 下午8:41:50 <br/>
 * 
 * @author 157229-zxy
 * @version
 * @since JDK 1.6
 */
public class ResourceService implements IResourceService {

	private IResourceDao resourceDao;
	private IRoleResourceDao roleResourceDao;
	private ILogDao logDao;

	@Override
	public List<ResourceEntity> getDirectChildResourceByCode(String parentCode) {
		return resourceDao.getDirectChildResourceByCode(parentCode);
	}

	/**
	 * @Title: insertOrUpdateOne
	 * @Description: 插入一条功能类数据(或 修改一条数据)
	 * @author yuyongxiang-134019-yuyongxiang@deppon.com
	 * @date 2014年8月25日 上午10:48:32
	 * @param @param resourceEntity
	 * @param @return 设定文件
	 * @throws
	 */
//	@Transactional("transactionManager")
	@Override
	public int insertOrUpdateOne(ResourceEntity resourceEntity) {
		int i = 0;
		String str = "add";
		String content = "";
		// 设置用户名
		UserEntity user = (UserEntity) (UserContext.getCurrentUser());

		resourceEntity.setModifyUser(user.getEmpCode());
		resourceEntity.setCreateUser(user.getEmpCode());
		// 如果数据不为空则证明是修改操作所以要逻辑删除以前的记录
		if (StringUtil.isNotBlank(resourceEntity.getId())) {
			// 先逻辑删除数据
			resourceDao.deleteFuncrionResource(resourceEntity.getId());
			// 再根据ID查询必须的数据
			ResourceEntity resourceEntityTemp = resourceDao
					.selectFuncrionResourceActiveWithNo(resourceEntity);

			content = resourceEntityTemp.getName() + " : "
					+ resourceEntityTemp.getCode();
			// 设置数据数据唯一的ID(这个唯一是确认唯一一组数据)
			resourceEntity.setUUID(resourceEntityTemp.getUUID());
			// 设置版本号
			resourceEntity.setVersionNo(resourceEntityTemp.getVersionNo());
			// 在删除关联数据
			// 删除老的历史数据
			RoleResourceEntity roleResourceEntity = new RoleResourceEntity();
			roleResourceEntity.setResourceCode(resourceEntityTemp.getCode());
			roleResourceDao
					.deleteRoleResourceByResourceCode(roleResourceEntity);
			str = "update";
		}
		// 添加功能数据
		// 做空格处理
		resourceEntity.setCode(StringUtil.trim(resourceEntity.getCode()));
		resourceEntity.setName(StringUtil.trim(resourceEntity.getName()));
		i = resourceDao.insert(resourceEntity);

		LogEntity log = new LogEntity();

		if (str.equals("update")) {
			log.setContent("把 " + content + " 内容更新成 "
					+ resourceEntity.getName() + " : "
					+ resourceEntity.getCode() + " .");
			log.setName("修改");
		} else {
			log.setName("新增");
			log.setContent("新增 " + resourceEntity.getName() + " : "
					+ resourceEntity.getCode() + " .");
		}
		log.setCode(str);
		log.setUserCode(user.getEmpCode());
		log.setUserName(user.getEmpName());
		log.setOrganizationName(user.getOrganization().getOrgName());
		log.setOrganizationCode(user.getOrganization().getOrgCode());
		logDao.insert(log);

		// 清楚缓存
		CacheManager.getInstance().getCache(IUser.class.getName()).invalid();
		return i;
	}

	/**
	 * @Title: selectlimit
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author yuyongxiang-134019-yuyongxiang@deppon.com
	 * @date 2014年8月25日 下午5:15:12
	 * @param @param map
	 * @param @return
	 * @param @throws BusinessException 设定文件
	 * @throws
	 */
	@Override
	public List<ResourceEntity> selectlimit(Map<String, Object> map)
			throws BusinessException {
		List<ResourceEntity> list = resourceDao.selectlimit(map);
		return list;
	}

	/**
	 * @Title: selectlimitCoun=t
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author yuyongxiang-134019-yuyongxiang@deppon.com
	 * @date 2014年8月25日 下午5:15:12
	 * @param @param map
	 * @param @return
	 * @param @throws BusinessException 设定文件
	 * @throws
	 */
	@Override
	public Long selectlimitCount(Map<String, Object> map)
			throws BusinessException {
		return resourceDao.selectlimitCount(map);
	}

	/**
	 * @Title: deleteFuncrionResource
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author yuyongxiang-134019-yuyongxiang@deppon.com
	 * @date 2014年8月25日 下午9:07:52
	 * @param @param id
	 * @param @return
	 * @param @throws BusinessException 设定文件
	 * @throws
	 */
	@Override
//	@Transactional("transactionManager")
	public int deleteFuncrionResource(String id) throws BusinessException {

		UserEntity user = (UserEntity) (UserContext.getCurrentUser());
		LogEntity log = new LogEntity();

		log.setCode("delete");
		log.setName("删除");
		log.setContent("删除 " + id + " .");
		log.setUserCode(user.getEmpCode());
		log.setUserName(user.getEmpName());
		log.setOrganizationName(user.getOrganization().getOrgName());
		log.setOrganizationCode(user.getOrganization().getOrgCode());
		logDao.insert(log);
		
		return resourceDao.deleteFuncrionResource(id);
	}

	/************************ getter and setter ******************************/
	public IResourceDao getResourceDao() {
		return resourceDao;
	}

	public void setResourceDao(IResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

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
	 * @return logDao
	 */
	public ILogDao getLogDao() {
		return logDao;
	}

	/**
	 * @param logDao
	 *            要设置的 logDao
	 */
	public void setLogDao(ILogDao logDao) {
		this.logDao = logDao;
	}

}
