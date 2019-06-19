package com.deppon.dpm.tongxunlu.server.util;

public class Constants {
	/**
	 * BPM后台应用标示
	 */
	public static final String BPM_RESOURCE_BELONG_SYSTEM_TYPE_WEB = "BPM_WEB";
	/**
	 * 顶级菜单code
	 */
	public static final String MENU_ROOT_CODE = "0";
	
	/**
	 * 请求成功
	 */
	public static final int SUCCESS = 0;
	/**
	 * 请求不正确
	 */
	public static final int WRONG_REQUEST = -1;
	/**
	 * 服务端异常
	 */
	public static final int SERVICE_ERROR = -2;

	public static final String ANDROID = "android";
	
	public static final String PINGGUO = "iphone";
	
	//===================================
	//=======菜单及权限===================
	//===================================
	/**
	 * 有效状态
	 */
	public static final String ACTIVE_YES = "Y";
	/**
	 * 无效状态
	 */
	public static final String ACTIVE_NO = "N";
	
	/**
	 * 员工Code
	 */
	public static final String FRAMEWORK_KEY_EMPCODE = "FRAMEWORK_KEY_EMPCODE";
	/**
	 * 部门
	 */
	public static final String FOSS_KEY_CURRENT_DEPTNAME = "FOSS_KEY_CURRENT_DEPTNAME";
	/**
	 * 角色
	 */
	public static final String FOSS_KEY_CURRENT_ROLES = "FOSS_KEY_CURRENT_ROLES";
	
	//=========================================
	//==============以下通讯录同步状态==========
	//=========================================
	/**
	 * 员工新增类型
	 */
	public static final String EMP_INSERT_TYPE = "1";
	/**
	 * 员工修改类型
	 */
	public static final String EMP_UPDATE_TYPE = "2";
	/**
	 * 员工删除类型
	 */
	public static final String EMP_DELETE_TYPE = "3";
	/**
	 * 员工异动类型
	 */
	public static final String EMP_UPD_ORG_TYPE = "4";
	
	/**
	 * 机构新增类型
	 */
	public static final String ORG_INSERT_TYPE = "1";
	/**
	 * 机构修改类型
	 */
	public static final String ORG_UPDATE_TYPE = "2";
	/**
	 * 机构删除类型
	 */
	public static final String ORG_DELETE_TYPE = "4";
	
	/**
	 * 同步成功状态
	 */
	public static final String SYNC_STATUS_SUCCESS = "0";
	/**
	 * 同步失败状态
	 */
	public static final String SYNC_STATUS_FAIL = "-1";
	/**
	 * 同步警告状态
	 */
	public static final String SYNC_STATUS_WARN = "1";
	
	//================================================
	//=========action成功失败code=====================
	//================================================
	/**
	 * action成功标志
	 */
	public static final int ACTION_RESULT_SUC = 0;
	/**
	 * action失败标志
	 */
	public static final int ACTION_RESULT_ERROR = 1;
}
