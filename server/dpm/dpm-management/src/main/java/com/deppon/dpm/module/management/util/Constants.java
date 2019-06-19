package com.deppon.dpm.module.management.util;

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
	
	
	

	/**
	 * 工程验收待检查状态
	 */
	public static final int PROC_CHECK_AWAITING = 0;
	/**
	 * 工程验收初次按钮点击之前
	 */
	public static final int PROC_CHECK_STOP = 1;
	/**
	 * 工程验收初次按钮点击之后
	 */
	public static final int PROC_CHECK_END = 2;
	/**
	 * 工程验收最终按钮点击之后
	 */
	public static final int PROC_CHECK_FINISH = 3;
	/**
	 * 工程巡检默认分数
	 */
	public static final double PROC_MANAGER_SOCER = -100d;
	/**
	 * 工程巡检缓存里没有数据，变为100000
	 * cacheProId
	 */
	public static final int PROC_CACHCHE_PROID = 100000;
	
	/**
	 * 设置连接超时时间(单位毫秒)
	 */
	public static final int HTTP_CON_TIMEOUT = 60000;
	/**
	 *  设置读数据超时时间(单位毫秒)
	 */
	public static final int HTTP_SO_TIMEOUT = 30000;
	/**
	 *  加密
	 */
	public static final int HTTP_PROTOCOL = 443;
	/**
	 *  收发室签收
	 */
	public static final int MailRecSen_Received = 1;
	/**
	 *  收发室拒收
	 */
	public static final int MailRecSen_Reject = 3;
	/**
	 *  收发室注销
	 */
	public static final int MailRecSen_Logout = 2;
	/**
	 *  收发室催领
	 */
	public static final int MailRecSen_Corporal = 4;
	/*
	 * 工程巡检权限
	 */
	public static final int Manager_Right = 1;
	/*
	 * 工程验收权限
	 */
	public static final int Check_Right = 2;
	/*
	 * 工程维修权限
	 */
	public static final int Maintain_Right = 3;
	/*
	 * 工程勘测权限
	 */
	public static final int Survey_Right = 4;
	/*
	 * 工程维修status异常标志
	 */
	public static final int PROC_MAINTAIN_STATUS = -1000;
	
	//常量6
	public static final int CONSTANT_SIX = 6;
	//常量5
	public static final int CONSTANT_FIVE = 5;
	//常量3
	public static final int CONSTANT_THREE = 3;
	//常量4
	public static final int CONSTANT_FOUR = 4;
	
	//两小时毫秒数
	public static final Long CONSTANT_TWO_HOUR = 2*60*60*1000L;
	//半小时毫秒数
	public static final Long CONSTANT_HALF_HOUR = 30*60*1000L;
	
	//消息推送-表示a
	public static final String APP_MARK_A = "14";
	//消息推送-表示b
	public static final int APP_MARK_B = 8;
	//消息推送-表示c
	public static final int APP_MARK_C = 0;
	//消息推送-表示d
	public static final int APP_MARK_D = 1;
	
	public static final int IS_ADMIN = 3;
	
	
	/**
	 * 版本号，
	 * 12.24版本 ：3，
	 * 01.12版本 ：4
	 */
	public static final int NEWVERSION = 4;

	/**
	 * 3
	 */
	public static final int PROC_SURV_THREE = 3;
	/**
	 * 4
	 */
	public static final int PROC_SURV_FOUR = 4;
	    //ProcRecordService
	public static final int PROC_TIME = 6000000;
		//数字10
	public static final int PROC_TEN = 10;
}
