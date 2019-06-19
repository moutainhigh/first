
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OAManagerProcess;
   /** 
 * @Title: IOAManagerProcessDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(流程新建/变更/废除 dao接口) 
 * @author 何玲菠 
 * @date 2013-8-21 上午11:38:42 
 * @version V1.0 
 */
public interface IOAManagerProcessDao {
	OAManagerProcess getOAManagerProcessByProcessinstid(String processinstid);
}

