
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OALicenseCanceledInfo;


   /** 
   * @ClassName: IOALicenseCanceledDao 
   * @Description:(分公司证照注销工作流数据层) 
   * @author 廖建雄 
   * @date 2013-8-22 上午10:06:53 
   * 
   */
public interface IOALicenseCanceledDao {
    
    
  
   /** 
   * @Title: getLicenseCanceledInfo 
   * @Description:(获取分公司证照注销工作流详细) 
   * @param @param processinstid
   * @param @return 设定文件 
   * @returnOALicenseCanceledInfo 返回类型 
   * @throws 
   * @date 2013-8-22 上午10:06:49 
   */
public OALicenseCanceledInfo getLicenseCanceledInfo(String processinstid);


}

