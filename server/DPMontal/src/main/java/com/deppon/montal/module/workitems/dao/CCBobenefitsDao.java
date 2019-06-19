
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.CCBobenefits;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: CCBobenefitsDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-6 上午9:42:16 
 * @version V1.0 
 */
public class CCBobenefitsDao implements ICCBobenefitsDao {
	private static Logger logger = Logger.getLogger(CCBobenefitsDao.class);
	private static final String QUERY_CCBOBENEFITS_INFO= " SELECT CC.*,"+
	         "(SELECT W.WORKITEMNAME"+
	         " FROM WFWORKITEM W"+
	        " WHERE (W.CURRENTSTATE = '10' OR W.CURRENTSTATE = '4')"+
	           "AND W.PROCESSINSTID = CC.PROCESSINSTID) CURRENTNODE　FROM CC_BOBENEFITS CC WHERE CC.PROCESSINSTID =?";
	@Override
	public CCBobenefits getCCBobenefitsByWorkId(String workId) {
		Object[] params = {workId};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		CCBobenefits ccbobenefits = new CCBobenefits();
		try {
			rs = ConnectionManager.query(conn, QUERY_CCBOBENEFITS_INFO, params);
			List resultSet = ConvertPojoUtil.resultSetToList(rs);
			if(resultSet.size()>0){
				ccbobenefits = (CCBobenefits)ConvertPojoUtil.mapToBean(new CCBobenefits(), (Map)resultSet.get(0));
			}
		} catch (SQLException e) {
		    logger.error("ERROR:[CCBobenefitsDao] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[CCBobenefitsDao] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		return ccbobenefits;
	}

}

