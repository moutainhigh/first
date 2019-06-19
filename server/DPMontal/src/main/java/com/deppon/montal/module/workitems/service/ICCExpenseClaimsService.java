
    package com.deppon.montal.module.workitems.service; 

import java.util.List;

import com.deppon.montal.model.CCExpenseClaim;
import com.deppon.montal.model.CCExpenseClaimEntry;
   /** 
 * @Title: ICCExpenseClaimsService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(通用费用报销单service层) 
 * @author 何玲菠 
 * @date 2013-4-27 下午3:09:28 
 * @version V1.0 
 */
public interface ICCExpenseClaimsService {
	
	public CCExpenseClaim getCCExpenseClaims(String processinstid);
    /** 
    * @Title: getCCwelfareexpenseEntry 
    * @Description:(获取通用费用报销单工作流详细信息) 
    * @param @param processinstid
    * @param @return 设定文件 
    * @returnCCExpenseClaim 返回类型 
    * @throws 
    * @date 2013-4-27 下午2:23:04 
    */
	public List<CCExpenseClaimEntry> getCCExpenseClaimsEntry(String processinstid);
    /** 
    * @Title: getCCwelfareexpenseEntry 
    * @Description:(获取通用费用报销单分录表详细信息) 
    * @param @param processinstid
    * @param @return 设定文件 
    * @returnCCExpenseClaimEntry 返回类型 
    * @throws 
    * @date 2013-4-27 下午2:23:04 
    */
}

