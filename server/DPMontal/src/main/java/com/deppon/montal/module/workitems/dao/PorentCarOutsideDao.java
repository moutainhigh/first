
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.PorentCarOutside;
import com.deppon.montal.model.PorentCarOutsideEntry;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
/** 
 * @Title: PorentCarOutsideDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (外请车数据操作) 
 * @author 廖建雄 
 * @date 2013-4-15 下午2:10:42 
 * @version V1.0 
 */
public class PorentCarOutsideDao implements IPorentCarOutsideDao {
    private static Logger logger = Logger.getLogger(PorentCarOutsideDao.class);
    private static String QUERY_PORENTCAROUTSIDE_INFO = "" +
    		"SELECT CP.*," +
    		"(SELECT W.WORKITEMNAME FROM WFWORKITEM W WHERE (W.CURRENTSTATE = '10' OR  W.CURRENTSTATE = '4') AND W.PROCESSINSTID = CP.PROCESSINSTID)CURRENTNODE" +
    		" FROM CC_PORENTCAROUTSIDE CP WHERE PROCESSINSTID = ?";
    private static String QUERY_PORENTCAROUTSIDEENTRY_INFO = "" +
    		"SELECT *　FROM CC_PORENTCAROUTSIDEENTRY WHERE PROCESSINSTID = ?";
    public PorentCarOutside getCarOutsideInfo(String processinstid){
	String sql = QUERY_PORENTCAROUTSIDE_INFO;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	PorentCarOutside carOutside = new PorentCarOutside();
	ResultSet rs = null;
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    if (resultList.size() > 0) {
		carOutside =(PorentCarOutside)ConvertPojoUtil.mapToBean(new PorentCarOutside(),
			(Map)resultList.get(0));
	    }
	}catch (SQLException e) {
	    logger.error("getCarOutsideInfo SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("getCarOutsideInfo rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return carOutside;
    }
    public List<PorentCarOutsideEntry> getCarOutsideEntry(String processinstid){
	String sql = QUERY_PORENTCAROUTSIDEENTRY_INFO;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	List<PorentCarOutsideEntry> carOutsideEntries = new ArrayList<PorentCarOutsideEntry>();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    for (Object object : resultList) {
    		PorentCarOutsideEntry carOutsideEntry =(PorentCarOutsideEntry)ConvertPojoUtil.mapToBean(new PorentCarOutsideEntry(),
    			(Map)object);
    		carOutsideEntries.add(carOutsideEntry);
	    }
	}catch (SQLException e) {
	    logger.error("getCarOutsideEntrySQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("getCarOutsideEntry RS转换为List失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return carOutsideEntries;
    }
}

