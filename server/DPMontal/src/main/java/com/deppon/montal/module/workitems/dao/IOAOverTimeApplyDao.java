
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OAOvertimeApply;
   /** 
 * @Title: IOverTimeApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-20 下午3:43:00 
 * @version V1.0 
 */
public interface IOAOverTimeApplyDao {
	public OAOvertimeApply getOAOverTimeApply(String workId);
}

