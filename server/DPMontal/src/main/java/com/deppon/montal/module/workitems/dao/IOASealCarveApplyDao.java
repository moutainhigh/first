
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OASealCarveApply;
   /** 
 * @Title: IOASealCarveApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(刻章申请dao接口) 
 * @author 何玲菠 
 * @date 2013-8-20 下午3:45:46 
 * @version V1.0 
 */
public interface IOASealCarveApplyDao {
	OASealCarveApply getOASealCarveApplyByprocessinstid(String processinstid);
}

