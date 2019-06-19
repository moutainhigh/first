
    package com.deppon.montal.module.workitems.service; 

import java.util.List;

import com.deppon.montal.model.CCPodailyPayment;
import com.deppon.montal.model.CCPodailyPaymentEntry;
 /** 
 * @Title: IRealcontractBorrowDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (日常付款业务层) 
 * @author 廖建雄 
 * @date 2013-5-14 上午9:12:35 
 * @version V1.0 
 */
public interface IPodailyPaymentService {
    
       /** 
       * @Title: getCCPodailyPaymentInfo 
       * @Description:(获取日常付款工作流详细) 
       * @param @param processinstid
       * @return CCPodailyPayment 返回类型 
       * @throws 
       * @date 2013-5-14 上午9:26:50 
       */
    public CCPodailyPayment getCCPodailyPaymentInfo(String processinstid);
    
       /** 
       * @Title: getCCPodailyPaymentEntry 
       * @Description:(获取日常付款工作流明细) 
       * @param @param processinstid
       * @return CCPodailyPaymentEntry 返回类型 
       * @throws 
       * @date 2013-5-14 下午4:28:00 
       */
    public List<CCPodailyPaymentEntry> getCCPodailyPaymentEntry(String processinstid);
}

