
    package com.deppon.montal.module.workitems.service; 

import java.util.List;

import com.deppon.montal.model.OAOvertimeApply;
   import com.deppon.montal.model.OvertimeInfo;
/** 
 * @Title: IOAOverTimeApplyService.java
 * @Package com.deppon.montal.login.service 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-20 下午4:01:52 
 * @version V1.0 
 */
public interface IOAOverTimeApplyService {
	public OAOvertimeApply getOAOverTimeApply(String workId);
	public List<OvertimeInfo> getOvertimes(OAOvertimeApply oaovertimeapply);
}

