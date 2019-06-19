/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.CCBoInjuryMedical;
import com.deppon.montal.module.workitems.dao.CCBoInjuryMedicalDao;
import com.deppon.montal.module.workitems.dao.ICCBoInjuryMedicalDao;

/** 
* @Title: ICCBoInjuryMedicalDao.java
* @Package com.deppon.montal.module.workitems.dao 
* @Description: (工伤医疗费用（新）工作流数据层) 
* @author yin 
* @date 2013-06-07  上午9:58:20 
* @version V1.0 
*/
public class CCBoInjuryMedicalService implements ICCBoInjuryMedicalService {

	private static ICCBoInjuryMedicalDao  medicalDao = new CCBoInjuryMedicalDao();
	
	@Override
	public CCBoInjuryMedical getCCBoInjuryMedical(String processinstid) {
		// TODO Auto-generated method stub
		return medicalDao.getCCBoInjuryMedical(processinstid);
	}

}
