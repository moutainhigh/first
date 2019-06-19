
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OaBudgetdataApply;
import com.deppon.montal.module.workitems.dao.IOaBudgetdataApplyDao;
import com.deppon.montal.module.workitems.dao.OaBudgetdataApplyDao;
   /** 
 * @Title: OaBudgetdataApplyService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-5-13 下午2:49:19 
 * @version V1.0 
 */
public class OaBudgetdataApplyService implements IOaBudgetdataApplyService {

	@Override
	public OaBudgetdataApply getOaBudgetdataApply(String pid) {

		// TODO Auto-generated method stub return null;
		IOaBudgetdataApplyDao service = new OaBudgetdataApplyDao();
		return service.getOaBudgetdataApply(pid);
	}

}

