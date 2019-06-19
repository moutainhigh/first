
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OARealcontractBorrow;
import com.deppon.montal.module.workitems.dao.IRealcontractBorrowDao;
import com.deppon.montal.module.workitems.dao.RealcontractBorrowDao;
   /** 
 * @Title: RealcontractBorrowService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: (实体合同借阅业务处理) 
 * @author 廖建雄 
 * @date 2013-5-14 上午9:29:29 
 * @version V1.0 
 */
public class RealcontractBorrowService implements IRealcontractBorrowService {

    private IRealcontractBorrowDao dao = new RealcontractBorrowDao();
    
    @Override
    public OARealcontractBorrow getOARealcontractBorrowInfo(String processinstid) {
	return dao.getOARealcontractBorrowInfo(processinstid);
    }

}

