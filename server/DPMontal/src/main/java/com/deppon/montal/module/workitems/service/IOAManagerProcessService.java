
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OAManagerProcess;
   /** 
 * @Title: IOAManagerProcessService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(流程新建/变更/废除) 
 * @author 何玲菠 
 * @date 2013-8-21 上午11:54:24 
 * @version V1.0 
 */
public interface IOAManagerProcessService {
	OAManagerProcess getOAManagerProcessByProcessinstid(String processinstid);
}

