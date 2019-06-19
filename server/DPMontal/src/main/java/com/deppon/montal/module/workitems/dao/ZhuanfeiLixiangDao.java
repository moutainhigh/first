
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.CCZhuanfeiLixiang;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: ZhuanfeiLixiangDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (专项费用立项申请工作流数据操作) 
 * @author 廖建雄 
 * @date 2013-6-20 上午10:43:50 
 * @version V1.0 
 */
public class ZhuanfeiLixiangDao implements IZhuanfeiLixiangDao {
    
    private static Logger logger = Logger.getLogger(ZhuanfeiLixiangDao.class);
    private static String QUERY_CC_ZHUANFEILIXIANG_INFO ="" +
    		"SELECT *　FROM CC_ZHUANFEILIXIANG WHERE PROCESSINSTID = ?";
    @Override
    public CCZhuanfeiLixiang getLixiangInfo(String processinstid) {
	String sql = QUERY_CC_ZHUANFEILIXIANG_INFO;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	
	CCZhuanfeiLixiang info = new CCZhuanfeiLixiang();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    //将rs转换为List
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    if(resultList.size() == 0) 
		return info;
	    //映射pojo
	    info = (CCZhuanfeiLixiang) ConvertPojoUtil.mapToBean(new CCZhuanfeiLixiang(), 
		    (Map)resultList.get(0));
	} catch (SQLException e) {
	    logger.error("ERROR:[ZhuanfeiLixiangDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[ZhuanfeiLixiangDao] rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	  return info;
    }
}

