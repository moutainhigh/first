
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.CCOnbusiness;
import com.deppon.montal.module.workitems.dao.CCOnbusinessDao;
import com.deppon.montal.module.workitems.dao.ICCOnbusinessDao;
   /** 
 * @Title: CCOnbusinessService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(请假申请工作流业务处理) 
 * @author 廖建雄 
 * @date 2013-4-27 上午11:32:44 
 * @version V1.0 
 */
public class CCOnbusinessService implements ICCOnbusinessService{
    
    private ICCOnbusinessDao dao = new CCOnbusinessDao();
    
    @Override
    public CCOnbusiness getCConOnbusiness(String processinstid) {
	return dao.getCConOnbusiness(processinstid);
    }

}

