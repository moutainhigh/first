
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OATrainLeave;
import com.deppon.montal.model.OATrainLeaveDetail;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: DisCountApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(培训请假数据处理) 
 * @author 廖建雄 
 * @date 2013-7-16 下午3:23:50 
 * @version V1.0 
 */
public class OATrainLeaveDao implements IOATrainLeaveDao {
    
    private static Logger logger = Logger.getLogger(OATrainLeaveDao.class);
    private static String QUERY_OA_TRAINLEAVE_INFO = "" +
    		"SELECT OA.*, " +
    		"(" +
    		" SELECT D.DICTNAME FROM EOS_DICT_ENTRY D " +
    		"  WHERE D.DICTTYPEID = 'DIP_DEPT_PROPERTY' AND D.DICTID = OA.DEPTPROPERTY" +
    		")DEPTPROPERTY, " +
    		"(" +
    		"SELECT D.DICTNAME FROM EOS_DICT_ENTRY D " +
    		"  WHERE D.DICTTYPEID = 'OA_PERSONAL' AND D.DICTID = OA.AREA" +
    		")AREA  " +
    		"FROM OA_TRAINLEAVE OA " +
    		"WHERE OA.PROCESSINSTID = ? ";
    
    private static String QUERY_OA_TRAINLEAVE_DTL_INFO = "" +
		"SELECT * " +
		"FROM OA_TRAINLEAVE_DTL  " +
		"WHERE PROCESSINSTID = ? ";

    @Override
    public OATrainLeave getTrainLeave(String processinstid) {
	String sql = QUERY_OA_TRAINLEAVE_INFO;
	Object[] params = {processinstid};
	OATrainLeave info = new OATrainLeave();
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
	    info = (OATrainLeave) ConvertPojoUtil.mapToBean(
		    new OATrainLeave(), (Map)list.get(0));
	    
	} catch (SQLException e) {
	    logger.error("ERROR:[OATrainLeaveDao getTrainLeave] SQL Query  Failure!" + 
		    e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[OATrainLeaveDao getTrainLeave] ResultSet To List Failure!" +
		    e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return info;
    }
    @Override
    public List<OATrainLeaveDetail> getOaTrainLeaveDetails(String processinstid){
	String sql = QUERY_OA_TRAINLEAVE_DTL_INFO;
	Object[] params = {processinstid};
	List<OATrainLeaveDetail> detailList = new ArrayList<OATrainLeaveDetail>();
	ResultSet rs = null;
	Connection conn = ConnectionManager.getConnection();
	
	try {
	    //查询数据库
	    rs = ConnectionManager.query(conn, sql, params);
	    //将rs 转换为list
	    List list = ConvertPojoUtil.resultSetToList(rs); 
	    
	    for (Object object : list) {
		
		//映射pojo
		 OATrainLeaveDetail info = (OATrainLeaveDetail) ConvertPojoUtil.mapToBean(
			    new OATrainLeaveDetail(), (Map)object);
		 detailList.add(info);
	    }
	    
	} catch (SQLException e) {
	    logger.error("ERROR:[OATrainLeaveDao getOaTrainLeaveDetails] SQL Query  Failure!" + 
		    e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[OATrainLeaveDao getOaTrainLeaveDetails] ResultSet To List Failure!" +
		    e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return detailList;
    }

}

