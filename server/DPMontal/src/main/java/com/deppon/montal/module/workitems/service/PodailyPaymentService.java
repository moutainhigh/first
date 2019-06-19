
    package com.deppon.montal.module.workitems.service; 

import java.util.List;

import com.deppon.montal.model.CCPodailyPayment;
import com.deppon.montal.model.CCPodailyPaymentEntry;
import com.deppon.montal.module.workitems.dao.IPodailyPaymentDao;
import com.deppon.montal.module.workitems.dao.PodailyPaymentDao;
   /** 
 * @Title: PodailyPaymentService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author 廖建雄 
 * @date 2013-5-14 下午4:25:38 
 * @version V1.0 
 */
public class PodailyPaymentService implements IPodailyPaymentService {

    private IPodailyPaymentDao dao = new PodailyPaymentDao();
    
    @Override
    public CCPodailyPayment getCCPodailyPaymentInfo(String processinstid) {
	return dao.getCCPodailyPaymentInfo(processinstid);
    }
    @Override
    public List<CCPodailyPaymentEntry> getCCPodailyPaymentEntry(String processinstid) {
	return dao.getCCPodailyPaymentEntry(processinstid);
    }

}

