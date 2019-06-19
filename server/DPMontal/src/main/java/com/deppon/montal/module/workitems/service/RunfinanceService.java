
    package com.deppon.montal.module.workitems.service; 


import com.deppon.montal.model.OARunfinance;
import com.deppon.montal.module.workitems.dao.IRunfinanceDao;
import com.deppon.montal.module.workitems.dao.RunfinanceDao;
   /** 
 * @Title: RunfinanceDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 廖建雄 
 * @date 2013-6-20 下午3:02:14 
 * @version V1.0 
 */
public class RunfinanceService implements IRunfinanceService {

    private static IRunfinanceDao dao = new RunfinanceDao();
    
    @Override
    public OARunfinance getRunfinance(String processinstid) {
	  return dao.getRunfinance(processinstid);
    }
}

