
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OABusinessBaddebtbill;
import com.deppon.montal.model.OABusinessBaddebtleaf;
import com.deppon.montal.model.OABusinessBaddebts;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: OABusinessBaddebtsDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(业务类坏账申请工作流数据处理) 
 * @author 廖建雄 
 * @date 2013-8-5 下午2:07:53 
 * @version V1.0 
 */
public class OABusinessBaddebtsDao implements IOABusinessBaddebtsDao {
    
    private static Logger logger = Logger.getLogger(OABusinessBaddebtsDao.class);
    private static String QUERY_OA_BUSINESS_BADDEBTS_INFO = "" +
    		"SELECT OA.*, " +
    		"(" +
    		" SELECT D.DICTNAME FROM EOS_DICT_ENTRY D " +
    		"  WHERE D.DICTTYPEID = 'DIP_BALANCEMETHOD' AND D.DICTID = OA.BALANCEMETHOD" +
    		")BALANCEMETHOD " +
    		"FROM OA_BUSINESS_BADDEBTS OA " +
    		"WHERE OA.PROCESSINSTID = ? ";
    private static String QUERY_OA_BUSINESS_BADDEBTBILL_INFO = "" +
	    "SELECT * FROM OA_BUSINESS_BADDEBTBILL OA WHERE OA.PROCESSINSTID = ? ";
    private static String QUERY_OA_BUSINESS_BADDEBTLEAF_INFO = "" +
	    "SELECT * FROM OA_BUSINESS_BADDEBTLEAF OA WHERE OA.PROCESSINSTID = ? ";

    @Override
    public OABusinessBaddebts getBusinessBaddebts(String processinstid) {
	String sql = QUERY_OA_BUSINESS_BADDEBTS_INFO;
	Object[] params = {processinstid};
	OABusinessBaddebts info = new OABusinessBaddebts();
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
	    info = (OABusinessBaddebts) ConvertPojoUtil.mapToBean(
		    new OABusinessBaddebts(), (Map)list.get(0));
	    
	} catch (SQLException e) {
	    logger.error("ERROR:[OABusinessBaddebtsDao getBusinessBaddebts] SQL Query  Failure!" + 
		    e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[OABusinessBaddebtsDao getBusinessBaddebts] ResultSet To List Failure!" +
		    e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return info;
    }
    
    
    @Override
    public List<OABusinessBaddebtbill> getBaddebtbills(String processinstid) {
	String sql = QUERY_OA_BUSINESS_BADDEBTBILL_INFO;
	Object[] params = {processinstid};
	List<OABusinessBaddebtbill> baddebtbills = new ArrayList<OABusinessBaddebtbill>();
	ResultSet rs = null;
	Connection conn = ConnectionManager.getConnection();
	
	try {
	    //查询数据库
	    rs = ConnectionManager.query(conn, sql, params);
	    //将rs 转换为list
	    List list = ConvertPojoUtil.resultSetToList(rs); 
	    for (Object object : list) {
		  //映射pojo
		OABusinessBaddebtbill  info = (OABusinessBaddebtbill) ConvertPojoUtil.mapToBean(
			    new OABusinessBaddebtbill(), (Map)object);
		
		baddebtbills.add(info);
	    }
	    
	} catch (SQLException e) {
	    logger.error("ERROR:[OABusinessBaddebtsDao getBaddebtbills] SQL Query  Failure!" + 
		    e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[OABusinessBaddebtsDao getBaddebtbills] ResultSet To List Failure!" +
		    e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return baddebtbills;
    }
    
    
    @Override
    public List<OABusinessBaddebtleaf> getBaddebtleafs(String processinstid) {
	String sql = QUERY_OA_BUSINESS_BADDEBTLEAF_INFO;
	Object[] params = {processinstid};
	List<OABusinessBaddebtleaf> baddebtleafs = new ArrayList<OABusinessBaddebtleaf>();
	ResultSet rs = null;
	Connection conn = ConnectionManager.getConnection();
	
	try {
	    //查询数据库
	    rs = ConnectionManager.query(conn, sql, params);
	    //将rs 转换为list
	    List list = ConvertPojoUtil.resultSetToList(rs); 
	    
	    for (Object object : list) {
		    //映射pojo
		    OABusinessBaddebtleaf info = (OABusinessBaddebtleaf) ConvertPojoUtil.mapToBean(
			    new OABusinessBaddebtleaf(), (Map)object);
		    baddebtleafs.add(info);
	    }
	    
	} catch (SQLException e) {
	    logger.error("ERROR:[OABusinessBaddebtsDao getBaddebtleafs] SQL Query  Failure!" + 
		    e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[OABusinessBaddebtsDao getBaddebtleafs] ResultSet To List Failure!" +
		    e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return baddebtleafs;
    }

}

