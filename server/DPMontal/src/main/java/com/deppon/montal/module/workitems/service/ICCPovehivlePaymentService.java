
    package com.deppon.montal.module.workitems.service; 

import java.util.List;

import com.deppon.montal.model.CCPovehivlePayment;
import com.deppon.montal.model.CCPovehivlePaymentEntry;
/** 
 * @Title: ICCPovehivlePaymentService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-6 上午9:45:56 
 * @version V1.0 
 */
public interface ICCPovehivlePaymentService {
	public CCPovehivlePayment getCCPovehivlePaymentByWorkId(String workId);
	public List<CCPovehivlePaymentEntry> getCCPovehivlePaymentEntriesByWorkId(String workId);
}

