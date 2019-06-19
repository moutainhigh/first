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
import java.util.Map;

import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;
import com.deppon.dpm.uums.server.dao.ILogDao;
import com.deppon.dpm.uums.server.dao.IRoleDao;
import com.deppon.dpm.uums.server.dao.IRoleResourceDao;
import com.deppon.dpm.uums.server.domain.LogEntity;
import com.deppon.dpm.uums.server.domain.RoleEntity;
import com.deppon.dpm.uums.server.domain.RoleResourceEntity;
import com.deppon.dpm.uums.server.service.IRoleService;
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
public class RoleService implements IRoleService{
	
	/**
	 * 
	 */
	private IRoleDao roleDao;
	private IRoleResourceDao roleResourceDao;
	private ILogDao logDao;
	

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
	public String insertOrUpdateOne(RoleEntity entity)
			throws BusinessException {
		
		String str = "add";
		String content = "";
		//设置用户名
		UserEntity user = (UserEntity) (UserContext.getCurrentUser());
		
		entity.setModifyUser(user.getEmpCode());
		entity.setCreateUser(user.getEmpCode());
		//如果数据不为空则证明是修改操作所以要逻辑删除以前的记录
		if(StringUtil.isNotBlank(entity.getId())){
			//先逻辑删除数据
			roleDao.deleteRole(entity.getId());
			//再根据ID查询必须的数据
			RoleEntity entityTemp = roleDao.selectRoleActiveWithNo(entity);
			content = entityTemp.getName() + " : "
					+ entityTemp.getCode();
			//设置数据数据唯一的ID(这个唯一是确认唯一一组数据)
			entityTemp.setUUID(entityTemp.getUUID());
			//设置版本号
			entityTemp.setVersionNo(entityTemp.getVersionNo());
			
			//在删除关联数据
			//删除老的历史数据
			RoleResourceEntity roleResourceEntity=new RoleResourceEntity();
			roleResourceEntity.setRoleCode(entityTemp.getCode());
			roleResourceDao.deleteRoleResourceByRoleCode(roleResourceEntity);
			str = "update";
		}
		//添加功能数据
		//做空格处理
		entity.setCode(StringUtil.trim(entity.getCode()));
		entity.setName(StringUtil.trim(entity.getName()));
		String id =roleDao.insert(entity);
		
		
		LogEntity log = new LogEntity();

		if (str.equals("update")) {
			log.setContent("把 " + content + " 内容跟新成 "
					+ entity.getName() + " : "
					+ entity.getCode() + " .");
			log.setName("修改");
		} else {
			log.setName("新增");
			log.setContent("新增 " + entity.getName() + " : "
					+ entity.getCode() + " .");
		}
		log.setCode(str);
		log.setUserCode(user.getEmpCode());
		log.setUserName(user.getEmpName());
		log.setOrganizationName(user.getOrganization().getOrgName());
		log.setOrganizationCode(user.getOrganization().getOrgCode());
		logDao.insert(log);
		
		
		
		//清楚缓存
		CacheManager.getInstance().getCache(IUser.class.getName()).invalid();
		return id;
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
	public List<RoleEntity> selectlimit(Map<String, Object> map)
			throws BusinessException {
		List<RoleEntity> list = roleDao.selectlimit(map);
		return list;
	}

	/** 
	* @Title: selectlimitCount 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author yuyongxiang-134019-yuyongxiang@deppon.com
	* @date 2014年8月26日 上午8:10:39 
	* @param @param map
	* @param @return
	* @param @throws BusinessException    设定文件 
	* @throws 
	*/
	@Override
	public Long selectlimitCount(Map<String, Object> map)
			throws BusinessException {
		return roleDao.selectlimitCount(map);
	}

	/** 
	* @Title: deleteFuncrionResource 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author yuyongxiang-134019-yuyongxiang@deppon.com
	* @date 2014年8月26日 上午8:10:39 
	* @param @param id
	* @param @return
	* @param @throws BusinessException    设定文件 
	* @throws 
	*/
	@Override
	public int deleteRole(String id) throws BusinessException {
		
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
		
		return roleDao.deleteRole(id);
	}

	/********************* getter and setter *************************/
	
	public IRoleDao getRoleDao() {
		return roleDao;
	}
	
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	/** 
	 * @return roleResourceDao 
	 */
	public IRoleResourceDao getRoleResourceDao() {
		return roleResourceDao;
	}

	/** 
	 * @param roleResourceDao 要设置的 roleResourceDao 
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
	 * @param logDao 要设置的 logDao 
	 */
	public void setLogDao(ILogDao logDao) {
		this.logDao = logDao;
	}
}

