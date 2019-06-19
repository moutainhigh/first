
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.CCOnbusiness;

   /** 
 * @Title: ICCOnbusinessService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: (请假申请工作流业务处理) 
 * @author 廖建雄 
 * @date 2013-4-27 上午11:32:36 
 * @version V1.0 
 */
public interface ICCOnbusinessService {
    
       /** 
       * @Title: getCConOnbusiness 
       * @Description:(获取申请工作流申请明细) 
       * @param @param processinstid
       * @param @return 设定文件 
       * @returnCCOnbusiness 返回类型 
       * @throws 
       * @date 2013-4-27 上午11:34:34 
       */
    public CCOnbusiness getCConOnbusiness(String processinstid);
}

