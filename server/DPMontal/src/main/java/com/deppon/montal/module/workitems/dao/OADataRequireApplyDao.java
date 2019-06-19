
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OADataRequireApply;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: DisCountApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(数据需求审批流程数据处理) 
 * @author 廖建雄 
 * @date 2013-7-16 下午3:23:50 
 * @version V1.0 
 */
public class OADataRequireApplyDao implements IOADataRequireApplyDao {
    
    private static Logger logger = Logger.getLogger(OADataRequireApplyDao.class);
    private static String QUERY_OA_DATE_REQUIRE_INFO = "" +
    		"SELECT OA.*, " +
    		"(" +
    		" SELECT D.DICTNAME FROM EOS_DICT_ENTRY D " +
    		"  WHERE D.DICTTYPEID = 'DIP_IFVALID' AND D.DICTID = OA.ISPROVIDE" +
    		")ISPROVIDE " +
    		"FROM SJXU OA " +
    		"WHERE OA.PROCESSINSTID = ? ";

    @Override
    public OADataRequireApply getDataRequireApply(String processinstid) {
	String sql = QUERY_OA_DATE_REQUIRE_INFO;
	Object[] params = {processinstid};
	OADataRequireApply info = new OADataRequireApply();
	ResultSet rs = null;
	Connection conn = ConnectionManager.getConnection();
	
	try {
	    //查询数据库
	    rs = ConnectionManager.query(conn, sql, params);
	    //将rs 转换为list
	    List list = ConvertPojoUtil.resultSetToList(rs); 
	    
	    //判空返回
	    if (list.size() == 0) 
		return info;
	    
	    //映射pojo
	    info = (OADataRequireApply) ConvertPojoUtil.mapToBean(
		    new OADataRequireApply(), (Map)list.get(0));
	    
	} catch (SQLException e) {
	    logger.error("ERROR:[OADataRequireApplyDao] SQL Query  Failure!" + 
		    e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[OADataRequireApplyDao] ResultSet To List Failure!" +
		    e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return info;
    }

}

