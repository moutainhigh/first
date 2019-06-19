package com.deppon.dpm.uums.server.dao;

import java.util.List;

import com.deppon.dpm.uums.server.domain.RoleResourceEntity;

/**
 * 角色权限 DAO接口
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2014-8-19 上午11:36:51 <br/>
 *
 * @author 157229-zxy
 * @version 
 * @since JDK 1.6
 */
public interface IRoleResourceDao {
    /**
     * 插入
     * 
     */
    RoleResourceEntity addRoleResource(RoleResourceEntity entity);

    /**
     * 根据VIRTUAL_CODE删除
     * 
     */
    RoleResourceEntity deleteRoleResource(RoleResourceEntity entity);

    /**
     * 根据VIRTUAL_CODE批量删除 
     * 
     */
    RoleResourceEntity deleteRoleResourceMore(String[] codes , String deleteUser);
	
    /**
     * 更新 
     * 
     */
    RoleResourceEntity updateRoleResource(RoleResourceEntity entity);
	
	
	
    /**
     * 以下全为查询 
     */
	
    /**
     * 精确查询
     * 根据VIRTUAL_CODE 查询
     * 
     */
    RoleResourceEntity queryRoleResourceByVirtualCode(String code);	
	
	
    /**
     * 精确查询
     * 根据多个VIRTUAL_CODE 查询
     * 
     * @see com.deppon.foss.module.base.dict.api.server.dao.IRoleResourceDao#queryRoleResourceByCode(java.lang.String)
     */
    List<RoleResourceEntity> queryRoleResourceBatchByVirtualCode(String[] codes);
    
    /**
     * 精确查询
     * 动态的查询条件。 如果传入的对象为空，传入一个对象，可查出所有的数据，如果传入的对象的属性不为空或者空白，则设置为查询条件
     *
     */
    List<RoleResourceEntity> queryRoleResourceExactByEntity(
	    RoleResourceEntity entity, int start, int limit) ;
    
    /**
     * 精确查询-查询总条数，用于分页
     * 动态的查询条件。 如果传入的对象为空，传入一个对象，可查出所有的数据，如果传入的对象的属性不为空或者空白，则设置为查询条件
     * 
     */
    long queryRoleResourceExactByEntityCount(RoleResourceEntity entity);
	
    /**
     * 根据entity模糊查询，
     * 
     */
    List<RoleResourceEntity> queryRoleResourceByEntity(RoleResourceEntity entity);
	
    /**
     * 查询queryRoleResourceByEntity返回的记录总数,用于分页
     * 
     */
    long queryRoleResourceByEntityCount(RoleResourceEntity entity);
		
	
    
    /**
     * 下面为特殊方法
     */
    
    /**
     * 根据ROLE_CODE删除
     * 
     */
    RoleResourceEntity deleteRoleResourceByRoleCode(RoleResourceEntity entity);
	
    
    /**
     * 特殊删除
     * 根据ROLE_CODE, RESOURCE_CODE删除
     * 
     */
    RoleResourceEntity deleteRoleResourceByRoleResource(RoleResourceEntity entity);
    /**
     * 特殊删除
     * 根据 RESOURCE_CODE删除
     * 
     */
    RoleResourceEntity deleteRoleResourceByResourceCode(RoleResourceEntity entity);
    
    
    /**
     * 根据entity精确查询,用于数据下载
     * entity里面根据表结构，要动态（可不传入）传入MODIFY_TIME,员工编号，部门编号,
     * 
     */
    List<RoleResourceEntity> queryRoleResourceForDownload(RoleResourceEntity entity);
    
    /**
     * 特殊查询，精确查询
     * 根据多个标识和列名批量查询
     * 
     * @see com.deppon.foss.module.base.baseinfo.api.server.dao.IRoleResourceDao#queryRoleResourceBatchBy(java.lang.String[])
     */
    List<RoleResourceEntity> queryRoleResourceMoreByColumnName(
	    String[] codes, String columnName);
    /**
     * 
     * <p>查询用户拥有的所有权限</p> 
     * @return
     * @see
     */
    List<RoleResourceEntity> queryRoleResourceExactByEntity(RoleResourceEntity roleResource);

	/**
	 * 根据entity精确查询,用于数据下载分页
     * entity里面根据表结构，要动态（可不传入）传入MODIFY_TIME,员工编号，部门编号,
	 * @param entity
	 * @param i
	 * @param thousand
	 * @return
	 */
    List<RoleResourceEntity>  queryRoleResourceForDownloadByPage(RoleResourceEntity entity, int started,
			int limited);

    /**
     * 根据角色查询对应的功能权限
     * @param roles
     * @return
     */
	List<RoleResourceEntity> queryRoleResourceExactByRoles(List<String> roles);
    
}
