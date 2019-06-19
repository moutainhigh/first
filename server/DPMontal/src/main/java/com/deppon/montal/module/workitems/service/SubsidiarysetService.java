
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OASubSidiarySet;
import com.deppon.montal.module.workitems.dao.ISubsidiarysetDao;
import com.deppon.montal.module.workitems.dao.SubsidiarysetDao;
   /** 
 * @Title: SubsidiarysetService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(子公司设立及变更申请service) 
 * @author 何玲菠 
 * @date 2013-7-16 上午10:08:59 
 * @version V1.0 
 */
public class SubsidiarysetService implements ISubsidiarysetService {

	@Override
	public OASubSidiarySet getOASubsidiarysetByWorkId(String workId) {
		ISubsidiarysetDao dao = new SubsidiarysetDao();
		return dao.getOASubsidiaryset(workId);
	}

}

