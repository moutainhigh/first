package com.deppon.foss.module.sync.business.exception;

import com.deppon.foss.framework.exception.BusinessException;

/**
 * 自定义异常
 * 
 * @author 231586
 * 
 */
public class DeptJMSException extends BusinessException {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 提示信息
	 */
	public static final String USER_ADD_EXIT = "新增的用户已经存在";
	/**
	 * 提示信息
	 */
	public static final String USER_ADD_NOT_EXIT = "修改或删除的用户不存在";
	/**
	 * 提示信息
	 */
	public static final String USER_EMPCODE_NOT_EXIT = "用户信息的员工编码不存在";

	/**
	 * Constructor
	 * 
	 * @param errCode
	 */
	public DeptJMSException(String errCode) {
		super();
		super.errCode = errCode;
	}

	/**
	 * 异常信息
	 * 
	 * @param code
	 * @param msg
	 */
	public DeptJMSException(String code, String msg) {
		super(code, msg);
	}

	/**
	 * 异常信息
	 * 
	 * @param code
	 * @param msg
	 * @param cause
	 */
	public DeptJMSException(String code, String msg, Throwable cause) {
		super(code, msg, cause);
	}

}
