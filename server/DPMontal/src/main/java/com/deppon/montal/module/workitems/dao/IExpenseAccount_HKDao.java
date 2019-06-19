
    package com.deppon.montal.module.workitems.dao; 

import java.util.List;

import com.deppon.montal.model.TWFSexpensehk;
   import com.deppon.montal.model.TWFSexpensehkSub;
/** 
 * @Title: IExpenseAccountDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(费用报销_香港) 
 * @author 何玲菠 
 * @date 2013-7-17 下午1:56:09 
 * @version V1.0 
 */
public interface IExpenseAccount_HKDao {
	TWFSexpensehk getTWFSexpensehkByWorkId(String workId);
	List<TWFSexpensehkSub> getTWFSexpensehkSubsByWorkId(String workId); 
}

