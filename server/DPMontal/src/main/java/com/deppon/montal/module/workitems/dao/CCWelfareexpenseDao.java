
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.CCOnbusiness;
import com.deppon.montal.model.CCWelfareexpense;
import com.deppon.montal.model.CCwelfareexpenseEntry;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: CCWelfareexpenseDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(福利费用工作流数据操作) 
 * @author 廖建雄 
 * @date 2013-4-27 上午9:59:06 
 * @version V1.0 
 */
public class CCWelfareexpenseDao implements ICCWelfareexpenseDao {
    
    private static Logger logger = Logger.getLogger(CCWelfareexpenseDao.class);
    
    /***获取福利费用工作流明细*/
    private static String QUERY_CC_WELFAREEXPENSE_INFO ="" +
    		"SELECT CC.*," +
    		"(SELECT W.WORKITEMNAME FROM WFWORKITEM W WHERE (W.CURRENTSTATE = '10' OR W.CURRENTSTATE = '4') " +
    		"AND W.PROCESSINSTID = CC.PROCESSINSTID) CURRENTNODE　" +
    		"FROM CC_WELFAREEXPENSE CC WHERE CC.PROCESSINSTID =?";
    
    /***获取福利费用工作流详细信息*/
    private static String QUERY_CC_WELFAREEXPENSEENTRY_INFO ="" +
	    "SELECT *　FROM CC_WELFAREEXPENSEENTRY WHERE PROCESSINSTID =?";
    
    @Override
    public CCWelfareexpense getCCWelfareexpense(String processinstid) {
	String sql = QUERY_CC_WELFAREEXPENSE_INFO;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	CCWelfareexpense welfareexpense = new CCWelfareexpense();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    if (resultList.size() > 0) {
		welfareexpense = (CCWelfareexpense) ConvertPojoUtil.mapToBean(new CCWelfareexpense(),
			(Map)resultList.get(0));
	    }
	} catch (SQLException e) {
	    logger.error("ERROR:[CCWelfareexpenseDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[CCWelfareexpenseDao] rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return welfareexpense;
    }

    @Override
    public List<CCwelfareexpenseEntry> getCCwelfareexpenseEntry(String processinstid) {
	String sql = QUERY_CC_WELFAREEXPENSEENTRY_INFO;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	CCwelfareexpenseEntry welfareexpenseeEntry = new CCwelfareexpenseEntry();
	List<CCwelfareexpenseEntry> list = new ArrayList<CCwelfareexpenseEntry>();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    if (resultList.size() > 0) {
	    	for (Object temp : resultList) {
	    		welfareexpenseeEntry = (CCwelfareexpenseEntry) ConvertPojoUtil.mapToBean(new CCwelfareexpenseEntry(),
	    				(Map)temp);
	    		list.add(welfareexpenseeEntry);
			}
	    }
	} catch (SQLException e) {
	    logger.error("ERROR:[CCWelfareexpenseDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[CCWelfareexpenseDao] rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return list;
    }

}

