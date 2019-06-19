package com.deppon.dpm.uums.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.uums.server.domain.RoleEntity;
import com.deppon.foss.framework.exception.BusinessException;


/**
 * 
* @ClassName: IRoleDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author yuyongxiang-134019-yuyongxiang@deppon.com
* @date 2014年8月26日 上午8:13:02 
*
 */
public interface IRoleDao {
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
	public String insert(RoleEntity entity);
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
	public RoleEntity selectRoleActiveWithNo(RoleEntity entity);
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
	public int deleteRole(String id) throws BusinessException;
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
	public List<RoleEntity> selectlimit(Map<String, Object> map) throws BusinessException;
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

