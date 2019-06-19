package com.deppon.dpm.module.wfs.util;

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
	 * 设置连接超时时间(单位毫秒)
	 */
	public static final int HTTP_READ_TIME = 50000;
	/**
	 *  设置读数据超时时间(单位毫秒)
	 */
	public static final int HTTP_SO_TIMEOUT = 30000;
	/**
	 *  加密
	 */
	public static final int HTTP_PROTOCOL = 443;
	/**
	 * 数组长度
	 */
	public static final int ARRAY_LENGTH = 4096;

	
	
	//常量6
	public static final int CONSTANT_SIX = 6;
	//常量5
	public static final int CONSTANT_FIVE = 5;
	//常量3
	public static final int CONSTANT_THREE = 3;
	//常量4
	public static final int CONSTANT_FOUR = 4;
	//常量2
	public static final int CONSTANT_TWO = 2;
	//常量1
	public static final int CONSTANT_ONE = 1;
	
	//项目发起人 
	public static final int PROJECT_LEAD = 101;
	//甲方项目发起人
	public static final int  APROJECT_MANAGER = 102;
	//乙方项目发起来
	public static final int  BPROJECT_MANAGER= 100;
	//内部员工
	public static final int  INTERNAL_STAFF= 1;
	//min length
	public static final int  MIN_LENGTH= 10;
	//max_length
	public static final int  MAX_LENGTH= 30;
	//工作流开关状态
	public static final int  WORKFLOW_STATUS= 1800;
	
	
	public static final int  HOUR_MIN= 3600;
	public static final int  THOUSAND= 1000;
	public static final int  TEN= 10;
	public static final int  DAY_HOUR= 24;
	
	
	
	//分页大小
	public static final int PAGE_SIZE = 10;
}
