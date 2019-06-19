package com.deppon.dpm.module.management.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.IBusOpenLineAndNewsSiteDao;
import com.deppon.dpm.module.management.shared.domain.BusOpenLineAndNewsSiteEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 显示所有的建议站点信息Dao层实现接口
 * @author 曹嵩
 * @date 2015.7.1
 */
@SuppressWarnings("unchecked")
public class BusOpenLineAndNewsSiteDao extends iBatis3DaoImpl implements
		IBusOpenLineAndNewsSiteDao {
    //地址
	String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.bussiteview";
	/**
	 * 显示所有的建议站点信息
	 * @return list集合
	 */
	@Override
	public List<BusOpenLineAndNewsSiteEntity> querySiteAll() throws Exception {
		return getSqlSession().selectList(mapperNameSpace+".getOpenLineAndNewsSite");
	}

}
