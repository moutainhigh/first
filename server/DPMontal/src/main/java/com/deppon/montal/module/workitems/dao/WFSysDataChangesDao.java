
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.model.OmEmployee;
import com.deppon.montal.model.WFSysDataChanges;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: WFSysDataChangesDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 廖建雄 
 * @date 2013-4-11 上午9:20:30 
 * @version V1.0 
 */
public class WFSysDataChangesDao implements IWFSysDataChangesDao {
    
    private static Logger logger = Logger.getLogger(WFSysDataChangesDao.class);
    
    /**获取系统变更申请明细*************************************/
    private static String  QUERY_SYS_DATACHANGES= "" +
    		"SELECT S.PROCESSINSTID, " +
    		"S.APPLYNAME," +
    		"S.MESSAGE," +
    		"S.PROCESS," +
    		"S.REASON," +
    		"S.EMPID," +
    		"(SELECT DOE.DICTNAME FROM EOS_DICT_ENTRY DOE WHERE DOE.DICTTYPEID LIKE 'DIP_IFVALID' AND DOE.DICTID LIKE S.ISFINANCIAL)ISFINANCIAL," +
    		"(SELECT DOE.DICTNAME FROM EOS_DICT_ENTRY DOE WHERE DOE.DICTTYPEID LIKE'DIP_SYSTEM_TYPE' AND DOE.DICTID LIKE S.SYSTEMID)SYSTEMID," +
    		"(SELECT W.WORKITEMNAME FROM WFWORKITEM W WHERE (W.CURRENTSTATE = '10' OR  W.CURRENTSTATE = '4') AND W.PROCESSINSTID = S.PROCESSINSTID)CURRENTNODE" +
    		" FROM SYSDATACHANGE S WHERE S.PROCESSINSTID = ?";
    
    public WFSysDataChanges getSysDataChangesDetail(String processinstid){
	String sql = QUERY_SYS_DATACHANGES;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	WFSysDataChanges sysDataChanges = new WFSysDataChanges();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List  resultList = ConvertPojoUtil.resultSetToList(rs);
	    if(resultList.size() > 0){
        	    sysDataChanges = (WFSysDataChanges)ConvertPojoUtil.mapToBean(new WFSysDataChanges(), 
        		    (Map) resultList.get(0));
	    }
	} catch (SQLException e) {
	    logger.error("SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
   	return sysDataChanges;
    }
}

