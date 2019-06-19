
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OAPersonelimPower;
import com.deppon.montal.module.workitems.dao.IOAPersonelimPowerDao;
import com.deppon.montal.module.workitems.dao.OAPersonelimPowerDao;
   /** 
 * @Title: OAPersonelimPowerService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(人事授权申请) 
 * @author yinrongping 
 * @date 2013-8-1 下午3:24:05 
 * @version V1.0 
 */
public class OAPersonelimPowerService implements IOAPersonelimPowerService{

	private static IOAPersonelimPowerDao powerDao = new OAPersonelimPowerDao();
	
	@Override
	public OAPersonelimPower getPersonelimPower(String processinstid) {
		
		return powerDao.getPersonelimPower(processinstid);
	}

}

