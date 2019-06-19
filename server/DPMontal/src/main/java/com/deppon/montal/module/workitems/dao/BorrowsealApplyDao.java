
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OABorrowsealApply;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: BorrowsealApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (获取借章申请数据操作) 
 * @author 廖建雄 
 * @date 2013-6-26 下午2:02:47 
 * @version V1.0 
 */
public class BorrowsealApplyDao implements IBorrowsealApplyDao {
    private static Logger logger = Logger.getLogger(BorrowsealApplyDao.class);
    private static String QUERY_OA_BORROWSEALAPPLY_INFO ="" +
    		"SELECT OA.*, " +
    		"(SELECT DIC.DICTNAME FROM EOS_DICT_ENTRY DIC WHERE DIC.DICTTYPEID ='DIP_DIVISION_NEW' " +
    		"AND DIC.DICTID = OA.AREA)AREA1, " +
    		"(SELECT DIC.DICTNAME FROM EOS_DICT_ENTRY DIC WHERE DIC.DICTTYPEID ='DIP_ENTERPRISE_AREA' " +
    		"AND DIC.DICTID = OA.AREA)AREA2 " +
    		"FROM OA_BORROWSEALAPPLY OA WHERE OA.PROCESSINSTID = ?";
    @Override
    public OABorrowsealApply getBorrowsealApply(String processinstid) {
	String sql = QUERY_OA_BORROWSEALAPPLY_INFO;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	OABorrowsealApply boApply = new OABorrowsealApply();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    //解析rs 转换为LIST
	    List rsList = ConvertPojoUtil.resultSetToList(rs);
	    
	    //映射实体类
	    for(Object obj : rsList){
		boApply = (OABorrowsealApply) ConvertPojoUtil.mapToBean(
			new OABorrowsealApply(), (Map)obj);
	    }
	} catch (SQLException e) {
	    logger.error("ERROR:[BorrowsealApplyDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[BorrowsealApplyDao] rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return boApply;

    }

}

