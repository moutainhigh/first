
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OALicenseLendRead;
import com.deppon.montal.module.workitems.dao.IOALicenseLendReadDao;
import com.deppon.montal.module.workitems.dao.OALicenseLendReadDao;

   /** 
   * @ClassName: OALicenseLendReadDao 
   * @Description:(证照借阅申请（新）业务处理) 
   * @author 廖建雄 
   * @date 2013-8-23 下午2:53:19 
   * 
   */
public class OALicenseLendReadService implements IOALicenseLendReadService {
    
    IOALicenseLendReadDao dao = new OALicenseLendReadDao();
    @Override
    public OALicenseLendRead getLicenseLendRead(String processinstid) {
	
	return dao.getLicenseLendRead(processinstid);

    }

}

