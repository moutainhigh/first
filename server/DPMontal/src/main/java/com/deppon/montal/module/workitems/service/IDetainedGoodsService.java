
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OAKouhuoApply;
   /** 
 * @Title: IDetainedGoodsService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(扣货申请service层) 
 * @author 何玲菠 
 * @date 2013-8-1 下午4:07:46 
 * @version V1.0 
 */
public interface IDetainedGoodsService {
	OAKouhuoApply getOAKouhuoApplyById(String pid);
}

