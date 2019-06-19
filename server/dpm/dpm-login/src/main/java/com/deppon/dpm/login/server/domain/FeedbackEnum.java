package com.deppon.dpm.login.server.domain;

/**
 * 意见反馈枚举值
 * 
 * @author 231586
 * 
 */
public enum FeedbackEnum {
	/**
	 * 待处理
	 */
	READY_TO_HANDLER(0, "未答复"),
	/**
	 * 已采纳
	 */
	RECEIVE_ADVICE(1, "已答复"),
	/**
	 * 未采纳
	 */
	RESCURE_ADVICE(2, "已答复"),
	/**
	 * 上线
	 */
	ALREADY_ONLINE(3, "已答复"),
	/**
	 * 已处理
	 */
	ALREADY_HANDLER(4, "已答复");
	/**
	 * 编号
	 */
	private int number;
	/**
	 * 消息
	 */
	private String message;

	/**
	 * get
	 * 
	 * @return
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * set
	 * 
	 * @param number
	 */
	public void setNumber(int number) {
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
	 * Constructor
	 * 
	 * @param number
	 * @param message
	 */
	private FeedbackEnum(int number, String message) {
		this.number = number;
		this.message = message;
	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	public static String getThisById(int number) {
		// 获取枚举数组
		FeedbackEnum[] values = FeedbackEnum.values();
		// 循环
		for (FeedbackEnum value : values) {
			// 如果id = 枚举数字
			if (number == value.number) {
				// 返回对应value
				return value.message;
			}
		}
		// 跳出
		return null;
	}

}
