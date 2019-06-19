
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OADataProvideApply;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: DataProvideApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (数据提供审批数据操作) 
 * @author 廖建雄 
 * @date 2013-5-28 上午9:18:56 
 * @version V1.0 
 */
public class DataProvideApplyDao implements IDataProvideApplyDao {
    private static Logger logger = Logger.getLogger(DataProvideApplyDao.class);
    private static String QUERY_OA_DATAPROVIDEAPPLY_INFO ="" +
	    	"SELECT OA.PROCESSINSTID,OA.EMPID,OA.NAME,OA.TARGET," +
		"(SELECT DOE.DICTNAME FROM EOS_DICT_ENTRY DOE WHERE DOE.DICTTYPEID ='DIP_DIVISION_NEW' AND DOE.DICTID = OA.AREA)AREA," +
		"OA.WHYAPPLY," +
		"(SELECT W.WORKITEMNAME FROM WFWORKITEM W WHERE (W.CURRENTSTATE = '10' OR  W.CURRENTSTATE = '4') AND W.PROCESSINSTID = OA.PROCESSINSTID)CURRENTNODE" +
		" FROM OA_DATAPROVIDEAPPLY OA" +
		" WHERE OA.PROCESSINSTID = ?";
    @Override
    public OADataProvideApply getOADataProvideApply(String processinstid) {
	String sql = QUERY_OA_DATAPROVIDEAPPLY_INFO;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	OADataProvideApply applyInfo = new OADataProvideApply();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    for (Object object : resultList) {
		applyInfo = (OADataProvideApply) ConvertPojoUtil.mapToBean(
			new OADataProvideApply(), (Map)object);
	    }
	} catch (SQLException e) {
	    logger.error("ERROR:[DataProvideApplyDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[DataProvideApplyDao] rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	
	return applyInfo;
    }

}

