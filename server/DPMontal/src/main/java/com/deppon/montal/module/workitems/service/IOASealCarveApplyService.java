
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OASealCarveApply;
   /** 
 * @Title: IOASealCarveApplyService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(刻章申请service接口) 
 * @author 何玲菠 
 * @date 2013-8-20 下午3:54:08 
 * @version V1.0 
 */
public interface IOASealCarveApplyService {
	OASealCarveApply getOASealCarveApplyByProcessinstid(String processinstid);
}

