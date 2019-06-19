package com.deppon.dpm.uums.server.dao;

import java.util.List;

import com.deppon.dpm.uums.server.domain.VersionEntity;
import com.deppon.foss.framework.exception.BusinessException;


/**
 * 
* @ClassName: IRoleDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author yuyongxiang-134019-yuyongxiang@deppon.com
* @date 2014年8月26日 上午8:13:02 
*
 */
public interface IVersionDao {
	
	public String updateVersion(VersionEntity entity);
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
	public List<VersionEntity> selectVersions() throws BusinessException;
}

