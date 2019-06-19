package com.deppon.dpm.tongxunlu.server.service;

import javax.servlet.ServletContext;

import com.deppon.dpm.tongxunlu.shared.domain.AppVersionConfigEntity;


/**
* @ClassName: IAppVersionConfigDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author yuyongxiang-134019-yuyongxiang@deppon.com
* @date 2014年8月12日 下午5:39:38 
*
 */
public interface IAppVersionConfigService {
	
	/**
	 * 
	 * @Title: seeVersion 
	 *
	 * @Description: 查看版本
	 *
	 * @author 134019-yuyongxiang@deppon.com
	 *
	 * @date 2014年8月12日 下午6:10:20 
	 *
	 * @param version
	 * @param appName
	 * @param osType
	 * @return String    返回类型 
	 *
	 * @throws 
	 * @see yu
	 */
	public String seeVersion(ServletContext servletContext, String requestType, String userId,String version, String appName, String osType);
	/**
	 * 
	 * @Title: seeVersion 
	 *
	 * @Description: 查看版本
	 *
	 * @author 134019-yuyongxiang@deppon.com
	 *
	 * @date 2014年8月12日 下午6:10:20 
	 *
	 * @param appName
	 * @param osType
	 * @return String    返回类型 
	 *
	 * @throws 
	 * @see yu
	 */
	public AppVersionConfigEntity seeVersion(String appName, String osType);

}
