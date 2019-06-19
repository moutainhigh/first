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
import java.util.Map;

import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;
import com.deppon.dpm.uums.server.dao.IRoleDao;
import com.deppon.dpm.uums.server.domain.RoleEntity;
import com.deppon.dpm.uums.server.util.UUIDUtils;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
import com.deppon.foss.framework.server.context.UserContext;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * ClassName:RoleDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * 
 * Date:     2014-8-16 下午7:23:13 <br/>
 * @author   157229-zxy
 * @version  
 * @since    JDK 1.6
 */
public class RoleDao extends iBatis3DaoImpl implements IRoleDao{
	//命名空间
	private String NAMESPACE = "com.deppon.dpm.uums.server.dao.roleEntityMapper.";

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
	public String insert(RoleEntity entity) {
		//封装基础数据
		if(null == entity){
			return "-1";
		}
		
		//设置ID
		entity.setId(UUIDUtils.getUUID());
		entity.setCreateDate(new Date());
		entity.setModifyDate(new Date());
		entity.setActive("Y");
		//版本号
		if(null == entity.getVersionNo() || entity.getVersionNo()<1){
			entity.setVersionNo(1L);
		}else{
			entity.setVersionNo(entity.getVersionNo() + 1L);
		}
		//
		if(StringUtil.isBlank(entity.getUUID())){
			entity.setUUID(UUIDUtils.getUUID());
		}
		
		this.getSqlSession().insert(NAMESPACE + "addRole", entity );
		return entity.getId();
	}

	/** 
	* @Title: updateFuncrionResource 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author yuyongxiang-134019-yuyongxiang@deppon.com
	* @date 2014年8月25日 下午2:22:54 
	* @param @param resourceEntity
	* @param @return    设定文件 
	* @throws 
	*/
	@Override
	public RoleEntity selectRoleActiveWithNo(RoleEntity entity) {
		//这个地方确保不能传入当前数据的状态
		return (RoleEntity) this.getSqlSession().selectOne(NAMESPACE + "selectRoleActiveWithNo", entity);
	}

	/** 
	* @Title: deleteFuncrionResource 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author yuyongxiang-134019-yuyongxiang@deppon.com
	* @date 2014年8月25日 下午2:22:54 
	* @param @param id
	* @param @return    设定文件 
	* @throws 
	*/
	@Override
	public int deleteRole(String id) {
		RoleEntity entity=new RoleEntity();
		UserEntity user = (UserEntity) (UserContext.getCurrentUser());
		//这个地反确认至修改状态和跟新时间
		entity.setId(id);
		entity.setActive("N");
		entity.setModifyDate(new Date());
		entity.setModifyUser(user.getEmpCode());
				
		return this.getSqlSession().insert(NAMESPACE + "updateRole", entity);
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
	public List<RoleEntity> selectlimit(Map<String, Object> map)
			throws BusinessException {
		map.put("active", "Y");
		return this.getSqlSession().selectList(NAMESPACE + "selectlimit", map);
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
	@Override
	public Long selectlimitCount(Map<String, Object> map)
			throws BusinessException {
		map.put("active", "Y");
		return (Long) this.getSqlSession().selectOne(NAMESPACE + "selectlimitCount", map);
	}

}

