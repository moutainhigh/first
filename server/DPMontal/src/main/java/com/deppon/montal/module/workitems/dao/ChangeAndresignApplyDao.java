
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OAChangeAndresignApply;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: ChangeAndresignApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (异动调动申请数据操作) 
 * @author 廖建雄 
 * @date 2013-5-28 上午9:35:58 
 * @version V1.0 
 */
public class ChangeAndresignApplyDao implements IChangeAndresignApplyDao {
    private static Logger logger = Logger.getLogger(DataProvideApplyDao.class);
    private static String QUERY_OA_CHANGEADNRESIGNAPPLY_INFO ="" +
    		"SELECT OA.PROCESSINSTID,OA.USERID,OA.NAME,OA.APPLYTYPE,JOBLEVEL,OA.APPLYTYPE," +
    		"(SELECT DOE.DICTNAME FROM EOS_DICT_ENTRY DOE WHERE DOE.DICTTYPEID ='OA_PERSONAL' AND DOE.DICTID = OA.AREAPERSONNELDEPT)AREAPERSONNELDEPT," +
    		"OA.BEFOREDEPT,OA.BEFOREPOSITION,OA.AFTERDEPT,OA.AFTERPOSITION,OA.ADDPERSONNO," +
    		"OA.APPLYTYPE,OA.BACKORIGINNO,OA.ISVARADDRESS,OA.ISUSEPHONE,OA.PHONENUMBER," +
    		"OA.ISTELHAND,OA.AFTERUSER,OA.MONEY,OA.REASON,OA.DEPTNATURE,OA.ISMANAGERTRAIN" +
    		" FROM OA_CHANGEANDRESIGNAPPLY OA" +
    		" WHERE OA.PROCESSINSTID = ?";
    @Override
    public OAChangeAndresignApply getOAChaApply(String processinstid) {
	String sql = QUERY_OA_CHANGEADNRESIGNAPPLY_INFO;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	OAChangeAndresignApply applyInfo = new OAChangeAndresignApply();
	ResultSet rs = null;
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    for (Object object : resultList) {
		applyInfo = (OAChangeAndresignApply) ConvertPojoUtil.mapToBean(
			new OAChangeAndresignApply(), (Map) object);
	    }
	} catch (SQLException e) {
	    logger.error("ERROR:[ChangeAndresignApplyDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[ChangeAndresignApplyDao] rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return applyInfo;
    }

}

