
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.RecommendExcellentEmp;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: BorrowsealApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (优秀人才推荐数据操作) 
 * @author 廖建雄 
 * @date 2013-6-26 下午2:02:47 
 * @version V1.0 
 */
public class RecommendExcellentEmpDao implements IRecommendExcellentEmpDao {
    private static Logger logger = Logger.getLogger(RecommendExcellentEmpDao.class);
    private static String QUERY_RECOMMENDE_XCELLENT_STAFF_INFO ="" +
    		"SELECT * FROM RECOMMENDEXCELLENTEMP WHERE PROCESSINSTID = ?";
    @Override
    public RecommendExcellentEmp getExcellentEmp(String processinstid) {
	String sql = QUERY_RECOMMENDE_XCELLENT_STAFF_INFO;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	RecommendExcellentEmp excellentEmp = new RecommendExcellentEmp();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    //解析rs 转换为LIST
	    List rsList = ConvertPojoUtil.resultSetToList(rs);
	    
	    //映射实体类
	    for(Object obj : rsList){
		excellentEmp = (RecommendExcellentEmp) ConvertPojoUtil.mapToBean(
			new RecommendExcellentEmp(), (Map)obj);
	    }
	} catch (SQLException e) {
	    logger.error("ERROR:[RecommendExcellentEmpDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[RecommendExcellentEmpDao] rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return excellentEmp;

    }

}

