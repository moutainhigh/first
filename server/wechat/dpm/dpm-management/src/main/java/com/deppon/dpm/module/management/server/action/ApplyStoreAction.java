package com.deppon.dpm.module.management.server.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.service.IUUMSRoleService;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.service.IApplyStoreService;
import com.deppon.dpm.module.management.shared.domain.ApplyDevice;
import com.deppon.dpm.module.management.shared.domain.ApplyStore;
import com.deppon.dpm.module.management.shared.domain.ApplyStoreAppraise;
import com.deppon.dpm.module.management.util.Constants;
import com.deppon.dpm.tongxunlu.server.service.ISystemConfigService;
import com.deppon.dpm.tongxunlu.server.service.ITongxunLuService;
import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

/**
 * 应用商店action
 * 
 * @author 245968
 * 
 */
public class ApplyStoreAction extends BaseAction {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3351811189867015036L;
	
	/**
	 * 日志
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplyStoreAction.class);
	/**
	 * 应用下载
	 */
	private final int DOWNTYPE_1 = 1;
	/**
	 * 应用卸载
	 */
	private final int DOWNTYPE_2 = 2;
	/**
	 * 应用状态：更新状态
	 */
	private final int APPTYPE_3 = 3;
	/**
	 * 应用状态：已安装状态
	 */
	private final int APPTYPE_2 = 2;
	/**
	 * set injection
	 */
	private IApplyStoreService iApplyStoreService;
	/**
	 * 监控service
	 */
	private ISystemConfigService systemConfigService;
	/**
	 * tongxunluServce
	 */
	private ITongxunLuService tongxunLuService;
	/**
	 * 请求uums角色信息
	 */
	private IUUMSRoleService uUMSRoleService;
	/**
	 * 应用的id
	 */
	private int appId;

	/**
	 * 设备号
	 */
	private String deviceToken;
	/**
	 * 设备类型
	 */
	private String osType;
	/**
	 * 版本号
	 */
	private String appVersion;
	/**
	 * 手机端传过来的排序
	 */
	private String sortStr;
	/**
	 * 传过来的员工等级
	 */
	private String jobLevel;
	/**
	 * 应用状态，1：未安装；2：已安装；3：更新
	 */
	private String appType;

	/**
	 * 应用评论当前页
	 */
	private String currentPage = "1";
	/**
	 * 应用评论显示条数
	 */
	private String pageSize = "10";
	/**
	 * 应用评论对象
	 */
	private ApplyStoreAppraise appraise;
	/**
	 * 应用商店分包：为了12月10号的版本能够使用<br>
	 * 老版本APP应用都是走原生应用
	 * 3 是12月24号版本
	 * 4是01.12版本
	 */
	private int newVersion;

	/**
	 * 根据工号获取用户的应用商店列表--安装状态和下载数量
	 */
	@SuppressWarnings("unchecked")
	public void list() {
		// 结果集定义
		Result<Object> result = new Result<Object>();
		try {
			// 获取角色信息
			String roleStr = uUMSRoleService.getRoles(userId);
			// 解析
			List<String> roleList = (List<String>)JSONObject.parseObject(roleStr).get("roleCodes");
			// 构造实体
			EmployeeVO employeeVO = new EmployeeVO();
			// 设置
			employeeVO.setEmpCode(userId);
			// 查询员工详情
			EmployeeEntity employeeEntity = tongxunLuService.selectOne(employeeVO);
			// 获取对应工号的应用商店列表
			List<ApplyStore> list = iApplyStoreService.list(employeeEntity,roleList,osType,appVersion);
			// 获取列表排序
			String sort = iApplyStoreService.getSort(userId);
			// 不为空
			if (StringUtils.isNotEmpty(sort)) {
				// 转换为集合
				List<String> asList = Arrays.asList(sort.split(","));
				// 处理应用商店列表
				dealApplyStoreList(list, asList);
			}
			// 应用列表排序，未安装，更新应用排在前面
//			list = sequenceList(list);

			// 结果集展示
			result.setData(list);
			// count
			result.setCount(list.size());
			// errorMessage
			result.setErrorMessage("获取应用商店列表成功");
		} catch (Exception e) {
			LOGGER.info("------应用商店list方法-----"+e);
			// errorCode
			result.setErrorCode(2);
			// errorMessage
			result.setErrorMessage("获取应用商店列表失败");
		}
		// 返回前端
		writeToPage(result);
	}

	/**
	 * 处理应用商店列表，返回应用状态 1：未安装；2：已安装；3：更新 首页应用列表,现不根据用户显示,根据设备号显示 2015-11-25
	 * 12月24增加版本控制newVersion，老版本应用商店应用都是走原生应用
	 */
	private void dealApplyStoreList(List<ApplyStore> list, List<String> asList) {
		// 设备号对应应用版本号信息对象
		Map<Integer, String> deviceMap = getApplyDeviceMap();
		// 循环
		for (ApplyStore store : list) {
			// 应用编号
			int appId = store.getAppId();
			// 是否是应用商店应用 1：是 0：不是
			String defaultApp = store.getDefaultApp();
			// 不需要更新H5资源默认显示在应用列表 0：不需要，1：需要
			String hasResources = store.getHasResources();
			// 应用最新版本号
			String versionType = store.getVersionType();
			// 设备应用版本号
			String deviceType = deviceMap.get(appId);
			if ("0".equals(defaultApp)) {
				// 展示
				store.setOpen(true);
				// 如果既是默认应用，又是H5应用
				if("1".equals(hasResources)){
					if(StringUtils.isNotBlank(deviceType)){
						// 应用状态
						store.setAppType(checkVersionType(versionType, deviceType));
					} else {
						// 如果设备从未记录过该应用的版本信息，直接设置为更新
						store.setAppType(MagicNumber.NUM3);
					}
				} else {
					store.setAppType(APPTYPE_2);
				}
			} 
			
			else if (("0".equals(hasResources) || newVersion != Constants.NEWVERSION)
					&& asList.contains(String.valueOf(appId))) {
				// 展示
				store.setOpen(true);
				// 原生应用商店应用如果首页安装了，则显示已安装
				store.setAppType(APPTYPE_2);
			} 
			
			else if("1".equals(hasResources) && asList.contains(String.valueOf(appId))){
				if(StringUtils.isNotBlank(deviceType)){
					// 应用状态
					store.setAppType(checkVersionType(versionType, deviceType));
				} else {
					// 如果该设备没有安装过此H5应用，直接显示更新
					store.setAppType(MagicNumber.NUM3);
				}
				// 展示
				store.setOpen(true);
			}
		}
	}

	/**
	 * Map::应用编号 对应应用版本号
	 * 
	 * @return
	 */
	private Map<Integer, String> getApplyDeviceMap() {
		// 设备号对应应用版本号信息对象
		Map<Integer, String> deviceMap = new HashMap<Integer, String>();
		if (StringUtils.isNotEmpty(deviceToken)) {
			// 查询条件
			ApplyDevice device = new ApplyDevice();
			device.setDeviceToken(deviceToken);
			// 根据设备号返回应用版本号信息
			List<ApplyDevice> deviceList = iApplyStoreService
					.getApplyDeviceList(device);
			if (deviceList != null && deviceList.size() > 0) {
				// 转换Map
				for (ApplyDevice applyDevice : deviceList) {
					// 应用编号 对应应用版本号
					deviceMap.put(applyDevice.getApplyStoreId(),
							applyDevice.getVersionType());
				}
			}
		}
		return deviceMap;
	}

	/**
	 * 判断设备中应用是否是最新
	 * 
	 * @param versionType
	 *            应用最新版本号
	 * @param deviceType
	 *            设备应用版本号
	 * @return
	 */
	private int checkVersionType(String versionType, String deviceType) {
		// 返回值
		int type = APPTYPE_3;
		// 应用最新版本号是否为空 有值说明此应用需要资源更新
		if (StringUtils.isNotBlank(versionType)
				&& versionType.replaceAll("\\.", "").matches("^[0-9]*$")) {
			// 设备版本号为空，默认走更新
			if (StringUtils.isNotBlank(deviceType)
					&& deviceType.replaceAll("\\.", "").matches("^[0-9]*$")) {
				// 应用最新版本号
				int versionTypeInt = Integer.valueOf(versionType.replaceAll(
						"\\.", ""));
				// 设备应用版本号
				int deviceTypeInt = Integer.valueOf(deviceType.replaceAll(
						"\\.", ""));
				// 设备应用版本号 等于 应用最新版本号 无需更新
				if (versionTypeInt == deviceTypeInt) {
					type = APPTYPE_2;
				}
			}
		} else {
			// 应用最新版本号为空 无需更新资源
			type = APPTYPE_2;
		}
		return type;
	}

	/**
	 * 应用列表排序，更新、未安装应用排在前面 appType 1：未安装；2：已安装；3：更新
	 */
//	private List<ApplyStore> sequenceList(List<ApplyStore> list) {
//		// 未安装应用
//		List<ApplyStore> list1 = new ArrayList<ApplyStore>();
//		// 已安装应用
//		List<ApplyStore> list2 = new ArrayList<ApplyStore>();
//		// 更新应用
//		List<ApplyStore> list3 = new ArrayList<ApplyStore>();
//		for (ApplyStore app : list) {
//			int appType = app.getAppType();
//			if (appType == 1) {
//				list1.add(app);
//			} else if (appType == APPTYPE_3) {
//				list3.add(app);
//			} else {
//				list2.add(app);
//			}
//		}
//		list = new ArrayList<ApplyStore>();
//		list.addAll(list3);
//		list.addAll(list1);
//		list.addAll(list2);
//		return list;
//		/*
//		 * Collections.sort(list, new Comparator(){
//		 * 
//		 * @Override public int compare(Object arg0, Object arg1) { ApplyStore
//		 * app = (ApplyStore)arg0; int obj0 = app.getAppType(); if(obj0==1 ||
//		 * obj0==3){ return -1; }else{ return 1; } } });
//		 */
//	}

	/**
	 * 安装下载应用模块
	 */
	public void download() {
		// 结果集定义
		Result<Object> result = new Result<Object>();
		try {
			// 更新状态不记录下载数量
			if (!"3".equals(appType)) {
				// 下载
				iApplyStoreService.download(userId, appId);
			}
			// 保存设备对应的应用版本号
			if (StringUtils.isNotBlank(deviceToken) && appId != 0) {
				ApplyDevice device = new ApplyDevice();
				device.setDeviceToken(deviceToken);
				device.setOsType(osType);
				device.setApplyStoreId(appId);
				iApplyStoreService.saveApplyDeviceByAppId(device,newVersion);
				
				// 监控应用下载
				systemConfigService.dataMonitorDownload(userId,appId,DOWNTYPE_1,osType);
			}
			// 提示信息
			result.setResult("安装成功");
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(1);
			// 提示信息
			result.setResult("安装失败");
		}
		// 返回前端
		writeToPage(result);
	}

	/**
	 * 保存应用模块排序
	 */
	public void sort() {
		// 结果集定义
		Result<Object> result = new Result<Object>();
		try {
			// 删除设备对应的应用版本号
			if (StringUtils.isNotBlank(deviceToken)) {
				deleteApplyDevice();
			}
			// 保存排序
			iApplyStoreService.sort(userId, sortStr);
			// 提示
			result.setResult("保存排序成功");
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(1);
			// 提示信息
			result.setResult("保存排序失败");
		}
		// 返回前端
		writeToPage(result);
	}

	/**
	 * 返回用户需要安装、更新的应用数量
	 * 12月24增加版本控制newVersion=3，老版本应用商店应用都是走原生应用
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void updateAppCount() {
		// 结果集定义
		Result<Object> result = new Result<Object>();
		try {
			// 获取角色信息
			String roleStr = uUMSRoleService.getRoles(userId);
			// 解析
			List<String> roleList = (List<String>)JSONObject.parseObject(roleStr).get("roleCodes");
			// 构造实体
			EmployeeVO employeeVO = new EmployeeVO();
			// 设置
			employeeVO.setEmpCode(userId);
			// 查询员工详情
			EmployeeEntity employeeEntity = tongxunLuService.selectOne(employeeVO);
			// 获取对应工号的应用商店列表
			List<ApplyStore> list = iApplyStoreService.list(employeeEntity,roleList,osType,appVersion);
			// 获取列表排序
			String sort = iApplyStoreService.getSort(userId);
			int count = 0;
			// 不为空
			if (StringUtils.isNotEmpty(sort)) {
				// 转换为集合
				List<String> asList = Arrays.asList(sort.split(","));
				// 计算未安装、更新应用数量 判断逻辑保持与获取应用商店列表一致
				// 设备号对应应用版本号信息对象
				Map<Integer, String> deviceMap = getApplyDeviceMap();
				// 循环
				for (ApplyStore store : list) {
					// 应用编号
					int appId = store.getAppId();
					// 是否是应用商店应用 1：是 0：不是
					String defaultApp = store.getDefaultApp();
					// 不需要更新H5资源默认显示在应用列表 0：不需要，1：需要
					String hasResources = store.getHasResources();
					// 应用最新版本号
					String versionType = store.getVersionType();
					// 设备应用版本号
					String deviceType = deviceMap.get(appId);
					// 默认应用
					if ("0".equals(defaultApp)) {
						if(("1".equals(hasResources) && StringUtils.isEmpty(deviceType))
								|| checkVersionType(versionType, deviceType) == APPTYPE_3) {
							count++;
						}
					} 
					
					else if (("0".equals(hasResources) || newVersion != Constants.NEWVERSION)
							&& !asList.contains(String.valueOf(appId))) {
						// 如果是原生应用并且首页排序字符串不包含此应用商店的应用，那么说明没有安装该应用，小红点+1
						count++;
					} 
					
					else if("1".equals(hasResources)) {
						if(asList.contains(String.valueOf(appId))) {
							// 如果是H5应用并且首页安装了，如果设备没有记录该应用版本或者是记录的版本不一致则小红点++
							if (StringUtils.isEmpty(deviceType) || checkVersionType(versionType, deviceType) == APPTYPE_3) {
								count++;
							}
						} else {
							count++;
						}
					}
				}
			} else {
				// 用户列表无应用，这未安装数量为应用全部数量
				// 基本不可能走
				count = list.size();
			}
			// count
			result.setCount(count);
			// errorMessage
			result.setErrorMessage("获取未安装应用数量成功");
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(2);
			// errorMessage
			result.setErrorMessage("获取未安装应用数量失败");
		}
		// 返回前端
		writeToPage(result);
	}
	
	/**
	 * 删除设备对应的应用版本号
	 */
	private void deleteApplyDevice() {
		// 新列表排序
		List<String> newList = new ArrayList<String>();
		// 不为空
		if (StringUtils.isNotEmpty(sortStr)) {
			// 转换为集合
			newList = Arrays.asList(sortStr.split(","));
		}
		// 获取原始列表排序
		String sort = iApplyStoreService.getSort(userId);
		// 不为空
		if (StringUtils.isNotEmpty(sort)) {
			List<Integer> appIdList = new ArrayList<Integer>();
			// 转换为集合
			List<String> oldList = Arrays.asList(sort.split(","));
			for (String str : oldList) {
				// 新应用列表中无此应用 删除设备对应的应用版本号数据
				if (!newList.contains(str)) {
					appIdList.add(Integer.valueOf(str));
					// 监控应用卸载  需要监控每个应用的卸载信息
					systemConfigService.dataMonitorDownload(userId,Integer.valueOf(str),DOWNTYPE_2,osType);
				}
			}
			// 如果没有要删除的应用 默认加0
			if (appIdList.size() == 0) {
				appIdList.add(0);
			}
			ApplyDevice device = new ApplyDevice();
			device.setDeviceToken(deviceToken);
			device.setAppIdList(appIdList);
			// 删除
			iApplyStoreService.deleteApplyDevice(device);
		}
	}

	/**
	 * 删除设备对应的所有应用版本号 用户删除整个应用的情况,为ios服务 不用
	 */
	@Deprecated
	public void delAllDevice() {
		// 结果集定义
		Result<Object> result = new Result<Object>();
		try {
			// 删除设备对应的应用版本号
			if (StringUtils.isNotBlank(deviceToken)) {
				ApplyDevice device = new ApplyDevice();
				device.setDeviceToken(deviceToken);
				// 删除
				// iApplyStoreService.deleteApplyDevice(device);
				result.setCount(1);
				result.setResult("删除设备应用版本号成功");
			} else {
				result.setErrorCode(1);
				// 提示
				result.setResult("删除设备应用版本号失败");
			}
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(1);
			// 提示信息
			result.setResult("删除设备应用版本号失败");
		}
		// 返回前端
		writeToPage(result);
	}

	/**
	 * 获取应用模块排序
	 */
	public void getSort() {
		// 返回前端
		writeToPage(iApplyStoreService.getSort(userId));
	}

	/**
	 * 根据应用id获取应用详情列表 包括应用评论
	 */
	public void appInfo() {
		// 结果集定义
		Result<Object> result = new Result<Object>();
		try {
			// 工号是否为空
			if (appId != 0 && currentPage.matches("^[0-9]*$")
					&& pageSize.matches("^[0-9]*$")) {
				// 当前页
				int page = Integer.valueOf(currentPage);
				// 多少条
				int size = Integer.valueOf(pageSize);
				// 开始
				int begin = (page - 1) * size;
				// 应用详情
				ApplyStore applyStore = iApplyStoreService.getApplyStoreById(
						appId, userId, begin, size);
				// 返回数据
				result.setData(applyStore != null ? applyStore : new ApplyStore());
				result.setCount(applyStore != null ? 1 : 0);
			} else {
				// errorCode
				result.setErrorCode(1);
				// 提示信息
				result.setResult("请求参数有误");
			}
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(1);
			// 提示信息
			result.setResult("获取应用详情列表失败");
		}
		// 返回前端
		writeToPage(result);
	}

	/**
	 * 用户评论应用
	 */
	public void appraise() {
		// 结果集定义
		Result<Object> result = new Result<Object>();
		try {
			// 判断是否为空
			if (appraise != null) {
				// 生成别名
				appraise.setAlias("APP" + Math.round(Math.random() * MagicNumber.NUM100000));
				// 插入动作
				int count = iApplyStoreService.insertApplyStoreAppraise(appraise);
				result.setCount(count);
			} else {
				// errorCode
				result.setErrorCode(1);
				// 提示信息
				result.setResult("请求参数有误");
			}
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(1);
			// 提示信息
			result.setResult("用户评论应用失败");
		}
		// 返回前端
		writeToPage(result);
	}

	/**
	 * 获取应用评论列表
	 */
	public void appraiseList() {
		// 结果集定义
		Result<Object> result = new Result<Object>();
		try {
			// 工号是否为空
			if (appId != 0 && currentPage.matches("^[0-9]*$")
					&& pageSize.matches("^[0-9]*$")) {
				// 当前页
				int page = Integer.valueOf(currentPage);
				// 多少条
				int size = Integer.valueOf(pageSize);
				// 开始
				int begin = (page - 1) * size;
				// 查询条件
				ApplyStoreAppraise entity = new ApplyStoreAppraise();
				entity.setAppId(appId);
				// 应用评论列表
				List<ApplyStoreAppraise> appraiseList = iApplyStoreService
						.getApplyStoreAppraiseList(entity, begin, size);
				// 返回数据
				result.setData(appraiseList);
				result.setCount(appraiseList != null ? appraiseList.size():0);
			} else {
				// errorCode
				result.setErrorCode(1);
				// 提示信息
				result.setResult("请求参数有误");
			}
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(1);
			// 提示信息
			result.setResult("获取应用评论列表失败");
		}
		// 返回前端
		writeToPage(result);
	}
	
	/**
	 * 为H5提供的接口，查询该H5应用是否有更新
	 */
	public void queryHasUpdate(){
		try {
			if(StringUtils.isBlank(deviceToken) || StringUtils.isBlank(osType) || appId == 0){
				// 不需要更新
				writeToPage("{\"hasUpdate\":0}");
				LOGGER.info("查询应用是否需要更新，参数不合法！   {appId = "+appId+",deviceToken = "+deviceToken+",osType = "+osType+"}");
				return;
			}
			boolean hasUpdate = this.iApplyStoreService.queryHasUpdate(appId,deviceToken,osType);
			if(hasUpdate){
				// 需要更新
				writeToPage("{\"hasUpdate\":1}");
				return;
			}
			// 不需要更新
			writeToPage("{\"hasUpdate\":0}");
		} catch (Exception e) {
			LOGGER.error("查询应用是否需要更新失败！  {appId = "+appId+",deviceToken = "+deviceToken+",osType = "+osType+"}",e);
		}
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public IApplyStoreService getiApplyStoreService() {
		return iApplyStoreService;
	}

	/**
	 * set
	 * 
	 * @param iApplyStoreService
	 */
	public void setiApplyStoreService(IApplyStoreService iApplyStoreService) {
		this.iApplyStoreService = iApplyStoreService;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getJobLevel() {
		return jobLevel;
	}

	/**
	 * set
	 * 
	 * @param jobLevel
	 */
	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getAppId() {
		return appId;
	}

	/**
	 * set
	 * 
	 * @param appId
	 */
	public void setAppId(int appId) {
		this.appId = appId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSortStr() {
		return sortStr;
	}

	/**
	 * set
	 * 
	 * @param sortStr
	 */
	public void setSortStr(String sortStr) {
		this.sortStr = sortStr;
	}

	/**
	 * get
	 */
	public String getDeviceToken() {
		return deviceToken;
	}

	/**
	 * set
	 */
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	/**
	 * get
	 */
	public String getOsType() {
		return osType;
	}

	/**
	 * set
	 */
	public void setOsType(String osType) {
		this.osType = osType;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAppType() {
		return appType;
	}

	/**
	 * set
	 * 
	 * @param appType
	 */
	public void setAppType(String appType) {
		this.appType = appType;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getCurrentPage() {
		return currentPage;
	}

	/**
	 * set
	 * 
	 * @param currentPage
	 */
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getPageSize() {
		return pageSize;
	}

	/**
	 * set
	 * 
	 * @param pageSize
	 */
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public ApplyStoreAppraise getAppraise() {
		return appraise;
	}

	/**
	 * set
	 * 
	 * @param appraise
	 */
	public void setAppraise(ApplyStoreAppraise appraise) {
		this.appraise = appraise;
	}

	/**
	 * get
	 * @return
	 */
	public int getNewVersion() {
		return newVersion;
	}

	/**
	 * set
	 * @param newVersion
	 */
	public void setNewVersion(int newVersion) {
		this.newVersion = newVersion;
	}

	/**
	 * get
	 * @return
	 */
	public ISystemConfigService getSystemConfigService() {
		return systemConfigService;
	}

	/**
	 * set
	 * @param systemConfigService
	 */
	public void setSystemConfigService(ISystemConfigService systemConfigService) {
		this.systemConfigService = systemConfigService;
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
	public void setTongxunLuService(ITongxunLuService tongxunLuService) {
		this.tongxunLuService = tongxunLuService;
	}
	
	/**
	 * setter
	 */
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	
}
