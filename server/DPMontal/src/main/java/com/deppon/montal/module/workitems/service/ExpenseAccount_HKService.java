
    package com.deppon.montal.module.workitems.service; 

import java.util.List;

import com.deppon.montal.model.TWFSexpensehk;
import com.deppon.montal.model.TWFSexpensehkSub;
import com.deppon.montal.module.workitems.dao.ExpenseAccount_HKDao;
import com.deppon.montal.module.workitems.dao.IExpenseAccount_HKDao;
   /** 
 * @Title: ExpenseAccount_HKService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(费用报销香港) 
 * @author 何玲菠 
 * @date 2013-7-17 下午2:52:45 
 * @version V1.0 
 */
public class ExpenseAccount_HKService implements IExpenseAccount_HKService {

	@Override
	public TWFSexpensehk getTWFSexpensehkByWorkId(String workId) {
		IExpenseAccount_HKDao dao = new ExpenseAccount_HKDao();
		return dao.getTWFSexpensehkByWorkId(workId);
	}

	@Override
	public List<TWFSexpensehkSub> getTWFSexpensehkSubsByWorkId(String workId) {
		IExpenseAccount_HKDao dao = new ExpenseAccount_HKDao();
		return dao.getTWFSexpensehkSubsByWorkId(workId);
	}

}

