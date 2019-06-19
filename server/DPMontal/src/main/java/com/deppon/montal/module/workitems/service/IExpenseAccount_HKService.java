
    package com.deppon.montal.module.workitems.service; 

import java.util.List;

import com.deppon.montal.model.TWFSexpensehk;
import com.deppon.montal.model.TWFSexpensehkSub;
   /** 
 * @Title: IExpenseAccount_HKService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(费用报销香港) 
 * @author 何玲菠 
 * @date 2013-7-17 下午2:52:02 
 * @version V1.0 
 */
public interface IExpenseAccount_HKService {
	TWFSexpensehk getTWFSexpensehkByWorkId(String workId);
	List<TWFSexpensehkSub> getTWFSexpensehkSubsByWorkId(String workId); 
}

