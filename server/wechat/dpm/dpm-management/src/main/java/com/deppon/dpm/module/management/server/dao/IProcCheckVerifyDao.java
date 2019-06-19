package com.deppon.dpm.module.management.server.dao;

/**
 * <p>ClassName: IProcCheckVerifyDao</p>
 * <p>Description: 工程验收初次保存的校验dao接口.</p>
 * <p>Author: 268101</p>
 * <p>Date: 2015-8-17</p>
 */
public interface IProcCheckVerifyDao {
	/**
	 * <p>
	 * Description: 工程验收初次保存的校验.
	 * </p>
	 * 
	 * @param name
	 *            营业部名称
	 * @return str
	 */
	public int checkProcSubmit(String name);
}
