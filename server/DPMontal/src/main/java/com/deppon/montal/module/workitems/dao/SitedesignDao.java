
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OASitedesign;
import com.deppon.montal.model.OAdisCountApply;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: SitedesignDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(场地设计申请工作流数据处理) 
 * @author 廖建雄 
 * @date 2013-7-16 下午3:23:50 
 * @version V1.0 
 */
public class SitedesignDao implements ISitedesignDao {
    
    private static Logger logger = Logger.getLogger(SitedesignDao.class);
    private static String QUERY_OA_SITEDESIGN_INFO = "" +
    		"SELECT OA.*, " +
    		"(" +
    		" SELECT D.DICTNAME FROM EOS_DICT_ENTRY D " +
    		"  WHERE D.DICTTYPEID = 'WFS_MATTER_TEAM' AND D.DICTID = OA.MATTER_TEAM" +
    		")MATTERTEAM " +
    		"FROM OA_SITEDESIGN OA " +
    		"WHERE OA.PROCESSINSTID = ? ";

    @Override
    public OASitedesign getSitedesign(String processinstid) {
	String sql = QUERY_OA_SITEDESIGN_INFO;
	Object[] params = {processinstid};
	OASitedesign info = new OASitedesign();
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
	    info = (OASitedesign) ConvertPojoUtil.mapToBean(
		    new OASitedesign(), (Map)list.get(0));
	    
	} catch (SQLException e) {
	    logger.error("ERROR:[SitedesignDao] SQL Query  Failure!" + 
		    e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[SitedesignDao] ResultSet To List Failure!" +
		    e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return info;
    }

}

