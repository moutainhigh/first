package com.deppon.dpm.module.management.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.IBusMessageByFindDao;
import com.deppon.dpm.module.management.shared.domain.BusMessageEntity;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 显示新增消息信息的dao层实现接口
 * @author 曹嵩
 * @date 2015.06.29
 */
@SuppressWarnings("unchecked")
public class BusMessageByFindDao extends iBatis3DaoImpl implements
		IBusMessageByFindDao {
	
	String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.bussiteview"; 
	/**
	 * 
	 * @return 找到所有的消息信息
	 * @throws BusinessException
	 */
	@Override
	public List<BusMessageEntity> getBusMessageByFind() throws BusinessException {
		return getSqlSession().selectList(mapperNameSpace+".getMessageAll");
	}

}
