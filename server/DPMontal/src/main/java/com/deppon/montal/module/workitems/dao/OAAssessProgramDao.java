
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OAAssessApply;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: OAAssessProgramDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-21 上午10:16:25 
 * @version V1.0 
 */
public class OAAssessProgramDao implements IOAAssessProgramDao {
	private static Logger logger = Logger.getLogger(OAAssessProgramDao.class);
	private static String QUERY_INFO = "select * from dipoa.oa_assessapply a where 1 = 1  and a.processinstid =?";

	@Override
	public OAAssessApply getOAAssessApply(String workId) {
		Object[] params = new Object[]{workId};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		OAAssessApply oaassessapply = null;
		try {
			rs = ConnectionManager.query(conn, QUERY_INFO, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				oaassessapply = (OAAssessApply)ConvertPojoUtil.mapToBean(new OAAssessApply(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
		    logger.error("ERROR:[OAAssessProgramDao] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[OAAssessProgramDao] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		return oaassessapply;
	}

}

