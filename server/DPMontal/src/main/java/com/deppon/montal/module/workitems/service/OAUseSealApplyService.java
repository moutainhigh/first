
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OAUseSealApply;
import com.deppon.montal.module.workitems.dao.IOAUseSealApplyDao;
import com.deppon.montal.module.workitems.dao.OAUseSealApplyDao;
   /** 
 * @Title: OAUseSealApplyService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(用章申请service层) 
 * @author 何玲菠 
 * @date 2013-8-1 下午2:07:25 
 * @version V1.0 
 */
public class OAUseSealApplyService implements IOAUseSealApplyService {

	@Override
	public OAUseSealApply getOAUseSealApplyById(String pid) {
		IOAUseSealApplyDao dao = new OAUseSealApplyDao();
		return dao.getOAUseSealApplyById(pid);
	}

}

