package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OAaddAttendance;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: OAaddAttendanceDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: 补考勤工作流
 * @author yin
 * @date 2013-4-27 上午9:57:39 
 * @version V1.0 
 */
public class OAaddAttendanceDao implements IOAaddAttendanceDao {
    
	private static Logger logger = Logger.getLogger(OAaddAttendanceDao.class);
    
    private static String QUERY_OA_ADDATTENDANCE_INFO ="" +
    		" select t.processinstid, "+
    		"   t.empid, "+
    		"   t.name, "+
    	    "   t.remark, "+
    	    "   t.area, "+
    	    "   t.adddept, "+
    	    "   t.adddate, "+
    	    "   t.addtype, "+
    	    "   t.reference, "+
    	    "   t.reason, "+
    	    "   t.addman, "+
    	    "   (select ede.dictname from eos_dict_entry ede "+
    	    "   where ede.dicttypeid = 'DIP_ENTERPRISEPERSONNEL' "+
    	    "     and ede.dictid = t.area) areaname "+
    	    " from oa_addattendance t where t.processinstid = ? ";

    @Override
    public OAaddAttendance getAddAttendanceInfo(String processinstid) {
		String sql = QUERY_OA_ADDATTENDANCE_INFO;
		Object[] params = {processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		OAaddAttendance attendance = new OAaddAttendance();
		try {
		    rs = ConnectionManager.query(conn, sql, params);
		    List resultList = ConvertPojoUtil.resultSetToList(rs);
		    if (resultList.size() > 0) {
			attendance = (OAaddAttendance) ConvertPojoUtil.mapToBean(new OAaddAttendance(),
				(Map)resultList.get(0));
		    }
		} catch (SQLException e) {
		    logger.error("ERROR:[OAaddAttendanceDao] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[OAaddAttendanceDao] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		return attendance;
    }
}

