
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OACarGoTransContract;
   /** 
 * @Title: IOACarGoTransContractService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(整车货物运输Service接口) 
 * @author 何玲菠 
 * @date 2013-8-20 下午3:05:45 
 * @version V1.0 
 */
public interface IOACarGoTransContractService {
	OACarGoTransContract getOACarGoTransContractByProcessinstid(String processinstid);
}

