
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OAConverterApply;
   /** 
 * @Title: IOATurnFormalService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-24 下午5:15:21 
 * @version V1.0 
 */
public interface IOATurnFormalService {
	public OAConverterApply getOAConverterApply(String workId);
	public OAConverterApply getOAConverterFlowtype(OAConverterApply oaconverterapply);
}

