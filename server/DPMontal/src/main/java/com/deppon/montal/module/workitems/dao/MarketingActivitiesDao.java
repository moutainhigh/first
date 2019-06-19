
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OAMarketingActivities;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: MarketingActivitiesDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(营销活动申请工作流数据处理) 
 * @author 廖建雄 
 * @date 2013-7-16 下午3:23:50 
 * @version V1.0 
 */
public class MarketingActivitiesDao implements IMarketingActivitiesDao {
    
    private static Logger logger = Logger.getLogger(MarketingActivitiesDao.class);
    private static String QUERY_OA_MARKETINGACTIVITIES_INFO = "" +
    		"SELECT M.*, " +
    		"(" +
    		" SELECT D.DICTNAME FROM EOS_DICT_ENTRY D " +
    		"  WHERE D.DICTTYPEID = 'DIP_DIVISION_NEW' AND D.DICTID = M.SUBORDINATEDIVISION" +
    		")SUBORDINATEDIVISION, " +
    		"(" +
    		" SELECT D.DICTNAME FROM EOS_DICT_ENTRY D " +
    		"  WHERE D.DICTTYPEID = 'ABF_MARKINGTYPE' AND D.DICTID = M.MARKETINGSUBORDINATETYPE" +
    		")MARKINGTYPE, " +
    		"(" +
    		" SELECT D.DICTNAME FROM EOS_DICT_ENTRY D " +
    		"  WHERE D.DICTTYPEID = 'DIP_IFVALID' AND D.DICTID = M.ISREDO" +
    		")ISREDO, " +
    		"(" +
    		" SELECT D.DICTNAME FROM EOS_DICT_ENTRY D " +
    		"  WHERE D.DICTTYPEID = 'ABF_PUBLICITY' AND D.DICTID = M.PROPAGANDALINETYPE" +
    		")PROPAGANDALINETYPE, " +
    		"(" +
    		" SELECT D.DICTNAME FROM EOS_DICT_ENTRY D " +
    		"  WHERE D.DICTTYPEID = 'ABF_PROPAGANDABUSTYPE' AND D.DICTID = M.PROPAGANDABUSTYPE" +
    		")PROPAGANDABUSTYPE, " +
    		"(" +
    		" SELECT D.DICTNAME FROM EOS_DICT_ENTRY D " +
    		"  WHERE D.DICTTYPEID = 'ABF_PROPAGANDAINDUSTRYTYPE' AND D.DICTID = M.PROPAGANDAINDUSTRYTYPE" +
    		")PROPAGANDAINDUSTRYTYPE, " +
    		"(" +
    		" SELECT D.DICTNAME FROM EOS_DICT_ENTRY D " +
    		"  WHERE D.DICTTYPEID = 'ABF_PROPAGANDAAIRTYPE' AND D.DICTID = M.PROPAGANDAAIRTYPE" +
    		")PROPAGANDAAIRTYPE, " +
    		"(" +
    		"SELECT W.WORKITEMNAME FROM WFWORKITEM W " +
    		"WHERE (W.CURRENTSTATE = '10' OR  W.CURRENTSTATE = '4') AND W.PROCESSINSTID = M.PROCESSINSTID" +
    		")CURRENTNODE " +
    		"FROM OA_MARKETINGACTIVITIESAPPLY M " +
    		"WHERE M.PROCESSINSTID = ? ";

    @Override
    public OAMarketingActivities getMarketingActivitiesInfo(String processinstid) {
	String sql = QUERY_OA_MARKETINGACTIVITIES_INFO;
	Object[] params = {processinstid};
	OAMarketingActivities info = new OAMarketingActivities();
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
	    info = (OAMarketingActivities) ConvertPojoUtil.mapToBean(
		    new OAMarketingActivities(), (Map)list.get(0));
	    
	} catch (SQLException e) {
	    logger.error("ERROR:[MarketingActivitiesDao] SQL Query  Failure!" + 
		    e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[MarketingActivitiesDao] ResultSet To List Failure!" +
		    e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return info;
    }

}

