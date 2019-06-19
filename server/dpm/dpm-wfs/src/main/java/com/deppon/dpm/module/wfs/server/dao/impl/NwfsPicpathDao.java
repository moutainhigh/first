package com.deppon.dpm.module.wfs.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.wfs.server.dao.INwfsPicpathDao;
import com.deppon.dpm.module.wfs.shared.domain.NwfsPicPathEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 根据传入的工号集合查询头像地址
 * @author 276344
 *
 */
public class NwfsPicpathDao extends iBatis3DaoImpl implements INwfsPicpathDao {
	/**
	 * 命名空间
	 */
	public static final String NAMESPACE = "com.deppon.dpm.module.wfs.server.dao.workitems.";
	@SuppressWarnings("unchecked")
	@Override
	public List<NwfsPicPathEntity> picturePaths(List<String> userIds) {
		
		return getSqlSession().selectList(NAMESPACE + "queryPicPathByUserids", userIds);
	}

}
