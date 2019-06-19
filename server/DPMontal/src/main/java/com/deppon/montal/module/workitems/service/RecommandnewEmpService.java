
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.RecommandNewEMP;
import com.deppon.montal.module.workitems.dao.IRecommandnewEmpDao;
import com.deppon.montal.module.workitems.dao.RecommandnewEmpDao;
   /** 
 * @Title: RecommandnewEmpService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-5-13 下午2:51:48 
 * @version V1.0 
 */
public class RecommandnewEmpService implements IRecommandnewEmpService {

	@Override
	public RecommandNewEMP getRecommandNewEMP(String pid) {

		// TODO Auto-generated method stub return null;
		IRecommandnewEmpDao service = new RecommandnewEmpDao();
		return service.getRecommandNewEmp(pid);
	}

}

