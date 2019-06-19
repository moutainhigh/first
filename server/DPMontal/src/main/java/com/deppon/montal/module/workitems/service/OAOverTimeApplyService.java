
    package com.deppon.montal.module.workitems.service; 

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.deppon.montal.model.OAOvertimeApply;
import com.deppon.montal.model.OvertimeInfo;
import com.deppon.montal.module.workitems.dao.IOAOverTimeApplyDao;
import com.deppon.montal.module.workitems.dao.OAOverTimeApplyDao;
   /** 
 * @Title: OAOverTimeApplyService.java
 * @Package com.deppon.montal.login.service 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-20 下午4:03:00 
 * @version V1.0 
 */
public class OAOverTimeApplyService implements IOAOverTimeApplyService{
	@Override
	public OAOvertimeApply getOAOverTimeApply(String workId) {
		IOAOverTimeApplyDao dao = new OAOverTimeApplyDao();
		return dao.getOAOverTimeApply(workId);
	}
	@Override
	public List<OvertimeInfo> getOvertimes(OAOvertimeApply oaovertimeapply) {
		List<OvertimeInfo> list = null;
		if(oaovertimeapply.getOttype()!=null){
			list = new ArrayList<OvertimeInfo>();
			String ottype = oaovertimeapply.getOttype();
			String begintime = oaovertimeapply.getBegindate();
			String endtime = oaovertimeapply.getEnddate();
			String[] ottypes = ottype.split(Pattern.quote("|"));
			String[] begintimes = begintime.split(Pattern.quote("|"));
			String[] endtimes = endtime.split(Pattern.quote("|"));
			OvertimeInfo overtimeinfo = null;
			for(int i=0;i<ottypes.length;i++){
				overtimeinfo = new OvertimeInfo(ottypes[i], begintimes[i], endtimes[i]);
				list.add(overtimeinfo);
			}
		}
		return list;
	}
}

