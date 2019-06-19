package com.deppon.dpm.module.announce.server.dao.impl;

import com.deppon.dpm.module.announce.server.dao.IAnnounceLogDao;
import com.deppon.dpm.module.announce.shared.domain.AnnounceLogEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 
* @ClassName: AnnounceLogDao 
* @Description: 公告日志DAO实现层 
* @author 045925/YANGBIN
* @date 2015-3-18 下午3:15:18 
*
 */
public class AnnounceLogDao extends iBatis3DaoImpl implements IAnnounceLogDao {
	private static final String NAME_SPACE="com.deppon.dpm.module.announce.shared.domain.AnnounceLogEntity.";
	/**
	 * 
	* @Title: insert 
	* @Description: 插入公告
	* @param @param entity
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	@Override
	public int insert(AnnounceLogEntity entity) {
		// 插入
		return getSqlSession().insert(NAME_SPACE+"insert", entity);
	}
	
}
