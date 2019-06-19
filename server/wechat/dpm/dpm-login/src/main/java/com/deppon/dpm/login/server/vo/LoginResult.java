package com.deppon.dpm.login.server.vo;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.common.shared.domain.EmpExtensionEntity;
import com.deppon.dpm.module.management.shared.domain.ApplyStore;
import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;

/**
 * 登录结果集
 */
public class LoginResult {
	/**
	 * sessionId
	 */
	private String sessionId;
	/**
	 * casCookie
	 */
	private String casCookie;
	/**
	 * sid
	 */
	private String sid;
	/**
	 * version
	 */
	private String version;
	/**
	 * androidVersion
	 */
	private String androidVersion;
	/**
	 * force
	 */
	private String force;
	/**
	 * url
	 */
	private String url;
	/**
	 * roleStr
	 */
	private Map<String, Object> roleStr;
	/**
	 * gustureStatus
	 */
	private String gustureStatus;
	/**
	 * smsStatus
	 */
	private String smsStatus;
	/**
	 * empExtensionEntity
	 */
	private EmpExtensionEntity empExtensionEntity;
	/**
	 * 是否需要短信验证,Y表示需要，N不需要
	 */
	private String sms = "N";
	/**
	 * 是否有手势密码
	 */
	private boolean hasGesturePassword;
	/**
	 * 是否有crm权限
	 */
	private boolean hasCrmPermission;
	/**
	 * 是否有管理工具权限
	 */
	private boolean hasManagePermission;
	/**
	 * 是否有德邦e站（文化社区）
	 */
	private boolean hasECCPermission;
	/**
	 * 是否有BI权限
	 */
	private boolean hasBIPermission;
	/**
	 * 是否有早安快递（早安德邦）权限
	 */
	private boolean hasExpressPermission;
	/**
	 * 是否是文化社区账号
	 */
	private boolean hasECCPrivateAccount;
	/**
	 * 是否有智慧收派权限
	 */
	private boolean hasRDVSPermission;

	/**
	 * 登录时获得考勤打卡
	 */
	private boolean needAttendanceRecord;
	/**
	 * 登陆时获得应用商店排序
	 */
	private String applyStoreSort;
	/**
	 * 有权限的应用
	 */
	private List<Integer> hasPermissionApplys;
	/**
	 * 自动更新的应用
	 */
	private List<Integer> refreshAppIds;
	/**
	 * 需要自动更新的应用信息
	 */
	private List<ApplyStore> refreshApplyStores;
	/**
	 * 登陆时获得资讯排序
	 */
	private String infoStoreSort;
	/**
	 * 登录时获取终端处理信息权限
	 */
	private boolean it;
	/**
	 * userEntity
	 */
	private UserEntity userEntity;
	/**
	 * mac地址绑定的工号
	 */
	private String macEmpCode;
	/**
	 * 当前登录的手机操作系统
	 */
	private String osType;
	/**
	 * 当前登录的手机系统版本
	 */
	private String osVersion;
	/**
	 * 当前登录的手机机型
	 */
	private String phoneModel;
	/**
	 * 当前登录的应用版本号
	 */
	private String appVersion;
	
	/**
	 * 是否需要监控模块异常
	 */
	private boolean monitorUserFunc;
	
	/**
	 * is
	 * 
	 * @return
	 */
	public boolean isHasGesturePassword() {
		return hasGesturePassword;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getInfoStoreSort() {
		return infoStoreSort;
	}

	/**
	 * set
	 * 
	 * @param infoStoreSort
	 */
	public void setInfoStoreSort(String infoStoreSort) {
		this.infoStoreSort = infoStoreSort;
	}

	/**
	 * is
	 * 
	 * @return
	 */
	public boolean isHasECCPrivateAccount() {
		return hasECCPrivateAccount;
	}

	/**
	 * set
	 * 
	 * @param hasECCPrivateAccount
	 */
	public void setHasECCPrivateAccount(boolean hasECCPrivateAccount) {
		this.hasECCPrivateAccount = hasECCPrivateAccount;
	}

	/**
	 * set
	 * 
	 * @param hasGesturePassword
	 */
	public void setHasGesturePassword(boolean hasGesturePassword) {
		this.hasGesturePassword = hasGesturePassword;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * set
	 * 
	 * @param sessionId
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getCasCookie() {
		return casCookie;
	}

	/**
	 * set
	 * 
	 * @param casCookie
	 */
	public void setCasCookie(String casCookie) {
		this.casCookie = casCookie;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSid() {
		return sid;
	}

	/**
	 * set
	 * 
	 * @param sid
	 */
	public void setSid(String sid) {
		this.sid = sid;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Map<String, Object> getRoleStr() {
		return roleStr;
	}

	/**
	 * set
	 * 
	 * @param roleStr
	 */
	public void setRoleStr(Map<String, Object> roleStr) {
		this.roleStr = roleStr;
	}

	/**
	 * @return version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            要设置的 version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return force
	 */
	public String getForce() {
		return force;
	}

	/**
	 * @param force
	 *            要设置的 force
	 */
	public void setForce(String force) {
		this.force = force;
	}

	/**
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            要设置的 url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return androidVersion
	 */
	public String getAndroidVersion() {
		return androidVersion;
	}

	/**
	 * @param androidVersion
	 *            要设置的 androidVersion
	 */
	public void setAndroidVersion(String androidVersion) {
		this.androidVersion = androidVersion;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public UserEntity getUserEntity() {
		return userEntity;
	}

	/**
	 * set
	 * 
	 * @param userEntity
	 */
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public EmpExtensionEntity getEmpExtensionEntity() {
		return empExtensionEntity;
	}

	/**
	 * set
	 * 
	 * @param empExtensionEntity
	 */
	public void setEmpExtensionEntity(EmpExtensionEntity empExtensionEntity) {
		this.empExtensionEntity = empExtensionEntity;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSms() {
		return sms;
	}

	/**
	 * set
	 * 
	 * @param sms
	 */
	public void setSms(String sms) {
		this.sms = sms;
	}

	/**
	 * is
	 * 
	 * @return
	 */
	public boolean isHasCrmPermission() {
		return hasCrmPermission;
	}

	/**
	 * set
	 * 
	 * @param hasCrmPermission
	 */
	public void setHasCrmPermission(boolean hasCrmPermission) {
		this.hasCrmPermission = hasCrmPermission;
	}

	/**
	 * is
	 * 
	 * @return
	 */
	public boolean isHasManagePermission() {
		return hasManagePermission;
	}

	/**
	 * set
	 * 
	 * @param hasManagePermission
	 */
	public void setHasManagePermission(boolean hasManagePermission) {
		this.hasManagePermission = hasManagePermission;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getGustureStatus() {
		return gustureStatus;
	}

	/**
	 * set
	 * 
	 * @param gustureStatus
	 */
	public void setGustureStatus(String gustureStatus) {
		this.gustureStatus = gustureStatus;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSmsStatus() {
		return smsStatus;
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
	 * get
	 * 
	 * @return
	 */
	public String getApplyStoreSort() {
		return applyStoreSort;
	}

	/**
	 * set
	 * 
	 * @param applyStoreSort
	 */
	public void setApplyStoreSort(String applyStoreSort) {
		this.applyStoreSort = applyStoreSort;
	}

	/**
	 * is
	 * 
	 * @return
	 */
	public boolean isHasECCPermission() {
		return hasECCPermission;
	}

	/**
	 * set
	 * 
	 * @param hasECCPermission
	 */
	public void setHasECCPermission(boolean hasECCPermission) {
		this.hasECCPermission = hasECCPermission;
	}

	/**
	 * is
	 * 
	 * @return
	 */
	public boolean isHasExpressPermission() {
		return hasExpressPermission;
	}

	/**
	 * set
	 * 
	 * @param hasExpressPermission
	 */
	public void setHasExpressPermission(boolean hasExpressPermission) {
		this.hasExpressPermission = hasExpressPermission;
	}
	
	/**
	 * is
	 * @return
	 */
	public boolean isHasRDVSPermission() {
		return hasRDVSPermission;
	}
	
	/**
	 * set
	 * @param hasRDVSPermission
	 */
	public void setHasRDVSPermission(boolean hasRDVSPermission) {
		this.hasRDVSPermission = hasRDVSPermission;
	}

	/**
	 * is
	 * 
	 * @return
	 */
	public boolean isNeedAttendanceRecord() {
		return needAttendanceRecord;
	}

	/**
	 * set
	 * 
	 * @param needAttendanceRecord
	 */
	public void setNeedAttendanceRecord(boolean needAttendanceRecord) {
		this.needAttendanceRecord = needAttendanceRecord;
	}

	/**
	 * is
	 * 
	 * @return
	 */
	public boolean isIt() {
		return it;
	}

	/**
	 * set
	 * 
	 * @param it
	 */
	public void setIt(boolean it) {
		this.it = it;
	}

	/**
	 * get
	 * @return
	 */
	public boolean isHasBIPermission() {
		return hasBIPermission;
	}

	/**
	 * set
	 * @param hasBIPermission
	 */
	public void setHasBIPermission(boolean hasBIPermission) {
		this.hasBIPermission = hasBIPermission;
	}

	/**
	 * getter
	 * @return
	 */
	public List<Integer> getHasPermissionApplys() {
		return hasPermissionApplys;
	}

	/**
	 * setter
	 * @param hasPermissionApplys
	 */
	public void setHasPermissionApplys(List<Integer> hasPermissionApplys) {
		this.hasPermissionApplys = hasPermissionApplys;
	}

	public String getMacEmpCode() {
		return macEmpCode;
	}

	public void setMacEmpCode(String macEmpCode) {
		this.macEmpCode = macEmpCode;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getPhoneModel() {
		return phoneModel;
	}

	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}

	public List<Integer> getRefreshAppIds() {
		return refreshAppIds;
	}

	public void setRefreshAppIds(List<Integer> refreshAppIds) {
		this.refreshAppIds = refreshAppIds;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public List<ApplyStore> getRefreshApplyStores() {
		return refreshApplyStores;
	}

	public void setRefreshApplyStores(List<ApplyStore> refreshApplyStores) {
		this.refreshApplyStores = refreshApplyStores;
	}

	public boolean isMonitorUserFunc() {
		return monitorUserFunc;
	}

	public void setMonitorUserFunc(boolean monitorUserFunc) {
		this.monitorUserFunc = monitorUserFunc;
	}

}
