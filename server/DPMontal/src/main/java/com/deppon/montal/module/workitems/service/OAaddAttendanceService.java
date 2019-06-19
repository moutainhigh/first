
    package com.deppon.montal.module.workitems.service; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.model.OAaddAttendance;
import com.deppon.montal.model.OAaddAttendanceEntry;
import com.deppon.montal.module.workitems.dao.IOAaddAttendanceDao;
import com.deppon.montal.module.workitems.dao.OAaddAttendanceDao;
   /** 
 * @Title: OAaddAttendanceService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: (补考勤工作流业务处理) 
 * @author 廖建雄 
 * @date 2013-4-27 上午11:03:00 
 * @version V1.0 
 */
public class OAaddAttendanceService implements IOAaddAttendanceService {
    
	private IOAaddAttendanceDao dao =new OAaddAttendanceDao();
    
    @Override
    public Map<String,Object> getAddAttendanceInfo(String processinstid) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		OAaddAttendance attendance = dao.getAddAttendanceInfo(processinstid);
		List<OAaddAttendanceEntry> entryList = new ArrayList<OAaddAttendanceEntry>();
		//分割补考勤详细信息
		if(null != attendance.getAddman()){
			String[] addman = attendance.getAddman().split("[|]");
			String[] adddept = attendance.getAdddept().split("[|]");
			String[] adddate = attendance.getAdddate().split("[|]");
			String[] addtype = attendance.getAddtype().split("[|]");
			String[] reason = attendance.getReason().split("[|]");
			String[] reference = attendance.getReference().split("[|]");
			for (int i=0; i<addman.length; i++) {
				OAaddAttendanceEntry entry = new OAaddAttendanceEntry();
			    entry.setAddman(addman[i]);
			    entry.setAdddept(adddept[i]);
			    entry.setAdddate(adddate[i]);
			    entry.setAddtype(addtype[i]);
			    entry.setReason(reason[i]);
			    entry.setReference(reference[i]);	
			    entryList.add(entry);
			}
		}
	
		map.put("OAaddAttendance", attendance);
		map.put("addAttendanceEntryList", entryList);
		return map;
    }

}

