
    package com.deppon.montal.module.workitems.service; 

import java.util.HashMap;
import java.util.Map;

import com.deppon.montal.module.workitems.dao.IOABusinessBaddebtsDao;
import com.deppon.montal.module.workitems.dao.OABusinessBaddebtsDao;

 /** 
 * @Title: OABusinessBaddebtService.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(场地设计申请工作流业务处理) 
 * @author 廖建雄 
 * @date 2013-8-5 下午2:07:53 
 * @version V1.0 
 */
public class OABusinessBaddebtService implements IOABusinessBaddebtsService {
    IOABusinessBaddebtsDao dao = new OABusinessBaddebtsDao();
    
    @Override
    public Map getBusinessBaddebt(String processinstid) {
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("businessBaddebts", dao.getBusinessBaddebts(processinstid)); //坏账详细
	map.put("baddebtbills", dao.getBaddebtbills(processinstid)); //坏账表单明细
	map.put("baddebtleafs", dao.getBaddebtleafs(processinstid)); //责任明细
	return map;
    }
    

}

