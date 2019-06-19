package com.deppon.dpm.module.common.shared.define;

public class DpmConstants {

	/**
	 * cas失效编码
	 */
	public static final int sessionInvalid = 9999;

	/**
	 * 监控日程级别
	 */
	public static final int MONITOR_LEVEL = 7;

	/**
	 * 监控日程族群
	 */
	public static final String MONITOR_GROUPS = "管理族群";
	/**
	 * MONITOR_SUCCESS
	 */
	public static final String MONITOR_SUCCESS = "SUCCESS";
	/**
	 * DPM_IS_NUM
	 */
	public static final String DPM_IS_NUM = "[0-9]+";
	// -------------------------------推送类型开始
	/**
	 * 我的工资条
	 */
	public static final int TPUSH_WAGE = 0;
	/**
	 * HR自助
	 */
	public static final int TPUSH_HR_HELP = 1;
	/**
	 * 系统通知
	 */
	public static final int TPUSH_SYSTEM_NOTIFY = 2;
	/**
	 * 固定资产
	 */
	public static final int TPUSH_FIXED_ASSETS = 3;
	/**
	 * it服务台
	 */
	public static final int TPUSH_IT_PLATFORM = 4;
	/**
	 * 我的任务
	 */
	public static final int TPUSH_MY_TASK = 5;
	/**
	 * 工作流
	 */
	public static final int TPUSH_WORK_FLOW = 6;
	/**
	 * 差旅助手
	 */
	public static final int TPUSH_TRAVEL_ASSISTANT = 7;
	/**
	 * 工程管理
	 */
	public static final int TPUSH_PROJECT_MANAGMENT = 8;
	/**
	 * 收发室
	 */
	public static final int TPUSH_IN_OUT = 9;
	/**
	 * 德邦e站
	 */
	public static final int TPUSH_DEPPON_E = 10;
	/**
	 * 发现
	 */
	public static final int TPUSH_DISCOVERY = 11;
	/**
	 * 移动CRM
	 */
	public static final int TPUSH_CRM = 12;
	/**
	 * 移动BI
	 */
	public static final int TPUSH_BI = 13;
	/**
	 * 收派助手
	 */
	public static final int TPUSH_EXPRESS_VISUALIZE = 14;
	/**
	 * 项目管理
	 */
	public static final int TPUSH_DPPM = 15;
	/**
	 * 后勤服务
	 */
	public static final int TPUSH_B_S = 16;
	/**
	 * 人事服务
	 */
	public static final int TPUSH_NHR = 17;
	/**
	 * 在线学习
	 */
	public static final int TPUSH_LEARNING_ONLINE = 18;
	/**
	 * 场地预定
	 */
	public static final int TPUSH_VENUE_BOOKING = 19;

	// -------------------------------推送类型结束

	// ----------------------------- 应用编码
	/**
	 * 邮箱
	 */
	public static final int email = 1;
	/**
	 * 固定资产
	 */
	public static final int fixedAssets = 2;
	/**
	 * IT服务台
	 */
	public static final int itPlatform = 3;
	/**
	 * 班车服务
	 */
	public static final int regularBus = 4;
	/**
	 * 日程
	 */
	public static final int schedule = 5;
	/**
	 * 差旅助手
	 */
	public static final int travelAssistant = 6;
	/**
	 * 运营安全
	 */
	public static final int operatSafe = 7;
	/**
	 * 人才选拔
	 */
	public static final int talentSelection = 8;
	/**
	 * 移动crm
	 */
	public static final int crm = 9;
	/**
	 * 管理工具 项目管理
	 */
	public static final int manage = 10;
	/**
	 * 快递可视化
	 */
	public static final int express = 12;
	/**
	 * 我的工资
	 */
	public static final int wage = 13;
	/**
	 * 工程管理
	 */
	public static final int projectManage = 14;
	/**
	 * 考勤
	 */
	public static final int attendanceRecord = 15;
	/**
	 * 打卡
	 */
	public static final int record = 16;
	/**
	 * 发现
	 */
	public static final int discovery = 17;
	/**
	 * 收发室
	 */
	public static final int inOut = 18;
	/**
	 * 悬赏
	 */
	public static final int award = 19;
	/**
	 * 提成奖金
	 */
	public static final int re_reward = 20;
	/**
	 * 在线学习
	 */
	public static final int learning_online = 21;
	/**
	 * 知识库
	 */
	public static final int knowledge_base = 22;
	/**
	 * 场地预定
	 */
	public static final int venue_booking = 23;
	/**
	 * 拼车吧
	 */
	public static final int carpool_bar = 24;
	/**
	 * 移动BI（默认应用）
	 */
	public static final int mobile_bi = 25;
	/**
	 * 德邦e站（默认应用）
	 */
	public static final int deppon_eStation = 26;
	/**
	 * 工作流（默认应用）
	 */
	public static final int wrokflow = 27;
	/**
	 * TPS
	 */
	public static final int tps = 28;
	/**
	 * 招聘
	 */
	public static final int recruit = 29;
	/**
	 * 智慧收派
	 */
	public static final int rdvs = 35;
	/**
	 * 劳动合同
	 */
	public static final int contract = 36;
	/**
	 * 新工作流（泛微）
	 */
	public static final int nwfs = 37;
	// ----------------------------- 权限
	/**
	 * 移动crm权限角色
	 */
	public static final String crmPermissionRole = "DPM0006";

	/**
	 * 管理工具权限角色 项目管理
	 */
	public static final String managePermissionRole = "DPM0008";

	/**
	 * 德邦e站（企业文化）权限角色
	 */
	public static final String eccPermissionRole = "DPM0009";

	/**
	 * 快递可视化角色
	 */
	public static final String expressVisualizRole = "DPM0012";

	/**
	 * 工程管理角色
	 * 
	 */
	public static final String projectManageRole = "DPM0013";

	/**
	 * BI角色
	 * 
	 */
	public static final String BIRole = "DPM0014";

	/**
	 * RDVS角色
	 * 
	 */
	public static final String RDVSRole = "DPM0028";

	/**
	 * 营业部晨会权限角色
	 */
	public static final String morningMeetingRole = "DPM0015";

	/**
	 * 早安快递权限角色
	 */
	public static final String dpmExpressRole = "DPM0016";

	/**
	 * 是否文化社区的用户
	 */
	public static final String eccPrivateRole = "DPM0017";

	/**
	 * 打卡考勤角色
	 */
	public static final String attendanceRecordRole = "DPM0018";

	/**
	 * 接送货快递晨会角色
	 */
	public static final String inOutExpressRole = "DPM0019";

	/**
	 * 终端处理信息角色
	 */
	public static final String it = "DPM0020";
	/**
	 * 提成奖金角色
	 */
	public static final String reward = "DPM0021";
	/**
	 * 知识库角色
	 */
	public static final String knowledge_base_Role = "DPM0022";
	/**
	 * 后台管理系统登录角色
	 */
	public static final String back_manage_Role = "DPM8080";
	
	/*
	 * *新工作流分页 每页显示工作流条数
	 */
	public static final int workflowPageNumber = 200;
}
