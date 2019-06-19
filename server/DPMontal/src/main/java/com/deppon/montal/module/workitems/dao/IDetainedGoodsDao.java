
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OAKouhuoApply;
   /** 
 * @Title: IDetainedGoodsDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(扣货申请dao接口) 
 * @author 何玲菠 
 * @date 2013-8-1 下午3:54:34 
 * @version V1.0 
 */
public interface IDetainedGoodsDao {
	OAKouhuoApply getOAKouhuoApplyById(String pid);
}

