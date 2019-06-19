
    package com.deppon.montal.module.workitems.service; 

import java.util.List;

import com.deppon.montal.model.CCExpenseClaim;
import com.deppon.montal.model.CCExpenseClaimEntry;
import com.deppon.montal.module.workitems.dao.CCExpenseClaimDao;
import com.deppon.montal.module.workitems.dao.ICCExpenseClaimDao;
   /** 
 * @Title: CCExpenseClaimService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-4-27 下午3:13:30 
 * @version V1.0 
 */
public class CCExpenseClaimService implements ICCExpenseClaimsService {
	private ICCExpenseClaimDao dao = new CCExpenseClaimDao();
	@Override
	public CCExpenseClaim getCCExpenseClaims(String processinstid) {

		// TODO Auto-generated method stub return null;
		return dao.getCCExpenseClaim(processinstid);
	}

	@Override
	public List<CCExpenseClaimEntry> getCCExpenseClaimsEntry(String processinstid) {

		// TODO Auto-generated method stub return null;
		return dao.getCCExpenseClaimeEntry(processinstid);
	}

}

