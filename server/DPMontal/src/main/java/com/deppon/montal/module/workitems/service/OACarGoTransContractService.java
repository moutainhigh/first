
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OACarGoTransContract;
import com.deppon.montal.module.workitems.dao.IOACarGoTransContractDao;
import com.deppon.montal.module.workitems.dao.OACarGoTransContractDao;
   /** 
 * @Title: OACarGoTransContractService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-8-20 下午3:07:34 
 * @version V1.0 
 */
public class OACarGoTransContractService implements
		IOACarGoTransContractService {

	@Override
	public OACarGoTransContract getOACarGoTransContractByProcessinstid(
			String processinstid) {
		IOACarGoTransContractDao dao = new OACarGoTransContractDao();
		return dao.getOACarGoTransContractByProcessinstid(processinstid);
	}

}

