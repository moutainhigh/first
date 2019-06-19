package com.deppon.dpm.module.management.shared.domain;

/**
 * it终端信息枚举值
 * 
 * @date 2015-09-18
 * @author 231586
 * 
 */
public enum ItTerminalEnum {
	REPORT("0000000000001", "上报"), 
	FAILED_IN_ONE_SHOT("0000000000002","一次性处理失败"), 
	FORWARD_TO_ASSIGN("0000000000003", "转指派"), 
	ALREADY_ASSIGN("0000000000004", "已指派"), 
	ALREADY_MERGE_IN("0000000000005", "已合并"), 
	ALREADY_DONE("0000000000006", "已完成"), 
	CHOOSE_OF_THE_NORMAL_HANDLER("0000000000007", "一般处理已选择"), 
	CHOOSE_OF_THE_READY_TO_ASSIGN("0000000000008", "待指派已选择"), 
	NORMAL_HANDLER_BACK("0000000000009","一般处理退回"), 
	SAVE_TEMPLATE("0000000000009", "暂存"), 
	FRONT_MISSION_HAS_CHOOSE("0000000000011", "一线任务已选择"), 
	FRONT_MISSION_BACK("0000000000012","一线任务退回"), 
	ISSUE_HANGUP("0000000000013", "事件挂起"),
	/* FORWARD_TO_PROBLEM("0000000000013", "转问题"), */
	CONFIM_FAILED("0000000000014", "确认失败"), 
	WAITTING_CUSTOMER_CONFIG("0000000000015", "待用户确认"), 
	PROBLEM_TO_ISSUE("0000000000016","问题转事件"), 
	FORWARD_TO_LIVE("0000000000017", "转现场"), 
	HANDDING("0000000000018", "处理中"), 
	HAND_HANDING("0000000000019", "受理处理中"), 
	ALREADY_CLOSED("0000000000020", "已关闭"), 
	ISSUE_TO_PROBLEM("0000000000021", "事件转问题"), 
	CONFIG_SUCCESSED("0000000000022", "确认成功"), 
	ONLINE_BUG("0000000000023", "线上bug"), 
	ALREADY_BACK("0000000000024", "已退回"), 
	SECOND_FORWARD_TO_ASSIGN("0000000000025","二次转指派"), 
	FORWARD_TO_FRONT("0000000000026", "转一线"), 
	FORWARD_TO_SECOND_FRONT("0000000000027", "转二线"), 
	FRONT_HANDDING("0000000000028", "一线处理中"), 
	SECOND_FRONT_HANDDING("0000000000029", "二线处理中"), 
	TERMINAL_HANDDING("0000000000030","终端处理中"), 
	DEVELOP_HANDDING("0000000000031", "开发处理中"), 
	TEST_HANDDING("0000000000032", "测试处理中"),
	PROFESSIONAL_HADDING("0000000000033","专业处理中"), 
	ALREADY_HANGING_UO("0000000000034", "已挂起"), 
	BAMP_CONFIG("0000000000035", "BAMP确认中");

	/**
	 * 编号
	 */
	private String number;
	/**
	 * 名称
	 */
	private String message;

	/**
	 * 构造方法
	 * 
	 * @param number
	 * @param message
	 */
	private ItTerminalEnum(String number, String message) {
		this.number = number;
		this.message = message;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * set
	 * 
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * set
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 根据名称获取编号
	 * 
	 * @param number
	 * @return
	 */
	public static String getThisById(String number) {
		ItTerminalEnum[] values = ItTerminalEnum.values();
		// 循环
		for (ItTerminalEnum value : values) {
			if (value.number.equalsIgnoreCase(number)) {
				// 返回
				return value.message;
			}
		}
		// 返回
		return null;
	}

	/**
	 * 根据编号获取名称
	 * 
	 * @param name
	 * @return
	 */
	public static String getThisByName(String name) {
		ItTerminalEnum[] values = ItTerminalEnum.values();
		// 循环
		for (ItTerminalEnum value : values) {
			if (value.message.equalsIgnoreCase(name)) {
				// 返回
				return value.number;
			}
		}
		// 返回
		return null;
	}
}
