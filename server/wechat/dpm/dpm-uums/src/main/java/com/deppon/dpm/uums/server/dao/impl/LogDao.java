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

import com.deppon.dpm.uums.server.dao.ILogDao;
import com.deppon.dpm.uums.server.domain.LogEntity;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 
* @ClassName: LogDao 
* @Description: 日志表dao
* @author yuyongxiang-134019-yuyongxiang@deppon.com
* @date 2014年9月19日 上午8:33:21 
*
 */
public class LogDao extends iBatis3DaoImpl implements ILogDao{
	//命名空间
	private String NAMESPACE = "com.deppon.dpm.uums.server.dao.LogDaoMapper.";

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
	public int insert(LogEntity entity) {
		//封装基础数据
		if(null == entity){
			return -1;
		}
		entity.setDateTime(new Date());
		return this.getSqlSession().insert(NAMESPACE + "addLog", entity );
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
	public List<LogEntity> selectlimit(Map<String, Object> map)
			throws BusinessException {
		
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
		
		return (Long) this.getSqlSession().selectOne(NAMESPACE + "selectlimitCount", map);
	}

}

