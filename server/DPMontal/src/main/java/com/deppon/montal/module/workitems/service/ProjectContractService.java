
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OaContractApply;
import com.deppon.montal.module.workitems.dao.IProjectContractApplyDao;
import com.deppon.montal.module.workitems.dao.ProjectContractApplyDao;
   /** 
 * @Title: ProjectContractService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(项目类合同签订申请) 
 * @author 何玲菠 
 * @date 2013-7-17 上午9:17:26 
 * @version V1.0 
 */
public class ProjectContractService implements IProjectContractService {

	@Override
	public OaContractApply getOAContractApplyByWorkId(String workId) {
		IProjectContractApplyDao dao = new ProjectContractApplyDao();
		OaContractApply oacontractapply = dao.getOAContractApplyByWorkId(workId);
		return oacontractapply;
	}
}

