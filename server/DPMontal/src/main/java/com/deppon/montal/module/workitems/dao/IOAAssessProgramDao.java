
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OAAssessApply;
   /** 
 * @Title: IAssessProgramDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-21 上午10:14:41 
 * @version V1.0 
 */
public interface IOAAssessProgramDao {
	public OAAssessApply getOAAssessApply(String workId);
}

