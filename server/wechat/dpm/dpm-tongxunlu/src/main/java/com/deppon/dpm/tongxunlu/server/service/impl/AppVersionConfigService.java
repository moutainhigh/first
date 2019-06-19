package com.deppon.dpm.tongxunlu.server.service.impl;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.dao.IVersionUpdateControlDao;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.domain.VersionUpdateControlEntity;
import com.deppon.dpm.tongxunlu.server.dao.IAppVersionConfigDao;
import com.deppon.dpm.tongxunlu.server.service.IAppVersionConfigService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.SeeVersionExtClassLoader;
import com.deppon.dpm.tongxunlu.shared.domain.AppVersionConfigEntity;
import com.deppon.dpm.tongxunlu.shared.vo.Result;

/**
 * @ClassName: AppVersionConfigDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yuyongxiang-134019-yuyongxiang@deppon.com
 * @date 2014年8月12日 下午5:39:13
 * 
 */
public class AppVersionConfigService implements IAppVersionConfigService {
	
	private static final Logger LOG = LoggerFactory.getLogger(AppVersionConfigService.class);

	private IAppVersionConfigDao appVersionConfigDao;
	
	private IVersionUpdateControlDao versionUpdateControlDao;
	
	private RedisService  loginRedisService;
	
	private SeeVersionExtClassLoader seeVersionExtClassLoader;
	
	// 控制弹框的Class
	private Class clazz1;
	
	// 控制是否有权限更新的Class
	private Class clazz2;
	
	
	/**
	 * 反射调用方法逻辑抽取
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private String executeFunction(String type,String userId,String version,String osType,ApplicationContext applicationContext,String loginResultStr) throws Exception{
		String jsonData = null;
		Class clazz = "0".equals(type) ? clazz1 : clazz2;
		// 查询版本更新权限表是否有控制弹框的配置
		List<VersionUpdateControlEntity> list = versionUpdateControlDao.queryByType(type);
		if(list.size() > 0) {
			VersionUpdateControlEntity entity = list.get(0);
			// 全类名
			String className = entity.getFileName();
			// 类文件的路径
			String classFilePath = entity.getFilePath();
			// 判断上传的文件是否已经加载
			if("off".equals(entity.getLoadStatus())) {
				// 加载class
				seeVersionExtClassLoader = new SeeVersionExtClassLoader(Thread.currentThread().getContextClassLoader(),classFilePath,className);
				clazz = seeVersionExtClassLoader.findClass(className);
				if("0".equals(type)){
					 clazz1 = clazz;
				} else {
					 clazz2 = clazz;
				}
			}
			// 如果clazz被回收，重新加载
			if(null == clazz) {
				seeVersionExtClassLoader = new SeeVersionExtClassLoader(Thread.currentThread().getContextClassLoader(),classFilePath,className);
				clazz = seeVersionExtClassLoader.findClass(className);
				
				if("0".equals(type)){
					 clazz1 = clazz;
				} else {
					 clazz2 = clazz;
				}
			}
			// 将spring容器通过构造器传入对象
			Object newInstance = clazz.getConstructor(WebApplicationContext.class).newInstance(applicationContext);
			// 获取execute方法
			Method method = clazz.getMethod("execute",String.class,String.class,String.class);
			// 调用方法
			jsonData = (String) method.invoke(newInstance,loginResultStr,version,osType);
			if("off".equals(entity.getLoadStatus())){
				// 更新配置信息的状态为已加载
				entity.setUpdateTime(new Date());
				entity.setLoadStatus("on");
				versionUpdateControlDao.update(entity);
			}
		}
		return jsonData;
	}
	
	
	/**
	 * 
	 * @Title: queryOne
	 *
	 * @Description: 
	 *               根据提供的两个参数查询id最大的那一条数据(当前的方法的参数可以唯一确定一个APP系统下面的莫一个移动类型下面的所有的版本信息例如
	 *               : DPM 系统下的android的app的所有的版本信息
	 *               由于ID是自增长的字段所以id最大的那一条数据一定是最新的版本号)
	 *
	 * @author 134019-yuyongxiang@deppon.com
	 *
	 * @date 2014年8月12日 下午5:42:12
	 *
	 * @param osType
	 *            移动终端的系统类型(android,iphone,.....等)
	 * @param appName
	 *            当前服务系统的名字例如 PDM
	 * @return AppVersionConfigEntity
	 *
	 * @throws
	 */
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String seeVersion(ServletContext servletContext, String requestType, String userId, String version, String appName, String osType) {
		//查询当前系统的记录最新
		AppVersionConfigEntity appVersionConfigEntity = appVersionConfigDao
				.queryOne(osType, appName);
		// 返回实体
		Result res = new Result();
		if (appVersionConfigEntity != null) {
			// 是否有权限控制的配置
			boolean hasConfig = false;
			// 弹框控制反射调用方法的返回数据
			String jsonData = null;
			// 是否有更新的权限
			String hasUpdatePermission = null;
			try {
				// 获取登录信息
				String loginResultStr = loginRedisService.get(RedisService.DPM_LOGIN_LOGININFO_KEY + userId);
				// 获取spring容器
				WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
				/*********控制是否有权限更新代码  start*************/
				hasUpdatePermission = executeFunction("1", userId, version, osType, applicationContext, loginResultStr);
				/*********控制是否有权限更新代码  end*************/
				// 如果有更新的权限
				if(null == hasUpdatePermission || "1".equals(hasUpdatePermission)){
					/*********控制是否可以弹框  start***************/
					int versionNum = Integer.parseInt(version.replace(".", ""));
					// 兼容版本：对于ios3.8.4以上和android3.7.3以上的版本才有效
					if("1".equals(requestType) && (("iphone".equals(osType) && versionNum >= MagicNumber.NUM384)
							|| ("android".equals(osType) && versionNum >= MagicNumber.NUM373))){
						jsonData = executeFunction("0", userId, version, osType, applicationContext, loginResultStr);
						// 设置标示
						hasConfig = true;
					}
				}
			} catch (Exception e) {
				LOG.error("系统版本更新的权限控制出错！！！param={userId="+userId+",version="+version+",osType="+osType+",appName="+appName+"}", e);
			}
			
			// 是否在自动检测更新后提示更新
			boolean hasPermission = false;
			// 是否强制更新
			boolean isForce = false;
			try {
				if(null != jsonData) {
					JSONObject jsonObject = JSON.parseObject(jsonData);
					hasPermission = jsonObject.getBooleanValue("hasPermission");
					isForce = jsonObject.getBooleanValue("isForce");
				}
			} catch (Exception e) {
				LOG.error("系统版本更新的权限控制解析json出错！！！jsonData="+jsonData,e);
			}
			/*********控制是否可以弹框  end***************/
			
			// 获取当前版本并以前端传递过来的版本号作对比
			if (version.equals(appVersionConfigEntity.getVersion()) || "0".equals(hasUpdatePermission)) {
				// errorCode
				res.setErrorCode(Constants.SUCCESS);
				// 提示信息
				res.setData("版本已经是最新的");
				Map m = new HashMap(1);
				// 是否是最新版本,true
				m.put("lastVersion", "true");
				// 设置返回数据
				res.setData(m);
				// 返回
				return JSON.toJSONString(res);
			} else {
				// errorCode
				res.setErrorCode(Constants.SUCCESS);
				// 参数拼接
				Map m = new HashMap();
				// 不是最新版本
				m.put("lastVersion", "false");
				// 版本号
				m.put("version", appVersionConfigEntity.getVersion());
				// 是否强制更新
				if(hasConfig && jsonData != null) {
					// 自动检测更新后是否弹出提示框
					m.put("isAlert", hasPermission ? "1" : "0");
					// 如果有权限控制的配置
					m.put("force", isForce ? "1" : "0");
				} else {
					m.put("force", appVersionConfigEntity.getForce());
				}
				// 更新内容
				m.put("content", appVersionConfigEntity.getContent());
				// url
				m.put("url", appVersionConfigEntity.getUrl());
				// 设置返回数据
				res.setData(m);
				// 返回
				return JSON.toJSONString(res);
			}
		}
		// errorCode
		res.setErrorCode(Constants.SERVICE_ERROR);
		// errorMessage
		res.setErrorMessage("没有找到对应的应用配置信息.");
		// 返回
		return JSON.toJSONString(res);
	}
	
	/** 
	* @Title: seeVersion 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author yuyongxiang-134019-yuyongxiang@deppon.com
	* @date 2014年8月13日 下午2:48:40 
	* @param @param appName
	* @param @param osType
	* @param @return    设定文件 
	* @throws 
	*/
	@Override
	public AppVersionConfigEntity seeVersion(String appName, String osType) {
		//查询当前系统的记录最新
		return appVersionConfigDao.queryOne(osType, appName);
	}

	/****************************** getter and setter start TODO *************************************/

	/**
	 * @return appVersionConfigDao
	 */
	public IAppVersionConfigDao getAppVersionConfigDao() {
		return appVersionConfigDao;
	}

	/**
	 * @param appVersionConfigDao
	 *            要设置的 appVersionConfigDao
	 */
	public void setAppVersionConfigDao(IAppVersionConfigDao appVersionConfigDao) {
		this.appVersionConfigDao = appVersionConfigDao;
	}

	public void setVersionUpdateControlDao(
			IVersionUpdateControlDao versionUpdateControlDao) {
		this.versionUpdateControlDao = versionUpdateControlDao;
	}

	public void setLoginRedisService(RedisService loginRedisService) {
		this.loginRedisService = loginRedisService;
	}
	/****************************** getter and setter end *************************************/
}
