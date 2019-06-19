package com.deppon.dpm.module.common.server.util;

public class Constants {
	/**
	 * 固定资产-盘点入口(资产列表)
	 */
	public static final int ASSETS_STOCK=1;
	
	/**
	 * 固定资产盘点-盘点资产个数
	 */
	public static final int STOCK_SWEEP=2;
	
	/**
	 * 固定资产-成功提交盘点任务(减去PC端回退的盘点任务)
	 */
	public static final int ASSETS_SUMIT=3;
	
	/**
	 * 固定资产暂存
	 */
	public static final int ASSETS_STORAGE=4;
	
	/**
	 * IT上报历史
	 */
	public static final int REPORT_HISTORY=5;
	
	/**
	 * 成功提交IT上报问题数
	 */
	public static final int SUCCESS_SUBMIT_REPORT=6;
	
	
	/**
	 * 资产更新-更新入口
	 */
	public static final int ASSETS_RENEW=7;
	
	/**
	 * 资产更新-回退
	 */
	public static final int ASSETS_BACK=8;
	
	/**
	 * 资产更新-扫描确认
	 */
	public static final int SWEEP_CONFIRM=9;
	 
	/**
	 * 资产盘点-点击扫一扫按钮
	 */
	//public static final int SWEEP_CONFIRM=10;
	/**
	 * 资产盘点-下发盘点单据数量
	 */
	public static final int STOCK_TASK_QUANTITY=11;
	/**
	 * 点击IT上报提交按钮次数
	 */
	public static final int SUBMIT_REPORT=12;
	
	/**
	* 差旅助手机票
	*/
	public static final int TRAVEL_ASSISTANT_FLIGHT=13;

	/**
	* 差旅助手酒店
	*/
	public static final int TRAVEL_ASSISTANT_HOTEL=14;

	/**
	* 差旅助手预定
	*/
	public static final int TRAVEL_ASSISTANT_SCHEDULE=15;
	
	/**
	 * 差旅助手
	 */
	public static final int TRAVEL_ASSISTANT=16;
	
	/**
	 * PC端提交的盘点任务
	 */
	public static final int PC_SUM_STOCK=17;
	
	/**
	 * PC端取消的盘点任务
	 */
	public static final int PC_CANCEL_STOCK=18;
	
	/**
	 * PC端回退的盘点任务
	 */
	public static final int PC_RETURN_STOCK=19;
	/**
	 * 班车服务-上班tab 
	 */
	public static final int BUS_GO_WORK=20;
	/**
	 * 班车服务-下班tab 
	 */
	public static final int BUS_GO_HOME=21;
	/**
	 * 班车服务-下班时间列表 
	 */
	public static final int BUS_START_TIME=22;
	/**
	 * 班车服务-服务评价提交 
	 */
	public static final int BUS_SERVICE_SUBMIT=23;
	/**
	 * 班车服务-开线建议tab 
	 */
	public static final int BUS_SUGGEST_TAB=24;
	/**
	 * 班车服务-上下班界面站点点击 
	 */
	public static final int BUS_WORK_SITE=25;
	/**
	 * 人才选拔-抽签结果提交
	 */
	public static final int NHR_submitDraw=26;
	/** 
	* 工程管理-工程巡检点击次数
	*/ 
	public static final int PROC_CHECK_CLICK=27;
	/** 
	* 工程管理-工程巡检营业部检查次数
	*/ 
	public static final int PROC_WATCH_DEPT=28;
	/** 
	* 工程管理-工程巡检损坏总数
	*/ 
	public static final int PROC_WATCH_PROJECT=29;
	/** 
	* 工程管理-工程访问点击次数
	*/ 
	public static final int PROC_CHECK_ACCEPT=30;
	
	/** 
	* 打卡上班卡
	*/ 
	public static final int PUNCH_CLOCK_UP=31;
	/** 
	* 打卡下班卡
	*/ 
	public static final int PUNCH_CLOCK_DOWN=32;
	/**
	* 差旅——事前申请按钮
	*/
	public static final int TRAVEL_ASSISTANT_INDTENS=33;
	/**
	 * 工程巡检——提交PC的次数
	 */
	public static final int PROC_ADDRESS_COU=34;
	
	/**
	 * 工程管理-工程验收-营业部初次打分保存次数
	 */
	public static final int PROC_SCORE_COU=35;
	
	/**
	 * 工程管理-工程验收-营业部最终提交PC次数
	 */
	public static final int PROC_ADDRESSPC_COU=36;
	
	/**
	 * 收发室-移动端扫描出库的件数.
	 */
	public static final int RECEIVING_ROOM_SCANNING = 37;
	
	/**
	 * 收发室-寄快递点击次数.
	 */
	public static final int EXPRESS_DELIVERY_TIMES = 38;
	
	/**
	 * 收发室-PC推送到移动端的包裹件数.
	 */
	public static final int PUSH_THE_NUMBER_OF_PARCELS_SENT = 39;
	
	/**
	 * 固定资产-任务盘点应盘个数
	 */
	public static final int ASSETS_CHECKNUM = 40;
	
	/**
	 * 工程管理-工程维修申请提交成功次数.
	 */
	public static final int PROCMAINTENANCE_ISSUBMIT = 41;
	
	/**
	 *  拼车点击次数
	 */
	public static final int SERVE_CLICK_NUMBER = 46;
	
	/**
	 *  拼车活动点击次数
	 */
	public static final int SERVE_ACTIVITY = 47;
	/**
	 *  拼车上班车点击次数Go to work
	 */
	public static final int SERVE_GO_WORK = 48;
	/**
	 *  拼车下班车点击次数get off work
	 */
	public static final int SERVE_GET_WORK = 49;
	/**
	 *  拼车上班车发布点击次数release
	 */
	public static final int SERVE_RELEASE_GO_WORK = 50;
	/**
	 *  拼车下班车发布点击次数release
	 */
	public static final int SERVE_RELEASE_GET_WORK = 51;
	/**
	 *  拼车活动发布点击次数release
	 */
	public static final int SERVE_RELEASE_ACTIVITY = 52;
	/**
	 *  拼车我的发布
	 */
	public static final int SERVE_USER_RELEASE = 53;
	/**
	 *  拼车我的参与
	 */
	public static final int SERVE_USER_JOIN = 54;
	
	
	/**
	 *  预定管理羽毛球点击次数badminton
	 */
	public static final int RESERVE_BADMINTON = 44;
	/**
	 *  预定管理瑜伽室点击次数 Yoga room
	 */
	public static final int SERVE_YOGA_ROOM = 45;
	
	/** 
	* 上班卡成功次数
	*/ 
	public static final int PUNCH_UP_SUC=55;
	/** 
	* 下班卡成功次数
	*/ 
	public static final int PUNCH_DOWN_SUC=56;
	
	/**
	 *  拼车上班车发布提交按钮点击次数release
	 */
	public static final int SERVE_SUBMIT_GO_WORK = 57;
	/**
	 *  拼车下班车发布提交按钮点击次数release
	 */
	public static final int SERVE_SUBMIT_GET_WORK = 58;
	/**
	 *  拼车活动发布提交按钮点击次数release
	 */
	public static final int SERVE_SUBMIT_ACTIVITY = 59;
	
	
	/******************************************************
	
	/**
	 * “累计”点击次数及跳转至职业生涯界面响应时长
	 */
	public static final int BONUS_CAREER=70;
	
	/**
	 * 当月奖金（奖金首页）快递员、派件员、销售专员、外场、车队各岗位点击次数及响应时长
	 */
	public static final int QUERY_BONUS_INDEX=71;

	/**
	 *奖金明细点击次数及响应时长
	 */
	public static final int QUERY_ROYALTY=72;
	
	/**
	 * 上月奖金点击次数及响应时长
	 */
	public static final int QUERY_LAST_MONTH_BONUS=73;
	
	/**
	 * 奖金排名点击次数及响应时长
	 */
	public static final int  RANKING_QUERY=74;
	
	/******************************************************
	 * 选拔提交成功   
	 */
	public static final int  SUBMIT_SUCCESS =75;

	/**
	 * 选拔提交失败
	 */
	public static final int  SUBMIT_FAIL =76;
	
	/**
	 * 选拔中途离场成功
	 */
	public static final int  DEPARTURE_SUCCESS=77;
	
	/**
	 * 选拔中途离场失败
	 */
	public static final int  DEPARTURE_FAIL=78;
	
	
	/**
	 * 掌上选拔（班级列表）点击次数及响应时间  
	 */
	public static final int  QUERY_CLASS =79;

	/**
	 * 班级列表点击次数及响应时间(优化后update by 2016-04-08)
	 */
	public static final int  QUERY_MISSION =80;
	
	/**
	 * 学员列表、分组获取题目点击次数及响应时间 
	 */
	public static final int  QUERY_STUDENTS =81;
	
	/**
	 * 全员概况点击次数及响应时间
	 */
	public static final int  QUERY_GENERAL_STUDENTS=82;
	
	/**
	 * 个人简历点击次数及响应时间
	 */
	public static final int  QUERY_RESUME_INFO=83;
	
	/**
	 * 维度表击次数及响应时间
	 */
	public static final int  QUERY_PROJECT_REPORT=84;
	
	/**
	 *  选拔“暂存”点击次数
	 */
	public static final int THE_STAGING=85;
	
	/**
	 *  选拔“整体打分”点击次数
	 */
	public static final int OVERALL_SCORE=86;
	
	
	/**
	 * 工资查询各层级访问人数
	 */
	public static final int  WAGE_QUERY =90;
	
	/**	
	 * 我的考勤各层级访问人数
	 */
	public static final int  CLOCKING_IN=91;
	
	/**
	 * 移动打卡：B5，B6，B7各等级访问人数
	 */
	public static final int  CLOCK_IN_COUNT=92;

	/**
	 * 一键补考勤：B5，B6，B7各等级访问人数
	 */
	public static final int  FOR_ATTENDANCE=93;
	
	
	/**
	 * 补考勤提交成功
	 */
	public static final int  FILL_IN_SUCCESS=94;

	/**
	 * 选拔提交失败
	 */
	public static final int  FILL_IN_FAIL=95;
	
	/**
	 * 知识库：B5,B6,B7,B8,B9各等级访问人数，职能和非职能访问人数，管理层与非管理层访问人数
	 */
	public static final int  REPOSITORY=96;
	
	/**
	 * 人才库：B5,B6,B7,B8,B9各等级访问人数，职能和非职能访问人数，管理层与非管理层访问人数
	 */
	public static final int   TALENT_POOL=97;
	
	
	/**
	 * 知识库类别 仓管家
	 */
	public static final int LOTE_CGJID=100;
	
	/**
	 * 知识库类别 新员工
	 */
	public static final int LOTE_XYGID=101;
	
	/**
	 * 知识库类别 合伙人
	 */
	public static final int LOTE_HHRID=102;
	
	/**
	 * 知识库类别 快递
	 */
	public static final int LOTE_KDID=103;
	
	/**
	 * 知识库类别 营销
	 */
	public static final int LOTE_YXID=104;
	
	/**
	 * 知识库类别 人力
	 */
	public static final int LOTE_RLID=105;
	
	/**
	 * 知识库类别 文化
	 */
	public static final int LOTE_WHID=106;
	
	/**
	 * 知识库类别 IT
	 */
	public static final int LOTE_ITID=107;
	
	/**
	 * 高管出差推送数据成功次数
	 */
	public static final int   TRIP_SUCCESS=108;
	
	/**
	 * 人才预警: B5,B6,B7,B8,B9各等级访问人数，职能和非职能访问人数，管理层与非管理层访问人数
	 */
	public static final int PP_Ready=109;	
	
	/**
	 * 人员规划: B5,B6,B7,B8,B9各等级访问人数，职能和非职能访问人数，管理层与非管理层访问人数
	 */
	public static final int Person_Plan=110;
	
	/**
	 * 人员聚点: B5,B6,B7,B8,B9各等级访问人数，职能和非职能访问人数，管理层与非管理层访问人数
	 */
	public static final int CC_assistant=111;
	
	/**
	 * 岗位查询: B5,B6,B7,B8,B9各等级访问人数，职能和非职能访问人数，管理层与非管理层访问人数
	 */
	public static final int Post_People=112;
	
	/**
	 * 我的推荐/人员管理: B5,B6,B7,B8,B9各等级访问人数，职能和非职能访问人数，管理层与非管理层访问人数
	 */
	public static final int MYPost_People=113;
	
	/**
	 * 内部推荐提交: B5,B6,B7,B8,B9各等级访问人数，职能和非职能访问人数，管理层与非管理层访问人数
	 */
	public static final int Post_PeopleSubm=114;
	
	/**
	 * 人员缺口: B5,B6,B7,B8,B9各等级访问人数，职能和非职能访问人数，管理层与非管理层访问人数
	 */
	public static final int GAP_People=115;
	
	/**
	 * 招聘报表: B5,B6,B7,B8,B9各等级访问人数，职能和非职能访问人数，管理层与非管理层访问人数
	 */
	public static final int report_People=116;
	
	/**
	 * 行为分析
	 */
	public static final int BEHAVIOURAL_ANALYSIS=117;
	
	/**
	 * 人才检索
	 */
	public static final int TALENT_SUARCH=118;
	
	/**
	 * 关注模型
	 */
	public static final int ATTENTION_MODEL=119;
	
	/**
	 * 生成模型
	 */
	public static final int GENERATE_MODEL=120;
	
	/**
	 * 收藏
	 */
	public static final int  COLLECT=121;
	
	/**
	* @Fields RESERVE_MEMBER : 预定提交魔法数字24
	*/
	public static final int RESERVE_MEMBER = 24;
	
	/**
	* @Fields RESERVE_MEMBER : 预定提交魔法数字1000
	*/
	public static final int RESERVE_TENHUNDRED = 1000;
	
	/**
	* @Fields RESERVE_MEMBER : 预定提交魔法数字3600
	*/
	public static final int RESERVE_THREESIXHUNDRED = 3600;
	
	
	
	
}
