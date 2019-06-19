
    package com.deppon.montal.module.workitems.dao; 

import java.util.List;

import com.deppon.montal.model.CCExpenseClaimEntry;
import com.deppon.montal.model.CCWelfareexpense;
import com.deppon.montal.model.CCwelfareexpenseEntry;
   /** 
 * @Title: ICCWelfareexpenseDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (福利费用工作流数据层) 
 * @author 廖建雄 
 * @date 2013-4-27 上午9:58:54 
 * @version V1.0 
 */
public interface ICCWelfareexpenseDao {
    
       /** 
       * @Title: getCCWelfareexpense 
       * @Description:(获取福利费用工作流明细) 
       * @return CCWelfareexpense 返回类型 
       * @throws 
       * @date 2013-4-27 下午2:14:37 
       */
    public CCWelfareexpense getCCWelfareexpense(String processinstid);
    
       /** 
       * @Title: getCCwelfareexpenseEntry 
       * @Description:(获取福利费用工作流详细信息) 
       * @return CCwelfareexpenseEntry 返回类型 
       * @throws 
       * @date 2013-4-27 下午2:15:09 
       */
    public List<CCwelfareexpenseEntry> getCCwelfareexpenseEntry(String processinstid);
    
}

