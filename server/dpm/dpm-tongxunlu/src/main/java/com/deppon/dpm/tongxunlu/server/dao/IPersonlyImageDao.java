package com.deppon.dpm.tongxunlu.server.dao;

import com.deppon.dpm.module.common.shared.domain.EmpExtensionEntity;

/**
 * 个人头像service层
 * @author 231586
 *
 */
public interface IPersonlyImageDao{
	/**
	 * 新增
	 * @param entity
	 * @return
	 */
	public int addPersonlyImage(EmpExtensionEntity entity);
	
	/**
	 * 修改个人头像
	 * @param entity
	 * @return
	 */
	public int updateImageAddress(EmpExtensionEntity entity);
	
	/**
	 * 查询个人头像文件
	 * @param empCode
	 * @return
	 */
	public String queryImageByEmpCode(String empCode);
}
