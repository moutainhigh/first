package com.deppon.dpm.tongxunlu.server.dao;

import com.deppon.dpm.tongxunlu.shared.domain.AppVersionConfigEntity;


/**
* @ClassName: IAppVersionConfigDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author yuyongxiang-134019-yuyongxiang@deppon.com
* @date 2014年8月12日 下午5:39:38 
*
 */
public interface IAppVersionConfigDao {
	
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
	AppVersionConfigEntity queryOne(String osType,String appName);

}
