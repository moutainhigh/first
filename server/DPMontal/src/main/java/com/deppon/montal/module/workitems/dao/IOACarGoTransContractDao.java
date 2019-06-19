
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OACarGoTransContract;
   /** 
 * @Title: IOACarGoTransContractDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(整车货物运输dao接口) 
 * @author 何玲菠 
 * @date 2013-8-20 下午2:49:25 
 * @version V1.0 
 */
public interface IOACarGoTransContractDao {
	OACarGoTransContract getOACarGoTransContractByProcessinstid(String processinstid);
}

