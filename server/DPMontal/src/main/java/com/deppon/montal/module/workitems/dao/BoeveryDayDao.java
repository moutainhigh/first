package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.CCBoeveryDay;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: BoeveryDayDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (日常（新）工作流数据操作) 
 * @author 廖建雄 
 * @date 2013-6-6 上午11:40:53 
 * @version V1.0 
 */
public class BoeveryDayDao implements IBoeveryDayDao {
    private static Logger logger = Logger.getLogger(BoeveryDayDao.class);
    
    private static String QUERY_CC_BOEVERYDAY_INFO = "" +
    		"SELECT CC.*," +
    		"(SELECT W.WORKITEMNAME FROM WFWORKITEM W WHERE (W.CURRENTSTATE = '10' OR  W.CURRENTSTATE = '4') AND W.PROCESSINSTID = CC.PROCESSINSTID)CURRENTNODE" +
    		" FROM CC_BOEVERYDAY CC WHERE CC.PROCESSINSTID = ?";
    
    @Override
    public CCBoeveryDay getBoeveryDayInfo(String processinstid) {
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	String sql = QUERY_CC_BOEVERYDAY_INFO;
	CCBoeveryDay boeveryDay = new CCBoeveryDay();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    for (Object object : resultList) {
		boeveryDay = (CCBoeveryDay) ConvertPojoUtil.mapToBean(new CCBoeveryDay(), 
			(Map)object);
	    }
	} catch (SQLException e) {
	    logger.error("ERROR:[BoeveryDayDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[BoeveryDayDao] rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return boeveryDay;
    }
}

