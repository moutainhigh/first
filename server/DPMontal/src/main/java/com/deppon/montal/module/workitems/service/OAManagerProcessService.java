
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OAManagerProcess;
import com.deppon.montal.module.workitems.dao.IOAManagerProcessDao;
import com.deppon.montal.module.workitems.dao.OAManagerProcessDao;
   /** 
 * @Title: OAManagerProcessService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(流程新建/变更/废除) 
 * @author 何玲菠 
 * @date 2013-8-21 下午1:41:48 
 * @version V1.0 
 */
public class OAManagerProcessService implements IOAManagerProcessService {

	@Override
	public OAManagerProcess getOAManagerProcessByProcessinstid(
			String processinstid) {
		IOAManagerProcessDao dao = new OAManagerProcessDao();
		return dao.getOAManagerProcessByProcessinstid(processinstid);
	}

}

