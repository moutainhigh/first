
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.CCBoeveryDay;
import com.deppon.montal.model.CCEntertainmentFees;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: EntertainmentFeesDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 廖建雄 
 * @date 2013-6-6 上午11:43:18 
 * @version V1.0 
 */
public class EntertainmentFeesDao implements IEntertainmentFeesDao {
    private static Logger logger = Logger.getLogger(EntertainmentFeesDao.class);
    private static String QUERY_CC_BOENTERTAINMENTFEES_INFO = "" +
    		"SELECT CC.*," +
    		"(SELECT W.WORKITEMNAME FROM WFWORKITEM W WHERE (W.CURRENTSTATE = '10' OR  W.CURRENTSTATE = '4') AND W.PROCESSINSTID = CC.PROCESSINSTID)CURRENTNODE" +
    		" FROM CC_BOENTERTAINMENTFEES CC WHERE CC.PROCESSINSTID =?";
    @Override
    public CCEntertainmentFees getFees(String processinstid) {
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	String sql = QUERY_CC_BOENTERTAINMENTFEES_INFO;
	CCEntertainmentFees fees = new  CCEntertainmentFees();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    for (Object object : resultList) {
		fees = (CCEntertainmentFees) ConvertPojoUtil.mapToBean(new CCEntertainmentFees(), 
			(Map)object);
	    }
	} catch (SQLException e) {
	    logger.error("ERROR:[EntertainmentFeesDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[EntertainmentFeesDao] rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return fees;
    }

}

