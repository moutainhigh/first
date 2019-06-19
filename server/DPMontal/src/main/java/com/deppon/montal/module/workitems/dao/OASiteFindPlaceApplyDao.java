
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OASiteFindPlaceApply;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;




   /** 
   * @ClassName: OASiteFindPlaceApplyDao 
   * @Description:(场地找点数据操作) 
   * @author 廖建雄 
   * @date 2013-8-26 上午8:54:40 
   * 
   */
public class OASiteFindPlaceApplyDao implements IOASiteFindPlaceApplyDao {
    private static Logger logger = Logger.getLogger(OASiteFindPlaceApplyDao.class);
    private static String QUERY_OA_SITEFINDPLACEAPPLY_INFO ="" +
    		"SELECT OA.*," +
    		"(" +
    		"SELECT D.DICTNAME FROM EOS_DICT_ENTRY D " +
    		"  WHERE D.DICTTYPEID = 'DIP_DIVISION_NEW' AND D.DICTID = OA.AREA" +
    		")AREA " +
    		"FROM OA_SITEFINDPLACEAPPLY OA WHERE OA.PROCESSINSTID = ?";
    @Override
    public OASiteFindPlaceApply getSiteFindPlaceApply(String processinstid) {
	String sql = QUERY_OA_SITEFINDPLACEAPPLY_INFO;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	OASiteFindPlaceApply licenseLend = new OASiteFindPlaceApply();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    //解析rs 转换为LIST
	    List rsList = ConvertPojoUtil.resultSetToList(rs);
	    
	    //映射实体类
	    for(Object obj : rsList){
		licenseLend = (OASiteFindPlaceApply) ConvertPojoUtil.mapToBean(
			new OASiteFindPlaceApply(), (Map)obj);
	    }
	} catch (SQLException e) {
	    logger.error("ERROR:[OASiteFindPlaceApplyDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[OASiteFindPlaceApplyDao] rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return licenseLend;

    }
}

