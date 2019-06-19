package com.deppon.dpm.module.common.server.util;

/**
 * 常量类
 *
 */
public class CommonConstant {

	/**
	 * 缓存中所有员工的工号/姓名Map
	 */
	public static final String REDIS_KEY_EMPCODEANDEMPNAME_MAP = "DPM_ALL_EMPCODEANDEMPNAME_MAP";
	
	/**
	 * 缓存中需要监控action访问内容的用户List
	 */
	public static final String REDIS_KEY_MONITORACTIONEMPCODE_LIST = "DPM_MONITORACTION_EMPCODE_LIST";
	
	/**
	 * 缓存中需要监控通讯录被查询的vp用户List
	 */
	public static final String REDIS_KEY_MONITOR_TONGXUNLU_VP_LIST = "REDIS_KEY_MONITOR_TONGXUNLU_VP_LIST";
	
}
