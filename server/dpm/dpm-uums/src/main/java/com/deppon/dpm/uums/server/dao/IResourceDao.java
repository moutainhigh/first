package com.deppon.dpm.uums.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.uums.server.domain.ResourceEntity;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 权限 DAO 接口
 * 
 * date: 2014-8-19 上午11:36:18 <br/>
 *
 * @author 157229-zxy
 * @version 
 * @since JDK 1.6
 */
public interface IResourceDao {

	public List<ResourceEntity> getDirectChildResourceByCode(String parentCode);
	
	public ResourceEntity getResourceByUri(String uri);
	
	public ResourceEntity getcurResourceByURI(String uri);
	
	/**
	 * 
	 * @Title: insert 
	 *
	 * @Description: 插入一条功能数据(除了name,code,notes,createUserCode,modifUserCode 这五个参数是前台穿过来的不做变更其他的都赋值初始化值)
	 *
	 * @author 134019-yuyongxiang@deppon.com
	 *
	 * @date 2014年8月25日 上午10:05:34 
	 *
	 * @param resourceEntity
	 * @return int 
	 *
	 * @throws 
	 * @see yu
	 */
	public int insert(ResourceEntity resourceEntity);
	/**
	 * 
	 * @Title: updateFuncrionResource 
	 *
	 * @Description: 根据id查询版本号和当前数据版本的唯一标识UUID(此ID不是单条数据的ID而是整个数据链的ID)
	 *
	 * @author 134019-yuyongxiang@deppon.com
	 *
	 * @date 2014年8月25日 下午2:20:52 
	 *
	 * @param resourceEntity
	 * @return int    返回类型 
	 *
	 * @throws 
	 * @see yu
	 */
	public ResourceEntity selectFuncrionResourceActiveWithNo(ResourceEntity resourceEntity);
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
	public Long selectlimitCount(Map<String, Object> map) throws BusinessException;

}
