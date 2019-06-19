
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OARunfinance;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: RunfinanceDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 廖建雄 
 * @date 2013-6-20 下午3:02:14 
 * @version V1.0 
 */
public class RunfinanceDao implements IRunfinanceDao {

    private static Logger logger = Logger.getLogger(RunfinanceDao.class);
    private static String QUERY_OA_RUNFINANCE_INFO = "" +
    		"SELECT * FROM OA_RUNFINANCE WHERE PROCESSINSTID = ?";
    
    @Override
    public OARunfinance getRunfinance(String processinstid) {
	String sql = QUERY_OA_RUNFINANCE_INFO;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	
	OARunfinance info = new OARunfinance();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    //将rs转换为List
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    if(resultList.size() == 0) 
		return info;
	    //映射pojo
	    info = (OARunfinance) ConvertPojoUtil.mapToBean(new OARunfinance(), 
		    (Map)resultList.get(0));
	} catch (SQLException e) {
	    logger.error("ERROR:[RunfinanceDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[RunfinanceDao] rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	  return info;
    }
}

