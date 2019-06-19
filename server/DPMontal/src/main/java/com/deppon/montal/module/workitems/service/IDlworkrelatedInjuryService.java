
    package com.deppon.montal.module.workitems.service; 

import java.util.Map;

import com.deppon.montal.model.CCDlworkrelatedInjury;
import com.deppon.montal.model.CCDlworkrelatedInjuryEntry;
/** 
 * @Title: IDlworkrelatedInjuryDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (工伤医疗费用报销申请业务层) 
 * @author 廖建雄 
 * @date 2013-6-6 上午11:44:35 
 * @version V1.0 
 */
public interface IDlworkrelatedInjuryService {
    
    
    /** 
     * @Title: getiInjuryInfo 
     * @Description:(工伤医疗费用报销申请工作流详细) 
     * @param @param processinstid
     * @return Map 返回类型 
     * @return CCDlworkrelatedInjury
     * @return CCDlworkrelatedInjuryEntry
     * @throws 
     * @date 2013-6-9 下午3:19:20 
     */
  public Map getiInjuryInfo(String processinstid);
  

}

