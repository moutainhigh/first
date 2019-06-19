
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.model.OAAssessApply;
import com.deppon.montal.module.workitems.dao.IOAAssessProgramDao;
import com.deppon.montal.module.workitems.dao.OAAssessProgramDao;
   /** 
 * @Title: OAAssessProgramService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-21 上午10:48:41 
 * @version V1.0 
 */
public class OAAssessProgramService implements IOAAssessProgramService {

	@Override
	public OAAssessApply getOAAssessApply(String workId) {
		IOAAssessProgramDao dao = new OAAssessProgramDao();
		OAAssessApply oaassessapply = dao.getOAAssessApply(workId);
//		System.out.println((oaassessapply.getSeason()));
//		System.out.println((Integer.parseInt(oaassessapply.getQuality())));
		oaassessapply.setSeason(F_Constants.ASSESS_PROGRAM_SEASON.get(Integer.parseInt(oaassessapply.getSeason())));
		oaassessapply.setQuality(F_Constants.ASSESS_PROGRAM_DEPT_PROPERTY.get(Integer.parseInt(oaassessapply.getQuality())));
		return oaassessapply;
	}

}

