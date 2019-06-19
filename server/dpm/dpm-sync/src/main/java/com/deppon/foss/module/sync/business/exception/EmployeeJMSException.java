package com.deppon.foss.module.sync.business.exception;

import com.deppon.foss.framework.exception.BusinessException;

/**
 * 自定义异常
 * 
 * @author 231586
 * 
 */
public class EmployeeJMSException extends BusinessException {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 提示信息
	 */
	public static final String DATA_RULE_REASON_OBJECTISNOTNULL_ERROR = "新增的员工已经存在";
	/**
	 * 提示信息
	 */
	public static final String DATA_RULE_REASON_OBJECTISNULL_ERROR = "修改的员工不存在";
	/**
	 * 提示信息
	 */
	public static final String DATA_RULE_REASON_DEPTISNULL_ERROR = "未找到该员工相应的部门";

	/**
	 * Constructor
	 * 
	 * @param errCode
	 */
	public EmployeeJMSException(String errCode) {
		super();
		super.errCode = errCode;
	}

	/**
	 * 异常信息
	 * 
	 * @param code
	 * @param msg
	 */
	public EmployeeJMSException(String code, String msg) {
		super(code, msg);
	}

	/**
	 * 异常信息
	 * 
	 * @param code
	 * @param msg
	 * @param cause
	 */
	public EmployeeJMSException(String code, String msg, Throwable cause) {
		super(code, msg, cause);
	}

}
