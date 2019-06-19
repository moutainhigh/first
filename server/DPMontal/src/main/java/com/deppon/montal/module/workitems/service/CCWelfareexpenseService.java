
    package com.deppon.montal.module.workitems.service; 

import java.util.List;

import com.deppon.montal.model.CCWelfareexpense;
import com.deppon.montal.model.CCwelfareexpenseEntry;
import com.deppon.montal.module.workitems.dao.CCWelfareexpenseDao;
import com.deppon.montal.module.workitems.dao.ICCWelfareexpenseDao;
   /** 
 * @Title: CCWelfareexpenseService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author 廖建雄 
 * @date 2013-4-27 下午2:21:45 
 * @version V1.0 
 */
public class CCWelfareexpenseService implements ICCWelfareexpenseService {
    private ICCWelfareexpenseDao dao = new CCWelfareexpenseDao();
    
    public CCWelfareexpense getCCWelfareexpense(String processinstid) {
	
	return dao.getCCWelfareexpense(processinstid);
    }

    @Override
    public List<CCwelfareexpenseEntry> getCCwelfareexpenseEntry(String processinstid) {
	
	  return dao.getCCwelfareexpenseEntry(processinstid);
    }
}

