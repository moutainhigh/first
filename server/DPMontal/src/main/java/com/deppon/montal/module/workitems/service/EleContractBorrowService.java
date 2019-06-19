
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OAElectroniContractBorrow;
import com.deppon.montal.module.workitems.dao.EleContractBorrowDao;
import com.deppon.montal.module.workitems.dao.IEleContractBorrowDao;
   /** 
 * @Title: EleContractBorrowService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author yinrongping 
 * @date 2013-8-5 上午11:05:46 
 * @version V1.0 
 */
public class EleContractBorrowService implements IEleContractBorrowService {

	private IEleContractBorrowDao borrowDao = new EleContractBorrowDao();
	
	/** 
	 * 获取电子合同借阅申请
	 */
	@Override
	public OAElectroniContractBorrow getEleContractBorrowInfo(
			String processinstid) {

		return borrowDao.getEleContractBorrowInfo(processinstid);

	}

}

