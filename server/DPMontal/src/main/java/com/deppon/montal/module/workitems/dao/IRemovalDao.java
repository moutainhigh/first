
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OARemoval;
   /** 
 * @Title: IRemovalDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(开设新点/旧点搬迁) 
 * @author 何玲菠 
 * @date 2013-7-16 上午11:45:58 
 * @version V1.0 
 */
public interface IRemovalDao {
	OARemoval getOARemoval(String pid);
}

