
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OAUseSealApply;
   /** 
 * @Title: IOAUSE.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(用章申请Dao层接口) 
 * @author 何玲菠 
 * @date 2013-8-1 上午11:43:38 
 * @version V1.0 
 */
public interface IOAUseSealApplyDao {
	OAUseSealApply getOAUseSealApplyById(String pid);
}

