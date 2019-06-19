
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OADismissal;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: DismissalDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (免职申请数据操作) 
 * @author 廖建雄 
 * @date 2013-6-26 下午2:02:47 
 * @version V1.0 
 */
public class DismissalDao implements IDismissalDao {
    private static Logger logger = Logger.getLogger(DismissalDao.class);
    private static String QUERY_OA_DISMISSAL_INFO ="" +
    		"SELECT DIS.PROCESSINSTID,DIS.NAME, DIS.MANNAME, DIS.MANDEPT, DIS.REMARK," +
    		"(SELECT DOE.DICTNAME FROM EOS_DICT_ENTRY DOE WHERE DOE.DICTTYPEID ='DIP_DISMISSALTYPE_NEW' " +
    		"AND DOE.DICTID = DIS.DISMISSALTYPE)DISMISSALTYPE," +
    		"(SELECT DOE.DICTNAME FROM EOS_DICT_ENTRY DOE WHERE DOE.DICTTYPEID ='DIP_DISMISSALPOST_NEW' " +
    		"AND DOE.DICTID = DIS.MANPOST)MANPOST," +
    		"(SELECT DOE.DICTNAME FROM EOS_DICT_ENTRY DOE WHERE DOE.DICTTYPEID ='DIP_ENTERPRISEPERSONNEL' " +
    		"AND DOE.DICTID = DIS.PERSONNEL)PERSONNEL " +
    		"FROM OA_DISMISSAL DIS WHERE DIS.PROCESSINSTID = ?";
    @Override
    public OADismissal getDismissal(String processinstid) {
	String sql = QUERY_OA_DISMISSAL_INFO;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	OADismissal dismissal = new OADismissal();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    //解析rs 转换为LIST
	    List rsList = ConvertPojoUtil.resultSetToList(rs);
	    
	    //映射实体类
	    for(Object obj : rsList){
		dismissal = (OADismissal) ConvertPojoUtil.mapToBean(
			new OADismissal(), (Map)obj);
	    }
	} catch (SQLException e) {
	    logger.error("ERROR:[DismissalDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[DismissalDao] rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return dismissal;

    }

}

