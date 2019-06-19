
    package com.deppon.montal.module.workitems.service; 

import java.util.List;

import com.deppon.montal.model.CCWelfareexpense;
import com.deppon.montal.model.CCwelfareexpenseEntry;
   /** 
 * @Title: ICCWelfareexpenseService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: (福利费用工作流业务层) 
 * @author 廖建雄 
 * @date 2013-4-27 下午2:21:31 
 * @version V1.0 
 */
public interface ICCWelfareexpenseService {
    
    
       /** 
       * @Title: getCCWelfareexpense 
       * @Description:(获取福利费用工作流明细) 
       * @param @param processinstid
       * @param @return 设定文件 
       * @returnCCWelfareexpense 返回类型 
       * @throws 
       * @date 2013-4-27 下午2:23:02 
       */
    public CCWelfareexpense getCCWelfareexpense(String processinstid);
    
       /** 
       * @Title: getCCwelfareexpenseEntry 
       * @Description:(获取福利费用工作流详细信息) 
       * @param @param processinstid
       * @param @return 设定文件 
       * @returnCCwelfareexpenseEntry 返回类型 
       * @throws 
       * @date 2013-4-27 下午2:23:04 
       */
    public List<CCwelfareexpenseEntry> getCCwelfareexpenseEntry(String processinstid);
}

