
    package com.deppon.montal.module.workitems.service; 

import java.util.HashMap;
import java.util.Map;

import com.deppon.montal.model.CCDlworkrelatedInjury;
import com.deppon.montal.model.CCDlworkrelatedInjuryEntry;
import com.deppon.montal.module.workitems.dao.DlworkrelatedInjuryDao;
import com.deppon.montal.module.workitems.dao.IDlworkrelatedInjuryDao;
   /** 
 * @Title: DlworkrelatedInjuryDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (工伤医疗费用报销申请业务处理) 
 * @author 廖建雄 
 * @date 2013-6-6 上午11:44:51 
 * @version V1.0 
 */
public class DlworkrelatedInjuryService implements IDlworkrelatedInjuryService {
    
    private static IDlworkrelatedInjuryDao dao = new DlworkrelatedInjuryDao();
    @Override
    public Map getiInjuryInfo(String processinstid) {
	
	Map map = new HashMap();
	map.put("CCDlworkrelatedInjury", dao.getiInjury(processinstid));
	map.put("CCDlworkrelatedInjuryEntry", dao.getinInjuryEntry(processinstid));
	return map;
	
    }


}

