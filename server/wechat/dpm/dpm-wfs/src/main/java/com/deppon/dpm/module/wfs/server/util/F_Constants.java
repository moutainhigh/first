package com.deppon.dpm.module.wfs.server.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: F_Constants.java
 * @Package com.deppon.montal.conf
 * @Description: (返回页面URL常量定义)
 * @author 廖建雄
 * @date 2013-2-26 上午8:54:23
 * @version V1.0
 */
public class F_Constants {

	// -------------------- 工作流类型 begin ------------------------------

	// APPLYINFO表中工作流来源标示：来源报账
	public static final String FSSC_WORKFLOW_SYSCODE = "FSSC";
	// APPLYINFO表中工作流来源标示：来源后勤
	public static final String DLSP_WORKFLOW_SYSCODE = "DLSP";
	// APPLYINFO表中工作流来源标示：来源门户二期
	public static final String DWFS_WORKFLOW_SYSCODE = "DWFS";
	// APPLYINFO表中工作流来源标示：来源CRM系统
	public static final String CRM_WORKFLOW_SYSCODE = "ICRM";
	// APPLYINFO表中工作流来源标示：来源FIN_SELF系统
	public static final String FIN_SELF_WORKFLOW_SYSCODE = "FINS";
	// APPLYINFO表中工作流来源标示：来源NHR系统
	public static final String HR_WORKFLOW_SYSCODE = "INHR";
	// 网点规划系统
	public static final String WDGH_WORKFLOW_SYSCODE = "WDGH";
	// 网点规划系统
	public static final String ACMS_WORKFLOW_SYSCODE = "ACMS";
	// 项目管理工具
    public static final String DPPM_WORKFLOW_SYSCODE = "dppm";
	// 老OA工作流标示
	public static final String DIPOA_WORKFLOW_SYSCODE = "DIPOA";

	// /**后勤系统所有工作流*/
	public static String ALL_WORKFLOW_TYPES_LSP = "";

	public static String ALL_WORKFLOW_TYPES_FSSC = "";

	/** CRM系统所有工作流 */
	public static String ALL_WORKFLOW_TYPES_ICRM = "";

	/** FIN_SELF财务自助工作流 */
	public static String ALL_WORKFLOW_TYPES_FIN_SELF = "";
	/** HR工作流 */
	public static String ALL_WORKFLOW_TYPES_HR = "";
	/** WDGH工作流 */
	public static String ALL_WORKFLOW_TYPES_WDGH = "";
	/** ACMS工作流 */
	public static String ALL_WORKFLOW_TYPES_ACMS = "";
	/** 门户二期所有工作流 */
	public static String ALL_WORKFLOW_TYPES_DWFS = "";
	public static String ALL_WORKFLOW_TYPES_DPPM = "";

	public static String ALL_WORKFLOW_TYPES = "";
	public static String ALL_WORKFLOW = "";
	public static Map<String, String> WF_FORWARD_MAP = new HashMap();

	/** 字符串判空返回结果 是返回"" 否 返回真值 */
	public static String chageNull(String str) {
		return str == null ? "" : str;
	}
}
