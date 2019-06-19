
    package com.deppon.montal.module.workitems.dao; 

import java.util.List;

import com.deppon.montal.model.CCDlworkrelatedInjury;
import com.deppon.montal.model.CCDlworkrelatedInjuryEntry;
/** 
 * @Title: IDlworkrelatedInjuryDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (工伤医疗费用报销申请数据层) 
 * @author 廖建雄 
 * @date 2013-6-6 上午11:44:35 
 * @version V1.0 
 */
public interface IDlworkrelatedInjuryDao {
    
    
       /** 
       * @Title: getiInjury 
       * @Description:(工伤医疗费用报销申请工作流详细) 
       * @param @param processinstid
       * @return CCDlworkrelatedInjury 返回类型 
       * @throws 
       * @date 2013-6-9 下午3:19:20 
       */
    public CCDlworkrelatedInjury getiInjury(String processinstid);
    
       /** 
       * @Title: getinInjuryEntry 
       * @Description:(工伤医疗费用报销申请工作流明细) 
       * @param @param processinstid
       * @return List<CCDlworkrelatedInjuryEntry> 返回类型 
       * @throws 
       * @date 2013-6-9 下午3:19:43 
       */
    public List<CCDlworkrelatedInjuryEntry> getinInjuryEntry(String processinstid);

}

