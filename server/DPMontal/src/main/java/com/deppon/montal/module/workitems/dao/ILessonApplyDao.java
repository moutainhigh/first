
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OALessonApply;
   /** 
 * @Title: ILessonApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(课程研发/审核申请数据层) 
 * @author 廖建雄 
 * @date 2013-7-16 下午3:23:31 
 * @version V1.0 
 */
public interface ILessonApplyDao {
    
    
       /** 
       * @Title: getLessonApply 
       * @Description:(课程研发/审核申请工作流详细) 
       * @param processinstid
       * @return OALessonApply 返回类型 
       * @throws 
       * @date 2013-7-16 下午3:29:46 
       */
    public OALessonApply getLessonApply (String processinstid);
}

