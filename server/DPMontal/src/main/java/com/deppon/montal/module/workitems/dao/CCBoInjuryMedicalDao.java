/**
 * 
 */
package com.deppon.montal.module.workitems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import com.deppon.montal.model.CCBoInjuryMedical;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;

/** 
* @Title: CCBoInjuryMedicalDao.java
* @Package com.deppon.montal.module.workitems.dao 
* @Description: (工伤医疗费用（新）工作流数据层) 
* @author yin 
* @date 2013-06-07 上午9:58:20 
* @version V1.0 
*/
public class CCBoInjuryMedicalDao implements ICCBoInjuryMedicalDao {

	private static Logger logger = Logger.getLogger(CCBoInjuryMedicalDao.class);
	
	public static final String QUERY_BOINJURYMEDICAL_PATH = " "+
	                 " select t.*, (SELECT W.WORKITEMNAME FROM WFWORKITEM W WHERE (W.CURRENTSTATE = '10' OR  W.CURRENTSTATE = '4') AND W.PROCESSINSTID = t.PROCESSINSTID) CURRENTNODE " +
	                 " from cc_boinjurymedical t where t.processinstid = ? ";
	
	/**
	 * 获取工伤医疗费用信息
	 * @param processinstid
	 * @return
	 */
	@Override
	public CCBoInjuryMedical getCCBoInjuryMedical(String processinstid) {
		Object[] params = {processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		CCBoInjuryMedical medical = new CCBoInjuryMedical();
		try {
			rs = ConnectionManager.query(conn, QUERY_BOINJURYMEDICAL_PATH, params);
			List resultSet = ConvertPojoUtil.resultSetToList(rs);
			if(resultSet.size()>0){
				medical = (CCBoInjuryMedical)ConvertPojoUtil.mapToBean(new CCBoInjuryMedical(), (Map)resultSet.get(0));
			}
		} catch (SQLException e) {
		    logger.error("ERROR:[CCBoInjuryMedicalDao] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[CCBoInjuryMedicalDao] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		return medical;
	}

}
