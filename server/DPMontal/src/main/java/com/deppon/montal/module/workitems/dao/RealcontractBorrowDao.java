
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
   
import com.deppon.montal.model.OARealcontractBorrow;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
/** 
 * @Title: RealcontractBorrowDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(实体合同借阅数据操作) 
 * @author 廖建雄 
 * @date 2013-5-14 上午9:12:49 
 * @version V1.0 
 */
public class RealcontractBorrowDao implements IRealcontractBorrowDao {
    private static Logger logger = Logger.getLogger(RealcontractBorrowDao.class);
    
    private static String GET_OA_REALCONTRACTBORROW_INFO= "" +
    		"SELECT PROCESSINSTID, NAME,EMPCODE,CONTRACTNUM,CUSTOMERNAME,SIGNDEPARTMENT," +
    		"CONTRACTTYPE,CONTRACTDENSE,BORROWDAYS,STARTDATE,ENDDATE,RESON," +
    		"(SELECT DICT.DICTNAME FROM EOS_DICT_ENTRY DICT WHERE DICT.DICTTYPEID='DIP_DIVISION_NEW' AND DICT.DICTID = AREA)AREA" +
    		" FROM OA_REALCONTRACTBORROW WHERE PROCESSINSTID = ?";
    
    public OARealcontractBorrow getOARealcontractBorrowInfo(String processinstid){
	String sql = GET_OA_REALCONTRACTBORROW_INFO;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	OARealcontractBorrow borrow = new OARealcontractBorrow();
	
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    for (Object object : resultList) {
		borrow = (OARealcontractBorrow) ConvertPojoUtil.mapToBean(
			new OARealcontractBorrow(), (Map) object);
	    }
	} catch (SQLException e) {
	    logger.error("ERROR:[RealcontractBorrowDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[RealcontractBorrowDao] rs转换为List失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn,null, rs);
	}
	return borrow;
    }
}

