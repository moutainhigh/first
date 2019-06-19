
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.CCOnbusiness;
   /** 
 * @Title: ICCOnbusinessDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (出差申请工作流数据层) 
 * @author 廖建雄 
 * @date 2013-4-27 上午10:00:39 
 * @version V1.0 
 */
public interface ICCOnbusinessDao {
    
    
       /** 
       * @Title: getCConOnbusiness 
       * @Description:(获取请假申请工作流明细) 
       * @param @param processinstid
       * @param @return 设定文件 
       * @return CCOnbusiness 返回类型 
       * @throws 
       * @date 2013-4-27 上午11:27:07 
       */
    public CCOnbusiness getCConOnbusiness(String processinstid);
}

