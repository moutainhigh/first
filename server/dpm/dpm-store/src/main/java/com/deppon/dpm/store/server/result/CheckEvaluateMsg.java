package com.deppon.dpm.store.server.result;
/**
 * 
 * @author XiaoTian
 *
 */
public class CheckEvaluateMsg {

	/**
	 * code
	 */
	private int code;
	/**
	 * msg
	 */
	private String msg;
	
	/**
	 * 构造方法
	 * @param code
	 * @param msg
	 */
	public CheckEvaluateMsg(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 错误信息
	 */
	public static  CheckEvaluateMsg USERID_ERROR=new CheckEvaluateMsg(500200,"用户ID,级别,deptseq不能为空");
	/**
	 * 错误信息
	 */
	public static  CheckEvaluateMsg BUSINESS_ERROR=new CheckEvaluateMsg(500201,"该员工下无下属营业部");
	/**
	 * 错误信息
	 */
	public static  CheckEvaluateMsg NO_SUBMISSION_ERROR=new CheckEvaluateMsg(500202, "所有营业部无子任务");

	/**
	 * get
	 * @return code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * set
	 * @param code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * get
	 * @return
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * set
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
