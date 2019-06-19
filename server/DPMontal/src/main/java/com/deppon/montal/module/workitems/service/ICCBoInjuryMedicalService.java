/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.CCBoInjuryMedical;

/** 
* @Title: ICCBoInjuryMedicalDao.java
* @Package com.deppon.montal.module.workitems.dao 
* @Description: (工伤医疗费用（新）工作流数据层) 
* @author yin 
* @date 2013-06-07  上午9:58:20 
* @version V1.0 
*/
public interface ICCBoInjuryMedicalService {

	/**
	 * 获取工伤医疗费用信息
	 * @param processinstid
	 * @return
	 */
	public CCBoInjuryMedical getCCBoInjuryMedical(String processinstid); 
}
