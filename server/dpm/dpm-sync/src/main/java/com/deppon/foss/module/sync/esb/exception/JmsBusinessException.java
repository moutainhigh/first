package com.deppon.foss.module.sync.esb.exception;

import com.deppon.foss.framework.exception.BusinessException;

/**
 * 自定义异常
 * 
 * @author 231586
 * 
 */
public class JmsBusinessException extends BusinessException {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 691797036656592039L;

	/**
	 * Instantiates a new dispatchException.
	 * 
	 * @param errCode
	 *            the errCode
	 */
	public JmsBusinessException(String errCode) {
		super();
		super.errCode = errCode;
	}

	/**
	 * Instantiates a new dispatchException.
	 * 
	 * @param errCode
	 *            the errCode
	 * @param msg
	 *            the msg
	 */
	public JmsBusinessException(String errCode, Throwable cause) {
		super(errCode, cause);
		super.errCode = errCode;
	}
}
