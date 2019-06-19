
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OAConverterApply;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: OATurnFormalDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-24 下午5:01:19 
 * @version V1.0 
 */
public class OATurnFormalDao implements IOATurnForMalDao {
	private static Logger logger = Logger.getLogger(OATurnFormalDao.class);
	private static String QUERY_INFO = " SELECT CC.*," +
			"(SELECT W.WORKITEMNAME " +
			"FROM dipoa.WFWORKITEM W " +
			"WHERE (W.CURRENTSTATE = 10 OR W.CURRENTSTATE = 4) " +
			"AND W.PROCESSINSTID = CC.PROCESSINSTID) CURRENTNODE　" +
			"FROM dipoa.oa_converterapply CC " +
			"WHERE CC.PROCESSINSTID =?";
	private static String QUERY_FLOWTYPE = "select  a.relatedatavchr from dipoa.wfprocessinst a where a.processinstid = ?";
	@Override
	public OAConverterApply getOAConverterApply(String workId) {
		Object[] params = new Object[]{workId};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		OAConverterApply oaConverterApply = null;
		String sql = QUERY_INFO;
		try {
			rs = ConnectionManager.query(conn, sql, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				oaConverterApply = (OAConverterApply)ConvertPojoUtil.mapToBean(new OAConverterApply(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
		    logger.error("ERROR:[OATurnFormalDao] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[OATurnFormalDao] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		return oaConverterApply;
	}
	@Override
	public OAConverterApply getOAConverterFlowtype(
			OAConverterApply oaconverterapply) {
		OAConverterApply temp = oaconverterapply;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(QUERY_FLOWTYPE);
			ps.setObject(1, oaconverterapply.getProcessinstid());
			rs = ps.executeQuery();
			if(rs.next()){
				String relatedatavchr = rs.getString("relatedatavchr");
				temp.setFlowtype(relatedatavchr);
			}
		} catch (SQLException e) {
		    logger.error("ERROR:[OATurnFormalDao] SQL语句出错！" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, ps, rs);
		}
		return temp;
	}
}

