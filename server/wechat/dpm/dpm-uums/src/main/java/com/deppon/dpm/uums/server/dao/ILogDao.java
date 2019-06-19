package com.deppon.dpm.uums.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.uums.server.domain.LogEntity;
import com.deppon.foss.framework.exception.BusinessException;


/**
 * 
* @ClassName: IlogDao 
* @Description: 日志操作dao
* @author yuyongxiang-134019-yuyongxiang@deppon.com
* @date 2014年8月26日 上午8:13:02 
*
 */
public interface ILogDao {
	
	/**
	 * 
	 * @Title: insert 
	 *
	 * @Description: 插入一条日志数据
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
	public int insert(LogEntity entity);
	
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
	public List<LogEntity> selectlimit(Map<String, Object> map) throws BusinessException;
	
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

