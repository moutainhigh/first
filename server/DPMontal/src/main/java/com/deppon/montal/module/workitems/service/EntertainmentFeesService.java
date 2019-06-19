
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.CCEntertainmentFees;
import com.deppon.montal.module.workitems.dao.EntertainmentFeesDao;
import com.deppon.montal.module.workitems.dao.IEntertainmentFeesDao;
   /** 
 * @Title: EntertainmentFeesService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: (应酬费（新）业务处理) 
 * @author 廖建雄 
 * @date 2013-6-7 下午3:31:10 
 * @version V1.0 
 */
public class EntertainmentFeesService implements IEntertainmentFeesService {
    IEntertainmentFeesDao dao = new EntertainmentFeesDao();
    @Override
    public CCEntertainmentFees getFees(String processinstid) {
	   return dao.getFees(processinstid);
    }
}

