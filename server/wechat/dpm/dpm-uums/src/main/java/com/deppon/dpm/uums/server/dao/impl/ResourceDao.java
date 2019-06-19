/**
 * Project Name:dpm-uums
 * File Name:ResourceDao.java
 * Package Name:com.deppon.dpm.uums.server.dao.impl
 * Date:2014-8-16下午7:22:56
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.deppon.dpm.uums.server.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;
import com.deppon.dpm.uums.server.dao.IResourceDao;
import com.deppon.dpm.uums.server.domain.ResourceEntity;
import com.deppon.dpm.uums.server.util.UUIDUtils;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
import com.deppon.foss.framework.server.context.UserContext;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * ClassName:ResourceDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * 
 * Date:     2014-8-16 下午7:22:56 <br/>
 * @author   157229-zxy
 * @version  
 * @since    JDK 1.6
 */
public class ResourceDao extends iBatis3DaoImpl implements IResourceDao{

	//命名空间
	private static final String NAMESPACE = "com.deppon.dpm.uums.server.dao.resourceEntityMapper.";
	//查询最新的同步记录
//	private static final String QUERY_RESOURCES_BY_PARENT_CODE = "queryResourcesByParentCode";
	private static final String GET_RESOURCE_BY_URL = "getResourceByURI";
	private static final String GET_DIRECT_CHILD_RESOURCE_BY_CODE = "getDirectChildResourceByCode";
	
	@Override
	public List<ResourceEntity> getDirectChildResourceByCode(String parentCode) {
		Map<String,String> params = new HashMap<String, String>();
		params.put("parentCode", parentCode);
		params.put("parentActive", "Y");
		params.put("resActive", "Y");
		return this.getSqlSession().selectList(NAMESPACE + GET_DIRECT_CHILD_RESOURCE_BY_CODE, params);
	}

	@Override
	public ResourceEntity getResourceByUri(String uri) {
		Map<String,String> params = new HashMap<String, String>();
		params.put("uri", uri);
		params.put("resActive", "Y");
		params.put("parentActive", "Y");
		return (ResourceEntity) this.getSqlSession().selectOne(NAMESPACE + GET_RESOURCE_BY_URL, params);
	}

	@Override
	public ResourceEntity getcurResourceByURI(String uri) {
		Map<String,String> params = new HashMap<String, String>();
		params.put("uri", uri);
		params.put("resActive", "Y");
		params.put("parentActive", "Y");
		return (ResourceEntity) this.getSqlSession().selectOne(NAMESPACE + "getcurResourceByURI", params);
	}
	
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
	public int insert(ResourceEntity resourceEntity) {
		//封装基础数据
		if(null == resourceEntity){
			return -1;
		}
		
		//设置ID
		resourceEntity.setId(UUIDUtils.getUUID());
		resourceEntity.setEntryUri(null);
		resourceEntity.setResLevel("2");
		resourceEntity.setParentResString("1");
		resourceEntity.setDisplayOrder("0");
		resourceEntity.setChecked("Y");
		resourceEntity.setResType("4");
		resourceEntity.setLeafFlag("Y");
		resourceEntity.setIconCls(null);
		resourceEntity.setCls(null);
		resourceEntity.setCreateDate(new Date());
		resourceEntity.setModifyDate(new Date());
		resourceEntity.setActive("Y");
		//版本号
		if(null == resourceEntity.getVersionNo() || resourceEntity.getVersionNo()<1){
			resourceEntity.setVersionNo(1L);
		}else{
			resourceEntity.setVersionNo(resourceEntity.getVersionNo() + 1L);
		}
		resourceEntity.setBelongSystemType("BPM_APP");
		//
		if(StringUtil.isBlank(resourceEntity.getUUID())){
			resourceEntity.setUUID(UUIDUtils.getUUID());
		}
		
		this.getSqlSession().insert(NAMESPACE + "addResource", resourceEntity );
		return 0;
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
	public ResourceEntity selectFuncrionResourceActiveWithNo(ResourceEntity resourceEntity) {
		//这个地方确保不能传入当前数据的状态
		return (ResourceEntity) this.getSqlSession().selectOne(NAMESPACE + "selectFuncrionResourceActiveWithNo", resourceEntity);
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
	public int deleteFuncrionResource(String id) {
		ResourceEntity resourceEntity=new ResourceEntity();
		UserEntity user = (UserEntity) (UserContext.getCurrentUser());
		//这个地反确认至修改状态和跟新时间
		resourceEntity.setId(id);
		resourceEntity.setActive("N");
		resourceEntity.setModifyDate(new Date());
		resourceEntity.setModifyUser(user.getEmpCode());
				
		return this.getSqlSession().insert(NAMESPACE + "updateFuncrionResource", resourceEntity );
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
	public List<ResourceEntity> selectlimit(Map<String, Object> map)
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

