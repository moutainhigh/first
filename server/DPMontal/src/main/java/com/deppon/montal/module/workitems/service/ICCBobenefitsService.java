
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.CCBobenefits;
   /** 
 * @Title: ICCBobenefitsService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-6 上午9:43:22 
 * @version V1.0 
 */
public interface ICCBobenefitsService {
	public CCBobenefits getCCBobenefitsByWorkId(String workId);
}

