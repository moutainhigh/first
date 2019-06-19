
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OAPersonelimPower;
   /** 
 * @Title: IOAPersonelimPowerService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(人事授权申请service) 
 * @author yinrongping 
 * @date 2013-8-1 下午3:23:22 
 * @version V1.0 
 */
public interface IOAPersonelimPowerService {

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

