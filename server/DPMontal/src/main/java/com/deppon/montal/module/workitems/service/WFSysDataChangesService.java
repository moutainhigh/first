
    package com.deppon.montal.module.workitems.service; 

import java.util.HashMap;
import java.util.Map;

import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.model.WFSysDataChanges;
import com.deppon.montal.module.workitems.dao.IOmEmployeeDao;
import com.deppon.montal.module.workitems.dao.IWFSysDataChangesDao;
import com.deppon.montal.module.workitems.dao.OmEmployeeDao;
import com.deppon.montal.module.workitems.dao.WFSysDataChangesDao;
   /** 
 * @Title: WFSysDataChangesService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: (处理系统变更业务) 
 * @author 廖建雄 
 * @date 2013-4-10 下午4:23:04 
 * @version V1.0 
 */
public class WFSysDataChangesService implements IWFSysDataChangesService {
    IWFSysDataChangesDao dao = new WFSysDataChangesDao();
    IOmEmployeeDao empdao = new OmEmployeeDao();
    public WFSysDataChanges getSysDataChangesDetail(String processinstid){
	return dao.getSysDataChangesDetail(processinstid);
    }
    
    public Map getApprover(LoginUser user){
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("devAppList", empdao.getDevApprover(user));
	map.put("devManageAppList", empdao.getDevManageApprover(user));
	return map;
    }
}

