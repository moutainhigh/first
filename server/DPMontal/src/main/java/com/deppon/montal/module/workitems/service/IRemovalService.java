
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OARemoval;
   /** 
 * @Title: IRemovalService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(新点开设/旧点搬迁) 
 * @author 何玲菠 
 * @date 2013-7-16 下午1:59:54 
 * @version V1.0 
 */
public interface IRemovalService {
	OARemoval getOAremovalByWorkId(String workId);
}

