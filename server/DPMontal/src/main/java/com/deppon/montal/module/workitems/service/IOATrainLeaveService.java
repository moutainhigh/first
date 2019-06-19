
    package com.deppon.montal.module.workitems.service; 

import java.util.Map;

   /** 
 * @Title: IOATrainLeaveDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(培训请假业务层) 
 * @author 廖建雄 
 * @date 2013-7-16 下午3:23:31 
 * @version V1.0 
 */
public interface IOATrainLeaveService {
    
    
       /** 
       * @Title: getTrainLeave 
       * @Description:(培训请假流程工作流详细) 
       * @param processinstid
       * @return Map 返回类型 
       * @throws 
       * @date 2013-7-16 下午3:29:46 
       */
    public Map getTrainLeave(String processinstid);
}

