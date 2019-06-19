
    package com.deppon.montal.module.workitems.service; 

import java.util.List;

import com.deppon.montal.model.CCPovehivlePayment;
import com.deppon.montal.model.CCPovehivlePaymentEntry;
import com.deppon.montal.module.workitems.dao.CCPovehivlePaymentDao;
import com.deppon.montal.module.workitems.dao.ICCPovehivlePaymentDao;
   /** 
 * @Title: CCPovehivlePaymentService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-6 上午9:46:45 
 * @version V1.0 
 */
public class CCPovehivlePaymentService implements ICCPovehivlePaymentService {

	@Override
	public CCPovehivlePayment getCCPovehivlePaymentByWorkId(String workId) {

		// TODO Auto-generated method stub return null;
		ICCPovehivlePaymentDao dao = new CCPovehivlePaymentDao();
		return dao.getCCPovehivlePaymentByWorkId(workId);
	}
	@Override
	public List<CCPovehivlePaymentEntry> getCCPovehivlePaymentEntriesByWorkId(
			String workId) {
		ICCPovehivlePaymentDao dao = new CCPovehivlePaymentDao();
		return dao.getCCPovehivlePaymentEntriesByWorkId(workId);
	}
}

