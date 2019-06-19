
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OALicenseCanceledInfo;
import com.deppon.montal.module.workitems.dao.IOALicenseCanceledDao;
import com.deppon.montal.module.workitems.dao.OALicenseCanceledDao;

   /** 
   * @ClassName: OALicenseCanceledDao 
   * @Description:(分公司证照注销工作流业务处理) 
   * @author 廖建雄 
   * @date 2013-8-22 上午10:07:53 
   * 
   */
public class OALicenseCanceledService implements IOALicenseCanceledService {
    IOALicenseCanceledDao dao = new OALicenseCanceledDao();
    @Override
    public OALicenseCanceledInfo getLicenseCanceledInfo(String processinstid) {
	return dao.getLicenseCanceledInfo(processinstid);

    }

}

