package com.deppon.dpm.module.management.server.service;

/**
 * <p>
 * ClassName: IProcCheckVerifyService
 * </p>
 * <p>
 * Description: 工程验收初次保存的校验接口.
 * </p>
 * <p>
 * Author: 268101
 * </p>
 * <p>
 * Date: 2015-8-17
 * </p>
 */
public interface IProcCheckVerifyService {
	/**
	 * <p>
	 * Description: 工程验收初次保存的校验.
	 * </p>
	 * 
	 * @param name
	 *            营业部名称
	 * @return str
	 */
	public String checkProcSubmit(String name);

}
