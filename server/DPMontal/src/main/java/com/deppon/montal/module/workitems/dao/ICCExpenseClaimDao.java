
    package com.deppon.montal.module.workitems.dao; 

import java.util.List;

import com.deppon.montal.model.CCExpenseClaim;
import com.deppon.montal.model.CCExpenseClaimEntry;
   /** 
 * @Title: ICCExpenseClaimDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (通用费用工作流数据层) 
 * @author 廖建雄 
 * @date 2013-4-27 上午9:58:20 
 * @version V1.0 
 */
public interface ICCExpenseClaimDao {
    
       /** 
       * @Title: getCCExpenseClaim 
       * @Description:(获取通用费用工作流明细) 
       * @param @param processinstid
       * @param @return 设定文件 
       * @returnCCExpenseClaim 返回类型 
       * @throws 
       * @date 2013-4-27 下午2:38:48 
       */
    public CCExpenseClaim getCCExpenseClaim(String processinstid);
    
       /** 
       * @Title: getCCExpenseClaimeEntry 
       * @Description:(获取通用费用工作流详细信息) 
       * @param @param processinstid
       * @param @return 设定文件 
       * @returnCCExpenseClaimEntry 返回类型 
       * @throws 
       * @date 2013-4-27 下午2:38:51 
       */
    public List<CCExpenseClaimEntry> getCCExpenseClaimeEntry(String processinstid);
}

