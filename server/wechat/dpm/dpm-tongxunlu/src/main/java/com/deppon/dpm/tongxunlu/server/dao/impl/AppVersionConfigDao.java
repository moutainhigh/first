package com.deppon.dpm.tongxunlu.server.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.deppon.dpm.tongxunlu.server.dao.IAppVersionConfigDao;
import com.deppon.dpm.tongxunlu.shared.domain.AppVersionConfigEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * @ClassName: AppVersionConfigDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yuyongxiang-134019-yuyongxiang@deppon.com
 * @date 2014年8月12日 下午5:39:13
 * 
 */
public class AppVersionConfigDao extends iBatis3DaoImpl implements IAppVersionConfigDao {
	// namespace
	private static final String NAMESPACE = "com.deppon.dpm.tongxunlu.server.dao.appVersionConfigDao.";

	/**
	 * 
	 * @Title: queryOne 
	 *
	 * @Description: 根据提供的两个参数查询id最大的那一条数据(当前的方法的参数可以唯一确定一个APP系统下面的莫一个移动类型下面的所有的版本信息例如 : 
	 * DPM 系统下的android的app的所有的版本信息 由于ID是自增长的字段所以id最大的那一条数据一定是最新的版本号)
	 *
	 * @author 134019-yuyongxiang@deppon.com
	 *
	 * @date 2014年8月12日 下午5:42:12 
	 *
	 * @param osType 移动终端的系统类型(android,iphone,.....等)
	 * @param appName 当前服务系统的名字例如 PDM
	 * @return AppVersionConfigEntity 
	 *
	 * @throws 
	 */
	@Override
	public AppVersionConfigEntity queryOne(String osType, String appName) {
		// 用以拼接参数
		Map<String, Object> map=new HashMap<String, Object>();
		// 设备类型
		map.put("osType", osType);
		// app名称
		map.put("appName", appName);
		// 返回实体类
		return (AppVersionConfigEntity) this.getSqlSession().selectOne(NAMESPACE + "queryOne", map);
	}

}
