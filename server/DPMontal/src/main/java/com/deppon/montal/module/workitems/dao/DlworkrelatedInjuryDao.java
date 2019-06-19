
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.CCDlworkrelatedInjury;
import com.deppon.montal.model.CCDlworkrelatedInjuryEntry;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: DlworkrelatedInjuryDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (工伤医疗费用报销申请数据操作) 
 * @author 廖建雄 
 * @date 2013-6-6 上午11:44:51 
 * @version V1.0 
 */
public class DlworkrelatedInjuryDao implements IDlworkrelatedInjuryDao {
    
    private static Logger logger = Logger.getLogger(DlworkrelatedInjuryDao.class);
    private static String QUERY_CC_DLWORKRELATEDINJURY_INFO ="" +
    		"SELECT CC.*,(SELECT W.WORKITEMNAME FROM WFWORKITEM W WHERE (W.CURRENTSTATE = '10' OR  W.CURRENTSTATE = '4') AND W.PROCESSINSTID = CC.PROCESSINSTID)CURRENTNODE" +
    		" FROM CC_DLWORKRELATEDINJURY CC  WHERE CC.PROCESSINSTID =? ";
    private static String QUERY_CC_DLWORKRELATEDINJURYENTRY_INFO ="" +
	    "SELECT * FROM CC_DLWORKRELATEDINJURYENTRY WHERE PROCESSINSTID = ?";

    @Override
    public CCDlworkrelatedInjury getiInjury(String processinstid) {
	
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	String sql = QUERY_CC_DLWORKRELATEDINJURY_INFO;
	CCDlworkrelatedInjury injury = new CCDlworkrelatedInjury();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    for (Object object : resultList) {
		injury = (CCDlworkrelatedInjury)ConvertPojoUtil.mapToBean(
			new CCDlworkrelatedInjury(),(Map)object);
	    }
	    
	} catch (SQLException e) {
	    logger.error("ERROR:[DlworkrelatedInjuryDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[DlworkrelatedInjuryDao] rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return injury;
	
    }

    @Override
    public List<CCDlworkrelatedInjuryEntry> getinInjuryEntry(String processinstid) {
	
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	String sql = QUERY_CC_DLWORKRELATEDINJURYENTRY_INFO;
	List<CCDlworkrelatedInjuryEntry> injuryEntryList = new ArrayList<CCDlworkrelatedInjuryEntry>();
	 try {
	     rs = ConnectionManager.query(conn, sql, params);
	     List resultList = ConvertPojoUtil.resultSetToList(rs);
	     for (Object object : resultList) {
		injuryEntryList.add((CCDlworkrelatedInjuryEntry)ConvertPojoUtil.mapToBean(
			new CCDlworkrelatedInjuryEntry(),(Map)object));
	     }
	    
	} catch (SQLException e) {
	    logger.error("ERROR:[DlworkrelatedInjuryDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[DlworkrelatedInjuryDao] rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return injuryEntryList;
	
    }

}

