package com.deppon.dpm.login.server.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.login.server.cache.UserCache;
import com.deppon.dpm.login.server.domain.CasUserEntity;
import com.deppon.dpm.login.server.domain.FailLoginInfoEntity;
import com.deppon.dpm.login.server.service.ILoginService;
import com.deppon.dpm.login.server.util.Base64Util;
import com.deppon.dpm.login.server.util.Cookie;
import com.deppon.dpm.login.server.util.FossUserContext;
import com.deppon.dpm.login.server.util.SmsSendUtil;
import com.deppon.dpm.login.server.vo.LoginResult;
import com.deppon.dpm.module.common.server.service.IEmpBindMacService;
import com.deppon.dpm.module.common.server.service.ILoginInfoService;
import com.deppon.dpm.module.common.server.service.IUUMSRoleService;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.DES;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.server.util.ThreadCallBack;
import com.deppon.dpm.module.common.shared.define.DpmConstants;
import com.deppon.dpm.module.common.shared.domain.EmpBindMacEntity;
import com.deppon.dpm.module.common.shared.domain.EmpExtensionEntity;
import com.deppon.dpm.module.common.shared.domain.LoginCheckBean;
import com.deppon.dpm.module.management.shared.domain.ApplyStore;
import com.deppon.dpm.tongxunlu.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.service.IAppVersionConfigService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.domain.AppVersionConfigEntity;
import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;
import com.deppon.dpm.tongxunlu.shared.vo.Result;
import com.deppon.foss.framework.cache.CacheManager;
import com.deppon.foss.framework.exception.security.UserNotLoginException;
import com.deppon.foss.framework.server.components.security.SecurityNonCheckRequired;
import com.deppon.foss.framework.server.context.SessionContext;
import com.deppon.foss.framework.server.context.UserContext;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * 登陆服务的控制转发类.
 * 
 * @author 130126
 * 
 */
public class LoginAction extends BaseAction {
	/**
	 * log
	 */
	private static Logger logger = Logger.getLogger(LoginAction.class);
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3518586514074288421L;
	
	/**
	 * ios3.7.8版本
	 */
	private static final int APPVERSION_378 = 378;  
	
	/**
	 * 错误的登录次数 6次
	 */
	private static final int ERROR_COUNT = 6;
	/**
	 * 状态码404
	 */
	private static final int NOTFOUND = 404;
	/**
	 * 状态码500
	 */
	private static final int SERVERERROR = 500;
	/**
	 * 用户名
	 */
	private String loginName;
	/**
	 * 是否登录验证
	 */
	private boolean doLogin;
	/**
	 * 加密TOKEN
	 */
	private String requestToken = null;
	/**
	 * 当前用户
	 */
	private UserEntity currentUser;
	/**
	 * 当前服务时间
	 */
	private Date currentServerTime;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * APP 的品牌信息
	 */
	private String osType = "ANDROID";
	/**
	 * APP 名字
	 */
	private String appName;
	/**
	 * 登陆类型
	 */
	private String loginType = "0";
	/**
	 * 设备号
	 */
	private String deviceToken;
	/**
	 * 手机机型
	 */
	private String phoneModel;
	/**
	 * 操作系统版本号
	 */
	private String osVersion;
	/**
	 * 手机mac地址
	 */
	private String phoneMac;
	
	/**
	 * 清除上次安装历史（ios使用）
	 * 0： 正常   1： 清除
	 */
	private String clearHistory;
	/**
	 * 6月6号版本，为了老系统能够使用<br>
	 * 0 是老版本，1是6月6号版本,2是6月9号版本
	 * 应用商店分包：为了12月10号的版本能够使用<br>
	 * 3 是12月24号版本
	 * 4是01.12版本
	 */
	private int newVersion;
	/**
	 * 应用版本号
	 */
	private String appVersion;
	/**
	 * 推送设备号
	 */
	private String pushToken;
	/**
	 * 登录的服务
	 */
	private ILoginService loginService;
	/**
	 * app版本的服务
	 */
	private IAppVersionConfigService appVersionConfigService;
	/**
	 * 记录登录用户信息服务
	 */
	private ILoginInfoService loginInfoService;

	/**
	 * 请求角色信息的service
	 */
	private IUUMSRoleService uUMSRoleService;
	
	/**
	 * RedisService
	 */
	private RedisService loginRedisService;
	
	/**
	 * 获取登录的手机绑定的工号
	 */
	private IEmpBindMacService empBindMacService;
	
	/**
	 * 手机app登陆
	 */
	@SuppressWarnings("unchecked")
	public void login() {
		// 定义返回结果
		final Result<Object> rstLogin = new Result<Object>();
		try {
			// 处理手机端传过来的参数
			dealParam();
		} catch (Exception e) {
			// errorMessage
			rstLogin.setErrorMessage("传入参数有误！");
			// errorCode
			rstLogin.setErrorCode(1);
			// 返回前端
			writeToPage(rstLogin);
			// 跳出
			return;
		}
		try {
			// 先查询用户的锁定状态和错误次数
			FailLoginInfoEntity failLoginInfoEntity = loginService.queryFailLoginInfo(userId);
			// 如果有记录
			if(null != failLoginInfoEntity){
				// 当前时间
				Date currentTime = new Date();
				// 被锁定时间
				Date lockedTime = failLoginInfoEntity.getLockedTime();
				// 如果已被锁定并且锁定时间还未过期，则跳出
				if(null != lockedTime && currentTime.getTime() < (DateUtils.addMinutes(lockedTime, 1).getTime())){
					// errorMessage
					rstLogin.setErrorMessage("账号已被锁定，请一分钟后再试");
					// errorCode
					rstLogin.setErrorCode(1);
					// 返回前端
					writeToPage(rstLogin);
					// 跳出
					return;
				}
			}
			// 开启线程，根据经纬度调用百度api获取地理位置
//			Callable<String> callableMap = new Callable<String>() {
//				@Override
//				public String call() throws Exception {
//					// 返回地址信息
//					return getLocation(latitude, longitude);
//				}
//			};
			// 存储地理位置信息
//			Future<String> futureMap = ThreadCallBack.call(callableMap);
			// 开启线程，判断是否需要短信验证码
			Callable<String> callableSms = new Callable<String>() {
				@Override
				public String call() throws Exception {
					// 获取状态
					String result = loginInfoService.existUserIdAndDeviceToken(
							userId, deviceToken, true);
					// 返回状态
					return result;
				}
			};
			// 存取短信处理状态
			Future<String> futureSms = ThreadCallBack.call(callableSms);
			// 开启线程，获得手势密码状态
			Callable<String> callableGuesture = new Callable<String>() {
				@Override
				public String call() throws Exception {
					// 获取手势密码状态
					String result = (String) loginService.getGustureStatus(
							userId).get("status");
					// 返回状态
					return result;
				}
			};
			// 存取手势密码状态
			Future<String> futureGuesture = ThreadCallBack
					.call(callableGuesture);
			// 开启线程，获得短信开关状态
			Callable<String> callableSmsStatus = new Callable<String>() {
				@Override
				public String call() throws Exception {
					// 获得短信开关状态
					String result = loginInfoService.existUserIdAndDeviceToken(
							userId, deviceToken, false);
					// 返回短信开关状态
					return result;
				}
			};
			// 存储短信开关状态
			Future<String> futureSmsStatus = ThreadCallBack
					.call(callableSmsStatus);
			// --------------------------
			
			// cas实体类
			CasUserEntity casUserEntity = null;
			try {
				// 获取cas实体类
				casUserEntity = loginService.userLogin(userId, password);
			} catch (Exception e) {
				// 如果登录错误信息表中没有该数据，则保存
				if(null == failLoginInfoEntity){
					// 封装实体数据
					failLoginInfoEntity = new FailLoginInfoEntity();
					// 工号
					failLoginInfoEntity.setEmpCode(userId);
					// 保存
					loginService.saveFailLoginInfo(failLoginInfoEntity);
				}else{
					// 如果登录错误信息表中有该数据，则更新
					// 错误登录次数+1
					failLoginInfoEntity.setErrorCount(failLoginInfoEntity.getErrorCount() + 1);
					// 最后一次错误登录的时间
					failLoginInfoEntity.setLastErrorLoginTime(new Date());
					// 更新时间
					failLoginInfoEntity.setUpdateTime(failLoginInfoEntity.getLastErrorLoginTime());
					// 如果错误的登录次数==6次，则需要锁定
					if(failLoginInfoEntity.getErrorCount() == ERROR_COUNT){
						// 锁定时间
						failLoginInfoEntity.setLockedTime(failLoginInfoEntity.getLastErrorLoginTime());
					}else if(failLoginInfoEntity.getErrorCount() > ERROR_COUNT){
						// 如果错误的登录次数大于6次，则重置错误次数和锁定时间,保证6次错误一个循环
						failLoginInfoEntity.setErrorCount(1);
						failLoginInfoEntity.setLockedTime(null);
					}
					// 更新
					loginService.updateFailLoginInfo(failLoginInfoEntity);
				}
				// errorMessage
				rstLogin.setErrorMessage("验证用户名或密码错误");
				// errorCode
				rstLogin.setErrorCode(1);
				// 返回前端
				writeToPage(rstLogin);
				// 跳出
				return;
			}
			// 验证账号密码成功后，需要清除错误登录信息表中的错误数和锁定时间
			if(null != failLoginInfoEntity){
				// 不用每次校验账号密码成功后都清除状态和次数
				if(null != failLoginInfoEntity.getLockedTime() || failLoginInfoEntity.getErrorCount() != 0){
					// 设置错误次数为0
					failLoginInfoEntity.setErrorCount(0);
					// 清除锁定时间
					failLoginInfoEntity.setLockedTime(null);
					// 更新时间
					failLoginInfoEntity.setUpdateTime(new Date());
					// 更新
					loginService.updateFailLoginInfo(failLoginInfoEntity);
				}
			}
			
			// 登陆结果实体
			LoginResult loginResult = new LoginResult();
			// appName为空或者设备类型为空
			if (StringUtil.isEmpty(appName) || StringUtil.isEmpty(osType)) {
				// 设置为安卓
				loginResult.setAndroidVersion("2");
			} else {
				// 根据appName和osType查看系统版本
				AppVersionConfigEntity version = appVersionConfigService
						.seeVersion(appName, osType);
				// 设置系统版本
				loginResult.setVersion(version.getVersion());
				// 设置是否强制更新
				loginResult.setForce(version.getForce());
				// url设置
				loginResult.setUrl(version.getUrl());
			}
			// phoneMac绑定的工号
			EmpBindMacEntity empBindMacEntity = new EmpBindMacEntity(osType,phoneMac);
			String macEmpCode = empBindMacService.queryEmpCodeByMacAndOstype(empBindMacEntity);
			macEmpCode = StringUtils.isEmpty(macEmpCode) ? "" : macEmpCode;
			// 设置信息
			loginResult.setMacEmpCode(macEmpCode);   
			loginResult.setOsType(osType);
			loginResult.setOsVersion(osVersion);
			loginResult.setPhoneModel(phoneModel);
			loginResult.setAppVersion(appVersion);
			// 设置权限
			Map<String, Object> roleMap = new HashMap<String, Object>(1);
			// 起始时间
			long startTime = System.currentTimeMillis();
			// 查询角色信息
			String roles = uUMSRoleService.getRoles(userId);
			// 结束时间
			long endTime = System.currentTimeMillis();
			// 日志
			logger.info("["+userId+"]登录调用uums获取角色用时>>>>>>" + (endTime - startTime));
			// 解析
			String roleStr = JSONObject.parseObject(roles).getString("roleCodes");
			List<String> rolesList = JSONObject.parseArray(roleStr, String.class);
			// 获取角色编码，用以权限判断
			if(null == rolesList){
				rolesList = new ArrayList<String>();
			}
			// 获取role编码
			roleMap.put("roleCodes", rolesList);
			// 将role编码放入loginResult中
			loginResult.setRoleStr(roleMap);
			// crm权限
			loginResult.setHasCrmPermission(rolesList
					.contains(DpmConstants.crmPermissionRole));
			// loginResult.setHasManagePermission(roleCodes
			// .contains(DpmConstants.managePermissionRole));
			// 20150820 项目管理工具放开控制权限
			loginResult.setHasManagePermission(true);
			// 判断是否含有早安快递的权限
			loginResult.setHasExpressPermission(rolesList
					.contains(DpmConstants.dpmExpressRole));
			// 是否包含打卡、补考勤权限
			loginResult.setNeedAttendanceRecord(!rolesList
					.contains(DpmConstants.attendanceRecordRole));
			// 是否包含it终端权限
			loginResult.setIt(rolesList.contains(DpmConstants.it));

			// 登陆时获取应用商店的排序
			Map<String,Object> resultMap = loginService.getApplyStoreSort(userId,deviceToken,clearHistory,newVersion,rolesList,osType,appVersion);
			// 有权限的应用编号list
			loginResult.setHasPermissionApplys((List<Integer>)(resultMap.get("hasPermissionApplys")));
			
			// 自动更新的应用
			loginResult.setRefreshAppIds(new ArrayList<Integer>());
			
			// 例如3.7.7-->377
			String dealAppVersion = "0";
			if(StringUtils.isNotBlank(appVersion)){
				dealAppVersion = appVersion.replace(".", "");
			}
			
			// 判断如果是ios登录，并且版本小于3.7.7版本，就做以下兼容
			if("android".equalsIgnoreCase(osType) && 
					(Integer.valueOf(dealAppVersion) == MagicNumber.NUM380 || 
							Integer.valueOf(dealAppVersion) == MagicNumber.NUM381)){
				// 安卓的3.8.0和3.8.1版本的自动更新有bug，跳过这2个版本
				loginResult.setRefreshApplyStores(new ArrayList<ApplyStore>());
			} else {
				// 需要自动更新的应用信息
				loginResult.setRefreshApplyStores((List<ApplyStore>)(resultMap.get("refreshApplyStores")));
			}
			
			
			// 设置应用排序
			loginResult.setApplyStoreSort((String)(resultMap.get("sortStr")));

			// 判断如果是ios登录，并且版本小于3.7.7版本，就做以下兼容
			if("iphone".equalsIgnoreCase(osType)){
				// 3.7.7版本的appVersion传值有问题
				if("(null)".equals(dealAppVersion) || Integer.valueOf(dealAppVersion) < APPVERSION_378){
					// 登陆时获取资讯的排序
					String infoStoreSort = loginService.getInfoStoreSort(userId);
					// 设置资讯排序
					loginResult.setInfoStoreSort(infoStoreSort);
				}
			}
			
			// 设置cookie
			loginResult.setCasCookie(casUserEntity.getCookie());
			// 设置sessionId
			loginResult.setSessionId(casUserEntity.getCasSessionId());
			// 获取用户信息
			UserEntity userEntity = loginService.queryUser(userId,rolesList);
			if(null == userEntity){
				// errorMessage
				rstLogin.setErrorMessage("用户信息未同步！");
				// errorCode
				rstLogin.setErrorCode(1);
				// 返回前端
				writeToPage(rstLogin);
				// 跳出
				return;
			}
			// 设置jobDuty为空，为了使返回的数据变小
			userEntity.getEmployee().setJobDuty(null);
			// ecc是否显示
			loginResult.setHasECCPermission((Boolean)(resultMap.get("hasECCPermission")));
			// BI是否显示
			boolean hasBIPermission = (Boolean)(resultMap.get("hasBIPermission"));
			loginResult.setHasBIPermission(hasBIPermission);
			//智慧收派是否显示
			loginResult.setHasRDVSPermission((Boolean)resultMap.get("hasRDVSPermission"));
			// 工作流是否显示，TODO
//			loginResult.setHasWorkFlowPermission();
			// 返回前端
			userEntity.getEmployee().setJobGroups(hasBIPermission ? "1" : "0");
			// BI权限
			// 设置用户角色信息
			loginResult.setUserEntity(userEntity);
			// 获取地址信息
//			location = futureMap.get();
			// 踢出判断
			// 参数拼接
			/*EmpExtensionEntity empExtensionEntity = loginInfoService
					.checkDevice(userId, deviceToken, osType, latitude,
							longitude, location);*/
			EmpExtensionEntity parm = new EmpExtensionEntity(osType, longitude, latitude, location, 
					phoneModel, osVersion, phoneMac, appVersion);
			EmpExtensionEntity empExtensionEntity = loginInfoService.checkDevice(userId, deviceToken,parm);
			// 上次登录信息获取
//			LoginLocationEntity lle = DpmCacheManager.getLocationInfo(userId);
			// 踢出判断用户信息不为空
			if (null != empExtensionEntity) {
				// 上次登录信息为空
//				if (null == lle) {
//					// 保存这次的登录信息
//					DpmCacheManager.setLocationInfo(
//							userId,
//							new LoginLocationEntity(location,
//									new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//											.format(new Date()) + ""));
//					// 设置上次登录地址为“”
//					empExtensionEntity.setLocation("");
//					// 设置上次的登陆时间
//					empExtensionEntity.setUpdateTime(new SimpleDateFormat(
//							"yyyy-MM-dd HH:mm:ss").format(new Date()) + "");
//				} else {
//					// 不为空，直接获取上次的登陆地址
//					empExtensionEntity.setLocation(lle.getLocation());
//					// 不为空，直接获取上次的登陆时间
//					empExtensionEntity.setUpdateTime(lle.getLoginTime());
//					// 将这次的登陆信息保存
//					DpmCacheManager.setLocationInfo(
//							userId,
//							new LoginLocationEntity(location,
//									new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//											.format(new Date()) + ""));
//				}
				// 将信息返回前端
				loginResult.setEmpExtensionEntity(empExtensionEntity);
			}
			
			// 判断用户模块监控开关是否开启（开启了前台才会监控模块点击异常）
			loginResult.setMonitorUserFunc(loginService.queryUserFuncStatus(userId));
			
			// 判断是否有手势密码
			boolean hasGesturePassword = loginService
					.hasGesturePassword(userId);
			// 设置手势密码
			loginResult.setHasGesturePassword(hasGesturePassword);
			// 获取手势密码开关状态
			String status = futureGuesture.get();
			// 手势密码开关获取
			loginResult.setGustureStatus(status == null ? "off" : status);
			// 获取手机短信开关状态
			loginResult.setSmsStatus(futureSmsStatus.get());
			// 返回前，记录登录用户信息
			Thread saveThread = new Thread() {
				@Override
				public void run() {
					// 保存用户信息
					loginInfoService.saveUserLogin(userId, loginType, osType, appVersion);
					// 保存用户设备信息
//					if("iphone".equals(osType) && StringUtils.isNotBlank(pushToken) && !"(null)".equals(pushToken)){
//						loginInfoService.saveUserDevice(userId,osType,pushToken);
//					}
				}
			};
			ThreadCallBack.run(saveThread);
			// --------------------------
			// 短信验证状态获取
			String smsResult = futureSms.get();
			// off和存在
			if ("off".equals(smsResult) || "exist".equals(smsResult)) {
				// 不需要进行短信验证
				loginResult.setSms("N");
			} else {
				// 否则需要
				loginResult.setSms("Y");
			}
			// --------------------------
			// 保存
//			Cookie.saveCookie();
			// 缓存获取工作流信息
//			DpmCacheManager.setWfs(userId, rstLogin);
			// 用户信息展示
			logger.info("[用户信息]==>"
					+ ReflectionToStringBuilder.toString(userEntity));
			// 返回前端封装
			rstLogin.setData(loginResult);
			// errorCode
			rstLogin.setErrorCode(Constants.ACTION_RESULT_SUC);
			try {
				// 将登录信息存入redis缓存（时间为30分钟）
				loginRedisService.set(RedisService.DPM_LOGIN_LOGININFO_KEY + userId, JSON.toJSONString(loginResult), MagicNumber.NUM1800);
			} catch (Exception e) {
				// errorCode
				rstLogin.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				rstLogin.setErrorMessage("系统发生异常，请稍后再试");
				// logger
				logger.error("[" + userId + "]登录发生异常>>>>",e);
			}
			// 前端返回
			this.writeToPage(rstLogin);
		} catch (Exception e) {
			// errorCode
			rstLogin.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			rstLogin.setErrorMessage(e.getMessage());
			// 前端返回
			this.writeToPage(rstLogin);
			// logger
			logger.error("[" + userId + "]登录发生异常>>>>",e);
		}
	}

	/**
	 * 登陆时，处理参数
	 */
	private void dealParam() throws Exception {
		// IOS和android的post有区别
		HttpServletRequest request = ServletActionContext.getRequest();
		// 用以读取IOS post请求消息体内的数据
		StringBuffer buffer = new StringBuffer();
		// 用以接收读取信息
		String line = null;
		// 读取ios传递信息
		BufferedReader in = new BufferedReader(new InputStreamReader(
				request.getInputStream(), "utf-8"));
		// 循环
		while ((line = in.readLine()) != null) {
			// 追加参数信息
			buffer.append(line);
		}
		// ios传递参数
		String iosParam = buffer.toString().trim();
		// 不为空，表示ios参数
		if (StringUtils.isNotEmpty(iosParam)) {
			// iosParam转换为jsonObject
			JSONObject jsonObject = JSON.parseObject(iosParam);
			// dpm
			appName = (String) jsonObject.get("appName");
			// 设备号
			osType = (String) jsonObject.get("osType");
			// 工号
			userId = (String) jsonObject.get("userId");
			// 版本
			newVersion = Integer
					.parseInt((String) jsonObject.get("newVersion"));
			// 密码
			password = (String) jsonObject.get("password");
			// token
			token = (String) jsonObject.get("token");
			// 登陆类别
			loginType = (String) jsonObject.get("loginType");
			// 是否为手机端登陆
			doLogin = Boolean.parseBoolean((String) jsonObject.get("doLogin"));
			// 设备号
			deviceToken = (String) jsonObject.get("deviceToken");
			// 纬度
			longitude = (String) jsonObject.get("longitude");
			// 经度
			latitude = (String) jsonObject.get("latitude");
			// 删除APP标志 ios
			clearHistory = (String) jsonObject.get("clearHistory");
			// 手机机型
			phoneModel = (String) jsonObject.get("phoneModel");
			// 手机系统版本号
			osVersion = (String) jsonObject.get("osVersion");
			// 手机mac
			phoneMac = (String) jsonObject.get("phoneMac");
			// 应用版本号
			appVersion = (String) jsonObject.get("appVersion");
			// 推送设备号
			pushToken = (String) jsonObject.get("pushToken");
		}
		// 6月6号版本，为了老系统能够使用
		if (newVersion == 1) {
			// 工号
			userId = DES.decryptDES(userId);
			// 密码
			password = DES.decryptDES(password);
		}// 6月9号版本
		if (newVersion >= 2 ) {
			// 工号
			userId = new String(Base64.decodeBase64(DES.decryptDES(userId)));
			// 密码
			password = new String(Base64.decodeBase64(DES.decryptDES(password)));
		}
	}

	/**
	 * 主页面
	 */
	@Override
	@SecurityNonCheckRequired
	public String execute() throws Exception {
		// web端登陆
		return this.doWebLogin();
	}

	/**
	 * WEB登陆功能 Date:2014-8-22下午12:55:30
	 */
	@SuppressWarnings("unchecked")
	private String doWebLogin() {
		// 网页端登陆
		if (this.doLogin) {
			try {
				// 用户名
				loginName = Base64Util.decodeToString(loginName);
				// 密码
				password = Base64Util.decodeToString(password);
				// 获取角色信息
				CasUserEntity casUserEntity = JSON.parseObject(uUMSRoleService.getRoles(loginName), CasUserEntity.class);
				// 用户登陆
				casUserEntity = loginService.webUserLogin(loginName,password,casUserEntity);
				// 验证管理平台权限
				loginService.validBpmWebUser(loginName, casUserEntity);
				// 这时跳转到main.jsp 根据session生成cookie
				Cookie.saveCookie();
				// 返回成功
				return this.returnSuccess();
			} catch (Exception e) {
				// 缓存获取信息
				CacheManager.getInstance().getCache(UserCache.USER_CACHE_UUID)
						.invalid(loginName);
				// log
				logger.error(e.getMessage());
				// 返回成功
				return this.returnError(e.getMessage());
			}
		} else {
			try {
				// userEntity
				UserEntity user = (UserEntity) (UserContext.getCurrentUser());
				if (user == null) {
					// 为null抛异常
					throw new UserNotLoginException();
				}
			} catch (UserNotLoginException e) {
				// 从缓存中获取
				CacheManager.getInstance().getCache(UserCache.USER_CACHE_UUID)
						.invalid(loginName);
				// 报错
				logger.error(e.getMessage());
				// 跳回登陆
				return "login";
			}
			// 返回
			return this.returnSuccess();
		}
	}

	/**
	 * WEB端退出功能
	 */
	public String doLogout() {
		// 失效Cookie
		Cookie.invalidateCookie();
		// 使session失效 invalidateSession
		SessionContext.invalidateSession();
		// 返回
		return this.returnSuccess();
	}

	/**
	 * 获得当前用户/部门信息/服务器当前时间/会话是否有效
	 */
	public String currentLoginUserInfo() {
		// 获得当前登录用户
		currentUser = FossUserContext.getCurrentUser();
		// 服务器当前时间
		currentServerTime = new Date();
		// 返回
		return returnSuccess();
	}

	/**
	 * 登陆状态设置
	 */
	public void checkEmpStatus() {
		// 前端展示
		writeToPage(loginInfoService.checkStatus(userId, deviceToken));
	}

	/**
	 * 获取casCoolie和sessionId
	 */
	public void getCas() {
		// 根据userId获取
//		LoginCheckBean value = DpmCacheManager.getCookieAndSession(userId);
		
		// 获取验证信息
		String checkValue = null;
		try {
			checkValue = loginRedisService.get(RedisService.DPM_LOGIN_LOGININFO_KEY + userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LoginResult loginResult = null;
		LoginCheckBean value = null;
		if(StringUtils.isNotBlank(checkValue)){
			loginResult = JSON.parseObject(checkValue, LoginResult.class);
		}
		if(null != loginResult){
			value = new LoginCheckBean(loginResult.getSessionId(),loginResult.getCasCookie());
		}
		// 没有说明会话失效
		if (value == null) {
			writeToPage("会话失效，请重新登录");
			// 跳出
			return;
		}
		try {
			// 刷新缓存
			loginRedisService.expire(RedisService.DPM_LOGIN_LOGININFO_KEY + userId,MagicNumber.NUM1800);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回前端sessionId和casCookie
		writeToPage("userId=" + userId + "&casCookie=" + value.getCookie()
				+ "&sessionId=" + value.getCasSessionId());
	}
	
	/**
	 * 校验sessionId和casCookie是否过期
	 */
	@CookieNotCheckedRequired
	public void checkSession() {
		String casCookie = null;
		String sessionId = null;
		
		// 获取登录信息
		String checkValue = null;
		try {
			checkValue = loginRedisService.get(RedisService.DPM_LOGIN_LOGININFO_KEY + userId);
		} catch (Exception e) {
			logger.error("["+userId+"]从redis获取登录信息失败!!!",e);
		}
		
		try {
			// 获取登录结果集
			LoginResult loginResult = null;
			if(StringUtils.isNotBlank(checkValue)) {
				// 获取传递的casCookie和sessionId
				casCookie = ServletActionContext.getRequest().getParameter("casCookie");
				sessionId = ServletActionContext.getRequest().getParameter("sessionId");
				
				// json解析
				loginResult = JSON.parseObject(checkValue, LoginResult.class);
				
				if(loginResult.getCasCookie().equals(casCookie) && loginResult.getSessionId().equals(sessionId)) {
					// 校验成功
					try {
						// 刷新缓存
						loginRedisService.expire(RedisService.DPM_LOGIN_LOGININFO_KEY + userId,MagicNumber.NUM1800);
					} catch (Exception e) {
						logger.error("["+userId+"]刷新redis缓存时间失败!!!",e);
					}
					// 返回成功
					writeToPage("{\"errorCode\":0}");
					return;
				}
			}
		} catch (Exception e) {
			logger.error("校验casCookie和sessionId是否过期失败!!! " +
					"param={userId="+userId+",casCookie="+casCookie+",sessionId="+sessionId+"}");
		}
		
		writeToPage("{\"errorCode\":1}");
	}

	/********************************* 短信 *********************************/
	/**
	 * 短信服务器地址
	 */
	private String smsUrl;
	/**
	 * 业务类型
	 */
	private String smsMsgType;
	/**
	 * 系统来源
	 */
	private String smsSource;
	private String smsEncrypt;
	/**
	 * 短信状态
	 */
	private String smsStatus;

	/**
	 * 获取短信验证码,德邦内部的短信服务器
	 */
	public void getSms() {
		// 获取手机号
		String phone = loginInfoService.getPhone(userId);
		// 定义返回类型
		Result<Object> result = new Result<Object>();
		// 手机号为空
		if (StringUtils.isEmpty(phone)) {
			// 404
			result.setErrorCode(NOTFOUND);
			// 提示信息
			result.setErrorMessage("手机号码为空，请到OA系统中修改");
			// 返回前端
			writeToPage(result);
			// 跳出
			return;
		}
		// 正则表达式
		Pattern p = Pattern.compile("\\d{11}");
		// 匹配字段
		Matcher m = p.matcher(phone.trim());
		// 不匹配
		if (!m.matches()) {
			// 500
			result.setErrorCode(SERVERERROR);
			// 提示信息
			result.setErrorMessage("手机号码格式不正确，请到OA系统中修改");
			// 返回前端
			writeToPage(result);
			// 跳出
			return;
		}
		try {
			// 发送短信
			String sendMessage = SmsSendUtil.sendMessage(phone, smsUrl,
					smsMsgType, smsSource, smsEncrypt);
			// 前端信息返回
			writeToPage(sendMessage);
		} catch (Exception e) {
			e.printStackTrace();
			// 错误信息
			logger.error(e);
		}
		// 前端返回
		writeToPage(result);
	}

	/**
	 * 保存绑定手机设备号信息
	 */
	public void saveInfo() {
		// 校验参数
		if(StringUtils.isNotEmpty(userId) && StringUtils.isNotEmpty(deviceToken)){
			loginInfoService.saveUserIdAndDeviceToken(userId, deviceToken,
					smsStatus);
		}
	}

	/**
	 * 通过工号获取短信状态
	 */
	public void getSmsStatusByEmpCode() {
		// 查询短信状态
		String dbSmsStatus = loginInfoService.existUserIdAndDeviceToken(userId,
				null, false);
		// 判断查询到的短信状态和传过来的短信状态是否一样
		if (dbSmsStatus.equals(smsStatus)) {
			// 前端返回
			writeToPage("{\"result\":\"" + Constants.SUCCESS
					+ "\",\"smsStatus\":\"" + smsStatus + "\"}");
		} else {
			try {
				// 保存
				loginInfoService.saveUserIdAndDeviceToken(userId, deviceToken,
						smsStatus);
				// 前端返回
				writeToPage("{\"result\":\"" + Constants.SUCCESS
						+ "\",\"smsStatus\":\"" + smsStatus + "\"}");
			} catch (Exception e) {
				// 打印
				e.printStackTrace();
				// 前端返回
				writeToPage("{\"result\":\"" + Constants.ACTION_RESULT_ERROR
						+ "\",\"smsStatus\":\"" + dbSmsStatus + "\"}");
			}
		}
	}

	/********************************* 定位 *********************************/
	/**
	 * 纬度
	 */
	private String longitude;
	/**
	 * 经度
	 */
	private String latitude;
	/**
	 * 地址
	 */
	private String location;

	/**
	 * 根据经纬度获取地址
	 * 
	 * @param la
	 * @param lo
	 * @return
	 * @throws Exception
	 */
//	private String getLocation(String la, String lo) throws Exception {
//		// url
//		String url = "http://api.map.baidu.com/geocoder";
//		// 参数
//		String param = "location=" + la + "," + lo
//				+ "&output=json&key=28bcdd84fae25699606ffad27f8da77b";
//		// 返回结果
//		String result = HttpUtil.getHttp(url, param, "utf-8");
//		// 获取结果
//		JSONObject object = ((JSONObject) JSONObject.parseObject(result).get(
//				"result"));
//		// 地址信息
//		object = (JSONObject) object.get("addressComponent");
//		// 省
//		String province = object.getString("province");
//		// 区
//		String district = object.getString("district");
//		// 返回省 + 区
//		return province + district;
//	}

	/**
	 * 手势密码
	 */
	private String gesturePassword;
	/**
	 * 手势密码状态
	 */
	private String inGustureStatus;

	/**
	 * 判断手势密码状态
	 */
	public void getGustureStatusByEmpCode() {
		// 判断是否有手势密码状态，没有将传过来的直接报存，并且返回，若有的话直接更新
		Map<String, Object> result = loginService.getGustureStatus(userId);
		// 获取手势密码状态
		String gustureStatus = (String) result.get("status");
		// 获取数据库中有米有手势密码
		int count = (Integer) result.get("count");
		// 不存在或者count为0都表示没有
		if (null == gustureStatus && count == 0) {
			// 保存手势密码
			loginService.saveGustureStatus(userId, inGustureStatus);
			// 前端返回
			writeToPage("{\"result\":\"" + Constants.SUCCESS
					+ "\",\"gustureStatus\":\"" + inGustureStatus + "\"}");
		} else if (gustureStatus != null
				&& gustureStatus.equals(inGustureStatus)) {
			// 前端返回
			writeToPage("{\"result\":\"" + Constants.SUCCESS
					+ "\",\"gustureStatus\":\"" + inGustureStatus + "\"}");
		} else {
			try {
				// 手势密码更新
				loginService.updateGustureStatus(userId, inGustureStatus);
				// 前端返回
				writeToPage("{\"result\":\"" + Constants.SUCCESS
						+ "\",\"gustureStatus\":\"" + inGustureStatus + "\"}");
			} catch (Exception e) {
				// println
				e.printStackTrace();
				// 前端返回
				writeToPage("{\"result\":\"" + Constants.ACTION_RESULT_ERROR
						+ "\",\"gustureStatus\":\"" + gustureStatus + "\"}");
			}
		}
	}

	/**
	 * 保存手势密码
	 */
	public void saveGesturePassword() {
		// 定义返回结果
		Result<Object> result = new Result<Object>();
		try {
			// 手势密码保存
			loginService.updateGesturePassword(userId, gesturePassword);
			// 提示信息
			result.setData("设置手势密码成功");
		} catch (Exception e) {
			// 错误打印
			e.printStackTrace();
			// errorCode
			result.setErrorCode(1);
			// 提示信息
			result.setData("设置手势密码失败");
		}
		// 前端返回
		writeToPage(result);
	}

	/**
	 * 验证手势密码是否正确
	 */
	public void validateGesturePassword() {
		// 定义返回结果
		Result<Object> result = new Result<Object>();
		try {
			// 验证手势密码是否正确
			boolean validate = loginService.validateGesturePassword(userId,
					gesturePassword);
			// true
			if (validate) {
				// 提示成功
				result.setData("验证手势密码成功");
			} else {
				// errorCode
				result.setErrorCode(1);
				// 提示失败
				result.setData("验证手势密码失败");
			}
			logger.info("手势密码验证结果：" + validate + ",params:{userId="+userId+",gesturePassword="+gesturePassword+"}");
		} catch (Exception e) {
			logger.error("手势密码验证出错！！！params:{userId="+userId+",gesturePassword="+gesturePassword+"}",e);
			// errorCode
			result.setErrorCode(1);
			// 提示失败
			result.setData("验证手势密码失败");
		}
		// 信息提示
		writeToPage(result);
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * set
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * set
	 * 
	 * @param loginName
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * is
	 * 
	 * @return
	 */
	public boolean isDoLogin() {
		return doLogin;
	}

	/**
	 * set
	 * 
	 * @param doLogin
	 */
	public void setDoLogin(boolean doLogin) {
		this.doLogin = doLogin;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getRequestToken() {
		return requestToken;
	}

	/**
	 * set
	 * 
	 * @param requestToken
	 */
	public void setRequestToken(String requestToken) {
		this.requestToken = requestToken;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public UserEntity getCurrentUser() {
		return currentUser;
	}

	/**
	 * set
	 * 
	 * @param currentUser
	 */
	public void setCurrentUser(UserEntity currentUser) {
		this.currentUser = currentUser;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getCurrentServerTime() {
		return currentServerTime;
	}

	/**
	 * set
	 * 
	 * @param currentServerTime
	 */
	public void setCurrentServerTime(Date currentServerTime) {
		this.currentServerTime = currentServerTime;
	}

	/**
	 * set
	 * 
	 * @param appVersionConfigService
	 */
	public void setAppVersionConfigService(
			IAppVersionConfigService appVersionConfigService) {
		this.appVersionConfigService = appVersionConfigService;
	}

	/**
	 * set
	 * 
	 * @param loginInfoService
	 */
	public void setLoginInfoService(ILoginInfoService loginInfoService) {
		this.loginInfoService = loginInfoService;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getOsType() {
		return osType;
	}

	/**
	 * set
	 * 
	 * @param osType
	 */
	public void setOsType(String osType) {
		this.osType = osType;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * set
	 * 
	 * @param appName
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
	 * set
	 * 
	 * @param loginService
	 */
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getLoginType() {
		return loginType;
	}

	/**
	 * set
	 * 
	 * @param loginType
	 */
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getDeviceToken() {
		return deviceToken;
	}

	/**
	 * set
	 * 
	 * @param deviceToken
	 */
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSmsUrl() {
		return smsUrl;
	}

	/**
	 * set
	 * 
	 * @param smsUrl
	 */
	public void setSmsUrl(String smsUrl) {
		this.smsUrl = smsUrl;
	}

	/**
	 * set
	 * 
	 * @param gesturePassword
	 */
	public void setGesturePassword(String gesturePassword) {
		this.gesturePassword = gesturePassword;
	}

	/**
	 * set
	 * 
	 * @param inGustureStatus
	 */
	public void setInGustureStatus(String inGustureStatus) {
		this.inGustureStatus = inGustureStatus;
	}

	/**
	 * set
	 * 
	 * @param longitude
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * set
	 * 
	 * @param latitude
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * set
	 * 
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * set
	 * 
	 * @param smsStatus
	 */
	public void setSmsStatus(String smsStatus) {
		this.smsStatus = smsStatus;
	}

	/**
	 * set
	 * 
	 * @param smsMsgType
	 */
	public void setSmsMsgType(String smsMsgType) {
		this.smsMsgType = smsMsgType;
	}

	/**
	 * set
	 * 
	 * @param smsSource
	 */
	public void setSmsSource(String smsSource) {
		this.smsSource = smsSource;
	}

	/**
	 * set
	 * 
	 * @param smsEncrypt
	 */
	public void setSmsEncrypt(String smsEncrypt) {
		this.smsEncrypt = smsEncrypt;
	}

	/**
	 * set
	 * 
	 * @param newVersion
	 */
	public void setNewVersion(int newVersion) {
		this.newVersion = newVersion;
	}

	/**
	 * get
	 * @return
	 */
	public String getClearHistory() {
		return clearHistory;
	}

	/**
	 * set
	 * @param clearHistory
	 */
	public void setClearHistory(String clearHistory) {
		this.clearHistory = clearHistory;
	}

	/**
	 * get
	 * @return
	 */
	public String getPhoneModel() {
		return phoneModel;
	}

	/**
	 * set
	 * @param phoneModel
	 */
	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}

	/**
	 * get
	 * @return
	 */
	public String getOsVersion() {
		return osVersion;
	}

	/**
	 * set
	 * @param osVersion
	 */
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	/**
	 * get
	 * @return
	 */
	public String getPhoneMac() {
		return phoneMac;
	}

	/**
	 * set
	 * @param phoneMac
	 */
	public void setPhoneMac(String phoneMac) {
		this.phoneMac = phoneMac;
	}
	/**
	 * setter
	 */
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	
	/**
	 * setter
	 */
	public void setPushToken(String pushToken) {
		this.pushToken = pushToken;
	}

	/**
	 * setter
	 */
	public void setuUMSRoleService(IUUMSRoleService uUMSRoleService) {
		this.uUMSRoleService = uUMSRoleService;
	}

	/**
	 * setter
	 */
	public void setLoginRedisService(RedisService loginRedisService) {
		this.loginRedisService = loginRedisService;
	}

	/**
	 * setter
	 */
	public void setEmpBindMacService(IEmpBindMacService empBindMacService) {
		this.empBindMacService = empBindMacService;
	}
}
