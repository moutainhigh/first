
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.CCOnbusiness;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: CCOnbusinessDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (出差申请工作流数据操作) 
 * @author 廖建雄 
 * @date 2013-4-27 上午10:00:54 
 * @version V1.0 
 */
public class CCOnbusinessDao implements ICCOnbusinessDao {
    private static Logger logger = Logger.getLogger(CCOnbusinessDao.class);
    private static String QUERY_CC_ONBUSINESS_INFO = "" +
    		"SELECT * FROM CC_ONBUSINESS WHERE PROCESSINSTID = ?";

    @Override
    public CCOnbusiness getCConOnbusiness(String processinstid) {
	String sql = QUERY_CC_ONBUSINESS_INFO;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	CCOnbusiness onbusiness = new CCOnbusiness();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    if (resultList.size() > 0) {
		onbusiness = (CCOnbusiness) ConvertPojoUtil.mapToBean(new CCOnbusiness(),
			(Map)resultList.get(0));
	    }
	} catch (SQLException e) {
	    logger.error("ERROR:[CCOnbusinessDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[CCOnbusinessDao] rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return onbusiness;
    }
}

