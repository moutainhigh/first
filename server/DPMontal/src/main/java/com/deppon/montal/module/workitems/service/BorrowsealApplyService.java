
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OABorrowsealApply;
import com.deppon.montal.module.workitems.dao.BorrowsealApplyDao;
import com.deppon.montal.module.workitems.dao.IBorrowsealApplyDao;
   /** 
 * @Title: BorrowsealApplyService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: (获取借章申请业务操作) 
 * @author 廖建雄 
 * @date 2013-6-26 下午2:02:47 
 * @version V1.0 
 */
public class BorrowsealApplyService implements IBorrowsealApplyService {
    
    private static IBorrowsealApplyDao dao = new BorrowsealApplyDao();
    @Override
    public OABorrowsealApply getBorrowsealApply(String processinstid) {
	return dao.getBorrowsealApply(processinstid);

    }

}

