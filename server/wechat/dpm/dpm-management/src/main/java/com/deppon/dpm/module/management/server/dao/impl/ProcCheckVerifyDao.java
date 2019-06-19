package com.deppon.dpm.module.management.server.dao.impl;

import com.deppon.dpm.module.management.server.dao.IProcCheckVerifyDao;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * <p>
 * ClassName: ProcCheckVerifyDao
 * </p>
 * <p>
 * Description: 工程验收初次保存的校验dao接口实现
 * </p>
 * <p>
 * Author: 268101
 * </p>
 * <p>
 * Date: 2015-8-17
 * </p>
 */
public class ProcCheckVerifyDao extends iBatis3DaoImpl implements
		IProcCheckVerifyDao {
	static String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.procverify";
     

	/**
	 * <p>
	 * Description: 工程验收初次保存的校验.
	 * </p>
	 * 
	 * @param name
	 *            营业部名称code
	 * @return str
	 */
	public int checkProcSubmit(String name) {
		if (!StringUtil.isEmpty(name)) {
			//得到工程验收数据
			return (Integer) this.getSqlSession().selectOne(
					mapperNameSpace + ".checkProcSubmit",name);
		}
		return 0;
		
	}

}
