
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.CCBobenefits;
   /** 
 * @Title: IBenifi.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-6 上午9:41:23 
 * @version V1.0 
 */
public interface ICCBobenefitsDao {
	public CCBobenefits getCCBobenefitsByWorkId(String workId);
}

