
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OADismissal;
import com.deppon.montal.module.workitems.dao.DismissalDao;
import com.deppon.montal.module.workitems.dao.IDismissalDao;

   /** 
 * @Title: DismissalService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description:(免职申请业务处理) 
 * @author 廖建雄 
 * @date 2013-6-26 下午2:02:47 
 * @version V1.0 
 */
public class DismissalService implements IDismissalService {
    private IDismissalDao dao = new DismissalDao();
    
    @Override
    public OADismissal getDismissal(String processinstid) {
	return dao.getDismissal(processinstid);
    }

}

