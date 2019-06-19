
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OAOvertimeApply;
import com.deppon.montal.model.OASystempowerApply;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: OverTimeApply.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-20 下午3:44:44 
 * @version V1.0 
 */
public class OAOverTimeApplyDao implements IOAOverTimeApplyDao {
	private static Logger logger = Logger.getLogger(OAOverTimeApplyDao.class);
	private static final String QUERY_INFO = "select t.processinstid, t.name, t.empid, t.userid, t.applytype,e.dictname PERSONNELDEPT," +
			"t.otapplyno,t.workdays,t.holidays,t.nbegindate," +
			"t.nenddate,t.nightdays,t.nwitness,t.ottype," +
			"t.begindate,t.enddate,t.reason,t.dept,t.position " +
			"from oa_overtimeapply t, eos_dict_entry e " +
			" where 1 = 1 " +
			" and e.dicttypeid = 'DIP_COMPENSATION'" +
			" and t.personneldept = e.dictid" +
			" and t.processinstid = ?";
	@Override
	public OAOvertimeApply getOAOverTimeApply(String workId) {
		Object[] params = new Object[]{workId};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		OAOvertimeApply overtime = null;
		try {
			rs = ConnectionManager.query(conn, QUERY_INFO, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if (resultList.size() > 0) {
				overtime = (OAOvertimeApply) ConvertPojoUtil.mapToBean(new OAOvertimeApply(),(Map)resultList.get(0));
		    }
		} catch (SQLException e) {
		    logger.error("ERROR:[OAOverTimeApplyDao] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[OAOverTimeApplyDao] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		return overtime;
	}

}

