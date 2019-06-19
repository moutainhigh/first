
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.CCBobenefits;
import com.deppon.montal.module.workitems.dao.CCBobenefitsDao;
import com.deppon.montal.module.workitems.dao.ICCBobenefitsDao;
   /** 
 * @Title: CCBobenefitsService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-6 上午9:44:11 
 * @version V1.0 
 */
public class CCBobenefitsService implements ICCBobenefitsService {
	@Override
	public CCBobenefits getCCBobenefitsByWorkId(String workId) {

		// TODO Auto-generated method stub return null;
		ICCBobenefitsDao dao = new CCBobenefitsDao();
		return dao.getCCBobenefitsByWorkId(workId);
	}

}

