
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OALicenseLendRead;



   /** 
   * @ClassName: IOALicenseLendReadDao 
   * @Description:(证照借阅申请（新）数据层) 
   * @author 廖建雄 
   * @date 2013-8-23 下午2:31:58 
   * 
   */
public interface IOALicenseLendReadDao {
    
    
  

   /** 
   * @Title: getLicenseLendRead 
   * @Description:(获取证照借阅申请（新）工作流详细) 
   * @param @param processinstid
   * @return OALicenseLendRead 返回类型 
   * @throws 
   * @date 2013-8-23 下午2:31:55 
   */
public OALicenseLendRead getLicenseLendRead(String processinstid);


}

