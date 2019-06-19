
 package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OAPersonelimPower;

/** 
 * @Title: OAPersonelimPowerDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(人事授权申请数据操作层接口) 
 * @author yinrongping 
 * @date 2013-8-1 下午2:20:51 
 * @version V1.0 
 */
public interface IOAPersonelimPowerDao {

	 /**
	   * @Title: getPersonelimPower 
	   * @Description:TODO(获取人事授权申请信息) 
	   * @param @param processinstid
	   * @param @return 设定文件 
	   * @returnOAPersonelimPower 返回类型 
	   * @throws 
	   * @date 2013-8-1 下午3:10:47
	 */
	public OAPersonelimPower getPersonelimPower(String processinstid);
}

