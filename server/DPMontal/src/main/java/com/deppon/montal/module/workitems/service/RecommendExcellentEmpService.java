
    package com.deppon.montal.module.workitems.service; 


import com.deppon.montal.model.RecommendExcellentEmp;
import com.deppon.montal.module.workitems.dao.IRecommendExcellentEmpDao;
import com.deppon.montal.module.workitems.dao.RecommendExcellentEmpDao;
/** 
 * @Title: BorrowsealApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (优秀人才推荐业务处理) 
 * @author 廖建雄 
 * @date 2013-6-26 下午2:02:47 
 * @version V1.0 
 */
public class RecommendExcellentEmpService implements IRecommendExcellentEmpService {
    IRecommendExcellentEmpDao dao = new RecommendExcellentEmpDao();
    @Override
    public RecommendExcellentEmp getExcellentEmp(String processinstid) {
	return dao.getExcellentEmp(processinstid);

    }
}

