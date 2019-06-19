
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OAAssessreduceApply;
   /** 
 * @Title: IAssessreduceApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(考核特批减免申请数据层) 
 * @author 廖建雄 
 * @date 2013-7-16 下午3:23:31 
 * @version V1.0 
 */
public interface IAssessreduceApplyDao {
    
    
       /** 
       * @Title: getAssessreduceApply 
       * @Description:(考核特批减免申请工作流详细) 
       * @param processinstid
       * @return OAAssessreduceApply 返回类型 
       * @throws 
       * @date 2013-7-16 下午3:29:46 
       */
    public OAAssessreduceApply getAssessreduceApply(String processinstid);
}

