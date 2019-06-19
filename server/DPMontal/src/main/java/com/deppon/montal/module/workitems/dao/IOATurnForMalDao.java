
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OAConverterApply;
   /** 
 * @Title: IOATurnForMalDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-24 下午5:00:17 
 * @version V1.0 
 */
public interface IOATurnForMalDao {
	public OAConverterApply getOAConverterApply(String workId);
	public OAConverterApply getOAConverterFlowtype(OAConverterApply oaconverterapply);
}

