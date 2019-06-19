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

import com.deppon.montal.model.CCOnbusiness;
import com.deppon.montal.model.OASystempowerApply;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;

/** 
* @Title: IOASystempowerApplyDao.java
* @Description:(系统权限申请数据操作类) 
* @author yin 
* @date 2013-5-14 上午9:19:35 
* @version V1.0 
*/
public class OASystempowerApplyDao implements IOASystempowerApplyDao {

	private static Logger logger = Logger.getLogger(OASystempowerApplyDao.class);
	
	public static final String QUERY_OASYSTEMPOWERAPPLY_SQL = ""+
			 " select processinstid,empid,applyname,empdept,empposition,s.beforeposition, "+
	         "      powertype, username, userid, entrydate, userposition,s.beforedept,  "+
	         "      endtime, whyapply,s.applytype,s.fixedassetcode,s.iscertification,s.subcom, "+
	         "     (select w.activitydefid from wfworkitem w where (w.currentstate = '10' or  "+
	         "     w.currentstate = '4') and w.processinstid = s.processinstid) currentnode,  "+
	         "     (select  a.relatedatavchr from dipoa.wfprocessinst a where a.processinstid = s.processinstid) wfrelatedata  "+
	         " from oa_oasystempowerapply s  "+
	         " where s.processinstid = ? ";
	
	@Override
	public OASystempowerApply getOASystempowerApply(String processinstid) {
		Object[] params = {processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		OASystempowerApply apply = new OASystempowerApply();
		try {
		    rs = ConnectionManager.query(conn, QUERY_OASYSTEMPOWERAPPLY_SQL, params);
		    List resultList = ConvertPojoUtil.resultSetToList(rs);
		    if (resultList.size() > 0) {
		    	apply = (OASystempowerApply) ConvertPojoUtil.mapToBean(new OASystempowerApply(),
				(Map)resultList.get(0));
		    }
		} catch (SQLException e) {
		    logger.error("ERROR:[OASystempowerApplyDao] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[OASystempowerApplyDao] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		return apply;
	}

}
