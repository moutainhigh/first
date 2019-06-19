
    package com.deppon.montal.module.workitems.dao; 

import java.util.List;

import com.deppon.montal.model.CCPovehivlePayment;
import com.deppon.montal.model.CCPovehivlePaymentEntry;
   /** 
 * @Title: IEvhiclePayDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-6 上午9:38:33 
 * @version V1.0 
 */
public interface ICCPovehivlePaymentDao {
	public CCPovehivlePayment getCCPovehivlePaymentByWorkId(String workId);
	public List<CCPovehivlePaymentEntry> getCCPovehivlePaymentEntriesByWorkId(String workId);
}

