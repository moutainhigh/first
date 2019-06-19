
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OAAssessreduceApply;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: AssessreduceApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(考核特批减免申请工作流数据处理) 
 * @author 廖建雄 
 * @date 2013-7-16 下午3:23:50 
 * @version V1.0 
 */
public class AssessreduceApplyDao implements IAssessreduceApplyDao {
    
    private static Logger logger = Logger.getLogger(AssessreduceApplyDao.class);
    private static String QUERY_OA_ASSESSREDUCEAPPLY_INFO = "" +
    		"SELECT * FROM OA_ASSESSREDUCEAPPLY " +
    		"WHERE PROCESSINSTID = ? ";

    @Override
    public OAAssessreduceApply getAssessreduceApply(String processinstid) {
	String sql = QUERY_OA_ASSESSREDUCEAPPLY_INFO;
	Object[] params = {processinstid};
	OAAssessreduceApply info = new OAAssessreduceApply();
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
	    info = (OAAssessreduceApply) ConvertPojoUtil.mapToBean(
		    new OAAssessreduceApply(), (Map)list.get(0));
	    
	} catch (SQLException e) {
	    logger.error("ERROR:[AssessreduceApplyDao] SQL Query  Failure!" + 
		    e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[AssessreduceApplyDao] ResultSet To List Failure!" +
		    e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return info;
    }

}

